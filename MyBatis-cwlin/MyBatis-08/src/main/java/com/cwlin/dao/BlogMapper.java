package com.cwlin.dao;

import com.cwlin.pojo.Blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    void insertBlog(Blog blog);

    //查询博客
    List<Blog> selectBlogIf(Map<String,String> map);
    List<Blog> selectBlogWhen(Map<String,String> map);

    //更新博客
    void updateBlog(Map<String,String> map);

    //查询第1,2,3号记录的博客
    List<Blog> selectBlogForeach(Map<String, ArrayList<Integer>> map);
}
