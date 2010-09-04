package com.thoughtworks.go.tests.mothers;

import com.thoughtworks.go.domain.Pipeline;

public class PipelineMother {
	public static Pipeline create() {
		return new Pipeline("convoy", "Success", "Success", "100", "2010-08-25T11:28:18",
				"http://10.12.1.65:8153/cruise/tab/stage/detail/convoy/2600/Build-Unit-Test/1");
	}
}
