package com.example.contracttesting.orderservice;

import au.com.dius.pact.consumer.ConsumerPactBuilder;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslResponse;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.core.model.PactSpecVersion;
import au.com.dius.pact.core.model.RequestResponsePact;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.function.Function;


public class consumerBasedContractTesting {
    @Test
    public void createContract() throws MalformedURLException, JsonProcessingException {

        Function<PactDslWithProvider, PactDslResponse> pactBuilderFunction = builder -> builder
                .uponReceiving("Create contracts for sample service")
                .path("/api/orderStatus")
                .method("GET")
                .headers(Collections.singletonMap("Content-Type", "application/json"))
                /*.body(newJsonBody(body -> body
                                .stringType("ApplicationID")
                                .stringType("ApplicationVersion")
                                .stringType("ArrangementNumber")
                        ).build()
                )*/
                .willRespondWith()
                .status(200)
                .body(new PactDslJsonBody()
                        .stringType("order_description")
                        .stringType("order_status")
                        .numberType("order_id")
                        .booleanType("special_order")
                        .stringType("customerId")
                );
        generatePact("customerservice", "orderservice", pactBuilderFunction);
    }

    protected RequestResponsePact generatePact(String consumer, String provider,
                                               Function<PactDslWithProvider, PactDslResponse> pactBuilderFunction) {
        PactDslWithProvider builder = new PactDslWithProvider(ConsumerPactBuilder.consumer(consumer), provider);
        au.com.dius.pact.core.model.RequestResponsePact pact = pactBuilderFunction.apply(builder).toPact();
        String pactDir = Paths.get("target/pacts").toAbsolutePath().toString();
        pact.write(pactDir, PactSpecVersion.V3);
        return pact;
    }

}
