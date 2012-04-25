/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Blend factor.
 *
 * @author Takahiko Kawasaki
 *
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
 */
public enum BlendFactor
{
    /**
     * GL_ZERO.
     */
    ZERO(GLESFactory.getInstance().GL_ZERO()),


    /**
     * GL_ONE.
     */
    ONE(GLESFactory.getInstance().GL_ONE()),


    /**
     * GL_SRC_COLOR.
     */
    SRC_COLOR(GLESFactory.getInstance().GL_SRC_COLOR()),


    /**
     * GL_ONE_MINUS_SRC_COLOR.
     */
    ONE_MINUS_SRC_COLOR(GLESFactory.getInstance().GL_ONE_MINUS_SRC_COLOR()),


    /**
     * GL_SRC_ALPHA.
     */
    SRC_ALPHA(GLESFactory.getInstance().GL_SRC_ALPHA()),


    /**
     * GL_ONE_MINUS_SRC_ALPHA.
     */
    ONE_MINUS_SRC_ALPHA(GLESFactory.getInstance().GL_ONE_MINUS_SRC_ALPHA()),


    /**
     * GL_DST_ALPHA.
     */
    DST_ALPHA(GLESFactory.getInstance().GL_DST_ALPHA()),


    /**
     * GL_ONE_MINUS_DST_ALPHA.
     */
    ONE_MINUS_DST_ALPHA(GLESFactory.getInstance().GL_ONE_MINUS_DST_ALPHA()),


    /**
     * GL_CONSTANT_COLOR.
     */
    CONSTANT_COLOR(GLESFactory.getInstance().GL_CONSTANT_COLOR()),


    /**
     * GL_ONE_MINUS_CONSTANT_COLOR.
     */
    ONE_MINUS_CONSTANT_COLOR(GLESFactory.getInstance().GL_ONE_MINUS_CONSTANT_COLOR()),


    /**
     * GL_CONSTANT_ALPHA.
     */
    CONSTANT_ALPHA(GLESFactory.getInstance().GL_CONSTANT_ALPHA()),


    /**
     * GL_ONE_MINUS_CONSTANT_ALPHA.
     */
    ONE_MINUS_CONSTANT_ALPHA(GLESFactory.getInstance().GL_ONE_MINUS_CONSTANT_ALPHA()),


    /**
     * GL_SRC_ALPHA_SATURATE.
     */
    SRC_ALPHA_SATURATE(GLESFactory.getInstance().GL_SRC_ALPHA_SATURATE());


    /**
     * The integer representing this blend factor.
     */
    private final int factor;


    /**
     * A constructor with a blend factor.
     *
     * @param factor
     *         A blend factor.
     */
    private BlendFactor(int factor)
    {
        this.factor = factor;
    }


    /**
     * Get the integer representing this blend factor.
     *
     * @return
     *         The integer representing this blend factor.
     */
    public int getFactor()
    {
        return factor;
    }
}
