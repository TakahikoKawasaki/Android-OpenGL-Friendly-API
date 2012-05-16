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


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.KeyEvent;
import android.view.MotionEvent;


/**
 * Renderer for OpenGL ES.
 *
 * <p>
 * Instances of this class should be set to {@link GLESSurfaceView}
 * so that their callback methods such as {@link
 * #onKeyDown(GLESSurfaceView, int, KeyEvent) onKeyDown()} can be
 * called.
 * </p>
 *
 * @author Takahiko Kawasaki
 */
public abstract class GLESRenderer implements GLSurfaceView.Renderer
{
    /**
     * Context given from the GLESSurfaceView when this renderer
     * intance was set to it.
     */
    private Context context;


    /**
     * This method calls {@link #onDrawFrame(GLES)}.
     */
    @Override
    public final void onDrawFrame(GL10 gl10)
    {
        try
        {
            onDrawFrame(GLESFactory.getInstance());
        }
        catch (GLESException e)
        {
            e.printStackTrace();
        }
    }


    /**
     * This method calls {@link #onSurfaceChanged(GLES, int, int)}.
     */
    @Override
    public final void onSurfaceChanged(GL10 gl10, int width, int height)
    {
        try
        {
            onSurfaceChanged(GLESFactory.getInstance(), width, height);
        }
        catch (GLESException e)
        {
            e.printStackTrace();
        }
    }


    /**
     * This method calls {@link #onSurfaceCreated(GLES, EGLConfig)}.
     */
    @Override
    public final void onSurfaceCreated(GL10 gl10, EGLConfig config)
    {
        try
        {
            onSurfaceCreated(GLESFactory.getInstance(), config);
        }
        catch (GLESException e)
        {
            e.printStackTrace();
        }
    }


    public abstract void onDrawFrame(GLES gles) throws GLESException;


    public abstract void onSurfaceChanged(GLES gles, int width, int height) throws GLESException;


    public abstract void onSurfaceCreated(GLES gles, EGLConfig config) throws GLESException;


    /**
     * Set the context of the {@link GLESSurfaceView} to which this
     * renderer is set to.
     *
     * <p>
     * This method is called by a {@link GLESSurfaceView} when this
     * renderer is set to it by {@link
     * GLESSurfaceView#setRenderer(android.opengl.GLSurfaceView.Renderer)
     * GLESSurfaceView.setRenderer()}.
     * </p>
     *
     * @param context
     */
    void setContext(Context context)
    {
        this.context = context;
    }


    /**
     * Get the context of the {@link GLESSurfaceView} to which this
     * renderer is set to.
     *
     * @return
     *         The context of the {@link GLESSurfaceView} to which
     *         this renderer is set to.
     */
    public Context getContext()
    {
        return context;
    }


    /**
     * Callback method for KeyDown event.
     *
     * <p>
     * This method is called when the {@link GLESSurfaceView} instance
     * which this renderer is set to receives a KeyDown event.
     * </p>
     *
     * @param view
     *         The GLESSurfaceView instance which this renderer is set to.
     *
     * @param keyCode
     * @param event
     *
     * @return
     *         True if the implementation of this method has consumed the event.
     *
     * @see GLESSurfaceView#onKeyDown(int, KeyEvent)
     */
    public boolean onKeyDown(GLESSurfaceView view, int keyCode, KeyEvent event)
    {
        return false;
    }


    /**
     * Callback method for KeyLongPress event.
     *
     * <p>
     * This method is called when the {@link GLESSurfaceView} instance
     * which this renderer is set to receives a KeyLongPress event.
     * </p>
     *
     * @param view
     *         The GLESSurfaceView instance which this renderer is set to.
     *
     * @param keyCode
     * @param event
     *
     * @return
     *         True if the implementation of this method has consumed the event.
     *
     * @see GLESSurfaceView#onKeyLongPress(int, KeyEvent)
     */
    public boolean onKeyLongPress(GLESSurfaceView view, int keyCode, KeyEvent event)
    {
        return false;
    }


    /**
     * Callback method for KeyUp event.
     *
     * <p>
     * This method is called when the {@link GLESSurfaceView} instance
     * which this renderer is set to receives a KeyUp event.
     * </p>
     *
     * @param view
     *         The GLESSurfaceView instance which this renderer is set to.
     *
     * @param keyCode
     * @param event
     *
     * @return
     *         True if the implementation of this method has consumed the event.
     *
     * @see GLESSurfaceView#onKeyUp(int, KeyEvent)
     */
    public boolean onKeyUp(GLESSurfaceView view, int keyCode, KeyEvent event)
    {
        return false;
    }


    /**
     * Callback method for Touch event.
     *
     * <p>
     * This method is called when the {@link GLESSurfaceView} instance
     * which this renderer is set to receives a Touch event.
     * </p>
     *
     * @param view
     *         The GLESSurfaceView instance which this renderer is set to.
     *
     * @param event
     *
     * @return
     *         True if the implementation of this method has consumed the event.
     *
     * @see GLESSurfaceView#onTouchEvent(MotionEvent)
     */
    public boolean onTouchEvent(GLESSurfaceView view, MotionEvent event)
    {
        return false;
    }
}