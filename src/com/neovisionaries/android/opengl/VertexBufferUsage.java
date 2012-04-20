/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL ES vertex buffer usage.
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
     *
     * <p>
     * Note that GL_STREAM_DRAW is not available in OpenGL ES 1.x.
     * </p>
     */
    STREAM(GLESFactory.getInstance().GL_STREAM_DRAW())
    ;


    /**
     * An integer representing vertex buffer usage.
     */
    private final int usage;


    /**
     * A constructor with usage.
     *
     * @param usage
     *         An integer representing usage.
     */
    private VertexBufferUsage(int usage)
    {
        this.usage = usage;
    }


    /**
     * Get the integer representing this usage.
     *
     * @return
     *         The integer representing this usage.
     */
    public int getUsage()
    {
        return usage;
    }
}
