package com.hanyang.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanyang.entity.Dormitory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hanyang.form.SearchForm;
import com.hanyang.vo.PageVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-03-16
 */
public interface DormitoryService extends IService<Dormitory> {

    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean deleteById(Integer integer);

}
