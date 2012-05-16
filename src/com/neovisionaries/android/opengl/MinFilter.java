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
 * Filters for GL_TEXTURE_MIN_FILTER.
 *
 * @author Takahiko Kawasaki
 *
 * @see Texture#setMinFilter(MinFilter)
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glTexParameter.xml">glTexParameter</a>
 */
public enum MinFilter
{
    /**
     * GL_NEAREST.
     */
    NEAREST(GLESFactory.getInstance().GL_NEAREST()),


    /**
     * GL_LINEAR.
     */
    LINEAR(GLESFactory.getInstance().GL_LINEAR()),


    /**
     * GL_NEAREST_MIPMAP_NEAREST.
     */
    NEAREST_MIPMAP_NEAREST(GLESFactory.getInstance().GL_NEAREST_MIPMAP_NEAREST()),


    /**
     * GL_NEAREST_MIPMAP_LINEAR.
     */
    NEAREST_MIPMAP_LINEAR(GLESFactory.getInstance().GL_NEAREST_MIPMAP_LINEAR()),


    /**
     * LINEAR_MIPMAP_NEAREST.
     */
    LINEAR_MIPMAP_NEAREST(GLESFactory.getInstance().GL_LINEAR_MIPMAP_NEAREST()),


    /**
     * LINEAR_MIPMAP_LINEAR.
     */
    LINEAR_MIPMAP_LINEAR(GLESFactory.getInstance().GL_LINEAR_MIPMAP_LINEAR())
    ;


    /**
     * The integer representing this min filter.
     */
    private final int filter;


    /**
     * A constructor with a min filter.
     *
     * @param filter
     *         A mag filter.
     */
    private MinFilter(int filter)
    {
        this.filter = filter;
    }


    /**
     * Get the integer representing this min filter.
     *
     * @return
     *         The integer representing this min filter.
     */
    public int getFilter()
    {
        return filter;
    }
}
