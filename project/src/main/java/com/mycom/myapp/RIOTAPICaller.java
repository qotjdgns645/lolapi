package com.mycom.myapp;

import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class RIOTAPICaller {

	private RestTemplate restTemplate;
	private String APIKEY = "RGAPI-5c6b1d10-f42e-4429-b017-ed0e4c87d039";
	
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
}
