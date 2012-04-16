/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL vertex buffer usage.
 * 
 * @author Takahiko Kawasaki
 */
public enum VertexBufferUsage
{
    /**
     * GL_STATIC_DRAW.
     */
    STATIC(GLESFactory.getInstance().GL_STATIC_DRAW()),


    /**
     * GL_DYNAMIC_DRAW.
     */
    DYNAMIC(GLESFactory.getInstance().GL_DYNAMIC_DRAW()),


    /**
     * GL_STREAM_DRAW.
     */
    STREAM(GLESFactory.getInstance().GL_STREAM_DRAW());


    /**
     * An integer representing vertex buffer usage.
     */
    private final int usage;


    /**
     * A constructor with usage.
     *
     * @param usage
     *         GL_STATIC_DRAW, GL_DYNAMIC_DRAW or
     *         GL_STREAM_DRAW.
     */
    private VertexBufferUsage(int usage)
    {
        this.usage = usage;
    }


    /**
     * Get the integer representing the usage.
     *
     * @return
     *         GL_STATIC_DRAW, GL_DYNAMIC_DRAW or
     *         GL_STREAM_DRAW.
     */
    public int getUsage()
    {
        return usage;
    }
}
