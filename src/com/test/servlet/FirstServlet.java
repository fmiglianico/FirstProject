package com.test.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.domain.Restaurant;
import com.test.service.RestaurantService;


public class FirstServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		ArrayList<Restaurant> restaurants = RestaurantService.getAllRestaurants();
		
		request.setAttribute("restaurants", restaurants);
		 
		this.getServletContext().getRequestDispatcher( "/WEB-INF/DisplayRestaurants.jsp" ).forward(request, response);
		 
    }
	
	
}
