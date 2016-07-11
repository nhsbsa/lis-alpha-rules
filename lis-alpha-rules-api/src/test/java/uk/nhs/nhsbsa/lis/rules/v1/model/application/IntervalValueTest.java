package uk.nhs.nhsbsa.lis.rules.v1.model.application;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Interval;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public class IntervalValueTest {

	@Test 
	public void convertMoneyWeeklyTest(){
		convert("10.00", Interval.WEEKLY, Interval.WEEKLY, "10.00");
		convert("30.00", Interval.FORTNIGHTLY, Interval.WEEKLY, "15.00");
		convert("40.00", Interval.FOURWEEKLY, Interval.WEEKLY, "10.00");
		convert("40.00", Interval.MONTHLY, Interval.WEEKLY, "9.23");
		convert("520.00", Interval.SIX_MONTHLY, Interval.WEEKLY, "20.00");
		convert("100.00", Interval.TEN_MONTHLY, Interval.WEEKLY, "2.31");
		convert("240.00", Interval.YEARLY, Interval.WEEKLY, "4.62");
	}
	
	@Test 
	public void convertMoneyYearlyTest(){
		convert("10.00", Interval.WEEKLY, Interval.YEARLY, "520.00");
		convert("30.00", Interval.FORTNIGHTLY, Interval.YEARLY, "780.00");
		convert("40.00", Interval.FOURWEEKLY, Interval.YEARLY, "520.00");
		convert("40.00", Interval.MONTHLY, Interval.YEARLY, "480.00");
		convert("520.00", Interval.SIX_MONTHLY, Interval.YEARLY, "1040.00");
		convert("100.00", Interval.TEN_MONTHLY, Interval.YEARLY, "120.00");
		convert("240.00", Interval.YEARLY, Interval.YEARLY, "240.00");
	}
	
	@Test 
	public void convertMoneyMonthlyTest(){
		convert("10.00", Interval.WEEKLY, Interval.MONTHLY, "43.33");
		convert("30.00", Interval.FORTNIGHTLY, Interval.MONTHLY, "65.00");
		convert("40.00", Interval.FOURWEEKLY, Interval.MONTHLY, "43.33");
		convert("40.00", Interval.MONTHLY, Interval.MONTHLY, "40.00");
		convert("520.00", Interval.SIX_MONTHLY, Interval.MONTHLY, "86.67");
		convert("100.00", Interval.TEN_MONTHLY, Interval.MONTHLY, "10.00");
		convert("240.00", Interval.YEARLY, Interval.MONTHLY, "20.00");
	}


	
	private void convert(String inputValue, Interval inputInterval, Interval outputInterval, String expectedValue) {
		
		IntervalValue input = new IntervalValue(inputInterval, new BigDecimal(inputValue));
		IntervalValue expected = new IntervalValue(outputInterval, new BigDecimal(expectedValue));
		
		assertEquals(expected, input.convert(outputInterval));
	}

}
