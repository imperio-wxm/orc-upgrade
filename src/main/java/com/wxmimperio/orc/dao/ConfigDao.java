package com.wxmimperio.orc.dao;

import java.util.List;
import java.util.Map;

public interface ConfigDao {
    List<String> getHdfsTopics() throws Exception;

    void putHdfsTopics(Map<String, String> paramMap) throws Exception;

    List<String> getHBaseTopics() throws Exception;

    void putHBaseTopics(Map<String, String> paramMap) throws Exception;
}
