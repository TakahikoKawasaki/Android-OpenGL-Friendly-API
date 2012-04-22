/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Depth buffer.
 *
 * @author Takahiko Kawasaki
 */
public final class DepthBuffer
{
    private DepthBuffer()
    {
    }


    /**
     * Set the depth used to clear the depth buffer
     * (call glClearDepthf(depth)).
     *
     * @param depth
     *         The depth used to clear the depth buffer.
     *         From 0.0f to 1.0f.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClearDepthf.xml">glClearDepthf</a>
     */
    public static void setClearDepth(float depth)
    {
        getGLES().glClearDepthf(depth);
    }


    /**
     * Clear the depth buffer (call glClear(GL_DEPTH_BUFFER_BIT)).
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClear.xml">glClear</a>
     */
    public static void clear()
    {
        GLES gles = getGLES();

        gles.glClear(gles.GL_DEPTH_BUFFER_BIT());
    }


    /**
     * Set the depth buffer writable (call glDepthMask(writable)).
     *
     * @param writable
     *         True to make the depth buffer writable.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDepthMask.xml">glDepthMask</a>
     */
    public static void setWritable(boolean writable)
    {
        getGLES().glDepthMask(writable);
    }


    /**
     * Check if the depth buffer is writable.
     *
     * @return
     *         True if the depth buffer is writable.
     *
     * @see GLESState#getDepthWritemask()
     */
    public static boolean isWritable()
    {
        return GLESState.getDepthWritemask();
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
