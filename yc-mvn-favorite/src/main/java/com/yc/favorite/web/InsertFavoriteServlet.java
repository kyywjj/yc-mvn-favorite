package com.yc.favorite.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yc.favorite.FavoriteBiz;
import com.yc.favorite.bean.Favorite;


public class InsertFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String Flable = request.getParameter("Flable");
		String Furl = request.getParameter("Furl");
		String Fdesc = request.getParameter("Fdesc");
		String Ftag = request.getParameter("Ftag");
		
	//	SqlSession session = MyBatisHelper.openSession();
	//	FavoriteMapper fm=session.getMapper(FavoriteMapper.class);
		FavoriteBiz fb=new FavoriteBiz();
		Favorite f=new Favorite();
		
		
		f.setFlabel(Flable);
		f.setFurl(Furl);
		f.setFtags(Ftag);
		f.setFdesc(Fdesc);
		fb.addFavorite(f);
		
		response.getWriter().append("新增成功！");
		//session.commit();
		//session.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
