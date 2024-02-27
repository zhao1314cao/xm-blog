package com.example.mapper;

import com.example.entity.Blog;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 操作blog相关数据接口
*/
public interface BlogMapper {

    /**
      * 新增
    */
    int insert(Blog blog);

    /**
      * 删除
    */
    int deleteById(Integer id);

    /**
      * 修改
    */
    int updateById(Blog blog);

    /**
      * 根据ID查询
    */
    Blog selectById(Integer id);

    /**
      * 查询所有
    */
    List<Blog> selectAll(Blog blog);

    /**
     * 查询当前用户的博客
     * @param id
     * @return
     */
    @Select("select * from blog where user_id=#{id}")
    List<Blog> selectUserBlog(Integer id);

    /**
     * 更新阅读量
     * @param blogId
     */
    @Update("update blog set read_count=read_count+1 where id= #{blogId}")
    void updateReadCount(Integer blogId);
}