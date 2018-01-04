package com.wxmimperio.orc.common;

import com.wxmimperio.orc.mapper.TableInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class InitDataBase implements CommandLineRunner {
    @Autowired
    private TableInfoMapper tableInfoMapper;
    private String tableName = "sequence_to_orc";

    @Override
    public void run(String... strings) throws Exception {
        tableInfoMapper.createTale(tableName);
    }
}
