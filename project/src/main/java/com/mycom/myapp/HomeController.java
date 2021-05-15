package com.mycom.myapp;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, ModelAndView mav) {
		logger.info("url : /home");
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		logger.info("url : /login");
		return "login";
	}
	
	@RequestMapping(value = "/summoner", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView result(ModelAndView mav, @RequestParam("userName") String userName) {
		
		RIOTAPICaller api = new RIOTAPICaller();
		ResponseEntity<SummonerDTO> response = api.getSummonerDTO(userName);
		logger.info("Parameter userName : " + userName);
		logger.info("ResponseEntitiy<UserInfo> Name : " + response.getBody().getName());
		
		
		mav.addObject("SummonerDTO", response.getBody());
		mav.setViewName("result");
		
		return mav;
	}
	
}
