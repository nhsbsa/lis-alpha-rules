package net.nhs.nhsbsa.lis.rules.app.controller;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.nhs.nhsbsa.lis.rules.app.model.Entitlement;

@Controller
@RequestMapping(path="/entitlement")
public class EntitlementController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EntitlementController.class);

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(path="/{uuid}", method=RequestMethod.GET)
    public ModelAndView get(@PathVariable("uuid") String uuid) {
        
        //setup MV and render
        ModelAndView result = new ModelAndView("entitlement");
        Entitlement e = getEntitlement(uuid);
        if (e != null) {
            result.getModel().put("entitlement", e);
        }
        return result;
	}

    private Entitlement getEntitlement(String uuid) {
        
        try {
            String json = new String(Base64.getDecoder().decode(uuid));
            return mapper.readValue(json, Entitlement.class);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.warn("Unable to locate cert: {}", uuid);
            return null;
        }
    }

}
