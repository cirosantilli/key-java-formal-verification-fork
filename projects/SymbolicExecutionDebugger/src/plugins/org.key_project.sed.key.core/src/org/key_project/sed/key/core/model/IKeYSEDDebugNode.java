/*******************************************************************************
 * Copyright (c) 2014 Karlsruhe Institute of Technology, Germany
 *                    Technical University Darmstadt, Germany
 *                    Chalmers University of Technology, Sweden
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Technical University Darmstadt - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.key_project.sed.key.core.model;

import org.eclipse.debug.core.DebugException;
import org.key_project.sed.core.model.ISEDDebugNode;

import de.uka.ilkd.key.symbolic_execution.model.IExecutionNode;

/**
 * Provides methods each {@link ISEDDebugNode} of the symbolic execution debugger (SED)
 * based on KeY must have.
 * @author Martin Hentschel
 */
public interface IKeYSEDDebugNode<E extends IExecutionNode<?>> extends ISEDDebugNode {
   /**
    * Returns the represented {@link IExecutionNode}.
    * @return The reprsented {@link IExecutionNode}.
    */
   public E getExecutionNode();
   
   /**
    * {@inheritDoc}
    */
   @Override
   public KeYDebugTarget getDebugTarget();
   
   /**
    * {@inheritDoc}
    */
   @Override
   public KeYThread getThread();
   
   /**
    * {@inheritDoc}
    */
   @Override
   public IKeYSEDDebugNode<?> getParent() throws DebugException;
   
   /**
    * {@inheritDoc}
    */
   @Override
   public IKeYSEDDebugNode<?>[] getChildren() throws DebugException;
   
   /**
    * {@inheritDoc}
    */
   @Override
   public KeYConstraint[] getConstraints() throws DebugException;

   /**
    * It is valid to set the parent as long it was not defined before.
    * So a parent might be set lazily later but can never be changed.
    * @param parent The new parent to set.
    */
   public void setParent(ISEDDebugNode parent);
   
   /**
    * Checks if truth value evaluation is enabled or not.
    * @return {@code true} enabled, {@code false} disabled.
    */
   public boolean isTruthValueEvaluationEnabled();
}