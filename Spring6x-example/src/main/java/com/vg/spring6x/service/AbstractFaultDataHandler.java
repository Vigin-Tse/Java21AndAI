package com.vg.spring6x.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AbstractFaultDataHandler {

    // 创建一个虚拟线程池
    // 为每个任务创建独立虚拟线程，适用于IO密集型任务：
    public ExecutorService executor =  Executors.newVirtualThreadPerTaskExecutor();

    // 创建一个固定大小的线程池，线程为虚拟线程
//    public ExecutorService executor =  Executors.newFixedThreadPool(
//            Runtime.getRuntime().availableProcessors(),
//            Thread.ofVirtual().factory());
    /**
     * 递归读取指定目录及所有子目录下的JSON文件
     */
    public void processJsonFilesRecursively(String rootPath) {
        processDirectory(new File(rootPath));
    }

    /**
     * 递归处理目录及其子目录
     * @param directory 目录文件对象
     */
    private void processDirectory(File directory) {
        // 检查目录有效性
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("无效目录: " + directory.getAbsolutePath());
            return;
        }

        // 获取目录下所有文件和子目录
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {

                if (file.isFile() && file.getName().toLowerCase().endsWith(".json")) {
                    // 处理JSON文件
                    processJsonFile(file);
                } else if (file.isDirectory()) {
                    // 递归处理子目录
                    processDirectory(file);
                }

            }
        }
    }

    /**
     * 处理单个JSON文件
     * @param jsonFile JSON文件对象
     */
    private void processJsonFile(File jsonFile) {
        try {
            // 使用hutool读取文件内容并转换为JSONObject
            String content = FileUtil.readUtf8String(jsonFile);
            JSONObject jsonObject = JSONUtil.parseObj(content);

            handleFaultData(jsonFile.getAbsolutePath(), jsonObject);
        } catch (Exception e) {
//            e.printStackTrace();
            System.err.println("处理JSON文件失败: " + jsonFile.getAbsolutePath() + ", 错误: " + e.getMessage());
        }
    }

    protected abstract void handleFaultData(String filePath, JSONObject jsonObject);
}
