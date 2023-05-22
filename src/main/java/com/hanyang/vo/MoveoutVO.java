package com.hanyang.vo;

import lombok.Data;

/**
 * ClassName: MoveoutVO
 * Package: com.hanyang.vo
 * Description:
 *
 * @Author: renkelin
 * @Create: 2023/5/7 - 13:54
 * @Version: v1.0
 */
@Data
public class MoveoutVO {
    private Integer id;
    private String studentName;
    private String dormitoryName;
    private String reason;
    private String createDate;
}
