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
 * Face.
 *
 * @author Takahiko Kawasaki
 */
public enum Face
{
    /**
     * GL_FRONT.
     */
    FRONT(GLESFactory.getInstance().GL_FRONT()),


    /**
     * GL_BACK.
     */
    BACK(GLESFactory.getInstance().GL_BACK()),


    /**
     * GL_FRONT_AND_BACK.
     */
    FRONT_AND_BACK(GLESFactory.getInstance().GL_FRONT_AND_BACK());


    /**
     * The integer representing this face.
     */
    private final int face;


    /**
     * A constructor with a face.
     *
     * @param face
     *         A face.
     */
    private Face(int face)
    {
        this.face = face;
    }


    /**
     * Get the integer representing this face.
     *
     * @return
     *         The integer representing this face.
     */
    public int getFace()
    {
        return face;
    }
}
