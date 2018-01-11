package com.wxmimperio.orc.controller;

import com.wxmimperio.orc.dao.impl.ConfigDaoImpl;
import com.wxmimperio.orc.pojo.SequenceToOrcInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConfigController {

    @Autowired
    private ConfigDaoImpl configDao;

    @RequestMapping(value = "/configInfo/get/getHDFSTopics", method = RequestMethod.GET, consumes = "application/json")
    public List<SequenceToOrcInfo> getHDFSTopics() throws Exception {
        return configDao.getHdfsConfigTopics();
    }

    @RequestMapping(value = "/configInfo/get/getHBaseTopics", method = RequestMethod.GET, consumes = "application/json")
    public List<SequenceToOrcInfo> getHBaseTopics() throws Exception {
        return configDao.getHBaseConfigTopics();
    }
}
