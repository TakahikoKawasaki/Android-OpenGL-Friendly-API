/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Comparator used for the stencil test.
 *
 * @author Takahiko Kawasaki
 *
 * @see StencilComparatorOperator
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilFunc.xml">glStencilFunc</a>
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilFuncSeparate.xml">glStencilFuncSeparate</a>
 */
public class StencilComparator
{
    private StencilComparisonOperator operator;
    private int referenceValue;
    private int mask;


    /**
     * This constructor is an alias of {@link #StencilComparator(
     * StencilComparisonOperator, int, int) StencilComparator}(null,
     * 0, 0xffffffff).
     */
    public StencilComparator()
    {
        this(null, 0, 0xffffffff);
    }


    /**
     * A constructor to define the function for the stencil test.
     *
     * @param operator
     *         A comparison operator. If null is given, {@link
     *         StencilComparisonOperator#ALWAYS} is used.
     *
     * @param referenceValue
     *         A reference value used for the comparison.
     *
     * @param mask
     *         A bit mask that is logical-ANDed with the bits
     *         of the stencil buffer.
     */
    public StencilComparator(StencilComparisonOperator operator, int referenceValue, int mask)
    {
        if (operator == null)
        {
            operator = StencilComparisonOperator.ALWAYS;
        }

        this.operator = operator;
        this.referenceValue = referenceValue;
        this.mask = mask;
    }


    /**
     * A copy constructor.
     *
     * @param comparator
     *         A comparator to copy from. If null is given,
     *         {@link StencilComparisonOperator#ALWAYS ALWAYS},
     *         0 and 0xffffffff are used as operator, reference
     *         value and mask, respectively.
     */
    public StencilComparator(StencilComparator comparator)
    {
        if (comparator == null)
        {
            operator = StencilComparisonOperator.ALWAYS;
            referenceValue = 0;
            mask = 0xffffffff;
        }
        else
        {
            operator = comparator.operator;
            referenceValue = comparator.referenceValue;
            mask = comparator.mask;
        }
    }


    /**
     * Get the comparison operator.
     *
     * @return
     *         The comparison operator.
     */
    public StencilComparisonOperator getOperator()
    {
        return operator;
    }


    /**
     * Set a comparison operator.
     *
     * @param operator
     *         A comparison operator. If null is given, {@link
     *         StencilComparisonOperator#ALWAYS} is set.
     *
     * @return
     *         This StencilComparator object.
     */
    public StencilComparator setOperator(StencilComparisonOperator operator)
    {
        if (operator == null)
        {
            operator = StencilComparisonOperator.ALWAYS;
        }

        this.operator = operator;

        return this;
    }


    /**
     * Get the reference value.
     *
     * @return
     *         The reference value used for the comparison.
     */
    public int getReferenceValue()
    {
        return referenceValue;
    }


    /**
     * Set a reference value.
     *
     * @param referenceValue
     *         A reference value used for the comparison.
     *
     * @return
     *         This StencilComparator object.
     */
    public StencilComparator setReferenceValue(int referenceValue)
    {
        this.referenceValue = referenceValue;

        return this;
    }


    /**
     * Get the bit mask.
     *
     * @return
     *         The bit mask that is logical-ANDed with the bits
     *         of the stencil buffer.
     */
    public int getMask()
    {
        return mask;
    }


    /**
     * Set a bit mask.
     *
     * @param mask
     *         A bit mask that is logical-ANDed with the bits
     *         of the stencil buffer.
     *
     * @return
     *         This StencilComparator object
     */
    public StencilComparator setMask(int mask)
    {
        this.mask = mask;

        return this;
    }
}
