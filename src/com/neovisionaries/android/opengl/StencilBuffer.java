/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Stencil buffer.
 *
 * @author Takahiko Kawasaki
 */
public final class StencilBuffer
{
    private StencilBuffer()
    {
    }


    /**
     * Set a stencil value used to clear the stencil buffer
     * (call glClearStencil(stencil)).
     *
     * @param stencil
     *         A stencil value used to clear the stencil buffer.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClearStencil.xml">glClearStencil</a>
     */
    public static void setClearStencil(int stencil)
    {
        getGLES().glClearStencil(stencil);
    }


    /**
     * Clear the stencil buffer (call glClear(GL_STENCIL_BUFFER_BIT)).
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClear.xml">glClear</a>
     */
    public static void clear()
    {
        GLES gles = getGLES();

        gles.glClear(gles.GL_STENCIL_BUFFER_BIT());
    }


    /**
     * Set a bit mask to enable and disable writing of individual
     * bits in the stencil planes.
     *
     * <p>
     * glStencilMask(stencilMask) is called.
     * </p>
     *
     * @param stencilMask
     *         A bit mask.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilMask.xml">glStencilMask</a>
     */
    public static void setWritable(int stencilMask)
    {
        getGLES().glStencilMask(stencilMask);
    }


    /**
     * Set a bit mask to enable and disable writing of individual
     * bits in the stencil planes for the specified face.
     *
     * <p>
     * If the OpenGL ES version is equal to or greater than 2.0,
     * this method executes glStencilMaskSeparate(face.{@link
     * Face#getFace() getFace()}, stencilMask). Otherwise, this
     * method executes glStencilMask(stencilMask) unless the
     * specified face is {@link Face#BACK}.
     * </p>
     *
     * @param stencilMask
     *         A bit mask.
     *
     * @param face
     *         A face to set the bit mask. If null is given, {@link
     *         Face#FRONT_AND_BACK} is used. If {@link Face#BACK}
     *         is given but the major version number of the underlying
     *         OpenGL ES implementation is less than 2, this method
     *         does nothing.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilMask.xml">glStencilMask</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilMaskSeparate.xml">glStencilMaskSeparate</a>
     */
    public static void setWritable(int stencilMask, Face face)
    {
        GLES gles = getGLES();
        boolean es2 = (2 <= gles.getMajorVersion());

        if (face == null)
        {
            face = Face.FRONT_AND_BACK;
        }

        if (es2)
        {
            gles.glStencilMaskSeparate(face.getFace(), stencilMask);
        }
        else if (face != Face.BACK)
        {
            gles.glStencilMask(stencilMask);
        }
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
