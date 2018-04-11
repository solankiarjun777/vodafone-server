package com.celfocus.online.interview.topups;



import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.celfocus.online.interview.topups.controllers.TopUpsController;
import com.celfocus.online.interview.topups.dto.TopupResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TopUpsController.class, secure = false)
public class TopupsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAccountHolder() throws Exception {
		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/topups/accounts").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		String expected = "[{\"id\":\"12345\",\"name\":\"Arjun's Family\",\"number\":\"9737363736\"},{\"id\":\"54321\",\"name\":\"Uday's Family\",\"number\":\"\"}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void testTopupRecharge() throws Exception {
		
		String data = "{\"conversionID\":\"5555\",\"financialAccount\":\"12345\",\"phoneNumber\":\"89452378\",\"amount\":\"15\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/topups/recharge")
				.accept(MediaType.APPLICATION_JSON).content(data)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		TopupResponse res = getTopupResponseFromJson(response);
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
		Assert.assertEquals("Success", res.getCode());
		

	}
	
	@Test
	public void testTopupWithoutSubscriberNumber() throws Exception {
		
		String data = "{\"conversionID\":\"5555\",\"financialAccount\":\"54321\",\"phoneNumber\":\"89452378\",\"amount\":\"15\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/topups/recharge")
				.accept(MediaType.APPLICATION_JSON).content(data)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		TopupResponse res = getTopupResponseFromJson(response);
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
		Assert.assertEquals("Error", res.getCode());
		

	}
	
	@Test
	public void testTopupWithoutSubscriberNumber1() throws Exception {
		
		String data = "{\"conversionID\":\"5555\",\"financialAccount\":\"54321\",\"phoneNumber\":\"89452378\",\"amount\":\"15\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/topups/recharge")
				.accept(MediaType.APPLICATION_JSON).content(data)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		TopupResponse res = getTopupResponseFromJson(response);
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
		Assert.assertEquals("Error", res.getCode());
		

	}

	private TopupResponse getTopupResponseFromJson(MockHttpServletResponse response)
			throws IOException, JsonParseException, JsonMappingException, UnsupportedEncodingException {
		ObjectMapper mapper = new ObjectMapper();
		TopupResponse res = mapper.readValue(response.getContentAsString(), TopupResponse.class);
		return res;
	}


}

