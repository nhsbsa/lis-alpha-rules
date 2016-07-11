package net.nhs.nhsbsa.lis.rules.app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.nhs.nhsbsa.lis.rules.app.assembler.IAssemblerService;
import net.nhs.nhsbsa.lis.rules.app.exception.ResourceNotFoundException;
import net.nhs.nhsbsa.lis.rules.app.repository.IAssessmentRespository;
import net.nhs.nhsbsa.lis.rules.client.IAssessmentRestClient;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.LisApplication;

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
	
		LisApplication application = new LisApplication();
		application.setClaimDate(LocalDate.now());
		Assessment assessment = assessmentRestClient.post(application);
		Assessment result = assessmentRespository.save(assessment);
		return result;
	}

	@Override
	public Assessment update(String id, Assessment updated) {
		
		Assessment existing = assessmentRespository.findOne(id);
		if (existing == null) {
			existing = create();
			updated.setId(existing.getId());
		}
		assembler.map(updated, existing);
		Assessment result = assessmentRestClient.put(id, existing);
		result = assessmentRespository.save(result);
		return result;
	}

	@Override
	public void delete(String id) {
		Assessment result = assessmentRespository.findOne(id);
		if (result == null) {
			throw new ResourceNotFoundException();
		}
		assessmentRespository.delete(id);
	}

}
