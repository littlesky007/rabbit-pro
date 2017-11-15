package com.btx.controller;

import com.btx.domain.Order;
import com.btx.service.IBusi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/myController")
public class MyController {

    @Autowired
    private IBusi iBusi;
    @RequestMapping("/dealOrder")
    public @ResponseBody Order dealOrder(Order order)
    {
        iBusi.dealOrder(order);
        return order;
    }

}
