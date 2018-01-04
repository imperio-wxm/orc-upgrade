package com.wxmimperio.orc.dao.impl;

import com.wxmimperio.orc.dao.SequenceToOrcDao;
import com.wxmimperio.orc.mapper.TableInfoMapper;
import com.wxmimperio.orc.pojo.SequenceToOrcInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SequenceToOrcDaoImpl implements SequenceToOrcDao {

    @Autowired
    private TableInfoMapper tableInfoMapper;

    @Autowired
    private ConfigDaoImpl configDao;

    @Override
    public void add() throws Exception {
        List<String> hdfsTopics = configDao.getHdfsTopics();
        for (String topicName : hdfsTopics) {
            if (tableInfoMapper.getByTableName(topicName).size() == 0) {
                SequenceToOrcInfo sequenceToOrcInfo = new SequenceToOrcInfo();
                sequenceToOrcInfo.setTable_name(topicName);
                tableInfoMapper.add(sequenceToOrcInfo);
            }
        }
    }

    @Override
    public void update(SequenceToOrcInfo sequenceToOrcInfo) throws Exception {
        if (tableInfoMapper.getByTableName(sequenceToOrcInfo.getTable_name()).size() != 0) {
            tableInfoMapper.update(sequenceToOrcInfo);
        }
    }

    @Override
    public void remove(SequenceToOrcInfo sequenceToOrcInfo) throws Exception {

    }

    @Override
    public List<SequenceToOrcInfo> getAll() throws Exception {
        add();
        return tableInfoMapper.getAllTables();
    }

    @Override
    public SequenceToOrcInfo getTopicByName(String tableName) throws Exception {
        return tableInfoMapper.getByTableName(tableName).get(0);
    }
}
