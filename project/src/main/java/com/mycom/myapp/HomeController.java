package com.mycom.myapp;


import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.xdevapi.JsonArray;


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
	public ModelAndView result(HttpSession session, ModelAndView mav, @RequestParam("userName") String userName, HttpServletRequest request) {
		
		RIOTAPICaller api = new RIOTAPICaller();
		ResponseEntity<SummonerDTO> response = api.getSummonerDTO(userName);
		logger.info("Parameter userName : " + userName);
		logger.info("ResponseEntitiy<UserInfo> Name : " + response.getBody().getName());
		
		mav.addObject("SummonerDTO", response.getBody());
		mav.setViewName("result");
		
		SummonerDTO summonerDTO = response.getBody();
		
		session.setAttribute("SummonerDTO", summonerDTO);
		
		SummonerDTO dto = (SummonerDTO) session.getAttribute("SummonerDTO");
		logger.info("getId: " + dto.getId());
		
		return mav;
	}
	
	@RequestMapping(value = "/tier", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String tier(Map<String, String> map ,HttpSession session, HttpServletRequest request) {
		RIOTAPICaller api = new RIOTAPICaller();
		
		SummonerDTO summonerDTO = (SummonerDTO) session.getAttribute("SummonerDTO");
		
		logger.info("id : " + summonerDTO.getId());
		
		ResponseEntity<String> leagueEntryDTO = api.getLeagueEntryDTO(summonerDTO.getId());
		
		logger.info("json data : " + leagueEntryDTO.getBody());
		
		return leagueEntryDTO.getBody();
	}
	
}
