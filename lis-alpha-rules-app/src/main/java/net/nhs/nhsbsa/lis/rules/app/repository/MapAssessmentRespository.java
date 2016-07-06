package net.nhs.nhsbsa.lis.rules.app.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

@Repository
public class MapAssessmentRespository implements IAssessmentRespository {

	Map<String, Assessment> store = new HashMap<>();
	
	@Override
	public long count() {
		return store.size();
	}

	@Override
	public void delete(String id) {
		store.remove(id);
	}

	@Override
	public void delete(Assessment assessment) {
		store.remove(assessment.getId());
	}

	@Override
	public void delete(Iterable<? extends Assessment> assessments) {
		for (Assessment assessment : assessments) {
			delete(assessment);
		}
	}

	@Override
	public void deleteAll() {
		store.clear();
	}

	@Override
	public boolean exists(String id) {
		return store.containsKey(id);
	}

	@Override
	public Iterable<Assessment> findAll() {
		return store.values();
	}

	@Override
	public Iterable<Assessment> findAll(Iterable<String> ids) {
		List<Assessment> result = new ArrayList<>();
		for (String id : ids) {
			result.add(store.get(id));
		}
		return result;
	}

	@Override
	public Assessment findOne(String id) {
		return store.get(id);
	}

	@Override
	public <S extends Assessment> S save(S assessment) {
		if (assessment.getId() == null) {
			String id = UUID.randomUUID().toString();
			assessment.setId(id);
		}
		store.put(assessment.getId(), (Assessment)assessment);
		return assessment;
	}

	@Override
	public <S extends Assessment> Iterable<S> save(Iterable<S> Assessment) {
		return null;
	}

}
