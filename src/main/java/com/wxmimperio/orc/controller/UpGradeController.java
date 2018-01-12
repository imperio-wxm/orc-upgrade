package com.wxmimperio.orc.controller;


import com.wxmimperio.orc.dao.impl.SequenceToOrcDaoImpl;
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

    @RequestMapping(value = "/api/upgrade/get/getAllTables", method = RequestMethod.GET, consumes = "application/json")
    public List<SequenceToOrcInfo> getAllTables() throws Exception {
        return sequenceToOrcDao.getAll();
    }

    @RequestMapping(value = "/api/upgrade/update/sequenceToOrcInfo", method = RequestMethod.POST, consumes = "application/json")
    public void update(@RequestBody List<SequenceToOrcInfo> sequenceToOrcInfos) throws Exception {
        sequenceToOrcService.upGradeTables(sequenceToOrcInfos);
    }

    @RequestMapping(value = "/api/upgrade/getTopicByName/{tableName}", method = RequestMethod.GET, consumes = "application/json")
    public SequenceToOrcInfo getTopicByName(@PathVariable String tableName) throws Exception {
        return sequenceToOrcDao.getTopicByName(tableName);
    }

    @RequestMapping(value = "/api/upgrade/refresh/autoRefresh", method = RequestMethod.GET, consumes = "application/json")
    public void autoRefresh() throws Exception {
        sequenceToOrcService.autoRefresh();
    }

    @RequestMapping(value = "/api/upgrade/get/getTablesByType/{type}", method = RequestMethod.GET, consumes = "application/json")
    public List<SequenceToOrcInfo> getTablesByType(@PathVariable String type) throws Exception {
        return sequenceToOrcDao.getTablesByType(type);
    }

    @RequestMapping(value = "/api/upgrade/get/getTablesByStatus/{status}", method = RequestMethod.GET, consumes = "application/json")
    public List<SequenceToOrcInfo> getTablesByStatus(@PathVariable String status) throws Exception {
        return sequenceToOrcDao.getTablesByStatus(status);
    }
}
