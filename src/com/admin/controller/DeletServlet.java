package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.DeleDao;
import com.admin.pojo.Goods;
import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class DeletServlet
 */
@WebServlet("/pdelete")
public class DeletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("love");

		Goods goods = accpet(request);
		

		DeleDao dao = 	new DeleDao() ; 

		int result = dao.delePorduct(goods);
		
		
		System.out.println(result);
		JSONObject jo = new  JSONObject();
		
			jo.put("keys",result);

		
		response.getWriter().print(jo);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		doGet(request, response);
	}
	
	public  Goods  accpet(HttpServletRequest request){
		

		   String projectID = request.getParameter("projectId");
			
			Goods goods =  new Goods();
			goods.setIdd(projectID);
			System.out.println(goods.getIdd());
		
			return goods;
		
	}

}
