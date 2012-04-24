/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import static com.neovisionaries.android.opengl.TextureState.CREATED;
import static com.neovisionaries.android.opengl.TextureState.DELETED;
import android.graphics.Bitmap;
import android.opengl.GLUtils;


/**
 * OpenGL ES texture.
 *
 * @author Takahiko Kawasaki
 */
public abstract class Texture<TTexture extends Texture<TTexture>>
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
     * Texture unit number that this texture should be bound to.
     * The possible smallest number is 0.
     */
    private int textureUnit;


    /**
     * Native texture unit number that this texture should be
     * bound to. The possible smallest number is GL_TEXTURE0.
     */
    private int nativeTextureUnit;


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
     * Get the texture unit that this texture should be bound to.
     * The default value is 0.
     *
     * @return
     *         The texture unit number. 0 means GL_TEXTURE0.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindTexture.xml">glBindTexture</a>
     */
    public int getTextureUnit()
    {
        return textureUnit;
    }


    /**
     * Set the texture unit that this texture should be bound to.
     * The default value before this method is called is 0.
     *
     * @param textureUnit
     *         A texture unit number. 0 means GL_TEXTURE0.
     *         The range of the number is from 0 to ({@link
     *         GLESState#getMaxTextureImageUnits()} - 1).
     *
     * @return
     *         This Texture object.
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>'textureUnit' is less than 0.
     * <li>'textureUnit' is equal to or greater than the state
     *      value of GL_MAX_TEXTURE_IMAGE_UNITS.
     * </ul>
     *
     * @see GLESState#getMaxTextureImageUnits()
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindTexture.xml">glBindTexture</a>
     */
    @SuppressWarnings("unchecked")
    public TTexture setTextureUnit(int textureUnit)
    {
        if (textureUnit < 0 || GLESState.getMaxTextureImageUnits() <= textureUnit)
        {
            throw new IllegalArgumentException("Texture unit is out of range.");
        }

        this.textureUnit = textureUnit;
        this.nativeTextureUnit = convertToNativeTextureUnit(textureUnit);

        return (TTexture)this;
    }


    /**
     * Convert a texture unit number (starting from 0) to a
     * corresponding native texture unit number (starting from
     * GL_TEXTURE0).
     *
     * @param textureUnit
     *         A texture unit number. The possible smallest
     *         number is 0.
     *
     * @return
     *         The corresponding native texture unit number.
     *         The possible smallest number is GL_TEXTURE0.
     */
    private static int convertToNativeTextureUnit(int textureUnit)
    {
        return textureUnit + getGLES().GL_TEXTURE0();
    }


    /**
     * Get the texture unit that this texture should be bound to.
     *
     * @return
     *         A texture unit number. The possible smallest number
     *         is GL_TEXTURE0.
     */
    int getNativeTextureUnit()
    {
        return nativeTextureUnit;
    }


    /**
     * Bind this texture using glBindTexture().
     *
     * <p>
     * If the current active texture unit is not the one that
     * this texture should be bound to (= the one that has been
     * set by {@link #setTextureUnit(int)}), glActiveTexture()
     * is called before glBindTexture().
     * </p>
     *
     * @return
     *         This Texture object.
     *
     * @throws IllegalStateException
     *         This texture has already been deleted.
     *
     * @see GLESState#getActiveTexture()
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glActiveTexture.xml">glActiveTexture</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindTexture.xml">glBindTexture</a>
     */
    @SuppressWarnings("unchecked")
    public TTexture bind()
    {
        if (state == DELETED)
        {
            throw new IllegalStateException("Texture has already been deleted.");
        }

        if (GLESState.getActiveTexture() != nativeTextureUnit)
        {
            // The current active texture unit is different from
            // the one that this texture should be bound to. So,
            // change the active texture before binding.
            getGLES().glActiveTexture(nativeTextureUnit);
        }

        // Bind the texture object.
        getGLES().glBindTexture(type.getType(), id);

        return (TTexture)this;
    }


    /**
     * Delete this texture object using glDeleteTextures().
     * If the texture object has already been deleted,
     * nothing is executed. After this method returns,
     * the state of this instance is {@link
     * TextureState#DELETED}.
     *
     * @return
     *         This Texture object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDeleteTextures.xml">glDeleteTextures</a>
     */
    @SuppressWarnings("unchecked")
    public TTexture delete()
    {
        // Check the current state of this instance.
        if (state == DELETED)
        {
            // This texture has already been deleted.
            return (TTexture)this;
        }


        int[] ids = new int[] { id };

        // Delete the texture object.
        getGLES().glDeleteTextures(1, ids, 0);

        // The texture object was deleted.
        state = DELETED;

        return (TTexture)this;
    }


    /**
     * Check if this texture is bound.
     *
     * @return
     *         True if this texture is bound.
     */
    public abstract boolean isBound();


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


    /**
     * Calls glTexParameteri(textureType, parameterId, parameterValue).
     *
     * @param parameterId
     * @param parameterValue
     *
     * @return
     *         This Texture object.
     */
    @SuppressWarnings("unchecked")
    private TTexture setParameter(int parameterId, int parameterValue)
    {
        getGLES().glTexParameteri(type.getType(), parameterId, parameterValue);

        return (TTexture)this;
    }


    /**
     * Set a mag filter.
     *
     * <p>
     * If this texture is not bound when this method is called,
     * {@link #bind()} is called before
     * glTexParameter(GL_TEXTURE_MAG_FILTER, filter.{@link
     * MagFilter#getFilter() getFilter()}) is called.
     * </p>
     *
     * @param filter
     *         A mag filter.
     *
     * @return
     *         This Texture object.
     *
     * @throws IllegalArgumentException
     *         'filter' is null.
     *
     * @throws IllegalStateException
     *         This texture has already been deleted.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glTexParameter.xml">glTexParameter</a>
     */
    public TTexture setMagFilter(MagFilter filter)
    {
        if (filter == null)
        {
            throw new IllegalArgumentException();
        }

        if (state == DELETED)
        {
            throw new IllegalStateException("Texture has already been deleted.");
        }

        if (isBound() == false)
        {
            bind();
        }

        return setParameter(getGLES().GL_TEXTURE_MAG_FILTER(), filter.getFilter());
    }


    /**
     * Set a min filter.
     *
     * <p>
     * If this texture is not bound when this method is called,
     * {@link #bind()} is called before
     * glTexParameter(GL_TEXTURE_MIN_FILTER, filter.{@link
     * MinFilter#getFilter() getFilter()}) is called.
     * </p>
     *
     * @param filter
     *         A min filter.
     *
     * @return
     *         This Texture object.
     *
     * @throws IllegalArgumentException
     *         'filter' is null.
     *
     * @throws IllegalStateException
     *         This texture has already been deleted.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glTexParameter.xml">glTexParameter</a>
     */
    public TTexture setMinFilter(MinFilter filter)
    {
        if (filter == null)
        {
            throw new IllegalArgumentException();
        }

        if (state == DELETED)
        {
            throw new IllegalStateException("Texture has already been deleted.");
        }

        if (isBound() == false)
        {
            bind();
        }

        return setParameter(getGLES().GL_TEXTURE_MIN_FILTER(), filter.getFilter());
    }


    /**
     * Set a wrap mode for S coordinates of textures.
     *
     * <p>
     * If this texture is not bound when this method is called,
     * {@link #bind()} is called before
     * glTexParameter(GL_TEXTURE_WRAP_S, mode.{@link
     * WrapMode#getMode() getMode()}) is called.
     * </p>
     *
     * @param mode
     *         A wrap mode.
     *
     * @return
     *         This Texture object.
     *
     * @throws IllegalArgumentException
     *         'mode' is null.
     *
     * @throws IllegalStateException
     *         This texture has already been deleted.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glTexParameter.xml">glTexParameter</a>
     */
    public TTexture setWrapS(WrapMode mode)
    {
        if (mode == null)
        {
            throw new IllegalArgumentException();
        }

        if (state == DELETED)
        {
            throw new IllegalStateException("Texture has already been deleted.");
        }

        if (isBound() == false)
        {
            bind();
        }

        return setParameter(getGLES().GL_TEXTURE_WRAP_S(), mode.getMode());
    }


    /**
     * Set a wrap mode for T coordinates of textures.
     *
     * <p>
     * If this texture is not bound when this method is called,
     * {@link #bind()} is called before
     * glTexParameter(GL_TEXTURE_WRAP_T, mode.{@link
     * WrapMode#getMode() getMode()}) is called.
     * </p>
     *
     * @param mode
     *         A wrap mode.
     *
     * @return
     *         This Texture object.
     *
     * @throws IllegalArgumentException
     *         'mode' is null.
     *
     * @throws IllegalStateException
     *         This texture has already been deleted.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glTexParameter.xml">glTexParameter</a>
     */
    public TTexture setWrapT(WrapMode mode)
    {
        if (mode == null)
        {
            throw new IllegalArgumentException();
        }

        if (state == DELETED)
        {
            throw new IllegalStateException("Texture has already been deleted.");
        }

        if (isBound() == false)
        {
            bind();
        }

        return setParameter(getGLES().GL_TEXTURE_WRAP_T(), mode.getMode());
    }


    /**
     * Calls {@link #bind()} if this texture is not bound yet
     * and then calls <a
     * href="http://developer.android.com/reference/android/opengl/GLUtils.html#texImage2D(int,%20int,%20android.graphics.Bitmap,%20int)"
     * >GLUtils.texImage2D</a>(target, bitmap, level).
     *
     * @param target
     * @param bitmap
     * @param level
     *
     * @return
     *         This Texture object.
     */
    @SuppressWarnings("unchecked")
    TTexture loadImage(int target, Bitmap bitmap, int level)
    {
        if (bitmap == null || level < 0)
        {
            throw new IllegalArgumentException();
        }

        if (state == DELETED)
        {
            throw new IllegalStateException("Texture has already been deleted.");
        }

        if (isBound() == false)
        {
            bind();
        }

        GLUtils.texImage2D(target, level, bitmap, 0);

        return (TTexture)this;
    }


    /**
     * Generate mipmaps.
     *
     * <p>
     * If this texture is not bound when this method is called,
     * {@link #bind()} is called first. Then glGenerateMipmap()
     * is called.
     * </p>
     *
     * @return
     *         This Texture object.
     *
     * @throws IllegalStateException
     *         This texture has already been deleted.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenerateMipmap.xml">glGenerateMipmap</a>
     */
    @SuppressWarnings("unchecked")
    public TTexture generateMipmap()
    {
        if (state == DELETED)
        {
            throw new IllegalStateException("Texture has already been deleted.");
        }
        
        if (isBound() == false)
        {
            bind();
        }

        getGLES().glGenerateMipmap(type.getType());

        return (TTexture)this;
    }
}
