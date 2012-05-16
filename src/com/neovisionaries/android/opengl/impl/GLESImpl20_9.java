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
package com.neovisionaries.android.opengl.impl;


import com.neovisionaries.android.opengl.GLES;
import android.opengl.GLES20;


/**
 * An implementation of {@link GLES} interface for OpenGL ES 2.0
 * (for Android 2.3 and newer).
 *
 * <p>
 * <a href="http://developer.android.com/reference/android/opengl/GLES20.html"
 * >android.opengl.GLES20</a> class in Android 2.2 (API Level 8)
 * has some problems. It does not have the methods below although
 * it should have.
 * </p>
 *
 * <ul>
 * <li>glDrawElements(int mode, int count, int type, int offset)
 * <li>glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, int offset)
 * </ul>
 *
 * <p>
 * The methods above were added in Android 2.3 (API Level 9) and
 * have been available since then.
 * </p>
 *
 * <p>
 * This class ({@link GLESImpl20_9}) extends {@link GLESImpl20} to
 * implement the methods that lack in Anroid 2.2. Note that the
 * methods below throw UnsupportedOperationException.
 * </p>
 *
 * <ul>
 * <li>{@link GLESImpl20}.glDrawElements(int mode, int count, int type, int offset)
 * <li>{@link GLESImpl20}.glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, int offset)
 * </ul>
 *
 * @author Takahiko Kawasaki
 *
 * @see <a href="http://developer.android.com/reference/android/opengl/GLES20.html">android.opengl.GLES20</a>
 */
public class GLESImpl20_9 extends GLESImpl20
{
    @Override
    public void glDrawElements(int mode, int count, int type, int offset)
    {
        GLES20.glDrawElements(mode, count, type, offset);
    }


    @Override
    public void glVertexAttribPointer(int vertexAttributeIndex, int size, int type, boolean normalized, int stride, int offset)
    {
        GLES20.glVertexAttribPointer(vertexAttributeIndex, size, type, normalized, stride, offset);
    }
}
