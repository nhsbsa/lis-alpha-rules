package net.nhs.nhsbsa.lis.rules.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.nhs.nhsbsa.lis.rules.app.MvcUtils;
import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import net.nhs.nhsbsa.lis.rules.app.service.IAssessmentService;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

@Controller
@RequestMapping(path="/assessments")
public class AssessmentController { 

	@Autowired
	private IAssessmentService assessmentService;
	
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView list() {
    	
		Iterable<Assessment> assessments = assessmentService.list();
		
		//setup MV and render
    	ModelAndView result = new ModelAndView("assessments");
        result.getModel().put("assessments", assessments);
        return result;
    }

	@RequestMapping(method=RequestMethod.POST)
    private String create() {
		AssessmentModel result = assessmentService.create();
        return MvcUtils.redirect("assessments/{}", result.getId());
	}

    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") String id) {

		AssessmentModel assessment = assessmentService.get(id);
    	
		//setup MV and render
    	ModelAndView result = new ModelAndView("assessment");
    	result.addObject("id", id);
        result.getModel().put("assessment", assessment);
        return result;
    }

	@RequestMapping(path="/{id}", method=RequestMethod.POST)
    public String update(@PathVariable("id") String id, 
    		final AssessmentModel model,
    		final BindingResult bindingResult) {
		
		AssessmentModel persisted = assessmentService.update(id, model);
		return MvcUtils.redirect("/assessments/{}", persisted.getId());
    }

}
