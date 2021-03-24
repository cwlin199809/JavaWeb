package com.cwlin.dao;

import com.cwlin.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    //获取所有老师
    List<Teacher> getTeachers();

    //获取指定老师下所有学生以及老师的信息
    Teacher getTeacher(@Param("tid") int id);
    Teacher getTeacher2(@Param("tid") int id);
}
