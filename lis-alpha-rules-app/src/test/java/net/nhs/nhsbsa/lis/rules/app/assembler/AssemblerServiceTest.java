package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.builder.LisApplicationBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class AssemblerServiceTest {

	private AssemblerService service;
	
	private Assessment assessment;
	
	@Before
	public void setup() {
		
		service = new AssemblerService();
		AssessmentToAssessmentAssembler assembler = new AssessmentToAssessmentAssembler();
		assembler.setDozer(new AssemblerConfiguration().dozerMapper());
		service.setAssemblers(Arrays.asList(new IAssembler[]{
			assembler
		}));
		
		LisApplicationBuilder builder = new LisApplicationBuilder();
		builder.withAddress().withPostcode("ne1 1en");
		assessment = new Assessment("42", builder.getInstance());
	}
	
	@Test
	public void AssessmentToAssessmentAssembler() {

		service.map(assessment, assessment);
		System.out.println(assessment);
	}

}
