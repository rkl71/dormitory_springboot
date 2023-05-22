package com.hanyang.form;

import lombok.Data;

/**
 * ClassName: SearchForm
 * Package: com.hanyang.form
 * Description:
 *
 * @Author: renkelin
 * @Create: 2023/5/1 - 19:58
 * @Version: v1.0
 */
@Data
public class SearchForm {
    private String key;
    private String value;
    private Integer page;
    private Integer size;
}
