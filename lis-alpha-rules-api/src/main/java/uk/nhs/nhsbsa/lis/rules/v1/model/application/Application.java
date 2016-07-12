package uk.nhs.nhsbsa.lis.rules.v1.model.application;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/**
 * The root class for a rules based LIS assessment.
 */
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    
    /**
     * Assessment is based on claim date. This is the date the claim arrived in
     * the post or the initial date the claim is created. If claim is save \
     * restored do we use the initial date or the save date?
     */
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate claimDate = LocalDate.now();

    /**
     * Processing date. The date the claim is processed by the operative or the
     * rules engine
     */
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate processingDate;

    /**
     * Address.
     */
    private Address address;

    /**
     * Contact Details
     * 
     */
    private ContactDetails contactDetails;

    /**
     * Main applicant.
     */
    private Person applicant;

    /**
     * Has applicant got a partner.
     */
    private boolean hasPartner;

    /**
     * Partner
     */
    private Person partner;

    /**
     * Dependants
     */
    private List<Person> dependants;

    /**
     * Non-Dependants
     */
    private List<Person> nonDependants;

    /**
     * Part 4 Savings
     */
    private List<Saving> Savings;

    public List<Saving> getSavings() {
        return Savings;
    }

    public void setSavings(List<Saving> savings) {
        Savings = savings;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public LocalDate getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(LocalDate processingDate) {
        this.processingDate = processingDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person getApplicant() {
        return applicant;
    }

    public void setApplicant(Person applicant) {
        this.applicant = applicant;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public List<Person> getDependants() {
        return dependants;
    }

    public void setDependants(List<Person> dependants) {
        this.dependants = dependants;
    }

    public List<Person> getNonDependants() {
        return nonDependants;
    }

    public void setNonDependants(List<Person> nonDependants) {
        this.nonDependants = nonDependants;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Application(").append(claimDate).append(")");
        return sb.toString();
    }

    public boolean getHasPartner() {
        return hasPartner;
    }

    public void setHasPartner(boolean hasPartner) {
        this.hasPartner = hasPartner;
    }

    public boolean claimWithinDateRange(String from, String to) {
	    boolean result = false;
	    if (claimDate != null) {
            LocalDate fromDate = LocalDate.parse(from);
            LocalDate toDate = LocalDate.parse(to);
            if (claimDate.equals(fromDate)) {
                result = true;
            } else if (claimDate.isBefore(toDate) && claimDate.isAfter(fromDate)) {
                result = true;
            }
	    } else {
            LOGGER.warn("Trying to compare a claim date to null internal date");
            result = "9999-12-31".equals(to);
	    }
	    return result;
	}
}
