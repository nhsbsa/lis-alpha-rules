package uk.nhs.nhsbsa.lis.rules.v1.builder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.BillPersonaTestData;

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
		AddressBuilder ab = b.withAddress(BillPersonaTestData.testAddress);
		assertNotNull(ab);
	}

	@Test
	public void testAddressBuilderFieldBuilder() {

		LisApplicationBuilder b = new LisApplicationBuilder();
		AddressBuilder ab = b.withAddress(BillPersonaTestData.testAddress);
		assertNotNull(ab.getFieldBuilder());
		assertNotNull(ab.getField());
		assertSame(ab.getInstance(), ab.getField().getValue());
	}

}
