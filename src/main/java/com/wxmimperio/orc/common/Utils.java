package com.wxmimperio.orc.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Utils {

    public static final ThreadLocal<SimpleDateFormat> eventTomeFormat = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static List<String> getConfigTopics(String url) throws Exception {
        CloseableHttpClient client = HttpClientUtil.getHttpClient();
        String res = HttpClientUtil.doGet(
                url
        );
        JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();
        List<String> topicList = Arrays.asList(
                jsonObject.get("propertySources")
                        .getAsJsonArray()
                        .get(0)
                        .getAsJsonObject()
                        .get("source")
                        .getAsJsonObject().get("schema.topic.name")
                        .getAsString()
                        .split(",", -1)
        );
        client.close();
        return topicList;
    }

    public static void putConfigTopics(String url, Map<String, String> paraMap) throws Exception {
        String CONTENT_TYPE = "application/json";
        CloseableHttpClient client = HttpClientUtil.getHttpClient();
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE);
        HttpClientUtil.doPost(
                url,
                gson.toJson(paraMap).toString(),
                new Header[]{header},
                client
        );
        client.close();
    }
}
