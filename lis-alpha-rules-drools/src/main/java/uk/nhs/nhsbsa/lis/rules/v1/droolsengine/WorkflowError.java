package uk.nhs.nhsbsa.lis.rules.v1.droolsengine;


/**
 * Class to hold error information.
 * The field in error, the rule that triggered
 * and an error message.
 * @author lorob
 *
 */
public class WorkflowError {
	private String field;
	private String errorRule;
	private String errorMessage;
	
	public WorkflowError(String field,String errorRule,String errorMessage){
		this.field=field;
		this.errorRule=errorRule;
		this.errorMessage=errorMessage;
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getErrorRule() {
		return errorRule;
	}
	public void setErrorRule(String errorRule) {
		this.errorRule = errorRule;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "WorkflowError [field=" + field + ", errorRule=" + errorRule + ", errorMessage="
				+ errorMessage + "]";
	}
	
	
}
