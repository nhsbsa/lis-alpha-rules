package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.rules.types.Field;
import uk.nhs.nhsbsa.util.ObjectWalker;

@Component
public class AssessmentModelToAssessmentAssembler extends AbstractAssembler<AssessmentModel, Assessment> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentModelToAssessmentAssembler.class);
	
	AssessmentModelIndexer indexer = new AssessmentModelIndexer();
	
	@Override
	public void map(AssessmentModel source, Assessment destination) {
		
		final Map<String, Field<Object>> index = indexer.index(source);
		ObjectWalker walker = new ObjectWalker(destination, (item) -> {
			Field<Object> src = index.get(item.getPath());
			if (src != null) {
				Object oldValue = item.getValue();
				Object newValue = src.getValue();
				if (!Objects.equals(oldValue, newValue)) {
					LOGGER.info("Changing {} from {} to {}", new Object[]{
							item.getField().getName(),
							oldValue,
							newValue
					});
					try {
						FieldUtils.writeField(item.getField(), item.getObject(), newValue, true);
					} catch (Exception e) {
						throw new IllegalArgumentException(e);
					}
				}
			}
		});
		walker.walk();
	}
}
