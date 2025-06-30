package com.example.demo.t.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.t.dto.DetailUser;

@Service
public class CustomerService {
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("ドライバのロードに失敗しました");
		}
	}

	@Value("${spring.datasource.username}")
	private String dbUsername;
	
	@Value("${spring.datasource.password}")
	private String dbPassword;
		

	public void jdbcConect(DetailUser detailUser) {

		Connection con = null;
		try {
			// DBへの接続
			con = DriverManager.getConnection("jdbc:postgresql:testdb", dbUsername,dbPassword);

			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO user_data (name, age, sex, address, tel, email) VALUES (?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, detailUser.getUserName());
			pstmt.setInt(2, detailUser.getAge());
			pstmt.setString(3, detailUser.getSex());
			pstmt.setString(4, detailUser.getAddress());
			pstmt.setString(5, detailUser.getTel());
			pstmt.setString(6, detailUser.getMailAddress());

			int r = pstmt.executeUpdate();

			if (r != 0) {
				System.out.println(r + "件のデータを追加しました");
			} else {
				System.out.println("データを追加できませんでした");
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
