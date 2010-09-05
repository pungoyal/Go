package com.thoughtworks.go.domain;

import java.util.Date;

public class Pipeline {

	private final String name;
	private final BuildActivity activity;
	private final BuildStatus lastBuildStatus;
	private final int lastBuildLabel;
	private final Date lastBuildTime;
	private final String url;

	public Pipeline(String name, BuildActivity activity, BuildStatus lastBuildStatus, int lastBuildLabel,
			Date lastBuildTime, String url) {
		this.name = name;
		this.activity = activity;
		this.lastBuildStatus = lastBuildStatus;
		this.lastBuildLabel = lastBuildLabel;
		this.lastBuildTime = lastBuildTime;
		this.url = url;
	}

	@Override
	public String toString() {
		return getName() + ":" + getActivity() + ":" + getLastBuildStatus() + ":" + getLastBuildLabel() + ":"
				+ getLastBuildTime() + ":" + getUrl();
	}

	public String getName() {
		return name;
	}

	public BuildStatus getLastBuildStatus() {
		return lastBuildStatus;
	}

	public int getLastBuildLabel() {
		return lastBuildLabel;
	}

	public Date getLastBuildTime() {
		return lastBuildTime;
	}

	public String getUrl() {
		return url;
	}

	public BuildActivity getActivity() {
		return activity;
	}

	public long getId() {
		return 0L;
	}
}
