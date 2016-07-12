package uk.nhs.nhsbsa.lis.rules.v1.model.outcome;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public interface IResource {

    public IntervalValue getValue();
    public String getType();
}
