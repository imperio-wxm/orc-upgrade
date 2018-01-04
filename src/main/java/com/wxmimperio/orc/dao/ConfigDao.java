package com.wxmimperio.orc.dao;

import java.util.List;

public interface ConfigDao {
    List<String> getHdfsTopics() throws Exception;

    void putHdfsTopics() throws Exception;

    List<String> getHBaseTopics() throws Exception;

    void putHBaseTopics() throws Exception;
}
