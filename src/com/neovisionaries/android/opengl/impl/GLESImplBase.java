/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl.impl;


import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import com.neovisionaries.android.opengl.GLES;


/**
 * The base implementation of {@link GLES} interface.
 *
 * <ol>
 * <li>All gl* methods throw UnsupportedOperationException.
 * <li>All GL_* methods except {@link #GL_TRUE()} return 0.
 * <li>{@link #GL_TRUE()} return 1.
 * </ol>
 * 
 * @author Takahiko Kawasaki
 */
public abstract class GLESImplBase implements GLES
{
    protected GLESImplBase()
    {
    }


    @Override
    public int GL_ARRAY_BUFFER()
    {
        return 0;
    }


    @Override
    public int GL_BLEND()
    {
        return 0;
    }


    @Override
    public int GL_COLOR_BUFFER_BIT()
    {
        return 0;
    }


    @Override
    public int GL_COMPILE_STATUS()
    {
        return 0;
    }


    @Override
    public int GL_CULL_FACE()
    {
        return 0;
    }


    @Override
    public int GL_DEPTH_BUFFER_BIT()
    {
        return 0;
    }


    @Override
    public int GL_DEPTH_TEST()
    {
        return 0;
    }


    @Override
    public int GL_DITHER()
    {
        return 0;
    }


    @Override
    public int GL_DYNAMIC_DRAW()
    {
        return 0;
    }


    @Override
    public int GL_ELEMENT_ARRAY_BUFFER()
    {
        return 0;
    }


    @Override
    public int GL_FALSE()
    {
        return 0;
    }


    @Override
    public int GL_FRAGMENT_SHADER()
    {
        return 0;
    }


    @Override
    public int GL_LINK_STATUS()
    {
        return 0;
    }


    @Override
    public int GL_POLYGON_OFFSET_FILL()
    {
        return 0;
    }


    @Override
    public int GL_SAMPLE_ALPHA_TO_COVERAGE()
    {
        return 0;
    }


    @Override
    public int GL_SAMPLE_COVERAGE()
    {
        return 0;
    }


    @Override
    public int GL_SCISSOR_TEST()
    {
        return 0;
    }


    @Override
    public int GL_STATIC_DRAW()
    {
        return 0;
    }


    @Override
    public int GL_STENCIL_BUFFER_BIT()
    {
        return 0;
    }


    @Override
    public int GL_STENCIL_TEST()
    {
        return 0;
    }


    @Override
    public int GL_STREAM_DRAW()
    {
        return 0;
    }


    @Override
    public int GL_TRUE()
    {
        return 1;
    }


    @Override
    public int GL_VERTEX_SHADER()
    {
        return 0;
    }


    @Override
    public void glAttachShader(int programId, int shaderId)
    {
        unsupported("glAttachShader");
    }


    @Override
    public void glBindBuffer(int vertexBufferType, int vertexBufferId)
    {
        unsupported("glBindBuffer");
    }


    @Override
    public void glBufferData(int vertexBufferType, int size, Buffer data, int vertexBufferUsage)
    {
        unsupported("glBufferData");
    }


    @Override
    public void glBufferSubData(int vertexBufferType, int offset, int size, Buffer data)
    {
        unsupported("glBufferSubData");
    }


    @Override
    public void glClear(int mask)
    {
        unsupported("glClear");
    }


    @Override
    public void glClearColor(float red, float green, float blue, float alpha)
    {
        unsupported("glClearColor");
    }


    @Override
    public void glClearDepthf(float depth)
    {
        unsupported("glClearDepthf");
    }


    @Override
    public void glClearStencil(int stencil)
    {
        unsupported("glClearStencil");
    }


    @Override
    public void glCompileShader(int shaderId)
    {
        unsupported("glCompileShader");
    }


    @Override
    public int glCreateProgram()
    {
        unsupported("glCreateProgram");

        return 0;
    }


    @Override
    public int glCreateShader(int shaderType)
    {
        unsupported("glCreateShader");

        return 0;
    }


    @Override
    public void glDeleteBuffers(int vertexBufferType, int[] vertexBufferIds, int offset)
    {
        unsupported("glDeleteBuffers");
    }


    @Override
    public void glDeleteProgram(int programId)
    {
        unsupported("glDeleteProgram");
    }


    @Override
    public void glDeleteShader(int shaderId)
    {
        unsupported("glDeleteShader");
    }


    @Override
    public void glDetachShader(int programId, int shaderId)
    {
        unsupported("glDetachShader");
    }


    @Override
    public void glDisable(int capability)
    {
        unsupported("glDisable");
    }


    @Override
    public void glEnable(int capability)
    {
        unsupported("glEnable");
    }


    @Override
    public void glGenBuffers(int vertexBufferType, int[] vertexBufferIds, int offset)
    {
        unsupported("glGenBuffers");
    }


    @Override
    public String glGetProgramInfoLog(int programId)
    {
        unsupported("glGetProgramInfoLog");

        return null;
    }


    @Override
    public void glGetProgramiv(int programId, int parameterName, int[] params, int offset)
    {
        unsupported("glGetProgramiv");
    }


    @Override
    public String glGetShaderInfoLog(int shaderId)
    {
        unsupported("glGetShaderInfoLog");

        return null;
    }


    @Override
    public void glGetShaderiv(int shaderId, int parameterName, int[] params, int offset)
    {
        unsupported("glGetShaderiv");
    }


    @Override
    public void glGetUniformfv(int programId, int uniformLocation, FloatBuffer params)
    {
        unsupported("glGetUniformfv");
    }


    @Override
    public void glGetUniformfv(int programId, int uniformLocation, float[] params, int offset)
    {
        unsupported("glGetUniformfv");
    }


    @Override
    public void glGetUniformiv(int programId, int uniformLocation, IntBuffer params)
    {
        unsupported("glGetUniformiv");
    }


    @Override
    public void glGetUniformiv(int programId, int uniformLocation, int[] params, int offset)
    {
        unsupported("glGetUniformiv");
    }


    @Override
    public int glGetUniformLocation(int programId, String variableName)
    {
        unsupported("glGetUniformLocation");

        return 0;
    }


    @Override
    public boolean glIsEnabled(int capability)
    {
        unsupported("glDisable");

        return false;
    }


    @Override
    public void glLinkProgram(int programId)
    {
        unsupported("glLinkProgram");
    }


    @Override
    public void glReleaseShaderCompiler()
    {
        unsupported("glReleaseShaderCompiler");
    }


    @Override
    public void glShaderSource(int shaderId, String shaderSourceCode)
    {
        unsupported("glShaderSource");
    }


    @Override
    public void glUniform1f(int uniformLocation, float x)
    {
        unsupported("glUniform1f");
    }


    @Override
    public void glUniform1fv(int uniformLocation, int count, FloatBuffer values)
    {
        unsupported("glUniform1fv");
    }


    @Override
    public void glUniform1fv(int uniformLocation, int count, float[] values, int offset)
    {
        unsupported("glUniform1fv");
    }


    @Override
    public void glUniform1i(int uniformLocation, int x)
    {
        unsupported("glUniform1i");
    }


    @Override
    public void glUniform1iv(int uniformLocation, int count, IntBuffer values)
    {
        unsupported("glUniform1iv");
    }


    @Override
    public void glUniform1iv(int uniformLocation, int count, int[] values, int offset)
    {
        unsupported("glUniform1iv");
    }


    @Override
    public void glUniform2f(int uniformLocation, float x, float y)
    {
        unsupported("glUniform2f");
    }


    @Override
    public void glUniform2fv(int uniformLocation, int count, FloatBuffer values)
    {
        unsupported("glUniform2fv");
    }


    @Override
    public void glUniform2fv(int uniformLocation, int count, float[] values, int offset)
    {
        unsupported("glUniform2fv");
    }


    @Override
    public void glUniform2i(int uniformLocation, int x, int y)
    {
        unsupported("glUniform2i");
    }


    @Override
    public void glUniform2iv(int uniformLocation, int count, IntBuffer values)
    {
        unsupported("glUniform2iv");
    }


    @Override
    public void glUniform2iv(int uniformLocation, int count, int[] values, int offset)
    {
        unsupported("glUniform2iv");
    }


    @Override
    public void glUniform3f(int uniformLocation, float x, float y, float z)
    {
        unsupported("glUniform3f");
    }


    @Override
    public void glUniform3fv(int uniformLocation, int count, FloatBuffer values)
    {
        unsupported("glUniform3fv");
    }


    @Override
    public void glUniform3fv(int uniformLocation, int count, float[] values, int offset)
    {
        unsupported("glUniform3fv");
    }


    @Override
    public void glUniform3i(int uniformLocation, int x, int y, int z)
    {
        unsupported("glUniform3i");
    }


    @Override
    public void glUniform3iv(int uniformLocation, int count, IntBuffer values)
    {
        unsupported("glUniform3iv");
    }


    @Override
    public void glUniform3iv(int uniformLocation, int count, int[] values, int offset)
    {
        unsupported("glUniform3iv");
    }


    @Override
    public void glUniform4f(int uniformLocation, float x, float y, float z, float w)
    {
        unsupported("glUniform4f");
    }


    @Override
    public void glUniform4fv(int uniformLocation, int count, FloatBuffer values)
    {
        unsupported("glUniform4fv");
    }


    @Override
    public void glUniform4fv(int uniformLocation, int count, float[] values, int offset)
    {
        unsupported("glUniform4fv");
    }


    @Override
    public void glUniform4i(int uniformLocation, int x, int y, int z, int w)
    {
        unsupported("glUniform4i");
    }


    @Override
    public void glUniform4iv(int uniformLocation, int count, IntBuffer values)
    {
        unsupported("glUniform4iv");
    }


    @Override
    public void glUniform4iv(int uniformLocation, int count, int[] values, int offset)
    {
        unsupported("glUniform4iv");
    }


    @Override
    public void glUniformMatrix2fv(int uniformLocation, int count, boolean transpose, FloatBuffer values)
    {
        unsupported("glUniformMatrix2fv");
    }


    @Override
    public void glUniformMatrix2fv(int uniformLocation, int count, boolean transpose, float[] values, int offset)
    {
        unsupported("glUniformMatrix2fv");
    }


    @Override
    public void glUniformMatrix3fv(int uniformLocation, int count, boolean transpose, FloatBuffer values)
    {
        unsupported("glUniformMatrix3fv");
    }


    @Override
    public void glUniformMatrix3fv(int uniformLocation, int count, boolean transpose, float[] values, int offset)
    {
        unsupported("glUniformMatrix3fv");
    }


    @Override
    public void glUniformMatrix4fv(int uniformLocation, int count, boolean transpose, FloatBuffer values)
    {
        unsupported("glUniformMatrix4fv");
    }


    @Override
    public void glUniformMatrix4fv(int uniformLocation, int count, boolean transpose, float[] values, int offset)
    {
        unsupported("glUniformMatrix4fv");
    }


    @Override
    public void glUseProgram(int programId)
    {
        unsupported("glUseProgram");
    }


    private void unsupported(String name)
    {
        String message = String.format("%s does not support '%s'", this.getClass().getName(), name);

        throw new UnsupportedOperationException(message);
    }
}
