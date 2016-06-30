package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.workflow;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.WorkflowErrorList;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.WorkflowState;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;

/**
 * Class to perform navigation rules check.
 * @author lorob
 *
 */
public class NavigationRules {
	private KieSession kSession;
	private Logger logger=Logger.getLogger("uk.nhs.nhsbsa.lis.rules.v1.droolsengine.NavigationCheck");
	
	public NavigationRules(){
		createRulesSession();
	}
	
	private void createRulesSession(){
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
    	kSession = kContainer.newKieSession("ksession-workflow");
	}
	
	/**
	 * Runs rules against the handed application and returns the workflow
	 * to be used in working out where in flow user is during save \ restore
	 * @param application
	 * @return
	 */
	public WorkflowState runWorkflowRules(LisApplication application){
		if(kSession!=null){
			// Create an object to house the calculation
			WorkflowState workflowState=new WorkflowState();
			kSession.insert(workflowState);
			kSession.insert(application);
			kSession.fireAllRules();
			return workflowState;
		}
		else{
			logger.log(Level.INFO, "runWorkflowRules(null) called");
			return null;
		}
	}
	
	public void clearRules(){
		 kSession.getAgenda().clear();
	}
}
