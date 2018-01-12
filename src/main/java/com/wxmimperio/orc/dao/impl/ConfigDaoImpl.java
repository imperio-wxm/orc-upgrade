package com.wxmimperio.orc.dao.impl;

import com.wxmimperio.orc.common.Utils;
import com.wxmimperio.orc.dao.ConfigDao;
import com.wxmimperio.orc.pojo.GlobalProperties;
import com.wxmimperio.orc.pojo.SequenceToOrcInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class ConfigDaoImpl implements ConfigDao {

    @Autowired
    private GlobalProperties globalProperties;

    @Override
    public List<String> getHdfsTopics() throws Exception {
        return getTopicNames(globalProperties.getHdfsConfigUrl(), globalProperties.getHdfsType());
    }

    @Override
    public void putHdfsTopics(Map<String, String> paramMap) throws Exception {
        Utils.putConfigTopics(globalProperties.getHdfsConfigUrl(), paramMap);
    }

    @Override
    public List<String> getHBaseTopics() throws Exception {
        return getTopicNames(globalProperties.getHbaeConfigUrl(), globalProperties.getHbaseType());
    }

    @Override
    public void putHBaseTopics(Map<String, String> paramMap) throws Exception {
        Utils.putConfigTopics(globalProperties.getHbaeConfigUrl(), paramMap);
    }

    @Override
    public List<SequenceToOrcInfo> getHdfsConfigTopics() throws Exception {
        return getTopicInfo(getTopicNames(globalProperties.getHdfsConfigUrl(), globalProperties.getHdfsType()));
    }

    @Override
    public List<SequenceToOrcInfo> getHBaseConfigTopics() throws Exception {
        return getTopicInfo(getTopicNames(globalProperties.getHbaeConfigUrl(), globalProperties.getHbaseType()));
    }

    private List<String> getTopicNames(String url, String type) throws Exception {
        return new ArrayList(Arrays.asList(
                Utils.getConfigTopics(url)
                        .get(type)
                        .getAsString()
                        .replaceAll(" ", "")
                        .split(",", -1)
        ));
    }

    private List<SequenceToOrcInfo> getTopicInfo(List<String> topicNames) {
        List<SequenceToOrcInfo> sequenceToOrcInfos = new ArrayList<>();
        for (String topic : topicNames) {
            SequenceToOrcInfo sequenceToOrcInfo = new SequenceToOrcInfo();
            sequenceToOrcInfo.setTable_name(topic);
            sequenceToOrcInfos.add(sequenceToOrcInfo);
        }
        return sequenceToOrcInfos;
    }
}
