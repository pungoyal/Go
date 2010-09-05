package com.thoughtworks.go.web;

import java.io.InputStream;

import android.content.Context;

import com.thoughtworks.go.domain.Pipelines;
import com.thoughtworks.go.xml.FeedParser;

public class GoClient {
	public GoClient(Context context) {
	}

	public Pipelines getStatus(InputStream inputStream) {
		FeedParser feedParser = new FeedParser();
		return feedParser.parse(inputStream);
	}
}
