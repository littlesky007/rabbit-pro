package com.btx.service.callback;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

@Component("confirmCallback")
public class ConfirmCallback implements RabbitTemplate.ConfirmCallback {
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if(ack)
        {
            System.out.println("消息确认发送给mq成功");
        }
        else
        {
            System.out.println("发送失败，请重新发送");
        }
    }
}
