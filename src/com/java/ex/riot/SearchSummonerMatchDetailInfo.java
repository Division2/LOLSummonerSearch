package com.java.ex.riot;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.java.ex.riotinfo.BaseURL;
import com.java.ex.riotinfo.DetailMatchInfo;

public class SearchSummonerMatchDetailInfo extends JFrame {
	
	Container ct;
	JPanel searchMatchDetailPanel;
	
	//승리팀, 패배팀
	JLabel lblWinnerTeam;
	JLabel lblLossesTeam;
	
	//승리팀 벤픽, 패배팀 벤픽
	JLabel lblWinnerTeamChampionBans;
	JLabel lblLossesTeamChampionBans;
	
	//승리팀 닉네임
	JLabel lblSummonerWinnerNick1;
	JLabel lblSummonerWinnerNick2;
	JLabel lblSummonerWinnerNick3;
	JLabel lblSummonerWinnerNick4;
	JLabel lblSummonerWinnerNick5;
	
	//패배팀 닉네임
	JLabel lblSummonerLossesNick1;
	JLabel lblSummonerLossesNick2;
	JLabel lblSummonerLossesNick3;
	JLabel lblSummonerLossesNick4;
	JLabel lblSummonerLossesNick5;
	
	//승리팀 스펠
	JLabel lblSummonerWinner1Spell1Id;
	JLabel lblSummonerWinner1Spell2Id;
	JLabel lblSummonerWinner2Spell1Id;
	JLabel lblSummonerWinner2Spell2Id;
	JLabel lblSummonerWinner3Spell1Id;
	JLabel lblSummonerWinner3Spell2Id;
	JLabel lblSummonerWinner4Spell1Id;
	JLabel lblSummonerWinner4Spell2Id;
	JLabel lblSummonerWinner5Spell1Id;
	JLabel lblSummonerWinner5Spell2Id;
	
	//패배팀 스펠
	JLabel lblSummonerLosses1Spell1Id;
	JLabel lblSummonerLosses1Spell2Id;
	JLabel lblSummonerLosses2Spell1Id;
	JLabel lblSummonerLosses2Spell2Id;
	JLabel lblSummonerLosses3Spell1Id;
	JLabel lblSummonerLosses3Spell2Id;
	JLabel lblSummonerLosses4Spell1Id;
	JLabel lblSummonerLosses4Spell2Id;
	JLabel lblSummonerLosses5Spell1Id;
	JLabel lblSummonerLosses5Spell2Id;
	
	//승리팀 룬
	JLabel lblSummonerWinner1Rune1Id;
	JLabel lblSummonerWinner1Rune2Id;
	JLabel lblSummonerWinner2Rune1Id;
	JLabel lblSummonerWinner2Rune2Id;
	JLabel lblSummonerWinner3Rune1Id;
	JLabel lblSummonerWinner3Rune2Id;
	JLabel lblSummonerWinner4Rune1Id;
	JLabel lblSummonerWinner4Rune2Id;
	JLabel lblSummonerWinner5Rune1Id;
	JLabel lblSummonerWinner5Rune2Id;
	
	//패배팀 룬
	JLabel lblSummonerLosses1Rune1Id;
	JLabel lblSummonerLosses1Rune2Id;
	JLabel lblSummonerLosses2Rune1Id;
	JLabel lblSummonerLosses2Rune2Id;
	JLabel lblSummonerLosses3Rune1Id;
	JLabel lblSummonerLosses3Rune2Id;
	JLabel lblSummonerLosses4Rune1Id;
	JLabel lblSummonerLosses4Rune2Id;
	JLabel lblSummonerLosses5Rune1Id;
	JLabel lblSummonerLosses5Rune2Id;
	
	//승리팀 KDA
	JLabel lblSummonerWinnerKDA1;
	JLabel lblSummonerWinnerKDA2;
	JLabel lblSummonerWinnerKDA3;
	JLabel lblSummonerWinnerKDA4;
	JLabel lblSummonerWinnerKDA5;
	
	//패배팀 KDA
	JLabel lblSummonerLossesKDA1;
	JLabel lblSummonerLossesKDA2;
	JLabel lblSummonerLossesKDA3;
	JLabel lblSummonerLossesKDA4;
	JLabel lblSummonerLossesKDA5;
	
	//딜량
	JProgressBar SummonerDmgBar1;
	JProgressBar SummonerDmgBar2;
	JProgressBar SummonerDmgBar3;
	JProgressBar SummonerDmgBar4;
	JProgressBar SummonerDmgBar5;
	JProgressBar SummonerDmgBar6;
	JProgressBar SummonerDmgBar7;
	JProgressBar SummonerDmgBar8;
	JProgressBar SummonerDmgBar9;
	JProgressBar SummonerDmgBar10;
	
	JLabel lblSummonerWinnerDamage1;
	JLabel lblSummonerWinnerDamage2;
	JLabel lblSummonerWinnerDamage3;
	JLabel lblSummonerWinnerDamage4;
	JLabel lblSummonerWinnerDamage5;
	JLabel lblSummonerLossesDamage1;
	JLabel lblSummonerLossesDamage2;
	JLabel lblSummonerLossesDamage3;
	JLabel lblSummonerLossesDamage4;
	JLabel lblSummonerLossesDamage5;
	
	//Ward
	JLabel lblSummonerWinnerWard1;
	JLabel lblSummonerWinnerWard2;
	JLabel lblSummonerWinnerWard3;
	JLabel lblSummonerWinnerWard4;
	JLabel lblSummonerWinnerWard5;
	JLabel lblSummonerLossesWard1;
	JLabel lblSummonerLossesWard2;
	JLabel lblSummonerLossesWard3;
	JLabel lblSummonerLossesWard4;
	JLabel lblSummonerLossesWard5;
	
	//CS
	JLabel lblSummonerWinnerCS1;
	JLabel lblSummonerWinnerCS2;
	JLabel lblSummonerWinnerCS3;
	JLabel lblSummonerWinnerCS4;
	JLabel lblSummonerWinnerCS5;
	JLabel lblSummonerLossesCS1;
	JLabel lblSummonerLossesCS2;
	JLabel lblSummonerLossesCS3;
	JLabel lblSummonerLossesCS4;
	JLabel lblSummonerLossesCS5;
	
	//승리팀 아이템
	JLabel lblSummonerWinner1Item0Id;
	JLabel lblSummonerWinner1Item1Id;
	JLabel lblSummonerWinner1Item2Id;
	JLabel lblSummonerWinner1Item3Id;
	JLabel lblSummonerWinner1Item4Id;
	JLabel lblSummonerWinner1Item5Id;
	JLabel lblSummonerWinner1Item6Id;
	JLabel lblSummonerWinner2Item0Id;
	JLabel lblSummonerWinner2Item1Id;
	JLabel lblSummonerWinner2Item2Id;
	JLabel lblSummonerWinner2Item3Id;
	JLabel lblSummonerWinner2Item4Id;
	JLabel lblSummonerWinner2Item5Id;
	JLabel lblSummonerWinner2Item6Id;
	JLabel lblSummonerWinner3Item0Id;
	JLabel lblSummonerWinner3Item1Id;
	JLabel lblSummonerWinner3Item2Id;
	JLabel lblSummonerWinner3Item3Id;
	JLabel lblSummonerWinner3Item4Id;
	JLabel lblSummonerWinner3Item5Id;
	JLabel lblSummonerWinner3Item6Id;
	JLabel lblSummonerWinner4Item0Id;
	JLabel lblSummonerWinner4Item1Id;
	JLabel lblSummonerWinner4Item2Id;
	JLabel lblSummonerWinner4Item3Id;
	JLabel lblSummonerWinner4Item4Id;
	JLabel lblSummonerWinner4Item5Id;
	JLabel lblSummonerWinner4Item6Id;
	JLabel lblSummonerWinner5Item0Id;
	JLabel lblSummonerWinner5Item1Id;
	JLabel lblSummonerWinner5Item2Id;
	JLabel lblSummonerWinner5Item3Id;
	JLabel lblSummonerWinner5Item4Id;
	JLabel lblSummonerWinner5Item5Id;
	JLabel lblSummonerWinner5Item6Id;
	
	//패배팀 아이템
	JLabel lblSummonerLosess1Item0Id;
	JLabel lblSummonerLosess1Item1Id;
	JLabel lblSummonerLosess1Item2Id;
	JLabel lblSummonerLosess1Item3Id;
	JLabel lblSummonerLosess1Item4Id;
	JLabel lblSummonerLosess1Item5Id;
	JLabel lblSummonerLosess1Item6Id;
	JLabel lblSummonerLosess2Item0Id;
	JLabel lblSummonerLosess2Item1Id;
	JLabel lblSummonerLosess2Item2Id;
	JLabel lblSummonerLosess2Item3Id;
	JLabel lblSummonerLosess2Item4Id;
	JLabel lblSummonerLosess2Item5Id;
	JLabel lblSummonerLosess2Item6Id;
	JLabel lblSummonerLosess3Item0Id;
	JLabel lblSummonerLosess3Item1Id;
	JLabel lblSummonerLosess3Item2Id;
	JLabel lblSummonerLosess3Item3Id;
	JLabel lblSummonerLosess3Item4Id;
	JLabel lblSummonerLosess3Item5Id;
	JLabel lblSummonerLosess3Item6Id;
	JLabel lblSummonerLosess4Item0Id;
	JLabel lblSummonerLosess4Item1Id;
	JLabel lblSummonerLosess4Item2Id;
	JLabel lblSummonerLosess4Item3Id;
	JLabel lblSummonerLosess4Item4Id;
	JLabel lblSummonerLosess4Item5Id;
	JLabel lblSummonerLosess4Item6Id;
	JLabel lblSummonerLosess5Item0Id;
	JLabel lblSummonerLosess5Item1Id;
	JLabel lblSummonerLosess5Item2Id;
	JLabel lblSummonerLosess5Item3Id;
	JLabel lblSummonerLosess5Item4Id;
	JLabel lblSummonerLosess5Item5Id;
	JLabel lblSummonerLosess5Item6Id;
	
	//소환사 초상화
	JLabel lblSummonerWinnerChampion1;
	JLabel lblSummonerWinnerChampion2;
	JLabel lblSummonerWinnerChampion3;
	JLabel lblSummonerWinnerChampion4;
	JLabel lblSummonerWinnerChampion5;
	JLabel lblSummonerLossesChampion1;
	JLabel lblSummonerLossesChampion2;
	JLabel lblSummonerLossesChampion3;
	JLabel lblSummonerLossesChampion4;
	JLabel lblSummonerLossesChampion5;
	
	JLabel lblSummonerWinnerChampionLevel1;
	JLabel lblSummonerWinnerChampionLevel2;
	JLabel lblSummonerWinnerChampionLevel3;
	JLabel lblSummonerWinnerChampionLevel4;
	JLabel lblSummonerWinnerChampionLevel5;
	JLabel lblSummonerLossesChampionLevel1;
	JLabel lblSummonerLossesChampionLevel2;
	JLabel lblSummonerLossesChampionLevel3;
	JLabel lblSummonerLossesChampionLevel4;
	JLabel lblSummonerLossesChampionLevel5;
	
	//스펠
	URL spell1IconURL;
	URL spell2IconURL;
	Image spell1Image;
	Image spell2Image;
	Image resizeSpell1Img;
	Image resizeSpell2Img;
	
	String spell1Id;
	String spell2Id;
	
	//아이템
	URL item0IconURL;
	URL item1IconURL;
	URL item2IconURL;
	URL item3IconURL;
	URL item4IconURL;
	URL item5IconURL;
	URL item6IconURL;
	Image item0Image;
	Image item1Image;
	Image item2Image;
	Image item3Image;
	Image item4Image;
	Image item5Image;
	Image item6Image;
	Image resizeItem0Img;
	Image resizeItem1Img;
	Image resizeItem2Img;
	Image resizeItem3Img;
	Image resizeItem4Img;
	Image resizeItem5Img;
	Image resizeItem6Img;
	
	//챔피언
	Image summonerChampionImage;
	Image resizeSummonerChampionImg;
	
	//룬
	URL rune1IconURL;
	URL rune2IconURL;
	Image rune1Image;
	Image rune2Image;
	Image resizeRune1Img;
	Image resizeRune2Img;

	String championName;
	StringBuilder WinnerBanList = new StringBuilder();
	StringBuilder LossesBanList = new StringBuilder();
	
	DetailMatchInfo dmInfo = new DetailMatchInfo();
	// -------------------------- 선언부 --------------------------------------- //
	
	public SearchSummonerMatchDetailInfo(Object gameId) {
		ct = getContentPane();
		searchMatchDetailPanel = new JPanel();
		searchMatchDetailPanel.setLayout(null);
		
//////////////////////////////////////////////////////////승리팀/////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//벤픽, 팀 구분, 소환사 닉네임
		lblWinnerTeamChampionBans = new JLabel();
		lblWinnerTeamChampionBans.setBounds(10, 30, 500, 30);
		
		lblWinnerTeam = new JLabel("승리팀");
		lblWinnerTeam.setBounds(375, 0, 100, 30);

		lblSummonerWinnerNick1 = new JLabel();
		lblSummonerWinnerNick2 = new JLabel();
		lblSummonerWinnerNick3 = new JLabel();
		lblSummonerWinnerNick4 = new JLabel();
		lblSummonerWinnerNick5 = new JLabel();
		lblSummonerWinnerNick1.setBounds(10, 80, 100, 30);
		lblSummonerWinnerNick2.setBounds(10, 130, 100, 30);
		lblSummonerWinnerNick3.setBounds(10, 180, 100, 30);
		lblSummonerWinnerNick4.setBounds(10, 230, 100, 30);
		lblSummonerWinnerNick5.setBounds(10, 280, 100, 30);
		//벤픽, 팀 구분, 소환사 닉네임
		
		//스펠
		lblSummonerWinner1Spell1Id = new JLabel();
		lblSummonerWinner1Spell2Id = new JLabel();
		lblSummonerWinner2Spell1Id = new JLabel();
		lblSummonerWinner2Spell2Id = new JLabel();
		lblSummonerWinner3Spell1Id = new JLabel();
		lblSummonerWinner3Spell2Id = new JLabel();
		lblSummonerWinner4Spell1Id = new JLabel();
		lblSummonerWinner4Spell2Id = new JLabel();
		lblSummonerWinner5Spell1Id = new JLabel();
		lblSummonerWinner5Spell2Id = new JLabel();
		lblSummonerWinner1Spell1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner1Spell2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner2Spell1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner2Spell2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner3Spell1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner3Spell2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner4Spell1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner4Spell2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner5Spell1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner5Spell2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner1Spell1Id.setBounds(120, 80, 16, 16);
		lblSummonerWinner1Spell2Id.setBounds(120, 96, 16, 16);
		lblSummonerWinner2Spell1Id.setBounds(120, 130, 16, 16);
		lblSummonerWinner2Spell2Id.setBounds(120, 146, 16, 16);
		lblSummonerWinner3Spell1Id.setBounds(120, 180, 16, 16);
		lblSummonerWinner3Spell2Id.setBounds(120, 196, 16, 16);
		lblSummonerWinner4Spell1Id.setBounds(120, 230, 16, 16);
		lblSummonerWinner4Spell2Id.setBounds(120, 246, 16, 16);
		lblSummonerWinner5Spell1Id.setBounds(120, 280, 16, 16);
		lblSummonerWinner5Spell2Id.setBounds(120, 296, 16, 16);
		//스펠
		
		//룬
		lblSummonerWinner1Rune1Id = new JLabel();
		lblSummonerWinner1Rune2Id = new JLabel();
		lblSummonerWinner2Rune1Id = new JLabel();
		lblSummonerWinner2Rune2Id = new JLabel();
		lblSummonerWinner3Rune1Id = new JLabel();
		lblSummonerWinner3Rune2Id = new JLabel();
		lblSummonerWinner4Rune1Id = new JLabel();
		lblSummonerWinner4Rune2Id = new JLabel();
		lblSummonerWinner5Rune1Id = new JLabel();
		lblSummonerWinner5Rune2Id = new JLabel();
		lblSummonerWinner1Rune1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner1Rune2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner2Rune1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner2Rune2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner3Rune1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner3Rune2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner4Rune1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner4Rune2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner5Rune1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner5Rune2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner1Rune1Id.setBounds(136, 80, 16, 16);
		lblSummonerWinner1Rune2Id.setBounds(136, 96, 16, 16);
		lblSummonerWinner2Rune1Id.setBounds(136, 130, 16, 16);
		lblSummonerWinner2Rune2Id.setBounds(136, 146, 16, 16);
		lblSummonerWinner3Rune1Id.setBounds(136, 180, 16, 16);
		lblSummonerWinner3Rune2Id.setBounds(136, 196, 16, 16);
		lblSummonerWinner4Rune1Id.setBounds(136, 230, 16, 16);
		lblSummonerWinner4Rune2Id.setBounds(136, 246, 16, 16);
		lblSummonerWinner5Rune1Id.setBounds(136, 280, 16, 16);
		lblSummonerWinner5Rune2Id.setBounds(136, 296, 16, 16);
		//룬
		
		//KDA
		lblSummonerWinnerKDA1 = new JLabel();
		lblSummonerWinnerKDA2 = new JLabel();
		lblSummonerWinnerKDA3 = new JLabel();
		lblSummonerWinnerKDA4 = new JLabel();
		lblSummonerWinnerKDA5 = new JLabel();
		lblSummonerWinnerKDA1.setBounds(170, 80, 100, 30);
		lblSummonerWinnerKDA2.setBounds(170, 130, 100, 30);
		lblSummonerWinnerKDA3.setBounds(170, 180, 100, 30);
		lblSummonerWinnerKDA4.setBounds(170, 230, 100, 30);
		lblSummonerWinnerKDA5.setBounds(170, 280, 100, 30);
		//KDA
		
		//Ward
		lblSummonerWinnerWard1 = new JLabel();
		lblSummonerWinnerWard2 = new JLabel();
		lblSummonerWinnerWard3 = new JLabel();
		lblSummonerWinnerWard4 = new JLabel();
		lblSummonerWinnerWard5 = new JLabel();
		lblSummonerWinnerWard1.setToolTipText("제어와드 / 와드설치 / 와드제거");
		lblSummonerWinnerWard2.setToolTipText("제어와드 / 와드설치 / 와드제거");
		lblSummonerWinnerWard3.setToolTipText("제어와드 / 와드설치 / 와드제거");
		lblSummonerWinnerWard4.setToolTipText("제어와드 / 와드설치 / 와드제거");
		lblSummonerWinnerWard5.setToolTipText("제어와드 / 와드설치 / 와드제거");
		lblSummonerWinnerWard1.setBounds(350, 80, 100, 30);
		lblSummonerWinnerWard2.setBounds(350, 130, 100, 30);
		lblSummonerWinnerWard3.setBounds(350, 180, 100, 30);
		lblSummonerWinnerWard4.setBounds(350, 230, 100, 30);
		lblSummonerWinnerWard5.setBounds(350, 280, 100, 30);
		//Ward
		
		//CS
		lblSummonerWinnerCS1 = new JLabel();
		lblSummonerWinnerCS2 = new JLabel();
		lblSummonerWinnerCS3 = new JLabel();
		lblSummonerWinnerCS4 = new JLabel();
		lblSummonerWinnerCS5 = new JLabel();
		lblSummonerWinnerCS1.setBounds(430, 80, 100, 30);
		lblSummonerWinnerCS2.setBounds(430, 130, 100, 30);
		lblSummonerWinnerCS3.setBounds(430, 180, 100, 30);
		lblSummonerWinnerCS4.setBounds(430, 230, 100, 30);
		lblSummonerWinnerCS5.setBounds(430, 280, 100, 30);
		//CS
		
		//아이템
		lblSummonerWinner1Item0Id = new JLabel();
		lblSummonerWinner1Item1Id = new JLabel();
		lblSummonerWinner1Item2Id = new JLabel();
		lblSummonerWinner1Item3Id = new JLabel();
		lblSummonerWinner1Item4Id = new JLabel();
		lblSummonerWinner1Item5Id = new JLabel();
		lblSummonerWinner1Item6Id = new JLabel();
		lblSummonerWinner1Item0Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner1Item1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner1Item2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner1Item3Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner1Item4Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner1Item5Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner1Item6Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner1Item0Id.setBounds(500, 85, 16, 16);
		lblSummonerWinner1Item1Id.setBounds(516, 85, 16, 16);
		lblSummonerWinner1Item2Id.setBounds(532, 85, 16, 16);
		lblSummonerWinner1Item3Id.setBounds(548, 85, 16, 16);
		lblSummonerWinner1Item4Id.setBounds(564, 85, 16, 16);
		lblSummonerWinner1Item5Id.setBounds(580, 85, 16, 16);
		lblSummonerWinner1Item6Id.setBounds(596, 85, 16, 16);
		
		lblSummonerWinner2Item0Id = new JLabel();
		lblSummonerWinner2Item1Id = new JLabel();
		lblSummonerWinner2Item2Id = new JLabel();
		lblSummonerWinner2Item3Id = new JLabel();
		lblSummonerWinner2Item4Id = new JLabel();
		lblSummonerWinner2Item5Id = new JLabel();
		lblSummonerWinner2Item6Id = new JLabel();
		lblSummonerWinner2Item0Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner2Item1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner2Item2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner2Item3Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner2Item4Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner2Item5Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner2Item6Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner2Item0Id.setBounds(500, 135, 16, 16);
		lblSummonerWinner2Item1Id.setBounds(516, 135, 16, 16);
		lblSummonerWinner2Item2Id.setBounds(532, 135, 16, 16);
		lblSummonerWinner2Item3Id.setBounds(548, 135, 16, 16);
		lblSummonerWinner2Item4Id.setBounds(564, 135, 16, 16);
		lblSummonerWinner2Item5Id.setBounds(580, 135, 16, 16);
		lblSummonerWinner2Item6Id.setBounds(596, 135, 16, 16);
		
		lblSummonerWinner3Item0Id = new JLabel();
		lblSummonerWinner3Item1Id = new JLabel();
		lblSummonerWinner3Item2Id = new JLabel();
		lblSummonerWinner3Item3Id = new JLabel();
		lblSummonerWinner3Item4Id = new JLabel();
		lblSummonerWinner3Item5Id = new JLabel();
		lblSummonerWinner3Item6Id = new JLabel();
		lblSummonerWinner3Item0Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner3Item1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner3Item2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner3Item3Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner3Item4Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner3Item5Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner3Item6Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner3Item0Id.setBounds(500, 185, 16, 16);
		lblSummonerWinner3Item1Id.setBounds(516, 185, 16, 16);
		lblSummonerWinner3Item2Id.setBounds(532, 185, 16, 16);
		lblSummonerWinner3Item3Id.setBounds(548, 185, 16, 16);
		lblSummonerWinner3Item4Id.setBounds(564, 185, 16, 16);
		lblSummonerWinner3Item5Id.setBounds(580, 185, 16, 16);
		lblSummonerWinner3Item6Id.setBounds(596, 185, 16, 16);
		
		lblSummonerWinner4Item0Id = new JLabel();
		lblSummonerWinner4Item1Id = new JLabel();
		lblSummonerWinner4Item2Id = new JLabel();
		lblSummonerWinner4Item3Id = new JLabel();
		lblSummonerWinner4Item4Id = new JLabel();
		lblSummonerWinner4Item5Id = new JLabel();
		lblSummonerWinner4Item6Id = new JLabel();
		lblSummonerWinner4Item0Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner4Item1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner4Item2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner4Item3Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner4Item4Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner4Item5Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner4Item6Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner4Item0Id.setBounds(500, 235, 16, 16);
		lblSummonerWinner4Item1Id.setBounds(516, 235, 16, 16);
		lblSummonerWinner4Item2Id.setBounds(532, 235, 16, 16);
		lblSummonerWinner4Item3Id.setBounds(548, 235, 16, 16);
		lblSummonerWinner4Item4Id.setBounds(564, 235, 16, 16);
		lblSummonerWinner4Item5Id.setBounds(580, 235, 16, 16);
		lblSummonerWinner4Item6Id.setBounds(596, 235, 16, 16);
		
		lblSummonerWinner5Item0Id = new JLabel();
		lblSummonerWinner5Item1Id = new JLabel();
		lblSummonerWinner5Item2Id = new JLabel();
		lblSummonerWinner5Item3Id = new JLabel();
		lblSummonerWinner5Item4Id = new JLabel();
		lblSummonerWinner5Item5Id = new JLabel();
		lblSummonerWinner5Item6Id = new JLabel();
		lblSummonerWinner5Item0Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner5Item1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner5Item2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner5Item3Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner5Item4Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner5Item5Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner5Item6Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerWinner5Item0Id.setBounds(500, 285, 16, 16);
		lblSummonerWinner5Item1Id.setBounds(516, 285, 16, 16);
		lblSummonerWinner5Item2Id.setBounds(532, 285, 16, 16);
		lblSummonerWinner5Item3Id.setBounds(548, 285, 16, 16);
		lblSummonerWinner5Item4Id.setBounds(564, 285, 16, 16);
		lblSummonerWinner5Item5Id.setBounds(580, 285, 16, 16);
		lblSummonerWinner5Item6Id.setBounds(596, 285, 16, 16);
		//아이템
		
		//소환사 챔피언 초상화
		lblSummonerWinnerChampion1 = new JLabel();
		lblSummonerWinnerChampion2 = new JLabel();
		lblSummonerWinnerChampion3 = new JLabel();
		lblSummonerWinnerChampion4 = new JLabel();
		lblSummonerWinnerChampion5 = new JLabel();
		lblSummonerWinnerChampion1.setBounds(620, 75, 32, 32);
		lblSummonerWinnerChampion2.setBounds(620, 125, 32, 32);
		lblSummonerWinnerChampion3.setBounds(620, 175, 32, 32);
		lblSummonerWinnerChampion4.setBounds(620, 225, 32, 32);
		lblSummonerWinnerChampion5.setBounds(620, 275, 32, 32);
		//소환사 챔피언 초상화
		
		//소환사 챔피언 레벨
		lblSummonerWinnerChampionLevel1 = new JLabel();
		lblSummonerWinnerChampionLevel2 = new JLabel();
		lblSummonerWinnerChampionLevel3 = new JLabel();
		lblSummonerWinnerChampionLevel4 = new JLabel();
		lblSummonerWinnerChampionLevel5 = new JLabel();
		lblSummonerWinnerChampionLevel1.setBounds(660, 85, 100, 30);
		lblSummonerWinnerChampionLevel2.setBounds(660, 135, 100, 30);
		lblSummonerWinnerChampionLevel3.setBounds(660, 185, 100, 30);
		lblSummonerWinnerChampionLevel4.setBounds(660, 235, 100, 30);
		lblSummonerWinnerChampionLevel5.setBounds(660, 285, 100, 30);
		//소환사 챔피언 레벨
		
//////////////////////////////////////////////////////////패배팀/////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//벤픽, 팀 구분, 소환사 닉네임
		lblLossesTeamChampionBans = new JLabel();
		lblLossesTeamChampionBans.setBounds(10, 370, 500, 30);
		
		lblLossesTeam = new JLabel("패배팀");
		lblLossesTeam.setBounds(375, 350, 100, 30);

		lblSummonerLossesNick1 = new JLabel();
		lblSummonerLossesNick2 = new JLabel();
		lblSummonerLossesNick3 = new JLabel();
		lblSummonerLossesNick4 = new JLabel();
		lblSummonerLossesNick5 = new JLabel();
		lblSummonerLossesNick1.setBounds(10, 420, 100, 30);
		lblSummonerLossesNick2.setBounds(10, 470, 100, 30);
		lblSummonerLossesNick3.setBounds(10, 520, 100, 30);
		lblSummonerLossesNick4.setBounds(10, 570, 100, 30);
		lblSummonerLossesNick5.setBounds(10, 620, 100, 30);
		//벤픽, 팀 구분, 소환사 닉네임
		
		//스펠
		lblSummonerLosses1Spell1Id = new JLabel();
		lblSummonerLosses1Spell2Id = new JLabel();
		lblSummonerLosses2Spell1Id = new JLabel();
		lblSummonerLosses2Spell2Id = new JLabel();
		lblSummonerLosses3Spell1Id = new JLabel();
		lblSummonerLosses3Spell2Id = new JLabel();
		lblSummonerLosses4Spell1Id = new JLabel();
		lblSummonerLosses4Spell2Id = new JLabel();
		lblSummonerLosses5Spell1Id = new JLabel();
		lblSummonerLosses5Spell2Id = new JLabel();
		lblSummonerLosses1Spell1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses1Spell2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses2Spell1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses2Spell2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses3Spell1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses3Spell2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses4Spell1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses4Spell2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses5Spell1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses5Spell2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses1Spell1Id.setBounds(120, 420, 16, 16);
		lblSummonerLosses1Spell2Id.setBounds(120, 436, 16, 16);
		lblSummonerLosses2Spell1Id.setBounds(120, 470, 16, 16);
		lblSummonerLosses2Spell2Id.setBounds(120, 486, 16, 16);
		lblSummonerLosses3Spell1Id.setBounds(120, 520, 16, 16);
		lblSummonerLosses3Spell2Id.setBounds(120, 536, 16, 16);
		lblSummonerLosses4Spell1Id.setBounds(120, 570, 16, 16);
		lblSummonerLosses4Spell2Id.setBounds(120, 586, 16, 16);
		lblSummonerLosses5Spell1Id.setBounds(120, 620, 16, 16);
		lblSummonerLosses5Spell2Id.setBounds(120, 636, 16, 16);
		//스펠
		
		//룬
		lblSummonerLosses1Rune1Id = new JLabel();
		lblSummonerLosses1Rune2Id = new JLabel();
		lblSummonerLosses2Rune1Id = new JLabel();
		lblSummonerLosses2Rune2Id = new JLabel();
		lblSummonerLosses3Rune1Id = new JLabel();
		lblSummonerLosses3Rune2Id = new JLabel();
		lblSummonerLosses4Rune1Id = new JLabel();
		lblSummonerLosses4Rune2Id = new JLabel();
		lblSummonerLosses5Rune1Id = new JLabel();
		lblSummonerLosses5Rune2Id = new JLabel();
		lblSummonerLosses1Rune1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses1Rune2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses2Rune1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses2Rune2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses3Rune1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses3Rune2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses4Rune1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses4Rune2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses5Rune1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses5Rune2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosses1Rune1Id.setBounds(136, 420, 16, 16);
		lblSummonerLosses1Rune2Id.setBounds(136, 436, 16, 16);
		lblSummonerLosses2Rune1Id.setBounds(136, 470, 16, 16);
		lblSummonerLosses2Rune2Id.setBounds(136, 486, 16, 16);
		lblSummonerLosses3Rune1Id.setBounds(136, 520, 16, 16);
		lblSummonerLosses3Rune2Id.setBounds(136, 536, 16, 16);
		lblSummonerLosses4Rune1Id.setBounds(136, 570, 16, 16);
		lblSummonerLosses4Rune2Id.setBounds(136, 586, 16, 16);
		lblSummonerLosses5Rune1Id.setBounds(136, 620, 16, 16);
		lblSummonerLosses5Rune2Id.setBounds(136, 636, 16, 16);
		//룬
		
		//KDA
		lblSummonerLossesKDA1 = new JLabel();
		lblSummonerLossesKDA2 = new JLabel();
		lblSummonerLossesKDA3 = new JLabel();
		lblSummonerLossesKDA4 = new JLabel();
		lblSummonerLossesKDA5 = new JLabel();
		lblSummonerLossesKDA1.setBounds(170, 420, 100, 30);
		lblSummonerLossesKDA2.setBounds(170, 470, 100, 30);
		lblSummonerLossesKDA3.setBounds(170, 520, 100, 30);
		lblSummonerLossesKDA4.setBounds(170, 570, 100, 30);
		lblSummonerLossesKDA5.setBounds(170, 620, 100, 30);
		//KDA
		
		//Ward
		lblSummonerLossesWard1 = new JLabel();
		lblSummonerLossesWard2 = new JLabel();
		lblSummonerLossesWard3 = new JLabel();
		lblSummonerLossesWard4 = new JLabel();
		lblSummonerLossesWard5 = new JLabel();
		lblSummonerLossesWard1.setToolTipText("제어와드 / 와드설치 / 와드제거");
		lblSummonerLossesWard2.setToolTipText("제어와드 / 와드설치 / 와드제거");
		lblSummonerLossesWard3.setToolTipText("제어와드 / 와드설치 / 와드제거");
		lblSummonerLossesWard4.setToolTipText("제어와드 / 와드설치 / 와드제거");
		lblSummonerLossesWard5.setToolTipText("제어와드 / 와드설치 / 와드제거");
		lblSummonerLossesWard1.setBounds(350, 420, 100, 30);
		lblSummonerLossesWard2.setBounds(350, 470, 100, 30);
		lblSummonerLossesWard3.setBounds(350, 520, 100, 30);
		lblSummonerLossesWard4.setBounds(350, 570, 100, 30);
		lblSummonerLossesWard5.setBounds(350, 620, 100, 30);
		//Ward
		
		//CS
		lblSummonerLossesCS1 = new JLabel();
		lblSummonerLossesCS2 = new JLabel();
		lblSummonerLossesCS3 = new JLabel();
		lblSummonerLossesCS4 = new JLabel();
		lblSummonerLossesCS5 = new JLabel();
		lblSummonerLossesCS1.setBounds(430, 420, 100, 30);
		lblSummonerLossesCS2.setBounds(430, 470, 100, 30);
		lblSummonerLossesCS3.setBounds(430, 520, 100, 30);
		lblSummonerLossesCS4.setBounds(430, 570, 100, 30);
		lblSummonerLossesCS5.setBounds(430, 620, 100, 30);
		//CS
		
		//아이템
		lblSummonerLosess1Item0Id = new JLabel();
		lblSummonerLosess1Item1Id = new JLabel();
		lblSummonerLosess1Item2Id = new JLabel();
		lblSummonerLosess1Item3Id = new JLabel();
		lblSummonerLosess1Item4Id = new JLabel();
		lblSummonerLosess1Item5Id = new JLabel();
		lblSummonerLosess1Item6Id = new JLabel();
		lblSummonerLosess1Item0Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess1Item1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess1Item2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess1Item3Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess1Item4Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess1Item5Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess1Item6Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess1Item0Id.setBounds(500, 425, 16, 16);
		lblSummonerLosess1Item1Id.setBounds(516, 425, 16, 16);
		lblSummonerLosess1Item2Id.setBounds(532, 425, 16, 16);
		lblSummonerLosess1Item3Id.setBounds(548, 425, 16, 16);
		lblSummonerLosess1Item4Id.setBounds(564, 425, 16, 16);
		lblSummonerLosess1Item5Id.setBounds(580, 425, 16, 16);
		lblSummonerLosess1Item6Id.setBounds(596, 425, 16, 16);

		lblSummonerLosess2Item0Id = new JLabel();
		lblSummonerLosess2Item1Id = new JLabel();
		lblSummonerLosess2Item2Id = new JLabel();
		lblSummonerLosess2Item3Id = new JLabel();
		lblSummonerLosess2Item4Id = new JLabel();
		lblSummonerLosess2Item5Id = new JLabel();
		lblSummonerLosess2Item6Id = new JLabel();
		lblSummonerLosess2Item0Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess2Item1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess2Item2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess2Item3Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess2Item4Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess2Item5Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess2Item6Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess2Item0Id.setBounds(500, 475, 16, 16);
		lblSummonerLosess2Item1Id.setBounds(516, 475, 16, 16);
		lblSummonerLosess2Item2Id.setBounds(532, 475, 16, 16);
		lblSummonerLosess2Item3Id.setBounds(548, 475, 16, 16);
		lblSummonerLosess2Item4Id.setBounds(564, 475, 16, 16);
		lblSummonerLosess2Item5Id.setBounds(580, 475, 16, 16);
		lblSummonerLosess2Item6Id.setBounds(596, 475, 16, 16);
		
		lblSummonerLosess3Item0Id = new JLabel();
		lblSummonerLosess3Item1Id = new JLabel();
		lblSummonerLosess3Item2Id = new JLabel();
		lblSummonerLosess3Item3Id = new JLabel();
		lblSummonerLosess3Item4Id = new JLabel();
		lblSummonerLosess3Item5Id = new JLabel();
		lblSummonerLosess3Item6Id = new JLabel();
		lblSummonerLosess3Item0Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess3Item1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess3Item2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess3Item3Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess3Item4Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess3Item5Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess3Item6Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess3Item0Id.setBounds(500, 525, 16, 16);
		lblSummonerLosess3Item1Id.setBounds(516, 525, 16, 16);
		lblSummonerLosess3Item2Id.setBounds(532, 525, 16, 16);
		lblSummonerLosess3Item3Id.setBounds(548, 525, 16, 16);
		lblSummonerLosess3Item4Id.setBounds(564, 525, 16, 16);
		lblSummonerLosess3Item5Id.setBounds(580, 525, 16, 16);
		lblSummonerLosess3Item6Id.setBounds(596, 525, 16, 16);
		
		lblSummonerLosess4Item0Id = new JLabel();
		lblSummonerLosess4Item1Id = new JLabel();
		lblSummonerLosess4Item2Id = new JLabel();
		lblSummonerLosess4Item3Id = new JLabel();
		lblSummonerLosess4Item4Id = new JLabel();
		lblSummonerLosess4Item5Id = new JLabel();
		lblSummonerLosess4Item6Id = new JLabel();
		lblSummonerLosess4Item0Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess4Item1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess4Item2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess4Item3Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess4Item4Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess4Item5Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess4Item6Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess4Item0Id.setBounds(500, 575, 16, 16);
		lblSummonerLosess4Item1Id.setBounds(516, 575, 16, 16);
		lblSummonerLosess4Item2Id.setBounds(532, 575, 16, 16);
		lblSummonerLosess4Item3Id.setBounds(548, 575, 16, 16);
		lblSummonerLosess4Item4Id.setBounds(564, 575, 16, 16);
		lblSummonerLosess4Item5Id.setBounds(580, 575, 16, 16);
		lblSummonerLosess4Item6Id.setBounds(596, 575, 16, 16);
		
		lblSummonerLosess5Item0Id = new JLabel();
		lblSummonerLosess5Item1Id = new JLabel();
		lblSummonerLosess5Item2Id = new JLabel();
		lblSummonerLosess5Item3Id = new JLabel();
		lblSummonerLosess5Item4Id = new JLabel();
		lblSummonerLosess5Item5Id = new JLabel();
		lblSummonerLosess5Item6Id = new JLabel();
		lblSummonerLosess5Item0Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess5Item1Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess5Item2Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess5Item3Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess5Item4Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess5Item5Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess5Item6Id.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lblSummonerLosess5Item0Id.setBounds(500, 625, 16, 16);
		lblSummonerLosess5Item1Id.setBounds(516, 625, 16, 16);
		lblSummonerLosess5Item2Id.setBounds(532, 625, 16, 16);
		lblSummonerLosess5Item3Id.setBounds(548, 625, 16, 16);
		lblSummonerLosess5Item4Id.setBounds(564, 625, 16, 16);
		lblSummonerLosess5Item5Id.setBounds(580, 625, 16, 16);
		lblSummonerLosess5Item6Id.setBounds(596, 625, 16, 16);
		//아이템
		
		//소환사 챔피언 초상화
		lblSummonerLossesChampion1 = new JLabel();
		lblSummonerLossesChampion2 = new JLabel();
		lblSummonerLossesChampion3 = new JLabel();
		lblSummonerLossesChampion4 = new JLabel();
		lblSummonerLossesChampion5 = new JLabel();
		lblSummonerLossesChampion1.setBounds(620, 415, 32, 32);
		lblSummonerLossesChampion2.setBounds(620, 465, 32, 32);
		lblSummonerLossesChampion3.setBounds(620, 515, 32, 32);
		lblSummonerLossesChampion4.setBounds(620, 565, 32, 32);
		lblSummonerLossesChampion5.setBounds(620, 615, 32, 32);
		//소환사 챔피언 초상화
		
		//소환사 챔피언 레벨
		lblSummonerLossesChampionLevel1 = new JLabel();
		lblSummonerLossesChampionLevel2 = new JLabel();
		lblSummonerLossesChampionLevel3 = new JLabel();
		lblSummonerLossesChampionLevel4 = new JLabel();
		lblSummonerLossesChampionLevel5 = new JLabel();
		lblSummonerLossesChampionLevel1.setBounds(660, 425, 100, 30);
		lblSummonerLossesChampionLevel2.setBounds(660, 475, 100, 30);
		lblSummonerLossesChampionLevel3.setBounds(660, 525, 100, 30);
		lblSummonerLossesChampionLevel4.setBounds(660, 575, 100, 30);
		lblSummonerLossesChampionLevel5.setBounds(660, 625, 100, 30);
		//소환사 챔피언 레벨
		
//////////////////////////////////////////////////////////공통//////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//딜량 (데미지바 y 좌표는 진팀부터 처리했음)
		SummonerDmgBar1 = new JProgressBar(0, 50000);
		SummonerDmgBar2 = new JProgressBar(0, 50000);
		SummonerDmgBar3 = new JProgressBar(0, 50000);
		SummonerDmgBar4 = new JProgressBar(0, 50000);
		SummonerDmgBar5 = new JProgressBar(0, 50000);
		SummonerDmgBar6 = new JProgressBar(0, 50000);
		SummonerDmgBar7 = new JProgressBar(0, 50000);
		SummonerDmgBar8 = new JProgressBar(0, 50000);
		SummonerDmgBar9 = new JProgressBar(0, 50000);
		SummonerDmgBar10 = new JProgressBar(0, 50000);
		SummonerDmgBar1.setBounds(220, 435, 100, 15);
		SummonerDmgBar2.setBounds(220, 485, 100, 15);
		SummonerDmgBar3.setBounds(220, 535, 100, 15);
		SummonerDmgBar4.setBounds(220, 585, 100, 15);
		SummonerDmgBar5.setBounds(220, 635, 100, 15);
		SummonerDmgBar6.setBounds(220, 95, 100, 15);
		SummonerDmgBar7.setBounds(220, 145, 100, 15);
		SummonerDmgBar8.setBounds(220, 195, 100, 15);
		SummonerDmgBar9.setBounds(220, 245, 100, 15);
		SummonerDmgBar10.setBounds(220, 295, 100, 15);
		SummonerDmgBar1.setBackground(Color.white);
		SummonerDmgBar2.setBackground(Color.white);
		SummonerDmgBar3.setBackground(Color.white);
		SummonerDmgBar4.setBackground(Color.white);
		SummonerDmgBar5.setBackground(Color.white);
		SummonerDmgBar6.setBackground(Color.white);
		SummonerDmgBar7.setBackground(Color.white);
		SummonerDmgBar8.setBackground(Color.white);
		SummonerDmgBar9.setBackground(Color.white);
		SummonerDmgBar10.setBackground(Color.white);
		SummonerDmgBar1.setForeground(Color.decode("#FF8B8B"));
		SummonerDmgBar2.setForeground(Color.decode("#FF8B8B"));
		SummonerDmgBar3.setForeground(Color.decode("#FF8B8B"));
		SummonerDmgBar4.setForeground(Color.decode("#FF8B8B"));
		SummonerDmgBar5.setForeground(Color.decode("#FF8B8B"));
		SummonerDmgBar6.setForeground(Color.decode("#FF8B8B"));
		SummonerDmgBar7.setForeground(Color.decode("#FF8B8B"));
		SummonerDmgBar8.setForeground(Color.decode("#FF8B8B"));
		SummonerDmgBar9.setForeground(Color.decode("#FF8B8B"));
		SummonerDmgBar10.setForeground(Color.decode("#FF8B8B"));
		SummonerDmgBar1.setBorder(null);
		SummonerDmgBar2.setBorder(null);
		SummonerDmgBar3.setBorder(null);
		SummonerDmgBar4.setBorder(null);
		SummonerDmgBar5.setBorder(null);
		SummonerDmgBar6.setBorder(null);
		SummonerDmgBar7.setBorder(null);
		SummonerDmgBar8.setBorder(null);
		SummonerDmgBar9.setBorder(null);
		SummonerDmgBar10.setBorder(null);
		
		lblSummonerWinnerDamage1 = new JLabel();
		lblSummonerWinnerDamage2 = new JLabel();
		lblSummonerWinnerDamage3 = new JLabel();
		lblSummonerWinnerDamage4 = new JLabel();
		lblSummonerWinnerDamage5 = new JLabel();
		lblSummonerLossesDamage1 = new JLabel();
		lblSummonerLossesDamage2 = new JLabel();
		lblSummonerLossesDamage3 = new JLabel();
		lblSummonerLossesDamage4 = new JLabel();
		lblSummonerLossesDamage5 = new JLabel();
		lblSummonerWinnerDamage1.setBounds(220, 70, 100, 30);
		lblSummonerWinnerDamage2.setBounds(220, 120, 100, 30);
		lblSummonerWinnerDamage3.setBounds(220, 170, 100, 30);
		lblSummonerWinnerDamage4.setBounds(220, 220, 100, 30);
		lblSummonerWinnerDamage5.setBounds(220, 270, 100, 30);
		lblSummonerLossesDamage1.setBounds(220, 410, 100, 30);
		lblSummonerLossesDamage2.setBounds(220, 460, 100, 30);
		lblSummonerLossesDamage3.setBounds(220, 510, 100, 30);
		lblSummonerLossesDamage4.setBounds(220, 560, 100, 30);
		lblSummonerLossesDamage5.setBounds(220, 610, 100, 30);
		//딜량
		
//////////////////////////////////////////////////////////패널추가////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//벤픽, 팀 구분, 소환사 닉네임
		searchMatchDetailPanel.add(lblWinnerTeamChampionBans);
		searchMatchDetailPanel.add(lblWinnerTeam);
		searchMatchDetailPanel.add(lblSummonerWinnerNick1);
		searchMatchDetailPanel.add(lblSummonerWinnerNick2);
		searchMatchDetailPanel.add(lblSummonerWinnerNick3);
		searchMatchDetailPanel.add(lblSummonerWinnerNick4);
		searchMatchDetailPanel.add(lblSummonerWinnerNick5);
		searchMatchDetailPanel.add(lblLossesTeamChampionBans);
		searchMatchDetailPanel.add(lblLossesTeam);
		searchMatchDetailPanel.add(lblSummonerLossesNick1);
		searchMatchDetailPanel.add(lblSummonerLossesNick2);
		searchMatchDetailPanel.add(lblSummonerLossesNick3);
		searchMatchDetailPanel.add(lblSummonerLossesNick4);
		searchMatchDetailPanel.add(lblSummonerLossesNick5);
		//벤픽, 팀 구분, 소환사 닉네임
		
		//스펠
		searchMatchDetailPanel.add(lblSummonerWinner1Spell1Id);
		searchMatchDetailPanel.add(lblSummonerWinner1Spell2Id);
		searchMatchDetailPanel.add(lblSummonerWinner2Spell1Id);
		searchMatchDetailPanel.add(lblSummonerWinner2Spell2Id);
		searchMatchDetailPanel.add(lblSummonerWinner3Spell1Id);
		searchMatchDetailPanel.add(lblSummonerWinner3Spell2Id);
		searchMatchDetailPanel.add(lblSummonerWinner4Spell1Id);
		searchMatchDetailPanel.add(lblSummonerWinner4Spell2Id);
		searchMatchDetailPanel.add(lblSummonerWinner5Spell1Id);
		searchMatchDetailPanel.add(lblSummonerWinner5Spell2Id);
		searchMatchDetailPanel.add(lblSummonerLosses1Spell1Id);
		searchMatchDetailPanel.add(lblSummonerLosses1Spell2Id);
		searchMatchDetailPanel.add(lblSummonerLosses2Spell1Id);
		searchMatchDetailPanel.add(lblSummonerLosses2Spell2Id);
		searchMatchDetailPanel.add(lblSummonerLosses3Spell1Id);
		searchMatchDetailPanel.add(lblSummonerLosses3Spell2Id);
		searchMatchDetailPanel.add(lblSummonerLosses4Spell1Id);
		searchMatchDetailPanel.add(lblSummonerLosses4Spell2Id);
		searchMatchDetailPanel.add(lblSummonerLosses5Spell1Id);
		searchMatchDetailPanel.add(lblSummonerLosses5Spell2Id);
		//스펠
		
		//룬
		searchMatchDetailPanel.add(lblSummonerWinner1Rune1Id);
		searchMatchDetailPanel.add(lblSummonerWinner1Rune2Id);
		searchMatchDetailPanel.add(lblSummonerWinner2Rune1Id);
		searchMatchDetailPanel.add(lblSummonerWinner2Rune2Id);
		searchMatchDetailPanel.add(lblSummonerWinner3Rune1Id);
		searchMatchDetailPanel.add(lblSummonerWinner3Rune2Id);
		searchMatchDetailPanel.add(lblSummonerWinner4Rune1Id);
		searchMatchDetailPanel.add(lblSummonerWinner4Rune2Id);
		searchMatchDetailPanel.add(lblSummonerWinner5Rune1Id);
		searchMatchDetailPanel.add(lblSummonerWinner5Rune2Id);
		searchMatchDetailPanel.add(lblSummonerLosses1Rune1Id);
		searchMatchDetailPanel.add(lblSummonerLosses1Rune2Id);
		searchMatchDetailPanel.add(lblSummonerLosses2Rune1Id);
		searchMatchDetailPanel.add(lblSummonerLosses2Rune2Id);
		searchMatchDetailPanel.add(lblSummonerLosses3Rune1Id);
		searchMatchDetailPanel.add(lblSummonerLosses3Rune2Id);
		searchMatchDetailPanel.add(lblSummonerLosses4Rune1Id);
		searchMatchDetailPanel.add(lblSummonerLosses4Rune2Id);
		searchMatchDetailPanel.add(lblSummonerLosses5Rune1Id);
		searchMatchDetailPanel.add(lblSummonerLosses5Rune2Id);
		//룬
		
		//KDA
		searchMatchDetailPanel.add(lblSummonerWinnerKDA1);
		searchMatchDetailPanel.add(lblSummonerWinnerKDA2);
		searchMatchDetailPanel.add(lblSummonerWinnerKDA3);
		searchMatchDetailPanel.add(lblSummonerWinnerKDA4);
		searchMatchDetailPanel.add(lblSummonerWinnerKDA5);
		searchMatchDetailPanel.add(lblSummonerLossesKDA1);
		searchMatchDetailPanel.add(lblSummonerLossesKDA2);
		searchMatchDetailPanel.add(lblSummonerLossesKDA3);
		searchMatchDetailPanel.add(lblSummonerLossesKDA4);
		searchMatchDetailPanel.add(lblSummonerLossesKDA5);
		//KDA
		
		//딜량
		searchMatchDetailPanel.add(SummonerDmgBar1);
		searchMatchDetailPanel.add(SummonerDmgBar2);
		searchMatchDetailPanel.add(SummonerDmgBar3);
		searchMatchDetailPanel.add(SummonerDmgBar4);
		searchMatchDetailPanel.add(SummonerDmgBar5);
		searchMatchDetailPanel.add(SummonerDmgBar6);
		searchMatchDetailPanel.add(SummonerDmgBar7);
		searchMatchDetailPanel.add(SummonerDmgBar8);
		searchMatchDetailPanel.add(SummonerDmgBar9);
		searchMatchDetailPanel.add(SummonerDmgBar10);
		searchMatchDetailPanel.add(lblSummonerWinnerDamage1);
		searchMatchDetailPanel.add(lblSummonerWinnerDamage2);
		searchMatchDetailPanel.add(lblSummonerWinnerDamage3);
		searchMatchDetailPanel.add(lblSummonerWinnerDamage4);
		searchMatchDetailPanel.add(lblSummonerWinnerDamage5);
		searchMatchDetailPanel.add(lblSummonerLossesDamage1);
		searchMatchDetailPanel.add(lblSummonerLossesDamage2);
		searchMatchDetailPanel.add(lblSummonerLossesDamage3);
		searchMatchDetailPanel.add(lblSummonerLossesDamage4);
		searchMatchDetailPanel.add(lblSummonerLossesDamage5);
		//딜량
		
		//Ward
		searchMatchDetailPanel.add(lblSummonerWinnerWard1);
		searchMatchDetailPanel.add(lblSummonerWinnerWard2);
		searchMatchDetailPanel.add(lblSummonerWinnerWard3);
		searchMatchDetailPanel.add(lblSummonerWinnerWard4);
		searchMatchDetailPanel.add(lblSummonerWinnerWard5);
		searchMatchDetailPanel.add(lblSummonerLossesWard1);
		searchMatchDetailPanel.add(lblSummonerLossesWard2);
		searchMatchDetailPanel.add(lblSummonerLossesWard3);
		searchMatchDetailPanel.add(lblSummonerLossesWard4);
		searchMatchDetailPanel.add(lblSummonerLossesWard5);
		//Ward
		
		//CS
		searchMatchDetailPanel.add(lblSummonerWinnerCS1);
		searchMatchDetailPanel.add(lblSummonerWinnerCS2);
		searchMatchDetailPanel.add(lblSummonerWinnerCS3);
		searchMatchDetailPanel.add(lblSummonerWinnerCS4);
		searchMatchDetailPanel.add(lblSummonerWinnerCS5);
		searchMatchDetailPanel.add(lblSummonerLossesCS1);
		searchMatchDetailPanel.add(lblSummonerLossesCS2);
		searchMatchDetailPanel.add(lblSummonerLossesCS3);
		searchMatchDetailPanel.add(lblSummonerLossesCS4);
		searchMatchDetailPanel.add(lblSummonerLossesCS5);
		//CS
		
		//아이템
		searchMatchDetailPanel.add(lblSummonerWinner1Item0Id);
		searchMatchDetailPanel.add(lblSummonerWinner1Item1Id);
		searchMatchDetailPanel.add(lblSummonerWinner1Item2Id);
		searchMatchDetailPanel.add(lblSummonerWinner1Item3Id);
		searchMatchDetailPanel.add(lblSummonerWinner1Item4Id);
		searchMatchDetailPanel.add(lblSummonerWinner1Item5Id);
		searchMatchDetailPanel.add(lblSummonerWinner1Item6Id);

		searchMatchDetailPanel.add(lblSummonerWinner2Item0Id);
		searchMatchDetailPanel.add(lblSummonerWinner2Item1Id);
		searchMatchDetailPanel.add(lblSummonerWinner2Item2Id);
		searchMatchDetailPanel.add(lblSummonerWinner2Item3Id);
		searchMatchDetailPanel.add(lblSummonerWinner2Item4Id);
		searchMatchDetailPanel.add(lblSummonerWinner2Item5Id);
		searchMatchDetailPanel.add(lblSummonerWinner2Item6Id);
		
		searchMatchDetailPanel.add(lblSummonerWinner3Item0Id);
		searchMatchDetailPanel.add(lblSummonerWinner3Item1Id);
		searchMatchDetailPanel.add(lblSummonerWinner3Item2Id);
		searchMatchDetailPanel.add(lblSummonerWinner3Item3Id);
		searchMatchDetailPanel.add(lblSummonerWinner3Item4Id);
		searchMatchDetailPanel.add(lblSummonerWinner3Item5Id);
		searchMatchDetailPanel.add(lblSummonerWinner3Item6Id);
		
		searchMatchDetailPanel.add(lblSummonerWinner4Item0Id);
		searchMatchDetailPanel.add(lblSummonerWinner4Item1Id);
		searchMatchDetailPanel.add(lblSummonerWinner4Item2Id);
		searchMatchDetailPanel.add(lblSummonerWinner4Item3Id);
		searchMatchDetailPanel.add(lblSummonerWinner4Item4Id);
		searchMatchDetailPanel.add(lblSummonerWinner4Item5Id);
		searchMatchDetailPanel.add(lblSummonerWinner4Item6Id);
		
		searchMatchDetailPanel.add(lblSummonerWinner5Item0Id);
		searchMatchDetailPanel.add(lblSummonerWinner5Item1Id);
		searchMatchDetailPanel.add(lblSummonerWinner5Item2Id);
		searchMatchDetailPanel.add(lblSummonerWinner5Item3Id);
		searchMatchDetailPanel.add(lblSummonerWinner5Item4Id);
		searchMatchDetailPanel.add(lblSummonerWinner5Item5Id);
		searchMatchDetailPanel.add(lblSummonerWinner5Item6Id);
		
		searchMatchDetailPanel.add(lblSummonerLosess1Item0Id);
		searchMatchDetailPanel.add(lblSummonerLosess1Item1Id);
		searchMatchDetailPanel.add(lblSummonerLosess1Item2Id);
		searchMatchDetailPanel.add(lblSummonerLosess1Item3Id);
		searchMatchDetailPanel.add(lblSummonerLosess1Item4Id);
		searchMatchDetailPanel.add(lblSummonerLosess1Item5Id);
		searchMatchDetailPanel.add(lblSummonerLosess1Item6Id);

		searchMatchDetailPanel.add(lblSummonerLosess2Item0Id);
		searchMatchDetailPanel.add(lblSummonerLosess2Item1Id);
		searchMatchDetailPanel.add(lblSummonerLosess2Item2Id);
		searchMatchDetailPanel.add(lblSummonerLosess2Item3Id);
		searchMatchDetailPanel.add(lblSummonerLosess2Item4Id);
		searchMatchDetailPanel.add(lblSummonerLosess2Item5Id);
		searchMatchDetailPanel.add(lblSummonerLosess2Item6Id);

		searchMatchDetailPanel.add(lblSummonerLosess3Item0Id);
		searchMatchDetailPanel.add(lblSummonerLosess3Item1Id);
		searchMatchDetailPanel.add(lblSummonerLosess3Item2Id);
		searchMatchDetailPanel.add(lblSummonerLosess3Item3Id);
		searchMatchDetailPanel.add(lblSummonerLosess3Item4Id);
		searchMatchDetailPanel.add(lblSummonerLosess3Item5Id);
		searchMatchDetailPanel.add(lblSummonerLosess3Item6Id);
		
		searchMatchDetailPanel.add(lblSummonerLosess4Item0Id);
		searchMatchDetailPanel.add(lblSummonerLosess4Item1Id);
		searchMatchDetailPanel.add(lblSummonerLosess4Item2Id);
		searchMatchDetailPanel.add(lblSummonerLosess4Item3Id);
		searchMatchDetailPanel.add(lblSummonerLosess4Item4Id);
		searchMatchDetailPanel.add(lblSummonerLosess4Item5Id);
		searchMatchDetailPanel.add(lblSummonerLosess4Item6Id);
		
		searchMatchDetailPanel.add(lblSummonerLosess5Item0Id);
		searchMatchDetailPanel.add(lblSummonerLosess5Item1Id);
		searchMatchDetailPanel.add(lblSummonerLosess5Item2Id);
		searchMatchDetailPanel.add(lblSummonerLosess5Item3Id);
		searchMatchDetailPanel.add(lblSummonerLosess5Item4Id);
		searchMatchDetailPanel.add(lblSummonerLosess5Item5Id);
		searchMatchDetailPanel.add(lblSummonerLosess5Item6Id);
		//아이템
		
		//소환사 챔피언 초상화
		searchMatchDetailPanel.add(lblSummonerWinnerChampion1);
		searchMatchDetailPanel.add(lblSummonerWinnerChampion2);
		searchMatchDetailPanel.add(lblSummonerWinnerChampion3);
		searchMatchDetailPanel.add(lblSummonerWinnerChampion4);
		searchMatchDetailPanel.add(lblSummonerWinnerChampion5);
		searchMatchDetailPanel.add(lblSummonerLossesChampion1);
		searchMatchDetailPanel.add(lblSummonerLossesChampion2);
		searchMatchDetailPanel.add(lblSummonerLossesChampion3);
		searchMatchDetailPanel.add(lblSummonerLossesChampion4);
		searchMatchDetailPanel.add(lblSummonerLossesChampion5);
		//소환사 챔피언 초상화
		
		//소환사 챔피언 레벨
		searchMatchDetailPanel.add(lblSummonerWinnerChampionLevel1);
		searchMatchDetailPanel.add(lblSummonerWinnerChampionLevel2);
		searchMatchDetailPanel.add(lblSummonerWinnerChampionLevel3);
		searchMatchDetailPanel.add(lblSummonerWinnerChampionLevel4);
		searchMatchDetailPanel.add(lblSummonerWinnerChampionLevel5);
		searchMatchDetailPanel.add(lblSummonerLossesChampionLevel1);
		searchMatchDetailPanel.add(lblSummonerLossesChampionLevel2);
		searchMatchDetailPanel.add(lblSummonerLossesChampionLevel3);
		searchMatchDetailPanel.add(lblSummonerLossesChampionLevel4);
		searchMatchDetailPanel.add(lblSummonerLossesChampionLevel5);
		//소환사 챔피언 레벨
		
		searchMatchDetailInfo(gameId);
		ct.add(searchMatchDetailPanel);
		
		setVisible(true);
		setSize(800, 700);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	//상세정보 검색 메소드
	public void searchMatchDetailInfo(Object gameId) {
		try {
			String apiURL = BaseURL.MATCH_DETAIL_INFORMATION + gameId + "?api_key=" + BaseURL.API_KEY;
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json;charset=utf-8");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println(response.toString());
			
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(response.toString());
			
			dmInfo.setGameId(Long.parseLong(jsonObj.get("gameId").toString()));
			dmInfo.setGameCreation(Long.parseLong(jsonObj.get("gameCreation").toString()));
			dmInfo.setGameDuration(Long.parseLong(jsonObj.get("gameDuration").toString()));
			dmInfo.setQueueId(Integer.parseInt(jsonObj.get("queueId").toString()));
			dmInfo.setMapId(Integer.parseInt(jsonObj.get("mapId").toString()));
			dmInfo.setSeasonId(Integer.parseInt(jsonObj.get("seasonId").toString()));

			//participantIdentities(ParticipantIdentityDto) jsonParsing
			//participantIdentities는 플레이어 정보, 플레이어 Id가 담긴 dto
			JSONArray jsonParticipantIdentityArray = (JSONArray)jsonObj.get("participantIdentities");
			for (int i = 0; i < jsonParticipantIdentityArray.size(); i++) {
				JSONObject jsonParticipantIdentityData = (JSONObject)jsonParticipantIdentityArray.get(i);
				dmInfo.setPlayerParticipantId(Integer.parseInt(jsonParticipantIdentityData.get("participantId").toString()));
				
				JSONObject jsonParticipantIdentityData2 = (JSONObject)jsonParticipantIdentityData.get("player");
				dmInfo.setSummonerName(jsonParticipantIdentityData2.get("summonerName").toString());
				
				//닉네임 지정 메소드
				setPlayerNickName();
			}
			
			//teams(TeamStatsDto) jsonParsing
			//teams는 이긴 팀과 진 팀의 첫 킬, 첫 포탑, 첫 억제기, 첫 바론, 첫 용 여부
			//바론 처치 수, 전령 처치 수, 용 처치 수, 포탑 파괴 수, 억제기 파괴 수, 벤픽 등이 담겨있는 dto
			JSONArray jsonTeamsArray = (JSONArray)jsonObj.get("teams");
			for (int i = 0; i < jsonTeamsArray.size(); i++) {
				JSONObject jsonTeamsObj = (JSONObject)jsonTeamsArray.get(i);
				
				dmInfo.setStatsTeamId(Integer.parseInt(jsonTeamsObj.get("teamId").toString()));
				//teamId가 100이면 패배, 200이면 승리
				if (dmInfo.getStatsTeamId() == 100) {
					//패배 팀들의 벤픽한 챔피언의 id를 받아옴
					JSONArray jsonBansArray = (JSONArray)jsonTeamsObj.get("bans");
					for (int j = 0; j < jsonBansArray.size(); j++) {
						JSONObject jsonBansObj = (JSONObject)jsonBansArray.get(j);
						dmInfo.setChampionId(Integer.parseInt(jsonBansObj.get("championId").toString()));
						loadChampionInfo(dmInfo.getChampionId());
					//	System.out.println("패배 팀 벤픽 챔프 ID : " + dmInfo.getChampionId());
						
						LossesBanList.append(championName + " ");
					}
					lblLossesTeamChampionBans.setText("금지 챔피언 : " + LossesBanList);
				}
				else {
					//이긴 팀들의 벤픽한 챔피언의 id를 받아옴
					JSONArray jsonArrayBans = (JSONArray)jsonTeamsObj.get("bans");
					for (int j = 0; j < jsonArrayBans.size(); j++) {
						JSONObject jsonBansObj = (JSONObject)jsonArrayBans.get(j);
						dmInfo.setChampionId(Integer.parseInt(jsonBansObj.get("championId").toString()));
						loadChampionInfo(dmInfo.getChampionId());
					//	System.out.println("승리 팀 벤픽 챔프 ID : " + dmInfo.getChampionId());
						
						WinnerBanList.append(championName + " ");
					}
					lblWinnerTeamChampionBans.setText("금지 챔피언 : " + WinnerBanList);
				}
			}
			
			//participants(ParticipantDto) jsonParsing
			//participants는 소환사의 번호, 소환가사 속한 팀 번호, 소환사가 픽한 챔피언, 스펠 등이 담겨있는 dto
			JSONArray jsonParticipantsArray = (JSONArray)jsonObj.get("participants");
			for (int i = 0; i < jsonParticipantsArray.size(); i++) {
				JSONObject jsonParticipantsObj = (JSONObject)jsonParticipantsArray.get(i);
				
				/*세부 매치 정보에 필요한 데이터는 ↓
				 * 챔피언ID, 스펠1ID, 스펠2ID, 룬 정보, 레벨, 피해량(챔피언에게 가한 피해량, 총 피해량), 와드(제어와드 구매, 설치, 제거)
				 * CS(미니언, 정글몹), 아이템1, 2, 3, 4, 5, 6, 7(장신구)
				 * 해당 소환사의 더블킬, 트리플킬, 쿼드라킬, 펜타킬 여부
				 * 해당 소환사의 KDA
				 * 각 팀의 바론, 전령, 용 처치 수
				 * 
				 * 세부 정보 데이터를 모았다면 이미지 또는 GUI 작업해야 할 것은 ↓
				 * 챔피언 초상화, 스펠 이미지, 룬 이미지, 아이템 이미지
				 * 
				 * 세부 정보 데이터를 모았다면 연산 처리해야 할 것은 ↓
				 * 티어가 있다면 티어를 표시하고 Unranked라면 소환사 계정의 레벨을 표시
				 * 매치의 토탈 킬 스코어를 구하고 해당 소환사의 K+A/TK * 100해서 킬 관여율을 구함
				 * 매치 종료 시점 기준으로 CS / 시간(29분이면 29)로 분당 CS 갯수를 구함
				 * dmInfo.getGameDuration() * 1000 / (60 * 1000)
				 * 게임 진행시간 시점으로 * 1000을 한 후 분 구하기 공식
				*/

				dmInfo.setParticipantId(Integer.parseInt(jsonParticipantsObj.get("participantId").toString()));
				dmInfo.setParticipantTeamId(Integer.parseInt(jsonParticipantsObj.get("teamId").toString()));
				dmInfo.setSummonerChampionId(Integer.parseInt(jsonParticipantsObj.get("championId").toString()));
				dmInfo.setSpell1Id(Integer.parseInt(jsonParticipantsObj.get("spell1Id").toString()));
				dmInfo.setSpell2Id(Integer.parseInt(jsonParticipantsObj.get("spell2Id").toString()));
				
				loadSpellInfo(dmInfo.getSpell1Id(), dmInfo.getSpell2Id());
				
				//소환사 이미지(챔피언, 스펠, 룬, 아이템) 지정
				setSummonerImage();
				
//				System.out.println("참가자 ID : " + dmInfo.getParticipantId());
//				System.out.println("팀 ID : " + dmInfo.getParticipantTeamId());
//				System.out.println("챔피언 ID : " + dmInfo.getSummonerChampionId());
//				System.out.println("스펠1 ID : " + spell1Id);
//				System.out.println("스펠2 ID : " + spell2Id);
				
				//participants 내부에 있는 stats json
				//플레이어의 세부 정보가 들어있음
				JSONObject jsonStatsObj = (JSONObject)jsonParticipantsObj.get("stats");
				dmInfo.setStatsParticipantId(Integer.parseInt(jsonStatsObj.get("participantId").toString()));
				dmInfo.setWin(Boolean.parseBoolean(jsonStatsObj.get("win").toString()));
				dmInfo.setItem0(Integer.parseInt(jsonStatsObj.get("item0").toString()));
				dmInfo.setItem1(Integer.parseInt(jsonStatsObj.get("item1").toString()));
				dmInfo.setItem2(Integer.parseInt(jsonStatsObj.get("item2").toString()));
				dmInfo.setItem3(Integer.parseInt(jsonStatsObj.get("item3").toString()));
				dmInfo.setItem4(Integer.parseInt(jsonStatsObj.get("item4").toString()));
				dmInfo.setItem5(Integer.parseInt(jsonStatsObj.get("item5").toString()));
				dmInfo.setItem6(Integer.parseInt(jsonStatsObj.get("item6").toString()));
				dmInfo.setChampLevel(Integer.parseInt(jsonStatsObj.get("champLevel").toString()));
				dmInfo.setKills(Integer.parseInt(jsonStatsObj.get("kills").toString()));
				dmInfo.setDeaths(Integer.parseInt(jsonStatsObj.get("deaths").toString()));
				dmInfo.setAssists(Integer.parseInt(jsonStatsObj.get("assists").toString()));
				dmInfo.setDoublekills(Integer.parseInt(jsonStatsObj.get("doubleKills").toString()));
				dmInfo.setTripleKills(Integer.parseInt(jsonStatsObj.get("tripleKills").toString()));
				dmInfo.setQuadraKills(Integer.parseInt(jsonStatsObj.get("quadraKills").toString()));
				dmInfo.setPentaKills(Integer.parseInt(jsonStatsObj.get("pentaKills").toString()));
				dmInfo.setMainRune(Integer.parseInt(jsonStatsObj.get("perk0").toString()));
				dmInfo.setSubRune(Integer.parseInt(jsonStatsObj.get("perk4").toString()));
				dmInfo.setTotalDamageDealtToChampions(Long.parseLong(jsonStatsObj.get("totalDamageDealtToChampions").toString()));
				dmInfo.setTotalDamageDealt(Integer.parseInt(jsonStatsObj.get("totalDamageDealt").toString()));
				dmInfo.setTotalMinionsKilled(Integer.parseInt(jsonStatsObj.get("totalMinionsKilled").toString()));
				dmInfo.setNeutralMinionsKilled(Integer.parseInt(jsonStatsObj.get("neutralMinionsKilled").toString()));
				dmInfo.setWardsPlaced(Integer.parseInt(jsonStatsObj.get("wardsPlaced").toString()));
				dmInfo.setWardsKilled(Integer.parseInt(jsonStatsObj.get("wardsKilled").toString()));
				dmInfo.setVisionWardsBoughtInGame(Integer.parseInt(jsonStatsObj.get("visionWardsBoughtInGame").toString()));
				dmInfo.setVisionScore(Long.parseLong(jsonStatsObj.get("visionScore").toString()));
				
				System.out.println("참가자 ID : " + dmInfo.getStatsParticipantId());
//				System.out.println("승리 여부 : " + dmInfo.isWin());
//				System.out.println("Item0 : " + dmInfo.getItem0());
//				System.out.println("Item1 : " + dmInfo.getItem1());
//				System.out.println("Item2 : " + dmInfo.getItem2());
//				System.out.println("Item3 : " + dmInfo.getItem3());
//				System.out.println("Item4 : " + dmInfo.getItem4());
//				System.out.println("Item5 : " + dmInfo.getItem5());
//				System.out.println("Item6 : " + dmInfo.getItem6());
//				System.out.println("레벨 : " + dmInfo.getChampLevel());
//				System.out.println("킬 : " + dmInfo.getKills());
//				System.out.println("데스 : " + dmInfo.getDeaths());
//				System.out.println("어시스트 : " + dmInfo.getAssists());
//				System.out.println("더블킬 : " + dmInfo.getDoublekills());
//				System.out.println("트리플킬 : " + dmInfo.getTripleKills());
//				System.out.println("쿼드라킬 : " + dmInfo.getQuadraKills());
//				System.out.println("펜타킬 : " + dmInfo.getPentaKills());
				System.out.println("Primary Rune : " + dmInfo.getMainRune());
				System.out.println("Secondary Rune : " + dmInfo.getSubRune());
				System.out.println("-------------------");
//				System.out.println("총 가한 피해량 : " + dmInfo.getTotalDamageDealtToChampions());
//				System.out.println("총 피해량 : " + dmInfo.getTotalDamageDealt());
//				System.out.println("CS : " + dmInfo.getTotalMinionsKilled());
//				System.out.println("정글 몬스터 : " + dmInfo.getNeutralMinionsKilled());
//				System.out.println("와드 설치 : " + dmInfo.getWardsPlaced());
//				System.out.println("와드 제거 : " + dmInfo.getWardsKilled());
//				System.out.println("제어 와드 : " + dmInfo.getVisionWardsBoughtInGame());
//				System.out.println("시야 점수 : " + dmInfo.getVisionScore());

			//	타임라인 받아오는 것
			//	JSONObject jsonTimelineObj = (JSONObject)jsonParticipantsObj.get("timeline");
				//소환사 KDA, 평점, 딜량, 와드정보,  CS지정
				setSummonerInfo();
				//소환사 아이템 이미지 지정
				setSummonerItem();
				//소환사 챔피언 초상화 지정
				setChampionPortrait(dmInfo.getSummonerChampionId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//승리팀, 패배팀 소환사 닉네임 지정
	public void setPlayerNickName() {
		//100이면 패배, 200이면 승리
		//1~5까지 패배 6~10 승리
		switch (dmInfo.getPlayerParticipantId()) {
			case 1: {
				lblSummonerLossesNick1.setText(dmInfo.getSummonerName());
				break;
			}
			case 2: {
				lblSummonerLossesNick2.setText(dmInfo.getSummonerName());
				break;
			}
			case 3: {
				lblSummonerLossesNick3.setText(dmInfo.getSummonerName());
				break;
			}
			case 4: {
				lblSummonerLossesNick4.setText(dmInfo.getSummonerName());
				break;
			}
			case 5: {
				lblSummonerLossesNick5.setText(dmInfo.getSummonerName());
				break;
			}
			case 6: {
				lblSummonerWinnerNick1.setText(dmInfo.getSummonerName());
				break;
			}
			case 7: {
				lblSummonerWinnerNick2.setText(dmInfo.getSummonerName());
				break;
			}
			case 8: {
				lblSummonerWinnerNick3.setText(dmInfo.getSummonerName());
				break;
			}
			case 9: {
				lblSummonerWinnerNick4.setText(dmInfo.getSummonerName());
				break;
			}
			case 10: {
				lblSummonerWinnerNick5.setText(dmInfo.getSummonerName());
				break;
			}
		}
	}
	
	//소환사 이미지(챔피언, 스펠, 룬, 아이템) 지정
	public void setSummonerImage() {
		Thread setSummonerImageThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					spell1IconURL = new URL(BaseURL.SUMMONER_SPELLS + dmInfo.getSpell1ImgName());
					spell1Image = ImageIO.read(spell1IconURL);
					resizeSpell1Img = spell1Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
					
					spell2IconURL = new URL(BaseURL.SUMMONER_SPELLS + dmInfo.getSpell2ImgName());
					spell2Image = ImageIO.read(spell2IconURL);
					resizeSpell2Img = spell2Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				switch (dmInfo.getParticipantId()) {
					case 1: {
						lblSummonerLosses1Spell1Id.setIcon(new ImageIcon(resizeSpell1Img));
						lblSummonerLosses1Spell2Id.setIcon(new ImageIcon(resizeSpell2Img));
						break;
					}
					case 2: {
						lblSummonerLosses2Spell1Id.setIcon(new ImageIcon(resizeSpell1Img));
						lblSummonerLosses2Spell2Id.setIcon(new ImageIcon(resizeSpell2Img));
						break;
					}
					case 3: {
						lblSummonerLosses3Spell1Id.setIcon(new ImageIcon(resizeSpell1Img));
						lblSummonerLosses3Spell2Id.setIcon(new ImageIcon(resizeSpell2Img));
						break;
					}
					case 4: {
						lblSummonerLosses4Spell1Id.setIcon(new ImageIcon(resizeSpell1Img));
						lblSummonerLosses4Spell2Id.setIcon(new ImageIcon(resizeSpell2Img));
						break;
					}
					case 5: {
						lblSummonerLosses5Spell1Id.setIcon(new ImageIcon(resizeSpell1Img));
						lblSummonerLosses5Spell2Id.setIcon(new ImageIcon(resizeSpell2Img));
						break;
					}
					case 6: {
						lblSummonerWinner1Spell1Id.setIcon(new ImageIcon(resizeSpell1Img));
						lblSummonerWinner1Spell2Id.setIcon(new ImageIcon(resizeSpell2Img));
						break;
					}
					case 7: {
						lblSummonerWinner2Spell1Id.setIcon(new ImageIcon(resizeSpell1Img));
						lblSummonerWinner2Spell2Id.setIcon(new ImageIcon(resizeSpell2Img));
						break;
					}
					case 8: {
						lblSummonerWinner3Spell1Id.setIcon(new ImageIcon(resizeSpell1Img));
						lblSummonerWinner3Spell2Id.setIcon(new ImageIcon(resizeSpell2Img));
						break;
					}
					case 9: {
						lblSummonerWinner4Spell1Id.setIcon(new ImageIcon(resizeSpell1Img));
						lblSummonerWinner4Spell2Id.setIcon(new ImageIcon(resizeSpell2Img));
						break;
					}
					case 10: {
						lblSummonerWinner5Spell1Id.setIcon(new ImageIcon(resizeSpell1Img));
						lblSummonerWinner5Spell2Id.setIcon(new ImageIcon(resizeSpell2Img));
						break;
					}
				}
			}
		});
		setSummonerImageThread.start();
	}
	
	//소환사 KDA, 평점, 딜량, 와드정보, CS 지정
	public void setSummonerInfo() {
		Thread setSummnerInfoThread = new Thread(new Runnable() {
			@Override
			public void run() {
				switch (dmInfo.getParticipantId()) {
					case 1: {
						//킬관여율은 킬+어시 / 전체킬 X 100
						lblSummonerLossesKDA1.setText("<html>" + dmInfo.getKills() + "/" + dmInfo.getDeaths() + "/" + dmInfo.getAssists() + "<br>" + String.format("%.2f", (dmInfo.getKills() + dmInfo.getAssists()) / Double.valueOf(dmInfo.getDeaths())) + "<br>" +"</html>");
						lblSummonerLossesDamage1.setText(dmInfo.getTotalDamageDealtToChampions().toString());
						SummonerDmgBar1.setValue(Integer.parseInt(dmInfo.getTotalDamageDealtToChampions().toString()));
						lblSummonerLossesWard1.setText("<html>" + dmInfo.getVisionWardsBoughtInGame() + " / " + dmInfo.getWardsPlaced() + " / " + dmInfo.getWardsKilled() + "<br>" + "시야 : " + dmInfo.getVisionScore() + "</html>");
						lblSummonerLossesCS1.setText("<html>" + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) + "<br>" + "CS/M : " + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) / (dmInfo.getGameDuration() * 1000 / (60 * 1000)) + "</html>");
						lblSummonerLossesChampionLevel1.setText("Lv" + dmInfo.getChampLevel());
						break;
					}
					case 2: {
						lblSummonerLossesKDA2.setText("<html>" + dmInfo.getKills() + "/" + dmInfo.getDeaths() + "/" + dmInfo.getAssists() + "<br>" + String.format("%.2f", (dmInfo.getKills() + dmInfo.getAssists()) / Double.valueOf(dmInfo.getDeaths())) + "</html>");
						lblSummonerLossesDamage2.setText(dmInfo.getTotalDamageDealtToChampions().toString());
						SummonerDmgBar2.setValue(Integer.parseInt(dmInfo.getTotalDamageDealtToChampions().toString()));
						lblSummonerLossesWard2.setText("<html>" + dmInfo.getVisionWardsBoughtInGame() + " / " + dmInfo.getWardsPlaced() + " / " + dmInfo.getWardsKilled() + "<br>" + "시야 : " + dmInfo.getVisionScore() + "</html>");
						lblSummonerLossesCS2.setText("<html>" + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) + "<br>" + "CS/M : " + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) / (dmInfo.getGameDuration() * 1000 / (60 * 1000)) + "</html>");
						lblSummonerLossesChampionLevel2.setText("Lv" + dmInfo.getChampLevel());
						break;
					}
					case 3: {
						lblSummonerLossesKDA3.setText("<html>" + dmInfo.getKills() + "/" + dmInfo.getDeaths() + "/" + dmInfo.getAssists() + "<br>" + String.format("%.2f", (dmInfo.getKills() + dmInfo.getAssists()) / Double.valueOf(dmInfo.getDeaths())) + "</html>");
						lblSummonerLossesDamage3.setText(dmInfo.getTotalDamageDealtToChampions().toString());
						SummonerDmgBar3.setValue(Integer.parseInt(dmInfo.getTotalDamageDealtToChampions().toString()));
						lblSummonerLossesWard3.setText("<html>" + dmInfo.getVisionWardsBoughtInGame() + " / " + dmInfo.getWardsPlaced() + " / " + dmInfo.getWardsKilled() + "<br>" + "시야 : " + dmInfo.getVisionScore() + "</html>");
						lblSummonerLossesCS3.setText("<html>" + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) + "<br>" + "CS/M : " + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) / (dmInfo.getGameDuration() * 1000 / (60 * 1000)) + "</html>");
						lblSummonerLossesChampionLevel3.setText("Lv" + dmInfo.getChampLevel());
						break;
					}
					case 4: {
						lblSummonerLossesKDA4.setText("<html>" + dmInfo.getKills() + "/" + dmInfo.getDeaths() + "/" + dmInfo.getAssists() + "<br>" + String.format("%.2f", (dmInfo.getKills() + dmInfo.getAssists()) / Double.valueOf(dmInfo.getDeaths())) + "</html>");
						lblSummonerLossesDamage4.setText(dmInfo.getTotalDamageDealtToChampions().toString());
						SummonerDmgBar4.setValue(Integer.parseInt(dmInfo.getTotalDamageDealtToChampions().toString()));
						lblSummonerLossesWard4.setText("<html>" + dmInfo.getVisionWardsBoughtInGame() + " / " + dmInfo.getWardsPlaced() + " / " + dmInfo.getWardsKilled() + "<br>" + "시야 : " + dmInfo.getVisionScore() + "</html>");
						lblSummonerLossesCS4.setText("<html>" + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) + "<br>" + "CS/M : " + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) / (dmInfo.getGameDuration() * 1000 / (60 * 1000)) + "</html>");
						lblSummonerLossesChampionLevel4.setText("Lv" + dmInfo.getChampLevel());
						break;
					}
					case 5: {
						lblSummonerLossesKDA5.setText("<html>" + dmInfo.getKills() + "/" + dmInfo.getDeaths() + "/" + dmInfo.getAssists() + "<br>" + String.format("%.2f", (dmInfo.getKills() + dmInfo.getAssists()) / Double.valueOf(dmInfo.getDeaths())) + "</html>");
						lblSummonerLossesDamage5.setText(dmInfo.getTotalDamageDealtToChampions().toString());
						SummonerDmgBar5.setValue(Integer.parseInt(dmInfo.getTotalDamageDealtToChampions().toString()));
						lblSummonerLossesWard5.setText("<html>" + dmInfo.getVisionWardsBoughtInGame() + " / " + dmInfo.getWardsPlaced() + " / " + dmInfo.getWardsKilled() + "<br>" + "시야 : " + dmInfo.getVisionScore() + "</html>");
						lblSummonerLossesCS5.setText("<html>" + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) + "<br>" + "CS/M : " + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) / (dmInfo.getGameDuration() * 1000 / (60 * 1000)) + "</html>");
						lblSummonerLossesChampionLevel5.setText("Lv" + dmInfo.getChampLevel());
						break;
					}
					case 6: {
						lblSummonerWinnerKDA1.setText("<html>" + dmInfo.getKills() + "/" + dmInfo.getDeaths() + "/" + dmInfo.getAssists() + "<br>" + String.format("%.2f", (dmInfo.getKills() + dmInfo.getAssists()) / Double.valueOf(dmInfo.getDeaths())) + "</html>");
						lblSummonerWinnerDamage1.setText(dmInfo.getTotalDamageDealtToChampions().toString());
						SummonerDmgBar6.setValue(Integer.parseInt(dmInfo.getTotalDamageDealtToChampions().toString()));
						lblSummonerWinnerWard1.setText("<html>" + dmInfo.getVisionWardsBoughtInGame() + " / " + dmInfo.getWardsPlaced() + " / " + dmInfo.getWardsKilled() + "<br>" + "시야 : " + dmInfo.getVisionScore() + "</html>");
						lblSummonerWinnerCS1.setText("<html>" + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) + "<br>" + "CS/M : " + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) / (dmInfo.getGameDuration() * 1000 / (60 * 1000)) + "</html>");
						lblSummonerWinnerChampionLevel1.setText("Lv" + dmInfo.getChampLevel());
						break;
					}
					case 7: {
						lblSummonerWinnerKDA2.setText("<html>" + dmInfo.getKills() + "/" + dmInfo.getDeaths() + "/" + dmInfo.getAssists() + "<br>" + String.format("%.2f", (dmInfo.getKills() + dmInfo.getAssists()) / Double.valueOf(dmInfo.getDeaths())) + "</html>");
						lblSummonerWinnerDamage2.setText(dmInfo.getTotalDamageDealtToChampions().toString());
						SummonerDmgBar7.setValue(Integer.parseInt(dmInfo.getTotalDamageDealtToChampions().toString()));
						lblSummonerWinnerWard2.setText("<html>" + dmInfo.getVisionWardsBoughtInGame() + " / " + dmInfo.getWardsPlaced() + " / " + dmInfo.getWardsKilled() + "<br>" + "시야 : " + dmInfo.getVisionScore() + "</html>");
						lblSummonerWinnerCS2.setText("<html>" + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) + "<br>" + "CS/M : " + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) / (dmInfo.getGameDuration() * 1000 / (60 * 1000)) + "</html>");
						lblSummonerWinnerChampionLevel2.setText("Lv" + dmInfo.getChampLevel());
						break;
					}
					case 8: {
						lblSummonerWinnerKDA3.setText("<html>" + dmInfo.getKills() + "/" + dmInfo.getDeaths() + "/" + dmInfo.getAssists() + "<br>" + String.format("%.2f", (dmInfo.getKills() + dmInfo.getAssists()) / Double.valueOf(dmInfo.getDeaths())) + "</html>");
						lblSummonerWinnerDamage3.setText(dmInfo.getTotalDamageDealtToChampions().toString());
						SummonerDmgBar8.setValue(Integer.parseInt(dmInfo.getTotalDamageDealtToChampions().toString()));
						lblSummonerWinnerWard3.setText("<html>" + dmInfo.getVisionWardsBoughtInGame() + " / " + dmInfo.getWardsPlaced() + " / " + dmInfo.getWardsKilled() + "<br>" + "시야 : " + dmInfo.getVisionScore() + "</html>");
						lblSummonerWinnerCS3.setText("<html>" + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) + "<br>" + "CS/M : " + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) / (dmInfo.getGameDuration() * 1000 / (60 * 1000)) + "</html>");
						lblSummonerWinnerChampionLevel3.setText("Lv" + dmInfo.getChampLevel());
						break;
					}
					case 9: {
						lblSummonerWinnerKDA4.setText("<html>" + dmInfo.getKills() + "/" + dmInfo.getDeaths() + "/" + dmInfo.getAssists() + "<br>" + String.format("%.2f", (dmInfo.getKills() + dmInfo.getAssists()) / Double.valueOf(dmInfo.getDeaths())) + "</html>");
						lblSummonerWinnerDamage4.setText(dmInfo.getTotalDamageDealtToChampions().toString());
						SummonerDmgBar9.setValue(Integer.parseInt(dmInfo.getTotalDamageDealtToChampions().toString()));
						lblSummonerWinnerWard4.setText("<html>" + dmInfo.getVisionWardsBoughtInGame() + " / " + dmInfo.getWardsPlaced() + " / " + dmInfo.getWardsKilled() + "<br>" + "시야 : " + dmInfo.getVisionScore() + "</html>");
						lblSummonerWinnerCS4.setText("<html>" + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) + "<br>" + "CS/M : " + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) / (dmInfo.getGameDuration() * 1000 / (60 * 1000)) + "</html>");
						lblSummonerWinnerChampionLevel4.setText("Lv" + dmInfo.getChampLevel());
						break;
					}
					case 10: {
						lblSummonerWinnerKDA5.setText("<html>" + dmInfo.getKills() + "/" + dmInfo.getDeaths() + "/" + dmInfo.getAssists() + "<br>" + String.format("%.2f", (dmInfo.getKills() + dmInfo.getAssists()) / Double.valueOf(dmInfo.getDeaths())) + "</html>");
						lblSummonerWinnerDamage5.setText(dmInfo.getTotalDamageDealtToChampions().toString());
						SummonerDmgBar10.setValue(Integer.parseInt(dmInfo.getTotalDamageDealtToChampions().toString()));
						lblSummonerWinnerWard5.setText("<html>" + dmInfo.getVisionWardsBoughtInGame() + " / " + dmInfo.getWardsPlaced() + " / " + dmInfo.getWardsKilled() + "<br>" + "시야 : " + dmInfo.getVisionScore() + "</html>");
						lblSummonerWinnerCS5.setText("<html>" + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) + "<br>" + "CS/M : " + (dmInfo.getTotalMinionsKilled() + dmInfo.getNeutralMinionsKilled()) / (dmInfo.getGameDuration() * 1000 / (60 * 1000)) + "</html>");
						lblSummonerWinnerChampionLevel5.setText("Lv" + dmInfo.getChampLevel());
						break;
					}
				}
			}
		});
		setSummnerInfoThread.start();
	}
	
	//소환사 아이템 이미지
	public void setSummonerItem() {
		try {
			File no_item = new File("src/riot_image/no_item.png");
			//아이템1
			if (dmInfo.getItem0() != 0) {
				item0IconURL = new URL(BaseURL.SUMMONER_ITEMS + dmInfo.getItem0() + ".png");
				item0Image = ImageIO.read(item0IconURL);
				resizeItem0Img = item0Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			else {
				item0Image = ImageIO.read(no_item);
				resizeItem0Img = item0Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			//아이템2
			if (dmInfo.getItem1() != 0) {
				item1IconURL = new URL(BaseURL.SUMMONER_ITEMS + dmInfo.getItem1() + ".png");
				item1Image = ImageIO.read(item1IconURL);
				resizeItem1Img = item1Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			else {
				item1Image = ImageIO.read(no_item);
				resizeItem1Img = item1Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			//아이템3
			if (dmInfo.getItem2() != 0) {
				item2IconURL = new URL(BaseURL.SUMMONER_ITEMS + dmInfo.getItem2() + ".png");
				item2Image = ImageIO.read(item2IconURL);
				resizeItem2Img = item2Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			else {
				item2Image = ImageIO.read(no_item);
				resizeItem2Img = item2Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			//아이템4
			if (dmInfo.getItem3() != 0) {
				item3IconURL = new URL(BaseURL.SUMMONER_ITEMS + dmInfo.getItem3() + ".png");
				item3Image = ImageIO.read(item3IconURL);
				resizeItem3Img = item3Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			else {
				item3Image = ImageIO.read(no_item);
				resizeItem3Img = item3Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			//아이템5
			if (dmInfo.getItem4() != 0) {
				item4IconURL = new URL(BaseURL.SUMMONER_ITEMS + dmInfo.getItem4() + ".png");
				item4Image = ImageIO.read(item4IconURL);
				resizeItem4Img = item4Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			else {
				item4Image = ImageIO.read(no_item);
				resizeItem4Img = item4Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			//아이템6
			if (dmInfo.getItem5() != 0) {
				item5IconURL = new URL(BaseURL.SUMMONER_ITEMS + dmInfo.getItem5() + ".png");
				item5Image = ImageIO.read(item5IconURL);
				resizeItem5Img = item5Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			else {
				item5Image = ImageIO.read(no_item);
				resizeItem5Img = item5Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			//아이템7(장신구)
			if (dmInfo.getItem6() != 0) {
				item6IconURL = new URL(BaseURL.SUMMONER_ITEMS + dmInfo.getItem6() + ".png");
				item6Image = ImageIO.read(item6IconURL);
				resizeItem6Img = item6Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
			else {
				item6Image = ImageIO.read(no_item);
				resizeItem6Img = item6Image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread setSummonerItemThread = new Thread(new Runnable() {
			@Override
			public void run() {
				switch (dmInfo.getParticipantId()) {
				case 1: {
					lblSummonerLosess1Item0Id.setIcon(new ImageIcon(resizeItem0Img));
					lblSummonerLosess1Item1Id.setIcon(new ImageIcon(resizeItem1Img));
					lblSummonerLosess1Item2Id.setIcon(new ImageIcon(resizeItem2Img));
					lblSummonerLosess1Item3Id.setIcon(new ImageIcon(resizeItem3Img));
					lblSummonerLosess1Item4Id.setIcon(new ImageIcon(resizeItem4Img));
					lblSummonerLosess1Item5Id.setIcon(new ImageIcon(resizeItem5Img));
					lblSummonerLosess1Item6Id.setIcon(new ImageIcon(resizeItem6Img));
					break;
				}
				case 2: {
					lblSummonerLosess2Item0Id.setIcon(new ImageIcon(resizeItem0Img));
					lblSummonerLosess2Item1Id.setIcon(new ImageIcon(resizeItem1Img));
					lblSummonerLosess2Item2Id.setIcon(new ImageIcon(resizeItem2Img));
					lblSummonerLosess2Item3Id.setIcon(new ImageIcon(resizeItem3Img));
					lblSummonerLosess2Item4Id.setIcon(new ImageIcon(resizeItem4Img));
					lblSummonerLosess2Item5Id.setIcon(new ImageIcon(resizeItem5Img));
					lblSummonerLosess2Item6Id.setIcon(new ImageIcon(resizeItem6Img));
					break;
				}
				case 3: {
					lblSummonerLosess3Item0Id.setIcon(new ImageIcon(resizeItem0Img));
					lblSummonerLosess3Item1Id.setIcon(new ImageIcon(resizeItem1Img));
					lblSummonerLosess3Item2Id.setIcon(new ImageIcon(resizeItem2Img));
					lblSummonerLosess3Item3Id.setIcon(new ImageIcon(resizeItem3Img));
					lblSummonerLosess3Item4Id.setIcon(new ImageIcon(resizeItem4Img));
					lblSummonerLosess3Item5Id.setIcon(new ImageIcon(resizeItem5Img));
					lblSummonerLosess3Item6Id.setIcon(new ImageIcon(resizeItem6Img));
					break;
				}
				case 4: {
					lblSummonerLosess4Item0Id.setIcon(new ImageIcon(resizeItem0Img));
					lblSummonerLosess4Item1Id.setIcon(new ImageIcon(resizeItem1Img));
					lblSummonerLosess4Item2Id.setIcon(new ImageIcon(resizeItem2Img));
					lblSummonerLosess4Item3Id.setIcon(new ImageIcon(resizeItem3Img));
					lblSummonerLosess4Item4Id.setIcon(new ImageIcon(resizeItem4Img));
					lblSummonerLosess4Item5Id.setIcon(new ImageIcon(resizeItem5Img));
					lblSummonerLosess4Item6Id.setIcon(new ImageIcon(resizeItem6Img));
					break;
				}
				case 5: {
					lblSummonerLosess5Item0Id.setIcon(new ImageIcon(resizeItem0Img));
					lblSummonerLosess5Item1Id.setIcon(new ImageIcon(resizeItem1Img));
					lblSummonerLosess5Item2Id.setIcon(new ImageIcon(resizeItem2Img));
					lblSummonerLosess5Item3Id.setIcon(new ImageIcon(resizeItem3Img));
					lblSummonerLosess5Item4Id.setIcon(new ImageIcon(resizeItem4Img));
					lblSummonerLosess5Item5Id.setIcon(new ImageIcon(resizeItem5Img));
					lblSummonerLosess5Item6Id.setIcon(new ImageIcon(resizeItem6Img));
					break;
				}
				case 6: {
					lblSummonerWinner1Item0Id.setIcon(new ImageIcon(resizeItem0Img));
					lblSummonerWinner1Item1Id.setIcon(new ImageIcon(resizeItem1Img));
					lblSummonerWinner1Item2Id.setIcon(new ImageIcon(resizeItem2Img));
					lblSummonerWinner1Item3Id.setIcon(new ImageIcon(resizeItem3Img));
					lblSummonerWinner1Item4Id.setIcon(new ImageIcon(resizeItem4Img));
					lblSummonerWinner1Item5Id.setIcon(new ImageIcon(resizeItem5Img));
					lblSummonerWinner1Item6Id.setIcon(new ImageIcon(resizeItem6Img));
					break;
				}
				case 7: {
					lblSummonerWinner2Item0Id.setIcon(new ImageIcon(resizeItem0Img));
					lblSummonerWinner2Item1Id.setIcon(new ImageIcon(resizeItem1Img));
					lblSummonerWinner2Item2Id.setIcon(new ImageIcon(resizeItem2Img));
					lblSummonerWinner2Item3Id.setIcon(new ImageIcon(resizeItem3Img));
					lblSummonerWinner2Item4Id.setIcon(new ImageIcon(resizeItem4Img));
					lblSummonerWinner2Item5Id.setIcon(new ImageIcon(resizeItem5Img));
					lblSummonerWinner2Item6Id.setIcon(new ImageIcon(resizeItem6Img));
					break;
				}
				case 8: {
					lblSummonerWinner3Item0Id.setIcon(new ImageIcon(resizeItem0Img));
					lblSummonerWinner3Item1Id.setIcon(new ImageIcon(resizeItem1Img));
					lblSummonerWinner3Item2Id.setIcon(new ImageIcon(resizeItem2Img));
					lblSummonerWinner3Item3Id.setIcon(new ImageIcon(resizeItem3Img));
					lblSummonerWinner3Item4Id.setIcon(new ImageIcon(resizeItem4Img));
					lblSummonerWinner3Item5Id.setIcon(new ImageIcon(resizeItem5Img));
					lblSummonerWinner3Item6Id.setIcon(new ImageIcon(resizeItem6Img));
					break;
				}
				case 9: {
					lblSummonerWinner4Item0Id.setIcon(new ImageIcon(resizeItem0Img));
					lblSummonerWinner4Item1Id.setIcon(new ImageIcon(resizeItem1Img));
					lblSummonerWinner4Item2Id.setIcon(new ImageIcon(resizeItem2Img));
					lblSummonerWinner4Item3Id.setIcon(new ImageIcon(resizeItem3Img));
					lblSummonerWinner4Item4Id.setIcon(new ImageIcon(resizeItem4Img));
					lblSummonerWinner4Item5Id.setIcon(new ImageIcon(resizeItem5Img));
					lblSummonerWinner4Item6Id.setIcon(new ImageIcon(resizeItem6Img));
					break;
				}
				case 10: {
					lblSummonerWinner5Item0Id.setIcon(new ImageIcon(resizeItem0Img));
					lblSummonerWinner5Item1Id.setIcon(new ImageIcon(resizeItem1Img));
					lblSummonerWinner5Item2Id.setIcon(new ImageIcon(resizeItem2Img));
					lblSummonerWinner5Item3Id.setIcon(new ImageIcon(resizeItem3Img));
					lblSummonerWinner5Item4Id.setIcon(new ImageIcon(resizeItem4Img));
					lblSummonerWinner5Item5Id.setIcon(new ImageIcon(resizeItem5Img));
					lblSummonerWinner5Item6Id.setIcon(new ImageIcon(resizeItem6Img));
					break;
				}
			}
			}
		});
		setSummonerItemThread.start();
	}
	
	//스펠 ID를 이용해 스펠 이름으로 변경,,
	public void loadSpellInfo(int spellId1, int spellId2) {
		//라이엇에서 제공하는 spells.json는 데이터가 많아서 내가 가공..
		try {
			//parser와 FileReader로 spells.json을 읽어 옴
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(new FileReader("src/riot_assets/spells.json"));
			
			JSONArray jsonSpellArray = (JSONArray)jsonObj.get("data");
			for (int i = 0; i < jsonSpellArray.size(); i++) {
				JSONObject jsonSpellData = (JSONObject)jsonSpellArray.get(i);
				
				if (spellId1 == Integer.parseInt(jsonSpellData.get("key").toString())) {
					spell1Id = jsonSpellData.get("name").toString();
					dmInfo.setSpell1ImgName(jsonSpellData.get("image").toString());
				}
				
				if (spellId2 == Integer.parseInt(jsonSpellData.get("key").toString())) {
					spell2Id = jsonSpellData.get("name").toString();
					dmInfo.setSpell2ImgName(jsonSpellData.get("image").toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//챔피언 ID를 통해 챔피언 이름으로 변경,,
	public void loadChampionInfo(int champion) {
		//라이엇에서 제공하는 champion.json는 데이터가 많아서 내가 가공.. 신챔나오면 추가해주장
		try {
			//parser와 FileReader로 champion.json을 읽어 옴
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(new FileReader("src/riot_assets/champion.json"));
			
			JSONArray jsonChampionArray = (JSONArray)jsonObj.get("data");
			for (int i = 0; i < jsonChampionArray.size(); i++) {
				JSONObject jsonChampionData = (JSONObject)jsonChampionArray.get(i);
				
				if (champion == Integer.parseInt(jsonChampionData.get("key").toString())) {
					championName = jsonChampionData.get("name").toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//챔피언 ID를 통해 초상화롭 변경,,
	public void setChampionPortrait(int champion) {
		//라이엇에서 제공하는 champion.json는 데이터가 많아서 내가 가공.. 신챔나오면 추가해주장
		try {
			//parser와 FileReader로 champion.json을 읽어 옴
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(new FileReader("src/riot_assets/champion.json"));
			
			JSONArray jsonChampionArray = (JSONArray)jsonObj.get("data");
			for (int i = 0; i < jsonChampionArray.size(); i++) {
				JSONObject jsonChampionData = (JSONObject)jsonChampionArray.get(i);
				
				if (champion == Integer.parseInt(jsonChampionData.get("key").toString())) {
					championName = jsonChampionData.get("id").toString();
				}
			}
			File championPortrait = new File("src/riot_image/champion/" + championName +".png");
			summonerChampionImage = ImageIO.read(championPortrait);
			resizeSummonerChampionImg = summonerChampionImage.getScaledInstance(32, 32, Image.SCALE_SMOOTH);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		switch (dmInfo.getParticipantId()) {
			case 1: {
				lblSummonerLossesChampion1.setIcon(new ImageIcon(resizeSummonerChampionImg));
				break;
			}
			case 2: {
				lblSummonerLossesChampion2.setIcon(new ImageIcon(resizeSummonerChampionImg));
				break;
			}
			case 3: {
				lblSummonerLossesChampion3.setIcon(new ImageIcon(resizeSummonerChampionImg));
				break;
			}
			case 4: {
				lblSummonerLossesChampion4.setIcon(new ImageIcon(resizeSummonerChampionImg));
				break;
			}
			case 5: {
				lblSummonerLossesChampion5.setIcon(new ImageIcon(resizeSummonerChampionImg));
				break;
			}
			case 6: {
				lblSummonerWinnerChampion1.setIcon(new ImageIcon(resizeSummonerChampionImg));
				break;
			}
			case 7: {
				lblSummonerWinnerChampion2.setIcon(new ImageIcon(resizeSummonerChampionImg));
				break;
			}
			case 8: {
				lblSummonerWinnerChampion3.setIcon(new ImageIcon(resizeSummonerChampionImg));
				break;
			}
			case 9: {
				lblSummonerWinnerChampion4.setIcon(new ImageIcon(resizeSummonerChampionImg));
				break;
			}
			case 10: {
				lblSummonerWinnerChampion5.setIcon(new ImageIcon(resizeSummonerChampionImg));
				break;
			}
		}
	}
}