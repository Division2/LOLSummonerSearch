package com.java.ex.riotinfo;

public class DetailMatchInfo {
	//MatchDto Info
	Long gameId;				//MatchId
	Long gameCreation;		//게임 생성 시간
	Long gameDuration;		//게임 진행 시간
	int queueId;			//queueId (노말, 랭크)
	int mapId;				//mapId (소환사의 협곡, 칼바람 나락)
	int seasonId;			//현재 시즌 Id
	
	public Long getGameId() {
		return gameId;
	}
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	public Long getGameCreation() {
		return gameCreation;
	}
	public void setGameCreation(Long gameCreation) {
		this.gameCreation = gameCreation;
	}
	public Long getGameDuration() {
		return gameDuration;
	}
	public void setGameDuration(Long gameDuration) {
		this.gameDuration = gameDuration;
	}
	public int getQueueId() {
		return queueId;
	}
	public void setQueueId(int queueId) {
		this.queueId = queueId;
	}
	public int getMapId() {
		return mapId;
	}
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	public int getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}
	
	//MatchDto의 teams에 속한 TeamStatsDto
	//팀 모델 Dto
	int statsTeamId;				//TeamId (승리, 패배)
	boolean firstDragon;			//첫 용 처치 여부
	boolean firstBaron;				//첫 바론 처치 여부
	boolean firstRiftHerald;		//첫 전령 처치 여부
	boolean firstTower;				//첫 포탑 처치 여부
	boolean firstInhibitor;			//첫 억제기 처치 여부
	
	int dragonKills;				//용 처치 수
	int baronKills;					//바론 처치 수
	int riftHeraldKills;			//전령 처치 수
	int towerKills;					//타워 파괴 수
	int inhibitorKills;				//억제기 파괴 수
	
	public int getStatsTeamId() {
		return statsTeamId;
	}
	public void setStatsTeamId(int statsTeamId) {
		this.statsTeamId = statsTeamId;
	}
	public boolean isFirstDragon() {
		return firstDragon;
	}
	public void setFirstDragon(boolean firstDragon) {
		this.firstDragon = firstDragon;
	}
	public boolean isFirstBaron() {
		return firstBaron;
	}
	public void setFirstBaron(boolean firstBaron) {
		this.firstBaron = firstBaron;
	}
	public boolean isFirstRiftHerald() {
		return firstRiftHerald;
	}
	public void setFirstRiftHerald(boolean firstRiftHerald) {
		this.firstRiftHerald = firstRiftHerald;
	}
	public boolean isFirstTower() {
		return firstTower;
	}
	public void setFirstTower(boolean firstTower) {
		this.firstTower = firstTower;
	}
	public boolean isFirstInhibitor() {
		return firstInhibitor;
	}
	public void setFirstInhibitor(boolean firstInhibitor) {
		this.firstInhibitor = firstInhibitor;
	}
	public int getDragonKills() {
		return dragonKills;
	}
	public void setDragonKills(int dragonKills) {
		this.dragonKills = dragonKills;
	}
	public int getBaronKills() {
		return baronKills;
	}
	public void setBaronKills(int baronKills) {
		this.baronKills = baronKills;
	}
	public int getRiftHeraldKills() {
		return riftHeraldKills;
	}
	public void setRiftHeraldKills(int riftHeraldKills) {
		this.riftHeraldKills = riftHeraldKills;
	}
	public int getTowerKills() {
		return towerKills;
	}
	public void setTowerKills(int towerKills) {
		this.towerKills = towerKills;
	}
	public int getInhibitorKills() {
		return inhibitorKills;
	}
	public void setInhibitorKills(int inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}

	//TeamStatsDto의 bans에 속한 TeamBansDto
	//벤 모델 Dto
	int pickTurn;					//플레이어 픽 순서
	int championId;					//금지시킨 ChampionId
	
	public int getPickTurn() {
		return pickTurn;
	}
	public void setPickTurn(int pickTurn) {
		this.pickTurn = pickTurn;
	}
	public int getChampionId() {
		return championId;
	}
	public void setChampionId(int championId) {
		this.championId = championId;
	}

	//MatchDto의 participants에 속한 ParticipantDto
	//소환사 별 게임요소 모델 Dto
	int participantId;				//플레이어 Id
	int participantTeamId;			//플레이어가 속한 TeamId
	int summonerChampionId;			//플레이어가 선택한 ChampionId
	int spell1Id;					//플레이어가 사용한 스펠1Id
	int spell2Id;					//플레이어가 사용한 스펠2Id
	
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public int getParticipantTeamId() {
		return participantTeamId;
	}
	public void setParticipantTeamId(int participantTeamId) {
		this.participantTeamId = participantTeamId;
	}
	public int getSummonerChampionId() {
		return summonerChampionId;
	}
	public void setSummonerChampionId(int summonerChampionId) {
		this.summonerChampionId = summonerChampionId;
	}
	public int getSpell1Id() {
		return spell1Id;
	}
	public void setSpell1Id(int spell1Id) {
		this.spell1Id = spell1Id;
	}
	public int getSpell2Id() {
		return spell2Id;
	}
	public void setSpell2Id(int spell2Id) {
		this.spell2Id = spell2Id;
	}
	
	//MatchDto의 participantIdentities에 속한 ParticipantIdentityDto
	//소환사 정보 모델 Dto
	int playerParticipantId;		//플레이어 Id
	
	public int getPlayerParticipantId() {
		return playerParticipantId;
	}
	public void setPlayerParticipantId(int playerParticipantId) {
		this.playerParticipantId = playerParticipantId;
	}

	//ParticipantIdentityDto의 player에 속한 PlayerDto
	//소환사 정보 모델 Dto
	String summonerName;			//소환사 닉네임

	public String getSummonerName() {
		return summonerName;
	}
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	//ParticipantDto의 stats에 속한 ParticipantStatsDto
	//소환사 별 스텟정보 모델 Dto
	int statsParticipantId;			//해당 플레이어의 Id;
	boolean win;					//해당 플레이어의 승리 여부
	int item0;						//해당 플레이어의 첫번째 아이템
	int item1;						//해당 플레이어의 두번째 아이템
	int item2;						//해당 플레이어의 세번째 아이템
	int item3;						//해당 플레이어의 네번째 아이템
	int item4;						//해당 플레이어의 다섯번째 아이템
	int item5;						//해당 플레이어의 여섯번째 아이템
	int item6;						//해당 플레이어의 일곱번째 아이템(장신구)
	int champLevel;					//해당 플레이어의 ChampionLevel
	int kills;						//해당 플레이어의 킬 수
	int deaths;						//해당 플레이어의 데스 수
	int assists;					//해당 플레이어의 어시스트 수
	int doublekills;				//해당 플레이어의 더블킬 수
	int tripleKills;				//해당 플레이어의 트리플킬 수
	int quadraKills;				//해당 플레이어의 쿼드라킬 수
	int pentaKills;					//해당 플레이어의 펜타킬 수
	int mainRune;					//해당 플레이어의 첫번째 룬
	int subRune;					//해당 플레이어의 두번째 룬
	Long totalDamageDealtToChampions;	//해당 플레이어가 가한 총 피해량(챔피언에게)
	int totalDamageDealt;				//해당 플레이어가 가한 총 피해량
	int totalMinionsKilled;				//해당 플레이어가 처치한 미니언 수
	int neutralMinionsKilled;			//해당 플레이어가 처치한 정글 몬스터 수
	int wardsPlaced;					//해당 플레이어가 설치한 와드 수
	int wardsKilled;					//해당 플레이어가 제거한 와드 수
	int visionWardsBoughtInGame;		//해당 플레이어가 구매한 제어 와드 수
	Long visionScore;					//해당 플레이어의 시야 점수

	public int getStatsParticipantId() {
		return statsParticipantId;
	}
	public void setStatsParticipantId(int statsParticipantId) {
		this.statsParticipantId = statsParticipantId;
	}
	public boolean isWin() {
		return win;
	}
	public void setWin(boolean win) {
		this.win = win;
	}
	public int getItem0() {
		return item0;
	}
	public void setItem0(int item0) {
		this.item0 = item0;
	}
	public int getItem1() {
		return item1;
	}
	public void setItem1(int item1) {
		this.item1 = item1;
	}
	public int getItem2() {
		return item2;
	}
	public void setItem2(int item2) {
		this.item2 = item2;
	}
	public int getItem3() {
		return item3;
	}
	public void setItem3(int item3) {
		this.item3 = item3;
	}
	public int getItem4() {
		return item4;
	}
	public void setItem4(int item4) {
		this.item4 = item4;
	}
	public int getItem5() {
		return item5;
	}
	public void setItem5(int item5) {
		this.item5 = item5;
	}
	public int getItem6() {
		return item6;
	}
	public void setItem6(int item6) {
		this.item6 = item6;
	}
	public int getChampLevel() {
		return champLevel;
	}
	public void setChampLevel(int champLevel) {
		this.champLevel = champLevel;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	public int getDoublekills() {
		return doublekills;
	}
	public void setDoublekills(int doublekills) {
		this.doublekills = doublekills;
	}
	public int getTripleKills() {
		return tripleKills;
	}
	public void setTripleKills(int tripleKills) {
		this.tripleKills = tripleKills;
	}
	public int getQuadraKills() {
		return quadraKills;
	}
	public void setQuadraKills(int quadraKills) {
		this.quadraKills = quadraKills;
	}
	public int getPentaKills() {
		return pentaKills;
	}
	public void setPentaKills(int pentaKills) {
		this.pentaKills = pentaKills;
	}
	public int getMainRune() {
		return mainRune;
	}
	public void setMainRune(int mainRune) {
		this.mainRune = mainRune;
	}
	public int getSubRune() {
		return subRune;
	}
	public void setSubRune(int subRune) {
		this.subRune = subRune;
	}
	public Long getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}
	public void setTotalDamageDealtToChampions(Long totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}
	public int getTotalDamageDealt() {
		return totalDamageDealt;
	}
	public void setTotalDamageDealt(int totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}
	public int getTotalMinionsKilled() {
		return totalMinionsKilled;
	}
	public void setTotalMinionsKilled(int totalMinionsKilled) {
		this.totalMinionsKilled = totalMinionsKilled;
	}
	public int getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}
	public void setNeutralMinionsKilled(int neutralMinionsKilled) {
		this.neutralMinionsKilled = neutralMinionsKilled;
	}
	public int getWardsPlaced() {
		return wardsPlaced;
	}
	public void setWardsPlaced(int wardsPlaced) {
		this.wardsPlaced = wardsPlaced;
	}
	public int getWardsKilled() {
		return wardsKilled;
	}
	public void setWardsKilled(int wardsKilled) {
		this.wardsKilled = wardsKilled;
	}
	public int getVisionWardsBoughtInGame() {
		return visionWardsBoughtInGame;
	}
	public void setVisionWardsBoughtInGame(int visionWardsBoughtInGame) {
		this.visionWardsBoughtInGame = visionWardsBoughtInGame;
	}
	public Long getVisionScore() {
		return visionScore;
	}
	public void setVisionScore(Long visionScore) {
		this.visionScore = visionScore;
	}
	
	//Spell Image File Name Information
	String spell1ImgName;
	String spell2ImgName;

	public String getSpell1ImgName() {
		return spell1ImgName;
	}
	public void setSpell1ImgName(String spell1ImgName) {
		this.spell1ImgName = spell1ImgName;
	}
	public String getSpell2ImgName() {
		return spell2ImgName;
	}
	public void setSpell2ImgName(String spell2ImgName) {
		this.spell2ImgName = spell2ImgName;
	}

}