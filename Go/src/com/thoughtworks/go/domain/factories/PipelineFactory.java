package com.thoughtworks.go.domain.factories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xml.sax.Attributes;

import com.thoughtworks.go.domain.BuildActivity;
import com.thoughtworks.go.domain.BuildStatus;
import com.thoughtworks.go.domain.Constants;
import com.thoughtworks.go.domain.Job;
import com.thoughtworks.go.domain.Pipelines;
import com.thoughtworks.go.domain.Stage;

public class PipelineFactory {
	private Pipelines pipelines;

	public PipelineFactory() {
		pipelines = new Pipelines();
	}

	public void parseAndAdd(Attributes attributes) {
		BuildActivity activity = BuildActivity.parse(attributes.getValue("activity"));
		BuildStatus lastBuildStatus = BuildStatus.parse(attributes.getValue("lastBuildStatus"));
		String lastBuildLabel = attributes.getValue("lastBuildLabel");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
		Date lastBuildTime;
		try {
			lastBuildTime = sdf.parse(attributes.getValue("lastBuildTime"));
		} catch (ParseException e) {
			e.printStackTrace();
			lastBuildTime = new Date();
		}
		String url = attributes.getValue("webUrl");
		String name = attributes.getValue("name");

		String[] buildables = name.split(Constants.SEPARATOR);
		String pipelineName = buildables[0];
		String stageName = buildables[1];

		if (buildables.length == 2) {
			Stage stage = new Stage(stageName, activity, lastBuildStatus, lastBuildLabel, lastBuildTime, url);
			pipelines.addStage(pipelineName, stage);
		} else {
			Job job = new Job(buildables[2], activity, lastBuildStatus, lastBuildLabel, lastBuildTime, url);
			pipelines.addJobToStage(pipelineName, stageName, job);
		}
	}

	public Pipelines getPipelines() {
		return pipelines;
	}
}
