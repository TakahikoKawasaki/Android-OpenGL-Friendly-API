/*
 * (C) 2011-2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * A builder to build a byte array from data objects.
 * 
 * @author Takahiko Kawasaki
 */
class DataBuilder
{
    /**
     * The buffer size used as (1) the initial buffer size of the
     * internal ByteArrayOutputStream instance when the default
     * constructor is used, and (2) the size of the temporary
     * buffer used in append(InputStream).
     */
    private static final int BUFFER_SIZE = 8192;


    /**
     * The place to hold appended data.
     */
    private final ByteArrayOutputStream baos;


    /**
     * The instance to provide DataOutputStream methods to append
     * data into the internal ByteArrayOutputStream instance.
     */
    private final DataOutputStream dos;


    /**
     * The default constructor.
     */
    public DataBuilder()
    {
        this(BUFFER_SIZE);
    }


    /**
     * A constructor with the initial buffer size of the internal
     * ByteArrayOutputStream instance.
     * 
     * @param size
     *        The initial buffer size of the internal
     *        ByteArrayOutputStream instance. If 0 or a negative
     *        value is given, the internal default size is used.
     */
    public DataBuilder(int size)
    {
        if (size <= 0)
        {
            // The given value is invalid. Use the default size.
            size = BUFFER_SIZE;
        }

        baos = new ByteArrayOutputStream(size);
        dos = new DataOutputStream(baos);
    }


    /**
     * Append a boolean data to this instance.
     */
    public void append(boolean data)
    {
        try
        {
            dos.writeBoolean(data);
        }
        catch (IOException e)
        {
        }
    }


    /**
     * Append a byte data to this instance.
     */
    public void append(byte data)
    {
        try
        {
            dos.writeByte(data);
        }
        catch (IOException e)
        {
        }
    }


    /**
     * Append a byte array into this instance.
     */
    public void append(byte[] data)
    {
        append(data, 0, data.length);
    }


    /**
     * Append a byte array to this instance.
     * 
     * @param data
     *        A data source.
     * @param offset
     *        Offset from the start of the data source.
     * @param length
     *        The number of bytes to append.
     */
    public void append(byte[] data, int offset, int length)
    {
        try
        {
            dos.write(data, offset, length);
        }
        catch (IOException e)
        {
        }
    }


    /**
     * Append a char data to this instance.
     */
    public void append(char data)
    {
        try
        {
            dos.writeChar(data);
        }
        catch (IOException e)
        {
        }
    }


    /**
     * Append a short data to this instance.
     */
    public void append(short data)
    {
        try
        {
            dos.writeShort(data);
        }
        catch (IOException e)
        {
        }
    }


    /**
     * Append an int data to this instance.
     */
    public void append(int data)
    {
        try
        {
            dos.writeInt(data);
        }
        catch (IOException e)
        {
        }
    }


    /**
     * Append a long data to this instance.
     */
    public void append(long data)
    {
        try
        {
            dos.writeLong(data);
        }
        catch (IOException e)
        {
        }
    }


    /**
     * Append a float data to this instance.
     */
    public void append(float data)
    {
        try
        {
            dos.writeFloat(data);
        }
        catch (IOException e)
        {
        }
    }


    /**
     * Append a double data to this instance.
     */
    public void append(double data)
    {
        try
        {
            dos.writeDouble(data);
        }
        catch (IOException e)
        {
        }
    }


    /**
     * Append a String data to this instance.
     */
    public void append(String data)
    {
        try
        {
            dos.writeUTF(data);
        }
        catch (IOException e)
        {
        }
    }


    /**
     * Read all the bytes from the given input stream and add them
     * into this instance.
     * 
     * @param in
     *        An input stream to read bytes from.
     * @throws IOException
     */
    public void append(InputStream in) throws IOException
    {
        // Create a buffer for read operation.
        byte[] buffer = new byte[BUFFER_SIZE];

        // Create a BufferedInputStream to read data effectively.
        BufferedInputStream bis = new BufferedInputStream(in, buffer.length);

        while (true)
        {
            // Read bytes from the input stream into the buffer.
            int nRead = bis.read(buffer);

            if (nRead == -1)
            {
                // Reached the end of the input stream.
                break;
            }

            // Put the read bytes into the internal DataOutputStream instance.
            dos.write(buffer, 0, nRead);
        }
    }


    /**
     * Convert accumulated data into a byte array.
     * 
     * This method is supposed to be called to get the final result
     * after all necessary calls of append() methods finish.
     * 
     * append() methods should not be called after this method is called
     * because the internal DataOutputStream instance is closed in this method.
     * 
     * @return A byte array containing data appended to this instance so far.
     */
    public byte[] toData()
    {
        byte[] data = null;

        try
        {
            // Flush all data in the DataOutputStream into the internal
            // ByteArrayOutputStream instance.
            dos.flush();

            // Extract data in the internal ByteArrayOutputStream as a byte
            // array.
            data = baos.toByteArray();

            // Close the DataOutputStream instance.
            dos.close();
        }
        catch (IOException e)
        {
        }

        return data;
    }
}
