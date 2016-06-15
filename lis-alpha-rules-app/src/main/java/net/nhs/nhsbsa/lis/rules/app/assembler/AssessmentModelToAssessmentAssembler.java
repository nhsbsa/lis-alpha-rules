package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.rules.builder.FieldWalker;
import uk.nhs.nhsbsa.rules.types.Field;

@Component
public class AssessmentModelToAssessmentAssembler extends AbstractAssembler<AssessmentModel, Assessment> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentModelToAssessmentAssembler.class);
	
	AssessmentModelIndexer indexer = new AssessmentModelIndexer();
	
	@SuppressWarnings("unchecked")
	@Override
	public void map(AssessmentModel source, Assessment destination) {
		
		Map<String, Field<Object>> index = indexer.index(source);
		FieldWalker walker = new FieldWalker();
		walker.walk(destination, (dst) -> {
			String key = key(dst);
			Field<Object> src = index.get(key);
			if (src != null) {
				Object oldValue = dst.getValue();
				Object newValue = src.getValue();
				if (!Objects.equals(oldValue, newValue)) {
					LOGGER.info("Changing {} from {} to {}", new Object[]{
							dst.getName(),
							oldValue,
							newValue
					});
					((Field<Object>)dst).setValue(newValue);
				}
			}
		});
	}

	private String key(Field<?> field) {
		return field.getName();
	}

}
