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
 * State of {@link Shader}.
 * 
 * @author Takahiko Kawasaki
 */
public enum ShaderState
{
    /**
     * The shader has been created.
     *
     * @see Shader#Shader(ShaderType)
     */
    CREATED,


    /**
     * A shader source has been set.
     *
     * @see Shader#Shader(ShaderType, String)
     * @see Shader#setSource(String)
     */
    SOURCE_SET,


    /**
     * The shader source has been compiled successfully.
     * 
     * @see Shader#compile()
     */
    COMPILED,


    /**
     * The shader has been deleted.
     * 
     * @see Shader#delete()
     */
    DELETED
    ;
}
