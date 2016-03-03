package com.sea.test.framework;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class UserActionTest extends TestBaseAction
{
	@Test
	public void getUser() throws Exception
	{
		Map<String, String> para = new HashMap<String, String>();
		para.put("userName", "zhangsan7");
		para.put("password", "1111111");
		testLoginRequest("/login", para);
	}

	@Test
	public void asscessToken() throws Exception
	{
		Map<String, String> para = new HashMap<String, String>();
		para.put("userName", "zhangsan7");
		para.put("password", "1111111");
		testLoginRequest("/auth/asscessToken", para);
	}

}
