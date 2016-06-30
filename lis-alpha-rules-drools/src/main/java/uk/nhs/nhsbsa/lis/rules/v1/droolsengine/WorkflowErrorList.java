package uk.nhs.nhsbsa.lis.rules.v1.droolsengine;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to record errors on the screen
 * The lists should be in order of the field in error, the rule that triggered
 * and an error message. The error message will need to be converted to i18n somewhere
 * @author lorob
 *
 */
public class WorkflowErrorList {
	private List<WorkflowError> errors;
	
	public WorkflowErrorList(){
		errors=new ArrayList<WorkflowError>();
	}

	public List<WorkflowError> getErrors() {
		return errors;
	}

	public void setErrors(List<WorkflowError> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "WorkflowErrorState [errors=" + errors + "]";
	}
	
}
