/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * State of {@link Shader}.
 * 
 * @author Takahiko Kawasaki
 */
public enum ShaderState
{
    /**
     * The shader has been created.
     */
    CREATED,


    /**
     * A shader source has been set.
     * 
     * @see Shader#setSource(String)
     */
    SOURCE_SET,


    /**
     * The shader source has been compiled successfully.
     * 
     * @see Shader#compile()
     */
    COMPILED,


    /**
     * The shader has been deleted.
     * 
     * @see Shader#delete()
     */
    DELETED
    ;
}
