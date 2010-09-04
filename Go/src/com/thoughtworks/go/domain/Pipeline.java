package com.thoughtworks.go.domain;

public class Pipeline {

	private final String name;
	private final String status;
	private final String lastBuildStatus;
	private final String lastBuildLabel;
	private final String lastBuildTime;
	private final String url;

	public Pipeline(String name, String status, String lastBuildStatus, String lastBuildLabel, String lastBuildTime,
			String url) {
		this.name = name;
		this.status = status;
		this.lastBuildStatus = lastBuildStatus;
		this.lastBuildLabel = lastBuildLabel;
		this.lastBuildTime = lastBuildTime;
		this.url = url;
	}

	@Override
	public String toString() {
		return name + ":" + status + ":" + lastBuildStatus + ":" + lastBuildLabel + ":" + lastBuildTime + ":" + url;
	}
}
