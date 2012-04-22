/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Wrap modes for GL_TEXTURE_WRAP_S and GL_TEXTURE_WRAP_T.
 *
 * @author Takahiko Kawasaki
 *
 * @see Texture2D#setWrapS(WrapMode)
 * @see Texture2D#setWrapT(WrapMode)
 * @see TextureCubeMap#setWrapS(WrapMode)
 * @see TextureCubeMap#setWrapT(WrapMode)
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glTexParameter.xml">glTexParameter</a>
 */
public enum WrapMode
{
    /**
     * GL_REPEAT.
     */
    REPEAT(GLESFactory.getInstance().GL_REPEAT()),


    /**
     * GL_CLAMP_TO_EDGE.
     */
    CLAMP_TO_EDGE(GLESFactory.getInstance().GL_CLAMP_TO_EDGE()),


    /**
     * GL_MIRRORED_REPEAT.
     */
    MIRRORED_REPEAT(GLESFactory.getInstance().GL_MIRRORED_REPEAT())
    ;


    /**
     * The integer representing this wrap mode.
     */
    private final int mode;


    /**
     * A constructor with a wrap mode.
     *
     * @param mode
     *         A wrap mode.
     */
    private WrapMode(int mode)
    {
        this.mode = mode;
    }


    /**
     * Get the integer representing this wrap mode.
     *
     * @return
     *         The integer representing this wrap mode.
     */
    public int getMode()
    {
        return mode;
    }
}
