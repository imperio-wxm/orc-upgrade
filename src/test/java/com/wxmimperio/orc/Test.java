package com.wxmimperio.orc;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.lang3.StringEscapeUtils;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            string.append((char) data);
        }

        return string.toString();
    }

    public static String replaceBlank(String oldStr) {
        String empty = new String();
        String newStr = oldStr;
        Pattern pattern = Pattern.compile("(\r\n|\r|\n|\n\r|\t)");
        Matcher matcher = pattern.matcher(oldStr);
        if (matcher.find()) {
            newStr = matcher.replaceAll(empty);
        }
        return newStr;
    }

    public static void main(String[] args) {
        String str = "{\"name\":\"wxmimperio\",\"age\":\"1515038587374\t2018-01-04 12:03:07\t123.149.7.236\tghome_qq_test2\t1.2.36.3264\n" +
                "???????(C) Microso \ndfasd\\u000a\\u000a\\u000a\\u000a\\u000a\\u000a\\u0009\\u0009\\u0009\\u0009\\u000d\\u000d\\u000d\\u000d" +
                "???????(C) Microso\tpt Host Version 5.812\n" +
                "???????(C) Microso\t\n" +
                "???????(C) Microso\t\"}";


        System.out.println("-------------");

        String str1 = new String("dfasd\\u000a\\u000a\\u000a\\u000a\\u000a\\u000a\\u0009\\u0009\\u0009\\u0009\\u000d".getBytes(), Charset.forName("UTF-8"));

        System.out.println(str1.toString());

        System.out.println(replaceBlank(StringEscapeUtils.unescapeJava(str1)));

        System.out.println(replaceBlank(str1));

        System.out.println(new JsonParser().parse(replaceBlank(StringEscapeUtils.unescapeJava(str))).getAsJsonObject());
    }
}
