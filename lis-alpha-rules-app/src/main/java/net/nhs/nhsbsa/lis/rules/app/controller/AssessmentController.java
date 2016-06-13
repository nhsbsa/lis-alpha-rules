package net.nhs.nhsbsa.lis.rules.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.nhs.nhsbsa.lis.rules.app.form.FormModel;
import net.nhs.nhsbsa.lis.rules.app.service.IAssessmentService;
import uk.nhs.nhsbsa.lis.rules.v1.builder.AssessmentBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.rules.types.Field;

@Controller
@RequestMapping(path="/assessments")
public class AssessmentController { 

	private IAssessmentService assessmentService;
	
    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public ModelAndView getGreeting(@PathVariable("id") String id) {

    	ModelAndView result = new ModelAndView("assessment");
    	result.addObject("id", id);
        result.getModel().put("model", dummyData());
//    	addAssessment(result, id);
        return result;
    }

    private FormModel dummyData() {
    	FormModel result = new FormModel();
        List<Field<?>> fields = Arrays.asList(
        		new Field<String>("forename", "Bob"),
        		new Field<String>("surname", "Builder")
        		);
        result.setFields(fields);
        return result;
	}

	private void addAssessment(ModelAndView mv, String id) {
        //TODO create iterator
    	Assessment assessment = assessmentService.getAssessment(id);
        List<Field<?>> it = Arrays.asList(
                assessment.getAddress().getValue().getPostcode(),
                assessment.getApplicant().getValue().getName().getValue().getSurname());
        mv.getModel().put("it", it);
	}

	@RequestMapping(path="/{id}", method=RequestMethod.POST)
    public ModelAndView putGreeting(@PathVariable("id") String id) {
		return getGreeting(id);
//        Assessment assessment = new AssessmentBuilder(id).getInstance();
//        return new ModelAndView("assessment", "assessment", assessment);
    }

}
