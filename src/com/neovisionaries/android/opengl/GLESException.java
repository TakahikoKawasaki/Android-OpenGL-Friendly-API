/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL ES exception.
 *
 * @author Takahiko Kawasaki
 */
@SuppressWarnings("serial")
public class GLESException extends Exception
{
    public GLESException()
    {
        super();
    }


    public GLESException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public GLESException(String message)
    {
        super(message);
    }


    public GLESException(Throwable cause)
    {
        super(cause);
    }
}
