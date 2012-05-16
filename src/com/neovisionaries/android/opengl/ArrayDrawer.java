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
 * Drawer to draw primitives using glDrawArrays().
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E S</b></span>
 *
 * <span style="color: darkgreen;">// All of the lines below are equivalent to</span>
 * <span style="color: darkgreen;">// glDrawArrays(GL_TRIANGLES, 0, 3).</span>
 *
 * new {@link ArrayDrawer#ArrayDrawer() ArrayDrawer()}.{@link
 * #setMode(DrawingMode) setMode}({@link DrawingMode#TRIANGLES}).{@link
 * #setFirst(int) setFirst}(0).{@link #setCount(int) setCount}(3).{@link #draw()};
 * 
 * new {@link ArrayDrawer#ArrayDrawer(DrawingMode) ArrayDrawer}({@link
 * DrawingMode#TRIANGLES}).{@link #setFirst(int) setFirst}(0).{@link
 * #setCount(int) setCount}(3).{@link #draw()};
 *
 * new {@link ArrayDrawer#ArrayDrawer(DrawingMode, int) ArrayDrawer}({@link
 * DrawingMode#TRIANGLES}, 3).{@link #setFirst(int) setFirst}(0).{@link #draw()};
 *
 * new {@link ArrayDrawer#ArrayDrawer(DrawingMode, int, int) ArrayDrawer}({@link
 * DrawingMode#TRIANGLES}, 0, 3).{@link #draw()};
 * </pre>
 *
 * @author Takahiko Kawasaki
 *
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDrawArrays.xml">glDrawArrays</a>
 */
public class ArrayDrawer extends Drawer<ArrayDrawer>
{
    private int first;
    private int count;


    /**
     * This constructor is an alias of {@link #ArrayDrawer(DrawingMode,
     * int, int) ArrayDrawer}({@link DrawingMode#TRIANGLES}, 0, 0).
     *
     * @see #ArrayDrawer(DrawingMode, int, int)
     */
    public ArrayDrawer()
    {
        this(DrawingMode.TRIANGLES, 0, 0);
    }


    /**
     * This constructor is an alias of {@link #ArrayDrawer(DrawingMode,
     * int, int) ArrayDrawer}(mode, 0, 0).
     *
     * @see #ArrayDrawer(DrawingMode, int, int)
     */
    public ArrayDrawer(DrawingMode mode)
    {
        this(mode, 0, 0);
    }


    /**
     * This constructor is an alias of {@link #ArrayDrawer(DrawingMode,
     * int, int) ArrayDrawer}(mode, 0, count).
     *
     * @see #ArrayDrawer(DrawingMode, int, int)
     */
    public ArrayDrawer(DrawingMode mode, int count)
    {
        this(mode, 0, count);
    }


    /**
     * A constructor.
     *
     * @param mode
     *         A drawing mode.
     *
     * @param first
     *         The index of the first vertex used for drawing in the
     *         vertex array.
     *
     * @param count
     *         The number of vertices used for drawing.
     *
     * @throws IllegalArgumentException
     *         'mode' is null, 'first' is less than 0, or 'count'
     *         is less than 0.
     */
    public ArrayDrawer(DrawingMode mode, int first, int count)
    {
        super(mode);

        if (first < 0 || count < 0)
        {
            throw new IllegalArgumentException();
        }

        this.first = first;
        this.count = count;
    }


    /**
     * Get the index of the first vertex used for drawing.
     *
     * @return
     *         The index of the first vertex used for drawing
     *         in the vertex array.
     */
    public int getFirst()
    {
        return first;
    }


    /**
     * Set the index of the first vertex used for drawing.
     *
     * @param first
     *         The index of the first vertex used for drawing.
     *
     * @return
     *         This ArrayDrawer object.
     *
     * @throws IllegalArgumentException
     *         'first' is less than 0.
     */
    public ArrayDrawer setFirst(int first)
    {
        if (first < 0)
        {
            throw new IllegalArgumentException();
        }

        this.first = first;

        return this;
    }


    /**
     * Get the number of vertices used for drawing.
     *
     * @return
     *         The number of vertices used for drawing.
     */
    public int getCount()
    {
        return count;
    }


    /**
     * Set the number of vertices used for drawing.
     *
     * @param count
     *         The number of vertices used for drawing.
     *
     * @return
     *         This ArrayDrawer object.
     */
    public ArrayDrawer setCount(int count)
    {
        if (count < 0)
        {
            throw new IllegalArgumentException();
        }

        this.count = count;

        return this;
    }


    /**
     * Draw primitives.
     *
     * <p>
     * This method is equlvalent to
     * glDrawArrays({@link #getMode()}.{@link DrawingMode#getMode()
     * getMode()}, {@link #getFirst()}, {@link #getCount()}).
     * </p>
     *
     * @return
     *         This ArrayDrawer object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDrawArrays.xml">glDrawArrays</a>
     */
    @Override
    public ArrayDrawer draw()
    {
        GLESFactory.getInstance().glDrawArrays(
                getMode().getMode(), getFirst(), getCount());

        return this;
    }
}
