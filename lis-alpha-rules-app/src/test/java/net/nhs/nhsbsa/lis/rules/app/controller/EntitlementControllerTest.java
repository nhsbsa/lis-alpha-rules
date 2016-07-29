package net.nhs.nhsbsa.lis.rules.app.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Base64;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.nhs.nhsbsa.lis.rules.app.model.Entitlement;

public class EntitlementControllerTest {

    EntitlementController controller = new EntitlementController();
    ObjectMapper mapper = new ObjectMapper();
    
    @Test
    public void testBadCert() {

        ModelAndView actual = controller.get("bad-request");
        
        assertNull(getEntitlement(actual));
    }

    @Test
    public void testGoodCert() {

        
        String uuid = encodeEntitlement("123 456 789", "2015-07-14", "2016-08-14");
        ModelAndView actual = controller.get(uuid);
        
        Entitlement e = getEntitlement(actual);
        assertNotNull(e);
        assertEquals("123 456 789", e.getCert());
    }

    private String encodeEntitlement(String cert, String from, String until) {
        return encodeEntitlement(cert, LocalDate.parse(from), LocalDate.parse(until));
    }
    private String encodeEntitlement(String cert, LocalDate from, LocalDate until) {

        try {
            Entitlement e = new Entitlement(cert, from, until);
            String json = mapper.writeValueAsString(e);
            String base64 = Base64.getEncoder().encodeToString(json.getBytes());
            System.out.println(URLEncoder.encode(base64));
            return base64;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Entitlement getEntitlement(ModelAndView model) {

        return (Entitlement)model.getModel().get("entitlement");
    }

}
