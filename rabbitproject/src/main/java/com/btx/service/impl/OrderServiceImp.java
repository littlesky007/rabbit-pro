package com.btx.service.impl;

import com.btx.domain.Order;
import com.btx.service.IOrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImp implements IOrderService
{
    public boolean addOrder(Order order) {
        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
