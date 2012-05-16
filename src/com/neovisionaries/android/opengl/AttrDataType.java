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
 * Data type for {@link Attribute}.
 *
 * @author Takahiko Kawasaki
 */
public enum AttrDataType
{
    /**
     * GL_BYTE.
     */
    BYTE(GLESFactory.getInstance().GL_BYTE()),


    /**
     * GL_UNSIGNED_BYTE.
     */
    UNSIGNED_BYTE(GLESFactory.getInstance().GL_UNSIGNED_BYTE()),


    /**
     * GL_SHORT.
     */
    SHORT(GLESFactory.getInstance().GL_SHORT()),


    /**
     * GL_UNSIGNED_SHORT.
     */
    UNSIGNED_SHORT(GLESFactory.getInstance().GL_UNSIGNED_SHORT()),


    /**
     * GL_FLOAT.
     */
    FLOAT(GLESFactory.getInstance().GL_FLOAT()),


    /**
     * GL_FIXED.
     */
    FIXED(GLESFactory.getInstance().GL_FIXED())
    ;


    /**
     * The integer representing the data type.
     */
    private final int type;


    /**
     * A constructor with a data type.
     *
     * @param type
     *         An integer representing a data type.
     */
    private AttrDataType(int type)
    {
        this.type = type;
    }


    /**
     * Get the integer representing the data type.
     *
     * @return
     *         The integer representing the data type.
     */
    public int getType()
    {
        return type;
    }
}
