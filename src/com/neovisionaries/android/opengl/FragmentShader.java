/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL fragment shader.
 *
 * @author Takahiko Kawasaki
 */
public class FragmentShader extends Shader
{
    /**
     * A constructor. {@link Shader#Shader(ShaderType)
     * super}({@link ShaderType#FRAGMENT}) is called.
     * After this constructor returns, the state of
     * this instance is {@link ShaderState#CREATED}.
     *
     * @throws GLESException
     *         glCreateShader() failed.
     *
     * @see Shader#Shader(ShaderType)
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     */
    public FragmentShader() throws GLESException
    {
        super(ShaderType.FRAGMENT);
    }


    /**
     * A constructor with a shader source. {@link
     * Shader#Shader(ShaderType, String) super}({@link
     * ShaderType#FRAGMENT}, source) is called. After
     * this constructor returns, the state of this
     * instance is {@link ShaderState#SOURCE_SET}.
     *
     * @param source
     *         A shader source code.
     *
     * @throws IllegalArgumentException
     *         The argument is null.
     *
     * @throws GLESException
     *         glCreateShader() failed.
     *
     * @see Shader#Shader(ShaderType, String)
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glShaderSource.xml">glShaderSource</a>
     */
    public FragmentShader(String source) throws GLESException
    {
        super(ShaderType.FRAGMENT, source);
    }
}
