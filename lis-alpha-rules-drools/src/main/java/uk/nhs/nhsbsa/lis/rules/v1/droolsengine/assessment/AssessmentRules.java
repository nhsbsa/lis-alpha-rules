package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.assessment;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.AssessmentCalculation;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;

/**
 * RulesCheck Class
 * Runs a drools set of rules file handed objects 
 * @author lorob
 *
 */
public class AssessmentRules {
	
	private KieSession kSession;
	private KieSession premiumKSession;
	private KieSession assessmentKSession;
	private AssessmentCalculation assessmentCalc;
	private Logger logger=Logger.getLogger("uk.nhs.nhsbsa.lis.rules.v1.droolsengine.RulesCheck");
	
	public AssessmentRules(){
		createRulesSession();
	}
	
	private void createRulesSession(){
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
	    logger.log(Level.INFO,ks.toString());
    	kSession = kContainer.newKieSession("ksession-rules");
    	premiumKSession = kContainer.newKieSession( "ksession-premiumtables" );
    	assessmentKSession = kContainer.newKieSession( "ksession-assessment" );
	}
	
	/**
	 * Runs rules against the handed application and returns the Assessment Calculation
	 * @param application
	 * @return
	 */
	public AssessmentCalculation runApplicationRules(LisApplication application){
		if(kSession!=null){
			assessmentCalc= new AssessmentCalculation();
			assessmentCalc.setClaimDate(application.getClaimDate());
			kSession.insert(assessmentCalc);
			kSession.insert(application);
			kSession.fireAllRules();
			// work out premiums
			premiumKSession.insert(assessmentCalc);
			premiumKSession.fireAllRules();
			
			// now do assessment
			assessmentKSession.insert(assessmentCalc);
			assessmentKSession.insert(application);
			assessmentKSession.fireAllRules();
			return assessmentCalc; 
		}
		else{
			logger.log(Level.INFO, "runApplicationRules(null) called");
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
	
	/**
	 * The premiums should be look up information which does not really need resetting
	 */
	public void clearPreiums(){
		premiumKSession.getAgenda().clear();
	}
}
