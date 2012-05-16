/*
 * Copyright (C) 2012 Neo Visionaries Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL ES vertex buffer of element array type.
 *
 * @author Takahiko Kawasaki
 */
public class ElementArrayBuffer extends VertexBuffer<ElementArrayBuffer>
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
     * Check if this element array buffer is bound.
     *
     * <p>
     * This method returns true if the value returned from
     * {@link GLESState#getElementArrayBufferBinding()} and
     * the value returned from {@link #getId()} are identical.
     * </p>
     *
     * @return
     *         True if this element array buffer is bound.
     *
     * @see GLESState#getElementArrayBufferBinding()
     */
    @Override
    public boolean isBound()
    {
        return GLESState.getElementArrayBufferBinding() == getId();
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
