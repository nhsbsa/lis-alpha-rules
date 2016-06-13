package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssemblerConfiguration {

	@Bean(name = "dozerMapper")
	public DozerBeanMapper dozerMapper() {

		List<String> mappingFiles = Arrays.asList("assembler/dozer-mapping.xml");
		DozerBeanMapper dozerBean = new DozerBeanMapper();
		dozerBean.setMappingFiles(mappingFiles);
		return dozerBean;
	}
}
