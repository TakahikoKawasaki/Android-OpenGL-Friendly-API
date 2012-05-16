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
