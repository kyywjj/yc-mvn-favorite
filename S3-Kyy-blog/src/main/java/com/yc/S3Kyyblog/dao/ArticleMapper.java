package com.yc.S3Kyyblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yc.S3Kyyblog.bean.Article;

public interface ArticleMapper {
	@Select("select * from article order by createtime desc")
	public List<Article>selectByNew();
	
	@Select("select * from article where id = #{id}")
	public Article selectById(int id);
	
	@Select("select * from article where  readCnt>20 ")
	public List<Article> selectByReadCnt();
	
	@Insert("insert into article values (#{id},#{author},#{title},#{content},"
			+ "#{keywords},#{description},#{categoryid},#{label},#{titleimgs},"
			+ "#{status},now(),#{readcnt},#{agreecnt})")
	
	public int insert(Article a);


}
