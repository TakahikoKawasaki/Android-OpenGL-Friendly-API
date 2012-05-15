/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import static com.neovisionaries.android.opengl.RenderBufferState.CREATED;
import static com.neovisionaries.android.opengl.RenderBufferState.DELETED;


/**
 * OpenGL ES render buffer.
 *
 * @author Takahiko Kawasaki
 */
public class RenderBuffer
{
    /**
     * ID of the render buffer object assigned by glGenRenderbuffers().
     */
    private final int id;


    /**
     * State of this render buffer.
     */
    private RenderBufferState state = CREATED;


    /**
     * A constructor. A render buffer object is assigned internally by
     * glGenRenderbuffers(). If this constructor returns without any
     * exception, the state of this instance is {@link
     * RenderBufferState#CREATED}.
     *
     * @throws GLESException
     *         glGenRenderbuffers() failed.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenRenderbuffers.xml">glGenRenderbuffers</a>
     */
    public RenderBuffer() throws GLESException
    {
        // Render buffer IDs assigned by glGenRenderbuffers().
        int[] ids = new int[] { 0 };

        // Create a render buffer object.
        getGLES().glGenRenderbuffers(1, ids, 0);

        // Check if a valid render buffer object has been created.
        if (ids[0] <= 0)
        {
            // Failed to create a buffer object.
            throw new GLESException("glGenRenderbuffers() failed.");
        }

        // A render buffer object was created successfully.

        // ID of the render buffer object.
        id = ids[0];
    }


    /**
     * A constructor with format parameters. A render buffer is assigned
     * internally by glGenRenderbuffers() and then format parameters are
     * set to the render buffer by glRenderbufferStorage(). If this
     * constructor returns without any exception, the state of this
     * instance is {@link RenderBufferState#CREATED}.
     *
     * <p>
     * This constructor does the same thing as follows.
     * </p>
     *
     * <pre style="background: lightgray;">
     *
     * new {@link #RenderBuffer()}.{@link #setFormat(RenderBufferFormat,
     * int, int) setFormat}(format, width, height);
     * </pre>
     *
     * @param format
     * @param width
     * @param height
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>The argument 'format' is null.
     * <li>The argument 'width' is less than 0 or greater than
     *     GL_MAX_RENDERBUFFER_SIZE.
     * <li>The argument 'height' is less than 0 or greater than
     *     GL_MAX_RENDERBUFFER_SIZE.
     * </ul>
     *
     * @throws GLESException
     *         glGenRenderbuffers() failed.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenRenderbuffers.xml">glGenRenderbuffers</a>
     */
    public RenderBuffer(RenderBufferFormat format, int width, int height) throws GLESException
    {
        this();

        setFormat(this, format, width, height);
    }


    /**
     * Get the ID of the render buffer object assigned to this instance.
     *
     * @return
     *         The ID of the render buffer object assigned by glGenRenderbuffers().
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenRenderbuffers.xml">glGenRenderbuffers</a>
     */
    public int getId()
    {
        return id;
    }


    /**
     * Get the state of this render buffer.
     *
     * @return
     *         The current state of this render buffer.
     */
    public RenderBufferState getState()
    {
        return state;
    }


    /**
     * Bind this render buffer using glBindRenderbuffer().
     *
     * @return
     *         This RenderBuffer object.
     *
     * @throws IllegalStateException
     *         This render buffer has already been deleted.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindRenderbuffer.xml">glBindRenderbuffer</a>
     */
    public RenderBuffer bind()
    {
        if (state == DELETED)
        {
            throw new IllegalStateException("Render buffer has already been deleted.");
        }

        // Bind the render buffer object.
        getGLES().glBindRenderbuffer(getGLES().GL_RENDERBUFFER(), id);

        return this;
    }


    /**
     * Check if this render buffer is bound.
     *
     * <p>
     * This method returns true if the value returned from
     * {@link GLESState#getRenderbufferBinding()} and
     * the value returned from {@link #getId()} are identical.
     * </p>
     *
     * @return
     *         True if this render buffer is bound.
     *
     * @see GLESState#getRenderbufferBinding()
     */
    public boolean isBound()
    {
        return (GLESState.getRenderbufferBinding() == getId());
    }


    /**
     * Delete the render buffer object using glDeleteRenderbuffers().
     * If the render buffer object has already been deleted, nothing
     * is executed. After this method returns, the state of this
     * instance is {@link RenderBufferState#DELETED}.
     *
     * @return
     *         This RenderBuffer object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDeleteRenderbuffers.xml">glDeleteRenderbuffers</a>
     */
    public RenderBuffer delete()
    {
        // Check the current state of this instance.
        if (state == DELETED)
        {
            return this;
        }

        int[] ids = new int[] { id };

        // Delete the render buffer object.
        getGLES().glDeleteRenderbuffers(1, ids, 0);

        // The buffer object was deleted.
        state = DELETED;

        return this;
    }


    /**
     * Set format, width and height of this render buffer using
     * glRenderbufferStorage().
     *
     * <p>
     * If this render buffer is not bound when this method is called,
     * {@link #bind()} is called before glRenderbufferStorage().
     * </p>
     * 
     * @param format
     * @param width
     * @param height
     *
     * @return
     *         This RenderBuffer object.
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>The argument 'format' is null.
     * <li>The argument 'width' is less than 0 or greater than
     *     GL_MAX_RENDERBUFFER_SIZE.
     * <li>The argument 'height' is less than 0 or greater than
     *     GL_MAX_RENDERBUFFER_SIZE.
     * </ul>
     *
     * @throws IllegalStateException
     *         This render buffer has already been deleted.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glRenderbufferStorage.xml">glRenderbufferStorage</a>
     * @see GLESState#getMaxRenderbufferSize()
     */
    public RenderBuffer setFormat(RenderBufferFormat format, int width, int height)
    {
        return setFormat(this, format, width, height);
    }


    private static RenderBuffer setFormat(RenderBuffer renderBuffer, RenderBufferFormat format, int width, int height)
    {
        // Check the argument 'format'.
        if (format == null)
        {
            throw new IllegalArgumentException("Render buffer format is not specified.");
        }

        // Get the maximum size of the implementation of render buffers.
        int max = GLESState.getMaxRenderbufferSize();

        // Check the argument 'width'.
        if (width < 0 || max < width)
        {
            throw new IllegalArgumentException("The specified width (" + width + ") is out of range.");
        }

        // Check the argument 'height'.
        if (height < 0 || max < height)
        {
            throw new IllegalArgumentException("The specified height (" + height + ") is out of range.");
        }

        // Check the current state of this instance.
        if (renderBuffer.getState() == DELETED)
        {
            throw new IllegalStateException("Render buffer has already been deleted.");
        }

        // Check if the render buffer is bound.
        if (renderBuffer.isBound() == false)
        {
            // Bind the render buffer.
            renderBuffer.bind();
        }

        // Set the format, width and height of the render buffer.
        getGLES().glRenderbufferStorage(getGLES().GL_RENDERBUFFER(), format.getFormat(), width, height);

        return renderBuffer;
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
}
