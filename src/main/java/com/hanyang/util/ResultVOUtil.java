package com.hanyang.util;

import com.hanyang.vo.ResultVO;

/**
 * ClassName: ResiltVOUtil
 * Package: com.hanyang.util
 * Description:
 *
 * @Author: renkelin
 * @Create: 2023/4/15 - 21:26
 * @Version: v1.0
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO fail(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(-1);
        return resultVO;
    }
}
