package uk.nhs.nhsbsa.lis.rules.v1.builder;

import java.util.List;

import uk.nhs.nhsbsa.lis.rules.v1.model.Income;
import uk.nhs.nhsbsa.lis.rules.v1.model.IncomeType;

public class IncomesBuilder extends AbstractBuilder<List<Income>>{
	public IncomesBuilder() {
		super();
	}

	public IncomesBuilder(AbstractBuilder<?> parent, String name, List<Income> instance) {
		super(parent, name, instance);
	}

	public IncomesBuilder withIncomeValue(String value) {
		getItem().setValue(value);
		return this;
	}

	public IncomesBuilder withIncomeType(IncomeType type) {
		getItem().setType(type);
		return this;
	}

	public IncomesBuilder add() {
		
		Income outgoing = new Income();
		instance.add(outgoing);
		return this;
	}
	
	private Income getItem() {
		Income result = null;
		List<Income> instance = getInstance();
		if (instance.isEmpty()) {
			result = new Income();
			instance.add(result);
		} else {
			result = instance.get(instance.size() - 1);
		}
		return result;
	}
}
