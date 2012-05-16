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
 * OpenGL ES capability.
 *
 * <p>
 * This list matches the set of values that glEnable() accepts.
 * All capabilities except {@link #DITHER} are disabled by default.
 * </p>
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E</b></span>
 *
 * <span style="color: darkgreen;">// Enable depth test.</span>
 * <span style="color: darkgreen;">// This is equivalent to glEnable(GL_DEPTH_TEST).</span>
 * Capability.{@link #DEPTH_TEST}.{@link #enable()};
 * </pre>
 *
 * @author Takahiko Kawasaki
 *
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glEnable.xml">glEnable</a>
 */
public enum Capability
{
    /**
     * GL_BLEND.
     */
    BLEND(getGLES().GL_BLEND()),


    /**
     * GL_CULL_FACE.
     */
    CULL_FACE(getGLES().GL_CULL_FACE()),


    /**
     * GL_DEPTH_TEST.
     */
    DEPTH_TEST(getGLES().GL_DEPTH_TEST()),


    /**
     * GL_DITHER.
     */
    DITHER(getGLES().GL_DITHER()),


    /**
     * GL_POLYGON_OFFSET_FILL.
     */
    POLYGON_OFFSET_FILL(getGLES().GL_POLYGON_OFFSET_FILL()),


    /**
     * GL_SAMPLE_ALPHA_TO_COVERAGE.
     */
    SAMPLE_ALPHA_TO_COVERAGE(getGLES().GL_SAMPLE_ALPHA_TO_COVERAGE()),


    /**
     * GL_SAMPLE_COVERAGE.
     */
    SAMPLE_COVERAGE(getGLES().GL_SAMPLE_COVERAGE()),


    /**
     * GL_SCISSOR_TEST.
     */
    SCISSOR_TEST(getGLES().GL_SCISSOR_TEST()),


    /**
     * GL_STENCIL_TEST.
     */
    STENCIL_TEST(getGLES().GL_STENCIL_TEST());


    /**
     * An integer representing this capability.
     */
    private final int capability;


    /**
     * A constructo with a capability.
     *
     * @param capability
     *         An integer represeting a capability.
     */
    private Capability(int capability)
    {
        this.capability = capability;
    }


    /**
     * Get the integer representing this capability.
     *
     * @return
     *     The integer representing this capability.
     *     One of the following.
     *
     * <ol>
     * <li>GL_BLEND
     * <li>GL_CULL_FACE
     * <li>GL_DEPTH_TEST
     * <li>GL_DITHER
     * <li>GL_POLYGON_OFFSET_FILL
     * <li>GL_SAMPLE_ALPHA_TO_COVERAGE
     * <li>GL_SAMPLE_COVERAGE
     * <li>GL_SCISSOR_TEST
     * <li>GL_STENCIL_TEST
     * </ol>
     */
    public int getCapability()
    {
        return capability;
    }


    /**
     * Enable this capability using glEnable().
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glEnable.xml">glEnable</a>
     */
    public void enable()
    {
        getGLES().glEnable(capability);
    }


    /**
     * Disable this capability using glDisable().
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisable.xml">glDisable</a>
     */
    public void disable()
    {
        getGLES().glDisable(capability);
    }


    /**
     * Check if this capability is enabled using glIsEnabled().
     *
     * @return
     *         True if this capability is enabled.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glIsEnabled.xml">glIsEnabled</a>
     */
    public boolean isEnabled()
    {
        return getGLES().glIsEnabled(capability);
    }


    /**
     * Get an implementation of {@link GLES} interface.
     *
     * @return
     *         An object implementing {@link GLES} interface.
     */
    private static GLES getGLES()
    {
        return GLESFactory.getInstance();
    }
}
