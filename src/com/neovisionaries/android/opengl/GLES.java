/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;


/**
 * OpenGL ES interface.
 *
 * <p>
 * An implementation of this interface can be obtained by
 * {@link GLESFactory#getInstance()}.
 * </p>
 *
 * @author Takahiko Kawasaki
 *
 * @see GLESFactory#getInstance()
 */
public interface GLES
{
    int GL_ARRAY_BUFFER();
    int GL_COLOR_BUFFER_BIT();
    int GL_COMPILE_STATUS();
    int GL_DEPTH_BUFFER_BIT();
    int GL_DYNAMIC_DRAW();
    int GL_ELEMENT_ARRAY_BUFFER();
    int GL_FRAGMENT_SHADER();
    int GL_LINK_STATUS();
    int GL_STATIC_DRAW();
    int GL_STENCIL_BUFFER_BIT();
    int GL_STREAM_DRAW();
    int GL_TRUE();
    int GL_VERTEX_SHADER();


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glAttachShader.xml">glAttachShader</a>
     */
    void glAttachShader(int programId, int shaderId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindBuffer.xml">glBindBuffer</a>
     */
    void glBindBuffer(int vertexBufferType, int vertexBufferId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBufferData.xml">glBufferData</a>
     */
    void glBufferData(int vertexBufferType, int size, Buffer data, int vertexBufferUsage);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBufferData.xml">glBufferSubData</a>
     */
    void glBufferSubData(int vertexBufferType, int offset, int size, Buffer data);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClear.xml">glClear</a>
     */
    void glClear(int mask);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClearColor.xml">glClearColor</a>
     */
    void glClearColor(float red, float green, float blue, float alpha);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClearDepthf.xml">glClearDepthf</a>
     */
    void glClearDepthf(float depth);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClearStencil.xml">glClearStencil</a>
     */
    void glClearStencil(int stencil);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glCompileShader.xml">glCompileShader</a>
     */
    void glCompileShader(int shaderId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glCreateProgram.xml">glCreateProgram</a>
     */
    int glCreateProgram();


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     */
    int glCreateShader(int shaderType);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDeleteBuffers.xml">glDeleteBuffers</a>
     */
    void glDeleteBuffers(int vertexBufferType, int[] vertexBufferIds, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDeleteProgram.xml">glDeleteProgram</a>
     */
    void glDeleteProgram(int programId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDeleteShader.xml">glDeleteShader</a>
     */
    void glDeleteShader(int shaderId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDetachShader.xml">glDetachShader</a>
     */
    void glDetachShader(int programId, int shaderId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenBuffers.xml">glGenBuffers</a>
     */
    void glGenBuffers(int vertexBufferType, int[] vertexBufferIds, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetProgramInfoLog.xml">glGetProgramInfoLog</a>
     */
    String glGetProgramInfoLog(int programId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetProgramiv.xml">glGetProgramiv</a>
     */
    void glGetProgramiv(int programId, int parameterName, int[] params, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetShaderInfoLog.xml">glGetShaderInfoLog</a>
     */
    String glGetShaderInfoLog(int shaderId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetShaderiv.xml">glGetShaderiv</a>
     */
    void glGetShaderiv(int shaderId, int parameterName, int[] params, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniform.xml">glGetUniformfv</a>
     */
    void glGetUniformfv(int programId, int uniformLocation, FloatBuffer params);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniform.xml">glGetUniformfv</a>
     */
    void glGetUniformfv(int programId, int uniformLocation, float[] params, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniform.xml">glGetUniformiv</a>
     */
    void glGetUniformiv(int programId, int uniformLocation, IntBuffer params);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniform.xml">glGetUniformiv</a>
     */
    void glGetUniformiv(int programId, int uniformLocation, int[] params, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniformLocation.xml">glGetUniformLocation</a>
     */
    int glGetUniformLocation(int programId, String variableName);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glLinkProgram.xml">glLinkProgram</a>
     */
    void glLinkProgram(int programId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glReleaseShaderCompiler.xml">glReleaseShaderCompiler</a>
     */
    void glReleaseShaderCompiler();


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glShaderSource.xml">glShaderSource</a>
     */
    void glShaderSource(int shaderId, String shaderSourceCode);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1f</a>
     */
    void glUniform1f(int uniformLocation, float x);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1fv</a>
     */
    void glUniform1fv(int uniformLocation, int count, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1fv</a>
     */
    void glUniform1fv(int uniformLocation, int count, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1i</a>
     */
    void glUniform1i(int uniformLocation, int x);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1iv</a>
     */
    void glUniform1iv(int uniformLocation, int count, IntBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1iv</a>
     */
    void glUniform1iv(int uniformLocation, int count, int[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2f</a>
     */
    void glUniform2f(int uniformLocation, float x, float y);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2fv</a>
     */
    void glUniform2fv(int uniformLocation, int count, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2fv</a>
     */
    void glUniform2fv(int uniformLocation, int count, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2i</a>
     */
    void glUniform2i(int uniformLocation, int x, int y);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2iv</a>
     */
    void glUniform2iv(int uniformLocation, int count, IntBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2iv</a>
     */
    void glUniform2iv(int uniformLocation, int count, int[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3f</a>
     */
    void glUniform3f(int uniformLocation, float x, float y, float z);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3fv</a>
     */
    void glUniform3fv(int uniformLocation, int count, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3fv</a>
     */
    void glUniform3fv(int uniformLocation, int count, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3i</a>
     */
    void glUniform3i(int uniformLocation, int x, int y, int z);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3iv</a>
     */
    void glUniform3iv(int uniformLocation, int count, IntBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3iv</a>
     */
    void glUniform3iv(int uniformLocation, int count, int[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4f</a>
     */
    void glUniform4f(int uniformLocation, float x, float y, float z, float w);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4fv</a>
     */
    void glUniform4fv(int uniformLocation, int count, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4fv</a>
     */
    void glUniform4fv(int uniformLocation, int count, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4i</a>
     */
    void glUniform4i(int uniformLocation, int x, int y, int z, int w);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4iv</a>
     */
    void glUniform4iv(int uniformLocation, int count, IntBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4iv</a>
     */
    void glUniform4iv(int uniformLocation, int count, int[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix2fv</a>
     */
    void glUniformMatrix2fv(int uniformLocation, int count, boolean transpose, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix2fv</a>
     */
    void glUniformMatrix2fv(int uniformLocation, int count, boolean transpose, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix3fv</a>
     */
    void glUniformMatrix3fv(int uniformLocation, int count, boolean transpose, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix3fv</a>
     */
    void glUniformMatrix3fv(int uniformLocation, int count, boolean transpose, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix4fv</a>
     */
    void glUniformMatrix4fv(int uniformLocation, int count, boolean transpose, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix4fv</a>
     */
    void glUniformMatrix4fv(int uniformLocation, int count, boolean transpose, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUseProgram.xml">glUseProgram</a>
     */
    void glUseProgram(int programId);
}
