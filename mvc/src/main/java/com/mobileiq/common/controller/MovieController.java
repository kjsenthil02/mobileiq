package com.mobileiq.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mobileiq.common.model.Movie;

@Controller
public class MovieController {

	@Value("${url}")
	private String remoteUrl;
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
	public @ResponseBody
	Movie getShopInJSON() {

		RestTemplate restTemplate = new RestTemplate();

		Movie movie = new Movie();

		try {
			movie = restTemplate.getForObject(remoteUrl, Movie.class);
		} catch (RuntimeException e) {
			List<String> list = new ArrayList<String>();
			list.add("My Movie 1");
			list.add("My Movie 2");
			list.add("My Movie 3");
			list.add("My Movie 4");
			list.add("My Movie 5");
			list.add("My Movie 6");
			list.add("My Movie 7");
			list.add("My Movie 8");
			list.add("My Movie 9");
			list.add("My Movie 10");
			Random r = new Random();
			int Low = 0;
			int High = 25;
			int R = r.nextInt(High - Low) + Low;
			movie.setName(list.get(R));
		}

		return movie;
	}
}