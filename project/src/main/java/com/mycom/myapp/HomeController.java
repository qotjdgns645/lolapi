package com.mycom.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
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
		
		// 모델 객체생성 : 객체 반환
		ModelMap map = new ModelMap();
		
		// 롤 API 메서드 호출
		RIOTAPICaller api = new RIOTAPICaller();
		
		//UserInfo 객체 생성 
		//api 에서 반환하는 UserInfo 객체 받음
		ResponseEntity<SummonerDTO> response = api.getSummonerDTO(userName);
		logger.info("Parameter userName : " + userName);
		logger.info("ResponseEntitiy<UserInfo> Name : " + response.getBody().getName());
		
		map.addAttribute("getName", response.getBody().getName());
		map.addAttribute("getSummonerLevel", response.getBody().getSummonerLevel());
		map.addAttribute("getRevisionDate", response.getBody().getRevisionDate());
		mav.addObject("result", map);
		mav.setViewName("result");
		
		return mav;
	}
	
}
