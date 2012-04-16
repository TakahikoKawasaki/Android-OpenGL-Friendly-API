/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL vertex buffer type.
 *
 * @author Takahiko Kawasaki
 */
public enum VertexBufferType
{
    /**
     * Array buffer (GL_ARRAY_BUFFER).
     */
    ARRAY(GLESFactory.getInstance().GL_ARRAY_BUFFER()),


    /**
     * Array element buffer (GL_ELEMENT_ARRAY_BUFFER).
     */
    ELEMENT_ARRAY(GLESFactory.getInstance().GL_ELEMENT_ARRAY_BUFFER())
    ;
    

    /**
     * An integer representing a vertex buffer type.
     */
    private final int type;


    /**
     * A constructor with a vertex buffer type.
     *
     * @param type
     *         GL_ARRAY_BUFFER or GL_ELEMENT_ARRAY_BUFFER.
     */
    private VertexBufferType(int type)
    {
        this.type = type;
    }


    /**
     * Get the integer representing the type of this vertex buffer.
     *
     * @return
     *         GL_ARRAY_BUFFER or GL_ELEMENT_ARRAY_BUFFER.
     */
    public int getType()
    {
        return type;
    }
}
