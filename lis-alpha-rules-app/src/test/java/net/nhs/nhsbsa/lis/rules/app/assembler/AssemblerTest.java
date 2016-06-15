package net.nhs.nhsbsa.lis.rules.app.assembler;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import uk.nhs.nhsbsa.rules.types.Field;

public class AssemblerTest {

	private AssessmentModelAssembler assembler = new AssessmentModelAssembler();
	
    private AssessmentModel fixture() {
    	AssessmentModel result = new AssessmentModel();
        List<Field<?>> fields = Arrays.asList(
        		new Field<String>("forename", "Bob"),
        		new Field<String>("surname", "Builder")
        		);
        result.setFields(fields);
        return result;
	}


	@Test
	public void testNulls() {
		assembler.map(null, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNullSource_error() {

		assembler.map(null, fixture());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNullDestination_error() {

		assembler.map(fixture(), null);
	}

	@Test
	public void testUnchanged() {

		AssessmentModel src = fixture();
		AssessmentModel dst = fixture();
		
		assembler.map(src, dst);
		
		assertEquals(src.getFields().get(0).getValue(), dst.getFields().get(0).getValue());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testChanged() {

		AssessmentModel src = fixture();
		AssessmentModel dst = fixture();
		
		//change dest
		String expected = "Terry";
		((Field<String>)src.getFields().get(0)).setValue(expected);
		assembler.map(src, dst);
		
		checkValue(expected, dst, 0);
	}
	
	private void checkValue(String expected, AssessmentModel actual, int index) {
		
		assertEquals(expected, actual.getFields().get(index).getValue());
	}

}
