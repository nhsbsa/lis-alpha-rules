package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.AssessmentCalculation;
import uk.nhs.nhsbsa.lis.rules.v1.model.Requirement;

public class AssessmentPresetsSessionProcesser extends DefaultSessionProcessor {

	@Override
	public void preProcess(KieSession session, Assessment assessment) {
		
		Requirement req = new Requirement();
		req.include("application");
		assessment.setRequirements(req);
		
		AssessmentCalculation calc = new AssessmentCalculation();
		calc.setClaimDate(assessment.getApplication().getClaimDate());
		assessment.setCalculation(calc);
		session.insert(calc);
	}

}
