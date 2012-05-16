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
