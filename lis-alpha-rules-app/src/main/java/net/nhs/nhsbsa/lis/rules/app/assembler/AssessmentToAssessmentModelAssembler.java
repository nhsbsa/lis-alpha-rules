package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.rules.types.Field;
import uk.nhs.nhsbsa.util.ObjectWalker;

@Component
public class AssessmentToAssessmentModelAssembler extends AbstractAssembler<Assessment, AssessmentModel> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentToAssessmentModelAssembler.class);
	
	AssessmentModelIndexer indexer = new AssessmentModelIndexer();
	
	@Override
	public void map(Assessment source, AssessmentModel destination) {

		Map<String, Field<Object>> index = indexer.index(destination);
		List<Field<?>> fields = new ArrayList<>();
		ObjectWalker walker = new ObjectWalker(source, (item) -> {

			//add field to destination
			fields.add(new Field<Object>(item.getPath(), item.getValue()));

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
						item.getField().getName(),
						newValue});
			}

		});
		walker.walk();
		destination.setFields(fields);
		destination.setId(source.getId());
	}

	private String key(Field<?> src) {
		return src.getName();
	}

}
