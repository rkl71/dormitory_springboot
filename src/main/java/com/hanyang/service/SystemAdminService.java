package com.hanyang.service;

import com.hanyang.entity.SystemAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hanyang.form.RuleForm;
import com.hanyang.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-03-16
 */
public interface SystemAdminService extends IService<SystemAdmin> {
    public ResultVO login(RuleForm ruleForm);

}
