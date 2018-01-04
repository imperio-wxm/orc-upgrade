package com.wxmimperio.orc.dao.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wxmimperio.orc.common.HttpClientUtil;
import com.wxmimperio.orc.dao.ConfigDao;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ConfigDaoImpl implements ConfigDao {

    @Override
    public List<String> getHdfsTopics() throws Exception {
        CloseableHttpClient client = HttpClientUtil.getHttpClient();
        String url = "http://10.128.74.83:8092/hdfsbridge/ua";
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

    @Override
    public void putHdfsTopics() throws Exception {

    }

    @Override
    public List<String> getHBaseTopics() throws Exception {
        return null;
    }

    @Override
    public void putHBaseTopics() throws Exception {

    }
}
