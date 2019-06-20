package com.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.RegisterDao;
import com.admin.pojo.User;
import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class Register_tiangouServle
 */
@WebServlet("/register")
public class Register_tiangouServle extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		User user = accept(request);
		
		RegisterDao dao = 	new  RegisterDao();
		
		int resutlt = dao.insertUser(user);
		
		
		JSONObject jo = new JSONObject() ; 
		
		jo.put("success", resutlt);
		
		response.getWriter().println(jo);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	public User accept(HttpServletRequest request){
		
		String user_name = request.getParameter("userName");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		User user = new User();
		user.setUser_name(user_name);
		user.setAccount(account);
		user.setPassword(password);
		user.setUser_phone(phone);
		
		return  user ; 
	}
	
	
	


}
