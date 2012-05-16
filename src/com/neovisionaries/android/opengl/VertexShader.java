/*
 * Copyright (C) 2012 Neo Visionaries Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.neovisionaries.android.opengl;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;


/**
 * OpenGL ES vertex shader.
 *
 * @author Takahiko Kawasaki
 */
public class VertexShader extends Shader<VertexShader>
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


    /**
     * A constructor with an input stream that feeds a shader
     * source code. {@link Shader#Shader(ShaderType, InputStream)
     * super}({@link ShaderType#VERTEX}, in) is called. After this
     * constructor returns, the state of this instance is {@link
     * ShaderState#SOURCE_SET}.
     *
     * @param in
     *         An input stream that feeds a shader source code.
     *
     * @throws IllegalArgumentException
     *         The argument is null.
     *
     * @throws IOException
     *         Failed to read the content of the input stream.
     *
     * @throws GLESException
     *         glCreateShader() failed.
     *
     * @see Shader#Shader(ShaderType, InputStream)
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glShaderSource.xml">glShaderSource</a>
     */
    public VertexShader(InputStream in) throws IOException, GLESException
    {
        super(ShaderType.VERTEX, in);
    }


    /**
     * A constructor with an input stream that feeds a shader
     * source code. {@link Shader#Shader(ShaderType, InputStream,
     * boolean) super}({@link ShaderType#VERTEX}, in, close) is
     * called. After this constructor returns, the state of this
     * instance is {@link ShaderState#SOURCE_SET}.
     *
     * @param in
     *         An input stream that feeds a shader source code.
     *
     * @param close
     *         If true is given, the input stream is closed before
     *         this method returns.
     *
     * @throws IllegalArgumentException
     *         The argument is null.
     *
     * @throws IOException
     *         Failed to read the content of the input stream.
     *
     * @throws GLESException
     *         glCreateShader() failed.
     *
     * @see Shader#Shader(ShaderType, InputStream, boolean)
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glShaderSource.xml">glShaderSource</a>
     */
    public VertexShader(InputStream in, boolean close) throws IOException, GLESException
    {
        super(ShaderType.VERTEX, in, close);
    }
}
