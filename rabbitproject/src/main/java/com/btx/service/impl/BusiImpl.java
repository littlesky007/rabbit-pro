package com.btx.service.impl;

import com.btx.domain.GoodTransferVo;
import com.btx.domain.Order;
import com.btx.service.IBusi;
import com.btx.service.IDepotService;
import com.btx.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusiImpl implements IBusi{
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IDepotService iDepotService;
    public boolean dealOrder(Order order) {
        iOrderService.addOrder(order);
        GoodTransferVo vo = new GoodTransferVo();
        vo.setGoodsId(order.getOrderId());
        vo.setChangeAmount(order.getNumber());
        iDepotService.saveDepot(vo);
        return true;
    }
}
