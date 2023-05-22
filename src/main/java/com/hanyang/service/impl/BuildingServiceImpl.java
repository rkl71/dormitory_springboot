package com.hanyang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer;
import com.hanyang.entity.Building;
import com.hanyang.entity.Dormitory;
import com.hanyang.entity.Student;
import com.hanyang.form.SearchForm;
import com.hanyang.mapper.BuildingMapper;
import com.hanyang.mapper.DormitoryAdminMapper;
import com.hanyang.mapper.DormitoryMapper;
import com.hanyang.mapper.StudentMapper;
import com.hanyang.service.BuildingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanyang.vo.BuildingVO;
import com.hanyang.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
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
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageVO list(Integer page, Integer size) {
        Page<Building> buildingPage = new Page<>(page, size);
        Page<Building> resultPage = this.buildingMapper.selectPage(buildingPage, null);
        //转换
        List<BuildingVO> buildingVOList = new ArrayList<>();
        for (Building building : resultPage.getRecords()) {
            BuildingVO buildingVO = new BuildingVO();
            BeanUtils.copyProperties(building, buildingVO);
            buildingVO.setAdminName(this.dormitoryAdminMapper.selectById(building.getAdminId()).getName());
            buildingVOList.add(buildingVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setData(buildingVOList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        Page<Building> buildingPage = new Page<>(searchForm.getPage(), searchForm.getSize());
        Page<Building> resultPage = null;
        if(searchForm.getValue().equals("")){
            resultPage = this.buildingMapper.selectPage(buildingPage, null);
        }else {
            QueryWrapper<Building> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(searchForm.getKey(), searchForm.getValue());
            resultPage = this.buildingMapper.selectPage(buildingPage, queryWrapper);
        }
        //转换
        List<BuildingVO> buildingVOList = new ArrayList<>();
        for (Building building : resultPage.getRecords()) {
            BuildingVO buildingVO = new BuildingVO();
            BeanUtils.copyProperties(building, buildingVO);
            buildingVO.setAdminName(this.dormitoryAdminMapper.selectById(building.getAdminId()).getName());
            buildingVOList.add(buildingVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setData(buildingVOList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    @Override
    public Boolean deleteById(Integer id) {
        //找到所有宿舍
        //找到宿舍中所有学生
        //换宿舍
        QueryWrapper<Dormitory> dormitoryQueryWrapper = new QueryWrapper<>();
        dormitoryQueryWrapper.eq("building_id", id);
        List<Dormitory> dormitoryList = this.dormitoryMapper.selectList(dormitoryQueryWrapper);
        for (Dormitory dormitory : dormitoryList) {
            QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
            studentQueryWrapper.eq("dormitory_id", dormitory.getId());
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
            int delete = this.dormitoryMapper.deleteById(dormitory.getId());
            if(delete != 1) return false;
        }
        int delete = this.dormitoryMapper.deleteById(id);
        if(delete != 1) return false;
        return true;
    }
}
