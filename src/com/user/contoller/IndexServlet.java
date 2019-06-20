package com.user.contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.pojo.Goods;
import com.alibaba.fastjson.JSONObject;
import com.user.model.IndexDao;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/getGoods")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setCharacterEncoding("UTF-8");
	response.setContentType("application/json; charset=utf-8");
		IndexDao dao = 	new IndexDao();
		List<Goods> producetList = dao.selectGoods();
		System.out.println(producetList);
		JSONObject jo = new  JSONObject();
		jo.put("data", producetList);
		response.getWriter().print(jo);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
