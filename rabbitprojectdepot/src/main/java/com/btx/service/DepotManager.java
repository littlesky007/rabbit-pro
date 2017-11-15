package com.btx.service;

import com.btx.domain.GoodTransferVo;
import org.springframework.stereotype.Service;

@Service
public class DepotManager {

    public void operDepot(GoodTransferVo goodTransferVo)
    {
        System.out.println("库存操作开始");
        try
        {
            Thread.currentThread().sleep(1000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        System.out.println("库存操作完成");
    }
}
