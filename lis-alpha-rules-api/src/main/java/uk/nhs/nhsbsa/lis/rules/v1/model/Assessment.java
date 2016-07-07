package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * An assessment of an application.
 * This object contains all the requirements, validations, calculated fields and outcome of the assessment.
 * @param <T>
 */
public class Assessment {

	/**
	 * ID for this assessment.
	 */
	@Id
	private String id;

	/**
	 * The application being assessed.
	 */
	private LisApplication application;
	
	private Requirement requirements;

	private AssessmentBreakdown breakdown;
	
	private List<Object> workingData;
	
	public Assessment() {
		requirements = new Requirement();
		requirements.include("application");
	}
	
	public Assessment(String id, LisApplication application) {
		this();
		this.application = application;
	}

	public Requirement getRequirements() {
		return requirements;
	}

	public void setRequirements(Requirement requirements) {
		this.requirements = requirements;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LisApplication getApplication() {
		return application;
	}

	public void setApplication(LisApplication application) {
		this.application = application;
	}

	public AssessmentBreakdown getBreakdown() {
		return breakdown;
	}

	public void setBreakdown(AssessmentBreakdown calculation) {
		this.breakdown = calculation;
	}

	public List<Object> getWorkingData() {
		return workingData;
	}

	public void setWorkingData(List<Object> facts) {
		this.workingData = facts;
	}
}
