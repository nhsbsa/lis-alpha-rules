package uk.nhs.nhsbsa.lis.rules.v1.builder;

import java.util.List;

import uk.nhs.nhsbsa.lis.rules.v1.model.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.BenefitType;
import uk.nhs.nhsbsa.lis.rules.v1.model.IntervalValue;

public class BenefitsBuilder extends AbstractBuilder<List<Benefit>>{

	public BenefitsBuilder() {
		super();
	}

	public BenefitsBuilder(AbstractBuilder<?> parent, String name, List<Benefit> instance) {
		super(parent, name, instance);
	}

	public BenefitsBuilder withBenefitValue(IntervalValue value) {
		getItem().setValue(value);
		return this;
	}

	public BenefitsBuilder withBenefitType(BenefitType type) {
		getItem().setType(type);
		return this;
	}

	public BenefitsBuilder add() {
		
		Benefit benefit = new Benefit();
		instance.add(benefit);
		return this;
	}
	
	private Benefit getItem() {
		Benefit result = null;
		List<Benefit> instance = getInstance();
		if (instance.isEmpty()) {
			result = new Benefit();
			instance.add(result);
		} else {
			result = instance.get(instance.size() - 1);
		}
		return result;
	}

}
