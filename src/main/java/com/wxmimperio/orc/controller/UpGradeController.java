package com.wxmimperio.orc.controller;

import com.wxmimperio.orc.common.HadoopUtils;
import com.wxmimperio.orc.dao.impl.ConfigDaoImpl;
import com.wxmimperio.orc.dao.impl.SequenceToOrcDaoImpl;
import com.wxmimperio.orc.pojo.GlobalProperties;
import com.wxmimperio.orc.pojo.SequenceToOrcInfo;
import com.wxmimperio.orc.service.impl.SequenceToOrcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UpGradeController {

    @Autowired
    private SequenceToOrcDaoImpl sequenceToOrcDao;
    @Autowired
    private SequenceToOrcServiceImpl sequenceToOrcService;

    @RequestMapping(value = "/upgrade/get/getAllTables", method = RequestMethod.GET, consumes = "application/json")
    public List<SequenceToOrcInfo> getAllTables() throws Exception {
        return sequenceToOrcDao.getAll();
    }

    @RequestMapping(value = "/upgrade/update/sequenceToOrcInfo", method = RequestMethod.POST, consumes = "application/json")
    public void update(@RequestBody List<SequenceToOrcInfo> sequenceToOrcInfos) throws Exception {
        sequenceToOrcService.upGradeTables(sequenceToOrcInfos);
    }

    @RequestMapping(value = "/upgrade/update/sequenceToOrcInfos", method = RequestMethod.POST, consumes = "application/json")
    public void updateList(@RequestBody List<SequenceToOrcInfo> sequenceToOrcInfos) throws Exception {
        System.out.println(sequenceToOrcInfos);
    }

    @RequestMapping(value = "/upgrade/getTopicByName/{tableName}", method = RequestMethod.GET, consumes = "application/json")
    public SequenceToOrcInfo getTopicByName(@PathVariable String tableName) throws Exception {
        return sequenceToOrcDao.getTopicByName(tableName);
    }

    @RequestMapping(value = "/upgrade/refresh/autoRefresh", method = RequestMethod.GET, consumes = "application/json")
    public void autoRefresh() throws Exception {
        sequenceToOrcService.autoRefresh();
    }

    @RequestMapping(value = "/upgrade/get/getTablesByType/{type}", method = RequestMethod.GET, consumes = "application/json")
    public List<SequenceToOrcInfo> getTablesByType(@PathVariable String type) throws Exception {
        return sequenceToOrcDao.getTablesByType(type);
    }

    @RequestMapping(value = "/upgrade/get/getTablesByStatus/{status}", method = RequestMethod.GET, consumes = "application/json")
    public List<SequenceToOrcInfo> getTablesByStatus(@PathVariable String status) throws Exception {
        return sequenceToOrcDao.getTablesByStatus(status);
    }
}
