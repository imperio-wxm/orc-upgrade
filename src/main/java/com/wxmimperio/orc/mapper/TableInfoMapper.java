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
            "id integer PRIMARY KEY autoincrement," +
            "table_name varchar(255) not null," +
            "table_type varchar(255) not null," +
            "table_status varchar(255) not null," +
            "upgrade_time varchar(255) not null," +
            "finish_time varchar(255) not null)")
    void createTale(@Param("tableName") String tableName) throws Exception;

    @Insert("insert into sequence_to_orc (table_name,table_type,table_status,upgrade_time,finish_time) values (" +
            "#{table_name}," +
            "#{table_type}," +
            "#{table_status}," +
            "#{upgrade_time}," +
            "#{finish_time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(SequenceToOrcInfo tableInfo) throws Exception;

    @Select("select * from sequence_to_orc where table_name='${table_name}'")
    @Results(value = {
            @Result(property = "id", column = "id", javaType = Long.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "table_name", column = "table_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "table_type", column = "table_type", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "table_status", column = "table_status", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "upgrade_time", column = "upgrade_time", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "finish_time", column = "finish_time", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<SequenceToOrcInfo> getByTableName(@Param("table_name") String table_name) throws Exception;

    @Update("update sequence_to_orc set table_name=#{table_name}," +
            "table_type=#{table_type}," +
            "table_status=#{table_status}," +
            "upgrade_time=#{upgrade_time}," +
            "finish_time=#{finish_time}  WHERE id=#{id}")
    void update(SequenceToOrcInfo tableInfo) throws Exception;
}
