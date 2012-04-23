/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import android.graphics.Bitmap;


/**
 * OpenGL ES cube map texture.
 *
 * @author Takahiko Kawasaki
 */
public class TextureCubeMap extends Texture
{
    /**
     * A constructor to create a cube map texture
     * (GL_TEXTURE_CUBE_MAP). {@link Texture#Texture(TextureType)
     * super}({@link TextureType#CUBE_MAP}) is called.
     * After this constructor returns, the state of
     * this instance is {@link TextureState#CREATED
     * CREATED}.
     *
     * @throws GLESException
     *         glGenTextures() failed.
     *
     * @see Texture#Texture(TextureType)
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenTextures.xml">glGenTextures</a>
     */
    public TextureCubeMap() throws GLESException
    {
        super(TextureType.CUBE_MAP);
    }


    /**
     * Set a mag filter for cube map textures.
     *
     * @param filter
     *
     * @throws IllegalArgumentException
     *         The given argument is null.
     */
    public static void setMagFilter(MagFilter filter)
    {
        Texture.setMagFilter(TextureType.CUBE_MAP, filter);
    }


    /**
     * Set a min filter for cube map textures.
     *
     * @param filter
     *
     * @throws IllegalArgumentException
     *         The given argument is null.
     */
    public static void setMinFilter(MinFilter filter)
    {
        Texture.setMinFilter(TextureType.CUBE_MAP, filter);
    }


    /**
     * Set a wrap mode for S coordinates of cube map textures.
     *
     * @param mode
     *
     * @throws IllegalArgumentException
     *         The given argument is null.
     */
    public static void setWrapS(WrapMode mode)
    {
        Texture.setWrapS(TextureType.CUBE_MAP, mode);
    }


    /**
     * Set a wrap mode for T coordinates of cube map textures.
     *
     * @param mode
     *
     * @throws IllegalArgumentException
     *         The given argument is null.
     */
    public static void setWrapT(WrapMode mode)
    {
        Texture.setWrapT(TextureType.CUBE_MAP, mode);
    }


    /**
     * Check if this 2D texture is bound.
     *
     * <p>
     * This method returns true if the value returned from
     * {@link GLESState#getTextureBindingCubeMap()} and
     * the value returned from {@link #getId()} are identical.
     * </p>
     *
     * @return
     *         True if this 2D texture is bound.
     *
     * @see GLESState#getTextureBindingCubeMap()
     */
    @Override
    public boolean isBound()
    {
        return GLESState.getTextureBindingCubeMap() == getId();
    }


    /**
     * Load an image at the positive X.
     *
     * <p>
     * If this texture is not bound when this method
     * is called, {@link #bind() bind()} is called first. Then,
     * <a href="http://developer.android.com/reference/android/opengl/GLUtils.html#texImage2D(int,%20int,%20android.graphics.Bitmap,%20int)"
     * >GLUtils.texImage2D</a>(GL_TEXTURE_CUBE_MAP_POSITIVE_X,
     * level, bitmap, 0) is called.
     * </p>
     *
     * @param bitmap
     *         Image to load.
     *
     * @param level
     *         Mipmap level.
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
    public void loadImagePositiveX(Bitmap bitmap, int level)
    {
        super.loadImage(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP_POSITIVE_X(), bitmap, level);
    }


    /**
     * This method is an alias of {@link #loadImagePositiveX(Bitmap, int)
     * loadImagePositiveX}(bitmap, 0).
     */
    public void loadImagePositiveX(Bitmap bitmap)
    {
        loadImagePositiveX(bitmap, 0);
    }


    /**
     * Load an image at the negative X.
     *
     * <p>
     * If this texture is not bound when this method
     * is called, {@link #bind() bind()} is called first. Then,
     * <a href="http://developer.android.com/reference/android/opengl/GLUtils.html#texImage2D(int,%20int,%20android.graphics.Bitmap,%20int)"
     * >GLUtils.texImage2D</a>(GL_TEXTURE_CUBE_MAP_NEGATIVE_X,
     * level, bitmap, 0) is called.
     * </p>
     *
     * @param bitmap
     *         Image to load.
     *
     * @param level
     *         Mipmap level.
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
    public void loadImageNegativeX(Bitmap bitmap, int level)
    {
        super.loadImage(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP_NEGATIVE_X(), bitmap, level);
    }


    /**
     * This method is an alias of {@link #loadImageNegativeX(Bitmap, int)
     * loadImageNegativeX}(bitmap, 0).
     */
    public void loadImageNegativeX(Bitmap bitmap)
    {
        loadImageNegativeX(bitmap, 0);
    }


    /**
     * Load an image at the positive Y.
     *
     * <p>
     * If this texture is not bound when this method
     * is called, {@link #bind() bind()} is called first. Then,
     * <a href="http://developer.android.com/reference/android/opengl/GLUtils.html#texImage2D(int,%20int,%20android.graphics.Bitmap,%20int)"
     * >GLUtils.texImage2D</a>(GL_TEXTURE_CUBE_MAP_POSITIVE_Y,
     * level, bitmap, 0) is called.
     * </p>
     *
     * @param bitmap
     *         Image to load.
     *
     * @param level
     *         Mipmap level.
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
    public void loadImagePositiveY(Bitmap bitmap, int level)
    {
        super.loadImage(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP_POSITIVE_Y(), bitmap, level);
    }


    /**
     * This method is an alias of {@link #loadImagePositiveY(Bitmap, int)
     * loadImagePositiveY}(bitmap, 0).
     */
    public void loadImagePositiveY(Bitmap bitmap)
    {
        loadImagePositiveY(bitmap, 0);
    }


    /**
     * Load an image at the negative Y.
     *
     * <p>
     * If this texture is not bound when this method
     * is called, {@link #bind() bind()} is called first. Then,
     * <a href="http://developer.android.com/reference/android/opengl/GLUtils.html#texImage2D(int,%20int,%20android.graphics.Bitmap,%20int)"
     * >GLUtils.texImage2D</a>(GL_TEXTURE_CUBE_MAP_NEGATIVE_Y,
     * level, bitmap, 0) is called.
     * </p>
     *
     * @param bitmap
     *         Image to load.
     *
     * @param level
     *         Mipmap level.
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
    public void loadImageNegativeY(Bitmap bitmap, int level)
    {
        super.loadImage(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP_NEGATIVE_Y(), bitmap, level);
    }


    /**
     * This method is an alias of {@link #loadImageNegativeY(Bitmap, int)
     * loadImageNegativeY}(bitmap, 0).
     */
    public void loadImageNegativeY(Bitmap bitmap)
    {
        loadImageNegativeY(bitmap, 0);
    }


    /**
     * Load an image at the positive Z.
     *
     * <p>
     * If this texture is not bound when this method
     * is called, {@link #bind() bind()} is called first. Then,
     * <a href="http://developer.android.com/reference/android/opengl/GLUtils.html#texImage2D(int,%20int,%20android.graphics.Bitmap,%20int)"
     * >GLUtils.texImage2D</a>(GL_TEXTURE_CUBE_MAP_POSITIVE_Z,
     * level, bitmap, 0) is called.
     * </p>
     *
     * @param bitmap
     *         Image to load.
     *
     * @param level
     *         Mipmap level.
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
    public void loadImagePositiveZ(Bitmap bitmap, int level)
    {
        super.loadImage(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP_POSITIVE_Z(), bitmap, level);
    }


    /**
     * This method is an alias of {@link #loadImagePositiveZ(Bitmap, int)
     * loadImagePositiveZ}(bitmap, 0).
     */
    public void loadImagePositiveZ(Bitmap bitmap)
    {
        loadImagePositiveZ(bitmap, 0);
    }


    /**
     * Load an image at the negative Z.
     *
     * <p>
     * If this texture is not bound when this method
     * is called, {@link #bind() bind()} is called first. Then,
     * <a href="http://developer.android.com/reference/android/opengl/GLUtils.html#texImage2D(int,%20int,%20android.graphics.Bitmap,%20int)"
     * >GLUtils.texImage2D</a>(GL_TEXTURE_CUBE_MAP_NEGATIVE_Z,
     * level, bitmap, 0) is called.
     * </p>
     *
     * @param bitmap
     *         Image to load.
     *
     * @param level
     *         Mipmap level.
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
    public void loadImageNegativeZ(Bitmap bitmap, int level)
    {
        super.loadImage(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP_NEGATIVE_Z(), bitmap, level);
    }


    /**
     * This method is an alias of {@link #loadImageNegativeZ(Bitmap, int)
     * loadImageNegativeZ}(bitmap, 0).
     */
    public void loadImageNegativeZ(Bitmap bitmap)
    {
        loadImageNegativeZ(bitmap, 0);
    }
}
