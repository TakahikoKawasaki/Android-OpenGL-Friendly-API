/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


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
}
