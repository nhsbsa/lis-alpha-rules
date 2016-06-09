package net.nhs.nhsbsa.lis.rules.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RestEndpointBuilderTest {

	private static final String RESOURCES_URI = "/resources";
	private static final String ID = "/{id}";

	private RestEndpointBuilder builder;
	
	@Before
	public void setup() {
		builder = new RestEndpointBuilder(RESOURCES_URI);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNull() {
		new RestEndpointBuilder(null);
	}

	@Test
	public void testBaseUriForGetResources() {
		assertEquals(RESOURCES_URI, builder.withGetResource(null).getGetResourceUri());
	}
	@Test
	public void testBaseUriForListResources() {
		assertEquals(RESOURCES_URI, builder.withListResources(null).getListResourcesUri());
	}
	@Test
	public void testBaseUriForPostResources() {
		assertEquals(RESOURCES_URI, builder.withPostResource(null).getPostResourceUri());
	}
	@Test
	public void testBaseUriForPutResources() {
		assertEquals(RESOURCES_URI, builder.withPutResource(null).getPutResourceUri());
	}
	@Test
	public void testBaseUriForDeleteResources() {
		assertEquals(RESOURCES_URI, builder.withDeleteResource(null).getDeleteResourceUri());
	}

	@Test
	public void testUriForGetResources() {
		assertEquals(RESOURCES_URI + ID, builder.withGetResource(ID).getGetResourceUri());
	}
	@Test
	public void testUriForListResources() {
		assertEquals(RESOURCES_URI + ID, builder.withListResources(ID).getListResourcesUri());
	}
	@Test
	public void testUriForPostResources() {
		assertEquals(RESOURCES_URI + ID, builder.withPostResource(ID).getPostResourceUri());
	}
	@Test
	public void testUriForPutResources() {
		assertEquals(RESOURCES_URI + ID, builder.withPutResource(ID).getPutResourceUri());
	}
	@Test
	public void testUriForDeleteResources() {
		assertEquals(RESOURCES_URI + ID, builder.withDeleteResource(ID).getDeleteResourceUri());
	}

}
