/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Filters for GL_TEXTURE_MAG_FILTER.
 *
 * @author Takahiko Kawasaki
 *
 * @see Texture#setMagFilter(MagFilter)
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glTexParameter.xml">glTexParameter</a>
 */
public enum MagFilter
{
    /**
     * GL_NEAREST.
     */
    NEAREST(GLESFactory.getInstance().GL_NEAREST()),


    /**
     * GL_LINEAR.
     */
    LINEAR(GLESFactory.getInstance().GL_LINEAR())
    ;


    /**
     * The integer representing this mag filter.
     */
    private final int filter;


    /**
     * A constructor with a mag filter.
     *
     * @param filter
     *         A mag filter.
     */
    private MagFilter(int filter)
    {
        this.filter = filter;
    }


    /**
     * Get the integer representing this mag filter.
     *
     * @return
     *         The integer representing this mag filter.
     */
    public int getFilter()
    {
        return filter;
    }
}
