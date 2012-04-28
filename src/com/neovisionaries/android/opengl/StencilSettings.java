/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


/**
 * Stencil settings.
 *
 * <pre style="background: lightgray;">
 * <span style="color: darkgreen;">// <b>E X A M P L E</b></span>
 *
 * new {@link #StencilSettings()}
 *     .{@link #setActionSet(StencilActionSet) setActionSet}(
 *         new {@link StencilActionSet#StencilActionSet(StencilAction,
 *         StencilAction, StencilAction) StencilActionSet}(
 *             {@link StencilAction#REPLACE},
 *             {@link StencilAction#DECR},
 *             {@link StencilAction#DECR}
 *         )
 *     )
 *     .{@link #setComparator(StencilComparator) setComparator}(
 *         new {@link StencilComparator#StencilComparator(
 *         StencilComparisonOperator, int, int) StencilComparator}(
 *             {@link StencilComparisonOperator#LESS},
 *             0x7,
 *             0x3
 *         )
 *     )
 *     .{@link #apply()};
 * </pre>
 *
 * @author Takahiko Kawasaki
 *
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilFunc.xml">glStencilFunc</a>
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilFuncSeparate.xml">glStencilFuncSeparate</a>
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilOp.xml">glStencilOp</a>
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilOpSeparate.xml">glStencilOpSeparate</a>
 */
public class StencilSettings
{
    private StencilActionSet frontActionSet = new StencilActionSet();
    private StencilActionSet backActionSet = new StencilActionSet();
    private StencilComparator frontComparator = new StencilComparator();
    private StencilComparator backComparator = new StencilComparator();


    /**
     * Get the action set for the front face.
     *
     * <p>
     * The default action set is an instance created by {@link
     * StencilActionSet#StencilActionSet() StencilActionSet()}.
     * </p>
     *
     * @return
     *         The action set for the front face.
     */
    public StencilActionSet getFrontActionSet()
    {
        return frontActionSet;
    }


    /**
     * Get the action set for the back face.
     *
     * <p>
     * The default action set is an instance created by {@link
     * StencilActionSet#StencilActionSet() StencilActionSet()}.
     * </p>
     *
     * @return
     *         The action set for the back face.
     */
    public StencilActionSet getBackActionSet()
    {
        return backActionSet;
    }


    /**
     * This method is an alias of {@link #setActionSet(StencilActionSet,
     * Face) setActionSet}(actionSet, null).
     */
    public StencilSettings setActionSet(StencilActionSet actionSet)
    {
        return setActionSet(actionSet, null);
    }


    /**
     * Set an action set for the specified face.
     *
     * <p>
     * If the major version number of the underlying OpenGL ES implementation
     * is less than 2 (OpenGL ES 1.1, for example), it is no use setting an
     * action set for the back face. It is because <a
     * href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilOpSeparate.xml"
     * >glStencilOpSeparate</a> is not available. In this case, an action
     * set for the front face is used for both the front face and the back
     * face.
     * </p>
     *
     * @param actionSet
     *         An action set. The given action set is copied by using
     *         {@link StencilActionSet#StencilActionSet(StencilActionSet)
     *         the copy constructor of StencilActionSet}.
     *
     * @param face
     *         A face for which the action set is used. If null is given,
     *         {@link Face#FRONT_AND_BACK} is used, meaning that the
     *         given action set is used for both the front face and
     *         the back face.
     *
     * @return
     *         This StencilSettings object.
     */
    public StencilSettings setActionSet(StencilActionSet actionSet, Face face)
    {
        // Copy
        actionSet = new StencilActionSet(actionSet);

        if (face == null)
        {
            face = Face.FRONT_AND_BACK;
        }

        if (face == Face.FRONT_AND_BACK || face == Face.FRONT)
        {
            frontActionSet = actionSet;
        }

        if (face == Face.FRONT_AND_BACK || face == Face.BACK)
        {
            backActionSet = actionSet;
        }

        return this;
    }


    /**
     * Get the stencil comparator for the front face.
     *
     * <p>
     * The default stencil comparator is an instance created by
     * {@link StencilComparator#StencilComparator()
     * StencilComparator()}.
     * </p>
     *
     * @return
     *         The stencil comparator for the front face.
     */
    public StencilComparator getFrontComparator()
    {
        return frontComparator;
    }


    /**
     * Get the stencil comparator for the back face.
     *
     * <p>
     * The default stencil comparator is an instance created by
     * {@link StencilComparator#StencilComparator()
     * StencilComparator()}.
     * </p>
     *
     * @return
     *         The stencil comparator for the back face.
     */
    public StencilComparator getBackComparator()
    {
        return backComparator;
    }


    /**
     * This method is an alias of {@link #setComparator(StencilComparator,
     * Face) setComparator}(comparator, null).
     *
     * @param comparator
     *         A stencil comparator.
     *
     * @return
     *         This StecilSettings object.
     */
    public StencilSettings setComparator(StencilComparator comparator)
    {
        return setComparator(comparator, null);
    }


    /**
     * Set a stencil comparator for the specified face.
     *
     * <p>
     * If the major version number of the underlying OpenGL ES implementation
     * is less than 2 (OpenGL ES 1.1, for example), it is no use setting a
     * stencil comparator for the back face. It is because <a
     * href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilFuncSeparate.xml"
     * >glStencilFuncSeparate</a> is not available. In this case, a stencil
     * comparator for the front face is used for both the front face and
     * the back face.
     * </p>
     *
     * @param comparator
     *         A stencil comparator. The given comparator is copied by
     *         using {@link StencilComparator#StencilComparator(StencilComparator)
     *         the copy constructor of StencilComparator}.
     *
     * @param face
     *         A face for which the comparator is used. If null is given,
     *         {@link Face#FRONT_AND_BACK} is used, meaning that the given
     *         comparator is used for both the front face and the back face.
     *
     * @return
     *         This StencilSettings object.
     */
    public StencilSettings setComparator(StencilComparator comparator, Face face)
    {
        // Copy
        comparator = new StencilComparator(comparator);

        if (face == null)
        {
            face = Face.FRONT_AND_BACK;
        }

        if (face == Face.FRONT_AND_BACK || face == Face.FRONT)
        {
            frontComparator = comparator;
        }

        if (face == Face.FRONT_AND_BACK || face == Face.BACK)
        {
            backComparator = comparator;
        }

        return this;
    }


    /**
     * Enable the stencil test. glEnable(STENCIL_TEST) is called.
     *
     * @return
     *         This StencilSettings object.
     */
    public StencilSettings enable()
    {
        Capability.STENCIL_TEST.enable();

        return this;
    }


    /**
     * Disable the stencil test. glDisable(STENCIL_TEST) is called.
     *
     * @return
     *         This StencilSettings object.
     */
    public StencilSettings disable()
    {
        Capability.STENCIL_TEST.disable();

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
     * <li>glStencilOpSeparate() (for the front face)
     * <li>glStencilOpSeparator() (for the back face)
     * <li>glStencilFuncSeparate() (for the front face)
     * <li>glStencilFuncSeparator() (for the back face)
     * </ol>
     *
     * <p>
     * Otherwise, the following two are executed.
     * </p>
     *
     * <ol>
     * <li>{@link #enable()}
     * <li>glStencilOp()
     * <li>glStencilFunc()
     * </ol>
     *
     * @return
     *         This StencilSettings object.
     *
     * @see #enable()
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilFunc.xml">glStencilFunc</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilFuncSeparate.xml">glStencilFuncSeparate</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilOp.xml">glStencilOp</a>
     * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilOpSeparate.xml">glStencilOpSeparate</a>
     */
    public StencilSettings apply()
    {
        enable();

        GLES gles = GLESFactory.getInstance();

        // Get the major version number of the underlying OpenGL ES implementation.
        boolean es2 = (2 <= gles.getMajorVersion());

        // Stencil action set.
        if (es2)
        {
            applyActionSet(frontActionSet, Face.FRONT);
            applyActionSet(backActionSet, Face.BACK);
        }
        else
        {
            applyActionSet(frontActionSet, null);
        }

        // Stencil comparator.
        if (es2)
        {
            applyComparator(frontComparator, Face.FRONT);
            applyComparator(backComparator, Face.BACK);
        }
        else
        {
            applyComparator(frontComparator, null);
        }

        return this;
    }


    private void applyActionSet(StencilActionSet actionSet, Face face)
    {
        if (face == null)
        {
            getGLES().glStencilOp(
                    actionSet.getStencilFailureAction().getAction(),
                    actionSet.getDepthFailureAction().getAction(),
                    actionSet.getPassAction().getAction());
        }
        else
        {
            getGLES().glStencilOpSeparate(
                    face.getFace(),
                    actionSet.getStencilFailureAction().getAction(),
                    actionSet.getDepthFailureAction().getAction(),
                    actionSet.getPassAction().getAction());
        }
    }


    private void applyComparator(StencilComparator comparator, Face face)
    {
        if (face == null)
        {
            getGLES().glStencilFunc(
                    comparator.getOperator().getOperator(),
                    comparator.getReferenceValue(),
                    comparator.getMask());
        }
        else
        {
            getGLES().glStencilFuncSeparate(
                    face.getFace(),
                    comparator.getOperator().getOperator(),
                    comparator.getReferenceValue(),
                    comparator.getMask());
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
