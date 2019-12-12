package com.example.camelDemo.route;

import com.example.camelDemo.mnt.MntModel;
import com.example.camelDemo.model.JsonModel;
import com.example.camelDemo.processor.ChangeJsonToMnt;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.DataFormatDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoRoute3 extends RouteBuilder {

    @Autowired
    private ChangeJsonToMnt changeJsonToMnt;

    DataFormatDefinition dataFormatDefinition = new DataFormatDefinition(new JacksonDataFormat(JsonModel.class));
    BindyCsvDataFormat bindy = new BindyCsvDataFormat(MntModel.class);

    @Override
    public void configure() {
        from("file:C:/a/d")
            .log("1: " + body())
            .unmarshal(dataFormatDefinition)
            .log("2: " + body())
            .process(changeJsonToMnt)
            .marshal(bindy)
            .log("3: " + body())
            .to("direct:testEndpoint")
            .end();
    }
}
