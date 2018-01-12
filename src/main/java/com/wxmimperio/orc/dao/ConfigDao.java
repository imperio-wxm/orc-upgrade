package com.wxmimperio.orc.dao;

import com.wxmimperio.orc.pojo.SequenceToOrcInfo;

import java.util.List;
import java.util.Map;

public interface ConfigDao {
    List<String> getHdfsTopics() throws Exception;

    void putHdfsTopics(Map<String, String> paramMap) throws Exception;

    List<String> getHBaseTopics() throws Exception;

    void putHBaseTopics(Map<String, String> paramMap) throws Exception;

    List<SequenceToOrcInfo> getHdfsConfigTopics() throws Exception;

    List<SequenceToOrcInfo> getHBaseConfigTopics() throws Exception;
}
