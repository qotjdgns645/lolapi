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
	private String APIKEY = "RGAPI-056c2b66-9ce6-4465-bc44-cb6081900417";
	
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
		ResponseEntity<String> responseEntity = restTemplate.exchange(reqUrl, HttpMethod.GET, entity, String.class);
		
		logger.info(responseEntity.getBody());
		
		return responseEntity;
	}
	public ResponseEntity<String> getMatch(String puuid){
		String reqUrl = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid + "/ids?start=0&count=10&api_key=" + APIKEY;
		
		logger.info("requrl : " + reqUrl);
		
		URI url = null;
		try {
			url = new URI(reqUrl);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		HttpEntity entity = new MakeEntity().makeEntity();
		
		ResponseEntity<String> responseEntity = restTemplate.exchange(reqUrl, HttpMethod.GET, entity, String.class);
		
		return responseEntity;
	}
	public ResponseEntity<String> getChamp(String encryptedSummonerId){
		String reqUrl = "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/" + encryptedSummonerId + "?api_key=" + APIKEY;
		
		logger.info("champrequrl : " + reqUrl);
		
		URI url = null;
		try {
			url = new URI(reqUrl);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		HttpEntity entity = new MakeEntity().makeEntity();
		ResponseEntity<String> responseEntity = restTemplate.exchange(reqUrl, HttpMethod.GET, entity, String.class);
		
		return responseEntity;
	}
}
