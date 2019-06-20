package com.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.ProductDao;
import com.admin.pojo.Goods;

/**
 * Servlet implementation class Product_adminServlet
 */
@WebServlet("/product")
public class Product_adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		ProductDao dao = 	new ProductDao();
		
		List<Goods> producetList = dao.selectProducet();
		
		request.setAttribute("producetList", producetList);

	    request.getRequestDispatcher("/admin/project_list.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
