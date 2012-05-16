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
 * Texture type.
 *
 * @author Takahiko Kawasaki
 */
public enum TextureType
{
    /**
     * GL_TEXTURE_2D.
     */
    TWO_D(GLESFactory.getInstance().GL_TEXTURE_2D()),


    /**
     * GL_TEXTURE_CUBE_MAP.
     */
    CUBE_MAP(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP())
    ;


    /**
     * The integer representing this texture type.
     */
    private final int type;


    /**
     * A constructor with a texture type.
     * @param type
     */
    private TextureType(int type)
    {
        this.type = type;
    }


    /**
     * Get the integer representing this texture type.
     *
     * @return
     *         The integer representing this texture type.
     */
    public int getType()
    {
        return type;
    }
}
