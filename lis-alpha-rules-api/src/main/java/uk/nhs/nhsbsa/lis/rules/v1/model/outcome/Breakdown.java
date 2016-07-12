package uk.nhs.nhsbsa.lis.rules.v1.model.outcome;

import java.util.ArrayList;
import java.util.List;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Income;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Interval;

/**
 * Breakdown of resources/requirements used in the assessment.
 */
public class Breakdown {

    private PersonalAllowance personalAllowance;
    
    private CouncilTax councilTax;
    
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

    public PersonalAllowance getPersonalAllowance() {
        return personalAllowance;
    }

    public void setPersonalAllowance(PersonalAllowance personalAllowance) {
        this.personalAllowance = personalAllowance;
    }

    public CouncilTax getCouncilTax() {
        return councilTax;
    }

    public void setCouncilTax(CouncilTax councilTax) {
        this.councilTax = councilTax;
    }
	
}
