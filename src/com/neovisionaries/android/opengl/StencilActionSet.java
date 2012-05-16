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
 * Set of stencil actions.
 *
 * @author Takahiko Kawasaki
 *
 * @see StencilAction
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilOp.xml">glStencilOp</a>
 * @see <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glStencilOpSeparate.xml">glStencilOpSeparate</a>
 */
public class StencilActionSet
{
    private StencilAction stencilFailureAction;
    private StencilAction depthFailureAction;
    private StencilAction passAction;


    /**
     * This constructor is an alias of {@link
     * #StencilActionSet(StencilAction, StencilAction,
     * StencilAction) StencilAction}(null, null, null).
     */
    public StencilActionSet()
    {
        this(null, null, null);
    }


    /**
     * A constructor which stencil actions.
     *
     * @param stencilFailureAction
     *         An action that is taken when the stencil test fails.
     *         If null is given, {@link StencilAction#KEEP} is set.
     *
     * @param depthFailureAction
     *         An action that is taken when the stencil test passes
     *         but the depth test fails.
     *         If null is given, {@link StencilAction#KEEP} is set.
     *
     * @param passAction
     *         An action that is taken when both the stencil test
     *         and the depth test pass.
     *         If null is given, {@link StencilAction#KEEP} is set.
     */
    public StencilActionSet(StencilAction stencilFailureAction, StencilAction depthFailureAction, StencilAction passAction)
    {
        if (stencilFailureAction == null)
        {
            stencilFailureAction = StencilAction.KEEP;
        }

        if (depthFailureAction == null)
        {
            depthFailureAction = StencilAction.KEEP;
        }

        if (passAction == null)
        {
            passAction = StencilAction.KEEP;
        }

        this.stencilFailureAction = stencilFailureAction;
        this.depthFailureAction = depthFailureAction;
        this.passAction = passAction;
    }


    /**
     * A copy constructor.
     *
     * @param actionSet
     *         An action set to copy from. If null is given,
     *         If null is given, all actions are set to
     *         {@link StencilAction#KEEP}.
     */
    public StencilActionSet(StencilActionSet actionSet)
    {
        if (actionSet == null)
        {
            stencilFailureAction = StencilAction.KEEP;
            depthFailureAction = StencilAction.KEEP;
            passAction = StencilAction.KEEP;
        }
        else
        {
            stencilFailureAction = actionSet.stencilFailureAction;
            depthFailureAction = actionSet.depthFailureAction;
            passAction = actionSet.passAction;
        }
    }


    /**
     * Get the action taken when the stencil test fails.
     *
     * @return
     *         The action taken when the stencil test fails.
     */
    public StencilAction getStencilFailureAction()
    {
        return stencilFailureAction;
    }


    /**
     * Set an action taken when the stencil test fails.
     *
     * @param action
     *         An action taken when the stencil test fails.
     *         If null is given, {@link StencilAction#KEEP}
     *         is set.
     *
     * @return
     *         This StencilActionSet object.
     */
    public StencilActionSet setStencilFailureAction(StencilAction action)
    {
        if (action == null)
        {
            action = StencilAction.KEEP;
        }

        stencilFailureAction = action;

        return this;
    }


    /**
     * Get the action taken when the stencil test passes but
     * the depth test fails.
     *
     * @return
     *         The action taken when the stencil test passes
     *         but the depth test fails.
     */
    public StencilAction getDepthFailureAction()
    {
        return depthFailureAction;
    }


    /**
     * Set an action taken when the stencil test passes but
     * the depth test fails.
     *
     * @param action
     *         An action taken when the stencil test passes
     *         but the depth test fails.
     *         If null is given, {@link StencilAction#KEEP}
     *         is set.
     *
     * @return
     *         This StencilActionSet object.
     */
    public StencilActionSet setDepthFailureAction(StencilAction action)
    {
        if (action == null)
        {
            action = StencilAction.KEEP;
        }

        depthFailureAction = action;

        return this;
    }


    /**
     * Get the action taken when both the stencil test and
     * the depth test pass.
     *
     * @return
     *         The action taken when both the stencil test
     *         and the depth test pass.
     */
    public StencilAction getPassAction()
    {
        return passAction;
    }


    /**
     * Set an action taken when both the stencil test and
     * the depth test pass.
     *
     * @param action
     *         An action taken when both the stencil test
     *         and the depth test pass.
     *         If null is given, {@link StencilAction#KEEP}
     *         is set.
     *
     * @return
     *         This StencilActionSet object.
     */
    public StencilActionSet setPassAction(StencilAction action)
    {
        if (action == null)
        {
            action = StencilAction.KEEP;
        }

        passAction = action;

        return this;
    }
}
