package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Application;
import uk.nhs.nhsbsa.lis.rules.v1.model.flow.Requirement;
import uk.nhs.nhsbsa.lis.rules.v1.model.outcome.AssessmentBreakdown;
import uk.nhs.nhsbsa.lis.rules.v1.model.outcome.Breakdown;
import uk.nhs.nhsbsa.lis.rules.v1.model.outcome.Entitlement;

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
	private Application application;
	
	private Requirement requirements;

	private List<Object> workingData;

	private List<Object> rules;

	private Breakdown breakdown2;
	
	public Breakdown getBreakdown2() {
		return breakdown2;
	}

	public void setBreakdown2(Breakdown breakdown2) {
		this.breakdown2 = breakdown2;
	}

	private AssessmentBreakdown breakdown;
	
	private Entitlement entitlement;
	
	public Assessment() {
		requirements = new Requirement();
		requirements.include("application");
	}
	
	public Assessment(String id, Application application) {
		this();
		this.application = application;
	}

	public Entitlement getEntitlement() {
		return entitlement;
	}

	public void setEntitlement(Entitlement entitlement) {
		this.entitlement = entitlement;
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

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
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

	public List<Object> getRules() {
		return rules;
	}

	public void setRules(List<Object> rules) {
		this.rules = rules;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		return sb.toString();
	}
}
