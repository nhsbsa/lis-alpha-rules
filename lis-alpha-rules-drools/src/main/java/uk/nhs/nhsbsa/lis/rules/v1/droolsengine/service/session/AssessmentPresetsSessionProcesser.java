package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import java.util.ArrayList;

import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.flow.Requirement;
import uk.nhs.nhsbsa.lis.rules.v1.model.outcome.AssessmentBreakdown;
import uk.nhs.nhsbsa.lis.rules.v1.model.outcome.Breakdown;

public class AssessmentPresetsSessionProcesser extends DefaultSessionProcessor {

	@Override
	public void preProcess(KieSession session, Assessment assessment) {
		
		//requirements
		Requirement req = new Requirement();
		req.include("application");
		assessment.setRequirements(req);
		
		//breakdown
		AssessmentBreakdown assessmentBreakdown = new AssessmentBreakdown();
		if (assessment.getApplication() != null) {
			assessmentBreakdown.setClaimDate(assessment.getApplication().getClaimDate());
		}
		assessment.setBreakdown(assessmentBreakdown);
		session.insert(assessmentBreakdown);
		
		//breakdown TODO remove old breakdown after refactor
		Breakdown breakdown = new Breakdown();
		assessment.setBreakdown2(breakdown);
		session.insert(breakdown);
		
		//rules
		assessment.setRules(new ArrayList<>());
		
		//working data
		assessment.setWorkingData(new ArrayList<>());
		
	}

}
