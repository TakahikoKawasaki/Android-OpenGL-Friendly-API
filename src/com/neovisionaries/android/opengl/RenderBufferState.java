/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * State of {@link RenderBuffer}.
 *
 * @author Takahiko Kawasaki
 */
public enum RenderBufferState
{
    /**
     * The render buffer has been created.
     *
     * @see RenderBuffer#RederBuffer()
     */
    CREATED,


    /**
     * The render buffer has been deleted.
     *
     * @see RenderBuffer#delete()
     */
    DELETED
    ;
}
