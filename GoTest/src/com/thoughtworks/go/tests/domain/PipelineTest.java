package com.thoughtworks.go.tests.domain;

import android.test.AndroidTestCase;

import com.thoughtworks.go.domain.Pipeline;
import com.thoughtworks.go.tests.mothers.PipelineMother;

public class PipelineTest extends AndroidTestCase {
	private Pipeline pipeline;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		pipeline = PipelineMother.create();
	}
	
	public void testPipelineConstruction() {
		pipeline.toString();
	}
}
