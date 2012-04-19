/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Data size for {@link Attribute}.
 *
 * @author Takahiko Kawasaki
 */
public enum AttrDataSize
{
    /**
     * 1.
     */
    ONE(1),


    /**
     * 2.
     */
    TWO(2),


    /**
     * 3.
     */
    THREE(3),


    /**
     * 4.
     */
    FOUR(4);


    /**
     * Size.
     */
    private final int size;


    /**
     * An constructor with size.
     *
     * @param size
     */
    private AttrDataSize(int size)
    {
        this.size = size;
    }


    /**
     * Get the size.
     *
     * @return
     *         The size.
     */
    public int getSize()
    {
        return size;
    }
}
