/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;


/**
 * Helper class for this package.
 *
 * @author Takahiko Kawasaki
 */
public final class GLESHelper
{
    private GLESHelper()
    {
    }


    /**
     * Get the element size in bytes of the given buffer.
     *
     * <br/><br/>
     * <table border="1" cellpadding="5" style="border-collapse: collapse;">
     * <tr style="background-color: lightgray;">
     *   <th>Buffer Type</th> <th>Return Value</th>
     * </tr>
     * <tr>
     *   <td>java.nio.ByteBuffer</td> <td>Byte.SIZE / 8</td>
     * </tr>
     * <tr>
     *   <td>java.nio.CharBuffer</td> <td>Character.SIZE / 8</td>
     * </tr>
     * <tr>
     *   <td>java.nio.ShortBuffer</td> <td>Short.SIZE / 8</td>
     * </tr>
     * <tr>
     *   <td>java.nio.IntBuffer</td> <td>Integer.SIZE / 8</td>
     * </tr>
     * <tr>
     *   <td>java.nio.LongBuffer</td> <td>Long.SIZE / 8</td>
     * </tr>
     * <tr>
     *   <td>java.nio.FloatBuffer</td> <td>Float.SIZE / 8</td>
     * </tr>
     * <tr>
     *   <td>java.nio.DoubleBuffer</td> <td>Double.SIZE / 8</td>
     * </tr>
     * <tr>
     *   <td>Others</td> <td>0</td>
     * </tr>
     * </table>
     *
     * @param buffer
     *
     * @return
     *         The element size in bytes of the given buffer.
     */
    public static int getElementSizeInBytes(Buffer buffer)
    {
        return getElementSizeInBits(buffer) / 8;
    }


    /**
     * Get the element size in bits of the given buffer.
     *
     * <br/><br/>
     * <table border="1" cellpadding="5" style="border-collapse: collapse;">
     * <tr style="background-color: lightgray;">
     *   <th>Buffer Type</th> <th>Return Value</th>
     * </tr>
     * <tr>
     *   <td>java.nio.ByteBuffer</td> <td>Byte.SIZE</td>
     * </tr>
     * <tr>
     *   <td>java.nio.CharBuffer</td> <td>Character.SIZE</td>
     * </tr>
     * <tr>
     *   <td>java.nio.ShortBuffer</td> <td>Short.SIZE</td>
     * </tr>
     * <tr>
     *   <td>java.nio.IntBuffer</td> <td>Integer.SIZE</td>
     * </tr>
     * <tr>
     *   <td>java.nio.LongBuffer</td> <td>Long.SIZE</td>
     * </tr>
     * <tr>
     *   <td>java.nio.FloatBuffer</td> <td>Float.SIZE</td>
     * </tr>
     * <tr>
     *   <td>java.nio.DoubleBuffer</td> <td>Double.SIZE</td>
     * </tr>
     * <tr>
     *   <td>Others</td> <td>0</td>
     * </tr>
     * </table>
     *
     * @param buffer
     *
     * @return
     *         The element size in bytes of the given buffer.
     */
    private static int getElementSizeInBits(Buffer buffer)
    {
        if (buffer == null)
        {
            return 0;
        }

        if (buffer instanceof ByteBuffer)
        {
            return Byte.SIZE;
        }
        else if (buffer instanceof CharBuffer)
        {
            return Character.SIZE;
        }
        else if (buffer instanceof ShortBuffer)
        {
            return Short.SIZE;
        }
        else if (buffer instanceof IntBuffer)
        {
            return Integer.SIZE;
        }
        else if (buffer instanceof LongBuffer)
        {
            return Long.SIZE;
        }
        else if (buffer instanceof FloatBuffer)
        {
            return Float.SIZE;
        }
        else if (buffer instanceof DoubleBuffer)
        {
            return Double.SIZE;
        }
        else
        {
            return 0;
        }
    }
}
