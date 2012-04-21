/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL ES viewport
 *
 * @author Takahiko Kawasaki
 *
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glViewport.xml">glViewport</a>
 */
public final class Viewport
{
    private Viewport()
    {
    }


    /**
     * Call glViewport(x, y, width, height).
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glViewport.xml">glViewport</a>
     */
    public static void set(int x, int y, int width, int height)
    {
        GLESFactory.getInstance().glViewport(x, y, width, height);
    }


    /**
     * This method is an alias of {@link #set(int, int, int, int)
     * set}(0, 0, width, height).
     *
     * @see #set(int x, int y, int width, int height)
     */
    public static void set(int width, int height)
    {
        set(0, 0, width, height);
    }
}
