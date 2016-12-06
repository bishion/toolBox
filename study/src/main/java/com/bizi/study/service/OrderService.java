package com.bizi.study.service;

import com.bizi.framework.service.BaseDao;
import com.bizi.study.model.uniorder.OrderInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by guo on 15-3-20.
 */
@Service
public class OrderService {
    @Resource(name = "baseDao_uniorder")
    private BaseDao<OrderInfo> orderInfoBaseDao;

    @Transactional("transactionManager_uniorder")
    public void save(OrderInfo orderInfo){
        orderInfoBaseDao.save(orderInfo);
    }
}
