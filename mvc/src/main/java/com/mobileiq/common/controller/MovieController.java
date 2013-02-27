package com.mobileiq.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobileiq.common.model.Movie;

@Controller
public class MovieController {

	/**
	 * To display view page
	 * 
	 */
	
	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String showView(ModelMap model) {

		model.addAttribute("message", "Mobile IQ Test");
		return "display";

	}
	
	/**
	 * To return the movie as json format
	 * 
	 */
	@RequestMapping(value="/json", method = RequestMethod.GET,headers="Accept=*/*")
	public @ResponseBody Movie getShopInJSON() {

		List<String> list = new ArrayList<String>();
		list.add("The Shawshank Redemption");
		list.add("Forrest Gump");
		list.add("Schindler's List");
		list.add("The Godfather");
		list.add("The Green Mile");
		list.add("Hotel Rwanda");
		list.add("Goodfellas");
		list.add("3:10 to Yuma");
		list.add("Scarface");
		list.add("The Bucket List");
		list.add("The Terminal");
		list.add("My Movie");
		list.add("My Movie 1");
		
		Random r = new Random();
		int Low = 0;
		int High = 25;
		int R = r.nextInt(High-Low) + Low;
		Movie movie = new Movie();
		movie.setName(list.get(R));
		
		return movie;
	}
}