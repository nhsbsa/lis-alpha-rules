package net.nhs.nhsbsa.lis.rules.app.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.nhs.nhsbsa.lis.rules.app.MvcUtils;
import net.nhs.nhsbsa.lis.rules.app.propertyeditors.LocalDatePropertyEditor;
import net.nhs.nhsbsa.lis.rules.app.repository.IAssessmentRespository;
import net.nhs.nhsbsa.lis.rules.app.service.IAssessmentService;
import uk.nhs.nhsbsa.rules.model.rules.Assessment;

@Controller
@RequestMapping(path="/assessments")
public class AssessmentController { 

	@Autowired
	private IAssessmentService assessmentService;
	
	@Autowired
	private IAssessmentRespository assessmentRespository;
	
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
		Assessment result = assessmentService.create();
        return MvcUtils.redirect("/assessments/{}", result.getId());
	}

    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") String id) {

		Assessment assessment = assessmentRespository.findOne(id);
		if (assessment == null) {
			return new ModelAndView(create());
		}
    	
		//setup MV and render
    	ModelAndView result = new ModelAndView("assessment");
    	result.addObject("id", id);
        result.getModel().put("assessment", assessment);
        return result;
    }

	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
    public String update(@PathVariable("id") String id, 
    		final Assessment model,
    		final BindingResult bindingResult) {
		
		Assessment persisted = assessmentService.update(id, model);
		return MvcUtils.redirect("/assessments/{}", persisted.getId());
    }

	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id) {
		
		assessmentService.delete(id);
		return MvcUtils.redirect("/assessments");
    }

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, new LocalDatePropertyEditor());
	}
}
