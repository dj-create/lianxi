package com.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.admin.model.AddProjectDao;
import com.admin.model.UpdateProductDao;
import com.admin.pojo.Goods;
import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Goods goods = uploadImage(request, response);


		UpdateProductDao dao = new UpdateProductDao();

		int res = dao.updateProduct(goods);

		request.getRequestDispatcher("product").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private Goods uploadImage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Goods goods = new Goods();

		if (ServletFileUpload.isMultipartContent(request)) {
			try {

				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload sfu = new ServletFileUpload(factory);
				sfu.setSizeMax(10 * 1024 * 1024);
				sfu.setHeaderEncoding("utf-8");
				List<FileItem> fileItemList = sfu.parseRequest(request);
				Iterator<FileItem> fileItems = fileItemList.iterator();
				while (fileItems.hasNext()) {
					FileItem fileItem = fileItems.next();
					if (fileItem.isFormField()) {

						String name = fileItem.getFieldName();
						String value = fileItem.getString("utf-8");
						if (name.equals("id")) {
							goods.setId(Integer.parseInt(value));;
						}
						if (name.equals("title")) {
							goods.setTitle(value);
						}
						if (name.equals("oldMoney")) {
							goods.setOldMoney(value);
						}
						if (name.equals("money")) {
							goods.setMoney(value);
						}
						if (name.equals("goodNumber")) {
							goods.setGoodNumber(value);
						}
						if (name.equals("goodIntroduction")) {
							goods.setGoodIntroduction(value);
						}
						if (name.equals("sellNumber")) {
							goods.setSellNumber(value);
						}

					}
					else {
						String fileName = fileItem.getName();
						String suffix = fileName.substring(fileName.lastIndexOf('.'));
						String newFileName = new Date().getTime() + suffix;
						File file = new File(request.getServletContext().getRealPath("/goods") + "\\" + newFileName);
						fileItem.write(file);
						String url = "http://localhost:8081/tiangou_dj/goods/" + newFileName;
						goods.setImages(url);

					}

				}
				return goods;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}
/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		Goods goods = accept(request);
		
		UpdateProductDao dao =  new UpdateProductDao();
		
		int res = dao.updateProduct(goods);
		
		
         JSONObject jo = 	new JSONObject();
		
		jo.put("success", res);
		
		response.getWriter().print(jo);
		
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	doGet(request, response);
}
  public Goods accept(HttpServletRequest request){
		
		
		int id =Integer.parseInt(request.getParameter("id")) ;
		String title=request.getParameter("title");
		String oldMoney=request.getParameter("oldMoney");
		String money=request.getParameter("money");
		String goodNumber=request.getParameter("goodNumber");
		String goodIntroduction=request.getParameter("goodIntroduction");
		String sellNumber=request.getParameter("sellNumber");
		String images=request.getParameter("images");
		
		Goods goods=new Goods();
		
		goods.setId(id);
		goods.setGoodIntroduction(goodIntroduction);
		goods.setGoodNumber(goodNumber);
		goods.setImages(images);
		goods.setMoney(money);
		goods.setOldMoney(oldMoney);
		goods.setSellNumber(sellNumber);
		goods.setTitle(title);
		
		return goods;
		
	}*/
}
