package uk.nhs.nhsbsa.lis.rules.v1.builder;

import java.util.List;

import org.apache.commons.collections.ListUtils;

import uk.nhs.nhsbsa.lis.rules.v1.model.Benefit;

public class BenefitsBuilder extends ModelBuilder<List<Benefit>>{

	public BenefitsBuilder() {
		super();
	}

	public BenefitsBuilder(ModelBuilder<?> parent, String name, List<Benefit> instance) {
		super(parent, name, instance);
	}

	public BenefitsBuilder withBenefitValue(String benefitValue) {
		getItem().setBenefitValue(benefitValue);
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
