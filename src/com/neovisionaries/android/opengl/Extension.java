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
 * OpenGL ES extension.
 *
 * @author Takahiko Kawasaki
 */
public enum Extension
{
    /**
     * OES_element_index_uint.
     *
     * <p>
     * This extension is needed for GL_UNSIGNED_INT to be accepted
     * as the third argument of glDrawElements(). If this extension
     * is supported, {@link ElementDrawer#setIndices(java.nio.Buffer)}
     * accepts IntBuffer.
     * </p>
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDrawElements.xml">glDrawElements</a>
     */
    OES_element_index_uint
    ;


    private Boolean supported;


    /**
     * Check if this extension is supported.
     *
     * @return
     *         True if this extension is supported.
     */
    public boolean isSupported()
    {
        if (supported == null)
        {
            boolean found = GLESState.getExtensions().contains(name());

            supported = (found ? Boolean.TRUE : Boolean.FALSE);
        }

        return supported.booleanValue();
    }
}
