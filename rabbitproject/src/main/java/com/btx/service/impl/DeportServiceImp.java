package com.btx.service.impl;

import com.btx.domain.GoodTransferVo;
import com.btx.service.IDepotService;
import com.google.gson.Gson;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("deportServiceImp")
public class DeportServiceImp implements IDepotService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    public boolean saveDepot(GoodTransferVo goodTransferVo) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(goodTransferVo);
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
        rabbitTemplate.send("depot-amount-exchange","amount.depot",new Message(jsonStr.getBytes(),messageProperties));
        return true;
    }
}
