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
 * OpenGL ES vertex buffer usage.
 * 
 * @author Takahiko Kawasaki
 */
public enum VertexBufferUsage
{
    /**
     * GL_STATIC_DRAW.
     */
    STATIC(GLESFactory.getInstance().GL_STATIC_DRAW()),


    /**
     * GL_DYNAMIC_DRAW.
     */
    DYNAMIC(GLESFactory.getInstance().GL_DYNAMIC_DRAW()),


    /**
     * GL_STREAM_DRAW.
     *
     * <p>
     * Note that GL_STREAM_DRAW is not available in OpenGL ES 1.x.
     * </p>
     */
    STREAM(GLESFactory.getInstance().GL_STREAM_DRAW())
    ;


    /**
     * An integer representing vertex buffer usage.
     */
    private final int usage;


    /**
     * A constructor with usage.
     *
     * @param usage
     *         An integer representing usage.
     */
    private VertexBufferUsage(int usage)
    {
        this.usage = usage;
    }


    /**
     * Get the integer representing this usage.
     *
     * @return
     *         The integer representing this usage.
     */
    public int getUsage()
    {
        return usage;
    }
}
