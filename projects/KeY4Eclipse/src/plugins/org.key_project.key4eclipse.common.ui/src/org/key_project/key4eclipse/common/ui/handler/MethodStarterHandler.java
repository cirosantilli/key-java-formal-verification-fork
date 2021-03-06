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

package org.key_project.key4eclipse.common.ui.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.internal.ui.actions.SelectionConverter;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.key_project.key4eclipse.common.ui.util.StarterUtil;

/**
 * Handler to start a proof for selected {@link IMethod}s via {@link StarterUtil#openMethodStarter(Shell, IMethod)}.
 */
@SuppressWarnings("restriction")
public class MethodStarterHandler extends AbstractSaveExecutionHandler {
   /**
    * {@inheritDoc}
    */
   @Override
   protected Object doExecute(ExecutionEvent event) throws Exception {
      Shell parentShell = HandlerUtil.getActiveShell(event);
      ISelection selection = HandlerUtil.getCurrentSelection(event);
      if (selection instanceof IStructuredSelection) {
         Object[] elements = ((IStructuredSelection) selection).toArray();
         for (Object element : elements) {
            if (element instanceof IMethod) {
               StarterUtil.openMethodStarter(parentShell, (IMethod) element);
            }
         }
      }
      else if (selection instanceof ITextSelection) {
         ITextSelection textSelection = (ITextSelection) selection;
         IEditorPart editor = HandlerUtil.getActiveEditor(event);
         if (editor instanceof JavaEditor) {
            JavaEditor javaEditor = (JavaEditor) editor;
            IJavaElement element = SelectionConverter.resolveEnclosingElement(javaEditor, textSelection);
            if (element instanceof IMethod) {
               StarterUtil.openMethodStarter(parentShell, (IMethod) element);
            }
         }
      }
      return null;
   }
}