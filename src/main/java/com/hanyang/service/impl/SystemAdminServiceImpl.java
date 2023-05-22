package com.hanyang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hanyang.entity.DormitoryAdmin;
import com.hanyang.entity.SystemAdmin;
import com.hanyang.form.RuleForm;
import com.hanyang.mapper.SystemAdminMapper;
import com.hanyang.service.SystemAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanyang.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-03-16
 */
@Service
public class SystemAdminServiceImpl extends ServiceImpl<SystemAdminMapper, SystemAdmin> implements SystemAdminService {

    @Autowired
    private SystemAdminMapper systemAdminMapper;
    @Override
    public ResultVO login(RuleForm ruleForm) {
        //1. 判断用户名是否存在
        QueryWrapper<SystemAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", ruleForm.getUsername());
        SystemAdmin systemAdmin = this.systemAdminMapper.selectOne(queryWrapper);

        ResultVO resultVO = new ResultVO();
        if (systemAdmin == null) {
            resultVO.setCode(-1);
        }else {
            //2. 判断密码是否正确
            if(!systemAdmin.getPassword().equals(ruleForm.getPassword())){
                resultVO.setCode(-2);
            }else{
                resultVO.setCode(0);
                resultVO.setData(systemAdmin);
            }
        }
        return resultVO;
    }
}
