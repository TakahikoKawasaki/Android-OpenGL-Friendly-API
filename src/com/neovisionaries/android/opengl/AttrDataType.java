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
    BYTE(getGLES().GL_BYTE()),


    /**
     * GL_UNSIGNED_BYTE.
     */
    UNSIGNED_BYTE(getGLES().GL_UNSIGNED_BYTE()),


    /**
     * GL_SHORT.
     */
    SHORT(getGLES().GL_SHORT()),


    /**
     * GL_UNSIGNED_SHORT.
     */
    UNSIGNED_SHORT(getGLES().GL_UNSIGNED_SHORT()),


    /**
     * GL_FLOAT.
     */
    FLOAT(getGLES().GL_FLOAT()),


    /**
     * GL_FIXED.
     */
    FIXED(getGLES().GL_FIXED())
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
     *         One of the following is returned.
     *         <ul>
     *         <li>GL_BYTE
     *         <li>GL_UNSIGNED_BYTE
     *         <li>GL_SHORT
     *         <li>GL_UNSIGNED_SHORT
     *         <li>GL_FLOAT
     *         <li>GL_FIXED
     *         </ul>
     */
    public int getType()
    {
        return type;
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
