/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
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
        super.setRenderer(renderer);

        this.renderer = renderer;

        if (renderer instanceof GLESRenderer)
        {
            ((GLESRenderer)renderer).setContext(context);
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
