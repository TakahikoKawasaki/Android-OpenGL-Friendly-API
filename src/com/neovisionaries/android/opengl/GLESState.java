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


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * GLES state.
 *
 * @author Takahiko Kawasaki
 *
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGet.xml">glGet</a>
 */
public final class GLESState
{
    private static Set<String> extensions;


    private GLESState()
    {
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


    private static boolean getBoolean(int parameterId)
    {
        boolean[] params = getBooleanArray(parameterId, 1);

        return params[0];
    }


    private static boolean[] getBooleanArray(int parameterId, int size)
    {
        return getBooleanArray(parameterId, new boolean[size]);
    }


    private static boolean[] getBooleanArray(int parameterId, boolean[] params)
    {
        getGLES().glGetBooleanv(parameterId, params, 0);

        return params;
    }


    private static int getInteger(int parameterId)
    {
        int[] params = getIntArray(parameterId, 1);

        return params[0];
    }


    private static int[] getIntArray(int parameterId, int size)
    {
        return getIntArray(parameterId, new int[size]);
    }


    private static int[] getIntArray(int parameterId, int[] params)
    {
        getGLES().glGetIntegerv(parameterId, params, 0);

        return params;
    }


    /**
     * Get the state value of GL_ACTIVE_TEXTURE.
     */
    public static int getActiveTexture()
    {
        return getInteger(getGLES().GL_ACTIVE_TEXTURE());
    }


    /**
     * Get the state value of GL_ARRAY_BUFFER_BINDING.
     */
    public static int getArrayBufferBinding()
    {
        return getInteger(getGLES().GL_ARRAY_BUFFER_BINDING());
    }


    /**
     * Get the state value of GL_COLOR_WRITEMASK.
     *
     * @return
     *         A boolean array of size 4. The values indicate whether
     *         the red, green, blue and alpha components are writable
     *         or not.
     */
    public static boolean[] getColorWritemask()
    {
        return getBooleanArray(getGLES().GL_COLOR_WRITEMASK(), 4);
    }


    /**
     * Get the state value of GL_DEPTH_WRITEMASK.
     */
    public static boolean getDepthWritemask()
    {
        return getBoolean(getGLES().GL_DEPTH_WRITEMASK());
    }


    /**
     * Get the state value of GL_ELEMENT_ARRAY_BUFFER_BINDING.
     */
    public static int getElementArrayBufferBinding()
    {
        return getInteger(getGLES().GL_ELEMENT_ARRAY_BUFFER_BINDING());
    }


    /**
     * Get the state value of GL_EXTENSIONS.
     *
     * @see Extension
     */
    public static Set<String> getExtensions()
    {
        if (extensions == null)
        {
            Set<String> set = getExtensionsSet();

            if (set == null)
            {
                set = new HashSet<String>();
            }

            extensions = Collections.unmodifiableSet(set);
        }

        return extensions;
    }


    private static Set<String> getExtensionsSet()
    {
        // Get the value of the state 'GL_EXTENSIONS'.
        String value = getGLES().glGetString(getGLES().GL_EXTENSIONS());

        if (value == null)
        {
            return null;
        }

        String[] extensions = value.split("\\s+");

        if (extensions == null)
        {
            return null;
        }

        Set<String> set = new HashSet<String>();

        for (String extension : extensions)
        {
            set.add(extension);
        }

        return set;
    }


    /**
     * Get the state value of GL_MAX_RENDERBUFFER_SIZE.
     */
    public static int getMaxRenderbufferSize()
    {
        return getInteger(getGLES().GL_MAX_RENDERBUFFER_SIZE());
    }


    /**
     * Get the state value of GL_MAX_TEXTURE_IMAGE_UNITS.
     */
    public static int getMaxTextureImageUnits()
    {
        return getInteger(getGLES().GL_MAX_TEXTURE_IMAGE_UNITS());
    }


    /**
     * Get the state value of GL_RENDERBUFFER_BINDING.
     */
    public static int getRenderbufferBinding()
    {
        return getInteger(getGLES().GL_RENDERBUFFER_BINDING());
    }


    /**
     * Get the state value of GL_TEXTURE_BINDING_2D.
     */
    public static int getTextureBinding2D()
    {
        return getInteger(getGLES().GL_TEXTURE_BINDING_2D());
    }


    /**
     * Get the state value of GL_TEXTURE_BINDING_CUBE_MAP.
     */
    public static int getTextureBindingCubeMap()
    {
        return getInteger(getGLES().GL_TEXTURE_BINDING_CUBE_MAP());
    }


    /**
     * Get the state value of GL_VERSION.
     */
    public static String getVersion()
    {
        return getGLES().glGetString(getGLES().GL_VERSION());
    }
}
