package com.mycom.myapp;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.swing.text.html.FormSubmitEvent.MethodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;

public class RIOTAPICaller {

	private RestTemplate restTemplate;
	private String APIKEY = "RGAPI-8da3dc0a-6539-4f38-b826-89f9bf3d353f";

	@Autowired
	public RIOTAPICaller() {
		this.restTemplate = new RestTemplate();
	}

	public ResponseEntity<SummonerDTO> getSummonerDTO(String userName) {
		URI url = null;
		String sumonerName = userName.replaceAll(" ", "%20");
		
		try {
			url = new URI("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + sumonerName + "?api_key="
					+ APIKEY);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		HttpEntity entity = new MakeEntity().makeEntity();
		SummonerDTO userInfo = (SummonerDTO) entity.getBody();
		ResponseEntity<SummonerDTO> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, SummonerDTO.class);
		
		return responseEntity;
	}
}
