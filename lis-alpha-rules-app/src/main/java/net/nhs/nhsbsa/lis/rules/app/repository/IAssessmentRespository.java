package net.nhs.nhsbsa.lis.rules.app.repository;

import org.springframework.data.repository.CrudRepository;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;

public interface IAssessmentRespository extends CrudRepository<AssessmentModel, String>{

}
