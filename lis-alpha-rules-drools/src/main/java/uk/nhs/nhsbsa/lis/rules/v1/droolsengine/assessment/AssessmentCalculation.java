package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.assessment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import java.util.logging.Level;
import uk.nhs.nhsbsa.lis.rules.v1.model.ClientGroup;

/**
 * Class to hold the values used in the assessment calculation
 * This is based on the HC3 form
 * @author lorob
 *
 */
public class AssessmentCalculation {
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
	private Double carerPreium;
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
	private LocalDateTime claimDate;
	private LocalTime zeroHour=LocalTime.parse("00:00");
	
	// TODO Other factors used in calculation - not sure if this should be here or elsewhere
	private Boolean hasPartner;
	private Integer mainClaimantAge;
	private Integer parterAge;
	
	// Rules
	private List<String> ruleList; // holds a string based list of rules used in the calculation
	
	private Logger logger=Logger.getLogger("uk.nhs.nhsbsa.lis.rules.v1.droolsengine.assessment.AssessmentCalculation");
	
	/**
	 * Constructor
	 */
	public AssessmentCalculation(){
		incomeCapitals=new ArrayList<IncomeCapital>();
		clientGroups=new ArrayList<ClientGroup>();
		ruleList=new ArrayList<String>();
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

	public Double getCarerPreium() {
		return carerPreium;
	}

	public void setCarerPreium(Double carerPreium) {
		this.carerPreium = carerPreium;
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

	public Integer getMainClaimantAge() {
		return mainClaimantAge;
	}

	public void setMainClaimantAge(Integer mainClaimantAge) {
		this.mainClaimantAge = mainClaimantAge;
	}

	public Integer getParterAge() {
		return parterAge;
	}

	public void setParterAge(Integer parterAge) {
		this.parterAge = parterAge;
	}

	public List<String> getRuleList() {
		return ruleList;
	}

	public void setRuleList(List<String> ruleList) {
		this.ruleList = ruleList;
	}

	public Boolean getHasPartner() {
		return hasPartner;
	}

	public void setHasPartner(Boolean hasPartner) {
		this.hasPartner = hasPartner;
	}
	
	public LocalDateTime getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDateTime claimDate) {
		this.claimDate = claimDate;
	}
	
	public Double getTotalHousing() {
		return totalHousing;
	}

	public void setTotalHousing(Double totalHousing) {
		this.totalHousing = totalHousing;
	}


	
	
	@Override
	public String toString() {
		return "AssessmentCalculation [runningTotal=" + runningTotal + ", runningPremiums=" + runningPremiums
				+ ", runningIncome=" + runningIncome + ", totalHousing=" + totalHousing + ", personalAllowance="
				+ personalAllowance + ", dependantsAllowance=" + dependantsAllowance + ", disabledChildPremium="
				+ disabledChildPremium + ", clientGroupPremium=" + clientGroupPremium + ", enhancedDisabilityPremium="
				+ enhancedDisabilityPremium + ", familyPremium=" + familyPremium + ", severeDisabilityPremium="
				+ severeDisabilityPremium + ", carerPreium=" + carerPreium + ", councilTax=" + councilTax
				+ ", mortgage=" + mortgage + ", rent=" + rent + ", groundRent=" + groundRent + ", otherCosts="
				+ otherCosts + ", nonDependantDeductions=" + nonDependantDeductions + ", incomeCapitals="
				+ incomeCapitals + ", clientGroups=" + clientGroups + ", claimDate=" + claimDate + ", zeroHour="
				+ zeroHour + ", hasPartner=" + hasPartner + ", mainClaimantAge=" + mainClaimantAge + ", parterAge="
				+ parterAge + ", ruleList=" + ruleList + ", logger=" + logger + "]";
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
				logger.log(Level.WARNING, "Trying to compare a claim date to null internal date");
				throw new Exception("Trying to compare a claim date to null internal date");
			}
			LocalDate fromDate =LocalDate.parse(lookupFromDate);
			LocalDate toDate =LocalDate.parse(lookupToDate);
			LocalDateTime fromDateTime =LocalDateTime.of(fromDate,zeroHour);
			LocalDateTime toDateTime =LocalDateTime.of(toDate,zeroHour);
			if(claimDate.equals(fromDateTime)){
				return true;
			}
			if(claimDate.isBefore(toDateTime)&&claimDate.isAfter(fromDateTime)){
				logger.log(Level.INFO,"FOUND DATE="+lookupFromDate);
				return true;
			}
			return false;
		}
		catch(Exception e){
			logger.log(Level.WARNING,"Unable to process dates : "+lookupFromDate+" : " + lookupToDate);
			throw e;
		}
	}

	
}
