/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;

import android.graphics.Bitmap;


/**
 * OpenGL ES 2D texture.
 *
 * @author Takahiko Kawasaki
 */
public class Texture2D extends Texture<Texture2D>
{
    /**
     * A constructor to create a 2D texture (GL_TEXTURE_2D).
     * {@link Texture#Texture(TextureType) super}({@link
     * TextureType#TWO_D}) is called. After this constructor
     * returns, the state of this instance is {@link
     * TextureState#CREATED CREATED}.
     *
     * @throws GLESException
     *         glGenTextures() failed.
     *
     * @see Texture#Texture(TextureType)
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenTextures.xml">glGenTextures</a>
     */
    public Texture2D() throws GLESException
    {
        super(TextureType.TWO_D);
    }


    /**
     * Check if this 2D texture is bound.
     *
     * <p>
     * This method returns true if the value returned from
     * {@link GLESState#getTextureBinding2D()} and
     * the value returned from {@link #getId()} are identical.
     * </p>
     *
     * @return
     *         True if this 2D texture is bound.
     *
     * @see GLESState#getTextureBinding2D()
     */
    @Override
    public boolean isBound()
    {
        return GLESState.getTextureBinding2D() == getId();
    }


    /**
     * Load an image.
     *
     * <p>
     * If this texture is not bound when this method
     * is called, {@link #bind() bind()} is called first. Then,
     * <a href="http://developer.android.com/reference/android/opengl/GLUtils.html#texImage2D(int,%20int,%20android.graphics.Bitmap,%20int)"
     * >GLUtils.texImage2D</a>(GL_TEXTURE_2D, level, bitmap, 0)
     * is called.
     * </p>
     *
     * @param bitmap
     *         Image to load.
     *
     * @param level
     *         Mipmap level.
     *
     * @return
     *         This Texture object.
     *
     * @throws IllegalArgumentException
     *         'bitmap' is null or 'level' is less than 0.
     *
     * @throws IllegalStateException
     *         This texture has already been deleted.
     *
     * @see <a href="http://developer.android.com/reference/android/opengl/GLUtils.html#texImage2D(int,%20int,%20android.graphics.Bitmap,%20int)"
     *       >GLUtils.texImage2D</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glTexImage2D.xml">glTexImage2D</a>
     */
    public Texture2D loadImage(Bitmap bitmap, int level)
    {
        return super.loadImage(GLESFactory.getInstance().GL_TEXTURE_2D(), bitmap, level);
    }


    /**
     * This method is an alias of {@link #loadImage(Bitmap, int)
     * loadImage}(bitmap, 0).
     */
    public Texture2D loadImage(Bitmap bitmap)
    {
        return loadImage(bitmap, 0);
    }
}
