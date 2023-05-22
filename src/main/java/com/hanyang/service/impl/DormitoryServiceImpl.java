package com.hanyang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanyang.entity.Building;
import com.hanyang.entity.Dormitory;
import com.hanyang.entity.Student;
import com.hanyang.form.SearchForm;
import com.hanyang.mapper.BuildingMapper;
import com.hanyang.mapper.DormitoryMapper;
import com.hanyang.mapper.StudentMapper;
import com.hanyang.service.BuildingService;
import com.hanyang.service.DormitoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanyang.vo.DormitoryVO;
import com.hanyang.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-03-16
 */
@Service
public class DormitoryServiceImpl extends ServiceImpl<DormitoryMapper, Dormitory> implements DormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageVO list(Integer page, Integer size) {
        Page<Dormitory> dormitoryPage = new Page<>(page, size);
        Page<Dormitory> resultPage = this.dormitoryMapper.selectPage(dormitoryPage, null);
        List<DormitoryVO> dormitoryVOList = new ArrayList<>();
        for (Dormitory dormitory : resultPage.getRecords()) {
            DormitoryVO dormitoryVO = new DormitoryVO();
            BeanUtils.copyProperties(dormitory, dormitoryVO);
            Building building = this.buildingMapper.selectById(dormitory.getBuildingId());
            dormitoryVO.setBuildingName(building.getName());
            dormitoryVOList.add(dormitoryVO);
        }

        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(dormitoryVOList);
        return pageVO;
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        Page<Dormitory> dormitoryPage = new Page<>(searchForm.getPage(), searchForm.getSize());
        Page<Dormitory> resultPage = null;
        if(searchForm.equals("")){
            resultPage = this.dormitoryMapper.selectPage(dormitoryPage, null);
        }else {
            QueryWrapper<Dormitory> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(searchForm.getKey(), searchForm.getValue());
            resultPage = this.dormitoryMapper.selectPage(dormitoryPage, queryWrapper);
        }
        List<DormitoryVO> dormitoryVOList = new ArrayList<>();
        for (Dormitory dormitory : resultPage.getRecords()) {
            DormitoryVO dormitoryVO = new DormitoryVO();
            BeanUtils.copyProperties(dormitory, dormitoryVO);
            Building building = this.buildingMapper.selectById(dormitory.getBuildingId());
            dormitoryVO.setBuildingName(building.getName());
            dormitoryVOList.add(dormitoryVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(dormitoryVOList);
        return pageVO;
    }

    @Override
    public Boolean deleteById(Integer id){
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq("dormitory_id", id);
        List<Student> studentList = this.studentMapper.selectList(studentQueryWrapper);
        for (Student student : studentList) {
            Integer availableDormitoryId = this.dormitoryMapper.findAvailableDormitoryId();
            student.setDormitoryId(availableDormitoryId);
            try {
                this.studentMapper.updateById(student);
                this.dormitoryMapper.subAvailable(availableDormitoryId);
            } catch (Exception e) {
                return false;
            }
        }
        int delete = this.dormitoryMapper.deleteById(id);
        if(delete != 1) return false;
        return true;
    }
}
