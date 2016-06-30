package net.nhs.nhsbsa.lis.rules.app.assembler;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.builder.LisApplicationBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.builder.PersonBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class AssessmentToAssessmentAssemblerTest {

	AssessmentToAssessmentAssembler assembler;
	
	@Before
	public void setup() {
		assembler = new AssessmentToAssessmentAssembler();
		assembler.setDozer(new AssemblerConfiguration().dozerMapper());
	}
	
	@Test
	public void test() {

		LisApplicationBuilder builder = new LisApplicationBuilder();
		builder.withAddress()
			.withAddressLines("", "", "");
		PersonBuilder applicant = builder.withApplicant();
		applicant
			.withName();
		applicant.withBenefits().add();
		Assessment input = new Assessment(null, builder.getInstance());
		Assessment output = new Assessment();

		assembler.map(input, output);
		assertEquals(1, output.getApplication().getApplicant().getBenefits().size());

		assembler.map(input, output);
		
		assertEquals(1, output.getApplication().getApplicant().getBenefits().size());
	}

}
