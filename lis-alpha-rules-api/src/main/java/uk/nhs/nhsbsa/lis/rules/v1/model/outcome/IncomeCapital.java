package uk.nhs.nhsbsa.lis.rules.v1.model.outcome;

import java.math.BigDecimal;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Interval;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public class IncomeCapital implements IResource {
    
	private String type; // This could be an IncomeType,SavingType or BenefitType TODO better way of doing this
	private String paidTo; // Claimant, partner or whatever is needed for the form
	private BigDecimal weeklyAmount;
	private BigDecimal earningsDisregard; // TODO verify whether this is an amount or string
    private BigDecimal otherDisregard; // TODO verify whether this is an amount or string
    private BigDecimal netWeeklyAmount; // TODO verify whether this is an amount or string
	
    public IncomeCapital(String type, String paidTo, BigDecimal weeklyAmount, BigDecimal earningsDisregard,
            BigDecimal otherDisregard, BigDecimal netWeeklyAmount) {
        super();
        this.type = type;
        this.paidTo = paidTo;
        this.weeklyAmount = weeklyAmount;
        this.earningsDisregard = earningsDisregard;
        this.otherDisregard = otherDisregard;
        this.netWeeklyAmount = netWeeklyAmount;
    }
    public IncomeCapital() {
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPaidTo() {
		return paidTo;
	}
	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}
	public BigDecimal getWeeklyAmount() {
		return weeklyAmount;
	}
	public void setWeeklyAmount(BigDecimal weeklyAmount) {
		this.weeklyAmount = weeklyAmount;
	}
	public BigDecimal getEarningsDisregard() {
		return earningsDisregard;
	}
	public void setEarningsDisregard(BigDecimal earningsDisregard) {
		this.earningsDisregard = earningsDisregard;
	}
	public BigDecimal getOtherDisregard() {
		return otherDisregard;
	}
	public void setOtherDisregard(BigDecimal otherDisregard) {
		this.otherDisregard = otherDisregard;
	}
    public BigDecimal getNetWeeklyAmount() {
        return netWeeklyAmount;
    }
    public void setNetWeeklyAmount(BigDecimal netWeeklyAmount) {
        this.netWeeklyAmount = netWeeklyAmount;
    }
    @Override
    public IntervalValue getValue() {
        return new IntervalValue(Interval.WEEKLY, weeklyAmount);
    }
    @Override
    public String toString() {
        return MessageFormatter.arrayFormat("{} income capital paid to {} as {}", new Object[]{
                getValue(), paidTo, type
        }).getMessage();
    }
}
