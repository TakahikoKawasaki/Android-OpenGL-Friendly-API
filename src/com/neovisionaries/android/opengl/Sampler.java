/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * A class to manipulate a uniform sampler variable in OpenGL Shader Language.
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E</b></span>
 *
 * <span style="color: darkgreen;">// Get a program from somewhere.</span>
 * {@link Program} program = ...;
 *
 * <span style="color: darkgreen;">// Get an accessor to a uniform sampler variable.</span>
 * {@link Sampler} s_texture = program.{@link Program#getSampler(String) getSampler}("s_texture");
 *
 * <span style="color: darkgreen;">// Get a texture from somewhere.</span>
 * {@link Texture}&lt;?&gt; texture = ...;
 *
 * <span style="color: darkgreen;">// Set the texture to the uniform sampler variable.</span>
 * s_texture.{@link #set(Texture) set}(texture);
 * </pre>
 *
 * @author Takahiko Kawasaki
 */
public class Sampler
{
    /**
     * Location of this uniform sampler variable;
     */
    private final int location;


    /**
     * A constructor.
     *
     * @param program
     * @param name
     *
     * @throws IllegalArgumentException
     *         Either or both of the arguments are null.
     *
     * @throws GLESException
     *         There is no such a uniform variable having the specified name.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniformLocation.xml">glGetUniformLocation</a>
     * @see Program#getSampler(String)
     */
    public Sampler(Program program, String name) throws GLESException
    {
        // Check the arguments.
        if (program == null || name == null)
        {
            throw new IllegalArgumentException();
        }

        // Get the location of the uniform having the specified name.
        location = GLESFactory.getInstance().glGetUniformLocation(program.getId(), name);

        if (location == -1)
        {
            // No uniform having the name.
            throw new GLESException("No such a uniform variable having the name: " + name);
        }
    }


    /**
     * Get the location of this uniform sampler variable.
     *
     * @return The location of this uniform sampler variable
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniformLocation.xml">glGetUniformLocation</a>
     */
    public int getLocation()
    {
        return location;
    }


    /**
     * Set a texture to this uniform sampler variable.
     *
     * <p>
     * This method does the same thing as glUniformli({@link
     * #getLocation()}, texture.{@link Texture#getTextureUnit()
     * getTextureUnit()}).
     * </p>
     *
     * @param texture
     *         A texture to set to this uniform sampler variable.
     *
     * @return
     *         This Sampler object.
     *
     * @throws IllegalArgumentException
     *         The argumenet is null.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1i</a>
     */
    public Sampler set(Texture<?> texture)
    {
        if (texture == null)
        {
            throw new IllegalArgumentException();
        }

        // Set the number of the texture unit to the
        // uniform sampler variable.
        GLESFactory.getInstance().glUniform1i(location, texture.getTextureUnit());

        return this;
    }
}
