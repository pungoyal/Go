package com.thoughtworks.go.domain.factories;

import org.xml.sax.Attributes;

import com.thoughtworks.go.domain.Pipeline;

public class PipelineFactory {

	public Pipeline createWith(Attributes attributes) {
		String name = attributes.getValue("name");
		String status = attributes.getValue("activity");
		String lastBuildStatus = attributes.getValue("lastBuildStatus");
		String lastBuildLabel = attributes.getValue("lastBuildLabel");
		String lastBuildTime = attributes.getValue("lastBuildTime");
		String url = attributes.getValue("webUrl");

		return new Pipeline(name, status, lastBuildStatus, lastBuildLabel, lastBuildTime, url);
	}

}
