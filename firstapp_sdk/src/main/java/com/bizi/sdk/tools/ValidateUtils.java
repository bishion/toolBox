package com.bizi.sdk.tools;

/**
 * Created by guo on 15-4-2.
 */
public class ValidateUtils {
    public static boolean hasOneEmpty(String... values){
        for (String value : values) {
            if(isBlank(value))
                return true;
        }
        return false;
    }
    public static boolean isBlank(String value){
        return value==null || "".equals(value)||"".equals(value.trim());
    }

    public static boolean isNull(Object object) {
        return object == null;
    }
}
