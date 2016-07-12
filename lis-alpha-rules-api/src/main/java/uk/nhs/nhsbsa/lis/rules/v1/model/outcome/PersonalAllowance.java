package uk.nhs.nhsbsa.lis.rules.v1.model.outcome;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Interval;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public class PersonalAllowance implements IRequirement {

    private IntervalValue value;
    private String name;
    
    public PersonalAllowance() {
    }
    
    public PersonalAllowance(Double value, String name) {
        this.value = new IntervalValue(Interval.WEEKLY, value);
        this.name = name;
    }
    
    public IntervalValue getValue() {
        return value;
    }

    public void setValue(IntervalValue value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return MessageFormatter.arrayFormat("{} is {}", new Object[]{
                name, value
        }).getMessage();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
