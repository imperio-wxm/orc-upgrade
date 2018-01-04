package com.wxmimperio.orc.pojo;

import com.wxmimperio.orc.common.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TableInfo {

    private Long id;
    private String table_name;
    private String table_type = "hive";
    private String table_status = "init";
    private String upgrade_time = Utils.eventTomeFormat.get().format(new Date());
    private String finish_time = "";

    public TableInfo() {
    }

    public TableInfo(Long id, String table_name, String table_type, String table_status, String upgrade_time, String finish_time) {
        this.id = id;
        this.table_name = table_name;
        this.table_type = table_type;
        this.table_status = table_status;
        this.upgrade_time = upgrade_time;
        this.finish_time = finish_time;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "id=" + id +
                ", tableName='" + table_name + '\'' +
                ", table_type='" + table_type + '\'' +
                ", table_status=" + table_status +
                ", upgrade_time='" + upgrade_time + '\'' +
                ", finish_time='" + finish_time + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getTable_type() {
        return table_type;
    }

    public void setTable_type(String table_type) {
        this.table_type = table_type;
    }

    public String getTable_status() {
        return table_status;
    }

    public void setTable_status(String table_status) {
        this.table_status = table_status;
    }

    public String getUpgrade_time() {
        return upgrade_time;
    }

    public void setUpgrade_time(String upgrade_time) {
        this.upgrade_time = upgrade_time;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }
}
