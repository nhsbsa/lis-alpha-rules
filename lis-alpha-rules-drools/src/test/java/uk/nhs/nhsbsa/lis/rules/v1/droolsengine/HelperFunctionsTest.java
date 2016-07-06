package uk.nhs.nhsbsa.lis.rules.v1.droolsengine;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.Interval;

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
		String result=HelperFunctions.convertMoney("10.00", Interval.WEEKLY, Interval.WEEKLY);
		assertTrue(result.equals("10.00"));
		result=HelperFunctions.convertMoney("30.00", Interval.FORTNIGHTLY, Interval.WEEKLY);
		assertTrue(result.equals("15.00"));
		result=HelperFunctions.convertMoney("40.00", Interval.FOURWEEKLY, Interval.WEEKLY);
		assertTrue(result.equals("10.00"));
		result=HelperFunctions.convertMoney("40.00", Interval.MONTHLY, Interval.WEEKLY);
		assertTrue(result.equals("9.23"));
		result=HelperFunctions.convertMoney("520.00", Interval.SIX_MONTHLY, Interval.WEEKLY);
		assertTrue(result.equals("20.00"));
		result=HelperFunctions.convertMoney("100.00", Interval.TEN_MONTHLY, Interval.WEEKLY);
		assertTrue(result.equals("2.31"));
		result=HelperFunctions.convertMoney("240.00", Interval.YEARLY, Interval.WEEKLY);
		assertTrue(result.equals("4.62"));
	}
	
	@Test 
	public void convertMoneyYearlyTest(){
		String result=HelperFunctions.convertMoney("10.00", Interval.WEEKLY, Interval.YEARLY);
		assertTrue(result.equals("520.00"));
		result=HelperFunctions.convertMoney("30.00", Interval.FORTNIGHTLY, Interval.YEARLY);
		assertTrue(result.equals("780.00"));
		result=HelperFunctions.convertMoney("40.00", Interval.FOURWEEKLY, Interval.YEARLY);
		assertTrue(result.equals("520.00"));
		result=HelperFunctions.convertMoney("40.00", Interval.MONTHLY, Interval.YEARLY);
		assertTrue(result.equals("480.00"));
		result=HelperFunctions.convertMoney("520.00", Interval.SIX_MONTHLY, Interval.YEARLY);
		assertTrue(result.equals("1040.00"));
		result=HelperFunctions.convertMoney("100.00", Interval.TEN_MONTHLY, Interval.YEARLY);
		assertTrue(result.equals("120.00"));
		result=HelperFunctions.convertMoney("240.00", Interval.YEARLY, Interval.YEARLY);
		assertTrue(result.equals("240.00"));
	}
	
	@Test 
	public void convertMoneyMonthlyTest(){
		String result=HelperFunctions.convertMoney("10.00", Interval.WEEKLY, Interval.MONTHLY);
		System.out.println("result="+result);
		assertTrue(result.equals("43.33"));
		result=HelperFunctions.convertMoney("30.00", Interval.FORTNIGHTLY, Interval.MONTHLY);
		System.out.println("result="+result);
		assertTrue(result.equals("65.00"));
		result=HelperFunctions.convertMoney("40.00", Interval.FOURWEEKLY, Interval.MONTHLY);
		System.out.println("result="+result);
		assertTrue(result.equals("43.33"));
		result=HelperFunctions.convertMoney("40.00", Interval.MONTHLY, Interval.MONTHLY);
		System.out.println("result="+result);
		assertTrue(result.equals("40.00"));
		result=HelperFunctions.convertMoney("520.00", Interval.SIX_MONTHLY, Interval.MONTHLY);
		System.out.println("result="+result);
		assertTrue(result.equals("86.67"));
		result=HelperFunctions.convertMoney("100.00", Interval.TEN_MONTHLY, Interval.MONTHLY);
		System.out.println("result="+result);
		assertTrue(result.equals("10.00"));
		result=HelperFunctions.convertMoney("240.00", Interval.YEARLY, Interval.MONTHLY);
		System.out.println("result="+result);
		assertTrue(result.equals("20.00"));
	}
}
