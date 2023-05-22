package com.hanyang.service;

import com.hanyang.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hanyang.form.SearchForm;
import com.hanyang.form.StudentForm;
import com.hanyang.vo.PageVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-03-16
 */
public interface StudentService extends IService<Student> {
    public Boolean saveStudent(Student student);
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean update(StudentForm studentForm);
    public Boolean deleteById(Integer id);

}
