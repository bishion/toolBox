package com.bizi.study.service;

import com.bizi.study.model.uniorder.OrderInfo;
import com.bizi.study.model.uniorder.SubOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring/application*.xml")
public class OrderServiceTest {

    @Resource
    private OrderService orderService;
    @Test
    public void testSave() throws Exception {

        SubOrder subOrder = new SubOrder();
        subOrder.setName("name");
        subOrder.setId(123l);
        subOrder.setSubTotal(123.333f);

        Set<SubOrder> subOrderSet = new HashSet<SubOrder>();
        subOrderSet.add(subOrder);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setAmount(1223.33f);
        orderInfo.setBuyDate(new Date());
        orderInfo.setBuyer("buyer");
        orderInfo.setOrderNo(1212);
        orderInfo.setSubOrderSet(subOrderSet);
        subOrder.setOrderInfo(orderInfo);

        orderService.save(orderInfo);
    }
}