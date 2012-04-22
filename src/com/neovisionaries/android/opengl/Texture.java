/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import static com.neovisionaries.android.opengl.TextureState.CREATED;
import static com.neovisionaries.android.opengl.TextureState.DELETED;


/**
 * OpenGL ES texture.
 *
 * @author Takahiko Kawasaki
 */
public abstract class Texture
{
    /**
     * Type of the texture object.
     */
    private final TextureType type;


    /**
     * ID of the texture object assigned by glGenTextures().
     */
    private final int id;


    /**
     * State of this texture.
     */
    private TextureState state = CREATED;


    /**
     * A constructor with a texture type. A texture object is
     * assigned internally by glGenTextures(). If this constructor
     * returns without any exception, the state of this instance
     * is {@link TextureState#CREATED}.
     *
     * @param type
     *         A texture type.
     *
     * @throws IllegalArgumentException
     *         The given argument is null.
     *
     * @throws GLESException
     *         glGenTextures() failed.
     *
     * @see Texture2D#Texture2D()
     * @see TextureCubeMap#TextureCubeMap()
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenTextures.xml">glGenTextures</a>
     */
    protected Texture(TextureType type) throws GLESException
    {
        if (type == null)
        {
            throw new IllegalArgumentException();
        }

        // Texture IDs assigned by glGenTextures().
        int[] ids = new int[1];

        // Create a Texture object.
        getGLES().glGenTextures(type.getType(), ids, 0);

        // Check if a valid texture object hasbeen created.
        if (ids[0] <= 0)
        {
            throw new GLESException("glGenTextures() failed.");
        }

        // A texture object was created successfully.

        // Type of the texture object.
        this.type = type;

        // ID of the texture object.
        this.id = ids[0];
    }


    /**
     * Get the type of this texture.
     *
     * @return
     *         The type of this texture.
     */
    public TextureType getType()
    {
        return type;
    }


    /**
     * Get the ID of this texture.
     *
     * @return
     *         The ID of this texture assigned by glGenTextures().
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenTextures.xml">glGenTextures</a>
     */
    public int getId()
    {
        return id;
    }


    /**
     * Get the state of this texture.
     *
     * @return
     *         The state of this texture.
     */
    public TextureState getState()
    {
        return state;
    }


    /**
     * Bind this texture using glBindTexture().
     *
     * @throws IllegalStateException
     *         This texture has already been deleted.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindTexture.xml">glBindTexture</a>
     */
    public void bind()
    {
        if (state == DELETED)
        {
            throw new IllegalStateException("Texture has already been deleted.");
        }

        // Bind the texture object.
        getGLES().glBindTexture(type.getType(), id);
    }


    /**
     * Delete this texture object using glDeleteTextures().
     * If the texture object has already been deleted,
     * nothing is executed. After this method returns,
     * the state of this instance is {@link
     * TextureState#DELETED}.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDeleteTextures.xml">glDeleteTextures</a>
     */
    public void delete()
    {
        // Check the current state of this instance.
        if (state == DELETED)
        {
            // This texture has already been deleted.
            return;
        }


        int[] ids = new int[] { id };

        // Delete the texture object.
        getGLES().glDeleteTextures(1, ids, 0);

        // The texture object was deleted.
        state = DELETED;
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


    private static void setParameter(int textureType, int parameterId, int parameterValue)
    {
        getGLES().glTexParameteri(textureType, parameterId, parameterValue);
    }


    static void setMagFilter(TextureType type, MagFilter filter)
    {
        if (filter == null)
        {
            throw new IllegalArgumentException();
        }

        setParameter(type.getType(), getGLES().GL_TEXTURE_MAG_FILTER(), filter.getFilter());
    }


    static void setMinFilter(TextureType type, MinFilter filter)
    {
        if (filter == null)
        {
            throw new IllegalArgumentException();
        }

        setParameter(type.getType(), getGLES().GL_TEXTURE_MIN_FILTER(), filter.getFilter());
    }


    static void setWrapS(TextureType type, WrapMode mode)
    {
        if (mode == null)
        {
            throw new IllegalArgumentException();
        }

        setParameter(type.getType(), getGLES().GL_TEXTURE_WRAP_S(), mode.getMode());
    }


    static void setWrapT(TextureType type, WrapMode mode)
    {
        if (mode == null)
        {
            throw new IllegalArgumentException();
        }

        setParameter(type.getType(), getGLES().GL_TEXTURE_WRAP_T(), mode.getMode());
    }
}
