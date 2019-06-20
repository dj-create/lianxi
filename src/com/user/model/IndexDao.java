package com.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.admin.pojo.Goods;
import com.utils.JdbcUtil;

public class IndexDao {

	public List<Goods> selectGoods() {

		try {

			Connection conn = JdbcUtil.getInstace().getConn();

			String sql = "select * from goods";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet result = ps.executeQuery();

		    List<Goods> list =new ArrayList<Goods>();
			
			while (result.next()) {

			    int id =result.getInt("id");
				String title = result.getString("title");
				String oldMoney = result.getString("oldMoney");
				String money = result.getString("money");
				String goodNumber = result.getString("goodNumber");
				String goodIntroduction = result.getString("goodIntroduction");
				String sellNumber = result.getString("sellNumber");
				String images = result.getString("images");

				
				
				Goods pr = 	new  Goods();
				
				pr.setId(id);
				pr.setGoodIntroduction(goodIntroduction);
				pr.setGoodNumber(goodNumber);
				pr.setImages(images);
				pr.setMoney(money);
				pr.setOldMoney(oldMoney);
				pr.setTitle(title);
				pr.setSellNumber(sellNumber);
				
				list.add(pr);
				
			}
			
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
