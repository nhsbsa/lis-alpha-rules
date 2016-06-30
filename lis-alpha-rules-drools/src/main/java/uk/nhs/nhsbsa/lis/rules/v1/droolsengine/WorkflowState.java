package uk.nhs.nhsbsa.lis.rules.v1.droolsengine;

import java.util.ArrayList;
import java.util.List;

/**
 * Container class to hold where we are on the form for save \ restore from a
 * section perspective - TODO Needs more thought
 * 
 * @author lorob
 *
 */
public class WorkflowState {
	// Rules
	private List<String> ruleList; // holds a string based list of rules used in the calculation
	private WorkflowErrorList errorList; // any errors during workflow (i.e. missing entries)
	
	public WorkflowState(){
		ruleList=new ArrayList<String>();
		errorList = new WorkflowErrorList();
	}

	public List<String> getRuleList() {
		return ruleList;
	}

	public void setRuleList(List<String> ruleList) {
		this.ruleList = ruleList;
	}
	
	

	public WorkflowErrorList getErrorList() {
		return errorList;
	}

	public void setErrorList(WorkflowErrorList errorList) {
		this.errorList = errorList;
	}

	@Override
	public String toString() {
		return "WorkflowState [ruleList=" + ruleList + "]";
	}
	
	
		
}
