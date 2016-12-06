package com.bizi.scjp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 * Created by GuoFangBi on 16-2-22.
 */
public class FirstTest {
    public static final Map map = new HashMap();

    @Test
    public void testFirst(){

        map.put("sdf","bizi");
        int[] ia = {1,3,5,7,9};
        for(int x : ia){
            for(int j = 0; j < 3 ;j++){
                if(x > 4 && x < 8){
                    continue;
                }
                System.out.println(" " + x);
                if(j == 1)
                    break;
                continue;
            }
            continue;
        }
    }
}
