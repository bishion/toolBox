package com.bizi.study.model.uniorder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by guo on 15-3-13.
 */
public class OrderInfo {
    private Integer orderNo;
    private String buyer;
    private Float amount;
    private Date buyDate;

    private Set<SubOrder> subOrderSet = new HashSet<SubOrder>();

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Set<SubOrder> getSubOrderSet() {
        return subOrderSet;
    }

    public void setSubOrderSet(Set<SubOrder> subOrderSet) {
        this.subOrderSet = subOrderSet;
    }
}
