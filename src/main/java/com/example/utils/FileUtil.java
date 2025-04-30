package com.example.utils;

import java.io.*;

/**
 * FileUtil 類別提供了複製檔案的功能，這裡使用了高效的 IO 流處理。
 * 當檔案存在時，會覆蓋目標檔案。
 */
public class FileUtil {

    /**
     * 複製檔案，將來源檔案 (fromFile) 複製到目標檔案 (toFile)。
     * 如果目標檔案已經存在，會被覆蓋。
     * 
     * @param fromFile 來源檔案
     * @param toFile 目標檔案
     * @throws IOException 當檔案操作過程中發生錯誤時會丟出此例外
     */
    public static void copy(File fromFile, File toFile) throws IOException {
        // 檢查來源檔案是否存在
        if (!fromFile.exists()) {
            throw new IOException("來源檔案不存在: " + fromFile.getAbsolutePath());
        }

        // 檢查目標檔案所在的目錄是否存在，若不存在則創建
        File parentDir = toFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        // 使用 try-with-resources 確保資源能被自動關閉
        try (InputStream in = new BufferedInputStream(new FileInputStream(fromFile), 1024);
             OutputStream out = new BufferedOutputStream(new FileOutputStream(toFile), 1024)) {

            // 定義一個緩衝區，用來讀取檔案
            byte[] buffer = new byte[1024];
            int bytesRead;

            // 從來源檔案讀取資料並寫入到目標檔案
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }

            // 強制將所有資料寫入目標檔案
            out.flush();
        } catch (IOException e) {
            // 在捕捉到異常時，記錄錯誤並重新拋出
            throw new IOException("複製檔案過程中發生錯誤: " + e.getMessage(), e);
        }
    }

    /**
     * 複製檔案，並檢查目標檔案是否存在。
     * 若目標檔案已存在，則不會覆蓋檔案，並丟出 IOException。
     * 
     * @param fromFile 來源檔案
     * @param toFile 目標檔案
     * @throws IOException 如果目標檔案已存在則拋出異常
     */
    public static void copyWithoutOverwrite(File fromFile, File toFile) throws IOException {
        // 檢查來源檔案是否存在
        if (!fromFile.exists()) {
            throw new IOException("來源檔案不存在: " + fromFile.getAbsolutePath());
        }

        // 如果目標檔案已經存在，拋出異常
        if (toFile.exists()) {
            throw new IOException("目標檔案已經存在: " + toFile.getAbsolutePath());
        }

        // 呼叫複製檔案的功能
        copy(fromFile, toFile);
    }
}
