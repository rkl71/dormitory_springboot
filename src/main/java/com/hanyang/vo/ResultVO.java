package com.hanyang.vo;

import lombok.Data;

/**
 * ClassName: ResultVO
 * Package: com.hanyang.vo
 * Description:
 *
 * @Author: renkelin
 * @Create: 2023/3/16 - 17:25
 * @Version: v1.0
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private T data;
}
