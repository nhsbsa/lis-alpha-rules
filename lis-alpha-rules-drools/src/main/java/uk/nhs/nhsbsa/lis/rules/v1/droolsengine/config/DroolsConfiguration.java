package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.config;

import java.io.File;
import java.io.IOException;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderConfiguration;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.builder.conf.DumpDirOption;
import org.kie.internal.io.ResourceFactory;
import org.kie.spring.KModuleBeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class DroolsConfiguration {

	private static final String RULES_PATH = "rules/";

	private KieFileSystem kieFileSystem;
	
	private KieContainer kieContainer;
	
	private KieServices kieServices;
	
	@Bean
	public KieFileSystem kieFileSystem() throws IOException {
		if (kieFileSystem == null) {
			kieFileSystem = getKieServices().newKieFileSystem();
		    for (Resource file : getRuleFiles()) {
		        kieFileSystem.write(ResourceFactory.newUrlResource(file.getURL()));
		    }
		}
	    return kieFileSystem;
	}

	/**
	 * Use Spring pattern matching to retrieve Rules files.
	 */
	private Resource[] getRuleFiles() throws IOException {
	    ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
	    return resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "**/*.*");
	}

	@Bean
	public KieContainer kieContainer() throws IOException {
		
		if (kieContainer == null) {
		    final KieRepository kieRepository = getKieServices().getRepository();
	
		    kieRepository.addKieModule(new KieModule() {
		        public ReleaseId getReleaseId() {
		            return kieRepository.getDefaultReleaseId();
		        }
		    });

//		    System.setProperty("drools.dump.dir", "/tmp/drools-generated-sources");
		    KieBuilder kieBuilder = getKieServices().newKieBuilder(kieFileSystem()); 
		    kieBuilder.buildAll();
	
		    kieContainer = getKieServices().newKieContainer(kieRepository.getDefaultReleaseId());
		}
		return kieContainer;
	}

	@Bean
	public KieServices getKieServices() {
		if (kieServices == null) {
			kieServices = KieServices.Factory.get();
		}
		return kieServices;
	}

	@Bean
	public KieBase kieBase() throws IOException {
	    return kieContainer().getKieBase();
	}

	@Bean
	public KModuleBeanFactoryPostProcessor kiePostProcessor() {
	    return new KModuleBeanFactoryPostProcessor();
	}
}
