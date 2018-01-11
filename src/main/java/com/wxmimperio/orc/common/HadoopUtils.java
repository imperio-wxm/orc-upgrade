package com.wxmimperio.orc.common;

import com.wxmimperio.orc.OrcUpgradeApplication;
import com.wxmimperio.orc.pojo.GlobalProperties;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class HadoopUtils {

    private static Configuration conf = null;
    private static String CORE_SITE_XML = "core-site.xml";
    private static String HDFS_SITE_XML = "hdfs-site.xml";

    private static GlobalProperties globalProperties;

    static {
        globalProperties = OrcUpgradeApplication.context.getBean(GlobalProperties.class);
        conf = new Configuration();
        conf.addResource(CORE_SITE_XML);
        conf.addResource(HDFS_SITE_XML);
        conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        System.out.println(globalProperties);
    }

    public static List<String> getFileList(String dataPath) throws Exception {
        List<String> fileList = new ArrayList<String>();
        try {
            Path path = new Path(dataPath);
            FileSystem fs = FileSystem.get(URI.create(globalProperties.getHdfsUri()), conf);
            FileStatus[] fileStatusArray = fs.globStatus(path);
            if (fileStatusArray != null) {
                for (FileStatus fileStatus : fileStatusArray) {
                    if (fs.isFile(fileStatus.getPath())) {
                        String fullPath = fileStatus.getPath().toString();
                        fileList.add(fullPath);
                    } else if (fs.isDirectory(fileStatus.getPath())) {
                        for (FileStatus fileStatus2 : fs.listStatus(fileStatus.getPath())) {
                            if (fs.isFile(fileStatus2.getPath())) {
                                String fullPath = fileStatus2.getPath().toString();
                                fileList.add(fullPath);
                            } else {
                                throw new Exception("file path error: " + fileStatus2.getPath().toString());
                            }
                        }
                    }
                }
            }
            return fileList;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
