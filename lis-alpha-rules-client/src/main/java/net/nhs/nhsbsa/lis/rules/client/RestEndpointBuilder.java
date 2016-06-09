package net.nhs.nhsbsa.lis.rules.client;

/**
 * Builder to specify and retrieve URIs for RESTful resource endpoint.
 */
public class RestEndpointBuilder {

	public String baseUri;
	
	public String listResourcesUri;
	
	public String getResourceUri;
	
	public String putResourceUri;
	
	public String postResourceUri;

	public String deleteResourceUri;

	public RestEndpointBuilder(String baseUri) {
		this.baseUri = baseUri;
	}
	
	public RestEndpointBuilder withListResources(String path) {
		listResourcesUri = appendPath(path);
		return this;
	}

	public RestEndpointBuilder withGetResource(String path) {
		getResourceUri = appendPath(path);
		return this;
	}
	
	public RestEndpointBuilder withPutResource(String path) {
		putResourceUri = appendPath(path);
		return this;
	}
	
	public RestEndpointBuilder withPostResource(String path) {
		postResourceUri = appendPath(path);
		return this;
	}

	public RestEndpointBuilder withDeleteResource(String path) {
		deleteResourceUri = appendPath(path);
		return this;
	}

	/**
	 * Safe append of paths that may be null.
	 * @param path
	 * @return
	 */
	private String appendPath(String path) {
		String result = null;
		if (path == null) {
			result = baseUri;
		} else {
			result = baseUri + path;
		}
		return result;
	}

	public String getBaseUri() {
		return baseUri;
	}

	public String getListResourcesUri() {
		return listResourcesUri;
	}

	public String getGetResourceUri() {
		return getResourceUri;
	}

	public String getPutResourceUri() {
		return putResourceUri;
	}

	public String getPostResourceUri() {
		return postResourceUri;
	}
	
}
