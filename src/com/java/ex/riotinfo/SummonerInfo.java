package com.java.ex.riotinfo;

public class SummonerInfo {
	//소환사 정보
	String id;
	String accountId;
	String puuid;
	String summonerName;
	int profileIconId;
	Long revisionDate;
	Long sumonerLevel;
	
	//소환사의 리그 정보
	String queueType;
	String tier;
	String tier_rank;
	int leaguePoints;
	int wins;
	int losses;
	
	int pWins;
	int pLosses;
	String progress;
	
	//소환사 정보 getter & setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getPuuid() {
		return puuid;
	}
	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}
	public String getSummonerName() {
		return summonerName;
	}
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	public int getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}
	public Long getRevisionDate() {
		return revisionDate;
	}
	public void setRevisionDate(Long revisionDate) {
		this.revisionDate = revisionDate;
	}
	public Long getSumonerLevel() {
		return sumonerLevel;
	}
	public void setSumonerLevel(Long sumonerLevel) {
		this.sumonerLevel = sumonerLevel;
	}
	
	//소환사 리그정보 getter & setter
	public String getQueueType() {
		return queueType;
	}
	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getTier_rank() {
		return tier_rank;
	}
	public void setTier_rank(String tier_rank) {
		this.tier_rank = tier_rank;
	}
	public int getLeaguePoints() {
		return leaguePoints;
	}
	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	//소환사 승급전 getter & setter
	public int getpWins() {
		return pWins;
	}
	public void setpWins(int pWins) {
		this.pWins = pWins;
	}
	public int getpLosses() {
		return pLosses;
	}
	public void setpLosses(int pLosses) {
		this.pLosses = pLosses;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
}