package com.example.camelDemo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DemoRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("file:C:/a/a")
            .to("file:C:/a/b")
        .end();
    }
}
