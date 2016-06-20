package org.springframework.boot.devtools.settings;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class SpringBootDevtoolsRestartClassloaderTest {

	@Test
	public void testDozer() throws MalformedURLException {
		
		URL dozer = new URL("file:/C:/Users/pattu/.m2/repository/net/sf/dozer/dozer/5.5.1/dozer-5.5.1.jar");
		
		DevToolsSettings settings = DevToolsSettings.get();
		
		assertTrue(settings.isRestartInclude(dozer));
	}

}
