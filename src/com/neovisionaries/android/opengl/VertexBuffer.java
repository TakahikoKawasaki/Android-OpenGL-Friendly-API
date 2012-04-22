/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import java.nio.Buffer;
import static com.neovisionaries.android.opengl.VertexBufferState.CREATED;
import static com.neovisionaries.android.opengl.VertexBufferState.DELETED;


/**
 * OpenGL ES vertex buffer.
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E   1</b></span>
 *
 * <span style="color: darkgreen;">// Create a vertex buffer.</span>
 * {@link VertexBuffer} vb = new {@link ArrayBuffer#ArrayBuffer() ArrayBuffer}();
 * <span style="color: darkgreen;">//VertexBuffer vb = new {@link
 * ElementArrayBuffer#ElementArrayBuffer() ElementArrayBuffer}();</span>
 *
 * <span style="color: darkgreen;">// Bind the vertex buffer.</span>
 * vb.{@link #bind() bind}();
 *
 * <span style="color: darkgreen;">// Prepare data to set to the vertex buffer.</span>
 * Buffer data = ...;
 *
 * <span style="color: darkgreen;">// Set the data to the vertex buffer.</span>
 * vb.{@link #setData(Buffer) setData}(data);
 * </pre>
 *
 * @author Takahiko Kawasaki
 */
public abstract class VertexBuffer
{
    /**
     * Type of the buffer object.
     */
    private final VertexBufferType type;


    /**
     * ID of the buffer object assigned by glGenBuffers().
     */
    private final int id;


    /**
     * State of this vertex buffer.
     */
    private VertexBufferState state = CREATED;


    /**
     * The class of the data given to the last call of a
     * setData() method.
     */
    private Class<? extends Buffer> dataBufferClass;


    /**
     * A constructor with a vertex buffer type. A buffer object
     * is assigned internally by glGenBuffers(). If this
     * constructor returns without any exception, the state of
     * this instance is {@link VertexBufferState#CREATED}.
     *
     * @param type
     *         {@link VertexBufferType#ARRAY} or
     *         {@link VertexBufferType#ELEMENT_ARRAY}.
     *
     * @throws IllegalArgumentException
     *         The given argument is null.
     *
     * @throws GLESException
     *         glGenBuffers() failed.
     *
     * @see ArrayBuffer#ArrayBuffer()
     * @see ElementArrayBuffer#ElementArrayBuffer()
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenBuffers.xml">glGenBuffers</a>
     */
    protected VertexBuffer(VertexBufferType type) throws GLESException
    {
        if (type == null)
        {
            throw new IllegalArgumentException("Vertex buffer type is null.");
        }

        // Buffer IDs assigned by glGenBuffers().
        int[] ids = new int[] { 0 };

        // Create a buffer object.
        getGLES().glGenBuffers(type.getType(), ids, 0);

        // Check if a valid buffer object has been created.
        if (ids[0] <= 0)
        {
            // Failed to create a buffer object.
            throw new GLESException("glGenBuffers() failed.");
        }

        // A buffer object was created successfully.

        // Type of the buffer object.
        this.type = type;

        // ID of the buffer object.
        id = ids[0];
    }


    /**
     * Get the type of this vertex buffer.
     *
     * @return
     *         {@link VertexBufferType#ARRAY} or
     *         {@link VertexBufferType#ELEMENT_ARRAY}.
     */
    public VertexBufferType getType()
    {
        return type;
    }


    /**
     * Get the ID of the buffer object assigned to this instance.
     *
     * @return
     *         The ID of the buffer object assigned by glGenBuffers().
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenBuffers.xml">glGenBuffers</a>
     */
    public int getId()
    {
        return id;
    }


    /**
     * Get the state of this vertex buffer.
     *
     * @return
     *         The current state of this vertex buffer.
     */
    public VertexBufferState getState()
    {
        return state;
    }


    /**
     * Bind this vertex buffer using glBindBuffer().
     *
     * @throws IllegalStateException
     *         This vertex buffer has already been deleted.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindBuffer.xml">glBindBuffer</a>
     */
    public void bind()
    {
        if (state == DELETED)
        {
            throw new IllegalStateException("Vertex buffer has already been deleted.");
        }

        // Bind the buffer object.
        getGLES().glBindBuffer(type.getType(), id);
    }


    /**
     * Delete the buffer object using glDeleteBuffers().
     * If the buffer object has already been deleted,
     * nothing is executed. After this method returns,
     * the state of this instance is {@link
     * VertexBufferState#DELETED}.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDeleteBuffers.xml">glDeleteBuffers</a>
     */
    public void delete()
    {
        // Check the current state of this instance.
        if (state == DELETED)
        {
            // This vertex buffer has already been deleted.
            return;
        }


        int[] ids = new int[] { id };

        // Delete the buffer object.
        getGLES().glDeleteBuffers(1, ids, 0);

        // The buffer object was deleted.
        state = DELETED;
    }


    /**
     * Set data to this vertex buffer.
     *
     * <p>
     * As a side effect, if this vertex buffer has not been bound yet,
     * {@link #bind()} is executed before glBufferData().
     * </p>
     *
     * @param data
     *         Data to pass to glBufferData().
     *
     * @param count
     *         The number of elements to pass to glBufferData(). Note that
     *         the unit is not 'bytes'. The size (in bytes) to pass to
     *         glBufferData() is calculated in this method based on the
     *         type of the given data. If 'count' is a negative value,
     *         data.remaining() is used.
     *
     * @param usage
     *         Usage of the data. If null is given, {@link
     *         VertexBufferUsage#STATIC} is used.
     *
     * @throws IllegalArgumentException
     *         'data' is null, or 'count' exceeds data.remaining().
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBufferData.xml">glBufferData</a>
     */
    public void setData(Buffer data, int count, VertexBufferUsage usage)
    {
        if (data == null)
        {
            throw new IllegalArgumentException("Data is null.");
        }

        if (count < 0)
        {
            count = data.remaining();
        }

        if (data.remaining() < count)
        {
            throw new IllegalArgumentException("Count exceeds data.remaining()");
        }

        if (usage == null)
        {
            usage = VertexBufferUsage.STATIC;
        }

        if (isBound() == false)
        {
            bind();
        }

        // Get the elements size (in bytes) of the data.
        int unit = GLESHelper.getElementSizeInBytes(data);

        getGLES().glBufferData(type.getType(), count * unit, data, usage.getUsage());

        // Remember the class of the given data for getDataBufferClass().
        dataBufferClass = data.getClass();
    }


    /**
     * This method calls {@link #setData(Buffer, int, VertexBufferUsage)
     * setData}(data, -1, usage).
     *
     * @param data
     *         Data to pass to glBufferData().
     *
     * @param usage
     *         Usage of the data.
     *
     * @see #setData(Buffer, int, VertexBufferUsage)
     */
    public void setData(Buffer data, VertexBufferUsage usage)
    {
        setData(data, -1, usage);
    }


    /**
     * This method calls {@link #setData(Buffer, int, VertexBufferUsage)
     * setData}(data, count, null).
     *
     * @param data
     *         Data to pass to glBufferData().
     *
     * @param count
     *         The number of elements to pass to glBufferData().
     *
     * @see #setData(Buffer, int, VertexBufferUsage)
     */
    public void setData(Buffer data, int count)
    {
        setData(data, count, null);
    }


    /**
     * This method calls {@link #setData(Buffer, int, VertexBufferUsage)
     * setData}(data, -1, null).
     *
     * @param data
     *         Data to pass to glBufferData().
     *
     * @see #setData(Buffer, int, VertexBufferUsage)
     */
    public void setData(Buffer data)
    {
        setData(data, -1, null);
    }


    /**
     * Set sub data to this vertex buffer.
     *
     * @param data
     *         Data to pass to glBufferSubData().
     *
     * @param count
     *         The number of elements to pass to glBufferSubData().
     *         Note that the unit is not 'bytes'. The size (in bytes)
     *         to pass to glBufferSubData() is calculated in this
     *         method based on the type of the given data. If 'count'
     *         is a negative value, data.remaining() is used.
     *
     * @param offset
     *         The number of elements to skip. Note that the unit is
     *         not 'bytes'. The offset (in bytes) to pass to
     *         glBufferSubData() is calculated in this method based
     *         on the type of the given data.
     *
     * @throws IllegalArgumentException
     *         'data' is null, or 'count' exceeds data.remaining().
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBufferSubData.xml">glBufferSubData</a>
     */
    public void setSubData(Buffer data, int count, int offset)
    {
        if (data == null)
        {
            throw new IllegalArgumentException("Data is null.");
        }

        if (count < 0)
        {
            count = data.remaining();
        }

        if (data.remaining() < count)
        {
            throw new IllegalArgumentException("Count exceeds data.remaining()");
        }

        // Get the elements size (in bytes) of the data.
        int unit = GLESHelper.getElementSizeInBytes(data);

        getGLES().glBufferSubData(type.getType(), offset * unit, count * unit, data);
    }


    /**
     * This method calls {@link #setSubData(Buffer, int, int)
     * setSubData}(data, count, 0).
     *
     * @param data
     *         Data to pass to glBufferSubData().
     *
     * @param count
     *         The number of elements to pass to glBufferSubData().
     *
     * @see #setSubData(Buffer, int, int)
     */
    public void setSubData(Buffer data, int count)
    {
        setSubData(data, count, 0);
    }


    /**
     * This method calls {@link #setSubData(Buffer, int, int)
     * setSubData}(data, -1, 0).
     *
     * @param data
     *         Data to pass to glBufferSubData().
     *
     * @see #setSubData(Buffer, int, int)
     */
    public void setSubData(Buffer data)
    {
        setSubData(data, -1, 0);
    }


    /**
     * Get the class of the data passed to the last call of a
     * setData() method.
     *
     * <p>
     * This package-private method is used by {@link Attribute}
     * and {@link ElementDrawer}.
     * </p>
     *
     * @return
     *         The class of the data passed to the last call
     *         of a setData() method. If any setData() method
     *         has not been called so far, null is returned.
     */
    Class<? extends Buffer> getDataBufferClass()
    {
        return dataBufferClass;
    }


    /**
     * Get an implementation of GLES interface.
     *
     * @return
     *         An object implementing GLES interface.
     */
    private static GLES getGLES()
    {
        return GLESFactory.getInstance();
    }


    /**
     * Check if this vertex buffer is bound.
     *
     * @return
     *         True if this vertex buffer is bound.
     */
    public abstract boolean isBound();
}
