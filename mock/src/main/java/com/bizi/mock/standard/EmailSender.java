package com.bizi.mock.standard;

/**
 * 描述：
 * Created by GuoFangBi on 16-3-10.
 */
public class EmailSender {
    /**
     * 需要被模拟的类。
     * 开发阶段，邮件发送可能无法连接或者根本不需要连接
     * 则在单元测试时希望能绕过该方法
     */
    public String sendMail(String content) {
        System.err.println("Sending mail");
        return "Mail has been sent";
    }
}
