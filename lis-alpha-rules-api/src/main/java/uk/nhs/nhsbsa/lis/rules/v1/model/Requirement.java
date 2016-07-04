package uk.nhs.nhsbsa.lis.rules.v1.model;

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
		
		boolean result = false;
		int includedDistance = distance("include", includes, path, 0);
		if (includedDistance != -1) {
			int excludedDistance = distance("exclude", excludes, path, 0);
			if (excludedDistance != -1) {
				result = includedDistance < excludedDistance;
			} else
				result = true;
		}
		LOGGER.info("{} {} required", path, (result ? "is":"isn't"));
		return result;
	}
	
	private int distance(String msg, Set<String> paths, String path, int d) {
		if (paths.contains(path)) {
			LOGGER.info("Found {} path {} after {} hops", new Object[]{
					msg, path, d
			});
			return d;
		}
		int index = lastIndex(path);
		if (index != -1) {
			String parent = path.substring(0, index);
			return distance(msg, paths, parent, d + 1);
		}
		return -1;
	}

	private int lastIndex(String path) {
		int index = -1;
		int lastDot = path.lastIndexOf('.');
		int lastBracket = path.lastIndexOf('[');
		if (lastBracket > lastDot) {
			index = lastBracket;
		} else {
			index = lastDot;
		}
		return index;
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
