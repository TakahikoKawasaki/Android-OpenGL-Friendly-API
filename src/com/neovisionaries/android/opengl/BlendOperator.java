/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Blend operator.
 *
 * @author Takahiko Kawasaki
 *
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendEquation.xml">glBlendEquation</a>
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendEquationSeparate.xml">glBlendEquationSeparate</a>
 */
public enum BlendOperator
{
    /**
     * GL_FUNC_ADD.
     */
    ADD(GLESFactory.getInstance().GL_FUNC_ADD()),


    /**
     * GL_FUNC_SUBTRACT.
     */
    SUBTRACT(GLESFactory.getInstance().GL_FUNC_SUBTRACT()),


    /**
     * GL_FUNC_REVERSE_SUBTRACT.
     */
    REVERSE_SUBTRACT(GLESFactory.getInstance().GL_FUNC_REVERSE_SUBTRACT())
    ;


    /**
     * The integer representing this blend operator.
     */
    private final int operator;


    /**
     * A constructor with a blend operator.
     *
     * @param operator
     *         A blend operator.
     */
    private BlendOperator(int operator)
    {
        this.operator = operator;
    }


    /**
     * Get the integer representing this blend operator.
     *
     * @return
     *         The integer representing this blend operator.
     */
    public int getOperator()
    {
        return operator;
    }
}
