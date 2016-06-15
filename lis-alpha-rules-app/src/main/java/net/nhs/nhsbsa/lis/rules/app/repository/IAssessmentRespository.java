package net.nhs.nhsbsa.lis.rules.app.repository;

import org.springframework.data.repository.CrudRepository;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public interface IAssessmentRespository extends CrudRepository<Assessment, String>{

}
