/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Format of render buffer.
 *
 * @author Takahiko Kawasaki
 *
 * @see RenderBuffer#setFormat(RenderBufferFormat, int, int)
 */
public enum RenderBufferFormat
{
    /**
     * GL_RGB565.
     */
    RGB565(GLESFactory.getInstance().GL_RGB565()),


    /**
     * GL_RGBA4.
     */
    RGBA4(GLESFactory.getInstance().GL_RGBA4()),


    /**
     * GL_RGB5_A1.
     */
    RGB5_A1(GLESFactory.getInstance().GL_RGB5_A1()),


    /**
     * GL_DEPTH_COMPONENT16.
     */
    DEPTH_COMPONENT16(GLESFactory.getInstance().GL_DEPTH_COMPONENT16()),


    /**
     * GL_STENCIL_INDEX8.
     */
    STENCIL_INDEX8(GLESFactory.getInstance().GL_STENCIL_INDEX8())
    ;


    /**
     * The integer representing this format.
     */
    private final int format;


    /**
     * A constructor with a format.
     *
     * @param format
     *         An integer representing a format.
     */
    private RenderBufferFormat(int format)
    {
        this.format = format;
    }


    /**
     * Get the integer representing this format.
     *
     * @return
     *         The integer representing this format.
     */
    public int getFormat()
    {
        return format;
    }
}
