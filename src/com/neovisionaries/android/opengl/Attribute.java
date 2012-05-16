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


import java.nio.Buffer;
import java.nio.FloatBuffer;


/**
 * OpenGL ES vertex attribute.
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E   1</b></span>
 *
 * <span style="color: darkgreen;">// Create an Attribute instance of the vertex array at</span>
 * <span style="color: darkgreen;">// the index '0'.</span>
 * {@link Attribute} attr = new {@link #Attribute(int) Attribute}(0);
 *
 * <span style="color: darkgreen;">// Set a constant value (1.0f, 0.0f, 0.0f, 1.0f).</span>
 * <span style="color: darkgreen;">// As a side effect, the vertex array for the index '0'</span>
 * <span style="color: darkgreen;">// is disabled by glDisableVertexAttribArray() because</span>
 * <span style="color: darkgreen;">// otherwise the data set here will not take effect.</span>
 * attr.{@link #set(float, float, float, float) set}(1.0f, 0.0f, 0.0f, 1.0f);
 *
 * <span style="color: darkgreen;">// Get a shader program instance from somewhere.</span>
 * {@link Program} program = ...;
 *
 * <span style="color: darkgreen;">// Feed data to the attribute variable 'a_color'.</span>
 * program.{@link Program#setAttribute(String, Attribute) setAttribute}("a_color", attr);
 * </pre>
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E   2</b></span>
 *
 * <span style="color: darkgreen;">// Prepare position data in the form of (x0, y0, z0),</span>
 * <span style="color: darkgreen;">// (x1, y1, z1), (x2, y2, z2), ...</span>
 * FloatBuffer positions = ...;
 *
 * <span style="color: darkgreen;">// Get a shader program instance from somewhere.</span>
 * {@link Program} program = ...;
 *
 * <span style="color: darkgreen;">// Get an Attribute instance for an attribute variable</span>
 * <span style="color: darkgreen;">// named 'a_position'.</span>
 * {@link Attribute} attr = program.{@link Program#getAttribute(String) getAttribute}("a_position");
 *
 * <span style="color: darkgreen;">// Feed data to the attribute variable. As side effects,</span>
 * <span style="color: darkgreen;">// the vertex array for the index of the attribute is enabled</span>
 * <span style="color: darkgreen;">// by glEnableVertexAttribArray() and the vertex array buffer</span>
 * <span style="color: darkgreen;">// is unbound by calling glBindBuffer(GL_ARRAY_BUFFER, 0)</span>
 * <span style="color: darkgreen;">// because otherwise the data set here will not take effect.</span>
 * attr.{@link #setArray3(FloatBuffer) setArray3}(positions);
 * </pre>
 *
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E   3</b></span>
 *
 * <span style="color: darkgreen;">// Prepare position data in the form of (x0, y0, z0),</span>
 * <span style="color: darkgreen;">// (x1, y1, z1), (x2, y2, z2), ...</span>
 * FloatBuffer positions = ...;
 *
 * <span style="color: darkgreen;">// Store the position data to the vertex array buffer.</span>
 * {@link ArrayBuffer} ab = new {@link ArrayBuffer#ArrayBuffer() ArrayBuffer()};
 * ab.{@link VertexBuffer#setData(Buffer) setData}(positions);
 *
 * <span style="color: darkgreen;">// Get an Attribute instance from somewhere.</span>
 * {@link Attribute} attr = ...;
 *
 * <span style="color: darkgreen;">// Make the Attribute instance use the vertex array buffer.</span>
 * <span style="color: darkgreen;">// As side effects, the vertex array for the index of the</span>
 * <span style="color: darkgreen;">// attribute is enabled by glEnableVertexAttribArray() and</span>
 * <span style="color: darkgreen;">// the vertex array buffer is bound by calling ab.bind()</span>
 * <span style="color: darkgreen;">// which is equivalent to glBindBuffer(GL_ARRAY_BUFFER, ab.getId()).</span>
 * <span style="color: darkgreen;">// </span>
 * <span style="color: darkgreen;">// Note that the method call below will throw UnsupportedOperationException</span>
 * <span style="color: darkgreen;">// in Android 2.2 (API Level 8) because android.opengl.GLES20</span>
 * <span style="color: darkgreen;">// class does not have glVertexAttribPointer() method whose</span>
 * <span style="color: darkgreen;">// last argument is 'int offset' although it should have.</span>
 * attr.{@link #setArray3(ArrayBuffer) setArray3}(ab);
 * </pre>
 *
 * @author Takahiko Kawasaki
 */
public class Attribute
{
    private final int index;


    /**
     * A constructor with a vertex attribute index.
     *
     * @param index
     *         A vertex attribute index.
     */
    public Attribute(int index)
    {
        this.index = index;
    }


    /**
     * Get the index of this vertex attribute.
     *
     * @return
     *         The index of this vertex attribute.
     */
    public int getIndex()
    {
        return index;
    }


    /**
     * Set a constant value to this vertex attribute by
     * glVertexAttrib1f(). As a side effect, the vertex
     * array is disabled by glDisableVertexAttribArray().
     *
     * @param x
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib1f</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    public Attribute set(float x)
    {
        getGLES().glVertexAttrib1f(index, x);

        return disableArray();
    }


    /**
     * Set a constant value to this vertex attribute by
     * glVertexAttrib2f(). As a side effect, the vertex
     * array is disabled by glDisableVertexAttribArray().
     *
     * @param x
     * @param y
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib2f</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    public Attribute set(float x, float y)
    {
        getGLES().glVertexAttrib2f(index, x, y);

        return disableArray();
    }


    /**
     * Set a constant value to this vertex attribute by
     * glVertexAttrib3f(). As a side effect, the vertex
     * array is disabled by glDisableVertexAttribArray().
     *
     * @param x
     * @param y
     * @param z
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib3f</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    public Attribute set(float x, float y, float z)
    {
        getGLES().glVertexAttrib3f(index, x, y, z);

        return disableArray();
    }


    /**
     * Set a constant value to this vertex attribute by
     * glVertexAttrib4f(). As a side effect, the vertex
     * array is disabled by glDisableVertexAttribArray().
     *
     * @param x
     * @param y
     * @param z
     * @param w
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib4f</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    public Attribute set(float x, float y, float z, float w)
    {
        getGLES().glVertexAttrib4f(index, x, y, z, w);

        return disableArray();
    }


    /**
     * Set a constant value to this vertex attribute by
     * glVertexAttrib1fv(). As a side effect, the vertex
     * array is disabled by glDisableVertexAttribArray().
     * 
     * @param values
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib1fv</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    public Attribute set1(float[] values, int offset)
    {
        getGLES().glVertexAttrib1fv(index, values, offset);

        return disableArray();
    }


    /**
     * This method is an alias of {@link #set1(float[], int)
     * set1}(values, 0).
     *
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @see #set1(float[], int)
     */
    public Attribute set1(float[] values)
    {
        return set1(values, 0);
    }


    /**
     * Set a constant value to this vertex attribute by
     * glVertexAttrib1fv(). As a side effect, the vertex
     * array is disabled by glDisableVertexAttribArray().
     * 
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib1fv</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    public Attribute set1(FloatBuffer values)
    {
        getGLES().glVertexAttrib1fv(index, values);

        return disableArray();
    }


    /**
     * Set a constant value to this vertex attribute by
     * glVertexAttrib2fv(). As a side effect, the vertex
     * array is disabled by glDisableVertexAttribArray().
     * 
     * @param values
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib2fv</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    public Attribute set2(float[] values, int offset)
    {
        getGLES().glVertexAttrib2fv(index, values, offset);

        return disableArray();
    }


    /**
     * This method is an alias of {@link #set2(float[], int)
     * set2}(values, 0).
     *
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @see #set2(float[], int)
     */
    public Attribute set2(float[] values)
    {
        return set2(values, 0);
    }


    /**
     * Set a constant value to this vertex attribute by
     * glVertexAttrib2fv(). As a side effect, the vertex
     * array is disabled by glDisableVertexAttribArray().
     * 
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib2fv</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    public Attribute set2(FloatBuffer values)
    {
        getGLES().glVertexAttrib2fv(index, values);

        return disableArray();
    }


    /**
     * Set a constant value to this vertex attribute by
     * glVertexAttrib3fv(). As a side effect, the vertex
     * array is disabled by glDisableVertexAttribArray().
     * 
     * @param values
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib3fv</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    public Attribute set3(float[] values, int offset)
    {
        getGLES().glVertexAttrib3fv(index, values, offset);

        return disableArray();
    }


    /**
     * This method is an alias of {@link #set3(float[], int)
     * set3}(values, 0).
     *
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @see #set3(float[], int)
     */
    public Attribute set3(float[] values)
    {
        return set3(values, 0);
    }


    /**
     * Set a constant value to this vertex attribute by
     * glVertexAttrib3fv(). As a side effect, the vertex
     * array is disabled by glDisableVertexAttribArray().
     * 
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib3fv</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    public Attribute set3(FloatBuffer values)
    {
        getGLES().glVertexAttrib3fv(index, values);

        return disableArray();
    }


    /**
     * Set a constant value to this vertex attribute by
     * glVertexAttrib4fv(). As a side effect, the vertex
     * array is disabled by glDisableVertexAttribArray().
     * 
     * @param values
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib4fv</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    public Attribute set4(float[] values, int offset)
    {
        getGLES().glVertexAttrib4fv(index, values, offset);

        return disableArray();
    }


    /**
     * This method is an alias of {@link #set4(float[], int)
     * set4}(values, 0).
     *
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @see #set4(float[], int)
     */
    public Attribute set4(float[] values)
    {
        return set4(values, 0);
    }


    /**
     * Set a constant value to this vertex attribute by
     * glVertexAttrib4fv(). As a side effect, the vertex
     * array is disabled by glDisableVertexAttribArray().
     * 
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib4fv</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    public Attribute set4(FloatBuffer values)
    {
        getGLES().glVertexAttrib4fv(index, values);

        return disableArray();
    }


    /**
     * Set a constant value to this vertex attribute. This
     * method calls another setter method depending on the
     * size of the given values. The following table shows
     * pairs of size and method.
     *
     * <br/><br/>
     * <table border="1" cellpadding="5" style="border-collapse: collapse;">
     * <tr style="background-color: lightgray;">
     *   <th>values.length</th> <th>Method to call</th>
     * </tr>
     * <tr>
     *   <td align="center">1</td> <td>{@link #set1(float[]) set1}(values)</td>
     * </tr>
     * <tr>
     *   <td align="center">2</td> <td>{@link #set2(float[]) set2}(values)</td>
     * </tr>
     * <tr>
     *   <td align="center">3</td> <td>{@link #set3(float[]) set3}(values)</td>
     * </tr>
     * <tr>
     *   <td align="center">4</td> <td>{@link #set4(float[]) set4}(values)</td>
     * </tr>
     * </table>
     *
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @throws IllegalArgumentException
     *         The argument is null, or its length is none of
     *         the ones listed in the above table.
     */
    public Attribute set(float[] values)
    {
        if (values == null)
        {
            throw new IllegalArgumentException();
        }

        switch (values.length)
        {
            case 1:
                return set1(values);

            case 2:
                return set2(values);

            case 3:
                return set3(values);

            case 4:
                return set4(values);

            default:
                throw new IllegalArgumentException();
        }
    }


    /**
     * Set a constant value to this vertex attribute. This
     * method calls another setter method depending on the
     * number of the remaining elements in the given values.
     * The following table shows pairs of number and method.
     *
     * <br/><br/>
     * <table border="1" cellpadding="5" style="border-collapse: collapse;">
     * <tr style="background-color: lightgray;">
     *   <th>values.remaining()</th> <th>Method to call</th>
     * </tr>
     * <tr>
     *   <td align="center">1</td> <td>{@link #set1(FloatBuffer) set1}(values)</td>
     * </tr>
     * <tr>
     *   <td align="center">2</td> <td>{@link #set2(FloatBuffer) set2}(values)</td>
     * </tr>
     * <tr>
     *   <td align="center">3</td> <td>{@link #set3(FloatBuffer) set3}(values)</td>
     * </tr>
     * <tr>
     *   <td align="center">4</td> <td>{@link #set4(FloatBuffer) set4}(values)</td>
     * </tr>
     * </table>
     *
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @throws IllegalArgumentException
     *         The argument is null, or its length is none of
     *         the ones listed in the above table.
     */
    public Attribute set(FloatBuffer values)
    {
        if (values == null)
        {
            throw new IllegalArgumentException();
        }

        switch (values.remaining())
        {
            case 1:
                return set1(values);

            case 2:
                return set2(values);

            case 3:
                return set3(values);

            case 4:
                return set4(values);

            default:
                throw new IllegalArgumentException();
        }
    }


    /**
     * Set a vertex array to this vertex attribute by glVertexAttribPointer().
     * Below are important side effects that are necessary to make the given
     * 'value' take effect.
     *
     * <ol>
     * <li>The vertex array buffer is unbound by calling glBindBuffer(GL_ARRAY_BUFFER, 0).
     * <li>The vertex array for the index of this vertex attribute is enabled
     *     by glEnableVertexAttribArray().
     * </ol>
     *
     * @param values
     *         Data to set to this vertex attribute.
     *
     * @param size
     *         The number of elements per one set of data.
     *         From {@link AttrDataSize#ONE ONE} to {@link AttrDataSize#FOUR FOUR}.
     *
     * @param type
     *         The type of the data. Possible values are
     *         {@link AttrDataType#BYTE BYTE},
     *         {@link AttrDataType#UNSIGNED_BYTE UNSIGNED_BYTE},
     *         {@link AttrDataType#SHORT SHORT},
     *         {@link AttrDataType#UNSIGNED_SHORT UNSIGNED_SHORT},
     *         {@link AttrDataType#FLOAT FLOAT} and
     *         {@link AttrDataType#FIXED FIXED}.
     *         Null can be given only when 'values' is an instance of {@link FloatBuffer},
     *         and in the case, {@link AttrDataType#FLOAT} is used.
     *
     * @param normalized
     *         True to normalize data when they are used. This parameter does
     *         not take any effect if 'type' is {@link AttrDataType#FLOAT}.
     *
     * @param stride
     *         The number of elements between the start of one data set
     *         and the start of the next data set. Note that the unit
     *         is not 'bytes'. The size (in bytes) that is passed to
     *         the underlying glVertexAttribPointer() implementation is
     *         calculated in this method based on the actual type of the
     *         given 'values'. For example, if the actual type of 'values'
     *         is FloatBuffer, (stride * 4) is passed to glVertexAttribPointer().
     *
     * @return
     *         This Attribute object.
     *
     * @throws IllegalArgumentException
     *         'values', 'size', or 'type' is null. Or 'stride' is less
     *         than 0. Note that, however, if 'values' is an instance of
     *         {@link FloatBuffer}, 'type' can be null.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttribPointer.xml">glVertexAttribPointer</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glEnableVertexAttribArray.xml">glEnableVertexAttribArray</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindBuffer.xml">glBindBuffer</a>
     */
    public Attribute setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
    {
        if (values == null || size == null || stride < 0)
        {
            throw new IllegalArgumentException();
        }

        if (type == null)
        {
            // Try to guess the data type.
            if (values instanceof FloatBuffer)
            {
                type = AttrDataType.FLOAT;
            }
            else
            {
                throw new IllegalArgumentException("Cannot guess AttrDataType.");
            }
        }

        // Unbind the vertex array buffer.
        ArrayBuffer.unbind();

        // Enable the vertex array for the index of this vertex attribute.
        enableArray();

        // Get the elements size (in bytes) of the data.
        int unit = GLESHelper.getElementSizeInBytes(values);

        getGLES().glVertexAttribPointer(index, size.getSize(), type.getType(), normalized, stride * unit, values);

        return this;
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, size, type, normalized, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized)
    {
        return setArray(values, size, type, normalized, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, size, type, false, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray(Buffer values, AttrDataSize size, AttrDataType type)
    {
        return setArray(values, size, type, false, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#ONE},
     * type, normalized, stride).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray1(Buffer values, AttrDataType type, boolean normalized, int stride)
    {
        return setArray(values, AttrDataSize.ONE, type, normalized, stride);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#ONE},
     * type, normalized, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray1(Buffer values, AttrDataType type, boolean normalized)
    {
        return setArray1(values, type, normalized, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#ONE},
     * type, false, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray1(Buffer values, AttrDataType type)
    {
        return setArray1(values, type, false, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#TWO},
     * type, normalized, stride).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray2(Buffer values, AttrDataType type, boolean normalized, int stride)
    {
        return setArray(values, AttrDataSize.TWO, type, normalized, stride);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#TWO},
     * type, normalized, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray2(Buffer values, AttrDataType type, boolean normalized)
    {
        return setArray2(values, type, normalized, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#TWO},
     * type, false, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray2(Buffer values, AttrDataType type)
    {
        return setArray2(values, type, false, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#THREE},
     * type, normalized, stride).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray3(Buffer values, AttrDataType type, boolean normalized, int stride)
    {
        return setArray(values, AttrDataSize.THREE, type, normalized, stride);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#THREE},
     * type, normalized, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray3(Buffer values, AttrDataType type, boolean normalized)
    {
        return setArray3(values, type, normalized, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#THREE},
     * type, false, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray3(Buffer values, AttrDataType type)
    {
        return setArray3(values, type, false, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#FOUR},
     * type, normalized, stride).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray4(Buffer values, AttrDataType type, boolean normalized, int stride)
    {
        return setArray(values, AttrDataSize.FOUR, type, normalized, stride);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#FOUR},
     * type, normalized, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray4(Buffer values, AttrDataType type, boolean normalized)
    {
        return setArray4(values, type, normalized, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#FOUR},
     * type, false, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray4(Buffer values, AttrDataType type)
    {
        return setArray4(values, type, false, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, size,
     * {@link AttrDataType#FLOAT}, false, stride).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray(FloatBuffer values, AttrDataSize size, int stride)
    {
        return setArray(values, size, AttrDataType.FLOAT, false, stride);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, size,
     * {@link AttrDataType#FLOAT}, false, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray(FloatBuffer values, AttrDataSize size)
    {
        return setArray(values, size, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#ONE},
     * {@link AttrDataType#FLOAT}, false, stride).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray1(FloatBuffer values, int stride)
    {
        return setArray(values, AttrDataSize.ONE, AttrDataType.FLOAT, false, stride);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#ONE},
     * {@link AttrDataType#FLOAT}, false, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray1(FloatBuffer values)
    {
        return setArray1(values, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#TWO},
     * {@link AttrDataType#FLOAT}, false, stride).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray2(FloatBuffer values, int stride)
    {
        return setArray(values, AttrDataSize.TWO, AttrDataType.FLOAT, false, stride);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#TWO},
     * {@link AttrDataType#FLOAT}, false, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray2(FloatBuffer values)
    {
        return setArray2(values, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#THREE},
     * {@link AttrDataType#FLOAT}, false, stride).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray3(FloatBuffer values, int stride)
    {
        return setArray(values, AttrDataSize.THREE, AttrDataType.FLOAT, false, stride);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#THREE},
     * {@link AttrDataType#FLOAT}, false, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray3(FloatBuffer values)
    {
        return setArray3(values, 0);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#FOUR},
     * {@link AttrDataType#FLOAT}, false, stride).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray4(FloatBuffer values, int stride)
    {
        return setArray(values, AttrDataSize.FOUR, AttrDataType.FLOAT, false, stride);
    }


    /**
     * This method is an alias of {@link #setArray(Buffer values,
     * AttrDataSize size, AttrDataType type, boolean normalized,
     * int stride) setArray}(values, {@link AttrDataSize#FOUR},
     * {@link AttrDataType#FLOAT}, false, 0).
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(Buffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
     */
    public Attribute setArray4(FloatBuffer values)
    {
        return setArray4(values, 0);
    }


    /**
     * Set a vertex array to this vertex attribute by glVertexAttribPointer().
     * Below are important side effects that are necessary to make the given
     * 'value' take effect.
     *
     * <ol>
     * <li>The vertex array buffer is bound by calling {@link VertexBuffer#bind()
     *     bind()} method of the given 'values'. This has the same effect as
     *     glBindBuffer(GL_ARRAY_BUFFER, values.{@link VertexBuffer#getId()}).
     * <li>The vertex array for the index of this vertex attribute is enabled
     *     by glEnableVertexAttribArray().
     * </ol>
     *
     * <p>
     * Important Note: This method will throw an UnsupportedOperationException
     * in Android 2.2 (API Level 8). It is because
     * <a href="http://developer.android.com/reference/android/opengl/GLES20.html"
     * >android.opengl.GLES20</a> class does not have glVertexAttribPointer()
     * method whose last parameter is 'int offset' although it should have.
     * </p>
     *
     * @param values
     *         Data to set to this vertex attribute.
     *
     * @param size
     *         The number of elements per one set of data.
     *         From {@link AttrDataSize#ONE ONE} to {@link AttrDataSize#FOUR FOUR}.
     *
     * @param type
     *         The type of the data. Possible values are
     *         {@link AttrDataType#BYTE BYTE},
     *         {@link AttrDataType#UNSIGNED_BYTE UNSIGNED_BYTE},
     *         {@link AttrDataType#SHORT SHORT},
     *         {@link AttrDataType#UNSIGNED_SHORT UNSIGNED_SHORT},
     *         {@link AttrDataType#FLOAT FLOAT} and
     *         {@link AttrDataType#FIXED FIXED}.
     *         Null can be given only when data held by 'values' is a float
     *         array, and in the case, {@link AttrDataType#FLOAT} is used.
     *
     * @param normalized
     *         True to normalize data when they are used. This parameter does
     *         not take any effect if 'type' is {@link AttrDataType#FLOAT}.
     *
     * @param stride
     *         The number of elements between the start of one data set
     *         and the start of the next data set. Note that the unit
     *         is not 'bytes'. The size (in bytes) that is passed to
     *         the underlying glVertexAttribPointer() implementation is
     *         calculated in this method based on the actual type of the
     *         data that has been set to 'values' in advance by
     *         {@link VertexBuffer#setData(Buffer, int, VertexBufferUsage)
     *         setData()} method of 'values'. For example, if a FloatBuffer
     *         instance has been set by calling values.{@link
     *         VertexBuffer#setData(Buffer) setData}(data), in advance,
     *         (stride * 4) is passed to glVertexAttribPointer() in the
     *         implementation of this setArray method. To private necessary
     *         information for this caluculation, {@link VertexBuffer}
     *         class remembers the class type of the given data every time
     *         {@link VertexBuffer#setData(Buffer, int, VertexBufferUsage)
     *         setData()} method is called.
     *
     * @param offset
     *         Data offset in 'values'.
     *
     * @return
     *         This Attribute object.
     *
     * @throws IllegalArgumentException
     *         'values', 'size', or 'type' is null. Or 'stride' is less
     *         than 0. Note that, however, if data held by 'values' is
     *         a float array, 'type' can be null.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttribPointer.xml">glVertexAttribPointer</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glEnableVertexAttribArray.xml">glEnableVertexAttribArray</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindBuffer.xml">glBindBuffer</a>
     */
    public Attribute setArray(ArrayBuffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride, int offset)
    {
        if (values == null || size == null || stride < 0)
        {
            throw new IllegalArgumentException();
        }

        if (type == null)
        {
            // Guess the data type.
            if (values.getDataBufferClass().equals(FloatBuffer.class))
            {
                type = AttrDataType.FLOAT;
            }
            else
            {
                throw new IllegalArgumentException("Cannot guess AttrDataType.");
            }
        }

        // Enable the vertex array for the index of this vertex attribute.
        enableArray();

        // Bind the vertex array buffer.
        values.bind();

        // Get the elements size (in bytes) of the data.
        int unit = GLESHelper.getElementSizeInBytes(values.getDataBufferClass());

        getGLES().glVertexAttribPointer(index, size.getSize(), type.getType(), normalized, stride * unit, offset);

        return this;
        
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, size, null,
     * normalized, stride, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     *
     * @param values
     * @param size
     * @param normalized
     * @param stride
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray(ArrayBuffer values, AttrDataSize size, boolean normalized, int stride, int offset)
    {
        return setArray(values, size, null, normalized, stride, offset);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, size, type,
     * normalized, stride, 0).
     *
     * @param values
     * @param size
     * @param type
     * @param normalized
     * @param stride
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray(ArrayBuffer values, AttrDataSize size, AttrDataType type, boolean normalized, int stride)
    {
        return setArray(values, size, type, normalized, stride, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, size, null,
     * normalized, stride, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     *
     * @param values
     * @param size
     * @param normalized
     * @param stride
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray(ArrayBuffer values, AttrDataSize size, boolean normalized, int stride)
    {
        return setArray(values, size, null, normalized, stride, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, size, type,
     * normalized, 0, 0).
     *
     * @param values
     * @param size
     * @param type
     * @param normalized
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray(ArrayBuffer values, AttrDataSize size, AttrDataType type, boolean normalized)
    {
        return setArray(values, size, type, normalized, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, size, null,
     * normalized, 0, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     *
     * @param values
     * @param size
     * @param normalized
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray(ArrayBuffer values, AttrDataSize size, boolean normalized)
    {
        return setArray(values, size, null, normalized, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, size, type,
     * false, 0, 0).
     *
     * @param values
     * @param size
     * @param type
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray(ArrayBuffer values, AttrDataSize size, AttrDataType type)
    {
        return setArray(values, size, type, false, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, size, null, false, 0, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     *
     * @param values
     * @param size
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray(ArrayBuffer values, AttrDataSize size)
    {
        return setArray(values, size, null, false, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#ONE},
     * type, normalized, stride, offset).
     *
     * @param values
     * @param type
     * @param normalized
     * @param stride
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray1(ArrayBuffer values, AttrDataType type, boolean normalized, int stride, int offset)
    {
        return setArray(values, AttrDataSize.ONE, type, normalized, stride, offset);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#ONE},
     * null, normalized, stride, offset).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     *
     * @param values
     * @param normalized
     * @param stride
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray1(ArrayBuffer values, boolean normalized, int stride, int offset)
    {
        return setArray(values, AttrDataSize.ONE, null, normalized, stride, offset);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#ONE},
     * type, normalized, stride, 0).
     * 
     * @param values
     * @param type
     * @param normalized
     * @param stride
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray1(ArrayBuffer values, AttrDataType type, boolean normalized, int stride)
    {
        return setArray(values, AttrDataSize.ONE, type, normalized, stride, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#ONE},
     * null, normalized, stride, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     * 
     * @param values
     * @param normalized
     * @param stride
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray1(ArrayBuffer values, boolean normalized, int stride)
    {
        return setArray(values, AttrDataSize.ONE, null, normalized, stride, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#ONE},
     * type, normalized, 0, 0).
     * 
     * @param values
     * @param type
     * @param normalized
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray1(ArrayBuffer values, AttrDataType type, boolean normalized)
    {
        return setArray(values, AttrDataSize.ONE, type, normalized, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#ONE},
     * null, normalized, 0, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     * 
     * @param values
     * @param normalized
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray1(ArrayBuffer values, boolean normalized)
    {
        return setArray(values, AttrDataSize.ONE, null, normalized, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#ONE},
     * type, false, 0, 0).
     * 
     * @param values
     * @param type
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray1(ArrayBuffer values, AttrDataType type)
    {
        return setArray(values, AttrDataSize.ONE, type, false, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#ONE},
     * null, false, 0, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     * 
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray1(ArrayBuffer values)
    {
        return setArray(values, AttrDataSize.ONE, null, false, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#TWO},
     * type, normalized, stride, offset).
     *
     * @param values
     * @param type
     * @param normalized
     * @param stride
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray2(ArrayBuffer values, AttrDataType type, boolean normalized, int stride, int offset)
    {
        return setArray(values, AttrDataSize.TWO, type, normalized, stride, offset);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#TWO},
     * null, normalized, stride, offset).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     *
     * @param values
     * @param normalized
     * @param stride
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray2(ArrayBuffer values, boolean normalized, int stride, int offset)
    {
        return setArray(values, AttrDataSize.TWO, null, normalized, stride, offset);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#TWO},
     * type, normalized, stride, 0).
     * 
     * @param values
     * @param type
     * @param normalized
     * @param stride
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray2(ArrayBuffer values, AttrDataType type, boolean normalized, int stride)
    {
        return setArray(values, AttrDataSize.TWO, type, normalized, stride, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#TWO},
     * null, normalized, stride, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     * 
     * @param values
     * @param normalized
     * @param stride
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray2(ArrayBuffer values, boolean normalized, int stride)
    {
        return setArray(values, AttrDataSize.TWO, null, normalized, stride, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#TWO},
     * type, normalized, 0, 0).
     * 
     * @param values
     * @param type
     * @param normalized
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray2(ArrayBuffer values, AttrDataType type, boolean normalized)
    {
        return setArray(values, AttrDataSize.TWO, type, normalized, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#TWO},
     * null, normalized, 0, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     * 
     * @param values
     * @param normalized
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray2(ArrayBuffer values, boolean normalized)
    {
        return setArray(values, AttrDataSize.TWO, null, normalized, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#TWO},
     * type, false, 0, 0).
     * 
     * @param values
     * @param type
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray2(ArrayBuffer values, AttrDataType type)
    {
        return setArray(values, AttrDataSize.TWO, type, false, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#TWO},
     * null, false, 0, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     * 
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray2(ArrayBuffer values)
    {
        return setArray(values, AttrDataSize.TWO, null, false, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#THREE},
     * type, normalized, stride, offset).
     *
     * @param values
     * @param type
     * @param normalized
     * @param stride
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray3(ArrayBuffer values, AttrDataType type, boolean normalized, int stride, int offset)
    {
        return setArray(values, AttrDataSize.THREE, type, normalized, stride, offset);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#THREE},
     * null, normalized, stride, offset).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     *
     * @param values
     * @param normalized
     * @param stride
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray3(ArrayBuffer values, boolean normalized, int stride, int offset)
    {
        return setArray(values, AttrDataSize.THREE, null, normalized, stride, offset);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#THREE},
     * type, normalized, stride, 0).
     * 
     * @param values
     * @param type
     * @param normalized
     * @param stride
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray3(ArrayBuffer values, AttrDataType type, boolean normalized, int stride)
    {
        return setArray(values, AttrDataSize.THREE, type, normalized, stride, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#THREE},
     * null, normalized, stride, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     * 
     * @param values
     * @param normalized
     * @param stride
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray3(ArrayBuffer values, boolean normalized, int stride)
    {
        return setArray(values, AttrDataSize.THREE, null, normalized, stride, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#THREE},
     * type, normalized, 0, 0).
     * 
     * @param values
     * @param type
     * @param normalized
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray3(ArrayBuffer values, AttrDataType type, boolean normalized)
    {
        return setArray(values, AttrDataSize.THREE, type, normalized, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#THREE},
     * null, normalized, 0, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     * 
     * @param values
     * @param normalized
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray3(ArrayBuffer values, boolean normalized)
    {
        return setArray(values, AttrDataSize.THREE, null, normalized, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#THREE},
     * type, false, 0, 0).
     * 
     * @param values
     * @param type
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray3(ArrayBuffer values, AttrDataType type)
    {
        return setArray(values, AttrDataSize.THREE, type, false, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#THREE},
     * null, false, 0, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     * 
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray3(ArrayBuffer values)
    {
        return setArray(values, AttrDataSize.THREE, null, false, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#FOUR},
     * type, normalized, stride, offset).
     *
     * @param values
     * @param type
     * @param normalized
     * @param stride
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray4(ArrayBuffer values, AttrDataType type, boolean normalized, int stride, int offset)
    {
        return setArray(values, AttrDataSize.FOUR, type, normalized, stride, offset);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#FOUR},
     * null, normalized, stride, offset).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     *
     * @param values
     * @param normalized
     * @param stride
     * @param offset
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray4(ArrayBuffer values, boolean normalized, int stride, int offset)
    {
        return setArray(values, AttrDataSize.FOUR, null, normalized, stride, offset);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#FOUR},
     * type, normalized, stride, 0).
     * 
     * @param values
     * @param type
     * @param normalized
     * @param stride
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray4(ArrayBuffer values, AttrDataType type, boolean normalized, int stride)
    {
        return setArray(values, AttrDataSize.FOUR, type, normalized, stride, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#FOUR},
     * null, normalized, stride, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     * 
     * @param values
     * @param normalized
     * @param stride
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray4(ArrayBuffer values, boolean normalized, int stride)
    {
        return setArray(values, AttrDataSize.FOUR, null, normalized, stride, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#FOUR},
     * type, normalized, 0, 0).
     * 
     * @param values
     * @param type
     * @param normalized
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray4(ArrayBuffer values, AttrDataType type, boolean normalized)
    {
        return setArray(values, AttrDataSize.FOUR, type, normalized, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#FOUR},
     * null, normalized, 0, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     * 
     * @param values
     * @param normalized
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray4(ArrayBuffer values, boolean normalized)
    {
        return setArray(values, AttrDataSize.FOUR, null, normalized, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#FOUR},
     * type, false, 0, 0).
     * 
     * @param values
     * @param type
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray4(ArrayBuffer values, AttrDataType type)
    {
        return setArray(values, AttrDataSize.FOUR, type, false, 0, 0);
    }


    /**
     * This method is an alias of {@link #setArray(ArrayBuffer, AttrDataSize,
     * AttrDataType, boolean, int, int) setArray}(values, {@link AttrDataSize#FOUR},
     * null, false, 0, 0).
     *
     * <p>
     * Note that data held by 'values' must be a float array. If not, other
     * method variants having {@link AttrDataType} as an argument must be used.
     * </p>
     * 
     * @param values
     *
     * @return
     *         This Attribute object.
     *
     * @see #setArray(ArrayBuffer, AttrDataSize, AttrDataType, boolean, int, int)
     */
    public Attribute setArray4(ArrayBuffer values)
    {
        return setArray(values, AttrDataSize.FOUR, null, false, 0, 0);
    }


    /**
     * Enable the vertex attribute array for the index of this
     * vertex attribute by glEnableVertexAttribArray().
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glEnableVertexAttribArray.xml">glEnableVertexAttribArray</a>
     */
    private Attribute enableArray()
    {
        getGLES().glEnableVertexAttribArray(index);

        return this;
    }


    /**
     * Disable the vertex attribute array for the index of this
     * vertex attribute by glEnableVertexAttribArray().
     *
     * @return
     *         This Attribute object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    private Attribute disableArray()
    {
        getGLES().glDisableVertexAttribArray(index);

        return this;
    }


    /**
     * Get an implementation of GLES interface.
     *
     * @return
     *         An object implementing GLES interface.
     */
    private GLES getGLES()
    {
        return GLESFactory.getInstance();
    }
}
