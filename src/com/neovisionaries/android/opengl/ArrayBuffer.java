/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL vertex buffer of array type.
 *
 * @author Takahiko Kawasaki
 */
public class ArrayBuffer extends VertexBuffer
{
    /**
     * A constructor to create a vertex buffer of array type
     * (GL_ARRAY_BUFFER). {@link VertexBuffer#VertexBuffer(VertexBufferType)
     * super}({@link VertexBufferType#ARRAY}) is called.
     * After this constructor returns, the state of this
     * instance is {@link VertexBufferState#CREATED CREATED}.
     *
     * @throws GLESException
     *         glGenBuffers() failed.
     *
     * @see VertexBuffer#VertexBuffer(VertexBufferType)
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glGenBuffers.xml">glGenBuffers</a>
     */
    public ArrayBuffer() throws GLESException
    {
        super(VertexBufferType.ARRAY);
    }


    /**
     * Unbind the array buffer (call glBindBuffer(GL_ARRAY_BUFFER, 0)).
     *
     * @see <a href="http://www.opengl.org/sdk/docs/man/xhtml/glBindBuffer.xml">glBindBuffer</a>
     */
    public static void unbind()
    {
        GLES gles = GLESFactory.getInstance();

        gles.glBindBuffer(gles.GL_ARRAY_BUFFER(), 0);
    }
}
