/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import android.graphics.Color;


/**
 * Color buffer.
 *
 * @author Takahiko Kawasaki
 */
public final class ColorBuffer
{
    private ColorBuffer()
    {
    }


    /**
     * Set a color used to clear the color buffer
     * (glClearColor() is called).
     *
     * @param red    Red component from 0.0f to 1.0f.
     * @param green  Green component from 0.0f to 1.0f.
     * @param blue   Blue component from 0.0f to 1.0f.
     * @param alpha  Alpha component form 0.0f to 1.0f. 
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClearColor.xml">glClearColor</a>
     */
    public static void setClearColor(float red, float green, float blue, float alpha)
    {
        getGLES().glClearColor(red, green, blue, alpha);
    }


    /**
     * Set a color used to clear the color buffer
     * (glClearColor() is called).
     *
     * @param red    Red component from 0 to 255.
     * @param green  Green component from 0 to 255.
     * @param blue   Blue component from 0 to 255.
     * @param alpha  Alpha component from 0 to 255.
     */
    public static void setClearColor(int red, int green, int blue, int alpha)
    {
        setClearColor(GLESHelper.map255(red),
                      GLESHelper.map255(green),
                      GLESHelper.map255(blue),
                      GLESHelper.map255(alpha));
    }


    /**
     * Set a color used to clear the color buffer
     * (glClearColor() is called).
     *
     * @param argb
     *         An integer that holds alpha, red, green and blue components.
     *         The format is the same as defined by
     *         <a href="http://developer.android.com/reference/android/graphics/Color.html"
     *         >android.graphics.Color</a>.
     *
     * @see <a href="http://developer.android.com/reference/android/graphics/Color.html">android.graphics.Color</a>
     */
    public static void setClearColor(int argb)
    {
        setClearColor(Color.red(argb),
                      Color.green(argb),
                      Color.blue(argb),
                      Color.alpha(argb));
    }


    /**
     * Clear the color buffer (call glClear(GL_COLOR_BUFFER_BIT)).
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClear.xml">glClear</a>
     */
    public static void clear()
    {
        GLES gles = getGLES();

        gles.glClear(gles.GL_COLOR_BUFFER_BIT());
    }


    /**
     * Get an implementation of GLES interface.
     *
     * @return
     *         An object implementing GLES interface.
     */
    private static GLES getGLES()
    {
        return GLESFactory.getInstance();
    }
}
