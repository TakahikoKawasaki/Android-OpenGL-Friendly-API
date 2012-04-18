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
    public void glAttachShader(int programId, int shaderId)
    {
        GLES20.glAttachShader(programId, shaderId);
    }


    @Override
    public void glBindAttribLocation(int programId, int attributeIndex, String attributeName)
    {
        GLES20.glBindAttribLocation(programId, attributeIndex, attributeName);
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
    public void glDisable(int capability)
    {
        GLES20.glDisable(capability);
    }


    @Override
    public void glDisableVertexAttribArray(int index)
    {
        GLES20.glDisableVertexAttribArray(index);
    }


    @Override
    public void glEnable(int capability)
    {
        GLES20.glEnable(capability);
    }


    @Override
    public void glEnableVertexAttribArray(int index)
    {
        GLES20.glEnableVertexAttribArray(index);
    }


    @Override
    public void glFinish()
    {
        GLES20.glFinish();
    }


    @Override
    public void glFlush()
    {
        GLES20.glFlush();
    }


    @Override
    public void glGenBuffers(int vertexBufferType, int[] vertexBufferIds, int offset)
    {
        GLES20.glGenBuffers(vertexBufferType, vertexBufferIds, offset);
    }


    @Override
    public int glGetAttribLocation(int programId, String attributeName)
    {
        return GLES20.glGetAttribLocation(programId, attributeName);
    }


    @Override
    public void glGetBooleanv(int parameterId, IntBuffer params)
    {
        GLES20.glGetBooleanv(parameterId, params);
    }


    @Override
    public void glGetBooleanv(int parameterId, boolean[] params, int offset)
    {
        GLES20.glGetBooleanv(parameterId, params, offset);
    }


    @Override
    public int glGetError()
    {
        return GLES20.glGetError();
    }


    @Override
    public void glGetFloatv(int parameterId, FloatBuffer params)
    {
        GLES20.glGetFloatv(parameterId, params);
    }


    @Override
    public void glGetFloatv(int parameterId, float[] params, int offset)
    {
        GLES20.glGetFloatv(parameterId, params, offset);
    }


    @Override
    public void glGetIntegerv(int parameterId, IntBuffer params)
    {
        GLES20.glGetIntegerv(parameterId, params);
    }


    @Override
    public void glGetIntegerv(int parameterId, int[] params, int offset)
    {
        GLES20.glGetIntegerv(parameterId, params, offset);
    }


    @Override
    public String glGetProgramInfoLog(int programId)
    {
        return GLES20.glGetProgramInfoLog(programId);
    }


    @Override
    public void glGetProgramiv(int programId, int parameterId, int[] params, int offset)
    {
        GLES20.glGetProgramiv(programId, parameterId, params, offset);
    }


    @Override
    public String glGetShaderInfoLog(int shaderId)
    {
        return GLES20.glGetShaderInfoLog(shaderId);
    }


    @Override
    public void glGetShaderiv(int shaderId, int parameterId, int[] params, int offset)
    {
        GLES20.glGetShaderiv(shaderId, parameterId, params, offset);
    }


    @Override
    public String glGetString(int parameterId)
    {
        return GLES20.glGetString(parameterId);
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
    public boolean glIsEnabled(int capability)
    {
        return GLES20.glIsEnabled(capability);
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


    @Override
    public void glViewport(int x, int y, int width, int height)
    {
        GLES20.glViewport(x, y, width, height);
    }
}
