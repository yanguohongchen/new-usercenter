package com.sea.test.framework;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class UserActionTest extends TestBaseAction
{
	@Test
	public void getUser() throws Exception
	{
		Map<String,String> para = new HashMap<String,String>();
		testRequest("/getUser", para);
	}

}
