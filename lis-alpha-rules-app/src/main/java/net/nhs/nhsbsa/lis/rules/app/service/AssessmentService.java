package net.nhs.nhsbsa.lis.rules.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.nhs.nhsbsa.lis.rules.app.assembler.IAssemblerService;
import net.nhs.nhsbsa.lis.rules.app.exception.ResourceNotFoundException;
import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
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
	public AssessmentModel get(String id) {
		Assessment assessment = assessmentRespository.findOne(id);
		if (assessment == null) {
			throw new ResourceNotFoundException();
		}
    	AssessmentModel result = new AssessmentModel();
    	assembler.map(assessment, result);
		return result;
	}

	@Override
	public AssessmentModel create() {
		
		Assessment assessment = assessmentRestClient.get(null);
		assessment = assessmentRespository.save(assessment);
    	AssessmentModel result = new AssessmentModel();
    	assembler.map(assessment, result);
		return result;
	}

	@Override
	public AssessmentModel update(String id, AssessmentModel model) {
		
		Assessment assessment = assessmentRespository.findOne(id);
		assembler.map(model, assessment);
		assessmentRestClient.put(id, assessment);
		assessmentRespository.save(assessment);
		assembler.map(assessment, model);
		return model;
	}
}
