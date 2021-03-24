package com.cwlin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//实体类
@Data //无参构造、get、set、toString、hashCode、equals
@AllArgsConstructor //有参构造
@NoArgsConstructor //无参构造
public class User {
    private int id;
    private String name;
    private String pwd;
}
