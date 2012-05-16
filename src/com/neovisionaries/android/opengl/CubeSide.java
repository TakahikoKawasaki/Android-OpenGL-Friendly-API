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
 * Cube side.
 *
 * @author Takahiko Kawasaki
 */
public enum CubeSide
{
    /**
     * GL_TEXTURE_CUBE_MAP_POSITIVE_X.
     */
    POSITIVE_X(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP_POSITIVE_X()),


    /**
     * GL_TEXTURE_CUBE_MAP_NEGATIVE_X.
     */
    NEGATIVE_X(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP_NEGATIVE_X()),


    /**
     * GL_TEXTURE_CUBE_MAP_POSITIVE_Y.
     */
    POSITIVE_Y(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP_POSITIVE_Y()),


    /**
     * GL_TEXTURE_CUBE_MAP_NEGATIVE_Y.
     */
    NEGATIVE_Y(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP_NEGATIVE_Y()),


    /**
     * GL_TEXTURE_CUBE_MAP_POSITIVE_Z.
     */
    POSITIVE_Z(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP_POSITIVE_Z()),


    /**
     * GL_TEXTURE_CUBE_MAP_NEGATIVE_Z.
     */
    NEGATIVE_Z(GLESFactory.getInstance().GL_TEXTURE_CUBE_MAP_NEGATIVE_Z())
    ;


    /**
     * The integer value representing this cube side.
     */
    private final int side;


    /**
     * A constructor with a cube side.
     * 
     * @param side
     */
    private CubeSide(int side)
    {
        this.side = side;
    }


    /**
     * Get the integer representing this cube side.
     * 
     * @return
     *         The integer representing this cube side.
     */
    public int getSide()
    {
        return side;
    }
}
