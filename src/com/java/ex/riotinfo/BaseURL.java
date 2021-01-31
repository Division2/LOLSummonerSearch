package com.java.ex.riotinfo;

public class BaseURL {
	//RIOT API KEY
	public static final String API_KEY = "";
	//소환사 검색 URI
	public static final String SEARCH_SUMMONER = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
	//소환사 SOLO, TEAM 5:5 리그 검색 URI
	public static final String SEARCH_SCORE = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/";
	//소환사 TFT 리그 검색 URI
	public static final String SEACRH_TFT = "https://kr.api.riotgames.com/tft/league/v1/entries/by-summoner/";
	//소환사 프로필 이미지 URI
	public static final String PROFILE_ICON = "http://ddragon.leagueoflegends.com/cdn/10.11.1/img/profileicon/";
	//소환사 매치정보 URI
	public static final String MATCH_LISTS = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/";
	//소환사 매치 세부정보 URI
	public static final String MATCH_DETAIL_INFORMATION = "https://kr.api.riotgames.com/lol/match/v4/matches/";
	//소환사 스펠 이미지
	public static final String SUMMONER_SPELLS = "http://ddragon.leagueoflegends.com/cdn/11.2.1/img/spell/";
	//소환사 아이템 이미지
	public static final String SUMMONER_ITEMS = "http://ddragon.leagueoflegends.com/cdn/11.2.1/img/item/";
	//소환사 룬 이미지
	public static final String SUMMONER_MAINRUNES = "https://ddragon.leagueoflegends.com/cdn/img/perk-images/Styles/";
}