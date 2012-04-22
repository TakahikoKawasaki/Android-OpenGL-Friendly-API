/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * State of {@link Texture}.
 *
 * @author Takahiko Kawasaki
 */
public enum TextureState
{
    /**
     * The texture has been created.
     *
     * @see Texture#Texture(TextureType)
     */
    CREATED,


    /**
     * The texture has been deleted.
     *
     * @see Texture#delete()
     */
    DELETED
    ;
}
