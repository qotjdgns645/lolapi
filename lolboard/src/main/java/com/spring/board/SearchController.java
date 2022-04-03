package com.spring.board;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SearchController {
	
	final static String API_KEY = "RGAPI-aea90361-4eae-41ef-8d2e-3e3cee29a555";
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String search() throws Exception{
		return "search";
	}

	@RequestMapping(value = "/summoner", method = RequestMethod.GET)
	public String summoner(Model model, HttpServletRequest httpServletRequest) {
		BufferedReader br = null;
		String SummonerName = httpServletRequest.getParameter("title");
		//Summoner temp= null;
		
		
		return "summoner";
	}
	
}
