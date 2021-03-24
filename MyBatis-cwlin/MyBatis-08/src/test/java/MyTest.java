import com.cwlin.dao.BlogMapper;
import com.cwlin.pojo.Blog;
import com.cwlin.utils.IdUtils;
import com.cwlin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void insertBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(true); //自动提交事务
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setAuthor("cwlin");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis如此简单");
        mapper.insertBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Java如此简单");
        mapper.insertBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.insertBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("微服务如此简单");
        blog.setViews(1000);
        mapper.insertBlog(blog);

        sqlSession.close();
    }

    @Test
    public void selectBlogIf(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String,String> map = new HashMap<>();
        //map.put("title","Java如此简单");
        map.put("author","cwlin");

        List<Blog> blogs = mapper.selectBlogIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void selectBlogWhen(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String,String> map = new HashMap<>();
        //map.put("title","微服务如此简单");
        map.put("author","cwlin");
        map.put("views","9999");

        List<Blog> blogs = mapper.selectBlogWhen(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String,String> map = new HashMap<>();
        map.put("title","Mybatis如此简单");
        //map.put("author","cwlin2");
        map.put("id","745b8dbf86be42c9b5d3c71b5ca4bcc0");

        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void selectBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);

        List<Blog> blogs = mapper.selectBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
