package com.thoughtworks.go.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.thoughtworks.go.domain.Pipelines;
import com.thoughtworks.go.domain.factories.PipelineFactory;

public class TrayFeedHandler extends DefaultHandler {
	private static final String PROJECT = "Project";
	private PipelineFactory factory;

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		factory = new PipelineFactory();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);

		if (localName.equalsIgnoreCase(PROJECT)) {
			factory.parseAndAdd(attributes);
		}
	}

	public Pipelines getResults() {
		return factory.getPipelines();
	}
}
