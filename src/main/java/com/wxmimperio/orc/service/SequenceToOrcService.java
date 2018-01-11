package com.wxmimperio.orc.service;

import com.wxmimperio.orc.pojo.SequenceToOrcInfo;


public interface SequenceToOrcService {
    void upGradeTables(SequenceToOrcInfo sequenceToOrcInfo) throws Exception;

    void autoRefresh() throws Exception;
}
