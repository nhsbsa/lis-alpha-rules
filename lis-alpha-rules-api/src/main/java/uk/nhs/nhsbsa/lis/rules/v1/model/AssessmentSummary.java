package uk.nhs.nhsbsa.lis.rules.v1.model;

public class AssessmentSummary {

	private IntervalValue resources;
	
	private IntervalValue requirements;

	public IntervalValue getResources() {
		return resources;
	}

	public void addResources(IntervalValue resources) {
		this.resources = resources.add(this.resources);
	}

	public IntervalValue getRequirements() {
		return requirements;
	}

	public void setRequirements(IntervalValue requirements) {
		this.requirements = requirements;
	}
	
}
