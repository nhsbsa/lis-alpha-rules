package net.nhs.nhsbsa.lis.rules.app.service;

import java.util.Map;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class AssessmentRespository {

	Map<String, Assessment> cache;
	
	public Assessment get(String id) {
		
		return cache.get(id);
	}
	
	public Assessment set(String id, Assessment assessment) {
		
		return cache.get(id);
	}
}
