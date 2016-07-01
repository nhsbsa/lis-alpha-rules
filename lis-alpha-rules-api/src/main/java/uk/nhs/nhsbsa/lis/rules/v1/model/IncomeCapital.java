package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.math.BigDecimal;

public class IncomeCapital {
	private String type; // This could be an IncomeType,SavingType or BenefitType TODO better way of doing this
	private String paidTo; // Claimant, partner or whatever is needed for the form
	private BigDecimal weeklyAmount;
	private BigDecimal earningsDisregard; // TODO verify whether this is an amount or string
	private BigDecimal otherDisregard; // TODO verify whether this is an amount or string
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
	@Override
	public String toString() {
		return "IncomeCapital [type=" + type + ", paidTo=" + paidTo + ", weeklyAmount=" + weeklyAmount
				+ ", earningsDisregard=" + earningsDisregard + ", otherDisregard=" + otherDisregard + "]";
	}
	
	
	
}
