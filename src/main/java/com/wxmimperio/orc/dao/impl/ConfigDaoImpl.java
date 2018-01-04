package com.wxmimperio.orc.dao.impl;

import com.wxmimperio.orc.common.Utils;
import com.wxmimperio.orc.dao.ConfigDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ConfigDaoImpl implements ConfigDao {

    @Override
    public List<String> getHdfsTopics() throws Exception {
        return Utils.getConfigTopics("http://10.128.74.83:8092/hdfsbridge/ua");
    }

    @Override
    public void putHdfsTopics(Map<String, String> paramMap) throws Exception {
        Utils.putConfigTopics("http://10.128.74.83:8092/hdfsbridge/ua", paramMap);
    }

    @Override
    public List<String> getHBaseTopics() throws Exception {
        return Utils.getConfigTopics("http://10.128.74.83:8092/hdfsbridge/ua");
    }

    @Override
    public void putHBaseTopics(Map<String, String> paramMap) throws Exception {
        Utils.putConfigTopics("http://10.128.74.83:8092/hdfsbridge/ua", paramMap);
    }
}
