package com.wxmimperio.orc.pojo;

public class SequenceToOrcInfo {

    private Long table_id;
    private String table_name;
    private String table_type = "Hive";
    private String table_status = "Init";
    private String part_date = "";
    private String upgrade_time = "";
    private String finish_time = "";

    public SequenceToOrcInfo() {
    }

    public SequenceToOrcInfo(Long table_id, String table_name, String table_type, String table_status, String part_date, String upgrade_time, String finish_time) {
        this.table_id = table_id;
        this.table_name = table_name;
        this.table_type = table_type;
        this.table_status = table_status;
        this.upgrade_time = upgrade_time;
        this.finish_time = finish_time;
        this.part_date = part_date;
    }

    @Override
    public String toString() {
        return "SequenceToOrcInfo{" +
                "table_id=" + table_id +
                ", table_name='" + table_name + '\'' +
                ", table_type='" + table_type + '\'' +
                ", table_status='" + table_status + '\'' +
                ", part_date='" + part_date + '\'' +
                ", upgrade_time='" + upgrade_time + '\'' +
                ", finish_time='" + finish_time + '\'' +
                '}';
    }

    public Long getTable_id() {
        return table_id;
    }

    public void setTable_id(Long table_id) {
        this.table_id = table_id;
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

    public String getPart_date() {
        return part_date;
    }

    public void setPart_date(String part_date) {
        this.part_date = part_date;
    }
}
