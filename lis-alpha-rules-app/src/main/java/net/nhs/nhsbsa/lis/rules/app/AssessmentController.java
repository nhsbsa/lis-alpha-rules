package net.nhs.nhsbsa.lis.rules.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.nhs.nhsbsa.lis.rules.v1.builder.AssessmentBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.rules.types.Field;

@Controller
@RequestMapping(path="/assessment")
public class AssessmentController { 

    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public ModelAndView getGreeting(@PathVariable("id") String id) {

    	AssessmentBuilder builder = new AssessmentBuilder(id);
		builder.withAddress()
			.withPostcode("BB1 1BB");
		builder.withApplicant()
			.withName()
				.withTitle("Mr")
				.withSurname("Builder")
				.withForenames("Bob")
				;
        		
        Assessment assessment = (Assessment) builder.getInstance();
        ModelAndView result = new ModelAndView("assessment", "assessment", assessment);
        List<Field<?>> it = Arrays.asList(assessment.getAddress(), assessment.getApplicant());
        result.getModel().put("it", it);
        return result;
    }

    @RequestMapping(path="/{id}", method=RequestMethod.PUT)
    public ModelAndView putGreeting(@PathVariable("id") String id) {
        Assessment assessment = new AssessmentBuilder("123").getInstance();
        return new ModelAndView("assessment", "assessment", assessment);
    }

}
