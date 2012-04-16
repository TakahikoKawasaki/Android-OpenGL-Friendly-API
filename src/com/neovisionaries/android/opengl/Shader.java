/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import java.util.LinkedList;
import java.util.List;
import static com.neovisionaries.android.opengl.ShaderState.COMPILED;
import static com.neovisionaries.android.opengl.ShaderState.CREATED;
import static com.neovisionaries.android.opengl.ShaderState.DELETED;
import static com.neovisionaries.android.opengl.ShaderState.SOURCE_SET;


/**
 * OpenGL shader.
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E   1</b></span>
 *
 * <span style="color: darkgreen;">// Create a shader.</span>
 * {@link Shader} shader = new {@link VertexShader}();
 * <span style="color: darkgreen;">//Shader shader = new {@link FragmentShader}();</span>
 *
 * <span style="color: darkgreen;">// Set a shader source code.</span> 
 * String shaderSource = <span style="color: brown;">"..."</span>;
 * shader.{@link #setSource(String) setSource}(shaderSource);
 *
 * <span style="color: darkgreen;">// Compile the shader source code.</span>
 * shader.{@link #compile() compile}();
 * </pre>
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E   2</b></span>
 *
 * <span style="color: darkgreen;">// Just one line.</span>
 * {@link Shader} shader = new {@link VertexShader}(<span style="color: brown;">"..."</span>).{@link #compile() compile}();
 * </pre>
 *
 * @author Takahiko Kawasaki
 *
 * @see Program
 */
public class Shader
{
    /**
     * Shader ID. A return value from glCreateShader().
     */
    private final int id;


    /**
     * State of this shader.
     */
    private ShaderState state = CREATED;


    /**
     * Programs that this shader is attached to.
     */
    private List<Program> programList = new LinkedList<Program>();


    /**
     * A constructor with a shader type. After this constructor
     * returns, the state of this instance is {@link ShaderState#CREATED}.
     *
     * @param type
     *         {@link ShaderType#VERTEX} or {@link ShaderType#FRAGMENT}.
     *
     * @throws IllegalArgumentException
     *         The given argument is null.
     *
     * @throws GLESException
     *         glCreateShader() failed.
     *
     * @see VertexShader#VertexShader()
     * @see FragmentShader#FragmentShader()
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     */
    protected Shader(ShaderType type) throws GLESException
    {
        // Check the argument.
        if (type == null)
        {
            // The argument is invalid.
            throw new IllegalArgumentException("Shader type is null.");
        }

        // Create a shader of the given type.
        id = getGLES().glCreateShader(type.getType());

        // Check the result of glCreateShader().
        if (id == 0)
        {
            // Failed to create a shader.
            throw new GLESException("glCreateShader() failed.");
        }
    }


    /**
     * A constructor with a shader type and a shader source.
     * After this constructor returns, the state of this instance
     * is {@link ShaderState#SOURCE_SET}.
     *
     * @param type
     *         {@link ShaderType#VERTEX} or {@link ShaderType#FRAGMENT}.
     *
     * @param source
     *         A shader source code.
     *
     * @throws IllegalArgumentException
     *         The given shader source is null.
     *
     * @throws GLESException
     *         glCreateShader() failed.
     *
     * @see VertexShader#VertexShader(String)
     * @see FragmentShader#FragmentShader(String)
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glShaderSource.xml">glShaderSource</a>
     */
    protected Shader(ShaderType type, String source) throws GLESException
    {
        this(type);

        // Check the argument.
        if (source == null)
        {
            // The argument is invalid.
            throw new IllegalArgumentException("Shader source is null.");
        }

        // Set the given string as a shader source code.
        getGLES().glShaderSource(id, source);

        // A shader source was set.
        state = SOURCE_SET;
    }


    /**
     * Get the shader ID which is a return value from glCreateShader().
     *
     * @return
     *         The shader ID assigned to this shader.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     */
    public int getId()
    {
        return id;
    }


    /**
     * Get the state of this shader.
     *
     * @return
     *         The state of this shader.
     */
    public ShaderState getState()
    {
        return state;
    }


    /**
     * Delete this shader. If this shader has already been deleted,
     * nothing is executed. After this method returns, the state of
     * this instance is {@link ShaderState#DELETED}.
     *
     * <p>
     * Note that calling this method detaches this shader from all
     * the programs that this shader is currently attached to.
     * </p>
     *
     * <p>
     * If this shader is attached to a {@link Program} instance
     * whose setting of 'deleteShaderOnDelete' is true, delete()
     * method of this Shader instance is called automatically when
     * the {@link Program} instance is deleted.
     * </p>
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glDeleteShader.xml">glDeleteShader</a>
     * @see Program#setDeleteShadersOnDelete(boolean)
     */
    public void delete()
    {
        // Check the state of this shader.
        if (state == DELETED)
        {
            // Already deleted.
            return;
        }

        // Delete this shader.
        getGLES().glDeleteShader(id);

        // This shader was deleted.
        state = DELETED;

        // For each program that this shader is attached to.
        for (Program program : programList)
        {
            // Notify the program that this shader was deleted.
            program.onShaderDeleted(this);
        }

        // Not keep track of programs any more.
        programList.clear();
        programList = null;
    }


    /**
     * Set a shader source code. If this method returns without
     * any execption, the state of this instance is {@link
     * ShaderState#SOURCE_SET}.
     *
     * @param source
     *         A shader source code.
     *
     * @return
     *         This Shader object.
     *
     * @throws IllegalArgumentException
     *         The given argument is null.
     *
     * @throws IllegalStateException
     *         This shader has already been deleted.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glShaderSource.xml">glShaderSource</a>
     */
    public Shader setSource(String source)
    {
        // Check the argument.
        if (source == null)
        {
            // The argument is invalid.
            throw new IllegalArgumentException("Shader source is null.");
        }

        // Check the state of this shader.
        if (state == DELETED)
        {
            // Already deleted.
            throw new IllegalStateException("Shader has already been deleted.");
        }

        // Set the given string as a shader source code.
        getGLES().glShaderSource(id, source);

        // A shader source was set.
        state = SOURCE_SET;

        return this;
    }


    /**
     * Compile the source code given by {@link #setSource(String)}.
     * If the current state of this shader is {@link
     * ShaderState#COMPILED COMPILED}, nothing is executed.
     * If this method returns without any exception, the state of
     * this instance is {@link ShaderState#COMPILED}.
     *
     * @return
     *         This Shader object.
     *
     * @throws IllegalStateException
     *         No shader source is set, or this shader has already
     *         been deleted.
     *
     * @throws GLESException
     *         glCompileShader() failed.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glCompileShader.xml">glCompileShader</a>
     */
    public Shader compile() throws GLESException
    {
        switch (state)
        {
            case CREATED:
                // Shader source is not set.
                throw new IllegalStateException("Shader source is not set.");

            case COMPILED:
                // Already compiled.
                return this;

            case DELETED:
                // Already deleted.
                throw new IllegalStateException("Shader has already been deleted.");
        }

        // Compile the source code.
        getGLES().glCompileShader(id);

        // Check if the source code has been compiled successfully.
        if (getCompileStatus() == false)
        {
            // Failed to compile the shader source.
            throw new GLESException("glCompileShader() failed: " + getLog());
        }

        // Compiled successfully.
        state = COMPILED;

        return this;
    }


    /**
     * Check the compilation status.
     *
     * @return True if the status indicates that compilation
     *          has succeeded.
     */
    private boolean getCompileStatus()
    {
        GLES gles = getGLES();

        int[] status = new int[1];

        // Get the result of compilation.
        gles.glGetShaderiv(id, gles.GL_COMPILE_STATUS(), status, 0);

        // GL_TRUE is returned if the compilation has succeeded.
        return (status[0] == gles.GL_TRUE());
    }


    /**
     * Get the shader information log.
     *
     * @return
     *         A log text.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glGetShaderInfoLog.xml">glGetShaderInfoLog</a>
     */
    private String getLog()
    {
        return getGLES().glGetShaderInfoLog(id);
    }


    /**
     * Tell the GLES implementation that resources used by the shader
     * compiler can be released.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man4/xhtml/glReleaseShaderCompiler.xml">glReleaseShaderCompiler</a>
     */
    public static void releaseCompiler()
    {
        getGLES().glReleaseShaderCompiler();
    }


    /**
     * This method is called when this shader was attached
     * to a {@link Program}.
     *
     * @param program
     *         A {@link Program} that this shader was attached to.
     */
    void onAttached(Program program)
    {
        if (programList != null)
        {
            programList.add(program);
        }
    }


    /**
     * This method is called when this shader was detached
     * from a {@link Program}.
     *
     * @param program
     *         A {@link Program} that this shader was detached from.
     */
    void onDetached(Program program)
    {
        if (programList != null)
        {
            programList.remove(program);
        }
    }


    /**
     * Get an implementation of GLES interface.
     *
     * @return
     *         An object implementing GLES interface.
     */
    private static GLES getGLES()
    {
        return GLESFactory.getInstance();
    }
}
