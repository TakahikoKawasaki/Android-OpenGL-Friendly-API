/*
 * Copyright (C) 2012 Neo Visionaries Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
