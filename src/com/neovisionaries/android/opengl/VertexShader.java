/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import java.io.File;
import java.io.IOException;


/**
 * OpenGL ES vertex shader.
 *
 * @author Takahiko Kawasaki
 */
public class VertexShader extends Shader
{
    /**
     * A constructor. {@link Shader#Shader(ShaderType)
     * super}({@link ShaderType#VERTEX}) is called.
     * After this constructor returns, the state of
     * this instance is {@link ShaderState#CREATED}.
     *
     * @throws GLESException
     *         glCreateShader() failed.
     *
     * @see Shader#Shader(ShaderType)
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     */
    public VertexShader() throws GLESException
    {
        super(ShaderType.VERTEX);
    }


    /**
     * A constructor with a shader source. {@link
     * Shader#Shader(ShaderType, String) super}({@link
     * ShaderType#VERTEX}, source) is called. After
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
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glShaderSource.xml">glShaderSource</a>
     */
    public VertexShader(String source) throws GLESException
    {
        super(ShaderType.VERTEX, source);
    }


    /**
     * A constructor with a shader source file. {@link
     * Shader#Shader(ShaderType, File) super}({@link
     * ShaderType#VERTEX}, file) is called. After
     * this constructor returns, the state of this
     * instance is {@link ShaderState#SOURCE_SET}.
     *
     * @param file
     *         A file whose content is a shader source code.
     *
     * @throws IllegalArgumentException
     *         The argument is null.
     *
     * @throws IOException
     *         Failed to read the content of the given file.
     *
     * @throws GLESException
     *         glCreateShader() failed.
     *
     * @see Shader#Shader(ShaderType, File)
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glShaderSource.xml">glShaderSource</a>
     */
    public VertexShader(File file) throws IOException, GLESException
    {
        super(ShaderType.VERTEX, file);
    }
}
