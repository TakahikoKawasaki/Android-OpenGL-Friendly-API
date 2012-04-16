/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL vertex buffer of element array type.
 *
 * @author Takahiko Kawasaki
 */
public class ElementArrayBuffer extends VertexBuffer
{
    /**
     * A constructor to create a vertex buffer of element
     * array type (GL_ELEMENT_ARRAY_BUFFER). {@link
     * VertexBuffer#VertexBuffer(VertexBufferType)
     * super}({@link VertexBufferType#ELEMENT_ARRAY}) is
     * called. After this constructor returns, the state
     * of this instance is {@link VertexBufferState#CREATED
     * CREATED}.
     *
     * @throws GLESException
     *         glGenBuffers() failed.
     *
     * @see VertexBuffer#VertexBuffer(VertexBufferType)
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenBuffers.xml">glGenBuffers</a>
     */
    public ElementArrayBuffer() throws GLESException
    {
        super(VertexBufferType.ELEMENT_ARRAY);
    }


    /**
     * Unbind the element array buffer (call
     * glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0)).
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindBuffer.xml">glBindBuffer</a>
     */
    public static void unbind()
    {
        GLES gles = GLESFactory.getInstance();

        gles.glBindBuffer(gles.GL_ELEMENT_ARRAY_BUFFER(), 0);
    }
}
