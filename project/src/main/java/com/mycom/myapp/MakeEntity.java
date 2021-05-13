package com.mycom.myapp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class MakeEntity {
	
	private static String User_Agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36";
	private static String Accept_Language ="ko,en;q=0.9,en-US;q=0.8";
	private static String Accept_Charset = "application/x-www-form-urlencoded; charset=UTF-8";
	private static String Origin = "https://developer.riotgames.com";
	private static String APIKEY = null;
	
	public static void setUser_Agent(String user_Agent) {
		User_Agent = user_Agent;
	}

	public static void setAccept_Language(String accept_Language) {
		Accept_Language = accept_Language;
	}

	public static void setAccept_Charset(String accept_Charset) {
		Accept_Charset = accept_Charset;
	}

	public static void setOrigin(String origin) {
		Origin = origin;
	}

	public static void setX_Riot_Token(String x_Riot_Token) {
		APIKEY = x_Riot_Token;
	}

	public HttpEntity<String> makeEntity() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity(headers);
		
		headers.set("User-Agent", User_Agent);
		headers.set("Accept-Language", Accept_Language);
		headers.set("Accept-Charset", Accept_Charset);
		headers.set("Origin", Origin);
		
		return httpEntity;
	}
	
	public HttpEntity<String> makeEntity(String User_Agent, String Accept_Language, String Accept_Charset, String Origin) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity(headers);
		
		headers.set("User-Agent", User_Agent);
		headers.set("Accept-Language", Accept_Language);
		headers.set("Accept-Charset", Accept_Charset);
		headers.set("Origin", Origin);
		
		return httpEntity;
	}
	
	public HttpEntity<String> makeEntity(String User_Agent, String Accept_Language, String Accept_Charset, String Origin, String APIKEY) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity(headers);
		
		headers.set("User-Agent", User_Agent);
		headers.set("Accept-Language", Accept_Language);
		headers.set("Accept-Charset", Accept_Charset);
		headers.set("Origin", Origin);
		headers.set("X-Riot-Token", APIKEY);
		return httpEntity;
	}
}
