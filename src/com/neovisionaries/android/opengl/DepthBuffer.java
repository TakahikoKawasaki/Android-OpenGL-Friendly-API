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
 * Depth buffer.
 *
 * @author Takahiko Kawasaki
 */
public final class DepthBuffer
{
    private DepthBuffer()
    {
    }


    /**
     * Set the depth used to clear the depth buffer
     * (call glClearDepthf(depth)).
     *
     * @param depth
     *         The depth used to clear the depth buffer.
     *         From 0.0f to 1.0f.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClearDepthf.xml">glClearDepthf</a>
     */
    public static void setClearDepth(float depth)
    {
        getGLES().glClearDepthf(depth);
    }


    /**
     * Clear the depth buffer (call glClear(GL_DEPTH_BUFFER_BIT)).
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClear.xml">glClear</a>
     */
    public static void clear()
    {
        GLES gles = getGLES();

        gles.glClear(gles.GL_DEPTH_BUFFER_BIT());
    }


    /**
     * Set the depth buffer writable (call glDepthMask(writable)).
     *
     * @param writable
     *         True to make the depth buffer writable.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDepthMask.xml">glDepthMask</a>
     */
    public static void setWritable(boolean writable)
    {
        getGLES().glDepthMask(writable);
    }


    /**
     * Check if the depth buffer is writable.
     *
     * @return
     *         True if the depth buffer is writable.
     *
     * @see GLESState#getDepthWritemask()
     */
    public static boolean isWritable()
    {
        return GLESState.getDepthWritemask();
    }


    /**
     * Get an implementation of GLES interface.
     *
     * @return
     *         An object implementing GLES interface.
     */
    private static GLES getGLES()
    {
        return GLESFactory.getInstance();
    }
}
