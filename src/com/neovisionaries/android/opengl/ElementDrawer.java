/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;


/**
 * Drawer to draw primitives using glDrawElements().
 *
 * <p>
 * On Android 2.2 (API Level 8), the constructors that take {@link
 * ElementArrayBuffer} and {@link #setIndices(ElementArrayBuffer)}
 * method should not be used. This is because
 * <a href="http://developer.android.com/reference/android/opengl/GLES20.html"
 * >android.opengl.GLES20</a> class of Android 2.2 does not have
 * glDrawElements(int mode, int count, int type, int offset) method
 * (note that the last argument is 'int offset') although it should
 * have. Without the glDrawElements method, the element array buffer
 * (represented by {@link ElementArrayBuffer}) cannot be used.
 * </p>
 *
 * @author Takahiko Kawasaki
 *
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDrawElements.xml">glDrawElements</a>
 */
public class ElementDrawer extends Drawer<ElementDrawer>
{
    private Object indices;
    private int count;
    private int offset;
    private int indexType;


    /**
     * A constructor that just calls {@link Drawer#Drawer() super()}.
     */
    public ElementDrawer()
    {
        super();
    }


    /**
     * A constructor that just calls {@link Drawer#Drawer(DrawingMode)
     * super}(mode).
     *
     * @param mode
     *         A drawing mode.
     *
     * @throws IllegalArgumentException
     *         The argument is null.
     */
    public ElementDrawer(DrawingMode mode)
    {
        super(mode);
    }


    /**
     * This constructor is an alias of {@link #ElementDrawer(DrawingMode,
     * Buffer, int) ElementDrawer}(mode, indices, 0).
     */
    public ElementDrawer(DrawingMode mode, Buffer indices)
    {
        this(mode, indices, 0);
    }


    /**
     * A constructor with indices data.
     *
     * @param mode
     *         A drawing mode.
     *
     * @param indices
     *         Indices data. The actual class of 'indices' must be
     *         either ByteBuffer or ShortBuffer. If the extension
     *         {@link Extension#OES_element_index_uint
     *         OES_element_index_uint} is supported, IntBuffer is
     *         also acceptable.
     *
     * @param count
     *         The number of indices.
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>'mode' is null.
     * <li>'indices' is null.
     * <li>'count' is less than 0.
     * <li>The actual class of 'indices' is not ByteBuffer or
     *     ShortBuffer. If {@link Extension#OES_element_index_uint
     *     OES_element_index_uint} is supported, the actual class
     *     of 'indices' is allowed to be IntBuffer.
     * </ul>
     */
    public ElementDrawer(DrawingMode mode, Buffer indices, int count)
    {
        super(mode);

        if (indices == null || count < 0)
        {
            throw new IllegalArgumentException();
        }

        // Get the index type for the actual class of the data.
        // getIndexType() may throw IllegalArgumentException
        // if the class of the data is not acceptable.
        this.indexType = getIndexType(indices.getClass());

        this.indices = indices;
        this.count = count;
    }


    /**
     * This constructor is an alias of {@link #ElementDrawer(DrawingMode,
     * ElementArrayBuffer, int, int) ElementArrayBuffer}(mode, indices,
     * 0, 0).
     */
    public ElementDrawer(DrawingMode mode, ElementArrayBuffer indices)
    {
        this(mode, indices, 0, 0);
    }


    /**
     * This constructor is an alias of {@link #ElementDrawer(DrawingMode,
     * ElementArrayBuffer, int, int) ElementArrayBuffer}(mode, indices,
     * count, 0).
     */
    public ElementDrawer(DrawingMode mode, ElementArrayBuffer indices, int count)
    {
        this(mode, indices, count, 0);
    }


    /**
     * A constructor with indices data held in the element array buffer.
     *
     * <p>
     * It is necessary for 'indices' to have data before it is passed
     * to this constructor. In other words, {@link
     * ElementArrayBuffer#setData(Buffer, int, VertexBufferUsage)
     * setData()} method must have been called. Otherwise, this
     * constructor throws IllegalArgumentException.
     * </p>

     * <p>
     * Note that this constructor should not be used in Android 2.2
     * (API Level 8).
     * </p>
     *
     * @param indices
     *
     * @param count
     *         The number of indices.
     *
     * @param offset
     *         The offset from the start of the element array buffer.
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>'mode' is null.
     * <li>'indices' is null.
     * <li>'count' is less than 0.
     * <li>'offset' is less than 0.
     * <li>The actual class of the data that 'indices' holds
     *     (= the data set by {@link ElementArrayBuffer#setData(Buffer,
     *     int, VertexBufferUsage)} is not ByteBuffer or ShortBuffer.
     *     (IntBuffer is allowed if the extension {@link
     *     Extension#OES_element_index_uint OES_element_index_uint}
     *     is supported.)
     * </ul>
     */
    public ElementDrawer(DrawingMode mode, ElementArrayBuffer indices, int count, int offset)
    {
        super(mode);

        if (indices == null || count < 0 || offset < 0)
        {
            throw new IllegalArgumentException();
        }

        // Get the index type for the actual class of the data.
        // getIndexType() may throw IllegalArgumentException
        // if the class of the data is not acceptable.
        this.indexType = getIndexType(indices.getDataBufferClass());

        this.indices = indices;
        this.count = count;
        this.offset = offset;
    }


    /**
     * Get the indices that this drawer currently holds.
     *
     * @return
     *         The indices data. The returned object can be cast to
     *         either {@link Buffer} or {@link ElementArrayBuffer}.
     *         If neither {@link #setIndices(Buffer)} nor {@link
     *         #setIndices(ElementArrayBuffer)} has been called,
     *         null is returned.
     */
    public Object getIndices()
    {
        return indices;
    }


    /**
     * Set the indices used for drawing.
     *
     * @param indices
     *
     * @return
     *         This ElementDrawer object.
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>The argument is null.
     * <li>The actual class of the given object is not ByteBuffer
     *     or ShortBuffer. (IntBuffer is allowed if the extension
     *     {@link Extension#OES_element_index_uint
     *     OES_element_index_uint} is supported.)
     * </ul>
     */
    public ElementDrawer setIndices(Buffer indices)
    {
        if (indices == null)
        {
            throw new IllegalArgumentException();
        }

        // Get the index type for the actual class of the data.
        // getIndexType() may throw IllegalArgumentException
        // if the class of the data is not acceptable.
        this.indexType = getIndexType(indices.getClass());

        this.indices = indices;

        return this;
    }


    /**
     * Set the indices used for drawing.
     *
     * <p>
     * It is necessary for the given object to have data before
     * it is passed to this method. In other words, {@link
     * ElementArrayBuffer#setData(Buffer, int, VertexBufferUsage)
     * setData()} method must have been called. Otherwise, this
     * setIndices() method throws IllegalArgumentException.
     * </p>
     *
     * <p>
     * Note that this method should not be used in Android 2.2
     * (API Level 8).
     * </p>
     *
     * @param indices
     *
     * @return
     *         This ElementDrawer object.
     *
     * @throws
     * <ul>
     * <li>The argument is null.
     * <li>The actual class of the data that the given object holds
     *     (= the data set by {@link ElementArrayBuffer#setData(Buffer,
     *     int, VertexBufferUsage)} is not ByteBuffer or ShortBuffer.
     *     (IntBuffer is allowed if the extension {@link
     *     Extension#OES_element_index_uint OES_element_index_uint}
     *     is supported.)
     * </ul>
     */
    public ElementDrawer setIndices(ElementArrayBuffer indices)
    {
        if (indices == null)
        {
            throw new IllegalArgumentException();
        }

        // Get the index type for the actual class of the data.
        // getIndexType() may throw IllegalArgumentException
        // if the class of the data is not acceptable.
        this.indexType = getIndexType(indices.getDataBufferClass());

        this.indices = indices;

        return this;
    }


    /**
     * Get the number of indices used for drawing.
     *
     * @return
     *         The number of indices used for drawing.
     */
    public int getCount()
    {
        return count;
    }


    /**
     * Set the number of indices used for drawing.
     *
     * @param count
     *         The number of indices used for drawing.
     *
     * @return
     *         This ElementDrawer object.
     *
     * @throws IllegalArgumentException
     *         The argument is less than 0.
     */
    public ElementDrawer setCount(int count)
    {
        if (count < 0)
        {
            throw new IllegalArgumentException();
        }

        this.count = count;

        return this;
    }


    /**
     * Get the offset from the start of the element array buffer.
     *
     * @return
     *         The offset from the start of the element array buffer.
     */
    public int getOffset()
    {
        return offset;
    }


    /**
     * Set the offset from the start of the element array buffer.
     *
     * <p>
     * The value set by this method has a meaning only when indices
     * are fed by the element array buffer. In other words, it has
     * a meaning only if {@link #setIndices(ElementArrayBuffer)}
     * is used. 
     * </p>
     *
     * @param offset
     *         The offset from the start of the element array buffer.
     *
     * @return
     *         This ElementDrawer object.
     */
    public ElementDrawer setOffset(int offset)
    {
        if (offset < 0)
        {
            throw new IllegalArgumentException();
        }

        this.offset = offset;

        return this;
    }


    /**
     * Draw primitives.
     *
     * <p>
     * If the index data this instance holds is an instance of Buffer
     * and if the element array buffer holds some data, this method
     * unbinds the element array buffer so that the index data can
     * take effect.  
     * </p>
     *
     * <p>
     * On the contrary, the index data this instance holds is an
     * instance of {@link ElementArrayBuffer} and if the ID of the
     * data that is currently bound to the element array buffer is
     * different from the ID of the index data (simply saying, if
     * the index data's {@link ElementArrayBuffer#isBound() isBound()}
     * method returns false), this method binds the index data to
     * the element array buffer (= this method calls the index
     * data's {@link ElementArrayBuffer#bind() bind()} method) so
     * that the index data can take effect.
     * </p>
     *
     * @return
     *         This ElementDrawer object.
     *
     * @throws IllegalStateException
     *         Indices are not set. That is, neither {@link
     *         #setIndices(Buffer)} nor {@link
     *         #setIndices(ElementArrayBuffer)} has been called.
     */
    @Override
    public ElementDrawer draw()
    {
        if (indices == null)
        {
            throw new IllegalStateException("Indices are not set.");
        }

        if (indices instanceof Buffer)
        {
            return drawInternal((Buffer)indices);
        }
        else
        {
            return drawInternal((ElementArrayBuffer)indices);
        }
    }


    private ElementDrawer drawInternal(Buffer indices)
    {
        if (GLESState.getElementArrayBufferBinding() != 0)
        {
            // The element array buffer is currently bound.
            // Unbind it to make the given indices take effect.
            ElementArrayBuffer.unbind();
        }

        getGLES().glDrawElements(getMode().getMode(), getCount(), indexType, indices);

        return this;
    }


    private ElementDrawer drawInternal(ElementArrayBuffer indices)
    {
        if (indices.isBound() == false)
        {
            indices.bind();
        }

        getGLES().glDrawElements(getMode().getMode(), getCount(), indexType, getOffset());

        return this;
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


    private static int getIndexType(Class<? extends Buffer> bufferClass)
    {
        if (bufferClass.equals(ByteBuffer.class))
        {
            return getGLES().GL_UNSIGNED_BYTE();
        }
        else if (bufferClass.equals(ShortBuffer.class))
        {
            return getGLES().GL_UNSIGNED_SHORT();
        }
        else if (bufferClass.equals(IntBuffer.class) &&
                  Extension.OES_element_index_uint.isSupported())
        {
            return getGLES().GL_UNSIGNED_INT();
        }
        else
        {
            throw new IllegalArgumentException(bufferClass.getName() + " cannot be used for glDrawElements()");
        }
    }
}
