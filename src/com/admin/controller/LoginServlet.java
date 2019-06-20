package com.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.LoginDao;
import com.admin.pojo.User;
import com.alibaba.fastjson.JSONObject;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = accpet(request);

		LoginDao dao = 	new LoginDao() ; 

		boolean result = dao.selectUser(user);

		
		JSONObject jo = new  JSONObject();
		
		if (result) {
			jo.put("flag","success");
		}

		
		response.getWriter().print(jo);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	public  User  accpet(HttpServletRequest request){
		

			String name = request.getParameter("name");
			
			String password = request.getParameter("password");

			User user =  new User();
			
			user.setUser_name(name);
			user.setPassword(password);
			return user;
		
	}
	

}
