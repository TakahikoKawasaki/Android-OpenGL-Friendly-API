/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import android.opengl.GLES20;


/**
 * OpenGL shader type.
 *
 * @author Takahiko Kawasaki
 */
public enum ShaderType
{
    /**
     * Vertex shader.
     */
    VERTEX(GLES20.GL_VERTEX_SHADER),


    /**
     * Fragment shader.
     */
    FRAGMENT(GLES20.GL_FRAGMENT_SHADER)
    ;


    /**
     * An integer representing a shader type.
     */
    private final int type;


    /**
     * A constructor with a shader type.
     *
     * @param type
     *         GLES20.GL_VERTEX_SHADER or GLES20.GL_FRAGMENT_SHADER.
     */
    private ShaderType(int type)
    {
        this.type = type;
    }


    /**
     * Get the integer representing the type of this shader.
     *
     * @return
     *         GLES20.GL_VERTEX_SHADER or GLES20.GL_FRAGMENT_SHADER.
     */
    public int getType()
    {
        return type;
    }
}
