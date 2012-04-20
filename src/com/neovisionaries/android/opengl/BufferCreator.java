/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;


/**
 * Buffer creator.
 *
 * @author Takahiko Kawasaki
 */
public final class BufferCreator
{
    private BufferCreator()
    {
    }


    /**
     * Create a direct ByteBuffer with the native byte order.
     *
     * <p>
     * Internally, a ByteBuffer is created by ByteBuffer.allocateDirect(size)
     * and its byte order is set to the native byte order, and this method
     * returns the ByteBuffer.
     * </p>
     *
     * @param size
     *         The number of elements that the created ByteBuffer
     *         should be able to hold.
     *
     * @return
     *         A newly allocated ByteBuffer.
     *
     * @throws IllegalArgumentException
     *         'size' is 0 or negative.
     */
    public static ByteBuffer createByteBuffer(int size)
    {
        return createBuffer(size, ByteBuffer.class);
    }


    /**
     * Create a direct ShortBuffer with the native byte order.
     *
     * <p>
     * Internally, a ByteBuffer is created by ByteBuffer.allocateDirect(size * 2)
     * and its byte order is set to the native byte order. What is returned
     * by this method is the ByteBuffer's view as ShortBuffer.
     * </p>
     *
     * @param size
     *         The number of elements that the created ShortBuffer
     *         should be able to hold. Note that the unit is not
     *         'bytes'.
     *
     * @return
     *         A newly allocated ShortBuffer.
     *
     * @throws IllegalArgumentException
     *         'size' is 0 or negative.
     */
    public static ShortBuffer createShortBuffer(int size)
    {
        return createBuffer(size, ShortBuffer.class).asShortBuffer();
    }


    /**
     * Create a direct IntBuffer with the native byte order.
     *
     * <p>
     * Internally, a ByteBuffer is created by ByteBuffer.allocateDirect(size * 4)
     * and its byte order is set to the native byte order. What is returned
     * by this method is the ByteBuffer's view as IntBuffer.
     * </p>
     *
     * @param size
     *         The number of elements that the created IntBuffer
     *         should be able to hold. Note that the unit is not
     *         'bytes'.
     *
     * @return
     *         A newly allocated IntBuffer.
     *
     * @throws IllegalArgumentException
     *         'size' is 0 or negative.
     */
    public static IntBuffer createIntBuffer(int size)
    {
        return createBuffer(size, IntBuffer.class).asIntBuffer();
    }


    /**
     * Create a direct FloatBuffer with the native byte order.
     *
     * <p>
     * Internally, a ByteBuffer is created by ByteBuffer.allocateDirect(size * 4)
     * and its byte order is set to the native byte order. What is returned
     * by this method is the ByteBuffer's view as FloatBuffer.
     * </p>
     *
     * @param size
     *         The number of elements that the created FloatBuffer
     *         should be able to hold. Note that the unit is not
     *         'bytes'.
     *
     * @return
     *         A newly allocated FloatBuffer.
     *
     * @throws IllegalArgumentException
     *         'size' is 0 or negative.
     */
    public static FloatBuffer createFloatBuffer(int size)
    {
        return createBuffer(size, FloatBuffer.class).asFloatBuffer();
    }


    /**
     * Create a direct ByteBuffer with the native byte order.
     *
     * @param size
     *         The number of elements that the created buffer should
     *         be able to hold. Note that the unit is not 'bytes'.
     *
     * @param bufferClass
     *         The Buffer class that the created ByteBuffer is to be
     *         used as.
     *
     * @return
     *         A newly allocated ByteBuffer.
     *
     * @throws IllegalArgumentException
     *         'size' is 0 or negative.
     */
    private static ByteBuffer createBuffer(int size, Class<? extends Buffer> bufferClass)
    {
        if (size <= 0)
        {
            throw new IllegalArgumentException("size is 0 or negative.");
        }

        int unit = GLESHelper.getElementSizeInBytes(bufferClass);

        ByteBuffer buffer = ByteBuffer.allocateDirect(size * unit);

        buffer.order(ByteOrder.nativeOrder());

        return buffer;
    }
}
