package net.nhs.nhsbsa.lis.rules.app.assembler;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

@Component
public class AssessmentToAssessmentAssembler extends AbstractAssembler<Assessment, Assessment> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentToAssessmentAssembler.class);
	
	@Autowired
	DozerBeanMapper dozer;
	
	@Override
	public void map(Assessment source, Assessment destination) {

		dozer.map(source, destination);
	}

	public void setDozer(DozerBeanMapper dozer) {
		this.dozer = dozer;
	}
}
