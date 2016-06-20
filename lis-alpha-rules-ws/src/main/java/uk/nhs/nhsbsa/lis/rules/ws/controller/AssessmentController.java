package uk.nhs.nhsbsa.lis.rules.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.nhs.nhsbsa.lis.rules.v1.IAssessmentWebService;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;
import uk.nhs.nhsbsa.lis.rules.ws.service.IAssessmentRulesService;
import uk.nhs.nhsbsa.rules.model.rules.Assessment;

@Controller
@RequestMapping("/assessments")
public class AssessmentController implements IAssessmentWebService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentController.class);
	
	@Autowired
	IAssessmentRulesService assessmentRulesService;
	
	@Override
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Assessment post(LisApplication application) {

    	LOGGER.info("POST /assessments");
		return assess(new Assessment(null, null));
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody Assessment get(@PathVariable String id) {
    	
    	LOGGER.info("GET /assessments/{}", id);
		return assess(new Assessment(id, null));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public @ResponseBody Assessment put(@PathVariable String id, @RequestBody Assessment assessment) {
    	
    	LOGGER.info("PUT /assessments/{}", id);
    	return assess(assessment);
    }

    /**
     * Call into rules to coordinate rules.
     * @param assessment
     * @return
     */
    private Assessment assess(Assessment assessment) {
		return assessmentRulesService.assess(assessment);
	}

}
