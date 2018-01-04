package com.wxmimperio.orc.controller;

import com.google.gson.JsonObject;
import com.wxmimperio.orc.common.Utils;
import com.wxmimperio.orc.mapper.TableInfoMapper;
import com.wxmimperio.orc.pojo.TableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


/**
 * Created by weiximing.imperio on 2016/8/26.
 */
@RestController
public class TestController {

    @Autowired
    TableInfoMapper tableInfoMapper;

    @RequestMapping(value = "/test/{username}", method = RequestMethod.GET, consumes = "application/json")
    public String createTableController(@PathVariable String username) throws Exception {
        System.out.println("This is " + username);


        TableInfo tableInfo = new TableInfo();
        tableInfo.setTable_name("test_table");
        //tableInfoMapper.add(tableInfo);
        List<TableInfo> tableInfoList = tableInfoMapper.getByTableName("test_table");
        if (tableInfoList.size() != 0) {
            tableInfo = tableInfoList.get(0);
            tableInfo.setFinish_time(Utils.eventTomeFormat.get().format(new Date()));
            tableInfoMapper.update(tableInfo);
        }

        System.out.println(tableInfoList);

       /* Connection conn = dataSource.hikariDataSource().getConnection();
        conn.setAutoCommit(false);
        PreparedStatement pstat = conn.prepareStatement("create table IF NOT EXISTS book (id int(11), name varchar(45),price float); ",
                Statement.RETURN_GENERATED_KEYS);
        pstat.execute();
        Statement stat = conn.createStatement();
        for (int i = 0; i < 10; i++) {
            float priceRandom = (float) ((int) (Math.random() * 10 + 1) * 0.2);
            String sql = "INSERT INTO book (id,name,price) " + "VALUES (1, 'Paul', 32);";
            System.out.println(sql);
            stat.execute(sql);
        }
        ResultSet rs = stat.executeQuery("select * from book;");
        conn.commit();
        while (rs.next()) {
            System.out.println("id=" + rs.getInt("id") + ", name=" + rs.getString("name"));
        }
        stat.close();
        conn.close();*/


        return "test";
    }
}
