package com.hanyang.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanyang.entity.DormitoryAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hanyang.form.RuleForm;
import com.hanyang.form.SearchForm;
import com.hanyang.vo.PageVO;
import com.hanyang.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-03-16
 */
public interface DormitoryAdminService extends IService<DormitoryAdmin> {
    public ResultVO login(RuleForm ruleForm);
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
}
