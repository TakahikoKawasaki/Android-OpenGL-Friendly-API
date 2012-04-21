/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL ES extension.
 *
 * @author Takahiko Kawasaki
 */
public enum Extension
{
    /**
     * OES_element_index_uint.
     *
     * <p>
     * This extension is needed for GL_UNSIGNED_INT to be accepted
     * as the third argument of glDrawElements(). If this extension
     * is supported, {@link ElementDrawer#setIndices(java.nio.Buffer)}
     * accepts IntBuffer.
     * </p>
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDrawElements.xml">glDrawElements</a>
     */
    OES_element_index_uint
    ;


    private Boolean supported;


    /**
     * Check if this extension is supported.
     *
     * @return
     *         True if this extension is supported.
     */
    public boolean isSupported()
    {
        if (supported == null)
        {
            boolean found = GLESState.getExtensions().contains(name());

            supported = (found ? Boolean.TRUE : Boolean.FALSE);
        }

        return supported.booleanValue();
    }
}
