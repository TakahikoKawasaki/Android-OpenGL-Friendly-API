/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * State of {@link Program}.
 *
 * @author Takahiko Kawasaki
 */
public enum ProgramState
{
    /**
     * The program needs linking before use.
     *
     * @see Program#Program(Shader...)
     * @see Program#attach(Shader)
     * @see Program#detach(Shader)
     */
    NEEDS_LINKING,


    /**
     * The program has been linked successfully.
     *
     * @see Program#link()
     */
    LINKED,


    /**
     * The program has been deleted.
     *
     * @see Program#delete()
     */
    DELETED
    ;
}
