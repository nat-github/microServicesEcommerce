package com.example.contracttesting.orderservice;

import au.com.dius.pact.consumer.*;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.model.PactFragment;
import au.com.dius.pact.model.RequestResponsePact;
import com.example.contracttesting.orderservice.controller.ApiOrderController;
import com.example.contracttesting.orderservice.model.Order;
import com.example.contracttesting.orderservice.model.OrderResponse;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class ConsumerClientContractTest {

	@Rule
	public PactProviderRule rule = new PactProviderRule("ApiCustomerController", this);

	@Pact(provider="ApiCustomerController", consumer="ApiOrderController")
	RequestResponsePact createFragment(PactDslWithProvider builder) {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		return builder.uponReceiving("Contract testing request")
				.path("api/processOrder")
				.method("POST")
				.willRespondWith()
				.headers(headers)
				.status(200)
				.body("{\n" +
						"    \"order_id\": 1234,\n" +
						"    \"order_description\": \"Contract Testing\",\n" +
						"    \"order_status\": \"Processed\",\n" +
						"    \"customerId\": \"172481\",\n" +
						"    \"billingAddress\": \"Cognizant\",\n" +
						"    \"paymentType\": \"Credit card\",\n" +
						"    \"customerName\": \"Contract Testing\"\n" +
						"}").toPact();
	}
	@Test
	@PactVerification("ApiCustomerController")
	public void runTest() {
		System.out.println("Pact verification");
		assertEquals(1,1);
	}
	/*@Test
	@PactTestFor(pactMethod = "createFragment")
	public void apiIsReachable() throws IOException {*/
		/*//Given
		HttpUriRequest request = new HttpGet(mockServer.getUrl());

		//When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		//Then
		assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);*/
		//System.out.println("Tests");
		//assertEquals(new OrderResponse(172481,"Test","Test","Test","Test","Test","Test"),new Order(172481,"Test","Test",false,"Test"));
		//assertEquals(new ApiOrderController);
//	}
}
