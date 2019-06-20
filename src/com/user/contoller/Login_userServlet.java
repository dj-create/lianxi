package com.user.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.pojo.User;
import com.alibaba.fastjson.JSONObject;
import com.user.model.Login_userDao;

/**
 * Servlet implementation class Login_userServlet
 */
@WebServlet("/login_user")
public class Login_userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = accpet(request);

		Login_userDao dao = 	new Login_userDao() ; 

		boolean result = dao.selectUser(user);

		
		JSONObject jo = new  JSONObject();
		if (result) {
			jo.put("resultCode", 1);
			jo.put("message", "denglucheenggong");
			
		} else {
			jo.put("resultCode", 0);
			jo.put("message", "cuowu");
		}

		
		response.getWriter().print(jo);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	public  User  accpet(HttpServletRequest request){
		

			String account = request.getParameter("account");
			String password = request.getParameter("password");
			

			User user =  new User();
			
			user.setAccount(account);
			user.setPassword(password);
			return user;
		
	}
}
