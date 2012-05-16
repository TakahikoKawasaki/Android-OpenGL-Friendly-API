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
 * If you want to make {@link #getInstance()} return another
 * different {@link GLES} implementation, call {@link
 * #initializeInstance(String)} or set a class name to the
 * system property {@link #GLES_IMPL_CLASS_PROPERTY}. See
 * the description of {@link #getInstance()} for details.
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
     * The class name of the default implementation of
     * {@link GLES} interface for OpenGL ES 2.0 in
     * Android 2.2 (API Level 8).
     */
    public static final String GLES_IMPL_GLES20
        = "com.neovisionaries.android.opengl.impl.GLESImpl20";


    /**
     * The class name of the default implementation of
     * {@link GLES} interface for OpenGL ES 2.0 in
     * Android 2.3 (API Level 9) and newer.
     */
    public static final String GLES_IMPL_GLES20_9
        = "com.neovisionaries.android.opengl.impl.GLESImpl20_9";


    /**
     * The class name of the default implementation of
     * {@link GLES} interface for OpenGL ES 1.1.
     */
    public static final String GLES_IMPL_GLES11
        = "com.neovisionaries.android.opengl.impl.GLESImpl11";


    /**
     * An instance of an implementation of {@link GLES} interface.
     */
    private static GLES instance;


    private GLESFactory()
    {
    }


    /**
     * Initialize the singleton instance of {@link GLES} implemetation.
     *
     * <p>
     * You do not have to call this method if the default implementation
     * suits your needs. See the description of {@link #getInstance()}
     * for the case you need to call this method.
     * </p>
     *
     * @param className
     *         The name of a class that implements {@link GLES} interface.
     *
     * @throws IllegalArgumentException
     *         The given argument is null.
     *
     * @throws IllegalStateException
     *         The singleton instance has aleady been created.
     *
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     *
     * @see #getInstance()
     */
    public static void initializeInstance(String className)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        if (className == null)
        {
            throw new IllegalArgumentException("className is null.");
        }

        synchronized (GLESFactory.class)
        {
            if (instance != null)
            {
                throw new IllegalStateException("Already initialized.");
            }

            instance = createInstance(className);
        }
    }


    /**
     * Get an implementation of {@link GLES} interface.
     *
     * <p>
     * If {@link #initializeInstance(String)} has been called before
     * this method is called, the object created in the call of
     * {@link #initializeInstance(String)} is returned. In other words,
     * to use another implementation of {@link GLES} that is different
     * from the one selected by the steps described below, call {@link
     * #initializeInstance(String)} before this method. Note that
     * because getInstance() method is called at various places in the
     * implementation of this Java package, if you want to use {@link
     * #initializeInstance(String)}, you must call it before not only
     * calling getInstance() but also referring to any other class in
     * this Java package.
     * </p>
     *
     * <p>
     * The steps to select an implementation of {@link GLES} instance
     * are as follows.
     * </p>
     *
     * <ol>
     * <li>The system property of {@link #GLES_IMPL_CLASS_PROPERTY}
     *     is checked. If it holds a non-null value, the value is
     *     used as a class name of a {@link GLES} implementation.
     * <li>Otherwise, the API Level of the Android platform is checked.
     *     If the API Level is 9 (Android 2.3) or higher, the value of
     *     {@link #GLES_IMPL_GLES20_9} is used as a class name of a
     *     {@link GLES} implementation.
     * <li>Otherwise, if the API Level is 8 (Android 2.2), the value of
     *     {@link #GLES_IMPL_GLES20} is used as a class name of a
     *     {@link GLES} implementation.
     * <li>Otherwise, the value of {@link #GLES_IMPL_GLES11} is used
     *     as a class name of a {@link GLES} implementation.
     * </ol>
     *
     * <p>
     * If you want to use OpenGL ES 1.1 instead of OpenGL ES 2.0 on
     * Android 2.2 (API Level 8) or newer, you need to call {@link
     * #initializeInstance(String)} or set a class name to the
     * system property {@link #GLES_IMPL_CLASS_PROPERTY}.
     * </p>
     *
     * <p>
     * The default {@link GLES} implementation for OpenGL ES 2.0 is
     * different between Android 2.2 and Android 2.3 (and newer).
     * This is because
     * <a href="http://developer.android.com/reference/android/opengl/GLES11.html"
     * >android.opengl.GLES20</a> class in Anroid 2.2 does not have
     * the method listed below although it should have.
     * </p>
     *
     * <ul>
     * <li>glDrawElements(int mode, int count, int type, int offset)
     * <li>glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, int offset)
     * </ul>
     *
     * @return
     *         An implementation of {@link GLES} interface.
     *
     * @throws UnsupportedOperationException
     *         Failed to create an object implementing {@link GLES}
     *         interface.
     *
     * @see <a href="http://developer.android.com/reference/android/opengl/GLES11.html">android.opengl.GLES11</a>
     * @see <a href="http://developer.android.com/reference/android/opengl/GLES20.html">android.opengl.GLES20</a>
     */
    public static GLES getInstance()
    {
        synchronized (GLESFactory.class)
        {
            if (instance == null)
            {
                String className = getImplementationClassName();

                try
                {
                    // Create an object that implements GLES interface.
                    instance = createInstance(className);
                }
                catch (Exception e)
                {
                    // Failed to create an object implementing GLES interface.
                    String message = "Failed to create an object implementing GLES interface.";

                    throw new UnsupportedOperationException(message, e);
                }
            }
        }

        return instance;
    }


    /**
     * Create an object that implements {@link GLES} interface.
     *
     * @param className
     *         The name of a class that implements {@link GLES} interface.
     *
     * @return
     *         An object that implements {@link GLES} interface.
     *
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private static GLES createInstance(String className)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        // Load the class.
        Class<?> clazz = Class.forName(className, true, GLESFactory.class.getClassLoader());

        // Create an instance of the class.
        Object impl = clazz.newInstance();

        // Cast the object to GLES interface.
        // This may throw ClassCastException.
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

        if (9 <= level)
        {
            // GLES implementation for OpenGL ES 2.0 for Android 2.3 and newer.
            return GLES_IMPL_GLES20_9;
        }
        else if (8 == level)
        {
            // GLES implementation for OpenGL ES 2.0 for Android 2.2.
            return GLES_IMPL_GLES20;
        }
        else
        {
            // GLES implementation for OpenGL ES 1.1
            return GLES_IMPL_GLES11;
        }
    }
}
