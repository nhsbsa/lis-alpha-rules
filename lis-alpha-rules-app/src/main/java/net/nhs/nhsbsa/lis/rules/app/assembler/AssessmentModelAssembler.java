package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import uk.nhs.nhsbsa.rules.types.Field;

@Component
public class AssessmentModelAssembler implements IAssembler<AssessmentModel, AssessmentModel> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentModelAssembler.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public void map(AssessmentModel source, AssessmentModel destination) {
		
		if (source == null) {
			Assert.isNull(destination);
		} else {
			Assert.notNull(destination);
			
			//check src/dst fields length
			List<Field<?>> srcFields = source.getFields();
			Assert.notNull(srcFields);
			List<Field<?>> dstFields = destination.getFields();
			Assert.notNull(dstFields);
			Assert.isTrue(srcFields.size() == dstFields.size());

			//iterate over both lists
			Iterator<Field<?>> srcIter = srcFields.iterator();
			Iterator<Field<?>> dstIter = dstFields.iterator();
			while(srcIter.hasNext() && dstIter.hasNext()) {
				Field<?> src = srcIter.next();
				Field<?> dst = dstIter.next();
				if (!Objects.equals(src.getValue(), dst.getValue())) {
					LOGGER.info("Changing {} from {} to {}", new Object[]{
							dst.getName(),
							dst.getValue(),
							src.getValue()
					});
					((Field<Object>)dst).setValue(src.getValue());
				}
			}
			
		}
		
	}

}
