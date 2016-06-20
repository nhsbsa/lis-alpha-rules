package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;
import uk.nhs.nhsbsa.rules.model.rules.Assessment;
import uk.nhs.nhsbsa.rules.model.rules.Requirement;
import uk.nhs.nhsbsa.rules.types.Field;
import uk.nhs.nhsbsa.util.FieldUtils;
import uk.nhs.nhsbsa.util.ObjectWalker;
import uk.nhs.nhsbsa.util.ObjectWalker.CallbackItem;

@Component
public class AssessmentToAssessmentModelAssembler extends AbstractAssembler<Assessment, AssessmentModel> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentToAssessmentModelAssembler.class);
	
	private FieldIndexer indexer = new FieldIndexer();
	
	@Override
	public void map(Assessment source, AssessmentModel destination) {

		final List<Field<?>> fields = mapApplicationToFields(source.getApplication(), destination.getFields());
		decorateFields(source, fields);
		destination.setFields(fields);
		destination.setId(source.getId());
	}

	private void decorateFields(Assessment source, List<Field<?>> fields) {
		
		final Map<String, Field<Object>> index = indexer.index(fields);
		List<Requirement> requirements = source.getRequirements();
		if (requirements != null) {
			for (Requirement requirement : requirements) {
				
			}
		}
	}

	/**
	 * Map LIS Application from Assessment into list of Fields.
	 * @param source
	 * @return
	 */
	private List<Field<?>> mapApplicationToFields(LisApplication source, List<Field<?>> existingFields) {
		
		final Map<String, Field<Object>> index = indexer.index(existingFields);
		final List<Field<?>> fields = new ArrayList<>();

		ObjectWalker walker = new ObjectWalker(source, (item) -> {

			if (FieldUtils.isPrimitive(item.getField().getType())) {
				
				//add field to destination
				fields.add(createField(item));
	
				//useful debug
				Object newValue = item.getValue();
				String key = item.getPath();
				if (index.containsKey(key)) {
					Field<?> dst = index.get(key);
					Object oldValue = dst.getValue();
					if (!Objects.equals(oldValue, newValue)) {
						LOGGER.info("Changing {} from {} to {}", new Object[]{
								dst.getName(),
								oldValue,
								newValue
						});
					}
					
				} else {
					LOGGER.info("Adding {} to {}", new Object[]{
							item.getPath(),
							newValue});
				}
			}	
		});
		walker.walk();
		
		return fields;
	}

	private Field<Object> createField(CallbackItem item) {
		return new Field<Object>(item.getPath(), item.getValue());
	}
}
