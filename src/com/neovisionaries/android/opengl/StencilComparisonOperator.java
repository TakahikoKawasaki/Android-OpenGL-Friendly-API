/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Comparison operator used for the stencil test.
 *
 * @author Takahiko Kawasaki
 *
 * @see StencilComparator
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilFunc.xml">glStencilFunc</a>
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilFuncSeparate.xml">glStencilFuncSeparate</a>
 */
public enum StencilComparisonOperator
{
    /**
     * GL_EQUAL.
     */
    EQUAL(GLESFactory.getInstance().GL_EQUAL()),


    /**
     * GL_NOTEQUAL.
     */
    NOTEQUAL(GLESFactory.getInstance().GL_NOTEQUAL()),


    /**
     * GL_LESS.
     */
    LESS(GLESFactory.getInstance().GL_LESS()),


    /**
     * GL_GREATER.
     */
    GREATER(GLESFactory.getInstance().GL_GREATER()),


    /**
     * GL_LEQUAL.
     */
    LEQUAL(GLESFactory.getInstance().GL_LEQUAL()),


    /**
     * GL_GEQUAL.
     */
    GEQUAL(GLESFactory.getInstance().GL_GEQUAL()),


    /**
     * GL_ALWAYS.
     */
    ALWAYS(GLESFactory.getInstance().GL_ALWAYS()),


    /**
     * GL_NEVER.
     */
    NEVER(GLESFactory.getInstance().GL_NEVER());


    /**
     * The integer representing this comparison operator.
     */
    private final int operator;


    /**
     * A constructor with a comparison operator.
     *
     * @param operator
     *         A comparison operator.
     */
    private StencilComparisonOperator(int operator)
    {
        this.operator = operator;
    }


    /**
     * Get the integer representing this comparison operator.
     *
     * @return
     *         The integer representing this comparison operator.
     */
    public int getOperator()
    {
        return operator;
    }
}
