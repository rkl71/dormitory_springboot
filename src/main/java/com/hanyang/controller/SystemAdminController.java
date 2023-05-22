package com.hanyang.controller;


import com.hanyang.form.RuleForm;
import com.hanyang.service.SystemAdminService;
import com.hanyang.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/systemAdmin")
public class SystemAdminController {

    @Autowired
    private SystemAdminService systemAdminService;
    @GetMapping("/login")
    public ResultVO login(RuleForm ruleForm){
        ResultVO resultVO = this.systemAdminService.login(ruleForm);
        return resultVO;
    }

}

