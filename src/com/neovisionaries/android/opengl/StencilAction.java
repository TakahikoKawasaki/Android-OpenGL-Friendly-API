/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Stencil action taken according to the result of
 * the stencil test and the depth test.
 *
 * @author Takahiko Kawasaki
 *
 * @see StencilActionSet
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilOp.xml">glStencilOp</a>
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilOpSeparate.xml">glStencilOpSeparate</a>
 */
public enum StencilAction
{
    /**
     * GL_ZERO.
     */
    ZERO(GLESFactory.getInstance().GL_ZERO()),


    /**
     * GL_REPLACE.
     */
    REPLACE(GLESFactory.getInstance().GL_REPLACE()),


    /**
     * GL_INCR.
     */
    INCR(GLESFactory.getInstance().GL_INCR()),


    /**
     * GL_DECR.
     */
    DECR(GLESFactory.getInstance().GL_DECR()),


    /**
     * GL_INCR_WRAP.
     */
    INCR_WRAP(GLESFactory.getInstance().GL_INCR_WRAP()),


    /**
     * GL_DECR_WRAP.
     */
    DECR_WRAP(GLESFactory.getInstance().GL_DECR_WRAP()),


    /**
     * GL_KEEP.
     */
    KEEP(GLESFactory.getInstance().GL_KEEP()),


    /**
     * GL_INVERT.
     */
    INVERT(GLESFactory.getInstance().GL_INVERT())
    ;


    /**
     * The integer representing this action.
     */
    private final int action;


    /**
     * A constructor with an action.
     *
     * @param action
     *         An action.
     */
    private StencilAction(int action)
    {
        this.action = action;
    }


    /**
     * Get the integer representing this action.
     */
    public int getAction()
    {
        return action;
    }
}
