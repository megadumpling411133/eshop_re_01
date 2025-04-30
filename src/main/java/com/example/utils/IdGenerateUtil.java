package com.example.utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerateUtil implements IdentifierGenerator {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // 獲取當前時間的毫秒級格式化字串
        String dateString = DATE_FORMAT.format(new Date());
        
        // 使用 ThreadLocalRandom 生成 100 到 999 之間的隨機數字
        int num = ThreadLocalRandom.current().nextInt(100, 1000);
        
        // 使用 StringBuilder 合併日期字串與隨機數字
        return new StringBuilder(dateString).append(num).toString();
    }
}
