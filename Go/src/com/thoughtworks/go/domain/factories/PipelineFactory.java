package com.thoughtworks.go.domain.factories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xml.sax.Attributes;

import com.thoughtworks.go.domain.BuildActivity;
import com.thoughtworks.go.domain.BuildStatus;
import com.thoughtworks.go.domain.Pipeline;

public class PipelineFactory {

	public Pipeline createWith(Attributes attributes) {
		String name = attributes.getValue("name");
		BuildActivity activity = BuildActivity.parse(attributes.getValue("activity"));
		BuildStatus lastBuildStatus = BuildStatus.parse(attributes.getValue("lastBuildStatus"));
		int lastBuildLabel = Integer.parseInt(attributes.getValue("lastBuildLabel"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-ddTHH:mm:ss");

		Date lastBuildTime;
		try {
			lastBuildTime = sdf.parse(attributes.getValue("lastBuildTime"));
		} catch (ParseException e) {
			e.printStackTrace();
			lastBuildTime = new Date();
		}

		String url = attributes.getValue("webUrl");

		return new Pipeline(name, activity, lastBuildStatus, lastBuildLabel, lastBuildTime, url);
	}

}
