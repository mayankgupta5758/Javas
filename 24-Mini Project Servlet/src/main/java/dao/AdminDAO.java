package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBConnection;

public class AdminDAO {

	public List<String> getAdminCredentials() {
		String query = "select * from admin";
		List<String> list = new ArrayList<String>();
		
		Connection connection = null;

		try {
			connection = DBConnection.conncetToDataBase();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String pass = rs.getString("a_password");
				String name = rs.getString("a_username");
				list.add(name);
				list.add(pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
