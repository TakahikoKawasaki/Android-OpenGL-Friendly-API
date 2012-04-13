/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL vertex shader.
 *
 * @author Takahiko Kawasaki
 */
public class VertexShader extends Shader
{
    /**
     * A constructor. After this constructor returns,
     * the state of this instance is {@link ShaderState#CREATED}.
     *
     * @throws GLESException
     *         glCreateShader() failed.
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     */
    public VertexShader() throws GLESException
    {
        super(ShaderType.VERTEX);
    }


    /**
     * A constructor with a shader source. After this constructor
     * returns, the state of this instance is {@link ShaderState#SOURCE_SET}.
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
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glShaderSource.xml">glShaderSource</a>
     */
    public VertexShader(String source) throws GLESException
    {
        super(ShaderType.VERTEX, source);
    }
}
