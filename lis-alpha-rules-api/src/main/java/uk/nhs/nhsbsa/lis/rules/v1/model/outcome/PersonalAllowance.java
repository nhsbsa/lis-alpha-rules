package uk.nhs.nhsbsa.lis.rules.v1.model.outcome;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Interval;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public class PersonalAllowance {

    private IntervalValue value;
    
    public PersonalAllowance() {
    }
    
    public PersonalAllowance(Double value) {
        this.value = new IntervalValue(Interval.WEEKLY, value);
    }
    
    public IntervalValue getValue() {
        return value;
    }

    public void setValue(IntervalValue value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return MessageFormatter.arrayFormat("", new Object[]{
                
        }).getMessage();
    }

}
