package uk.nhs.nhsbsa.lis.rules.v1.droolsengine;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.MoneyPeriod;

/**
 * Test the helper function conversions
 * TODO verfiy with business this is the rule
 * @author lorob
 *
 */
public class HelperFunctionsTest {
	@Test
	public void roundTest(){
		double testDouble=HelperFunctions.round(new Double("10.505"), 2);
		assertTrue(testDouble==10.51);
		testDouble=HelperFunctions.round(new Double("10.504"), 2);
		assertTrue(testDouble==10.50);
		testDouble=HelperFunctions.round(new Double("10.999"), 2);
		assertTrue(testDouble==11.00);
	}
	
	@Test 
	public void convertMoneyWeeklyTest(){
		String result=HelperFunctions.convertMoney("10.00", MoneyPeriod.weekly, MoneyPeriod.weekly);
		assertTrue(result.equals("10.00"));
		result=HelperFunctions.convertMoney("30.00", MoneyPeriod.fortnightly, MoneyPeriod.weekly);
		assertTrue(result.equals("15.00"));
		result=HelperFunctions.convertMoney("40.00", MoneyPeriod.fourWeekly, MoneyPeriod.weekly);
		assertTrue(result.equals("10.00"));
		result=HelperFunctions.convertMoney("40.00", MoneyPeriod.monthly, MoneyPeriod.weekly);
		assertTrue(result.equals("9.23"));
		result=HelperFunctions.convertMoney("520.00", MoneyPeriod.sixMonthly, MoneyPeriod.weekly);
		assertTrue(result.equals("20.00"));
		result=HelperFunctions.convertMoney("100.00", MoneyPeriod.tenMonthly, MoneyPeriod.weekly);
		assertTrue(result.equals("2.31"));
		result=HelperFunctions.convertMoney("240.00", MoneyPeriod.yearly, MoneyPeriod.weekly);
		assertTrue(result.equals("4.62"));
	}
	
	@Test 
	public void convertMoneyYearlyTest(){
		String result=HelperFunctions.convertMoney("10.00", MoneyPeriod.weekly, MoneyPeriod.yearly);
		assertTrue(result.equals("520.00"));
		result=HelperFunctions.convertMoney("30.00", MoneyPeriod.fortnightly, MoneyPeriod.yearly);
		assertTrue(result.equals("780.00"));
		result=HelperFunctions.convertMoney("40.00", MoneyPeriod.fourWeekly, MoneyPeriod.yearly);
		assertTrue(result.equals("520.00"));
		result=HelperFunctions.convertMoney("40.00", MoneyPeriod.monthly, MoneyPeriod.yearly);
		assertTrue(result.equals("480.00"));
		result=HelperFunctions.convertMoney("520.00", MoneyPeriod.sixMonthly, MoneyPeriod.yearly);
		assertTrue(result.equals("1040.00"));
		result=HelperFunctions.convertMoney("100.00", MoneyPeriod.tenMonthly, MoneyPeriod.yearly);
		assertTrue(result.equals("120.00"));
		result=HelperFunctions.convertMoney("240.00", MoneyPeriod.yearly, MoneyPeriod.yearly);
		assertTrue(result.equals("240.00"));
	}
	
	@Test 
	public void convertMoneyMonthlyTest(){
		String result=HelperFunctions.convertMoney("10.00", MoneyPeriod.weekly, MoneyPeriod.monthly);
		System.out.println("result="+result);
		assertTrue(result.equals("43.33"));
		result=HelperFunctions.convertMoney("30.00", MoneyPeriod.fortnightly, MoneyPeriod.monthly);
		System.out.println("result="+result);
		assertTrue(result.equals("65.00"));
		result=HelperFunctions.convertMoney("40.00", MoneyPeriod.fourWeekly, MoneyPeriod.monthly);
		System.out.println("result="+result);
		assertTrue(result.equals("43.33"));
		result=HelperFunctions.convertMoney("40.00", MoneyPeriod.monthly, MoneyPeriod.monthly);
		System.out.println("result="+result);
		assertTrue(result.equals("40.00"));
		result=HelperFunctions.convertMoney("520.00", MoneyPeriod.sixMonthly, MoneyPeriod.monthly);
		System.out.println("result="+result);
		assertTrue(result.equals("86.67"));
		result=HelperFunctions.convertMoney("100.00", MoneyPeriod.tenMonthly, MoneyPeriod.monthly);
		System.out.println("result="+result);
		assertTrue(result.equals("10.00"));
		result=HelperFunctions.convertMoney("240.00", MoneyPeriod.yearly, MoneyPeriod.monthly);
		System.out.println("result="+result);
		assertTrue(result.equals("20.00"));
	}
}
