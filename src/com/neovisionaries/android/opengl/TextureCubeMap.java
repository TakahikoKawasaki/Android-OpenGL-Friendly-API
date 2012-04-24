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
public class TextureCubeMap extends Texture<TextureCubeMap>
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
     * Load an image.
     *
     * <p>
     * If this texture is not bound when this method is called,
     * {@link #bind() bind()} is called first. Then,
     * <a href="http://developer.android.com/reference/android/opengl/GLUtils.html#texImage2D(int,%20int,%20android.graphics.Bitmap,%20int)"
     * >GLUtils.texImage2D</a>(side.{@link CubeSide#getSide()
     * getSide()}, level, bitmap, 0) is called.
     * </p>
     *
     * @param bitmap
     *         Image to load.
     *
     * @param level
     *         Mipmap level.
     *
     * @param side
     *         Cube side.
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
    public TextureCubeMap loadImage(Bitmap bitmap, int level, CubeSide side)
    {
        if (side == null)
        {
            throw new IllegalArgumentException("side is null.");
        }

        return super.loadImage(side.getSide(), bitmap, level);
    }


    /**
     * This method is an alias of {@link #loadImage(Bitmap, int,
     * CubeSide) loadImage}(bitmap, 0, side).
     */
    public TextureCubeMap loadImage(Bitmap bitmap, CubeSide side)
    {
        return loadImage(bitmap, 0, side);
    }
}
