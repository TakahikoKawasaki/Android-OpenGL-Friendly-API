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
     * Set color components writable (call glColorMask(red, green, blue, alpha)).
     *
     * @param red
     *         True to set the red component writable.
     *
     * @param green
     *         True to set the green component writable.
     *
     * @param blue
     *         True to set the blue component writable.
     *
     * @param alpha
     *         True to set the alpha component writable.
     *
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glColorMask.xml">glColorMask</a>
     */
    public static void setWritable(boolean red, boolean green, boolean blue, boolean alpha)
    {
        getGLES().glColorMask(red, green, blue, alpha);
    }


    /**
     * Set color components writable.
     *
     * <p>
     * This method calls {@link #setWritable(boolean, boolean, boolean, boolean)
     * setWritable}(masks[0], masks[1], masks[2], masks[3]).
     * </p>
     *
     * @param masks
     *         A boolean array of size 4 (or more). Each element
     *         corresponds to red, green blue and alpha components
     *         from the beginning in this order respectively.
     *         True should be set to make the corresponding color
     *         component writable.
     *
     * @throws IllegalArgumentException
     *         The argument is null or the length of the argument
     *         is less than 4.
     *
     * @see #setWritable(boolean red, boolean green, boolean blue, boolean alpha)
     */
    public static void setWritable(boolean[] masks)
    {
        if (masks == null || masks.length < 4)
        {
            throw new IllegalArgumentException();
        }

        setWritable(masks[0], masks[1], masks[2], masks[3]);
    }


    /**
     * Get the current writable masks of color components.
     *
     * @return
     *         A boolean array of size 4. The values indicate whether
     *         the red, green, blue and alpha components are writable
     *         or not.
     *
     * @see GLESState#getColorWritemask()
     */
    public static boolean[] getWritable()
    {
        return GLESState.getColorWritemask();
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
