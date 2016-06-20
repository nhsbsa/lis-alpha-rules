package uk.nhs.nhsbsa.rules.model.rules;

import java.util.List;

import org.springframework.data.annotation.Id;

import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;

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
	
	private List<Requirement> requirements;

	
	public Assessment() {
	}
	
	public Assessment(String id, LisApplication application) {
		this.application = application;
	}

	public List<Requirement> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<Requirement> requirements) {
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
}
