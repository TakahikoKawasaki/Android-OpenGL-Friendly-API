/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl.impl;


import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import android.opengl.GLES20;
import com.neovisionaries.android.opengl.GLES;


/**
 * An implementation of {@link GLES} interface for OpenGL ES 2.0.
 *
 * @author Takahiko Kawasaki
 *
 * @see <a href="http://developer.android.com/reference/android/opengl/GLES20.html">android.opengl.GLES20</a>
 */
public class GLESImpl20 extends GLESImplBase
{
    @Override
    public int GL_ARRAY_BUFFER()
    {
        return GLES20.GL_ARRAY_BUFFER;
    }


    @Override
    public int GL_COLOR_BUFFER_BIT()
    {
        return GLES20.GL_COLOR_BUFFER_BIT;
    }


    @Override
    public int GL_COMPILE_STATUS()
    {
        return GLES20.GL_COMPILE_STATUS;
    }


    @Override
    public int GL_DEPTH_BUFFER_BIT()
    {
        return GLES20.GL_DEPTH_BUFFER_BIT;
    }


    @Override
    public int GL_DYNAMIC_DRAW()
    {
        return GLES20.GL_DYNAMIC_DRAW;
    }


    @Override
    public int GL_ELEMENT_ARRAY_BUFFER()
    {
        return GLES20.GL_ELEMENT_ARRAY_BUFFER;
    }


    @Override
    public int GL_FRAGMENT_SHADER()
    {
        return GLES20.GL_FRAGMENT_SHADER;
    }


    @Override
    public int GL_LINK_STATUS()
    {
        return GLES20.GL_LINK_STATUS;
    }


    @Override
    public int GL_STATIC_DRAW()
    {
        return GLES20.GL_STATIC_DRAW;
    }


    @Override
    public int GL_STENCIL_BUFFER_BIT()
    {
        return GLES20.GL_STENCIL_BUFFER_BIT;
    }


    @Override
    public int GL_STREAM_DRAW()
    {
        return GLES20.GL_STREAM_DRAW;
    }


    @Override
    public int GL_TRUE()
    {
        return GLES20.GL_TRUE;
    }


    @Override
    public int GL_VERTEX_SHADER()
    {
        return GLES20.GL_VERTEX_SHADER;
    }


    @Override
    public void glAttachShader(int programId, int shaderId)
    {
        GLES20.glAttachShader(programId, shaderId);
    }


    @Override
    public void glBindBuffer(int vertexBufferType, int vertexBufferId)
    {
        GLES20.glBindBuffer(vertexBufferType, vertexBufferId);
    }


    @Override
    public void glBufferData(int vertexBufferType, int size, Buffer data, int vertexBufferUsage)
    {
        GLES20.glBufferData(vertexBufferType, size, data, vertexBufferUsage);
    }


    @Override
    public void glBufferSubData(int vertexBufferType, int offset, int size, Buffer data)
    {
        GLES20.glBufferSubData(vertexBufferType, offset, size, data);
    }


    @Override
    public void glClear(int mask)
    {
        GLES20.glClear(mask);
    }


    @Override
    public void glClearColor(float red, float green, float blue, float alpha)
    {
        GLES20.glClearColor(red, green, blue, alpha);
    }


    @Override
    public void glClearDepthf(float depth)
    {
        GLES20.glClearDepthf(depth);
    }


    @Override
    public void glClearStencil(int stencil)
    {
        GLES20.glClearStencil(stencil);
    }


    @Override
    public void glCompileShader(int shaderId)
    {
        GLES20.glCompileShader(shaderId);
    }


    @Override
    public int glCreateProgram()
    {
        return GLES20.glCreateProgram();
    }


    @Override
    public int glCreateShader(int shaderType)
    {
        return GLES20.glCreateShader(shaderType);
    }


    @Override
    public void glDeleteBuffers(int vertexBufferType, int[] vertexBufferIds, int offset)
    {
        GLES20.glDeleteBuffers(vertexBufferType, vertexBufferIds, offset);
    }


    @Override
    public void glDeleteProgram(int programId)
    {
        GLES20.glDeleteProgram(programId);
    }


    @Override
    public void glDeleteShader(int shaderId)
    {
        GLES20.glDeleteShader(shaderId);
    }


    @Override
    public void glDetachShader(int programId, int shaderId)
    {
        GLES20.glDetachShader(programId, shaderId);
    }


    @Override
    public void glGenBuffers(int vertexBufferType, int[] vertexBufferIds, int offset)
    {
        GLES20.glGenBuffers(vertexBufferType, vertexBufferIds, offset);
    }


    @Override
    public String glGetProgramInfoLog(int programId)
    {
        return GLES20.glGetProgramInfoLog(programId);
    }


    @Override
    public void glGetProgramiv(int programId, int parameterName, int[] params, int offset)
    {
        GLES20.glGetProgramiv(programId, parameterName, params, offset);
    }


    @Override
    public String glGetShaderInfoLog(int shaderId)
    {
        return GLES20.glGetShaderInfoLog(shaderId);
    }


    @Override
    public void glGetShaderiv(int shaderId, int parameterName, int[] params, int offset)
    {
        GLES20.glGetShaderiv(shaderId, parameterName, params, offset);
    }


    @Override
    public void glGetUniformfv(int programId, int uniformLocation, FloatBuffer params)
    {
        GLES20.glGetUniformfv(programId, uniformLocation, params);
    }


    @Override
    public void glGetUniformfv(int programId, int uniformLocation, float[] params, int offset)
    {
        GLES20.glGetUniformfv(programId, uniformLocation, params, offset);
    }


    @Override
    public void glGetUniformiv(int programId, int uniformLocation, IntBuffer params)
    {
        GLES20.glGetUniformiv(programId, uniformLocation, params);
    }


    @Override
    public void glGetUniformiv(int programId, int uniformLocation, int[] params, int offset)
    {
        GLES20.glGetUniformiv(programId, uniformLocation, params, offset);
    }


    @Override
    public int glGetUniformLocation(int programId, String variableName)
    {
        return GLES20.glGetUniformLocation(programId, variableName);
    }


    @Override
    public void glLinkProgram(int programId)
    {
        GLES20.glLinkProgram(programId);
    }


    @Override
    public void glReleaseShaderCompiler()
    {
        GLES20.glReleaseShaderCompiler();
    }


    @Override
    public void glShaderSource(int shaderId, String shaderSourceCode)
    {
        GLES20.glShaderSource(shaderId, shaderSourceCode);
    }


    @Override
    public void glUniform1f(int uniformLocation, float x)
    {
        GLES20.glUniform1f(uniformLocation, x);
    }


    @Override
    public void glUniform1fv(int uniformLocation, int count, FloatBuffer values)
    {
        GLES20.glUniform1fv(uniformLocation, count, values);
    }


    @Override
    public void glUniform1fv(int uniformLocation, int count, float[] values, int offset)
    {
        GLES20.glUniform1fv(uniformLocation, count, values, offset);
    }


    @Override
    public void glUniform1i(int uniformLocation, int x)
    {
        GLES20.glUniform1i(uniformLocation, x);
    }


    @Override
    public void glUniform1iv(int uniformLocation, int count, IntBuffer values)
    {
        GLES20.glUniform1iv(uniformLocation, count, values);
    }


    @Override
    public void glUniform1iv(int uniformLocation, int count, int[] values, int offset)
    {
        GLES20.glUniform1iv(uniformLocation, count, values, offset);
    }


    @Override
    public void glUniform2f(int uniformLocation, float x, float y)
    {
        GLES20.glUniform2f(uniformLocation, x, y);
    }


    @Override
    public void glUniform2fv(int uniformLocation, int count, FloatBuffer values)
    {
        GLES20.glUniform2fv(uniformLocation, count, values);
    }


    @Override
    public void glUniform2fv(int uniformLocation, int count, float[] values, int offset)
    {
        GLES20.glUniform2fv(uniformLocation, count, values, offset);
    }


    @Override
    public void glUniform2i(int uniformLocation, int x, int y)
    {
        GLES20.glUniform2i(uniformLocation, x, y);
    }


    @Override
    public void glUniform2iv(int uniformLocation, int count, IntBuffer values)
    {
        GLES20.glUniform2iv(uniformLocation, count, values);
    }


    @Override
    public void glUniform2iv(int uniformLocation, int count, int[] values, int offset)
    {
        GLES20.glUniform2iv(uniformLocation, count, values, offset);
    }


    @Override
    public void glUniform3f(int uniformLocation, float x, float y, float z)
    {
        GLES20.glUniform3f(uniformLocation, x, y, z);
    }


    @Override
    public void glUniform3fv(int uniformLocation, int count, FloatBuffer values)
    {
        GLES20.glUniform3fv(uniformLocation, count, values);
    }


    @Override
    public void glUniform3fv(int uniformLocation, int count, float[] values, int offset)
    {
        GLES20.glUniform3fv(uniformLocation, count, values, offset);
    }


    @Override
    public void glUniform3i(int uniformLocation, int x, int y, int z)
    {
        GLES20.glUniform3i(uniformLocation, x, y, z);
    }


    @Override
    public void glUniform3iv(int uniformLocation, int count, IntBuffer values)
    {
        GLES20.glUniform3iv(uniformLocation, count, values);
    }


    @Override
    public void glUniform3iv(int uniformLocation, int count, int[] values, int offset)
    {
        GLES20.glUniform3iv(uniformLocation, count, values, offset);
    }


    @Override
    public void glUniform4f(int uniformLocation, float x, float y, float z, float w)
    {
        GLES20.glUniform4f(uniformLocation, x, y, z, w);
    }


    @Override
    public void glUniform4fv(int uniformLocation, int count, FloatBuffer values)
    {
        GLES20.glUniform4fv(uniformLocation, count, values);
    }


    @Override
    public void glUniform4fv(int uniformLocation, int count, float[] values, int offset)
    {
        GLES20.glUniform4fv(uniformLocation, count, values, offset);
    }


    @Override
    public void glUniform4i(int uniformLocation, int x, int y, int z, int w)
    {
        GLES20.glUniform4i(uniformLocation, x, y, z, w);
    }


    @Override
    public void glUniform4iv(int uniformLocation, int count, IntBuffer values)
    {
        GLES20.glUniform4iv(uniformLocation, count, values);
    }


    @Override
    public void glUniform4iv(int uniformLocation, int count, int[] values, int offset)
    {
        GLES20.glUniform4iv(uniformLocation, count, values, offset);
    }


    @Override
    public void glUniformMatrix2fv(int uniformLocation, int count, boolean transpose, FloatBuffer values)
    {
        GLES20.glUniformMatrix2fv(uniformLocation, count, transpose, values);
    }


    @Override
    public void glUniformMatrix2fv(int uniformLocation, int count, boolean transpose, float[] values, int offset)
    {
        GLES20.glUniformMatrix2fv(uniformLocation, count, transpose, values, offset);
    }


    @Override
    public void glUniformMatrix3fv(int uniformLocation, int count, boolean transpose, FloatBuffer values)
    {
        GLES20.glUniformMatrix3fv(uniformLocation, count, transpose, values);
    }


    @Override
    public void glUniformMatrix3fv(int uniformLocation, int count, boolean transpose, float[] values, int offset)
    {
        GLES20.glUniformMatrix3fv(uniformLocation, count, transpose, values, offset);
    }


    @Override
    public void glUniformMatrix4fv(int uniformLocation, int count, boolean transpose, FloatBuffer values)
    {
        GLES20.glUniformMatrix4fv(uniformLocation, count, transpose, values);
    }


    @Override
    public void glUniformMatrix4fv(int uniformLocation, int count, boolean transpose, float[] values, int offset)
    {
        GLES20.glUniformMatrix4fv(uniformLocation, count, transpose, values, offset);
    }


    @Override
    public void glUseProgram(int programId)
    {
        GLES20.glUseProgram(programId);
    }
}
