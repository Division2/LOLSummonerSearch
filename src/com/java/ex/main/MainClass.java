package com.java.ex.main;

import com.java.ex.riot.SearchSummoner;
import com.java.ex.riotinfo.SummonerInfo;

public class MainClass {
	
	public static void main(String[] args) {
		SummonerInfo sInfo = new SummonerInfo();
		new SearchSummoner(sInfo);
	}
}