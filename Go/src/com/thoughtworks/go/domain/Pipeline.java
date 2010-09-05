package com.thoughtworks.go.domain;

import java.util.ArrayList;

public class Pipeline {
	private ArrayList<Stage> stages;
	private final String name;

	public Pipeline(String name) {
		this.name = name;
		this.stages = new ArrayList<Stage>();
	}

	public void addStage(Stage stage) {
		stages.add(stage);
	}

	public String getName() {
		return name;
	}

	public void addJobToStage(String stageName, Job job) {
		for (Stage stage : stages) {
			if (stage.getName().equals(stageName)) {
				stage.addJob(job);
			}
		}
	}

}
