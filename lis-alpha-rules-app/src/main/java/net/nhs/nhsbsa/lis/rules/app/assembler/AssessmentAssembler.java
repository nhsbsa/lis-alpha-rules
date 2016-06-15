package net.nhs.nhsbsa.lis.rules.app.assembler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

//@Component
public class AssessmentAssembler extends AbstractAssembler<AssessmentModel, Assessment> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentAssembler.class);
	
//	@Override
	public void map(AssessmentModel source, Assessment destination) {
		
	}

}
