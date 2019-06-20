package com.admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.admin.pojo.Goods;
import com.utils.JdbcUtil;

public class DeleDao {
	public int delePorduct(Goods goods){
		Connection conn=JdbcUtil.getInstace().getConn();
		String sql="delete from goods where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, goods.getIdd());
			int rs = ps.executeUpdate();
			if(rs==1){
				return 1 ;
			}
			return 0 ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0 ;
			
		}
	}
}
