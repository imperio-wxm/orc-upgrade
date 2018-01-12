package com.wxmimperio.orc.common;

import com.wxmimperio.orc.mapper.TableInfoMapper;
import com.wxmimperio.orc.service.impl.SequenceToOrcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
@Order(1)
public class InitDataBase implements CommandLineRunner {
    @Autowired
    private TableInfoMapper tableInfoMapper;
    @Autowired
    private SequenceToOrcServiceImpl sequenceToOrcService;
    private String tableName = "sequence_to_orc";

    @Override
    public void run(String... strings) throws Exception {
        tableInfoMapper.createTale(tableName);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    sequenceToOrcService.autoRefresh();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 5000, 60 * 1000);
    }
}
