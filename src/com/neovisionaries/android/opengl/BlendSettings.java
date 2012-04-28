/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Blend settings.
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E</b></span>
 *
 * new {@link BlendSettings#BlendSettings() BlendSettings()}
 *     .{@link #setSourceFactor(BlendFactor) setSourceFactor}({@link
 *      BlendFactor#ONE})
 *     .{@link #setOperator(BlendOperator) setOperator}({@link
 *      BlendOperator#ADD})
 *     .{@link #apply()};
 * </pre>
 *
 * @author Takahiko Kawasaki
 *
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendColor.xml">glBlendColor</a>
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendEquationSeparate.xml">glBlendEquationSeparate</a>
 */
public class BlendSettings
{
    private BlendFactor sourceRGBFactor = BlendFactor.ONE;
    private BlendFactor sourceAlphaFactor = BlendFactor.ONE;
    private BlendFactor destinationRGBFactor = BlendFactor.ONE;
    private BlendFactor destinationAlphaFactor = BlendFactor.ONE;
    private float constantRed = 0;
    private float constantGreen = 0;
    private float constantBlue = 0;
    private float constantAlpha = 0;
    private BlendOperator rgbOperator = BlendOperator.ADD;
    private BlendOperator alphaOperator = BlendOperator.ADD;


    /**
     * Set the blending factor for source. The default value is
     * {@link BlendFactor#ONE}.
     *
     * <p>
     * The given value is used for both RGB and alpha factors.
     * </p>
     *
     * @param factor
     *         A blending factor. If null is given, {@link
     *         BlendFactor#ONE} is used.
     *
     * @return
     *         This BlendSettings object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
     */
    public BlendSettings setSourceFactor(BlendFactor factor)
    {
        if (factor == null)
        {
            factor = BlendFactor.ONE;
        }

        this.sourceRGBFactor = factor;
        this.sourceAlphaFactor = factor;

        return this;
    }


    /**
     * Set the blending factor for RGB of source. The default
     * value is {@link BlendFactor#ONE}.
     *
     * @param factor
     *         A blending factor. If null is given, {@link
     *         BlendFactor#ONE} is used.
     *
     * @return
     *         This BlendSettings object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
     */
    public BlendSettings setSourceRGBFactor(BlendFactor factor)
    {
        if (factor == null)
        {
            factor = BlendFactor.ONE;
        }

        this.sourceRGBFactor = factor;

        return this;
    }


    /**
     * Set the blending factor for alpha of source. The default
     * value is {@link BlendFactor#ONE}.
     *
     * <p>
     * If the version of the underlying OpenGL ES implementation
     * is less than 2.0, calling this method has no meaning because
     * glBlendFuncSeparate() is not available.
     * </p>
     *
     * @param factor
     *         A blending factor. If null is given, {@link
     *         BlendFactor#ONE} is used.
     *
     * @return
     *         This BlendSettings object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
     */
    public BlendSettings setSourceAlphaFactor(BlendFactor factor)
    {
        if (factor == null)
        {
            factor = BlendFactor.ONE;
        }

        this.sourceAlphaFactor = factor;

        return this;
    }


    /**
     * Get the blending factor for RGB of source.
     *
     * @return
     *         The blending factor for RGB of source.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
     */
    public BlendFactor getSourceRGBFactor()
    {
        return sourceRGBFactor;
    }


    /**
     * Get the blending factor for alpha of source.
     *
     * @return
     *         The blending factor for alpha of source.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
     */
    public BlendFactor getSourceAlphaFactor()
    {
        return sourceAlphaFactor;
    }


    /**
     * Set the blending factor for destination. The default
     * value is {@link BlendFactor#ONE}.
     *
     * <p>
     * The given value is used for both RGB and alpha factors.
     * </p>
     *
     * @param factor
     *         A blending factor. If null is given, {@link
     *         BlendFactor#ONE} is used.
     *
     * @return
     *         This BlendSettings object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
     */
    public BlendSettings setDestinationFactor(BlendFactor factor)
    {
        if (factor == null)
        {
            factor = BlendFactor.ONE;
        }

        this.destinationRGBFactor = factor;
        this.destinationAlphaFactor = factor;

        return this;
    }


    /**
     * Set the blending factor for RGB of destination. The default
     * value is {@link BlendFactor#ONE}.
     *
     * @param factor
     *         A blending factor. If null is given, {@link
     *         BlendFactor#ONE} is used.
     *
     * @return
     *         This BlendSettings object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
     */
    public BlendSettings setDestinationRGBFactor(BlendFactor factor)
    {
        if (factor == null)
        {
            factor = BlendFactor.ONE;
        }

        this.destinationRGBFactor = factor;

        return this;
    }


    /**
     * Set the blending factor for alpha of destination. The default
     * value is {@link BlendFactor#ONE}.
     *
     * <p>
     * If the version of the underlying OpenGL ES implementation
     * is less than 2.0, calling this method has no meaning because
     * glBlendFuncSeparate() is not available.
     * </p>
     *
     * @param factor
     *         A blending factor. If null is given, {@link
     *         BlendFactor#ONE} is used.
     *
     * @return
     *         This BlendSettings object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
     */
    public BlendSettings setDestinationAlphaFactor(BlendFactor factor)
    {
        if (factor == null)
        {
            factor = BlendFactor.ONE;
        }

        this.destinationAlphaFactor = factor;

        return this;
    }


    /**
     * Get the blending factor for RGB of destination.
     *
     * @return
     *         The blending factor for RGB of destination.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
     */
    public BlendFactor getDestinationRGBFactor()
    {
        return this.destinationRGBFactor;
    }


    /**
     * Get the blending factor for alpha of destination.
     *
     * @return
     *         The blending factor for alpha of destination.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
     */
    public BlendFactor getDestinationAlphaFactor()
    {
        return this.destinationAlphaFactor;
    }


    /**
     * Set the constant blending color. The default value is
     * (0, 0, 0, 0).
     *
     * <p>
     * If the version of the underlying OpenGL ES implementation
     * is less than 2.0, calling this method has no meaning because
     * glBlendColor() is not available.
     * </p>
     *
     * @param red
     * @param green
     * @param blue
     * @param alpha
     *
     * @return
     *         This BlendSettings object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendColor.xml">glBlendColor</a>
     */
    public BlendSettings setColor(float red, float green, float blue, float alpha)
    {
        this.constantRed = GLESHelper.clampFrom0To1(red);
        this.constantGreen = GLESHelper.clampFrom0To1(green);
        this.constantBlue = GLESHelper.clampFrom0To1(blue);
        this.constantAlpha = GLESHelper.clampFrom0To1(alpha);

        return this;
    }


    /**
     * Get the constant blending color.
     *
     * @return
     *         The constant blending color.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendColor.xml">glBlendColor</a>
     */
    public float[] getColor()
    {
        return new float[] { constantRed, constantGreen, constantBlue, constantAlpha };
    }


    /**
     * Set the blending operator for both RGB and alpha. The default
     * value is {@link BlendOperator#ADD}.
     *
     * <p>
     * If the version of the underlying OpenGL ES implementation
     * is less than 2.0, calling this method has no meaning because
     * neither glBlendEquation() nor glBlendEquationsSeparate() is
     * available.
     * </p>
     *
     * @param operator
     *         A blending operator.
     *
     * @return
     *         This BlendSettings object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendEquation.xml">glBlendEquation</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendEquationSeparate.xml">glBlendEquationSeparate</a>
     */
    public BlendSettings setOperator(BlendOperator operator)
    {
        if (operator == null)
        {
            operator = BlendOperator.ADD;
        }

        this.rgbOperator = operator;
        this.alphaOperator = operator;

        return this;
    }


    /**
     * Set the blending operator for RGB. The default value is
     * {@link BlendOperator#ADD}.
     *
     * <p>
     * If the version of the underlying OpenGL ES implementation
     * is less than 2.0, calling this method has no meaning because
     * neither glBlendEquation() nor glBlendEquationsSeparate() is
     * available.
     * </p>
     *
     * @param operator
     *         A blending operator.
     *
     * @return
     *         This BlendSettings object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendEquation.xml">glBlendEquation</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendEquationSeparate.xml">glBlendEquationSeparate</a>
     */
    public BlendSettings setRGBOperator(BlendOperator operator)
    {
        if (operator == null)
        {
            operator = BlendOperator.ADD;
        }

        this.rgbOperator = operator;

        return this;
    }


    /**
     * Set the blending operator for alpha. The default value is
     * {@link BlendOperator#ADD}.
     *
     * <p>
     * If the version of the underlying OpenGL ES implementation
     * is less than 2.0, calling this method has no meaning because
     * neither glBlendEquation() nor glBlendEquationsSeparate() is
     * available.
     * </p>
     *
     * @param operator
     *         A blending operator.
     *
     * @return
     *         This BlendSettings object.
     *
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendEquation.xml">glBlendEquation</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendEquationSeparate.xml">glBlendEquationSeparate</a>
     */
    public BlendSettings setAlphaOperator(BlendOperator operator)
    {
        if (operator == null)
        {
            operator = BlendOperator.ADD;
        }

        this.alphaOperator = operator;

        return this;
    }


    /**
     * Get the blending operator for RGB.
     *
     * @return
     *         The blending operator for RGB.
     */
    public BlendOperator getRGBOperator()
    {
        return rgbOperator;
    }


    /**
     * Get the blending operator for alpha.
     *
     * @return
     *         The blending operator for alpha.
     */
    public BlendOperator getAlphaOperator()
    {
        return alphaOperator;
    }


    /**
     * Enable blending (call glEnable(GL_BLEND)).
     *
     * @return
     *         This BlendSettings object.
     */
    public BlendSettings enable()
    {
        Capability.BLEND.enable();

        return this;
    }


    /**
     * Disable blending (call glDisable(GL_BLEND)).
     *
     * @return
     *         This BlendSettings object.
     */
    public BlendSettings disable()
    {
        Capability.BLEND.disable();

        return this;
    }


    /**
     * Apply the settings values that this instance holds to
     * the underlying OpenGL ES implementation.
     *
     * <p>
     * If the OpenGL ES version is equal to or greater than
     * 2.0, methods listed below are executed.
     * </p>
     *
     * <ol>
     * <li>{@link #enable()}
     * <li>glBlendFuncSeparate()
     * <li>glBlendColor()
     * <li>glBlendEquationSeparate()
     * </ol>
     *
     * <p>
     * Otherwise, the following two are executed.
     * </p>
     *
     * <ol>
     * <li>{@link #enable()}
     * <li>glBlendFunc()
     * </ol>
     *
     * @return
     *         This BlendSettings object.
     *
     * @see #enable()
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFunc.xml">glBlendFunc</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendFuncSeparate.xml">glBlendFuncSeparate</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendColor.xml">glBlendColor</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBlendEquationSeparate.xml">glBlendEquationSeparate</a>
     */
    public BlendSettings apply()
    {
        // Enable blending.
        enable();

        GLES gles = GLESFactory.getInstance();

        boolean es2 = (2 <= gles.getMajorVersion());

        // Blend factors.
        if (es2)
        {
            gles.glBlendFuncSeparate(
                    sourceRGBFactor.getFactor(),
                    destinationRGBFactor.getFactor(),
                    sourceAlphaFactor.getFactor(),
                    destinationAlphaFactor.getFactor());
        }
        else
        {
            gles.glBlendFunc(
                    sourceRGBFactor.getFactor(),
                    destinationRGBFactor.getFactor());
        }

        // Blend constant color.
        if (es2)
        {
            gles.glBlendColor(constantRed, constantGreen, constantBlue, constantAlpha);
        }

        // Blend operator.
        if (es2)
        {
            gles.glBlendEquationSeparate(
                    rgbOperator.getOperator(),
                    alphaOperator.getOperator());
        }

        return this;
    }
}
