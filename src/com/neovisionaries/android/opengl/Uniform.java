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


import java.nio.FloatBuffer;
import java.nio.IntBuffer;


/**
 * A class to manipulate a uniform variable in OpenGL Shader Language.
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E</b></span>
 *
 * <span style="color: darkgreen;">// Get a program from somewhere.</span>
 * {@link Program} program = ...;
 *
 * <span style="color: darkgreen;">// Get an accessor to a uniform variable.</span>
 * {@link Uniform} pos = program.{@link Program#getUniform(String) getUniform}("pos");
 *
 * <span style="color: darkgreen;">// Set a value to the uniform variable.</span>
 * <span style="color: darkgreen;">// It is assumed here that pos is a vec2 variable.</span>
 * pos.{@link #set(float, float) set}(1.0f, 1.0f);
 * </pre>
 *
 * @author Takahiko Kawasaki
 */
public class Uniform
{
    /**
     * Location of this uniform.
     */
    private final int location;


    /**
     * A constructor.
     *
     * @param program
     * @param name
     *
     * @throws IllegalArgumentException
     *         Either or both of the arguments are null.
     *
     * @throws GLESException
     *         There is no such a uniform variable having the specified name.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniformLocation.xml">glGetUniformLocation</a>
     * @see Program#getUniform(String)
     */
    public Uniform(Program program, String name) throws GLESException
    {
        // Check the arguments.
        if (program == null || name == null)
        {
            throw new IllegalArgumentException();
        }

        // Get the location of the uniform having the specified name.
        location = getGLES().glGetUniformLocation(program.getId(), name);

        if (location == -1)
        {
            // No uniform having the name.
            throw new GLESException("No such a uniform variable having the name: " + name);
        }
    }


    /**
     * Get the location of this uniform.
     *
     * @return The location of this uniform.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniformLocation.xml">glGetUniformLocation</a>
     */
    public int getLocation()
    {
        return location;
    }


    /**
     * Get the value of a uniform variable.
     *
     * @param program
     * @param params
     *
     * @return
     *         The given 'params' object.
     *
     * @throws IllegalArgumentException
     *         Either or both of the arguments are null.
     *
     * @throws IllegalStateException
     *         The state of the program is not {@link ProgramState#LINKED LINKED}.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniform.xml">glGetUniformfv</a>
     */
    public FloatBuffer get(Program program, FloatBuffer params)
    {
        // Check the arguments.
        if (program == null || params == null)
        {
            throw new IllegalArgumentException();
        }

        // Check the state of the program.
        if (program.getState() != ProgramState.LINKED)
        {
            throw new IllegalStateException("Program is not linked.");
        }

        getGLES().glGetUniformfv(program.getId(), location, params);

        return params;
    }


    /**
     * Get the value of a uniform variable.
     *
     * @param program
     * @param params
     * @param offset
     *
     * @return
     *         The given 'params' object.
     *
     * @throws IllegalArgumentException
     *         Either or both of the arguments are null, or 'offset'
     *         is equal to or greater than the length of 'params'.
     *
     * @throws IllegalStateException
     *         The state of the program is not {@link ProgramState#LINKED LINKED}.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniform.xml">glGetUniformfv</a>
     */
    public float[] get(Program program, float[] params, int offset)
    {
        // Check the arguments.
        if (program == null || params == null || params.length <= offset)
        {
            throw new IllegalArgumentException();
        }

        // Check the state of the program.
        if (program.getState() != ProgramState.LINKED)
        {
            throw new IllegalStateException("Program is not linked.");
        }

        getGLES().glGetUniformfv(program.getId(), location, params, offset);

        return params;
    }


    /**
     * Get the value of a uniform variable.
     * This method calls {@link #get(Program, float[], int)
     * get}(program, params, 0).
     *
     * @param program
     * @param params
     *
     * @return
     *         The given 'params' object.
     *
     * @throws IllegalArgumentException
     *         Either or both of the arguments are null, or the
     *         length of 'params' is 0.
     *
     * @see #get(Program, float[], int)
     */
    public float[] get(Program program, float[] params)
    {
        return get(program, params, 0);
    }


    /**
     * Get the value of a uniform variable.
     *
     * @param program
     * @param params
     *
     * @return
     *         The given 'params' object.
     *
     * @throws IllegalArgumentException
     *         Either or both of the arguments are null.
     *
     * @throws IllegalStateException
     *         The state of the program is not {@link ProgramState#LINKED LINKED}.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniform.xml">glGetUniformiv</a>
     */
    public IntBuffer get(Program program, IntBuffer params)
    {
        // Check the arguments.
        if (program == null || params == null)
        {
            throw new IllegalArgumentException();
        }

        // Check the state of the program.
        if (program.getState() != ProgramState.LINKED)
        {
            throw new IllegalStateException("Program is not linked.");
        }

        getGLES().glGetUniformiv(program.getId(), location, params);

        return params;
    }


    /**
     * Get the value of a uniform variable.
     *
     * @param program
     * @param params
     * @param offset
     *
     * @return
     *         The given 'params' object.
     *
     * @throws IllegalArgumentException
     *         Either or both of the arguments are null, or 'offset'
     *         is equal to or greater than the length of 'params'.
     *
     * @throws IllegalStateException
     *         The state of the program is not {@link ProgramState#LINKED LINKED}.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniform.xml">glGetUniformiv</a>
     */
    public int[] get(Program program, int[] params, int offset)
    {
        // Check the arguments.
        if (program == null || params == null || params.length <= offset)
        {
            throw new IllegalArgumentException();
        }

        // Check the state of the program.
        if (program.getState() != ProgramState.LINKED)
        {
            throw new IllegalStateException("Program is not linked.");
        }

        getGLES().glGetUniformiv(program.getId(), location, params, offset);

        return params;
    }


    /**
     * Get the value of a uniform variable.
     * This method calls {@link #get(Program, int[], int)
     * get}(program, params, 0).
     *
     * @param program
     * @param params
     *
     * @return
     *         The given 'params' object.
     *
     * @throws IllegalArgumentException
     *         Either or both of the arguments are null, or the
     *         length of 'params' is 0.
     *
     * @see #get(Program, int[], int)
     */
    public int[] get(Program program, int[] params)
    {
        return get(program, params, 0);
    }


    /**
     * Set a value to a uniform variable (float).
     *
     * @param x
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1f</a>
     */
    public void set1(float x)
    {
        getGLES().glUniform1f(location, x);
    }


    /**
     * Set a value to a uniform variable (float array).
     *
     * @param count
     * @param values
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1fv</a>
     */
    public void set1(int count, FloatBuffer values)
    {
        getGLES().glUniform1fv(location, count, values);
    }


    /**
     * Set a value to a uniform variable (float array).
     *
     * @param count
     * @param values
     * @param offset
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1fv</a>
     */
    public void set1(int count, float[] values, int offset)
    {
        getGLES().glUniform1fv(location, count, values, offset);
    }


    /**
     * Set a value to a uniform variable (float array).
     * This method calls {@link #set1(int, float[], int)
     * set1}(values.length, values, 0).
     *
     * @param values
     *
     * @see #set1(int, float[], int)
     */
    public void set1(float[] values)
    {
        set1(values.length, values, 0);
    }


    /**
     * Set a value to a uniform variable (int).
     *
     * @param x
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1i</a>
     */
    public void set1(int x)
    {
        getGLES().glUniform1i(location, x);
    }


    /**
     * Set a value to a uniform variable (int array).
     *
     * @param count
     * @param values
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1iv</a>
     */
    public void set1(int count, IntBuffer values)
    {
        getGLES().glUniform1iv(location, count, values);
    }


    /**
     * Set a value to a uniform variable (int array).
     *
     * @param count
     * @param values
     * @param offset
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1iv</a>
     */
    public void set1(int count, int[] values, int offset)
    {
        getGLES().glUniform1iv(location, count, values, offset);
    }


    /**
     * Set a value to a uniform variable (int array).
     * This method calls {@link #set1(int, int[], int)
     * set1}(values.length, values, 0).
     *
     * @param values
     *
     * @see #set1(int, int[], int)
     */
    public void set1(int[] values)
    {
        set1(values.length, values, 0);
    }


    /**
     * Set a value to a uniform variable (float vec2).
     *
     * @param x
     * @param y
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2f</a>
     */
    public void set2(float x, float y)
    {
        getGLES().glUniform2f(location, x, y);
    }


    /**
     * Set a value to a uniform variable (float vec2 array).
     *
     * @param count
     * @param values
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2fv</a>
     */
    public void set2(int count, FloatBuffer values)
    {
        getGLES().glUniform2fv(location, count, values);
    }


    /**
     * Set a value to a uniform variable (float vec2 array).
     *
     * @param count
     * @param values
     * @param offset
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2fv</a>
     */
    public void set2(int count, float[] values, int offset)
    {
        getGLES().glUniform2fv(location, count, values, offset);
    }


    /**
     * Set a value to a uniform variable (float vec2 array).
     * This method calls {@link #set2(int, float[], int)
     * set2}(values.length / 2, values, 0).
     *
     * @param values
     *
     * @see #set2(int, float[], int)
     */
    public void set2(float[] values)
    {
        set2(values.length / 2, values, 0);
    }


    /**
     * Set a value to a uniform variable (int vec2).
     *
     * @param x
     * @param y
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2i</a>
     */
    public void set2(int x, int y)
    {
        getGLES().glUniform2i(location, x, y);
    }


    /**
     * Set a value to a uniform variable (int vec2 array).
     *
     * @param count
     * @param values
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2iv</a>
     */
    public void set2(int count, IntBuffer values)
    {
        getGLES().glUniform2iv(location, count, values);
    }


    /**
     * Set a value to a uniform variable (int vec2 array).
     *
     * @param count
     * @param values
     * @param offset
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2iv</a>
     */
    public void set2(int count, int[] values, int offset)
    {
        getGLES().glUniform2iv(location, count, values, offset);
    }


    /**
     * Set a value to a uniform variable (int vec2 array).
     * This method calls {@link #set2(int, int[], int)
     * set2}(values.length / 2, values, 0).
     *
     * @param values
     *
     * @see #set2(int, int[], int)
     */
    public void set2(int[] values)
    {
        set2(values.length / 2, values, 0);
    }


    /**
     * Set a value to a uniform variable (float vec3).
     *
     * @param x
     * @param y
     * @param z
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3f</a>
     */
    public void set3(float x, float y, float z)
    {
        getGLES().glUniform3f(location, x, y, z);
    }


    /**
     * Set a value to a uniform variable (float vec3 array).
     *
     * @param count
     * @param values
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3fv</a>
     */
    public void set3(int count, FloatBuffer values)
    {
        getGLES().glUniform3fv(location, count, values);
    }


    /**
     * Set a value to a uniform variable (float vec3 array).
     *
     * @param count
     * @param values
     * @param offset
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3fv</a>
     */
    public void set3(int count, float[] values, int offset)
    {
        getGLES().glUniform3fv(location, count, values, offset);
    }


    /**
     * Set a value to a uniform variable (float vec3 array).
     * This method calls {@link #set3(int, float[], int)
     * set3}(values.length / 3, values, 0).
     *
     * @param values
     *
     * @see #set3(int, float[], int)
     */
    public void set3(float[] values)
    {
        set3(values.length / 3, values, 0);
    }


    /**
     * Set a value to a uniform variable (int vec3).
     *
     * @param x
     * @param y
     * @param z
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3i</a>
     */
    public void set3(int x, int y, int z)
    {
        getGLES().glUniform3i(location, x, y, z);
    }


    /**
     * Set a value to a uniform variable (int vec3 array).
     *
     * @param count
     * @param values
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3iv</a>
     */
    public void set3(int count, IntBuffer values)
    {
        getGLES().glUniform3iv(location, count, values);
    }


    /**
     * Set a value to a uniform variable (int vec3 array).
     *
     * @param count
     * @param values
     * @param offset
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3iv</a>
     */
    public void set3(int count, int[] values, int offset)
    {
        getGLES().glUniform3iv(location, count, values, offset);
    }


    /**
     * Set a value to a uniform variable (int vec3 array).
     * This method calls {@link #set3(int, int[], int)
     * set3}(values.length / 3, values, 0).
     *
     * @param values
     *
     * @see #set3(int, int[], int)
     */
    public void set3(int[] values)
    {
        set3(values.length / 3, values, 0);
    }


    /**
     * Set a value to a uniform variable (float vec4).
     *
     * @param x
     * @param y
     * @param z
     * @param w
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4f</a>
     */
    public void set4(float x, float y, float z, float w)
    {
        getGLES().glUniform4f(location, x, y, z, w);
    }


    /**
     * Set a value to a uniform variable (float vec4 array).
     *
     * @param count
     * @param values
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4fv</a>
     */
    public void set4(int count, FloatBuffer values)
    {
        getGLES().glUniform4fv(location, count, values);
    }


    /**
     * Set a value to a uniform variable (float vec4 array).
     *
     * @param count
     * @param values
     * @param offset
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4fv</a>
     */
    public void set4(int count, float[] values, int offset)
    {
        getGLES().glUniform4fv(location, count, values, offset);
    }


    /**
     * Set a value to a uniform variable (float vec4 array).
     * This method calls {@link #set4(int, float[], int)
     * set4}(values.lenth / 4, values, 0).
     *
     * @param values
     *
     * @see #set4(int, float[], int)
     */
    public void set4(float[] values)
    {
        set4(values.length / 4, values, 0);
    }


    /**
     * Set a value to a uniform variable (int vec4).
     *
     * @param x
     * @param y
     * @param z
     * @param w
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4i</a>
     */
    public void set4(int x, int y, int z, int w)
    {
        getGLES().glUniform4i(location, x, y, z, w);
    }


    /**
     * Set a value to a uniform variable (int vec4 array).
     *
     * @param count
     * @param values
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4iv</a>
     */
    public void set4(int count, IntBuffer values)
    {
        getGLES().glUniform4iv(location, count, values);
    }


    /**
     * Set a value to a uniform variable (int vec4 array).
     *
     * @param count
     * @param values
     * @param offset
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4iv</a>
     */
    public void set4(int count, int[] values, int offset)
    {
        getGLES().glUniform4iv(location, count, values, offset);
    }


    /**
     * Set a value to a uniform variable (int vec4 array).
     * This method calls {@link #set4(int, int[], int)
     * set4}(values.lenth / 4, values, 0).
     *
     * @param values
     *
     * @see #set4(int, int[], int)
     */
    public void set4(int[] values)
    {
        set4(values.length / 4, values, 0);
    }


    /**
     * Set a value to a uniform variable (mat2 array).
     *
     * @param count
     * @param values
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix2fv</a>
     */
    public void setMatrix2(int count, FloatBuffer values)
    {
        getGLES().glUniformMatrix2fv(location, count, false, values);
    }


    /**
     * Set a value to a uniform variable (mat2 array).
     *
     * @param count
     * @param values
     * @param offset
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix2fv</a>
     */
    public void setMatrix2(int count, float[] values, int offset)
    {
        getGLES().glUniformMatrix2fv(location, count, false, values, offset);
    }


    /**
     * Set a value to a uniform variable (mat2 array).
     * This method calls {@link #setMatrix2(int, float[], int)
     * setMatrix2}(values.length / (2 * 2), values, 0).
     *
     * @param values
     *
     * @see #setMatrix2(int, float[], int)
     */
    public void setMatrix2(float[] values)
    {
        setMatrix2(values.length / (2 * 2), values, 0);
    }


    /**
     * Set a value to a uniform variable (mat3 array).
     *
     * @param count
     * @param values
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix3fv</a>
     */
    public void setMatrix3(int count, FloatBuffer values)
    {
        getGLES().glUniformMatrix3fv(location, count, false, values);
    }


    /**
     * Set a value to a uniform variable (mat3 array).
     *
     * @param count
     * @param values
     * @param offset
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix3fv</a>
     */
    public void setMatrix3(int count, float[] values, int offset)
    {
        getGLES().glUniformMatrix3fv(location, count, false, values, offset);
    }


    /**
     * Set a value to a uniform variable (mat3 array).
     * This method calls {@link #setMatrix3(int, float[], int)
     * setMatrix3}(values.length / (3 * 3), values, 0).
     *
     * @param values
     *
     * @see #setMatrix3(int, float[], int)
     */
    public void setMatrix3(float[] values)
    {
        setMatrix3(values.length / (3 * 3), values, 0);
    }


    /**
     * Set a value to a uniform variable (mat4 array).
     *
     * @param count
     * @param values
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix4fv</a>
     */
    public void setMatrix4(int count, FloatBuffer values)
    {
        getGLES().glUniformMatrix4fv(location, count, false, values);
    }


    /**
     * Set a value to a uniform variable (mat4 array).
     *
     * @param count
     * @param values
     * @param offset
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix4fv</a>
     */
    public void setMatrix4(int count, float[] values, int offset)
    {
        getGLES().glUniformMatrix4fv(location, count, false, values, offset);
    }


    /**
     * Set a value to a uniform variable (mat4 array).
     * This method calls {@link #setMatrix4(int, float[], int)
     * setMatrix4}(values.length / (4 * 4), values, 0).
     *
     * @param values
     *
     * @see #setMatrix4(int, float[], int)
     */
    public void setMatrix4(float[] values)
    {
        setMatrix4(values.length / (4 * 4), values, 0);
    }


    /**
     * This method is an alias of {@link #set1(float)}.
     *
     * @param x
     *
     * @see #set1(float)
     */
    public void set(float x)
    {
        set1(x);
    }


    /**
     * This method is an alias of {@link #set1(int)}.
     *
     * @param x
     *
     * @see #set1(int)
     */
    public void set(int x)
    {
        set1(x);
    }


    /**
     * This method is an alias of {@link #set2(float, float)}.
     *
     * @param x
     * @param y
     *
     * @see #set2(float, float)
     */
    public void set(float x, float y)
    {
        set2(x, y);
    }


    /**
     * This method is an alias of {@link #set2(int, int)}.
     *
     * @param x
     * @param y
     *
     * @see #set2(int, int)
     */
    public void set(int x, int y)
    {
        set2(x, y);
    }


    /**
     * This method is an alias of {@link #set3(float, float, float)}.
     *
     * @param x
     * @param y
     * @param z
     *
     * @see #set3(float, float, float)
     */
    public void set(float x, float y, float z)
    {
        set3(x, y, z);
    }


    /**
     * This method is an alias of {@link #set3(int, int, int)}.
     *
     * @param x
     * @param y
     * @param z
     *
     * @see #set3(int, int, int)
     */
    public void set(int x, int y, int z)
    {
        set3(x, y, z);
    }


    /**
     * This method is an alias of {@link #set4(float, float, float, float)}.
     *
     * @param x
     * @param y
     * @param z
     * @param w
     *
     * @see #set4(float, float, float, float)
     */
    public void set(float x, float y, float z, float w)
    {
        set4(x, y, z, w);
    }


    /**
     * This method is an alias of {@link #set4(int, int, int, int)}.
     *
     * @param x
     * @param y
     * @param z
     * @param w
     *
     * @see #set4(int, int, int, int)
     */
    public void set(int x, int y, int z, int w)
    {
        set4(x, y, z, w);
    }


    /**
     * Set a value to a non-array uniform variable.
     * This method calls another setter method depending on the size
     * of the given values. The following table shows pairs of size
     * and method.
     *
     * <br/><br/>
     * <table border="1" cellpadding="5" style="border-collapse: collapse;">
     * <tr style="background-color: lightgray;">
     *   <th>values.length</th> <th>Method to call</th>
     * </tr>
     * <tr>
     *   <td align="center">1</td> <td>{@link #set1(float) set1}(values[0])</td>
     * </tr>
     * <tr>
     *   <td align="center">2</td> <td>{@link #set2(float, float) set2}(values[0], values[1])</td>
     * </tr>
     * <tr>
     *   <td align="center">3</td> <td>{@link #set3(float, float, float) set3}(values[0], values[1], values[2])</td>
     * </tr>
     * <tr>
     *   <td align="center">4</td> <td>{@link #set4(float, float, float, float) set4}(values[0], values[1], values[2], values[3])</td>
     * </tr>
     * </table>
     *
     * @param values
     *
     * @throws IllegalArgumentException
     *         The argument is null, or its length is none of the ones
     *         listed in the above table.
     */
    public void set(float[] values)
    {
        if (values == null)
        {
            throw new IllegalArgumentException();
        }

        switch (values.length)
        {
            case 1:
                set1(values[0]);
                break;

            case 2:
                set2(values[0], values[1]);
                break;

            case 3:
                set3(values[0], values[1], values[2]);
                break;

            case 4:
                set4(values[0], values[1], values[2], values[3]);
                break;

            default:
                throw new IllegalArgumentException();
        }
    }


    /**
     * Set a value to a non-array uniform variable.
     * This method calls another setter method depending on the size
     * of the given values. The following table shows pairs of size
     * and method.
     *
     * <br/><br/>
     * <table border="1" cellpadding="5" style="border-collapse: collapse;">
     * <tr style="background-color: lightgray;">
     *   <th>values.length</th> <th>Method to call</th>
     * </tr>
     * <tr>
     *   <td align="center">1</td> <td>{@link #set1(int) set1}(values[0])</td>
     * </tr>
     * <tr>
     *   <td align="center">2</td> <td>{@link #set2(int, int) set2}(values[0], values[1])</td>
     * </tr>
     * <tr>
     *   <td align="center">3</td> <td>{@link #set3(int, int, int) set3}(values[0], values[1], values[2])</td>
     * </tr>
     * <tr>
     *   <td align="center">4</td> <td>{@link #set4(int, int, int, int) set4}(values[0], values[1], values[2], values[3])</td>
     * </tr>
     * </table>
     *
     * @param values
     *
     * @throws IllegalArgumentException
     *         The argument is null, or its length is none of the ones
     *         listed in the above table.
     */
    public void set(int[] values)
    {
        if (values == null)
        {
            throw new IllegalArgumentException();
        }

        switch (values.length)
        {
            case 1:
                set1(values[0]);
                break;

            case 2:
                set2(values[0], values[1]);
                break;

            case 3:
                set3(values[0], values[1], values[2]);
                break;

            case 4:
                set4(values[0], values[1], values[2], values[3]);
                break;

            default:
                throw new IllegalArgumentException();
        }
    }


    /**
     * Set a value to a non-array, matrix uniform variable.
     * This method calls another setter method depending on the size
     * of the given values. The following table shows pairs of size
     * and method.
     *
     * <br/><br/>
     * <table border="1" cellpadding="5" style="border-collapse: collapse;">
     * <tr style="background-color: lightgray;">
     *   <th>values.length</th> <th>Method to call</th>
     * </tr>
     * <tr>
     *   <td align="center">4</td> <td>{@link #setMatrix2(float[]) setMatrix2}(values)</td>
     * </tr>
     * <tr>
     *   <td align="center">9</td> <td>{@link #setMatrix3(float[]) setMatrix3}(values)</td>
     * </tr>
     * <tr>
     *   <td align="center">16</td> <td>{@link #setMatrix4(float[]) setMatrix4}(values)</td>
     * </tr>
     * </table>
     *
     * @param values
     *
     * @throws IllegalArgumentException
     *         The argument is null, or its length is none of the ones
     *         listed in the above table.
     */
    public void setMatrix(float[] values)
    {
        if (values == null)
        {
            throw new IllegalArgumentException();
        }

        switch (values.length)
        {
            case 4:
                setMatrix2(values);
                break;

            case 9:
                setMatrix3(values);
                break;

            case 16:
                setMatrix4(values);
                break;

            default:
                throw new IllegalArgumentException();
        }
    }


    /**
     * Get an implementation of GLES interface.
     *
     * @return
     *         An object implementing GLES interface.
     */
    private static GLES getGLES()
    {
        return GLESFactory.getInstance();
    }
}
