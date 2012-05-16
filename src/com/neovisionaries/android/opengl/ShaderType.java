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
 * OpenGL ES shader type.
 *
 * @author Takahiko Kawasaki
 */
public enum ShaderType
{
    /**
     * Vertex shader (GL_VERTEX_SHADER).
     */
    VERTEX(GLESFactory.getInstance().GL_VERTEX_SHADER()),


    /**
     * Fragment shader (GL_FRAGMENT_SHADER).
     */
    FRAGMENT(GLESFactory.getInstance().GL_FRAGMENT_SHADER())
    ;


    /**
     * An integer representing a shader type.
     */
    private final int type;


    /**
     * A constructor with a shader type.
     *
     * @param type
     *         An integer representing a shader type.
     */
    private ShaderType(int type)
    {
        this.type = type;
    }


    /**
     * Get the integer representing the type of this shader.
     *
     * @return
     *         The integer representing the type of this shader.
     */
    public int getType()
    {
        return type;
    }
}
