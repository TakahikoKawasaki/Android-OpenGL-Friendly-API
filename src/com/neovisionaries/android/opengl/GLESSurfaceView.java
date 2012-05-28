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


import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;


/**
 * SurfaceView for OpenGL.
 *
 * <p>
 * Constructors of this class call setEGLContextClientVersion(int version).
 * The number given to setEGLContextClientVersion() is the return value
 * from {@link GLESFactory}.{@link GLESFactory#getInstance()
 * getInstance()}.{@link GLES#getMajorVersion() getMajorVersion()}.
 * </p>
 *
 * <p>
 * A renderer instance passed to {@link #setRenderer(GLSurfaceView.Renderer)
 * setRenderer()} method should be an instance of {@link GLESRenderer}
 * in order to make this view delegate some events to the renderer.
 * </p>
 *
 * @author Takahiko Kawasaki
 */
public class GLESSurfaceView extends GLSurfaceView
{
    private Context context;
    private Renderer renderer;


    public GLESSurfaceView(Context context)
    {
        super(context);

        init(context);
    }


    public GLESSurfaceView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        init(context);
    }


    private void init(Context context)
    {
        int major = GLESFactory.getInstance().getMajorVersion();

        setEGLContextClientVersion(major);

        this.context = context;
    }


    /**
     * Get the renderer that is currently set to this view.
     *
     * @return
     *         The renderer set to this view.
     */
    public Renderer getRenderer()
    {
        return renderer;
    }


    /**
     * Set a renderer to this view.
     *
     * <p>
     * If the renderer is an instance of {@link GLESRenderer}, some of
     * events this view receives are passed to the renderer. See the
     * description of {@link #onKeyDown(int, KeyEvent)} for example.
     * </p>
     *
     * @see GLESRenderer
     */
    @Override
    public void setRenderer(Renderer renderer)
    {
        if (this.renderer == renderer)
        {
            return;
        }

        super.setRenderer(renderer);

        if (this.renderer instanceof GLESRenderer)
        {
            // Detach the current renderer from this view.
            ((GLESRenderer)this.renderer).setContext(null);
        }

        // Replace with the new renderer.
        this.renderer = renderer;

        if (renderer instanceof GLESRenderer)
        {
            // Attach the new renderer to this view.
            ((GLESRenderer)renderer).setContext(context);
        }
    }


    /**
     * Inform this view that the Actvity hosting this view got paused.
     *
     * <p>
     * The implementation of this method does the following.
     * </p>
     *
     * <ol>
     * <li>If the renderer is an instance of {@link GLESRenderer},
     *     call {@link GLESRenderer#onPause(GLESSurfaceView)
     *     onPause}(this) method of the renderer.
     * <li>Call super.onPause().
     * </ol>
     */
    @Override
    public void onPause()
    {
        if (renderer instanceof GLESRenderer)
        {
            ((GLESRenderer)renderer).onPause(this);
        }

        super.onPause();
    }


    /**
     * Inform this view that the Actvity hosting this view got resumed.
     *
     * <p>
     * The implementation of this method does the following.
     * </p>
     *
     * <ol>
     * <li>Call super.onResume().
     * <li>If the renderer is an instance of {@link GLESRenderer},
     *     call {@link GLESRenderer#onResume(GLESSurfaceView)
     *     onResume}(this) method of the renderer.
     * </ol>
     */
    @Override
    public void onResume()
    {
        super.onResume();

        if (renderer instanceof GLESRenderer)
        {
            ((GLESRenderer)renderer).onResume(this);
        }
    }


    /**
     * Callback method for KeyDown event.
     *
     * <p>
     * This implementation calls {@link GLESRenderer#onKeyDown(GLESSurfaceView,
     * int, KeyEvent)} if the renderer set to this view is an instance of {@link
     * GLESRenderer}.
     * </p>
     *
     * <p>
     * If the renderer is not an instance of {@link GLESRenderer} or if the
     * renderer's {@link GLESRenderer#onKeyDown(GLESSurfaceView, int, KeyEvent)
     * onKeyDown()} method returns false, this method calls
     * super.onKeyDown(keyCode, event).
     * </p>
     *
     * @return
     *         True if the event has been consumed by this method.
     *
     * @see GLESRenderer#onKeyDown(GLESSurfaceView, int, KeyEvent)
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        boolean consumed = false;

        if (renderer instanceof GLESRenderer)
        {
            consumed = ((GLESRenderer)renderer).onKeyDown(this, keyCode, event);
        }

        if (consumed == false)
        {
            consumed = super.onKeyDown(keyCode, event);
        }

        return consumed;
    }


    /**
     * Callback method for KeyLongPress event.
     *
     * <p>
     * This implementation calls {@link GLESRenderer#onKeyLongPress(GLESSurfaceView,
     * int, KeyEvent)} if the renderer set to this view is an instance of {@link
     * GLESRenderer}.
     * </p>
     *
     * <p>
     * If the renderer is not an instance of {@link GLESRenderer} or if the
     * renderer's {@link GLESRenderer#onKeyLongPress(GLESSurfaceView, int, KeyEvent)
     * onKeyLongPress()} method returns false, this method calls
     * super.onKeyLongPress(keyCode, event).
     * </p>
     *
     * @return
     *         True if the event has been consumed by this method.
     *
     * @see GLESRenderer#onKeyLongPress(GLESSurfaceView, int, KeyEvent)
     */
    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event)
    {
        boolean consumed = false;

        if (renderer instanceof GLESRenderer)
        {
            consumed = ((GLESRenderer)renderer).onKeyLongPress(this, keyCode, event);
        }

        if (consumed == false)
        {
            consumed = super.onKeyLongPress(keyCode, event);
        }

        return consumed;
    }


    /**
     * Callback method for KeyUp event.
     *
     * <p>
     * This implementation calls {@link GLESRenderer#onKeyUp(GLESSurfaceView,
     * int, KeyEvent)} if the renderer set to this view is an instance of
     * {@link GLESRenderer}.
     * </p>
     *
     * <p>
     * If the renderer is not an instance of {@link GLESRenderer} or if the
     * renderer's {@link GLESRenderer#onKeyUp(GLESSurfaceView, int, KeyEvent)
     * onKeyUp()} method returns false, this method calls
     * super.onKeyUp(keyCode, event).
     * </p>
     *
     * @return
     *         True if the event has been consumed by this method.
     *
     * @see GLESRenderer#onKeyUp(GLESSurfaceView, int, KeyEvent)
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        boolean consumed = false;

        if (renderer instanceof GLESRenderer)
        {
            consumed = ((GLESRenderer)renderer).onKeyUp(this, keyCode, event);
        }

        if (consumed == false)
        {
            consumed = super.onKeyUp(keyCode, event);
        }

        return consumed;
    }


    /**
     * Callback method for Touch event.
     *
     * <p>
     * This implementation calls {@link GLESRenderer#onTouchEvent(GLESSurfaceView,
     * MotionEvent)} if the renderer set to this view is an instance of {@link
     * GLESRenderer}.
     * </p>
     *
     * <p>
     * If the renderer is not an instance of {@link GLESRenderer} or if the
     * renderer's {@link GLESRenderer#onTouchEvent(GLESSurfaceView, MotionEvent)
     * onTouchEvent()} method returns false, this method calls
     * super.onTouchEvent(event).
     * </p>
     *
     * @return
     *         True if the event has been consumed by this method.
     *
     * @see GLESRenderer#onTouchEvent(GLESSurfaceView, MotionEvent)
     */
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        boolean consumed = false;

        if (renderer instanceof GLESRenderer)
        {
            consumed = ((GLESRenderer)renderer).onTouchEvent(this, event);
        }

        if (consumed == false)
        {
            consumed = super.onTouchEvent(event);
        }

        return consumed;
    }
}
