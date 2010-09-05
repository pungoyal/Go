package com.thoughtworks.go.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;

import com.thoughtworks.go.domain.Pipelines;
import com.thoughtworks.go.exceptions.ServerUnreachableException;
import com.thoughtworks.go.exceptions.XMLParseException;
import com.thoughtworks.go.xml.FeedParser;

public class GoClient {
	private String server;

	public GoClient(Context context) {
//		SharedPreferences preferences = context.getSharedPreferences(Constants.APPLICATION_KEY, 0);
		// server = preferences.getString(Constants.SERVER_KEY, "10.0.2.2");

		server = "10.0.2.2:4567";
	}

	public Pipelines getStatus(InputStream inputStream) throws ServerUnreachableException, XMLParseException {
		try {
			String cctray = getResponseXML();
			FeedParser feedParser = new FeedParser();
			return feedParser.parse(cctray);

		} catch (IOException e) {
			throw new ServerUnreachableException(e, server);
		}
	}

	private String getResponseXML() throws IOException {
		StringBuffer buffer = new StringBuffer();

		HttpURLConnection connection = null;
		URL u = new URL("http://" + server + "/cctray.xml");
		connection = (HttpURLConnection) u.openConnection();
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);

		connection.connect();
		InputStream inputStream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		String line = null;
		String line_separator = System.getProperty("line.separator");
		while ((line = reader.readLine()) != null) {
			buffer.append(line + line_separator);
		}
		connection.disconnect();
		return buffer.toString();
	}
}
