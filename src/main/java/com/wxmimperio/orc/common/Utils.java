package com.wxmimperio.orc.common;

import java.text.SimpleDateFormat;

public class Utils {

    public static final ThreadLocal<SimpleDateFormat> eventTomeFormat = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
}
