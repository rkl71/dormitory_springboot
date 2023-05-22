package com.hanyang.vo;

import lombok.Data;


/**
 * ClassName: StudentVO
 * Package: com.hanyang.vo
 * Description:
 *
 * @Author: renkelin
 * @Create: 2023/5/2 - 22:30
 * @Version: v1.0
 */
@Data
public class StudentVO {
    private Integer id;
    private String number;
    private String name;
    private String gender;
    private String dormitoryName;
    private String state;
    private String createDate;
}
