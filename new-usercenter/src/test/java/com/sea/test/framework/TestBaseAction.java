package com.sea.test.framework;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Map;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 控制层测试
 * 
 * @author sea
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-servlet.xml", "classpath:applicationContext.xml" })
@WebAppConfiguration
public abstract class TestBaseAction
{
	@Autowired
	private WebApplicationContext wac;

	public MockMvc mockMvc;

	@Before
	public void setup()
	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	public void testLoginRequest(String request, Map<String, String> params) throws Exception
	{
		MockHttpServletRequestBuilder tokenRequest = get("/auth/asscessToken");
		tokenRequest.param("client_id", "PHONECLIENT");
		tokenRequest.param("client_secret", "!sdfioaflksdxcijvn");
		if (params != null)
		{
			for (String param : params.keySet())
			{
				tokenRequest.param(param, params.get(param));
			}
		}
		MvcResult mvcResult = this.mockMvc.perform(tokenRequest).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		String json = response.getContentAsString();
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
		JsonElement data = jsonObject.get("data");
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = get(request);
		mockHttpServletRequestBuilder.param("client_id", "PHONECLIENT");
		mockHttpServletRequestBuilder.param("client_secret", "!sdfioaflksdxcijvn");
		mockHttpServletRequestBuilder.param("token", data.getAsString());
		if (params != null)
		{
			for (String param : params.keySet())
			{
				mockHttpServletRequestBuilder.param(param, params.get(param));
			}
		}
		mvcResult = this.mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
		System.out.println("==================结果=======================");
		response = mvcResult.getResponse();
		json = response.getContentAsString();
		System.out.println(json);
		jsonObject = new JsonParser().parse(json).getAsJsonObject();
		JsonElement code = jsonObject.get("status");
		System.out.println("=============================================");
		org.junit.Assert.assertNotEquals(500, code.getAsInt());

	}

	public void testTokenRequest(String request, Map<String, String> params) throws Exception
	{
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = get(request);

		mockHttpServletRequestBuilder.param("client_id", "PHONECLIENT");
		mockHttpServletRequestBuilder.param("client_secret", "!sdfioaflksdxcijvn");
		if (params != null)
		{
			for (String param : params.keySet())
			{
				mockHttpServletRequestBuilder.param(param, params.get(param));
			}
		}
		MvcResult mvcResult = this.mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
		System.out.println("==================结果=======================");
		MockHttpServletResponse response = mvcResult.getResponse();
		String json = response.getContentAsString();
		System.out.println(json);
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
		JsonElement code = jsonObject.get("status");
		System.out.println("=============================================");
		org.junit.Assert.assertNotEquals(500, code.getAsInt());
	}

	public void testRequest(String request, Map<String, String> params) throws Exception
	{
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = get(request);

		if (params != null)
		{
			for (String param : params.keySet())
			{
				mockHttpServletRequestBuilder.param(param, params.get(param));
			}
		}
		MvcResult mvcResult = this.mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
		System.out.println("==================结果=======================");
		MockHttpServletResponse response = mvcResult.getResponse();
		String json = response.getContentAsString();
		System.out.println(json);
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
		JsonElement code = jsonObject.get("status");
		System.out.println("=============================================");
		org.junit.Assert.assertNotEquals(500, code.getAsInt());
	}

	/**
	 * 返回状态码
	 * 
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String testRequestReturnResult(String request, Map<String, String> params) throws Exception
	{
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = get(request);
		if (params != null)
		{
			for (String param : params.keySet())
			{
				mockHttpServletRequestBuilder.param(param, params.get(param));
			}
		}
		MvcResult mvcResult = this.mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
		System.out.println("=================结果========================");
		MockHttpServletResponse response = mvcResult.getResponse();
		String json = response.getContentAsString();
		System.out.println(json);
		System.out.println("=========================================");
		return json;
	}

}
