package com.example.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.example.constant.ConstantName;
import com.example.pojo.entity.User;
import com.example.utils.FileUtil;

/**
 * HomeAction 類別處理首頁顯示、登出和檔案上傳的邏輯。
 */
public class HomeAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    // 用於接收上傳的檔案、檔案類型和檔案名稱
    private File[] upload;
    private String[] uploadContentType;
    private String[] uploadFileName;

    /**
     * 跳轉至首頁，顯示使用者資訊
     * @return SUCCESS 返回成功頁面
     */
    public String goHome() {
        User user = (User) getSession().getAttribute(ConstantName.SESSION_USER);
        if (user != null) {
            getRequest().setAttribute("user", user);
            return SUCCESS;
        } else {
            // 如果使用者未登入，重定向到登入頁
            return "login"; 
        }
    }

    /**
     * 登出功能，清除 session 並重定向至登入頁面
     * @return INPUT 返回登入頁面
     */
    public String logOut() {
        getSession().invalidate(); // 無效化 session
        return "login"; // 返回登入頁面
    }

    /**
     * 跳轉到上傳頁面
     * @return SUCCESS 返回上傳頁面
     */
    public String toUpload() {
        return SUCCESS;
    }

    /**
     * 處理檔案上傳邏輯
     * @return SUCCESS 若上傳成功，返回成功頁面；ERROR 若上傳失敗，返回錯誤頁面
     */
    public String upload() {
        if (upload == null || upload.length == 0) {
            // 若沒有檔案上傳，返回錯誤頁面
            getRequest().setAttribute("msg", "未選擇檔案");
            return ERROR;
        }

        String folder = "F:/upload/";
        File dir = new File(folder);
        if (!dir.exists()) {
            // 如果資料夾不存在，創建資料夾
            if (!dir.mkdirs()) {
                getRequest().setAttribute("msg", "創建資料夾失敗");
                return ERROR;
            }
        }

        // 迴圈處理每個檔案
        for (int i = 0; i < upload.length; i++) {
            if (upload[i] == null) {
                // 若檔案為 null，跳過該檔案處理
                continue;
            }

            try {
                // 生成新的檔案名稱
                String fileName = generateUniqueFileName(uploadFileName[i]);
                // 使用 FileUtil 工具將檔案複製到指定路徑
                FileUtil.copy(upload[i], new File(folder + fileName));
            } catch (IOException e) {
                // 錯誤處理，輸出錯誤訊息
                e.printStackTrace();
                getRequest().setAttribute("msg", "檔案上傳失敗");
                return ERROR;
            }
        }

        // 上傳成功，設置成功訊息
        getRequest().setAttribute("msg", "上傳成功");
        return SUCCESS;
    }

    /**
     * 生成唯一的檔案名稱，避免檔案名稱重複
     * @param originalFileName 原始檔案名稱
     * @return 唯一的檔案名稱
     */
    private String generateUniqueFileName(String originalFileName) {
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));
        String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
        return name + "_" + new Date().getTime() + suffix;
    }

    // Getter 和 Setter 方法

    public File[] getUpload() {
        return upload;
    }

    public void setUpload(File[] upload) {
        this.upload = upload;
    }

    public String[] getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String[] uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String[] getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String[] uploadFileName) {
        this.uploadFileName = uploadFileName;
    }
}
