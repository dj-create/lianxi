package com.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.EditSelectProductDao;
import com.admin.pojo.Goods;
/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String projectId = request.getParameter("projectId");
		
		EditSelectProductDao dao= 	new EditSelectProductDao();
		
		Goods selectProducet = dao.selectProducet(projectId);
		request.setAttribute("projectInfo", selectProducet);
		
		
		request.getRequestDispatcher("/admin/project_update.jsp").forward(request, response);
		
	}

}
