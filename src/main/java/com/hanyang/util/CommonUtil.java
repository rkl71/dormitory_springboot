package com.hanyang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: CommonUtil
 * Package: com.hanyang.util
 * Description:
 *
 * @Author: renkelin
 * @Create: 2023/5/2 - 21:47
 * @Version: v1.0
 */
public class CommonUtil {
    public static String createDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
}
