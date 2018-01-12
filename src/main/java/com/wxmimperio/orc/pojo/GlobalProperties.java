package com.wxmimperio.orc.pojo;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "orc.upgrade")
@Component
public class GlobalProperties {
    @NotNull
    @NotBlank
    @Value("${orc.upgrade.hdfs-uri}")
    private String hdfsUri;
    @NotNull
    @NotBlank
    @Value("${orc.upgrade.hdfs-config-url}")
    private String hdfsConfigUrl;
    @NotNull
    @NotBlank
    @Value("${orc.upgrade.hdfs-type}")
    private String hdfsType;
    @NotNull
    @NotBlank
    @Value("${orc.upgrade.hbase-config-url}")
    private String hbaeConfigUrl;
    @NotNull
    @NotBlank
    @Value("${orc.upgrade.hbase-type}")
    private String hbaseType;
    @NotNull
    @NotBlank
    @Value("${orc.upgrade.hdfs-prefix}")
    private String hdfsPrefix;


    @Override
    public String toString() {
        return "GlobalProperties{" +
                "hdfsUri='" + hdfsUri + '\'' +
                ", hdfsConfigUrl='" + hdfsConfigUrl + '\'' +
                ", hdfsType='" + hdfsType + '\'' +
                ", hbaeConfigUrl='" + hbaeConfigUrl + '\'' +
                ", hbaseType='" + hbaseType + '\'' +
                ", hdfsPrefix='" + hdfsPrefix + '\'' +
                '}';
    }

    public String getHdfsPrefix() {
        return hdfsPrefix;
    }

    public void setHdfsPrefix(String hdfsPrefix) {
        this.hdfsPrefix = hdfsPrefix;
    }

    public String getHdfsUri() {
        return hdfsUri;
    }

    public void setHdfsUri(String hdfsUri) {
        this.hdfsUri = hdfsUri;
    }

    public String getHdfsConfigUrl() {
        return hdfsConfigUrl;
    }

    public void setHdfsConfigUrl(String hdfsConfigUrl) {
        this.hdfsConfigUrl = hdfsConfigUrl;
    }

    public String getHdfsType() {
        return hdfsType;
    }

    public void setHdfsType(String hdfsType) {
        this.hdfsType = hdfsType;
    }

    public String getHbaeConfigUrl() {
        return hbaeConfigUrl;
    }

    public void setHbaeConfigUrl(String hbaeConfigUrl) {
        this.hbaeConfigUrl = hbaeConfigUrl;
    }

    public String getHbaseType() {
        return hbaseType;
    }

    public void setHbaseType(String hbaseType) {
        this.hbaseType = hbaseType;
    }
}
