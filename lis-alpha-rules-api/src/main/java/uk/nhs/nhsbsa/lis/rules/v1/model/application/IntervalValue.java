package uk.nhs.nhsbsa.lis.rules.v1.model.application;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

import com.google.common.collect.ImmutableMap;

/**
 * TODO use Long to represent pennies and format to pounds on front end.
 */
public class IntervalValue {

	private static final Logger LOGGER = LoggerFactory.getLogger(IntervalValue.class);
	
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
	
	public static boolean canConvert(IntervalValue... values) {
		boolean result = Boolean.TRUE;
		for (IntervalValue value : values) {
			if (value == null ||
					value.value == null|| 
					value.interval == null) {
				result = Boolean.FALSE;
				break;
			}
		}
		return result;
	}


	/**
	 * Default constructor.
	 */
	public IntervalValue() {
	}

	/**
	 * Convenience constructor.
	 * @param interval
	 * @param value
	 */
	public IntervalValue(Interval interval, String value) {
		this(interval, new BigDecimal(value));
	}
	
	/**
	 * Convenience constructor.
	 * @param interval
	 * @param value
	 */
	public IntervalValue(Interval interval, Number value) {
		this(interval, value.toString());
	}
	
	/**
	 * Convenience constructor.
	 * @param interval
	 * @param value
	 */
	public IntervalValue(Interval interval, BigDecimal value) {
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

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
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
		IntervalValue other = (IntervalValue) obj;
		if (interval != other.interval)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/**
	 * Scale the current interval to the one provided.
	 * @param interval
	 * @return a new IntervalValue with the new scale.
	 */
	public IntervalValue convert(Interval interval) {
		
		//exception if can't convert
		if (!canConvert()) {
			String msg = MessageFormatter.arrayFormat("Can't convert from {} to {}. Call canConvert() first", 
					new Object[]{this, interval}).getMessage();
			throw new IllegalStateException(msg);
		}
		
		// nothing to do
		if(interval == this.interval){
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
		
		IntervalValue result = new IntervalValue(interval, newValue);
		LOGGER.info("{} > £{} YEARLY > {}", new Object[]{this, working, result});

		return result;
	}

	public boolean canConvert() {
		return canConvert(this);
	}

	public IntervalValue add(IntervalValue value) {
		IntervalValue result = null;
		if (canConvert(this, value)) {
			IntervalValue tmp = value.convert(interval);
			BigDecimal total = this.value.add(tmp.value);
			result = new IntervalValue(interval, total);
		} else {
			result = this;
		}
		return result;
	}

	public IntervalValue subtract(IntervalValue value) {
		IntervalValue result = null;
		if (canConvert(this, value)) {
			IntervalValue tmp = value.convert(interval);
			BigDecimal total = this.value.subtract(tmp.value);
			result = new IntervalValue(interval, total);
		} else {
			result = this;
		}
		return result;
	}

	public IntervalValue multiply(IntervalValue value) {
		IntervalValue result = null;
		if (canConvert(this, value)) {
			IntervalValue tmp = value.convert(interval);
			BigDecimal total = this.value.multiply(tmp.value);
			result = new IntervalValue(interval, total);
		} else {
			result = this;
		}
		return result;
	}

	public IntervalValue divide(IntervalValue value) {
		IntervalValue result = null;
		if (canConvert(this, value)) {
			IntervalValue tmp = value.convert(interval);
			BigDecimal total = this.value.divide(tmp.value);
			result = new IntervalValue(interval, total);
		} else {
			result = this;
		}
		return result;
	}

	public Boolean eq(IntervalValue value) {
		Boolean result = null;
		if (canConvert(this, value)) {
			IntervalValue tmp = value.convert(interval);
			result = this.value.compareTo(tmp.getValue()) == 0;
		} else {
			result = Boolean.FALSE;
		}
		return result;
	}

	public Boolean gt(IntervalValue value) {
		Boolean result = null;
		if (canConvert(this, value)) {
			IntervalValue tmp = value.convert(interval);
			result = this.value.compareTo(tmp.getValue()) > 0;
		} else {
			result = Boolean.FALSE;
		}
		return result;
	}

	public Boolean gte(IntervalValue value) {
		Boolean result = null;
		if (canConvert(this, value)) {
			IntervalValue tmp = value.convert(interval);
			result = this.value.compareTo(tmp.getValue()) >= 0;
		} else {
			result = Boolean.FALSE;
		}
		return result;
	}

	public Boolean lt(IntervalValue value) {
		Boolean result = null;
		if (canConvert(this, value)) {
			IntervalValue tmp = value.convert(interval);
			result = this.value.compareTo(tmp.getValue()) < 0;
		} else {
			result = Boolean.FALSE;
		}
		return result;
	}

	public Boolean lte(IntervalValue value) {
		Boolean result = null;
		if (canConvert(this, value)) {
			IntervalValue tmp = value.convert(interval);
			result = this.value.compareTo(tmp.getValue()) <= 0;
		} else {
			result = Boolean.FALSE;
		}
		return result;
	}

	@Override
	public String toString() {
		return "£" + value + " " + interval;
	}

}
