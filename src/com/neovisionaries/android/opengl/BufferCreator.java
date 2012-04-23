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
     * Create a direct ByteBuffer with the native byte order.
     *
     * <p>
     * Int values from the offset in the data array up to the
     * specified length are set to a newly allocated ByteBuffer.
     * </p>
     *
     * @param data
     *         Data to set to a newly allocated ByteBuffer.
     *
     * @param offset
     *         The offset from the beginning of the data array.
     *
     * @param length
     *         The number of int values to use.
     *
     * @return
     *         A newly allocated ByteBuffer. Its position is 0
     *         right after this method returns.
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>'data' is null.
     * <li>'offset' is less than 0.
     * <li>'offset' is equal to or greater than the length of 'data'.
     * <li>'length' is 0 or less.
     * <li>'length' is greater than ('data.length' - 'offset').
     * </ul>
     */
    public static ByteBuffer createByteBuffer(byte[] data, int offset, int length)
    {
        if (data == null)
        {
            throw new IllegalArgumentException("bad data");
        }

        // Check if the combination of the arguments is valid.
        checkDataArguments(data.length, offset, length);

        // Create a new ByteBuffer.
        ByteBuffer buffer = createByteBuffer(length);

        // Set the passed data to the ByteBUffer.
        buffer.put(data, offset, length);

        // Move the position to the beginning.
        buffer.position(0);

        return buffer;
    }


    /**
     * This method is an alias of {@link #createByteBuffer(byte[],
     * int, int) createByteBuffer}(data, 0, data.length).
     *
     * @param data
     *         Data to set to a newly allocated ByteBuffer.
     *
     * @return
     *         A newly allocated ByteBuffer. Its position is 0
     *         right after this method returns.
     *
     * @throws IllegalArgumentException
     *         'data' is null or its length is 0.
     */
    public static ByteBuffer createByteBuffer(byte[] data)
    {
        if (data == null || data.length == 0)
        {
            throw new IllegalArgumentException("bad data");
        }

        return createByteBuffer(data, 0, data.length);
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
     * Create a direct ShortBuffer with the native byte order.
     *
     * <p>
     * Int values from the offset in the data array up to the
     * specified length are set to a newly allocated ShortBuffer.
     * </p>
     *
     * @param data
     *         Data to set to a newly allocated ShortBuffer.
     *
     * @param offset
     *         The offset from the beginning of the data array.
     *
     * @param length
     *         The number of int values to use.
     *
     * @return
     *         A newly allocated ShortBuffer. Its position is 0
     *         right after this method returns.
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>'data' is null.
     * <li>'offset' is less than 0.
     * <li>'offset' is equal to or greater than the length of 'data'.
     * <li>'length' is 0 or less.
     * <li>'length' is greater than ('data.length' - 'offset').
     * </ul>
     */
    public static ShortBuffer createShortBuffer(short[] data, int offset, int length)
    {
        if (data == null)
        {
            throw new IllegalArgumentException("bad data");
        }

        // Check if the combination of the arguments is valid.
        checkDataArguments(data.length, offset, length);

        // Create a new ShortBuffer.
        ShortBuffer buffer = createShortBuffer(length);

        // Set the passed data to the ShortBUffer.
        buffer.put(data, offset, length);

        // Move the position to the beginning.
        buffer.position(0);

        return buffer;
    }


    /**
     * This method is an alias of {@link #createShortBuffer(short[],
     * int, int) createShortBuffer}(data, 0, data.length).
     *
     * @param data
     *         Data to set to a newly allocated ShortBuffer.
     *
     * @return
     *         A newly allocated ShortBuffer. Its position is 0
     *         right after this method returns.
     *
     * @throws IllegalArgumentException
     *         'data' is null or its length is 0.
     */
    public static ShortBuffer createShortBuffer(short[] data)
    {
        if (data == null || data.length == 0)
        {
            throw new IllegalArgumentException("bad data");
        }

        return createShortBuffer(data, 0, data.length);
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
     * Create a direct IntBuffer with the native byte order.
     *
     * <p>
     * Int values from the offset in the data array up to the
     * specified length are set to a newly allocated IntBuffer.
     * </p>
     *
     * @param data
     *         Data to set to a newly allocated IntBuffer.
     *
     * @param offset
     *         The offset from the beginning of the data array.
     *
     * @param length
     *         The number of int values to use.
     *
     * @return
     *         A newly allocated IntBuffer. Its position is 0
     *         right after this method returns.
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>'data' is null.
     * <li>'offset' is less than 0.
     * <li>'offset' is equal to or greater than the length of 'data'.
     * <li>'length' is 0 or less.
     * <li>'length' is greater than ('data.length' - 'offset').
     * </ul>
     */
    public static IntBuffer createIntBuffer(int[] data, int offset, int length)
    {
        if (data == null)
        {
            throw new IllegalArgumentException("bad data");
        }

        // Check if the combination of the arguments is valid.
        checkDataArguments(data.length, offset, length);

        // Create a new IntBuffer.
        IntBuffer buffer = createIntBuffer(length);

        // Set the passed data to the IntBUffer.
        buffer.put(data, offset, length);

        // Move the position to the beginning.
        buffer.position(0);

        return buffer;
    }


    /**
     * This method is an alias of {@link #createIntBuffer(int[],
     * int, int) createIntBuffer}(data, 0, data.length).
     *
     * @param data
     *         Data to set to a newly allocated IntBuffer.
     *
     * @return
     *         A newly allocated IntBuffer. Its position is 0
     *         right after this method returns.
     *
     * @throws IllegalArgumentException
     *         'data' is null or its length is 0.
     */
    public static IntBuffer createIntBuffer(int[] data)
    {
        if (data == null || data.length == 0)
        {
            throw new IllegalArgumentException("bad data");
        }

        return createIntBuffer(data, 0, data.length);
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
     * Create a direct FloatBuffer with the native byte order.
     *
     * <p>
     * Float values from the offset in the data array up to the
     * specified length are set to a newly allocated FloatBuffer.
     * </p>
     *
     * @param data
     *         Data to set to a newly allocated FloatBuffer.
     *
     * @param offset
     *         The offset from the beginning of the data array.
     *
     * @param length
     *         The number of float values to use.
     *
     * @return
     *         A newly allocated FloatBuffer. Its position is 0
     *         right after this method returns.
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>'data' is null.
     * <li>'offset' is less than 0.
     * <li>'offset' is equal to or greater than the length of 'data'.
     * <li>'length' is 0 or less.
     * <li>'length' is greater than ('data.length' - 'offset').
     * </ul>
     */
    public static FloatBuffer createFloatBuffer(float[] data, int offset, int length)
    {
        if (data == null)
        {
            throw new IllegalArgumentException("bad data");
        }

        // Check if the combination of the arguments is valid.
        checkDataArguments(data.length, offset, length);

        // Create a new FloatBuffer.
        FloatBuffer buffer = createFloatBuffer(length);

        // Set the passed data to the FloatBUffer.
        buffer.put(data, offset, length);

        // Move the position to the beginning.
        buffer.position(0);

        return buffer;
    }


    /**
     * This method is an alias of {@link #createFloatBuffer(float[],
     * int, int) createFloatBuffer}(data, 0, data.length).
     *
     * @param data
     *         Data to set to a newly allocated FloatBuffer.
     *
     * @return
     *         A newly allocated FloatBuffer. Its position is 0
     *         right after this method returns.
     *
     * @throws IllegalArgumentException
     *         'data' is null or its length is 0.
     */
    public static FloatBuffer createFloatBuffer(float[] data)
    {
        if (data == null || data.length == 0)
        {
            throw new IllegalArgumentException("bad data");
        }

        return createFloatBuffer(data, 0, data.length);
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


    /**
     * Check if the combination of the arguments is valid.
     *
     * @param dataLength
     * @param offset
     * @param length
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>'offset' is less than 0.
     * <li>'offset' is equal to or greater than 'dataLength'.
     * <li>'length' is 0 or less.
     * <li>'length' is greater than ('dataLength' - 'offset').
     * </ul>
     */
    private static void checkDataArguments(int dataLength, int offset, int length)
    {
        if (offset < 0 || dataLength <= offset)
        {
            throw new IllegalArgumentException("bad offset");
        }

        if (length <= 0 || (dataLength - offset) < length)
        {
            throw new IllegalArgumentException("bad length");
        }
    }
}
