package com.btx.listener;

import com.btx.domain.GoodTransferVo;
import com.btx.service.DepotManager;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessDepot implements ChannelAwareMessageListener {
    @Autowired
    private DepotManager depotManager;
    public void onMessage(Message message, Channel channel)  {
        String msg = new String(message.getBody());
        try {
            try {
                System.out.println("收到的信息为：" + msg);
                GoodTransferVo goodTransferVo = new Gson().fromJson(msg, GoodTransferVo.class);
                depotManager.operDepot(goodTransferVo);
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (Exception e) {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
