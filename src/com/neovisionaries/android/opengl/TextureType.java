/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Texture type.
 *
 * @author Takahiko Kawasaki
 */
public enum TextureType
{
    /**
     * GL_TEXTURE_2D.
     */
    TWO_D(GLESFactory.getInstance().GL_TEXTURE_2D()),


    /**
     * GL_TEXTURE_CUBE_MAP.
     */
    CUBE_MAP(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP())
    ;


    /**
     * The integer representing this texture type.
     */
    private final int type;


    /**
     * A constructor with a texture type.
     * @param type
     */
    private TextureType(int type)
    {
        this.type = type;
    }


    /**
     * Get the integer representing this texture type.
     *
     * @return
     *         The integer representing this texture type.
     */
    public int getType()
    {
        return type;
    }
}
