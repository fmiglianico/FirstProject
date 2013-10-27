package com.test.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.dao.RestaurantDAO;
import com.test.domain.Restaurant;

public class RestaurantService {
	
	public static ArrayList<Restaurant> getAllRestaurants() {
		RestaurantDAO handler = RestaurantDAO.getInstance();
		
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		ResultSet rs = null;
		Connection conn = null;

		try {
			conn = handler.getConn();

			String query = "SELECT num_restaurant, typerestau1, typerestau2 FROM restaurant";
			rs = handler.executeQueryRS(conn, query);

			// Traitement a faire ici sur le resultset
			while(rs.next())
				restaurants.add(map(rs));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.err.println("Error in finally: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return restaurants;
	}

	public static Restaurant getRestaurant(int id) {
		
		RestaurantDAO handler = RestaurantDAO.getInstance();
		
		Restaurant restaurant = null;
		ResultSet rs = null;
		Connection conn = null;

		try {
			conn = handler.getConn();

			String query = "SELECT num_restaurant, typerestau1, typerestau2 FROM restaurant WHERE num_restaurant = " + id;
			rs = handler.executeQueryRS(conn, query);

			// Traitement a faire ici sur le resultset
			if(rs.next())
				restaurant = map(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.err.println("Error in finally: " + e.getMessage());
				e.printStackTrace();
			}
		}
	    
	    return restaurant;
	}
	
	private static Restaurant map( ResultSet resultSet ) {
		Restaurant restaurant = new Restaurant();
		
		try {
			restaurant.setId(resultSet.getLong("num_restaurant"));
			restaurant.setType1(resultSet.getString("typerestau1"));
			restaurant.setType2(resultSet.getString("typerestau2"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	    return restaurant;
	}

}
