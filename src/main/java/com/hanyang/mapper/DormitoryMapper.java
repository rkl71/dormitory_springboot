package com.hanyang.mapper;

import com.hanyang.entity.Dormitory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2023-03-16
 */
public interface DormitoryMapper extends BaseMapper<Dormitory> {
    public void subAvailable(Integer id);
    public void addAvailable(Integer id);
    public Integer findAvailableDormitoryId();

}
