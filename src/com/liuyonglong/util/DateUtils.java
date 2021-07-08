package com.liuyonglong.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 将字符串日期转日期对象
     * @param date 字符串日期
     * @param pattern 正则
     * @return 日期对象
     */
    public static Date strTranferDate(String date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date dat = null;
        try {
            dat = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dat;
    }
}
