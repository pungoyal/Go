package com.thoughtworks.go.xml;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.util.Log;

import com.thoughtworks.go.domain.Pipelines;

public class FeedParser {
	public Pipelines parse(InputStream cctray) {
		Pipelines projects = new Pipelines();
		try {
			InputSource inputSource = new InputSource(cctray);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			XMLReader xmlreader = parser.getXMLReader();

			TrayFeedHandler feedHandler = new TrayFeedHandler();
			xmlreader.setContentHandler(feedHandler);
			xmlreader.parse(inputSource);
			projects = feedHandler.getResults();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Log.d("FeedParser", "Parsed " + projects.size() + " projects.");
		return projects;
	}
}
