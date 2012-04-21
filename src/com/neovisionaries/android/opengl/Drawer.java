/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * The base class for {@link ArrayDrawer} and {@link ElementDrawer}.
 *
 * @author Takahiko Kawasaki
 *
 * @see ArrayDrawer
 * @see ElementDrawer
 */
public abstract class Drawer<TDrawer extends Drawer<TDrawer>>
{
    private DrawingMode mode;


    /**
     * This constructor is an alias of {@link #Drawer(DrawingMode)
     * Drawer}({@link DrawingMode#TRIANGLES}).
     */
    protected Drawer()
    {
        this(DrawingMode.TRIANGLES);
    }


    /**
     * A constructor with a drawing mode.
     *
     * @param mode
     *         A drawing mode.
     *
     * @throws IllegalArgumentException
     *         The given argument is null.
     */
    protected Drawer(DrawingMode mode)
    {
        if (mode == null)
        {
            throw new IllegalArgumentException("mode is null.");
        }

        this.mode = mode;
    }


    /**
     * Get the drawing mode.
     *
     * @return
     *         The drawing mode.
     */
    public DrawingMode getMode()
    {
        return mode;
    }


    /**
     * Set the drawing mode.
     *
     * @param mode
     *         A drawing mode.
     *
     * @return
     *         This object.
     */
    @SuppressWarnings("unchecked")
    public TDrawer setMode(DrawingMode mode)
    {
        if (mode == null)
        {
            throw new IllegalArgumentException("mode is null.");
        }

        return (TDrawer)this;
    }


    /**
     * Draw primitives.
     *
     * @return
     *         This object.
     */
    public abstract TDrawer draw();
}
