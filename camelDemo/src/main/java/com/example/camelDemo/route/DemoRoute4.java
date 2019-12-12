package com.example.camelDemo.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DemoRoute4 extends RouteBuilder {

    @Override
    public void configure() {
        from("direct:testEndpoint")
            .routeId("testEndpoint")
            .setBody(simple(null))
            .setHeader(Exchange.HTTP_METHOD, constant("GET"))
            .to("http4://jsonplaceholder.typicode.com/posts")
            .log("response: " + body())
        .end();
    }
}
