package com.bizi.jmockit.standard;

import com.bizi.mock.standard.BizService;
import com.bizi.mock.standard.EmailSender;
import com.bizi.mock.standard.IBizService;
import com.bizi.mock.standard.WSRequestUtil;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Test;

/**
 * 描述：
 * Created by GuoFangBi on 16-3-10.
 */
public class StandardMockExpectationsTest {

    @Tested
    private IBizService bizService = new BizService();

    @Test
    public void testMockClass(@Mocked final EmailSender sender) {
        // 先定义期望，然后执行被测试代码，则被测试代码中特定的函数调用就会返回模拟的结果
        new Expectations() {
            {
                new EmailSender();
                sender.sendMail(anyString);
                // 我期望在执行到以上两个方法之后，返回如下的结果
                result = "Mock sender result";
            }
        };
        // 正式调用
        System.err.println(bizService.sendMail("test"));
    }

    @Test
    public void testMockStatic(@Mocked WSRequestUtil util){
        new Expectations(){
            {
                WSRequestUtil.queryResult(anyString);
                result = "Mock remote request";
            }
        };

        System.err.println(bizService.getRemoteResult("test"));
    }
}
