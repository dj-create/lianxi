package com.admin.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.admin.pojo.Goods;
import com.utils.JdbcUtil;
public class EditSelectProductDao {

	
	
	public Goods selectProducet(String idd ) {

		try {

			Connection conn = JdbcUtil.getInstace().getConn();

			String sql = "select * from goods where id =?";

			PreparedStatement ps = conn.prepareStatement(sql);
 
			
			ps.setString(1, idd);
			
			ResultSet result = ps.executeQuery();
			Goods pr=null;

			while (result.next()) {

			    int id =result.getInt("id");
				String title = result.getString("title");
				String oldMoney = result.getString("oldMoney");
				String money = result.getString("money");
				String goodNumber = result.getString("goodNumber");
				String goodIntroduction = result.getString("goodIntroduction");
				String sellNumber = result.getString("sellNumber");
				String images = result.getString("images");

				pr = 	new  Goods();
				pr.setId(id);
				pr.setGoodIntroduction(goodIntroduction);
				pr.setGoodNumber(goodNumber);
				pr.setImages(images);
				pr.setMoney(money);
				pr.setOldMoney(oldMoney);
				pr.setSellNumber(sellNumber);
				pr.setTitle(title);
	
			}
			
			return pr;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
