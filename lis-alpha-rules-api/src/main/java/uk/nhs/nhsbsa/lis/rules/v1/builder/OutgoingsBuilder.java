package uk.nhs.nhsbsa.lis.rules.v1.builder;

import java.util.List;

import uk.nhs.nhsbsa.lis.rules.v1.model.IntervalValue;
import uk.nhs.nhsbsa.lis.rules.v1.model.Outgoing;
import uk.nhs.nhsbsa.lis.rules.v1.model.OutgoingType;

public class OutgoingsBuilder extends AbstractBuilder<List<Outgoing>>{
	public OutgoingsBuilder() {
		super();
	}

	public OutgoingsBuilder(AbstractBuilder<?> parent, String name, List<Outgoing> instance) {
		super(parent, name, instance);
	}

	public OutgoingsBuilder withOutgoingValue(IntervalValue value) {
		getItem().setValue(value);
		return this;
	}

	public OutgoingsBuilder withOutgoingType(OutgoingType type) {
		getItem().setType(type);
		return this;
	}

	public OutgoingsBuilder add() {
		
		Outgoing outgoing = new Outgoing();
		instance.add(outgoing);
		return this;
	}
	
	private Outgoing getItem() {
		Outgoing result = null;
		List<Outgoing> instance = getInstance();
		if (instance.isEmpty()) {
			result = new Outgoing();
			instance.add(result);
		} else {
			result = instance.get(instance.size() - 1);
		}
		return result;
	}
}
