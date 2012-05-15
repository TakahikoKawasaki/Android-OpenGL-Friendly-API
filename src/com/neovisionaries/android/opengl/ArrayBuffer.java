/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL ES vertex buffer of array type.
 *
 * @author Takahiko Kawasaki
 */
public class ArrayBuffer extends VertexBuffer<ArrayBuffer>
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
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenBuffers.xml">glGenBuffers</a>
     */
    public ArrayBuffer() throws GLESException
    {
        super(VertexBufferType.ARRAY);
    }


    /**
     * Check if this array buffer is bound.
     *
     * <p>
     * This method returns true if the value returned from
     * {@link GLESState#getArrayBufferBinding()} and
     * the value returned from {@link #getId()} are identical.
     * </p>
     *
     * @return
     *         True if this array buffer is bound.
     *
     * @see GLESState#getArrayBufferBinding()
     */
    @Override
    public boolean isBound()
    {
        return GLESState.getArrayBufferBinding() == getId();
    }


    /**
     * Unbind the array buffer (call glBindBuffer(GL_ARRAY_BUFFER, 0)).
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindBuffer.xml">glBindBuffer</a>
     */
    public static void unbind()
    {
        GLES gles = GLESFactory.getInstance();

        gles.glBindBuffer(gles.GL_ARRAY_BUFFER(), 0);
    }
}
