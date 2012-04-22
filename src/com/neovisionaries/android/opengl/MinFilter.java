/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Filters for GL_TEXTURE_MIN_FILTER.
 *
 * @author Takahiko Kawasaki
 *
 * @see Texture2D#setMinFilter(MinFilter)
 * @see TextureCubeMap#setMinFilter(MinFilter)
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glTexParameter.xml">glTexParameter</a>
 */
public enum MinFilter
{
    /**
     * GL_NEAREST.
     */
    NEAREST(GLESFactory.getInstance().GL_NEAREST()),


    /**
     * GL_LINEAR.
     */
    LINEAR(GLESFactory.getInstance().GL_LINEAR()),


    /**
     * GL_NEAREST_MIPMAP_NEAREST.
     */
    NEAREST_MIPMAP_NEAREST(GLESFactory.getInstance().GL_NEAREST_MIPMAP_NEAREST()),


    /**
     * GL_NEAREST_MIPMAP_LINEAR.
     */
    NEAREST_MIPMAP_LINEAR(GLESFactory.getInstance().GL_NEAREST_MIPMAP_LINEAR()),


    /**
     * LINEAR_MIPMAP_NEAREST.
     */
    LINEAR_MIPMAP_NEAREST(GLESFactory.getInstance().GL_LINEAR_MIPMAP_NEAREST()),


    /**
     * LINEAR_MIPMAP_LINEAR.
     */
    LINEAR_MIPMAP_LINEAR(GLESFactory.getInstance().GL_LINEAR_MIPMAP_LINEAR())
    ;


    /**
     * The integer representing this min filter.
     */
    private final int filter;


    /**
     * A constructor with a min filter.
     *
     * @param filter
     *         A mag filter.
     */
    private MinFilter(int filter)
    {
        this.filter = filter;
    }


    /**
     * Get the integer representing this min filter.
     *
     * @return
     *         The integer representing this min filter.
     */
    public int getFilter()
    {
        return filter;
    }
}
