package uk.nhs.nhsbsa.lis.rules.v1.droolsengine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uk.nhs.nhsbsa.lis.rules.v1.model.AssessmentCalculation;
import uk.nhs.nhsbsa.lis.rules.v1.model.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.BenefitType;
import uk.nhs.nhsbsa.lis.rules.v1.model.Income;
import uk.nhs.nhsbsa.lis.rules.v1.model.IncomeCapital;
import uk.nhs.nhsbsa.lis.rules.v1.model.IncomeType;
import uk.nhs.nhsbsa.lis.rules.v1.model.MoneyPeriod;
import uk.nhs.nhsbsa.lis.rules.v1.model.Outgoing;
import uk.nhs.nhsbsa.lis.rules.v1.model.OutgoingType;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;

public class HelperFunctions {
	private static Logger logger=Logger.getLogger("uk.nhs.nhsbsa.lis.rules.v1.droolsengine.HelperFunctions");
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
	 * Search for and return the community charge calculation
	 * @param person
	 * @return
	 */
	public static List <String> communityChargeCalculation(Person person){
		return HelperFunctions.outgoingCalculation(person,OutgoingType.COMMUNITY_CHARGE);
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
		List<Outgoing>outgoings=person.getOutgoings();
		List<String>values=new ArrayList<String>();
		for(Outgoing outgoing : outgoings){
			if(outgoing.getType() == type){
				String value=outgoing.getValue();
				MoneyPeriod moneyPeriod=outgoing.getMoneyPeriod();
				value=convertMoney(value,moneyPeriod,MoneyPeriod.weekly);
				values.add(value);
			}
		} 
		return values;
	}
	
	/** Calculate the benefits from the handed person. Converts the value to weekly
	 * @param person
	 * @param type
	 * @return a list of values that match or empty list
	 */
	public static List <String> benefitCalculation(Person person,BenefitType type){
		List<Benefit>benefits=person.getBenefits();
		List<String>values=new ArrayList<String>();
		for(Benefit benefit : benefits){
			if(benefit.getType() == type){
				String value=benefit.getValue();
				MoneyPeriod moneyPeriod=benefit.getMoneyPeriod();
				// convert to weekly
				value=convertMoney(value,moneyPeriod,MoneyPeriod.weekly);
				values.add(value);
			}
		} 
		return values;
	}
	
	/** Calculate the outgoing from the handed person. Converts the value to weekly
	 * @param person
	 * @param type
	  * @return a list of values that match or empty list
	 */
	public static List <String> incomeCalculation(Person person,IncomeType type){
		List<Income>incomes=person.getIncomes();
		List<String>values=new ArrayList<String>();
		for(Income income : incomes){
			if(income.getType() == type){
				String value=income.getValue();
				MoneyPeriod moneyPeriod=income.getMoneyPeriod();
				value=convertMoney(value,moneyPeriod,MoneyPeriod.weekly);
				values.add(value);
			}
		} 
		return values;
	}
	
	/**
	 * Convert the handed string (double) from money period in to money period requested.
	 * i.e. 100 as weekly would be converted to 400 as fourWeekly.
	 * @param input
	 * @param inputMoneyPeriod
	 * @param requestedMoneyPeriod
	 * @return
	 */
	public static String convertMoney(String input,MoneyPeriod inputMoneyPeriod,MoneyPeriod requestedMoneyPeriod){
		if(inputMoneyPeriod==requestedMoneyPeriod){
			// nothing to do
			return input;
		}
		else if (inputMoneyPeriod==MoneyPeriod.UNDEFINED||requestedMoneyPeriod==MoneyPeriod.UNDEFINED){
			logger.log(Level.WARNING,"Calling convertMoney with UNDEFINED conversion");
		}
		double inputValue=Double.parseDouble(input);
		// convert to weekly
		switch(inputMoneyPeriod)
		{
			case weekly:
				break;
			case fortnightly:
				inputValue=inputValue/2;
				break;
			case fourWeekly:
				inputValue=inputValue/4;
				break;
			case monthly:
				inputValue=(12*inputValue)/52;
				break;
			case yearly:
				inputValue=inputValue/52;
				break;
			case tenMonthly:
				inputValue=(1.2*inputValue)/52;
				break;
			case sixMonthly:
				inputValue=(2*inputValue)/52;
				break;
			default:
				break;
		}
		// now multiply by wanted
		switch(requestedMoneyPeriod)
		{
			case weekly:
				break;
			case fortnightly:
				inputValue=inputValue*2;
				break;
			case fourWeekly:
				inputValue=inputValue*4;
				break;
			case monthly:
				inputValue=(52*inputValue)/12;
				break;
			case yearly:
				inputValue=inputValue*52;
				break;
			case tenMonthly:
				inputValue=((52*10)*inputValue)/(12);
				break;
			case sixMonthly:
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
	public static void logRule(AssessmentCalculation container,String rule){
		logger.log(Level.INFO,"Executing rule:"+rule);
		container.getRuleList().add(rule);
	}
	
	/**
	 * Log that this rule has been triggered
	 * @param container
	 * @param rule
	 */
	public static void logWorkflowRule(WorkflowState container,String rule){
		logger.log(Level.INFO,"Executing rule:"+rule);
		container.getRuleList().add(rule);
	}
	
	/**
	 * Sum the premiums from the assessment
	 * @param assessmentCalc
	 */
	public static void sumPremiums(AssessmentCalculation assessmentCalc){
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
		if(assessmentCalc.getCarerPreium()!=null){
			assessmentCalc.setRunningPremiums(assessmentCalc.getRunningPremiums()+assessmentCalc.getCarerPreium());		
		}
		if(assessmentCalc.getCouncilTax()!=null){
			assessmentCalc.setRunningPremiums(assessmentCalc.getRunningPremiums()+assessmentCalc.getCouncilTax());		
		}
	}
	
	/**
	 * Sum the housing costs
	 * @param assessmentCalc
	 */
	public static void sumHousingCosts(AssessmentCalculation assessmentCalc){
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
	
	public static void sumIncomeAndCapital(AssessmentCalculation assessmentCalc){
		List<IncomeCapital> incomes=assessmentCalc.getIncomeCapitals();
		for(IncomeCapital incomeCapital : incomes){
			Double thisIncome=Double.parseDouble(incomeCapital.getWeeklyAmount().toString());
			assessmentCalc.setRunningIncome(assessmentCalc.getRunningIncome()+thisIncome);
		}
	}
	
	public static void sumRunningTotal(AssessmentCalculation assessmentCalc){
		assessmentCalc.setRunningTotal(assessmentCalc.getRunningPremiums()
				+assessmentCalc.getTotalHousing()
				-assessmentCalc.getRunningIncome());
	}
	
	public static void sumIncomeList(AssessmentCalculation assessmentCalc,List<String> incomes,String incomeName,String owner){
		if(incomes.size()>0){
			for(String incomeCapital : incomes){
				Double parseDouble=Double.parseDouble(incomeCapital);
				assessmentCalc.getIncomeCapitals().add(
					new IncomeCapital(incomeName,owner,new BigDecimal(parseDouble)));
			}
		}
	}
}
