package com.wxmimperio.orc.pojo;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "rt.datasheets")
public class GlobalProperties {

    @NotNull
    @NotBlank
    private String hivePath;
    @NotNull
    @NotBlank
    private String hiveDataBase;
    @NotNull
    @NotBlank
    private String schemaURL;
    @NotNull
    @NotBlank
    private String cassandraConnect;
    @NotNull
    @NotBlank
    private String keySpaceName;
    @NotNull
    @NotBlank
    private String hiveConnectionUrl;

    @Override
    public String toString() {
        return "GlobalProperties{" +
                "hivePath='" + hivePath + '\'' +
                ", hiveDataBase='" + hiveDataBase + '\'' +
                ", schemaURL='" + schemaURL + '\'' +
                ", cassandraConnect='" + cassandraConnect + '\'' +
                ", keySpaceName='" + keySpaceName + '\'' +
                ", hiveConnectionUrl='" + hiveConnectionUrl + '\'' +
                '}';
    }

    public String getHiveConnectionUrl() {
        return hiveConnectionUrl;
    }

    public void setHiveConnectionUrl(String hiveConnectionUrl) {
        this.hiveConnectionUrl = hiveConnectionUrl;
    }

    public String getHivePath() {
        return hivePath;
    }

    public void setHivePath(String hivePath) {
        this.hivePath = hivePath;
    }

    public String getHiveDataBase() {
        return hiveDataBase;
    }

    public void setHiveDataBase(String hiveDataBase) {
        this.hiveDataBase = hiveDataBase;
    }

    public String getSchemaURL() {
        return schemaURL;
    }

    public void setSchemaURL(String schemaURL) {
        this.schemaURL = schemaURL;
    }

    public String getCassandraConnect() {
        return cassandraConnect;
    }

    public void setCassandraConnect(String cassandraConnect) {
        this.cassandraConnect = cassandraConnect;
    }

    public String getKeySpaceName() {
        return keySpaceName;
    }

    public void setKeySpaceName(String keySpaceName) {
        this.keySpaceName = keySpaceName;
    }
}
