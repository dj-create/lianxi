package com.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.admin.pojo.User;
import com.utils.JdbcUtil;

public class Login_userDao {

	public boolean selectUser(User user) {

		try {

			Connection conn = JdbcUtil.getInstace().getConn();
			String sql = "SELECT * FROM USER WHERE account =? AND user_password =?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
		
			ResultSet res = ps.executeQuery();

			 
			if (res.next()) {
				
				return true ; 
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;

	}
}
