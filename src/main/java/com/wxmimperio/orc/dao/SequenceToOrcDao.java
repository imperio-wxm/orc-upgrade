package com.wxmimperio.orc.dao;

import com.wxmimperio.orc.pojo.SequenceToOrcInfo;

import java.util.List;

public interface SequenceToOrcDao {

    void add() throws Exception;

    void update(SequenceToOrcInfo sequenceToOrcInfo) throws Exception;

    void remove(SequenceToOrcInfo sequenceToOrcInfo) throws Exception;

    List<SequenceToOrcInfo> getAll() throws Exception;

    SequenceToOrcInfo getTopicByName(String tableName) throws Exception;

    List<SequenceToOrcInfo> getTablesByType(String type) throws Exception;

    List<SequenceToOrcInfo> getTablesByStatus(String status) throws Exception;
}
