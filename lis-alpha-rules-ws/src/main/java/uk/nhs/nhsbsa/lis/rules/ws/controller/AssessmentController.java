package uk.nhs.nhsbsa.lis.rules.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.nhs.nhsbsa.lis.rules.v1.IAssessmentWebService;
import uk.nhs.nhsbsa.lis.rules.v1.builder.LisApplicationBuilder;
import uk.nhs.nhsbsa.rules.model.rules.Assessment;

@Controller
@RequestMapping("/assessments")
public class AssessmentController implements IAssessmentWebService {

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody Assessment get(@PathVariable String id) {
    	
    	//TODO pad out a blank assessment with all the required fields.
    	LisApplicationBuilder builder = new LisApplicationBuilder();
    	builder.withAddress(); 
    	return new Assessment(id, builder.getInstance());
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public @ResponseBody Assessment put(@PathVariable String id, @RequestBody Assessment assessment) {
    	
    	return assessment;
    }

}
