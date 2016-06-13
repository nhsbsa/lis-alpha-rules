package net.nhs.nhsbsa.lis.rules.app.service;

import org.springframework.stereotype.Service;

import uk.nhs.nhsbsa.lis.rules.v1.builder.AssessmentBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

@Service
public class AssessmentService implements IAssessmentService {

	/* (non-Javadoc)
	 * @see net.nhs.nhsbsa.lis.rules.app.service.IAssessmentService#getAssessment(java.lang.String)
	 */
	@Override
	public Assessment getAssessment(String id) {
		
    	AssessmentBuilder builder = new AssessmentBuilder(id);
		builder.withAddress()
			.withPostcode("BB1 1BB");
		builder.withApplicant()
			.withName()
				.withTitle("Mr")
				.withSurname("Builder")
				.withForenames("Bob")
				;
        Assessment result = (Assessment) builder.getInstance();
        return result;
	}
}
