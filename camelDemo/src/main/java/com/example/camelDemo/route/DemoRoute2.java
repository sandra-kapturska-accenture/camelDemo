package com.example.camelDemo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DemoRoute2 extends RouteBuilder {

    @Override
    public void configure() {
        from("file:C:/a/b")
            .split(body().tokenize("\r\n")).streaming()
                .choice()
                    .when(body().isNotEqualTo("4"))
                    .to("file:C:/a/c?fileExist=append")
                .otherwise()
                    .log("Jest enter")
        .end();
    }
}
