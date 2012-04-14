/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import java.util.HashMap;
import java.util.Map;
import android.opengl.GLES20;
import static com.neovisionaries.android.opengl.ProgramState.NEEDS_LINKING;
import static com.neovisionaries.android.opengl.ProgramState.DELETED;
import static com.neovisionaries.android.opengl.ProgramState.LINKED;


/**
 * OpenGL Shader Program.
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E   1</b></span>
 *
 * <span style="color: darkgreen;">// Create a program.</span>
 * {@link Program} program = new {@link #Program(Shader...) Program}();
 *
 * <span style="color: darkgreen;">// Attach a vertex shader.</span> 
 * {@link VertexShader} vShader = new {@link VertexShader#VertexShader(String)
 * VertexShader}(<span style="color: brown;">"..."</span>).{@link
 * Shader#compile() compile}();
 * program.{@link #attach(Shader) attach}(vShader);
 *
 * <span style="color: darkgreen;">// Attach a fragment shader.</span> 
 * {@link FragmentShader} fShader = new {@link FragmentShader#FragmentShader(String)
 * FragmentShader}(<span style="color: brown;">"..."</span>).{@link
 * Shader#compile() compile}();
 * program.{@link #attach(Shader) attach}(fShader);
 *
 * <span style="color: darkgreen;">// Link the shaders.</span>
 * program.{@link #link() link}();
 *
 * <span style="color: darkgreen;">// Use the program.</span>
 * program.{@link #use() use}();
 *
 * <span style="color: darkgreen;">// Delete the program.</span>
 * program.{@link #delete() delete}();
 * </pre>
 *
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E   2</b></span>
 *
 * <span style="color: darkgreen;">// Create a program with shaders.</span>
 * {@link Program} program = new {@link #Program(Shader...) Program}(new {@link
 * VertexShader#VertexShader(String) VertexShader}(<span style="color: brown;">"..."</span>), new {@link
 * FragmentShader#FragmentShader(String) FragmentShader}(<span style="color: brown;">"..."</span>));
 *
 * <span style="color: darkgreen;">// Use the program. Compiling and linking are performed automatically.</span>
 * program.{@link #use() use}();
 *
 * <span style="color: darkgreen;">// Delete the program.</span>
 * program.{@link #delete() delete}();
 * </pre>
 *
 * @author Takahiko Kawasaki
 *
 * @see Shader
 */
public class Program
{
    /**
     * Program ID. A return value from glCreateProgram().
     */
    private final int id;


    /**
     * State of this program.
     */
    private ProgramState state = NEEDS_LINKING;


    /**
     * Attached shaders.
     */
    private Map<Integer, Shader> shaderMap = new HashMap<Integer, Shader>();


    /**
     * A constructor. After this constructor returns, the state
     * of this instance is {@link ProgramState#NEEDS_LINKING
     * NEEDS_LINKING}.
     *
     * @param shaders
     *         Shaders to attach to this program. Shaders can
     *         be attached also by {@link #attach(Shader)} later.
     *         Shaders that have already been deleted are not
     *         attached even if they appear in the given list.
     *
     * @throws GLESException
     *        glCreateProgram() failed. 
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glCreateProgram.xml">glCreateProgram</a>
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glAttachShader.xml">glAttachShader</a>
     */
    public Program(Shader... shaders) throws GLESException
    {
        // Create a program.
        id = GLES20.glCreateProgram();

        // Check the result of glCreateProgram().
        if (id == 0)
        {
            // Failed to create a program.
            throw new GLESException("glCreateProgram() failed.");
        }

        // For each shader given to this constructor.
        for (Shader shader : shaders)
        {
            if (shader == null || shader.getState() == ShaderState.DELETED)
            {
                continue;
            }

            // Attach the shader to this program.
            attachInternal(shader);
        }
    }


    /**
     * Get the program ID which is a return value from glCreateProgram().
     *
     * @return
     *         The program ID assigned to this program.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glCreateProgram.xml">glCreateProgram</a>
     */
    public int getId()
    {
        return id;
    }


    /**
     * Get the state of this program.
     *
     * @return
     *         The state of this program.
     */
    public ProgramState getState()
    {
        return state;
    }


    /**
     * Delete this program. If this program has already been deleted,
     * nothing is executed. After this method returns, the state of
     * this instance is {@link ProgramState#DELETED DELETED}.
     *
     * <p>
     * Attached shaders, if any, are detached from this program
     * explicitly before this method returns.
     * </p>
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glDeleteProgram.xml">glDeleteProgram</a>
     */
    public void delete()
    {
        // Check the state of this program.
        if (state == DELETED)
        {
            // Already deleted.
            return;
        }

        // Detach all the shaders.
        for (Shader shader : shaderMap.values())
        {
            // Detach the shader from this program.
            GLES20.glDetachShader(id,  shader.getId());
        }

        // Not keep track of shaders any more.
        shaderMap.clear();
        shaderMap = null;

        // Delete this program.
        GLES20.glDeleteProgram(id);

        // This program was deleted.
        state = DELETED;
    }


    /**
     * Attach a shader to this program. If this method returns without
     * any exception, the state of this program is {@link
     * ProgramState#NEEDS_LINKING NEEDS_LINKING}.
     *
     * @param shader
     *         A shader to attach to this program.
     *
     * @return
     *         This Program object.
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>The given shader is null.
     * <li>The given shader has already been deleted.
     * <li>The given shader has already been attached to this program.
     * </ul>
     *
     * @throws IllegalStateException
     *         This program has already been deleted.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glAttachShader.xml">glAttachShader</a>
     */
    public Program attach(Shader shader)
    {
        // Check the argument.
        if (shader == null || shader.getState() == ShaderState.DELETED)
        {
            // The argument is invalid.
            throw new IllegalArgumentException("Shader is null.");
        }

        // Check the state of this program.
        if (state == DELETED)
        {
            throw new IllegalStateException("Program has already been deleted.");
        }

        // Check if the shader has already been attached.
        if (shaderMap.containsKey(shader.getId()))
        {
            throw new IllegalArgumentException("Shader has already been attached.");
        }

        // Attach the shader to this program.
        attachInternal(shader);

        return this;
    }


    private void attachInternal(Shader shader)
    {
        // Attach the shader to this program.
        GLES20.glAttachShader(id, shader.getId());

        // The shader was attached.
        shaderMap.put(shader.getId(), shader);

        // This program needs linking.
        state = NEEDS_LINKING;

        // Notify the shader that it was attached to this program.
        shader.onAttached(this);
    }


    /**
     * Detach a shader from this program. If this method returns
     * without any exception, the state of this program is {@link
     * ProgramState#NEEDS_LINKING NEEDS_LINKING}.
     *
     * @return
     *         This Program object.
     *
     * @throws IllegalArgumentException
     *         The given argument is null, or the shader is not attached
     *         to this program.
     *
     * @throws IllegalStateException
     *         This program has already been deleted.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glDetachShader.xml">glDetachShader</a>
     */
    public Program detach(Shader shader)
    {
        // Check the argument.
        if (shader == null)
        {
            // The argument is invalid.
            throw new IllegalArgumentException("Shader is null.");
        }

        // Check the state of this program.
        if (state == DELETED)
        {
            throw new IllegalStateException("Program has already been deleted.");
        }

        // Check if the shader is attached to this program.
        if (shaderMap.containsKey(shader.getId()) == false)
        {
            // The shader is not attached to this program.
            throw new IllegalArgumentException("Shader is not attached.");
        }

        // Detach the shader from this program.
        detachInternal(shader);

        return this;
    }


    private void detachInternal(Shader shader)
    {
        // Detach the shader from this program.
        GLES20.glDetachShader(id, shader.getId());

        // The shader was detached.
        shaderMap.remove(shader.getId());

        // This program needs linking.
        state = NEEDS_LINKING;

        // Notify the shader that it was detached from this program.
        shader.onDetached(this);
    }


    /**
     * Link attached shaders. If the current state of this program is
     * {@link ProgramState#LINKED LINKED}, nothing is executed.
     * Before calling glLinkProgram(), shaders attached to this program
     * are compiled if they have not been compiled yet. If this method
     * returns without any exception, the state of this program is
     * {@link ProgramState#LINKED LINKED}.
     *
     * @return
     *         This Program object.
     *
     * @throws IllegalStateException
     * <ul>
     * <li>This program has already been deleted.
     * <li>Any source code is given to a shader that is attached to
     *     this program.
     * <li>A shader
     * </ul>
     *
     * @throws GLESException
     *         glLinkProgram() or glCompileShader() failed.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glLinkProgram.xml">glLinkProgram</a>
     */
    public Program link() throws GLESException
    {
        switch (state)
        {
            case LINKED:
                // Already linked.
                return this;

            case DELETED:
                // Already deleted.
                throw new IllegalStateException("Program has already been deleted.");
        }

        // Make sure that all shaders are compiled.
        for (Shader shader : shaderMap.values())
        {
            // Compile the shader. If the shader has already been
            // compiled, compile() does nothing. Note that compile()
            // may throw an exception.
            shader.compile();
        }

        // Link the attached shaders.
        GLES20.glLinkProgram(id);

        // Check if the shaders have been linked successfully.
        if (getLinkStatus() == false)
        {
            // Failed to link the shaders.
            throw new GLESException("glLinkProgram() failed: " + getLog());
        }

        // Linked successfully.
        state = LINKED;

        return this;
    }


    /**
     * Check the linking status.
     *
     * @return True if the status indicates that linking has succeeded.
     */
    private boolean getLinkStatus()
    {
        int[] status = new int[1];

        // Get the result of linking.
        GLES20.glGetProgramiv(id, GLES20.GL_LINK_STATUS, status, 0);

        // GL_TRUE is returned if the linking has succeeded.
        return (status[0] == GLES20.GL_TRUE);
    }


    /**
     * Get the program information log.
     *
     * @return
     *         A log text.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glGetProgramInfoLog.xml">glGetProgramInfoLog</a>
     */
    private String getLog()
    {
        return GLES20.glGetProgramInfoLog(id);
    }


    /**
     * Use this program. If this program has not been linked yet,
     * {@link #link()} is executed before calling glUseProgram().
     *
     * @return
     *         This Program object.
     *
     * @throws IllegalStateException
     *         This program has already been deleted.
     *
     * @throws GLESException
     *         Linking failed.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glUseProgram.xml">glUseProgram</a>
     */
    public Program use() throws GLESException
    {
        if (state != LINKED)
        {
            // Link.
            link();
        }

        // Use this program.
        GLES20.glUseProgram(id);

        return this;
    }


    /**
     * Call glUseProgram(0).
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glUseProgram.xml">glUseProgram</a>
     */
    public static void unuse()
    {
        GLES20.glUseProgram(0);
    }


    /**
     * Get a Uniform object.
     *
     * @param name
     *         A name of a uniform variable.
     *
     * @return
     *         A {@link Uniform} object to manipulate the uniform variable.
     *
     * @throws GLESException
     *         There is no such a uniform variable having the name.
     */
    public Uniform getUniform(String name) throws GLESException
    {
        return new Uniform(this, name);
    }


    /**
     * This method is called when a shader attached to this program
     * was deleted.
     *
     * @param shader
     *         A shader that was deleted.
     */
    void onShaderDeleted(Shader shader)
    {
        if (state == DELETED)
        {
            // This program has already been deleted.
            return;
        }

        // Detach the shader from this program.
        GLES20.glDetachShader(id, shader.getId());

        // The shader was detached.
        shaderMap.remove(shader.getId());

        // This program needs linking.
        state = NEEDS_LINKING;
    }
}
