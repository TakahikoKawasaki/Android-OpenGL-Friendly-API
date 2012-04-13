/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import android.opengl.GLES20;
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
 * Shader shader = new {@link VertexShader}();
 * <span style="color: darkgreen;">//Shader shader = new {@link FragmentShader}();</span>
 *
 * <span style="color: darkgreen;">// Set a shader source code.</span> 
 * String shaderSource = <span style="color: brown;">"......"</span>;
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
 * Shader shader = new {@link VertexShader}(<span style="color: brown;">"......"</span>).{@link #compile() compile}();
 * </pre>
 *
 * @author Takahiko Kawasaki
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
     * A constructor with a shader ID. The state of this instance
     * is set up according to the state of the given shader.
     *
     * <p>
     * Use this constructor only if you already have a shader ID
     * that has been assigned by glCreateShader(). Otherwise,
     * use {@link VertexShader} or {@link FragmentShader}.
     * </p>
     *
     * @param id
     *         A return value from glCreateShader().
     *
     * @throws IllegalArgumentException
     *         The given number is not a shader ID.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     */
    public Shader(int id)
    {
        // Check if the given ID is a shader ID.
        if (GLES20.glIsShader(id) == false)
        {
            // The given integer is not a shader ID.
            throw new IllegalArgumentException("Not a shader.");
        }

        // Shader ID
        this.id = id;

        // Check if the shader is marked as deleted.
        if (getDeleteStatus())
        {
            // The given shader has already been deleted.
            state = DELETED;
        }
        // Check the compilation status of the shader.
        else if (getCompileStatus())
        {
            // The shader has already been compiled.
            state = COMPILED;
        }
        else
        {
            state = CREATED;
        }
    }


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
        id = GLES20.glCreateShader(type.getType());

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
        GLES20.glShaderSource(id, source);

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
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glDeleteShader.xml">glDeleteShader</a>
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
        GLES20.glDeleteShader(id);

        // This shader was deleted.
        state = DELETED;
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
        GLES20.glShaderSource(id, source);

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
     *         Failed to compile the source (glCompileShader() failed).
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
                throw new IllegalArgumentException("Shader has already been deleted.");
        }

        // Compile the source code.
        GLES20.glCompileShader(id);

        // Check if the source code has been compiled successfully.
        if (getCompileStatus() == false)
        {
            // Failed to compile the shader source.
            throw new GLESException(getLog());
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
        int[] status = new int[1];

        // Get the result of compilation.
        GLES20.glGetShaderiv(id, GLES20.GL_COMPILE_STATUS, status, 0);

        // GL_TRUE is returned if the compilation has succeeded.
        return (status[0] == GLES20.GL_TRUE);
    }


    /**
     * Check the deletion status.
     *
     * @return True if this shader is marked as deleted.
     */
    private boolean getDeleteStatus()
    {
        int[] status = new int[1];

        // Get the deletion status.
        GLES20.glGetShaderiv(id, GLES20.GL_DELETE_STATUS, status, 0);

        // GL_TRUE is returned if this shader is marked as deleted.
        return (status[0] == GLES20.GL_TRUE);
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
        return GLES20.glGetShaderInfoLog(id);
    }


    /**
     * Tell the GLES implementation that resources used by the shader
     * compiler can be released.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man4/xhtml/glReleaseShaderCompiler.xml">glReleaseShaderCompiler</a>
     */
    public static void releaseCompiler()
    {
        GLES20.glReleaseShaderCompiler();
    }
}
