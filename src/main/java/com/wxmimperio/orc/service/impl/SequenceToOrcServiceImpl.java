package com.wxmimperio.orc.service.impl;

import com.wxmimperio.orc.common.HadoopUtils;
import com.wxmimperio.orc.common.Utils;
import com.wxmimperio.orc.dao.impl.ConfigDaoImpl;
import com.wxmimperio.orc.dao.impl.SequenceToOrcDaoImpl;
import com.wxmimperio.orc.pojo.GlobalProperties;
import com.wxmimperio.orc.pojo.SequenceToOrcInfo;
import com.wxmimperio.orc.service.SequenceToOrcService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SequenceToOrcServiceImpl implements SequenceToOrcService, InitializingBean {
    private static final Log LOG = LogFactory.getLog(SequenceToOrcDaoImpl.class);

    @Autowired
    private ConfigDaoImpl configDao;
    @Autowired
    private SequenceToOrcDaoImpl sequenceToOrcDao;
    @Autowired
    private GlobalProperties globalProperties;

    private List<String> hdfsTopics;
    private List<String> hbaseTopics;

    @Override
    public void afterPropertiesSet() throws Exception {
        hdfsTopics = configDao.getHdfsTopics();
        hbaseTopics = configDao.getHBaseTopics();
    }

    @Override
    public void upGradeTables(List<SequenceToOrcInfo> sequenceToOrcInfos) throws Exception {

        System.out.println("src hdfs map " + hdfsTopics);
        System.out.println("src hbase map " + hbaseTopics);

        System.out.println("---------------------");

        for (SequenceToOrcInfo sequenceToOrcInfo : sequenceToOrcInfos) {
            String tableName = sequenceToOrcInfo.getTable_name();
            if (hdfsTopics.contains(tableName) && !hbaseTopics.contains(tableName)) {
                Map<String, String> newHdfsTopic = getNewHdfsTopics(hdfsTopics, tableName);
                Map<String, String> newHbaseTopic = getNewHBaseTopics(hbaseTopics, tableName);
                sequenceToOrcDao.update(sequenceToOrcInfo);
                configDao.putHdfsTopics(newHdfsTopic);
                configDao.putHBaseTopics(newHbaseTopic);
                setNewTopics(newHdfsTopic);
                setNewTopics(newHbaseTopic);
                System.out.println("hdfs map " + newHdfsTopic);
                System.out.println("hbase map " + newHbaseTopic);
                LOG.info("Upgrade data = " + sequenceToOrcInfo);
                System.out.println("====================");
            }
        }
    }

    @Override
    public void autoRefresh() throws Exception {
        for (SequenceToOrcInfo sequenceToOrcInfo : sequenceToOrcDao.getTablesByStatus("Running")) {
            String filePath = globalProperties.getHdfsPrefix()
                    + sequenceToOrcInfo.getTable_name() + "/temp/part_date="
                    + sequenceToOrcInfo.getPart_date() + "/";
            List<String> files = HadoopUtils.getFileList(filePath);
            if (files.size() == 0) {
                sequenceToOrcInfo.setFinish_time(Utils.eventTomeFormat.get().format(new Date()));
                sequenceToOrcInfo.setTable_status("Finish");
                sequenceToOrcInfo.setTable_type("HBase");
                sequenceToOrcDao.update(sequenceToOrcInfo);
                LOG.info("Finish data = " + sequenceToOrcInfo);
            }
        }
    }

    private Map<String, String> getNewHdfsTopics(List<String> oldTopics, String removeTopic) {
        List<String> newTopics = new ArrayList<>();
        for (String oldTopic : oldTopics) {
            if (!oldTopic.equals(removeTopic)) {
                newTopics.add(oldTopic);
            }
        }
        Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("schema.topic.name", newTopics.toString().
                substring(1, newTopics.toString().length() - 1).
                replaceAll(" ", ""));
        return paraMap;
    }

    private Map<String, String> getNewHBaseTopics(List<String> oldTopics, String addTopic) {
        oldTopics.add(addTopic);
        Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("hbase.table.list", oldTopics.toString().
                substring(1, oldTopics.toString().length() - 1).
                replaceAll(" ", ""));
        return paraMap;
    }

    private void setNewTopics(Map<String, String> newTopic) {
        for (String topic : newTopic.keySet()) {
            if (topic.equalsIgnoreCase("schema.topic.name")) {
                hdfsTopics.clear();
                hdfsTopics.add(newTopic.get(topic));
            } else if (topic.equalsIgnoreCase("hbase.table.list")) {
                hbaseTopics.clear();
                hbaseTopics.add(newTopic.get(topic));
            }
        }
    }
}
