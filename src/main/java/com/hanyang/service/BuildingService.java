package com.hanyang.service;

import com.hanyang.entity.Building;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hanyang.form.SearchForm;
import com.hanyang.vo.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-03-16
 */
public interface BuildingService extends IService<Building> {
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean deleteById(Integer id);

}
