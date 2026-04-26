package com.mayank.jdbcassignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.mayank.jdbcassignment.model.Branch;
import com.mayank.jdbcassignment.util.InputValidation;

public class BranchDAO {

	public int getBranchId(Connection connection, Scanner scanner) {
		String query = "SELECT * FROM branch";
		List<Branch> branches = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("b_id");
				String name = rs.getString("b_name");

				branches.add(new Branch(id, name));
				System.out.println("Id: " + id + " | Name: " + name);
			}
			int b_id;
			while (true) {
				b_id = InputValidation.getValidInt(scanner, "Enter Branch ID: ");
				for (Branch b : branches) {
					if (b.getB_id() == b_id) {
						return b.getB_id();
					}
				}
				System.out.println("Invalid Branch ID, try again!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}