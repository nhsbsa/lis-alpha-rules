package uk.nhs.nhsbsa.lis.rules.v1.droolsengine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.math.NumberUtils;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.BenefitType;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Income;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.IncomeType;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Interval;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Outgoing;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.OutgoingType;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.outcome.AssessmentBreakdown;
import uk.nhs.nhsbsa.lis.rules.v1.model.outcome.IncomeCapital;

public class HelperFunctions {

	private static Logger LOGGER = Logger.getLogger("uk.nhs.nhsbsa.lis.rules.v1.droolsengine.HelperFunctions");

	private static DecimalFormat decimalFormat = new DecimalFormat("#.00"); 
	
	/**
	 * Helper function. Determines age from handed claim date and dob
	 * @param claimDate
	 * @param dob
	 * @return
	 */
	public static Long ageCalculation(LocalDate claimDate,LocalDate dob){
		return ChronoUnit.YEARS.between(claimDate, dob);
	}
	
	/**
	 * Search for and return the council tax calculation
	 * @param person
	 * @return
	 */
	public static List <String> councilTaxCalculation(Person person){
		return HelperFunctions.outgoingCalculation(person,OutgoingType.COUNCIL_TAX);
	} 
	
	/**
	 * Search for and return the Mortgage
	 * @param person
	 * @return
	 */
	public static List <String> mortgageCalculation(Person person){
		return HelperFunctions.outgoingCalculation(person,OutgoingType.MORTGAGE);
	}
	
	/**
	 * Search for and return the Rent
	 * @param person
	 * @return
	 */
	public static List <String> rentCalculation(Person person){
		return HelperFunctions.outgoingCalculation(person,OutgoingType.RENT);
	}
	
	/**
	 * Search for and return the Ground Rent
	 * @param person
	 * @return
	 */
	public static List <String> groundRentCalculation(Person person){
		return HelperFunctions.outgoingCalculation(person,OutgoingType.GROUND_RENT);
	}
	
	/**
	 * Search for and return the Pension
	 * @param person
	 * @return
	 */
	public static List <String> statePensionBenefit(Person person){
		return HelperFunctions.benefitCalculation(person,BenefitType.RETIREMENT_PENSION);
	}
	
	/**
	 * Search for and return the private pension
	 * @param person
	 * @return
	 */
	public static List <String> privatePensionBenefit(Person person){
		return HelperFunctions.incomeCalculation(person,IncomeType.OCC_PENSION);
	}
	
	/** Calculate the outgoing from the handed person. Converts the value to weekly
	 * @param person
	 * @param type
	  * @return a list of values that match or empty list
	 */
	public static List <String> outgoingCalculation(Person person,OutgoingType type){
		List<String>result = new ArrayList<String>();
		List<Outgoing>outgoings=person.getOutgoings();
		if (outgoings != null) {
			for(Outgoing outgoing : outgoings){
				if(outgoing.getType() == type && outgoing.getValue() != null){
					IntervalValue value=outgoing.getValue();
					if (value.canConvert()) {
						result.add(value.convert(Interval.WEEKLY).getValue().toPlainString());
					}
				}
			} 
		}
		return result;
	}
	
	/** Calculate the benefits from the handed person. Converts the value to weekly
	 * @param person
	 * @param type
	 * @return a list of values that match or empty list
	 */
	public static List <String> benefitCalculation(Person person,BenefitType type){
		List<String>result = new ArrayList<String>();
		List<Benefit>benefits = person.getBenefits();
		if (benefits != null) {
			for(Benefit benefit : benefits){
				if(benefit.getType() == type && benefit.getValue() != null){
					IntervalValue value=benefit.getValue();
					if (value.canConvert()) {
						result.add(value.convert(Interval.WEEKLY).getValue().toPlainString());
					}
				}
			} 
		}
		return result;
	}
	
	/** Calculate the outgoing from the handed person. Converts the value to weekly
	 * @param person
	 * @param type
	  * @return a list of values that match or empty list
	 */
	public static List <String> incomeCalculation(Person person,IncomeType type){
		List<String>result = new ArrayList<String>();
		List<Income>incomes = person.getIncomes();
		if (incomes != null) {
			for(Income income : incomes){
				if(income.getType() == type && income.getValue() != null){
					IntervalValue value=income.getValue();
					if (value.canConvert()) {
						result.add(value.convert(Interval.WEEKLY).getValue().toPlainString());
					}
				}
			} 
		}
		return result;
	}
	
	/**
	 * Convert the handed string (double) from money period in to money period requested.
	 * i.e. 100 as weekly would be converted to 400 as fourWeekly.
	 * @param input
	 * @param inputMoneyPeriod
	 * @param requestedMoneyPeriod
	 * @return
	 */
	public static String convertMoney(String input, Interval inputMoneyPeriod, Interval requestedMoneyPeriod){
		
		if (inputMoneyPeriod == null || requestedMoneyPeriod == null) {
			return null;
		}
		
		//shortcut
		if (inputMoneyPeriod==requestedMoneyPeriod){
			return input;
		}

		double inputValue=NumberUtils.toDouble(input);
		// convert to weekly
		switch(inputMoneyPeriod)
		{
			case WEEKLY:
				break;
			case FORTNIGHTLY:
				inputValue=inputValue/2;
				break;
			case FOURWEEKLY:
				inputValue=inputValue/4;
				break;
			case MONTHLY:
				inputValue=(12*inputValue)/52;
				break;
			case YEARLY:
				inputValue=inputValue/52;
				break;
			case TEN_MONTHLY:
				inputValue=(1.2*inputValue)/52;
				break;
			case SIX_MONTHLY:
				inputValue=(2*inputValue)/52;
				break;
			default:
				break;
		}
		// now multiply by wanted
		switch(requestedMoneyPeriod)
		{
			case WEEKLY:
				break;
			case FORTNIGHTLY:
				inputValue=inputValue*2;
				break;
			case FOURWEEKLY:
				inputValue=inputValue*4;
				break;
			case MONTHLY:
				inputValue=(52*inputValue)/12;
				break;
			case YEARLY:
				inputValue=inputValue*52;
				break;
			case TEN_MONTHLY:
				inputValue=((52*10)*inputValue)/(12);
				break;
			case SIX_MONTHLY:
				inputValue=((52*6)*inputValue)/(12);
				break;
			default:
				break;
		}
		inputValue=round(inputValue,2);
		// TODO - changing the object type will change this
		return decimalFormat.format(inputValue);
	}
	
	/** Round the handed double to n places
	 * @param value
	 * @param places
	 * @return
	 */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	/**
	 * Log that this rule has been triggered
	 * @param container
	 * @param rule
	 */
	public static void logRule(Assessment assessment,String rule){
		LOGGER.log(Level.INFO,"Executing rule:"+rule);
		assessment.getRules().add(rule);
	}
	
	/**
	 * Log that this rule has been triggered
	 * @param container
	 * @param rule
	 */
	public static void logWorkflowRule(WorkflowState container,String rule){
		LOGGER.log(Level.INFO,"Executing rule:"+rule);
		container.getRuleList().add(rule);
	}
	
	/**
	 * Sum the premiums from the assessment
	 * @param assessmentCalc
	 */
	public static void sumPremiums(AssessmentBreakdown assessmentCalc){
		if(assessmentCalc.getPersonalAllowance()!=null){
			assessmentCalc.setRunningPremiums(assessmentCalc.getRunningPremiums()+assessmentCalc.getPersonalAllowance());		
		}
		if(assessmentCalc.getDependantsAllowance()!=null){
			assessmentCalc.setRunningPremiums(assessmentCalc.getRunningPremiums()+assessmentCalc.getDependantsAllowance());		
		}
		if(assessmentCalc.getDisabledChildPremium()!=null){
			assessmentCalc.setRunningPremiums(assessmentCalc.getRunningPremiums()+assessmentCalc.getDisabledChildPremium());		
		}
		if(assessmentCalc.getClientGroupPremium()!=null){
			assessmentCalc.setRunningPremiums(assessmentCalc.getRunningPremiums()+assessmentCalc.getClientGroupPremium());		
		}
		if(assessmentCalc.getEnhancedDisabilityPremium()!=null){
			assessmentCalc.setRunningPremiums(assessmentCalc.getRunningPremiums()+assessmentCalc.getEnhancedDisabilityPremium());		
		}
		if(assessmentCalc.getFamilyPremium()!=null){
			assessmentCalc.setRunningPremiums(assessmentCalc.getRunningPremiums()+assessmentCalc.getFamilyPremium());		
		}
		if(assessmentCalc.getSevereDisabilityPremium()!=null){
			assessmentCalc.setRunningPremiums(assessmentCalc.getRunningPremiums()+assessmentCalc.getSevereDisabilityPremium());		
		}
		if(assessmentCalc.getCarerPremium()!=null){
			assessmentCalc.setRunningPremiums(assessmentCalc.getRunningPremiums()+assessmentCalc.getCarerPremium());		
		}
		if(assessmentCalc.getCouncilTax()!=null){
			assessmentCalc.setRunningPremiums(assessmentCalc.getRunningPremiums()+assessmentCalc.getCouncilTax());		
		}
	}
	
	/**
	 * Sum the housing costs
	 * @param assessmentCalc
	 */
	public static void sumHousingCosts(AssessmentBreakdown assessmentCalc){
		if(assessmentCalc.getMortgage()!=null){
			assessmentCalc.setTotalHousing(assessmentCalc.getTotalHousing()+assessmentCalc.getMortgage());
		}
		if(assessmentCalc.getRent()!=null){
			assessmentCalc.setTotalHousing(assessmentCalc.getTotalHousing()+assessmentCalc.getRent());
		}
		if(assessmentCalc.getGroundRent()!=null){
			assessmentCalc.setTotalHousing(assessmentCalc.getTotalHousing()+assessmentCalc.getGroundRent());
		}
		if(assessmentCalc.getNonDependantDeductions()!=null){
			assessmentCalc.setTotalHousing(assessmentCalc.getTotalHousing()+assessmentCalc.getNonDependantDeductions());
		}
		assessmentCalc.setRunningPremiums(assessmentCalc.getRunningPremiums()+assessmentCalc.getTotalHousing());
	}
	
	public static void sumIncomeAndCapital(AssessmentBreakdown assessmentCalc){
		List<IncomeCapital> incomes=assessmentCalc.getIncomeCapitals();
		for(IncomeCapital incomeCapital : incomes){
			Double thisIncome=NumberUtils.toDouble(incomeCapital.getWeeklyAmount().toString());
			assessmentCalc.setRunningIncome(assessmentCalc.getRunningIncome()+thisIncome);
		}
	}
	
	public static void sumRunningTotal(AssessmentBreakdown assessmentCalc){
		assessmentCalc.setRunningTotal(assessmentCalc.getRunningPremiums()
				+assessmentCalc.getTotalHousing()
				-assessmentCalc.getRunningIncome());
	}
	
	public static void sumIncomeList(AssessmentBreakdown assessmentCalc,List<String> incomes,String incomeName,String owner){
		if(incomes.size()>0){
			for(String incomeCapital : incomes){
				Double parseDouble=NumberUtils.toDouble(incomeCapital);
				assessmentCalc.getIncomeCapitals().add(
					new IncomeCapital(incomeName,owner,new BigDecimal(parseDouble)));
			}
		}
	}
	
}
