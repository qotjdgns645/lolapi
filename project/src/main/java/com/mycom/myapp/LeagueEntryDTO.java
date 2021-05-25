package com.mycom.myapp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LeagueEntryDTO{
	
	private String leagueId;
	private String summonerId;
	private String summonerName;
	private String queueType; //GOLD
	private String tier;
	private String rank;//II
	private String leaguePoints; // 17
	private String wins;
	private String losses;
	private String hotStreak;
	private String veteran;
	private String freshBlood;
	private String inactive;
	private MiniSeriesDTO miniSeries;
	
}
