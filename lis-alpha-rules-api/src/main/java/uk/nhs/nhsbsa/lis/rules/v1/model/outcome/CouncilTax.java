package uk.nhs.nhsbsa.lis.rules.v1.model.outcome;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public class CouncilTax implements IRequirement {

    private IntervalValue value;
    
    public CouncilTax() {
    }
    
    public CouncilTax(IntervalValue value) {
        super();
        this.value = value;
    }

    @Override
    public IntervalValue getValue() {
        return value;
    }

    public void setValue(IntervalValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return MessageFormatter.arrayFormat("Council tax of {}", new Object[]{
                value
        }).getMessage();
    }
}
