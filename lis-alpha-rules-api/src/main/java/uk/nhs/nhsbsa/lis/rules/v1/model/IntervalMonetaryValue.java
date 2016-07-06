package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;

/**
 * TODO convert to immutable class.
 * TODO user Long to represent pennies and format to pounds on front end.
 */
public class IntervalMonetaryValue {

	private static final Logger LOGGER = LoggerFactory.getLogger(IntervalMonetaryValue.class);
	
	/**
	 * Standard MathContext for money.
	 */
	private static final MathContext MC = new MathContext(2, RoundingMode.HALF_UP);

	//apparent defect when dividing with scale 2 ROUND_HALF_UP
	private static final MathContext MC_DIVISOR = new MathContext(4, RoundingMode.HALF_UP);
	
	/**
	 * Map of factor to multiple up/down to YEARLY
	 */
	private static final Map<Interval, BigDecimal> FACTORS;
	static {
		ImmutableMap.Builder<Interval, BigDecimal> multiplicandBuilder = ImmutableMap.builder();
		multiplicandBuilder.put(Interval.WEEKLY, BigDecimal.valueOf(52));
		multiplicandBuilder.put(Interval.FORTNIGHTLY, BigDecimal.valueOf(26));
		multiplicandBuilder.put(Interval.FOURWEEKLY, BigDecimal.valueOf(13));
		multiplicandBuilder.put(Interval.MONTHLY, BigDecimal.valueOf(12));
		multiplicandBuilder.put(Interval.SIX_MONTHLY, BigDecimal.valueOf(2));
		multiplicandBuilder.put(Interval.TEN_MONTHLY, new BigDecimal("1.2"));
		FACTORS = multiplicandBuilder.build();
	}

	private Interval interval;
	
	private BigDecimal value;
	
	public IntervalMonetaryValue(Interval interval, BigDecimal value) {
		super();
		this.interval = interval;
		this.value = value.setScale(MC.getPrecision(), MC.getRoundingMode());
	}

	public Interval getInterval() {
		return interval;
	}

	public BigDecimal getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((interval == null) ? 0 : interval.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntervalMonetaryValue other = (IntervalMonetaryValue) obj;
		if (interval != other.interval)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	public IntervalMonetaryValue convertInterval(Interval interval) {
		
		if(interval == this.interval){
			// nothing to do
			return this;
		}

		// convert to yearly
		BigDecimal working = null;
		BigDecimal multiplicand = FACTORS.get(this.interval);
		if (multiplicand != null) {
			working = this.value.multiply(multiplicand);
		} else {
			working = this.value;
		}
		
		// convert to requested
		BigDecimal newValue;
		BigDecimal divisor = FACTORS.get(interval);
		if (divisor != null) {
			newValue = working.divide(divisor, MC_DIVISOR);
		} else {
			newValue = working;
		}
		
		IntervalMonetaryValue result = new IntervalMonetaryValue(interval, newValue);
		LOGGER.info("{} > £{} YEARLY > {}", new Object[]{this, working, result});

		return result;
	}

	@Override
	public String toString() {
		return "£" + value + " " + interval;
	}

	
}
