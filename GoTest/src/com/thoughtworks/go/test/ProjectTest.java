package com.thoughtworks.go.test;

import junit.framework.Assert;
import android.test.AndroidTestCase;

public class ProjectTest extends AndroidTestCase {
	public void testSomething() throws Throwable {
		Assert.assertTrue(1 + 1 == 2);
	}

	public void testSomethingElse() throws Throwable {
		Assert.assertFalse(1 + 1 == 3);
	}
}
