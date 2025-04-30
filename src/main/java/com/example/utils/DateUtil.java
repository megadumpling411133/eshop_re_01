package com.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * DateUtil 類別提供了日期格式化與解析的方法，主要用來將 Date 物件轉換為字串，
 * 或者將字串轉換為 Date 物件。這些方法通常在處理日期字串與日期格式化時使用，
 * 常見於用戶輸入日期或資料庫日期格式轉換的情境。
 */
public class DateUtil {

    // 定義一個預設的日期格式
    private static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 定義一個支援的日期格式列表，可以根據需求擴展
    private static final List<SimpleDateFormat> SUPPORTED_FORMATS = new ArrayList<>();

    static {
        SUPPORTED_FORMATS.add(DEFAULT_DATE_FORMAT);
        SUPPORTED_FORMATS.add(new SimpleDateFormat("yyyyMMdd"));
        SUPPORTED_FORMATS.add(new SimpleDateFormat("yyyy-MM-dd"));
        SUPPORTED_FORMATS.add(new SimpleDateFormat("HH:mm:ss"));
    }

    /**
     * 將 Date 物件格式化為指定格式的字串。
     * 
     * @param date     要格式化的 Date 物件
     * @param pattern  格式化模式，例如："yyyy-MM-dd HH:mm:ss"
     * @return         格式化後的字串
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null || pattern == null) {
            return null;
        }
        // 使用 SimpleDateFormat 來格式化日期
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * 將字串轉換為 Date 物件，根據指定的格式。
     * 該方法將嘗試多種常見的日期格式來解析字串。
     * 
     * @param dateString 日期字串
     * @param pattern    日期格式模式，例如："yyyy-MM-dd HH:mm:ss"
     * @return           轉換後的 Date 物件，若轉換失敗則返回 null
     */
    public static Date parseDate(String dateString, String pattern) {
        if (dateString == null || pattern == null) {
            return null;
        }

        // 嘗試使用指定的格式進行解析
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            // 當指定的格式解析失敗時，返回 null
            return null;
        }
    }

    /**
     * 嘗試使用多種常見日期格式解析字串。
     * 
     * @param dateString 日期字串
     * @return 解析成功的 Date 物件，若無法解析則返回 null
     */
    public static Date parseDate(String dateString) {
        if (dateString == null) {
            return null;
        }

        for (SimpleDateFormat format : SUPPORTED_FORMATS) {
            try {
                return format.parse(dateString);
            } catch (ParseException e) {
                // 若格式解析失敗，繼續嘗試其他格式
            }
        }
        // 若所有格式都無法解析，則返回 null
        return null;
    }
}
