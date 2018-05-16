package com.hms.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
    /** 正则表达式 */
    public static boolean pattern(String text, String regex) {
        boolean result = false;
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            result = matcher.matches();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
