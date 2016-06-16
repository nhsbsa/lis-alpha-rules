package uk.nhs.nhsbsa.lis.rules.v1.builder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class AssessmentBuilderTest {
	
	TestData testData;

	@Test
	public void testNotNull() {

		AssessmentBuilder builder = new AssessmentBuilder();
		assertNotNull(builder.getInstance());
	}

	@Test
	public void testAddressBuilderNotNull() {

		AssessmentBuilder b = new AssessmentBuilder();
		AddressBuilder ab = b.withAddress(TestData.testAddress);
		assertNotNull(ab);
	}

	@Test
	public void testAddressBuilderFieldBuilder() {

		AssessmentBuilder b = new AssessmentBuilder();
		AddressBuilder ab = b.withAddress(TestData.testAddress);
		assertNotNull(ab.getFieldBuilder());
		assertNotNull(ab.getField());
		assertSame(ab.getInstance(), ab.getField().getValue());
	}

}
