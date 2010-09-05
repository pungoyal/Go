package com.thoughtworks.go.tests.domain;

import java.util.Date;

import android.test.AndroidTestCase;

import com.thoughtworks.go.domain.BuildActivity;
import com.thoughtworks.go.domain.BuildStatus;
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
		assertEquals("convoy", pipeline.getName());
		assertEquals(BuildActivity.SLEEPING, pipeline.getActivity());
		assertEquals(BuildStatus.SUCCESS, pipeline.getLastBuildStatus());
		assertEquals(100, pipeline.getLastBuildLabel());
		assertEquals(new Date(2010, 1, 1, 10, 10, 10), pipeline.getLastBuildTime());

	}
}
