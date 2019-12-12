package com.example.camelDemo.processor;

import com.example.camelDemo.mnt.MntModel;
import com.example.camelDemo.model.JsonModel;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ChangeJsonToMnt implements Processor {

    @Override
    public void process(Exchange exchange) {
        JsonModel jsonModel = exchange.getIn().getBody(JsonModel.class);
        MntModel mntModel = new MntModel();
        mntModel.setId(jsonModel.getId());
        mntModel.setDescription(jsonModel.getDescription());
        exchange.getIn().setBody(mntModel);
    }
}
