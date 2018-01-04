package com.wxmimperio.orc.controller;

import com.wxmimperio.orc.dao.impl.SequenceToOrcDaoImpl;
import com.wxmimperio.orc.pojo.SequenceToOrcInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UpGradeController {

    @Autowired
    private SequenceToOrcDaoImpl sequenceToOrcDao;

    @RequestMapping(value = "/upgrade/get/getAllTables", method = RequestMethod.GET, consumes = "application/json")
    public List<SequenceToOrcInfo> getAllTables() throws Exception {
        return sequenceToOrcDao.getAll();
    }

    @RequestMapping(value = "/upgrade/update/sequenceToOrcInfo", method = RequestMethod.POST, consumes = "application/json")
    public void update(@RequestBody SequenceToOrcInfo sequenceToOrcInfo) throws Exception {
        sequenceToOrcDao.update(sequenceToOrcInfo);
    }

    @RequestMapping(value = "/upgrade/getTopicByName/{tableName}", method = RequestMethod.GET, consumes = "application/json")
    public SequenceToOrcInfo getTopicByName(@PathVariable String tableName) throws Exception {
        return sequenceToOrcDao.getTopicByName(tableName);
    }
}
