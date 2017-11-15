package com.btx.service.callback;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component("sendReturnCallback")
public class SendReturnCallback implements RabbitTemplate.ReturnCallback {

    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("Returned replyText："+replyText);
        System.out.println("Returned exchange："+exchange);
        System.out.println("Returned routingKey："+routingKey);
        String msgJson  = new String(message.getBody());
        System.out.println("Returned Message："+msgJson);
    }
}
