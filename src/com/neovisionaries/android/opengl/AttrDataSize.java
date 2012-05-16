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
 * Data size for {@link Attribute}.
 *
 * @author Takahiko Kawasaki
 */
public enum AttrDataSize
{
    /**
     * 1.
     */
    ONE(1),


    /**
     * 2.
     */
    TWO(2),


    /**
     * 3.
     */
    THREE(3),


    /**
     * 4.
     */
    FOUR(4);


    /**
     * Size.
     */
    private final int size;


    /**
     * An constructor with size.
     *
     * @param size
     */
    private AttrDataSize(int size)
    {
        this.size = size;
    }


    /**
     * Get the size.
     *
     * @return
     *         The size.
     */
    public int getSize()
    {
        return size;
    }
}
