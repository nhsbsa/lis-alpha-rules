package uk.nhs.nhsbsa.lis.rules.v1.builder;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.BillPersonaTestData;

public class AssessmentBuilderTest {
	
	BillPersonaTestData testData;

	@Test
	public void testNotNull() {

		LisApplicationBuilder builder = new LisApplicationBuilder();
		assertNotNull(builder.getInstance());
	}

	@Test
	public void testAddressBuilderNotNull() {

		LisApplicationBuilder b = new LisApplicationBuilder();
		AddressBuilder ab = b.withAddress();
		assertNotNull(ab);
	}

}
