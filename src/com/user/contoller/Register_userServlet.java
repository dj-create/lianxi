package com.user.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.pojo.User;
import com.alibaba.fastjson.JSONObject;
import com.user.model.RegisterUserDao;

/**
 * Servlet implementation class Register_userServlet
 */
@WebServlet("/user_login")
public class Register_userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		User user = accept(request);
		
		RegisterUserDao dao = 	new  RegisterUserDao();
		
		int result = dao.insertUser(user);
		
		
		JSONObject jo = new JSONObject() ; 
		if(result==1){
			jo.put("resultCode", 1);
			jo.put("message", "注册成功");
		}else{
			jo.put("resultCode", 0);
			jo.put("message", "注册失败");
		}
		
		
		response.getWriter().println(jo);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	public User accept(HttpServletRequest request){
		
		String email = request.getParameter("email");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setAccount(account);
		
		return  user ; 
	}

}
