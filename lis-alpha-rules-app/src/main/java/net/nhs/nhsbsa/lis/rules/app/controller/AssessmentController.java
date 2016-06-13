package net.nhs.nhsbsa.lis.rules.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.nhs.nhsbsa.lis.rules.app.MvcUtils;
import net.nhs.nhsbsa.lis.rules.app.assembler.IAssembler;
import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import net.nhs.nhsbsa.lis.rules.app.repository.IAssessmentRespository;
import uk.nhs.nhsbsa.rules.types.Field;

@Controller
@RequestMapping(path="/assessments")
public class AssessmentController { 

	@Autowired
	private IAssessmentRespository assessmentRespository;
	
	@Autowired
	IAssembler<AssessmentModel, AssessmentModel> assembler;
	
    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") String id) {

		AssessmentModel assessment = assessmentRespository.findOne(id);
		
		//create a dummy assessment and redirect back to its ID
		if (assessment == null) {
			assessment = create();
			assessment = assessmentRespository.save(assessment);
			return new ModelAndView(
					MvcUtils.redirect("/assessments/{}", assessment.getId()));
		}
    	
		//setup MV and render
    	ModelAndView result = new ModelAndView("assessment");
    	result.addObject("id", id);
        result.getModel().put("assessment", assessment);
        return result;
    }

    private AssessmentModel create() {
    	AssessmentModel result = new AssessmentModel();
        List<Field<?>> fields = Arrays.asList(
        		new Field<String>("forename", "Bob"),
        		new Field<String>("surname", "Builder")
        		);
        result.setFields(fields);
        return result;
	}

	@RequestMapping(path="/{id}", method=RequestMethod.POST)
    public String update(@PathVariable("id") String id, 
    		final AssessmentModel model,
    		final BindingResult bindingResult) {
		
		AssessmentModel persisted = assessmentRespository.findOne(id);
		assembler.map(model, persisted);
		assessmentRespository.save(persisted);
		return MvcUtils.redirect("/assessments/{}", persisted.getId());
    }

}
