package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import uk.nhs.nhsbsa.lis.rules.v1.builder.LisApplicationBuilder;
import uk.nhs.nhsbsa.rules.model.rules.Assessment;
import uk.nhs.nhsbsa.rules.types.Field;

public class AssemblerServiceTest {

	private AssemblerService service;
	
	private Assessment assessment;
	private AssessmentModel assessmentModel;
	
	@Before
	public void setup() {
		
		service = new AssemblerService();
		service.setAssemblers(Arrays.asList(new IAssembler[]{
			new AssessmentModelToAssessmentAssembler(),
			new AssessmentToAssessmentModelAssembler()
		}));
		
		LisApplicationBuilder builder = new LisApplicationBuilder();
		builder.withAddress().withPostcode("ne1 1en");
		assessment = new Assessment("42", builder.getInstance());
		assessmentModel = new AssessmentModel();
		assessmentModel.setFields(Arrays.asList(new Field[]{
				new Field("name", "bob")
		}));
	}
	
	@Test
	public void AssessmentModelToAssessmentAssembler() {

		service.map(assessmentModel, assessment);
		System.out.println(assessment);
	}

	@Test
	public void testAssessmentToAssessmentModelAssembler() {

		service.map(assessment, assessmentModel);
		System.out.println(assessmentModel);
	}

}
