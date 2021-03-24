package com.cwlin.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    private int id;
    private String name;
    private List<Student> students; //一个老师拥有多个学生
}
