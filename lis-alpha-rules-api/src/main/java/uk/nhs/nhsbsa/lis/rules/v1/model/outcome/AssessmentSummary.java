package uk.nhs.nhsbsa.lis.rules.v1.model.outcome;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public class AssessmentSummary {

	private IntervalValue resources;
	
	private IntervalValue requirements;

	public IntervalValue getResources() {
		return resources;
	}

	public IntervalValue getRequirements() {
		return requirements;
	}

	public void setRequirements(IntervalValue requirements) {
		this.requirements = requirements;
	}
	
	public void addResources(IntervalValue resources) {
		this.resources = resources.add(this.resources);
	}

	public void addRequirements(IntervalValue requirements) {
		this.requirements = requirements.add(this.requirements);
	} 

}
