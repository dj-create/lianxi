package com.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.admin.pojo.User;
import com.utils.JdbcUtil;

public class RegisterUserDao {
public int insertUser(User user ){
		
		try {
			
			Connection conn = JdbcUtil.getInstace().getConn();
    
			String sql = "INSERT INTO `tiangou`.`user` (`email`, `account`, `user_password`) VALUES (?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getAccount());
			ps.setString(3, user.getPassword());
			int result = ps.executeUpdate();
			return result ;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
