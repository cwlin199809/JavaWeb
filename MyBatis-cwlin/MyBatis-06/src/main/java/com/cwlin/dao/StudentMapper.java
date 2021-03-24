package com.cwlin.dao;

import com.cwlin.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有学生的信息，以及对应老师的信息
    public List<Student> getStudent();
    public List<Student> getStudent2();
}
