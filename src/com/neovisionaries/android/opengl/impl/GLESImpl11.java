/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl.impl;


import java.nio.Buffer;
import android.opengl.GLES11;
import com.neovisionaries.android.opengl.GLES;


/**
 * An implementation of {@link GLES} interface for OpenGL ES 1.1.
 * 
 * @author Takahiko Kawasaki
 * 
 * @see <a
 *      href="http://developer.android.com/reference/android/opengl/GLES11.html">android.opengl.GLES11</a>
 */
public class GLESImpl11 extends GLESImplBase
{
    @Override
    public int GL_ARRAY_BUFFER()
    {
        return GLES11.GL_ARRAY_BUFFER;
    }


    @Override
    public int GL_COLOR_BUFFER_BIT()
    {
        return GLES11.GL_COLOR_BUFFER_BIT;
    }


    @Override
    public int GL_DEPTH_BUFFER_BIT()
    {
        return GLES11.GL_DEPTH_BUFFER_BIT;
    }


    @Override
    public int GL_DYNAMIC_DRAW()
    {
        return GLES11.GL_DYNAMIC_DRAW;
    }


    @Override
    public int GL_ELEMENT_ARRAY_BUFFER()
    {
        return GLES11.GL_ELEMENT_ARRAY_BUFFER;
    }


    @Override
    public int GL_STATIC_DRAW()
    {
        return GLES11.GL_STATIC_DRAW;
    }


    @Override
    public int GL_STENCIL_BUFFER_BIT()
    {
        return GLES11.GL_STENCIL_BUFFER_BIT;
    }


    @Override
    public int GL_TRUE()
    {
        return GLES11.GL_TRUE;
    }


    @Override
    public void glBindBuffer(int vertexBufferType, int vertexBufferId)
    {
        GLES11.glBindBuffer(vertexBufferType, vertexBufferId);
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
    public void glDeleteBuffers(int vertexBufferType, int[] vertexBufferIds, int offset)
    {
        GLES11.glDeleteBuffers(vertexBufferType, vertexBufferIds, offset);
    }


    @Override
    public void glGenBuffers(int vertexBufferType, int[] vertexBufferIds, int offset)
    {
        GLES11.glGenBuffers(vertexBufferType, vertexBufferIds, offset);
    }
}
