package com.bizi.mock.standard;

import com.bizi.mock.spring.IUserDao;
import com.bizi.mock.spring.UserDTO;

import java.util.List;

/**
 * 描述：
 * Created by GuoFangBi on 16-3-8.
 */
public class BizService implements IBizService {

    /**
     * 方法使用到了发邮件功能。邮件接口提供的调用方式是：
     * 1.初始化邮件对象。
     * 2.调用发送邮件方法。
     */
    public String sendMail(String content){
        System.err.println("准备发送邮件");
        EmailSender sender = new EmailSender();

        return sender.sendMail(content);
    }

    /**
     * 方法使用到了远程调用功能。该功能的调用方式是：
     * 直接调用WSRequestUtil的静态方法。
     */
    public String getRemoteResult(String username) {
        System.err.println("准备调用远程数据");
        return WSRequestUtil.queryResult("bizi");
    }
}
