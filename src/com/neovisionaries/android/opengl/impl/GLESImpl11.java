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
package com.neovisionaries.android.opengl.impl;


import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import android.opengl.GLES11;
import com.neovisionaries.android.opengl.GLES;


/**
 * An implementation of {@link GLES} interface for OpenGL ES 1.1.
 * 
 * @author Takahiko Kawasaki
 * 
 * @see <a href="http://developer.android.com/reference/android/opengl/GLES11.html">android.opengl.GLES11</a>
 */
public class GLESImpl11 extends GLESImplBase
{
    @Override
    public int getMajorVersion()
    {
        // OpenGL ES 1.1.
        return 1;
    }


    @Override
    public void glActiveTexture(int textureUnit)
    {
        GLES11.glActiveTexture(textureUnit);
    }


    @Override
    public void glBindBuffer(int vertexBufferType, int vertexBufferId)
    {
        GLES11.glBindBuffer(vertexBufferType, vertexBufferId);
    }


    @Override
    public void glBindTexture(int textureType, int textureId)
    {
        GLES11.glBindTexture(textureType, textureId);
    }


    @Override
    public void glBlendFunc(int sourceFactor, int destinationFactor)
    {
        GLES11.glBlendFunc(sourceFactor, destinationFactor);
    }


    @Override
    public void glBufferData(int vertexBufferType, int size, Buffer data, int vertexBufferUsage)
    {
        GLES11.glBufferData(vertexBufferType, size, data, vertexBufferUsage);
    }


    @Override
    public void glBufferSubData(int vertexBufferType, int offset, int size, Buffer data)
    {
        GLES11.glBufferSubData(vertexBufferType, offset, size, data);
    }


    @Override
    public void glClear(int mask)
    {
        GLES11.glClear(mask);
    }


    @Override
    public void glClearColor(float red, float green, float blue, float alpha)
    {
        GLES11.glClearColor(red, green, blue, alpha);
    }


    @Override
    public void glClearDepthf(float depth)
    {
        GLES11.glClearDepthf(depth);
    }


    @Override
    public void glClearStencil(int stencil)
    {
        GLES11.glClearStencil(stencil);
    }


    @Override
    public void glColorMask(boolean red, boolean green, boolean blue, boolean alpha)
    {
        GLES11.glColorMask(red, green, blue, alpha);
    }


    @Override
    public void glDeleteBuffers(int count, int[] vertexBufferIds, int offset)
    {
        GLES11.glDeleteBuffers(count, vertexBufferIds, offset);
    }


    @Override
    public void glDeleteTextures(int count, int[] textureIds, int offset)
    {
        GLES11.glDeleteTextures(count, textureIds, offset);
    }


    @Override
    public void glDepthMask(boolean writable)
    {
        GLES11.glDepthMask(writable);
    }


    @Override
    public void glDisable(int capability)
    {
        GLES11.glDisable(capability);
    }


    @Override
    public void glDrawArrays(int mode, int first, int count)
    {
        GLES11.glDrawArrays(mode, first, count);
    }


    @Override
    public void glDrawElements(int mode, int count, int type, Buffer indices)
    {
        GLES11.glDrawElements(mode, count, type, indices);
    }


    @Override
    public void glDrawElements(int mode, int count, int type, int offset)
    {
        GLES11.glDrawElements(mode, count, type, offset);
    }


    @Override
    public void glEnable(int capability)
    {
        GLES11.glEnable(capability);
    }


    @Override
    public void glFinish()
    {
        GLES11.glFinish();
    }


    @Override
    public void glFlush()
    {
        GLES11.glFlush();
    }


    @Override
    public void glGenBuffers(int vertexBufferType, int[] vertexBufferIds, int offset)
    {
        GLES11.glGenBuffers(vertexBufferType, vertexBufferIds, offset);
    }


    @Override
    public void glGenTextures(int textureType, int[] textureIds, int offset)
    {
        GLES11.glGenTextures(textureType, textureIds, offset);
    }


    @Override
    public void glGetBooleanv(int parameterId, IntBuffer params)
    {
        GLES11.glGetBooleanv(parameterId, params);
    }


    @Override
    public void glGetBooleanv(int parameterId, boolean[] params, int offset)
    {
        GLES11.glGetBooleanv(parameterId, params, offset);
    }


    @Override
    public int glGetError()
    {
        return GLES11.glGetError();
    }


    @Override
    public void glGetFloatv(int parameterId, FloatBuffer params)
    {
        GLES11.glGetFloatv(parameterId, params);
    }


    @Override
    public void glGetFloatv(int parameterId, float[] params, int offset)
    {
        GLES11.glGetFloatv(parameterId, params, offset);
    }


    @Override
    public void glGetIntegerv(int parameterId, IntBuffer params)
    {
        GLES11.glGetIntegerv(parameterId, params);
    }


    @Override
    public void glGetIntegerv(int parameterId, int[] params, int offset)
    {
        GLES11.glGetIntegerv(parameterId, params, offset);
    }


    @Override
    public String glGetString(int parameterId)
    {
        return GLES11.glGetString(parameterId);
    }


    @Override
    public boolean glIsEnabled(int capability)
    {
        return GLES11.glIsEnabled(capability);
    }


    @Override
    public void glStencilFunc(int comparisonOperator, int referenceValue, int mask)
    {
        GLES11.glStencilFunc(comparisonOperator, referenceValue, mask);
    }


    @Override
    public void glStencilMask(int stencilMask)
    {
        GLES11.glStencilMask(stencilMask);
    }


    @Override
    public void glStencilOp(int stencilFail, int depthFail, int pass)
    {
        GLES11.glStencilOp(stencilFail, depthFail, pass);
    }


    @Override
    public void glTexParameteri(int textureType, int parameterId, int parameterValue)
    {
        GLES11.glTexParameteri(textureType, parameterId, parameterValue);
    }


    @Override
    public void glViewport(int x, int y, int width, int height)
    {
        GLES11.glViewport(x, y, width, height);
    }
}
