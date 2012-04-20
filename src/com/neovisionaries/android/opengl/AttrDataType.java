/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Data type for {@link Attribute}.
 *
 * @author Takahiko Kawasaki
 */
public enum AttrDataType
{
    /**
     * GL_BYTE.
     */
    BYTE(GLESFactory.getInstance().GL_BYTE()),


    /**
     * GL_UNSIGNED_BYTE.
     */
    UNSIGNED_BYTE(GLESFactory.getInstance().GL_UNSIGNED_BYTE()),


    /**
     * GL_SHORT.
     */
    SHORT(GLESFactory.getInstance().GL_SHORT()),


    /**
     * GL_UNSIGNED_SHORT.
     */
    UNSIGNED_SHORT(GLESFactory.getInstance().GL_UNSIGNED_SHORT()),


    /**
     * GL_FLOAT.
     */
    FLOAT(GLESFactory.getInstance().GL_FLOAT()),


    /**
     * GL_FIXED.
     */
    FIXED(GLESFactory.getInstance().GL_FIXED())
    ;


    /**
     * The integer representing the data type.
     */
    private final int type;


    /**
     * A constructor with a data type.
     *
     * @param type
     *         An integer representing a data type.
     */
    private AttrDataType(int type)
    {
        this.type = type;
    }


    /**
     * Get the integer representing the data type.
     *
     * @return
     *         The integer representing the data type.
     */
    public int getType()
    {
        return type;
    }
}
