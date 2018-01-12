package com.wxmimperio.orc.mapper;


import com.wxmimperio.orc.pojo.SequenceToOrcInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TableInfoMapper {

    @Update("create table if not exists ${tableName} (" +
            "table_id integer PRIMARY KEY autoincrement," +
            "table_name varchar(255) not null," +
            "table_type varchar(255) not null," +
            "table_status varchar(255) not null," +
            "part_date varchar(255) not null," +
            "upgrade_time varchar(255) not null," +
            "finish_time varchar(255) not null)")
    void createTale(@Param("tableName") String tableName) throws Exception;

    @Insert("insert into sequence_to_orc (table_name,table_type,table_status,part_date,upgrade_time,finish_time) values (" +
            "#{table_name}," +
            "#{table_type}," +
            "#{table_status}," +
            "#{part_date}," +
            "#{upgrade_time}," +
            "#{finish_time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(SequenceToOrcInfo tableInfo) throws Exception;

    @Select("select * from sequence_to_orc where table_name='${table_name}' order by table_name,upgrade_time,finish_time")
    @Results(value = {
            @Result(property = "table_id", column = "table_id", javaType = Long.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "table_name", column = "table_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "table_type", column = "table_type", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "table_status", column = "table_status", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "part_date", column = "part_date", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "upgrade_time", column = "upgrade_time", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "finish_time", column = "finish_time", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<SequenceToOrcInfo> getByTableName(@Param("table_name") String table_name) throws Exception;

    @Select("select * from sequence_to_orc order by table_name,upgrade_time,finish_time")
    @Results(value = {
            @Result(property = "table_id", column = "table_id", javaType = Long.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "table_name", column = "table_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "table_type", column = "table_type", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "table_status", column = "table_status", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "part_date", column = "part_date", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "upgrade_time", column = "upgrade_time", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "finish_time", column = "finish_time", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<SequenceToOrcInfo> getAllTables() throws Exception;

    @Update("update sequence_to_orc set table_name=#{table_name}," +
            "table_type=#{table_type}," +
            "table_status=#{table_status}," +
            "part_date=#{part_date}," +
            "upgrade_time=#{upgrade_time}," +
            "finish_time=#{finish_time}  WHERE table_id=#{table_id}")
    void update(SequenceToOrcInfo tableInfo) throws Exception;

    @Select("select * from sequence_to_orc where table_status = '${table_status}' order by table_name,upgrade_time,finish_time")
    @Results(value = {
            @Result(property = "table_id", column = "table_id", javaType = Long.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "table_name", column = "table_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "table_type", column = "table_type", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "table_status", column = "table_status", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "part_date", column = "part_date", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "upgrade_time", column = "upgrade_time", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "finish_time", column = "finish_time", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<SequenceToOrcInfo> getTablesByStatus(@Param("table_status") String table_status) throws Exception;

    @Select("select * from sequence_to_orc where table_type = '${table_type}' order by table_name,upgrade_time,finish_time")
    @Results(value = {
            @Result(property = "table_id", column = "table_id", javaType = Long.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "table_name", column = "table_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "table_type", column = "table_type", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "table_status", column = "table_status", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "part_date", column = "part_date", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "upgrade_time", column = "upgrade_time", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "finish_time", column = "finish_time", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<SequenceToOrcInfo> getTablesByType(@Param("table_type") String table_type) throws Exception;
}
