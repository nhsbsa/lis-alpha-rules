package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.assessment;


import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Application;
import uk.nhs.nhsbsa.lis.rules.v1.model.outcome.AssessmentBreakdown;

/**
 * RulesCheck Class
 * Runs a drools set of rules file handed objects 
 * @author lorob
 *
 */
public class AssessmentRules {
	
	private KieSession kSession;
	private AssessmentBreakdown assessmentCalc;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentRules.class);
	
	public AssessmentRules(){
		createRulesSession();
	}
	
	private void createRulesSession(){
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
	    LOGGER.info("{}", ks);
    	kSession = kContainer.newKieSession("rules");
	}
	
	/**
	 * Runs rules against the handed application and returns the Assessment Calculation
	 * @param application
	 * @return
	 */
	public AssessmentBreakdown runApplicationRules(Application application){
		if(kSession!=null){
			assessmentCalc= new AssessmentBreakdown();
			assessmentCalc.setClaimDate(application.getClaimDate());
			kSession.insert(assessmentCalc);
			kSession.insert(application);
			kSession.fireAllRules();
			// work out premiums
			kSession.insert(assessmentCalc);
			kSession.fireAllRules();
			
			// now do assessment
			kSession.insert(assessmentCalc);
			kSession.insert(application);
			kSession.fireAllRules();
			return assessmentCalc; 
		}
		else{
			LOGGER.info("runApplicationRules(null) called");
			return null;
		}
	}
	
	/*
	 * Clear out the rules 
	 */
	public void clearRules(){
		if (kSession != null) {
			 kSession.getAgenda().clear();
		}
	}

}
