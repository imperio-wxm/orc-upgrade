package com.wxmimperio.orc.controller;

import com.wxmimperio.orc.dao.impl.SequenceToOrcDaoImpl;
import com.wxmimperio.orc.pojo.SequenceToOrcInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class UpGradeController {

    @Autowired
    private SequenceToOrcDaoImpl sequenceToOrcDao;

    @RequestMapping(value = "/upgrade/getAllTables", method = RequestMethod.GET, consumes = "application/json")
    public void getAllTables() throws Exception {

        System.out.println(sequenceToOrcDao.getAll());
    }

    @RequestMapping(value = "/upgrade/sequenceToOrcInfo", method = RequestMethod.POST, consumes = "application/json")
    public void update(@RequestBody SequenceToOrcInfo sequenceToOrcInfo) throws Exception {

        System.out.println(sequenceToOrcInfo);
    }

    @RequestMapping(value = "/upgrade/getTopicByName/{tableName}", method = RequestMethod.GET, consumes = "application/json")
    public SequenceToOrcInfo getTopicByName(@PathVariable String tableName) throws Exception {
        SequenceToOrcInfo sequenceToOrcInfo = sequenceToOrcDao.getTopicByName(tableName);
        return sequenceToOrcInfo;
    }
}
