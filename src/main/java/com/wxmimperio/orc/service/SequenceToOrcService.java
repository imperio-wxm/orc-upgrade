package com.wxmimperio.orc.service;

import com.wxmimperio.orc.pojo.SequenceToOrcInfo;

import java.util.List;


public interface SequenceToOrcService {
    void upGradeTables(List<SequenceToOrcInfo> sequenceToOrcInfos) throws Exception;

    void autoRefresh() throws Exception;
}
