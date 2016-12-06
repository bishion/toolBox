package com.bizi.jmockit.standard;

import com.bizi.mock.standard.BizService;
import com.bizi.mock.standard.EmailSender;
import com.bizi.mock.standard.IBizService;
import com.bizi.mock.standard.WSRequestUtil;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;
import org.junit.Test;

/**
 * 描述：
 * Created by GuoFangBi on 16-3-8.
 */
public class StandardMockUpTest {
    @Tested
    IBizService bizService = new BizService();
    @Test
    public void testMockClass() {
        // 定义被模拟的对象
        new MockUp<EmailSender>() {
            @Mock  // 覆盖要被模拟的方法。必须加这个注解
            public String sendMail(String content) {// 方法名必须跟被模拟的方法名一样
                // 自定义被模拟方法的返回值。
                return "Just mock sending email";
            }
        };
        new EmailSender();// 通知调用
        System.err.println(bizService.sendMail("test"));// 执行被测试代码
    }

    @Test
    public void testMockStatic() {
        new MockUp<WSRequestUtil>(){// 定义被模拟的对象
            @Mock // 覆盖要被模拟的方法。必须加这个注解
            String queryResult(String param){// 方法名必须跟被模拟的方法名一样
                System.err.println("Mock调用远程接口");
                return "Mock返回处理结果";
            }
        };
        System.err.println(bizService.getRemoteResult("test"));// 执行被测试代码

    }
}