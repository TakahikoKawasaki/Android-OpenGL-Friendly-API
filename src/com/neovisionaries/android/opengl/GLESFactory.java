/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import android.os.Build;


/**
 * The factory class to get an implementation of {@link GLES}
 * interface.
 *
 * <p>
 * If Android API Level is 8 (Android 2.2) or higher, an
 * implementation for OpenGL ES 2.0 is returned by {@link
 * #getInstance()} method. Otherwise, an implementation for
 * OpenGL ES 1.1 is returned. Note that if Android API Level
 * were less than 4 (Android 1.6), this factory class itself
 * would not be able to be loaded. 
 * </p>
 *
 * <p>
 * The system property defined by {@link #GLES_IMPL_CLASS_PROPERTY}
 * can be used to specify a class name of an implementation of
 * {@link GLES} interface.
 * </p>
 *
 * @author Takahiko Kawasaki
 */
public final class GLESFactory
{
    /**
     * The name of the system property to specify a class
     * name of an implementation of {@link GLES} interface.
     */
    public static final String GLES_IMPL_CLASS_PROPERTY
        = "com.neovisionaries.android.opengl.GLES";

    /**
     * The API level since which GLES20 has been supported.
     */
    private static final int API_LEVEL_GLES20 = 8;


    /**
     * The class name of the default implementation of
     * {@link GLES} interface for OpenGL ES 2.0.
     */
    private static final String GLES_IMPL_GLES20
        = "com.neovisionaries.android.opengl.impl.GLESImpl20";


    /**
     * The class name of the default implementation of
     * {@link GLES} interface for OpenGL ES 1.1.
     */
    private static final String GLES_IMPL_GLES11
        = "com.neovisionaries.android.opengl.impl.GLESImpl11";


    /**
     * An instance of an implementation of {@link GLES} interface.
     */
    private static GLES instance;


    /**
     * Get an implementation of {@link GLES} interface.
     *
     * <p>
     * The system property defined by {@link #GLES_IMPL_CLASS_PROPERTY}
     * can be used to specify a class name of an implementation of
     * {@link GLES} interface.
     * </p>
     *
     * @return
     *         An implementation of {@link GLES} interface.
     *
     * @throws RuntimeException
     *         Failed to create an object implementing {@link GLES}
     *         interface.
     */
    public static GLES getInstance()
    {
        if (instance == null)
        {
            try
            {
                // Create an object that implements GLES interface.
                instance = createInstance();
            }
            catch (Exception e)
            {
                // Failed to create an object implementing GLES interface.
                String message = "Failed to create an object implementing GLES interface.";

                throw new RuntimeException(message, e);
            }
        }

        return instance;
    }


    /**
     * Create an object that implements {@link GLES} interface.
     * The class name of the object is determined by {@link
     * #getImplementationClassName()}.
     *
     * @return
     *         An object that implements {@link GLES} interface.
     *
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private static GLES createInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        // Get a class name of an implementation of GLES interface.
        String className = getImplementationClassName();

        // Load the class.
        Class<?> clazz = Class.forName(className, true, GLESFactory.class.getClassLoader());

        // Create an instance of the class.
        Object impl = clazz.newInstance();

        // Cast the object to GLES interface. This may throw
        // a ClassCastException.
        return (GLES)impl;
    }


    /**
     * Get a class name of an implementation of {@link GLES}
     * interface.
     *
     * <p>
     * First, the system property defined by {@link
     * #GLES_IMPL_CLASS_PROPERTY} is checked and if its has a
     * non-null value, the value is used as the class name.
     * Otherwise, the name of the default implementation is
     * used. The default implementation is selected based on
     * the value of android.os.Build.VERSION.SDK_INT.
     * </p>
     *
     * @return
     *         A class name of an implementation of {@link GLES}
     *         interface.
     */
    private static String getImplementationClassName()
    {
        String className = null;

        try
        {
            // Get the class name of an implementation of GLES interface.
            className = System.getProperty(GLES_IMPL_CLASS_PROPERTY);
        }
        catch (Exception e)
        {
            // System.getProperty() threw a SecurityException?
        }

        if (className != null)
        {
            // A class name of an implementation of GLES interface is
            // specified by the system property.
            return className;
        }

        // Get the Android API level. Note that both Build.VERSION.SDK_INT
        // itself and GLES10/GLES11 are available since API level 4.
        int level = Build.VERSION.SDK_INT;

        if (API_LEVEL_GLES20 <= level)
        {
            // GLES implementation for OpenGL ES 2.0
            return GLES_IMPL_GLES20;
        }
        else
        {
            // GLES implementation for OpenGL ES 1.1
            return GLES_IMPL_GLES11;
        }
    }
}
