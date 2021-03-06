// This file is part of KeY - Integrated Deductive Software Design
//
// Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
//                         Universitaet Koblenz-Landau, Germany
//                         Chalmers University of Technology, Sweden
// Copyright (C) 2011-2014 Karlsruhe Institute of Technology, Germany
//                         Technical University Darmstadt, Germany
//                         Chalmers University of Technology, Sweden
//
// The KeY system is protected by the GNU General
// Public License. See LICENSE.TXT for details.
//

package de.uka.ilkd.key.gui.lemmatagenerator;

import java.io.File;
import java.util.Collections;

import de.uka.ilkd.key.proof.init.Profile;
import de.uka.ilkd.key.proof.init.ProofInputException;
import de.uka.ilkd.key.proof.io.AbstractEnvInput;

public class EmptyEnvInput extends AbstractEnvInput  {

    public EmptyEnvInput(Profile profile) {
        super("empty dummy environment", null, Collections.<File>emptyList(), null, profile);
    }

    @Override
    public void read() throws ProofInputException {
        // nothing to to do
    }

    @Override
    public File getInitialFile() {
        // no file availbale. may return null
        return null;
    }

}