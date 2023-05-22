package com.hanyang.form;

import lombok.Data;

/**
 * ClassName: StudentForm
 * Package: com.hanyang.form
 * Description:
 *
 * @Author: renkelin
 * @Create: 2023/5/4 - 13:46
 * @Version: v1.0
 */
@Data
public class StudentForm {

    private Integer id;
    private String number;
    private String name;
    private String gender;
    private Integer dormitoryId;
    private Integer oldDormitoryId;
    private String state;
    private String createDate;
}
