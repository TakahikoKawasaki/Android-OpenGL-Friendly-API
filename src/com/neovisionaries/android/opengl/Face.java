/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Face.
 *
 * @author Takahiko Kawasaki
 */
public enum Face
{
    /**
     * GL_FRONT.
     */
    FRONT(GLESFactory.getInstance().GL_FRONT()),


    /**
     * GL_BACK.
     */
    BACK(GLESFactory.getInstance().GL_BACK()),


    /**
     * GL_FRONT_AND_BACK.
     */
    FRONT_AND_BACK(GLESFactory.getInstance().GL_FRONT_AND_BACK());


    /**
     * The integer representing this face.
     */
    private final int face;


    /**
     * A constructor with a face.
     *
     * @param face
     *         A face.
     */
    private Face(int face)
    {
        this.face = face;
    }


    /**
     * Get the integer representing this face.
     *
     * @return
     *         The integer representing this face.
     */
    public int getFace()
    {
        return face;
    }
}
