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


import android.opengl.Matrix;


/**
 * Transform.
 *
 * @author Takahiko Kawasaki
 */
public class Transform
{
    private float[] matrix = new float[16];


    public Transform()
    {
        Matrix.setIdentityM(matrix, 0);
    }


    public Transform setIdentity()
    {
        Matrix.setIdentityM(matrix, 0);

        return this;
    }


    public Transform rotate(float angle, float x, float y, float z)
    {
        Matrix.rotateM(matrix, 0, angle, x, y, z);

        return this;
    }


    public Transform scale(float x, float y, float z)
    {
        Matrix.scaleM(matrix, 0, x, y, z);

        return this;
    }


    public Transform translate(float x, float y, float z)
    {
        Matrix.translateM(matrix, 0, x, y, z);

        return this;
    }


    public Transform transpose()
    {
        float[] temp = new float[16];

        Matrix.transposeM(temp, 0, matrix, 0);

        return copy(temp, matrix);
    }


    public Transform multiply(Transform rhs)
    {
        if (rhs == null)
        {
            throw new IllegalArgumentException();
        }

        float[] temp = new float[16];

        Matrix.multiplyMM(temp, 0, matrix, 0, rhs.matrix, 0);

        return copy(temp, matrix);
    }


    public Transform frustum(float left, float right, float bottom, float top, float near, float far)
    {
        float[] projection = new float[16];
        float[] temp = new float[16];

        Matrix.frustumM(projection, 0, left, right, bottom, top, near, far);
        Matrix.multiplyMM(temp, 0, matrix, 0, projection, 0);

        return copy(temp, matrix);
    }


    public Transform setFrustum(float left, float right, float bottom, float top, float near, float far)
    {
        Matrix.frustumM(matrix, 0, left, right, bottom, top, near, far);

        return this;
    }


    public Transform perspective(float fovy, float aspect, float near, float far)
    {
        float[] projection = new float[16];
        float[] temp = new float[16];

        perspectiveM(projection, 0, fovy, aspect, near, far);
        Matrix.multiplyMM(temp, 0, matrix, 0, projection, 0);

        return copy(temp, matrix);
    }


    public Transform setPerspective(float fovy, float aspect, float near, float far)
    {
        perspectiveM(matrix, 0, fovy, aspect, near, far);

        return this;
    }


    public Transform lookAt(
            float eyeX, float eyeY, float eyeZ,
            float centerX, float centerY, float centerZ,
            float upX, float upY, float upZ)
    {
        float[] camera = new float[16];
        float[] temp = new float[16];

        setLookAtM(camera, 0,
                eyeX, eyeY, eyeZ,
                centerX, centerY, centerZ,
                upX, upY, upZ);
        Matrix.multiplyMM(temp, 0, matrix, 0, camera, 0);

        return copy(temp, matrix);
    }


    public Transform setLookAt(
            float eyeX, float eyeY, float eyeZ,
            float centerX, float centerY, float centerZ,
            float upX, float upY, float upZ)
    {
        setLookAtM(matrix, 0,
                eyeX, eyeY, eyeZ,
                centerX, centerY, centerZ,
                upX, upY, upZ);

        return this;
    }


    public Transform setTo(Uniform uniform)
    {
        if (uniform == null)
        {
            throw new IllegalArgumentException();
        }

        uniform.setMatrix4(matrix);

        return this;
    }


    private Transform copy(float[] source, float[] destination)
    {
        System.arraycopy(source, 0, destination, 0, 16);

        return this;
    }


    /*
     * Copyright (C) 2007 The Android Open Source Project
     *
     * Licensed under the Apache License, Version 2.0 (the "License");
     * you may not use this file except in compliance with the License.
     * You may obtain a copy of the License at
     *
     *      http://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */


    // Copied the source code of Matrix.perspectiveMM() from Android
    // because Matrix.perspectiveM() method is not available in
    // API Level 13 (Android 3.2) and older.
    /**
     * Define a projection matrix in terms of a field of view angle, an
     * aspect ratio, and z clip planes
     * @param m the float array that holds the perspective matrix
     * @param offset the offset into float array m where the perspective
     * matrix data is written
     * @param fovy field of view in y direction, in degrees
     * @param aspect width to height aspect ratio of the viewport
     * @param zNear
     * @param zFar
     */
    //public static void perspectiveM(float[] m, int offset,
    private static void perspectiveM(float[] m, int offset,
          float fovy, float aspect, float zNear, float zFar) {
        float f = 1.0f / (float) Math.tan(fovy * (Math.PI / 360.0));
        float rangeReciprocal = 1.0f / (zNear - zFar);

        m[offset + 0] = f / aspect;
        m[offset + 1] = 0.0f;
        m[offset + 2] = 0.0f;
        m[offset + 3] = 0.0f;

        m[offset + 4] = 0.0f;
        m[offset + 5] = f;
        m[offset + 6] = 0.0f;
        m[offset + 7] = 0.0f;

        m[offset + 8] = 0.0f;
        m[offset + 9] = 0.0f;
        m[offset + 10] = (zFar + zNear) * rangeReciprocal;
        m[offset + 11] = -1.0f;

        m[offset + 12] = 0.0f;
        m[offset + 13] = 0.0f;
        m[offset + 14] = 2.0f * zFar * zNear * rangeReciprocal;
        m[offset + 15] = 0.0f;
    }


    // Copied the source code of Matrix.setLookAtM() from Android
    // because Matrix.setLookAtM() method is not available in
    // API Level 7 (Android 2.1) and older.
    /**
     * Define a viewing transformation in terms of an eye point, a center of
     * view, and an up vector.
     *
     * @param rm returns the result
     * @param rmOffset index into rm where the result matrix starts
     * @param eyeX eye point X
     * @param eyeY eye point Y
     * @param eyeZ eye point Z
     * @param centerX center of view X
     * @param centerY center of view Y
     * @param centerZ center of view Z
     * @param upX up vector X
     * @param upY up vector Y
     * @param upZ up vector Z
     */
    //public static void setLookAtM(float[] rm, int rmOffset,
    private static void setLookAtM(float[] rm, int rmOffset,
            float eyeX, float eyeY, float eyeZ,
            float centerX, float centerY, float centerZ, float upX, float upY,
            float upZ) {

        // See the OpenGL GLUT documentation for gluLookAt for a description
        // of the algorithm. We implement it in a straightforward way:

        float fx = centerX - eyeX;
        float fy = centerY - eyeY;
        float fz = centerZ - eyeZ;

        // Normalize f
        float rlf = 1.0f / Matrix.length(fx, fy, fz);
        fx *= rlf;
        fy *= rlf;
        fz *= rlf;

        // compute s = f x up (x means "cross product")
        float sx = fy * upZ - fz * upY;
        float sy = fz * upX - fx * upZ;
        float sz = fx * upY - fy * upX;

        // and normalize s
        float rls = 1.0f / Matrix.length(sx, sy, sz);
        sx *= rls;
        sy *= rls;
        sz *= rls;

        // compute u = s x f
        float ux = sy * fz - sz * fy;
        float uy = sz * fx - sx * fz;
        float uz = sx * fy - sy * fx;

        rm[rmOffset + 0] = sx;
        rm[rmOffset + 1] = ux;
        rm[rmOffset + 2] = -fx;
        rm[rmOffset + 3] = 0.0f;

        rm[rmOffset + 4] = sy;
        rm[rmOffset + 5] = uy;
        rm[rmOffset + 6] = -fy;
        rm[rmOffset + 7] = 0.0f;

        rm[rmOffset + 8] = sz;
        rm[rmOffset + 9] = uz;
        rm[rmOffset + 10] = -fz;
        rm[rmOffset + 11] = 0.0f;

        rm[rmOffset + 12] = 0.0f;
        rm[rmOffset + 13] = 0.0f;
        rm[rmOffset + 14] = 0.0f;
        rm[rmOffset + 15] = 1.0f;

        // [Modified]
        //   Prepended "Matrix.". Matrix.translateM() method has been
        //   available since API Level 1.
        //translateM(rm, rmOffset, -eyeX, -eyeY, -eyeZ);
        Matrix.translateM(rm, rmOffset, -eyeX, -eyeY, -eyeZ);
    }
}
