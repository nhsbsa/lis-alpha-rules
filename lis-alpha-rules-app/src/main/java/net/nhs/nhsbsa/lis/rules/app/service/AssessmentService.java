package net.nhs.nhsbsa.lis.rules.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.nhs.nhsbsa.lis.rules.app.assembler.IAssemblerService;
import net.nhs.nhsbsa.lis.rules.app.exception.ResourceNotFoundException;
import net.nhs.nhsbsa.lis.rules.app.repository.IAssessmentRespository;
import net.nhs.nhsbsa.lis.rules.client.IAssessmentRestClient;
import uk.nhs.nhsbsa.rules.model.rules.Assessment;

@Service
public class AssessmentService implements IAssessmentService {

	@Autowired
	private IAssessmentRespository assessmentRespository;
	
	@Autowired
	private IAssemblerService assembler;
	
	@Autowired
	private IAssessmentRestClient assessmentRestClient;

	@Override
	public Iterable<Assessment> list() {

		return assessmentRespository.findAll();
	}

	@Override
	public Assessment get(String id) {
		Assessment result = assessmentRespository.findOne(id);
		if (result == null) {
			throw new ResourceNotFoundException();
		}
		return result;
	}

	@Override
	public Assessment create() {
	
		Assessment assessment = assessmentRestClient.post(null);
		Assessment result = assessmentRespository.save(assessment);
		return result;
	}

	@Override
	public Assessment update(String id, Assessment updated) {
		
		Assessment existing = assessmentRespository.findOne(id);
		assembler.map(updated, existing);
		Assessment result = assessmentRestClient.put(id, existing);
		result = assessmentRespository.save(result);
		return result;
	}

}
