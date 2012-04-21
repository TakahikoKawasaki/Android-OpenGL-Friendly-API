/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
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
     * Get the state value of GL_ARRAY_BUFFER_BINDING.
     */
    public static int getArrayBufferBinding()
    {
        return getInteger(getGLES().GL_ARRAY_BUFFER_BINDING());
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
     * Get the state value of GL_VERSION.
     */
    public static String getVersion()
    {
        return getGLES().glGetString(getGLES().GL_VERSION());
    }
}
