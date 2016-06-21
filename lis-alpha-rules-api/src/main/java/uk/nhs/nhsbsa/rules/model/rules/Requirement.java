package uk.nhs.nhsbsa.rules.model.rules;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Requirement {

	private static final Logger LOGGER = LoggerFactory.getLogger(Requirement.class);
	
	private Set<String> includes = new HashSet<>(); 
	private Set<String> excludes = new HashSet<>();

	public void include(String path) {
		includes.add(path);
	}

	public void exclude(String path) {
		excludes.add(path);
	}
	
	public boolean isRequired(String path) {
		
		int includedDistance = distance(includes, path, 0);
		if (includedDistance != -1) {
			int excludedDistance = distance(excludes, path, 0);
			if (excludedDistance != -1) {
				return includedDistance < excludedDistance;
			} else
				return true;
		}
		return false;
	}
	
	private int distance(Set<String> paths, String path, int d) {
		if (paths.contains(path)) {
			LOGGER.info("Found path {} after {} hops", path, d);
			return d;
		}
		int index = path.lastIndexOf('.');
		if (index != -1) {
			String parent = path.substring(0, index);
			return distance(paths, parent, d + 1);
		}
		return -1;
	}

	public Set<String> getIncludes() {
		return includes;
	}

	public void setIncludes(Set<String> includes) {
		this.includes = includes;
	}

	public Set<String> getExcludes() {
		return excludes;
	}

	public void setExcludes(Set<String> excludes) {
		this.excludes = excludes;
	}

}
