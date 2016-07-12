package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;

public class HasPartner {

    Person applicant;
    
    Person partner;
    
    public HasPartner(Person applicant, Person partner) {
        super();
        this.applicant = applicant;
        this.partner = partner;
    }

    @Override
    public String toString() {
        return MessageFormatter.arrayFormat("Applicant {} has partner {}", new Object[]{
                applicant, partner
        }).getMessage();
    }
}
