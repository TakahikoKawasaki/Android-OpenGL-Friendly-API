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
