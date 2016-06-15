package net.nhs.nhsbsa.lis.rules.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.nhs.nhsbsa.lis.rules.app.assembler.IAssemblerService;
import net.nhs.nhsbsa.lis.rules.app.exception.ResourceNotFoundException;
import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import net.nhs.nhsbsa.lis.rules.app.repository.IAssessmentRespository;
import net.nhs.nhsbsa.lis.rules.client.IAssessmentRestClient;
import uk.nhs.nhsbsa.rules.types.Field;

@Service
public class AssessmentService implements IAssessmentService {

	@Autowired
	private IAssessmentRespository assessmentRespository;
	
	@Autowired
	private IAssemblerService assembler;
	
	@Autowired
	private IAssessmentRestClient assessmentRestClient;

	@Override
	public Iterable<AssessmentModel> list() {

		return assessmentRespository.findAll();
	}

	@Override
	public AssessmentModel get(String id) {
		AssessmentModel result = assessmentRespository.findOne(id);
		if (result == null) {
			throw new ResourceNotFoundException();
		}
		return result;
	}

	@Override
	public AssessmentModel create() {
		
		assessmentRestClient.post(); 
    	AssessmentModel result = new AssessmentModel();
        List<Field<?>> fields = Arrays.asList(
        		new Field<String>("forenames", "Bob"),
        		new Field<String>("surname", "Builder")
        		);
        result.setFields(fields);
		return assessmentRespository.save(result);
	}

	@Override
	public AssessmentModel update(String id, AssessmentModel model) {
		
		AssessmentModel persisted = assessmentRespository.findOne(id);
		assembler.map(model, persisted);
		assessmentRespository.save(persisted);
		return persisted;
	}
}
