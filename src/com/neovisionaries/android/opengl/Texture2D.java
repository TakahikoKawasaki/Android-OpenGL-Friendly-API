/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * OpenGL ES 2D texture.
 *
 * @author Takahiko Kawasaki
 */
public class Texture2D extends Texture
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
}
