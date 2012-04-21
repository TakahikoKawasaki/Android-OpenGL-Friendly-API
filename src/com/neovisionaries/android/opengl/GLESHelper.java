/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.nio.charset.Charset;


/**
 * Helper class for this package.
 *
 * @author Takahiko Kawasaki
 */
final class GLESHelper
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
     * Get the element size in bytes of the given buffer class.
     *
     * <br/><br/>
     * <table border="1" cellpadding="5" style="border-collapse: collapse;">
     * <tr style="background-color: lightgray;">
     *   <th>Buffer Class</th> <th>Return Value</th>
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
     * @param bufferClass
     *
     * @return
     *         The element size in bytes of the given buffer class.
     */
    public static int getElementSizeInBytes(Class<? extends Buffer> bufferClass)
    {
        return getElementSizeInBits(bufferClass) / 8;
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

        return getElementSizeInBits(buffer.getClass());
    }


    /**
     * Get the element size in bits of the given buffer class.
     *
     * <br/><br/>
     * <table border="1" cellpadding="5" style="border-collapse: collapse;">
     * <tr style="background-color: lightgray;">
     *   <th>Buffer Class</th> <th>Return Value</th>
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
     * @param bufferClass
     *
     * @return
     *         The element size in bytes of the given buffer class.
     */
    private static int getElementSizeInBits(Class<? extends Buffer> bufferClass)
    {
        if (bufferClass.equals(ByteBuffer.class))
        {
            return Byte.SIZE;
        }
        else if (bufferClass.equals(CharBuffer.class))
        {
            return Character.SIZE;
        }
        else if (bufferClass.equals(ShortBuffer.class))
        {
            return Short.SIZE;
        }
        else if (bufferClass.equals(IntBuffer.class))
        {
            return Integer.SIZE;
        }
        else if (bufferClass.equals(LongBuffer.class))
        {
            return Long.SIZE;
        }
        else if (bufferClass.equals(FloatBuffer.class))
        {
            return Float.SIZE;
        }
        else if (bufferClass.equals(DoubleBuffer.class))
        {
            return Double.SIZE;
        }
        else
        {
            return 0;
        }
    }


    /**
     * Convert the content of the given file to a String instance.
     * This method calls {@link #toString(File, Charset)
     * toString}(file, null).
     *
     * @param file
     *         A File instance.
     *
     * @return
     *         The content of the file.
     *
     * @throws IOException
     *         The file size is too big, or some other general I/O
     *         error occurred.
     */
    public static String toString(File file) throws IOException
    {
        return toString(file, null);
    }


    /**
     * Convert the content of the given file to a String instance.
     *
     * @param file
     *         A File instance.
     *
     * @param charset
     *         The character set of the content of the file. If null
     *         is given, the default character set of the platform
     *         is used.
     *
     * @return
     *         The content of the file.
     *
     * @throws IllegalArgumentException
     *         'file' argument is null.
     *
     * @throws IOException
     *         The file size is too big, or some other general I/O
     *         error occurred.
     */
    public static String toString(File file, Charset charset) throws IOException
    {
        if (file == null)
        {
            // Error. 'file' argument is mandatory.
            throw new IllegalArgumentException("file is null.");
        }

        if (charset == null)
        {
            // Use the default charset of the platform.
            charset = Charset.defaultCharset();
        }

        if (Integer.MAX_VALUE < file.length())
        {
            // The file size is too big.
            throw tooBig(file, null);
        }

        // InputStream to read the content of the file from.
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));

        try
        {
            // Create a byte array having the same size as the file.
            byte[] content = new byte[(int)file.length()];

            // Read all the bytes of the file into the byte array.
            in.read(content);

            // Convert the byte array into a String instance.
            return new String(content, charset);
        }
        catch (OutOfMemoryError e)
        {
            // The file size is too big.
            throw tooBig(file, e);
        }
        finally
        {
            try
            {
                // Close the file.
                in.close();
            }
            catch (IOException e)
            {
            }
        }
    }


    /**
     * This method is an alias of {@link #toString(InputStream, Charset, boolean)
     * toString}(in, null, false).
     *
     * @see #toString(InputStream, Charset, boolean)
     */
    public static String toString(InputStream in) throws IOException
    {
        return toString(in, null, false);
    }


    /**
     * This method is an alias of {@link #toString(InputStream, Charset, boolean)
     * toString}(in, null, close).
     *
     * @see #toString(InputStream, Charset, boolean)
     */
    public static String toString(InputStream in, boolean close) throws IOException
    {
        return toString(in, null, close);
    }


    /**
     * This method is an alias of {@link #toString(InputStream, Charset, boolean)
     * toString}(in, charset, false).
     *
     * @see #toString(InputStream, Charset, boolean)
     */
    public static String toString(InputStream in, Charset charset) throws IOException
    {
        return toString(in, charset, false);
    }


    /**
     * Read all the bytes from the input stream and convert them a String instance.
     *
     * @param in
     *         Input.
     *
     * @param charset
     *         The character set of the content of the file. If null
     *         is given, the default character set of the platform
     *         is used.
     *
     * @param close
     *         If true is given, the input stream is closed before
     *         this method returns.
     *
     * @return
     *         A String instance built from the data of the input stream.
     *
     * @throws IllegalArgumentException
     *         'in' is null.
     *
     * @throws IOException
     */
    public static String toString(InputStream in, Charset charset, boolean close) throws IOException
    {
        if (in == null)
        {
            throw new IllegalArgumentException();
        }

        if (charset == null)
        {
            // Use the default charset of the platform.
            charset = Charset.defaultCharset();
        }

        // Read all bytes from the input stream.
        DataBuilder builder = new DataBuilder();
        builder.append(in);
        byte[] data = builder.toData();

        // Convert the bytes to a String instance.
        String str = new String(data, charset);

        if (close)
        {
            in.close();
        }

        return str;
    }


    /**
     * Create an IOException instance having a message to indicate
     * that the given file is too big.
     *
     * @param file
     *         The file related to the IOException.
     *
     * @param cause
     *         The cause of the IOException. null is OK.
     *
     * @return
     *         An IOException instance having a message to indicate
     *         that the given file is too big.
     */
    private static IOException tooBig(File file, Throwable cause)
    {
        String format = "The file '%s' is too big (%,d bytes).";

        String message = String.format(format, file.getAbsolutePath(), file.length());

        if (cause != null)
        {
            return new IOException(message, cause);
        }
        else
        {
            return new IOException(message);
        }
    }


    /**
     * Convert an integer value ranging from 0 to 255 to a float value
     * ranging from 0.0f to 1.0f.
     *
     * @param value
     *         An integer that ranges from 0 to 255.
     *
     * @return
     *         A float value that ranges from 0.0f to 1.0f.
     */
    public static float map255(int value)
    {
        if (value <= 0)
        {
            return 0.0f;
        }

        if (255 <= value)
        {
            return 1.0f;
        }

        return value / 255.0f;
    }
}
