package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to hold the values used in the assessment calculation
 * This is based on the HC3 form
 * @author lorob
 *
 */
public class AssessmentBreakdown {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentBreakdown.class);

	// HC3 Fields
	private Double runningTotal;
	private Double runningPremiums;
	private Double runningIncome;
	private Double totalHousing;
	
	
	private Double personalAllowance;
	private Double dependantsAllowance;
	private Double disabledChildPremium;
	private Double clientGroupPremium;
	private Double enhancedDisabilityPremium;
	private Double familyPremium;
	private Double severeDisabilityPremium;
	private Double carerPremium;
	private Double councilTax;
	// housing
	private Double mortgage;
	private Double rent;
	private Double groundRent;
	private Double otherCosts;
	private Double nonDependantDeductions;
	
	private List<IncomeCapital> incomeCapitals;
	private List<ClientGroup> clientGroups;
	
	/**
	 * Assessment is based on claim date. This is the date the claim
	 * arrived in the post or the initial date the claim is created.
	 * If claim is save \ restored do we use the initial date or the save date?
	 */
	private LocalDate claimDate;
	private LocalTime zeroHour=LocalTime.parse("00:00");
	
	// TODO Other factors used in calculation - not sure if this should be here or elsewhere
	private Boolean hasPartner;
	private Long mainClaimantAge;
	private Long parterAge;
	
	private Double prescriptionPrice;
	private Double upperLimitHC3Amount;
	
	/**
	 * Constructor
	 */
	public AssessmentBreakdown(){
		incomeCapitals=new ArrayList<IncomeCapital>();
		clientGroups=new ArrayList<ClientGroup>();
	}
	
	public Double getRunningTotal() {
		return runningTotal;
	}

	public void setRunningTotal(Double runningTotal) {
		this.runningTotal = runningTotal;
	}

	public Double getRunningPremiums() {
		return runningPremiums;
	}

	public void setRunningPremiums(Double runningPremiums) {
		this.runningPremiums = runningPremiums;
	}

	public Double getRunningIncome() {
		return runningIncome;
	}

	public void setRunningIncome(Double runningIncome) {
		this.runningIncome = runningIncome;
	}

	public Double getPersonalAllowance() {
		return personalAllowance;
	}

	public void setPersonalAllowance(Double personalAllowance) {
		this.personalAllowance = personalAllowance;
	}

	public Double getDependantsAllowance() {
		return dependantsAllowance;
	}

	public void setDependantsAllowance(Double dependantsAllowance) {
		this.dependantsAllowance = dependantsAllowance;
	}

	public Double getDisabledChildPremium() {
		return disabledChildPremium;
	}

	public void setDisabledChildPremium(Double disabledChildPremium) {
		this.disabledChildPremium = disabledChildPremium;
	}

	public Double getClientGroupPremium() {
		return clientGroupPremium;
	}

	public void setClientGroupPremium(Double clientGroupPremium) {
		this.clientGroupPremium = clientGroupPremium;
	}

	public Double getEnhancedDisabilityPremium() {
		return enhancedDisabilityPremium;
	}

	public void setEnhancedDisabilityPremium(Double enhancedDisabilityPremium) {
		this.enhancedDisabilityPremium = enhancedDisabilityPremium;
	}

	public Double getFamilyPremium() {
		return familyPremium;
	}

	public void setFamilyPremium(Double familyPremium) {
		this.familyPremium = familyPremium;
	}

	public Double getSevereDisabilityPremium() {
		return severeDisabilityPremium;
	}

	public void setSevereDisabilityPremium(Double severeDisabilityPremium) {
		this.severeDisabilityPremium = severeDisabilityPremium;
	}

	public Double getCarerPremium() {
		return carerPremium;
	}

	public void setCarerPremium(Double carerPreium) {
		this.carerPremium = carerPreium;
	}

	public Double getCouncilTax() {
		return councilTax;
	}

	public void setCouncilTax(Double councilTax) {
		this.councilTax = councilTax;
	}

	public Double getMortgage() {
		return mortgage;
	}

	public void setMortgage(Double mortage) {
		this.mortgage = mortage;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public Double getGroundRent() {
		return groundRent;
	}

	public void setGroundRent(Double groundRent) {
		this.groundRent = groundRent;
	}

	public Double getOtherCosts() {
		return otherCosts;
	}

	public void setOtherCosts(Double otherCosts) {
		this.otherCosts = otherCosts;
	}

	public Double getNonDependantDeductions() {
		return nonDependantDeductions;
	}

	public void setNonDependantDeductions(Double nonDependantDeductions) {
		this.nonDependantDeductions = nonDependantDeductions;
	}

	public List<IncomeCapital> getIncomeCapitals() {
		return incomeCapitals;
	}

	public void setIncomeCapitals(List<IncomeCapital> incomeCapitals) {
		this.incomeCapitals = incomeCapitals;
	}

	public List<ClientGroup> getClientGroups() {
		return clientGroups;
	}

	public void setClientGroups(List<ClientGroup> clientGroups) {
		this.clientGroups = clientGroups;
	}

	public Long getMainClaimantAge() {
		return mainClaimantAge;
	}

	public void setMainClaimantAge(Long mainClaimantAge) {
		this.mainClaimantAge = mainClaimantAge;
	}

	public Long getParterAge() {
		return parterAge;
	}

	public void setParterAge(Long parterAge) {
		this.parterAge = parterAge;
	}

	public Boolean getHasPartner() {
		return hasPartner;
	}

	public void setHasPartner(Boolean hasPartner) {
		this.hasPartner = hasPartner;
	}
	
	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}
	
	public Double getTotalHousing() {
		return totalHousing;
	}

	public void setTotalHousing(Double totalHousing) {
		this.totalHousing = totalHousing;
	}

	
	public Double getPrescriptionPrice() {
		return prescriptionPrice;
	}

	public void setPrescriptionPrice(Double prescriptionPrice) {
		this.prescriptionPrice = prescriptionPrice;
	}

	
	public Double getUpperLimitHC3Amount() {
		return upperLimitHC3Amount;
	}

	public void setUpperLimitHC3Amount(Double upperLimitHC3Amount) {
		this.upperLimitHC3Amount = upperLimitHC3Amount;
	}

	/**
	 * Compare the internal date to the handed dates.
	 * If the internal handed claim is equal to forDate or lives between the dates
	 * return true. Otherwise return false. 
	 * @param lookupFromDate
	 * @param lookupToDate
	 * @return
	 */
	public boolean compareToClaimDate(String lookupFromDate,String lookupToDate) throws Exception{
		try{
			if(claimDate==null){
				LOGGER.warn("Trying to compare a claim date to null internal date");
				throw new Exception("Trying to compare a claim date to null internal date");
			}
			LocalDate fromDate =LocalDate.parse(lookupFromDate);
			LocalDate toDate =LocalDate.parse(lookupToDate);
			if(claimDate.equals(fromDate)){
				return true;
			}
			if(claimDate.isBefore(toDate)&&claimDate.isAfter(fromDate)){
				LOGGER.info("FOUND DATE="+lookupFromDate);
				return true;
			}
			return false;
		}
		catch(Exception e){
			LOGGER.warn("Unable to process dates : {} : {}", lookupFromDate, lookupToDate);
			throw e;
		}
	}

	public boolean hasPremiums() {
		return runningPremiums != null && runningPremiums > 0;
	}

	@Override
	public String toString() {
		return "Breakdown [runningTotal=" + runningTotal + "]";
	}
	
}
