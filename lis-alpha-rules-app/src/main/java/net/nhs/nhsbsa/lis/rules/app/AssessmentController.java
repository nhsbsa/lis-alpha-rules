package net.nhs.nhsbsa.lis.rules.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.nhs.nhsbsa.lis.rules.v1.builder.AssessmentBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

@Controller
@RequestMapping(path="/assessment")
public class AssessmentController {

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView getGreeting() {
        Assessment assessment = new AssessmentBuilder("123").getInstance();
        return new ModelAndView("assessment", "assessment", assessment);
    }

}
