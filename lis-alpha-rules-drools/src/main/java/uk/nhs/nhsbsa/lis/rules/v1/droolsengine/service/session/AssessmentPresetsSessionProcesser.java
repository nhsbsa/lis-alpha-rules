package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import java.util.ArrayList;

import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.flow.Requirement;
import uk.nhs.nhsbsa.lis.rules.v1.model.outcome.AssessmentBreakdown;
import uk.nhs.nhsbsa.lis.rules.v1.model.outcome.AssessmentSummary;

public class AssessmentPresetsSessionProcesser extends DefaultSessionProcessor {

	@Override
	public void preProcess(KieSession session, Assessment assessment) {
		
		//requirements
		Requirement req = new Requirement();
		req.include("application");
		assessment.setRequirements(req);
		
		//breakdown
		AssessmentBreakdown breakdown = new AssessmentBreakdown();
		if (assessment.getApplication() != null) {
			breakdown.setClaimDate(assessment.getApplication().getClaimDate());
		}
		assessment.setBreakdown(breakdown);
		session.insert(breakdown);
		
		//rules
		assessment.setRules(new ArrayList<>());
		
		//working data
		assessment.setWorkingData(new ArrayList<>());
		
		//summary
		AssessmentSummary summary = new AssessmentSummary();
		assessment.setSummary(summary);
		session.insert(summary);
	}

}
