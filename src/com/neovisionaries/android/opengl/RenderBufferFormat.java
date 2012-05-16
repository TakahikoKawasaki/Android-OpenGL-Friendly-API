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
 * Format of render buffer.
 *
 * @author Takahiko Kawasaki
 *
 * @see RenderBuffer#setFormat(RenderBufferFormat, int, int)
 */
public enum RenderBufferFormat
{
    /**
     * GL_RGB565.
     */
    RGB565(GLESFactory.getInstance().GL_RGB565()),


    /**
     * GL_RGBA4.
     */
    RGBA4(GLESFactory.getInstance().GL_RGBA4()),


    /**
     * GL_RGB5_A1.
     */
    RGB5_A1(GLESFactory.getInstance().GL_RGB5_A1()),


    /**
     * GL_DEPTH_COMPONENT16.
     */
    DEPTH_COMPONENT16(GLESFactory.getInstance().GL_DEPTH_COMPONENT16()),


    /**
     * GL_STENCIL_INDEX8.
     */
    STENCIL_INDEX8(GLESFactory.getInstance().GL_STENCIL_INDEX8())
    ;


    /**
     * The integer representing this format.
     */
    private final int format;


    /**
     * A constructor with a format.
     *
     * @param format
     *         An integer representing a format.
     */
    private RenderBufferFormat(int format)
    {
        this.format = format;
    }


    /**
     * Get the integer representing this format.
     *
     * @return
     *         The integer representing this format.
     */
    public int getFormat()
    {
        return format;
    }
}
