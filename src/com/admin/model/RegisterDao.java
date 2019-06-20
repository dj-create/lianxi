package com.admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.admin.pojo.User;
import com.utils.JdbcUtil;

public class RegisterDao {

	
	
	public int insertUser(User user ){
		
		try {
			
			Connection conn = JdbcUtil.getInstace().getConn();
    
			String sql = "INSERT INTO `tiangou`.`user` (`user_name`, `account`, `user_password`, `user_phone`) VALUES (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getAccount());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getUser_phone());

			int result = ps.executeUpdate();
			return result ;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
