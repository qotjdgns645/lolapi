package com.mycom.myapp;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class RIOTAPICaller {

	private RestTemplate restTemplate;
	private String APIKEY = "RGAPI-d14c645f-439a-453f-b272-21daf189c2a3";
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	public RIOTAPICaller() {
		this.restTemplate = new RestTemplate();
	}

	public ResponseEntity<SummonerDTO> getSummonerDTO(String userName) {
		URI url = null;
		logger.info("userName : " + userName);
		
		String summonerName = userName.replaceAll(" ", "%20");
		String reqUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key="
				+ APIKEY;
		
		try {
			url = new URI(reqUrl);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		HttpEntity entity = new MakeEntity().makeEntity();
		SummonerDTO userInfo = (SummonerDTO) entity.getBody();
		ResponseEntity<SummonerDTO> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, SummonerDTO.class);
		

		return responseEntity;
	}
	
	public ResponseEntity<String> getLeagueEntryDTO(String encryptedSummonerId){
		String reqUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + encryptedSummonerId + "?api_key=" + APIKEY;
		
		logger.info("requrl : " + reqUrl);
		
		URI url = null;
		try {
			url = new URI(reqUrl);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		HttpEntity entity = new MakeEntity().makeEntity();
		String tier = (String) entity.getBody();
		ResponseEntity<String> responseEntity = restTemplate.exchange(reqUrl, HttpMethod.GET, entity, String.class);
		
		logger.info(responseEntity.getBody());
		
		return responseEntity;
	}
}
