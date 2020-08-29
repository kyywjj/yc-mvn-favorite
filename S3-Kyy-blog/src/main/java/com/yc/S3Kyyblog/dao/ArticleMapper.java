package com.yc.S3Kyyblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.S3Kyyblog.bean.Article;

public interface ArticleMapper {
	
	@Select("select * from article order by createtime desc")
	//ResultMap->Results
	@Results(id = "rmAm",value= {
			@Result(id=true,column = "id",property = "id"),//缓存性能优化
			@Result (
					column = "categoryid",
					property = "category",
					one = @One(select = "com.yc.S3Kyyblog.dao.CategoryMapper.selectById")
					)
	})
	public List<Article>selectByNew();
	
	@Select("select * from article where id = #{id}")
	@ResultMap("rmAm")
	public Article selectById(int id);
	
	@Select("select * from article where  readCnt>20 ")
	public List<Article> selectByReadCnt();
	
	@Insert("insert into article values (#{id},#{author},#{title},#{content},"
			+ "#{keywords},#{description},#{categoryid},#{label},#{titleimgs},"
			+ "#{status},now(),#{readcnt},#{agreecnt})")
	@Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
	public int insert(Article a);


}
