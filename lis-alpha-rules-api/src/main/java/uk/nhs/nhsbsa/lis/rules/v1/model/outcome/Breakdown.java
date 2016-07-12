package uk.nhs.nhsbsa.lis.rules.v1.model.outcome;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Income;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Interval;

/**
 * Class to hold the values used in the assessment calculation
 * This is based on the HC3 form
 * @author lorob
 *
 */
public class Breakdown {

	private static final Logger LOGGER = LoggerFactory.getLogger(Breakdown.class);

	private List<IncomeCapital> incomeCapital;

	public List<IncomeCapital> getIncomeCapital() {
		return incomeCapital;
	}

	public void setIncomeCapital(List<IncomeCapital> incomeCapital) {
		this.incomeCapital = incomeCapital;
	}
	
	public void addIncomeCapital(Income income) {
		IncomeCapital capital = new IncomeCapital(
				income.getType().name(), 
				income.getOwner().toString(), 
				income.getValue().convert(Interval.WEEKLY).getValue(),
				null, null, null);
		addIncomeCapital(capital);
	}
	
	public void addIncomeCapital(Benefit benefit) {
		IncomeCapital capital = new IncomeCapital(
				benefit.getType().name(), 
				benefit.getOwner().toString(), 
				benefit.getValue().convert(Interval.WEEKLY).getValue(),
				null, null, null);
		addIncomeCapital(capital);
	}
	
	public void addIncomeCapital(IncomeCapital incomeCapital) {
		if (this.incomeCapital == null) {
			this.incomeCapital = new ArrayList<>();
		}
		this.incomeCapital.add(incomeCapital);
	}
	
}
