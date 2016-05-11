package uk.nhs.nhsbsa.lis.rules.ws.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.nhs.nhsbsa.lis.rules.ws.model.Rule;

@Controller
@RequestMapping("/rules")
public class RulesController {

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<Rule> list() {
        return Arrays.asList(new Rule());
    }

}
