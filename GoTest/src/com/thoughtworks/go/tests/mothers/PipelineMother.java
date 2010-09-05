package com.thoughtworks.go.tests.mothers;

import java.util.Date;

import com.thoughtworks.go.domain.BuildActivity;
import com.thoughtworks.go.domain.BuildStatus;
import com.thoughtworks.go.domain.Pipeline;

public class PipelineMother {
	public static Pipeline create() {
		return new Pipeline("convoy", BuildActivity.SLEEPING, BuildStatus.SUCCESS, 100,
				new Date(2010, 1, 1, 10, 10, 10),
				"http://10.12.1.65:8153/cruise/tab/stage/detail/convoy/2600/Build-Unit-Test/1");
	}
}
