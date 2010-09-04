package com.thoughtworks.go.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.thoughtworks.go.domain.Projects;
import com.thoughtworks.go.domain.factories.ProjectFactory;

public class TrayFeedHandler extends DefaultHandler {
	private static final String PROJECT = "Project";
	private Projects projects;
	private ProjectFactory factory;

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		projects = new Projects();
		factory = new ProjectFactory();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);

		if (localName.equalsIgnoreCase(PROJECT)) {
			projects.add(factory.createWith(attributes));
		}
	}

	public Projects getResults() {
		return projects;
	}
}
