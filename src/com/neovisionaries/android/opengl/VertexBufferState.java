/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * State of {@link VertexBuffer}.
 *
 * @author Takahiko Kawasaki
 */
public enum VertexBufferState
{
    /**
     * The vertex buffer has been created.
     *
     * @see VertexBuffer#VertexBuffer(VertexBufferType)
     */
    CREATED,


    /**
     * The vertex buffer has been deleted.
     *
     * @see VertexBuffer#delete()
     */
    DELETED
    ;
}
