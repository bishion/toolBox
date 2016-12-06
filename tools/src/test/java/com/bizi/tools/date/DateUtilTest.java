package com.bizi.tools.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtilTest{

    /**
     * 测试格林威治时间
     */
    @Test
    public void testCSTTime(){

        String str = "Fri Mar 20 17:27:41 CDT 2015";//在08与00之间加：
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy",Locale.US);

        Date d;
        try {
            d = sdf.parse(str);
            System.out.println(d.toString());
            System.out.println(DateUtil.toString(d, DateUtil.yyyy_MM_dd_HH_mm_ss));
        } catch (ParseException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}