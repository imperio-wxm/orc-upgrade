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
                System.out.println("add " + sequenceToOrcInfo);
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
        List<SequenceToOrcInfo> sequenceToOrcInfoList = tableInfoMapper.getByTableName(tableName);
        if (sequenceToOrcInfoList.size() == 0) {
            return null;
        }
        return tableInfoMapper.getByTableName(tableName).get(0);
    }

    @Override
    public List<SequenceToOrcInfo> getTablesByType(String type) throws Exception {
        return tableInfoMapper.getTablesByType(type);
    }

    @Override
    public List<SequenceToOrcInfo> getTablesByStatus(String status) throws Exception {
        return tableInfoMapper.getTablesByStatus(status);
    }
}
