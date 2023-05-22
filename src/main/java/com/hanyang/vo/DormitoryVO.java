package com.hanyang.vo;

import lombok.Data;

/**
 * ClassName: DormitoryVO
 * Package: com.hanyang.vo
 * Description:
 *
 * @Author: renkelin
 * @Create: 2023/5/5 - 17:26
 * @Version: v1.0
 */
@Data
public class DormitoryVO {
    private Integer id;

    private String buildingName;

    private String name;

    private Integer type;

    private Integer available;

    private String telephone;
}
