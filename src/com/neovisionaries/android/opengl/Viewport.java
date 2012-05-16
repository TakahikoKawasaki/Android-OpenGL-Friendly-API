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
 * OpenGL ES viewport
 *
 * @author Takahiko Kawasaki
 *
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glViewport.xml">glViewport</a>
 */
public final class Viewport
{
    private Viewport()
    {
    }


    /**
     * Call glViewport(x, y, width, height).
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glViewport.xml">glViewport</a>
     */
    public static void set(int x, int y, int width, int height)
    {
        GLESFactory.getInstance().glViewport(x, y, width, height);
    }


    /**
     * This method is an alias of {@link #set(int, int, int, int)
     * set}(0, 0, width, height).
     *
     * @see #set(int x, int y, int width, int height)
     */
    public static void set(int width, int height)
    {
        set(0, 0, width, height);
    }
}
