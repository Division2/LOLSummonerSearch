package com.java.ex.riot;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.java.ex.riotinfo.BaseURL;
import com.java.ex.riotinfo.SummonerInfo;

public class SearchSummoner extends JFrame {
	Container ct;
	JPanel searchPanel;
	JPanel borderGroup;
	
	JLabel lblSummonerNick;
	JLabel lblSummonerIcon;
	JLabel lblSummonerLevel;
	JLabel lblSummonerSoloScore; 
	JLabel lblSummonerTeamScore;
	JLabel lblSummonerTFTScore;
	JLabel lblSummonerTimeStamp;
	
	JLabel lblSummonerLeagueSolo;
	JLabel lblSummonerSoloTier;
	JLabel lblSummonerSoloTier_Rank;
	JLabel lblSummonerSoloPoints;
	JLabel lblSummonerSoloRate;
	JLabel lblSummonerSoloProgress;
	
	JLabel lblSummonerLeagueTeam;
	JLabel lblSummonerTeamTier;
	JLabel lblSummonerTeamTier_Rank;
	JLabel lblSummonerTeamPoints;
	JLabel lblSummonerTeamRate;
	JLabel lblSummonerTeamProgress;
	
	JLabel lblSummonerLeagueTFT;
	JLabel lblSummonerTFTTier;
	JLabel lblSummonerTFTTier_Rank;
	JLabel lblSummonerTFTPoints;
	JLabel lblSummonerTFTRate;
	
	JTextField summonerNick;
	JButton btnSearch;
	
	JButton btnMatchInquiry;
	
	JButton btnChampionRotation;
	
	ImageIcon tierImage;
	URL profileIconURL;
	Image profileImage;
	Image resizeProfileImg;
	String tierIconPath;

	public SearchSummoner(SummonerInfo sInfo) {
		ct = getContentPane();
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		
		//소환사 닉네임, 프로필, 승, 패
		summonerNick = new JTextField("17831023");
		summonerNick.setBounds(10, 10, 385, 30);
		summonerNick.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					setTierClear();
					summonerSearch(sInfo);
					summonerScore(sInfo);
					tftSummonerScore(sInfo);
				}
			}
		});
		summonerNick.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				summonerNick.setText("");
			}
		});

		lblSummonerIcon = new JLabel();
		lblSummonerIcon.setBounds(10, 50, 75, 75);
		
		lblSummonerNick = new JLabel();
		lblSummonerNick.setBounds(90, 45, 200, 30);
		
		Font nickFont = new Font("굴림", Font.BOLD, 20);
		lblSummonerNick.setFont(nickFont);
		
		lblSummonerLevel = new JLabel();
		lblSummonerLevel.setBounds(90, 65, 100, 30);
		
		lblSummonerSoloScore = new JLabel();
		lblSummonerSoloScore.setBounds(90, 85, 100, 30);
		
		lblSummonerTeamScore = new JLabel();
		lblSummonerTeamScore.setBounds(190, 85, 100, 30);
		
		lblSummonerTFTScore = new JLabel();
		lblSummonerTFTScore.setBounds(310, 170, 100, 30);
		
		lblSummonerTimeStamp = new JLabel();
		lblSummonerTimeStamp.setBounds(90, 105, 150, 30);
		
		//---------------- 소환사 정보 그룹
		borderGroup = new JPanel();
		borderGroup.setLayout(null);
		borderGroup.setBounds(10, 135, 465, 240);
		borderGroup.setBorder(new TitledBorder(null, "소환사 정보", TitledBorder.LEADING, TitledBorder.TOP));
		
		lblSummonerLeagueSolo = new JLabel();
		lblSummonerLeagueSolo.setBounds(15, 90, 300, 30);
		
		lblSummonerSoloTier = new JLabel();
		lblSummonerSoloTier.setBounds(15, 20, 75, 75);
		
		lblSummonerSoloTier_Rank = new JLabel();
		lblSummonerSoloTier_Rank.setBounds(15, 110, 300, 30);
		
		lblSummonerSoloPoints = new JLabel();
		lblSummonerSoloPoints.setBounds(15, 130, 90, 30);
		
		lblSummonerSoloRate = new JLabel();
		lblSummonerSoloRate.setBounds(15, 150, 110, 30);
		
		lblSummonerSoloProgress = new JLabel();
		lblSummonerSoloProgress.setBounds(15, 170, 110, 30);
		
		lblSummonerLeagueTeam = new JLabel();
		lblSummonerLeagueTeam.setBounds(165, 90, 300, 30);
		
		lblSummonerTeamTier = new JLabel();
		lblSummonerTeamTier.setBounds(165, 20, 75, 75);
		
		lblSummonerTeamTier_Rank = new JLabel();
		lblSummonerTeamTier_Rank.setBounds(165, 110, 300, 30);
		
		lblSummonerTeamPoints = new JLabel();
		lblSummonerTeamPoints.setBounds(165, 130, 90, 30);
		
		lblSummonerTeamRate = new JLabel();
		lblSummonerTeamRate.setBounds(165, 150, 110, 30);
		
		lblSummonerTeamProgress = new JLabel();
		lblSummonerTeamProgress.setBounds(165, 170, 110, 30);
		
		lblSummonerLeagueTFT = new JLabel();
		lblSummonerLeagueTFT.setBounds(310, 90, 300, 30);
		
		lblSummonerTFTTier = new JLabel();
		lblSummonerTFTTier.setBounds(310, 20, 75, 75);
		
		lblSummonerTFTTier_Rank = new JLabel();
		lblSummonerTFTTier_Rank.setBounds(310, 110, 300, 30);
		
		lblSummonerTFTPoints = new JLabel();
		lblSummonerTFTPoints.setBounds(310, 130, 90, 30);
		
		lblSummonerTFTRate = new JLabel();
		lblSummonerTFTRate.setBounds(310, 150, 110, 30);
		//---------------- 소환사 정보 그룹
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(400, 10, 80, 30);
		btnSearch.setBackground(Color.PINK);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTierClear();
				summonerSearch(sInfo);
				summonerScore(sInfo);
				tftSummonerScore(sInfo);
			}
		});
		
		//사용자 게임 매치정보
		btnMatchInquiry = new JButton("매치 정보");
		btnMatchInquiry.setBounds(10, 200, 285, 30);
		btnMatchInquiry.setVisible(false);
		btnMatchInquiry.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchSummonerMatch(sInfo);
			}
		});
		
		searchPanel.add(lblSummonerNick);
		searchPanel.add(lblSummonerIcon);
		searchPanel.add(lblSummonerLevel);
		searchPanel.add(lblSummonerSoloScore);
		searchPanel.add(lblSummonerTeamScore);
		//TFT는 승률 밑에 띄우장
		borderGroup.add(lblSummonerTFTScore);
		searchPanel.add(lblSummonerTimeStamp);
		
		borderGroup.add(lblSummonerLeagueSolo);
		borderGroup.add(lblSummonerSoloTier);
		borderGroup.add(lblSummonerSoloTier_Rank);
		borderGroup.add(lblSummonerSoloPoints);
		borderGroup.add(lblSummonerSoloRate);
		borderGroup.add(lblSummonerSoloProgress);
		borderGroup.add(btnMatchInquiry);
		
		borderGroup.add(lblSummonerLeagueTeam);
		borderGroup.add(lblSummonerTeamTier);
		borderGroup.add(lblSummonerTeamTier_Rank);
		borderGroup.add(lblSummonerTeamPoints);
		borderGroup.add(lblSummonerTeamRate);
		borderGroup.add(lblSummonerTeamProgress);
		
		borderGroup.add(lblSummonerLeagueTFT);
		borderGroup.add(lblSummonerTFTTier);
		borderGroup.add(lblSummonerTFTTier_Rank);
		borderGroup.add(lblSummonerTFTPoints);
		borderGroup.add(lblSummonerTFTRate);
		
		searchPanel.add(summonerNick);
		searchPanel.add(btnSearch);

		ct.add(borderGroup);
		ct.add(searchPanel);

		setVisible(true);
		setSize(500, 420);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//소환사 검색 메소드
	public void summonerSearch(SummonerInfo sInfo) {
		try {
			String apiURL = BaseURL.SEARCH_SUMMONER + summonerNick.getText().toString().replace(" ", "") + "?api_key=" + BaseURL.API_KEY;
			
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
			
			JSONParser parse = new JSONParser();
			JSONObject jsonObj = (JSONObject)parse.parse(response.toString());
			
			sInfo.setId(jsonObj.get("id").toString());
			sInfo.setAccountId(jsonObj.get("accountId").toString());
			sInfo.setPuuid(jsonObj.get("puuid").toString());
			sInfo.setSummonerName(jsonObj.get("name").toString());
			sInfo.setProfileIconId(Integer.parseInt(jsonObj.get("profileIconId").toString()));
			sInfo.setRevisionDate((Long)jsonObj.get("revisionDate"));
			sInfo.setSumonerLevel((Long)jsonObj.get("summonerLevel"));

	        profileIconURL = new URL(BaseURL.PROFILE_ICON + sInfo.getProfileIconId() +".png");
	        profileImage = ImageIO.read(profileIconURL);
			resizeProfileImg = profileImage.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
	        
			lblSummonerNick.setText(sInfo.getSummonerName());
			lblSummonerIcon.setIcon(new ImageIcon(resizeProfileImg));
			lblSummonerIcon.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			lblSummonerLevel.setText("레벨 : " + sInfo.getSumonerLevel());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			lblSummonerTimeStamp.setText(sdf.format(sInfo.getRevisionDate()));
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "존재하지 않는 소환사입니다.", "GG", JOptionPane.WARNING_MESSAGE);
		} catch (IIOException e) {
			lblSummonerIcon.setIcon(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//소환사 SOLO 5:5, TEAM 5:5 리그 검색
	public void summonerScore(SummonerInfo sInfo) {
		try {
			String apiURL = BaseURL.SEARCH_SCORE + sInfo.getId() + "?api_key=" + BaseURL.API_KEY;
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
			JSONArray jsonArray = (JSONArray)parser.parse(response.toString());
			
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObj = (JSONObject)jsonArray.get(i);
				JSONObject miniSeries = (JSONObject)jsonObj.get("miniSeries");

				sInfo.setQueueType(jsonObj.get("queueType").toString());
				sInfo.setTier(jsonObj.get("tier").toString());
				sInfo.setTier_rank(jsonObj.get("rank").toString());
				sInfo.setWins(Integer.parseInt(jsonObj.get("wins").toString()));
				sInfo.setLosses(Integer.parseInt(jsonObj.get("losses").toString()));
				sInfo.setLeaguePoints(Integer.parseInt(jsonObj.get("leaguePoints").toString()));
				
				if (miniSeries != null) {
					sInfo.setProgress(miniSeries.get("progress").toString());
					sInfo.setpWins(Integer.parseInt(miniSeries.get("wins").toString()));
					sInfo.setpLosses(Integer.parseInt(miniSeries.get("losses").toString()));
				}
				
				if (response.toString().equals("[]")) {
					sInfo.setTier("UNRANKED");
					btnMatchInquiry.setVisible(false);
				}
				else {
					setTierIcon(sInfo.getTier());

					lblSummonerNick.setText(sInfo.getSummonerName());
					tierImage = new ImageIcon(tierIconPath);
					Image tierImage2 = tierImage.getImage();
					Image resizeTierImg = tierImage2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
					btnMatchInquiry.setVisible(true);
					
					if (sInfo.getQueueType().equals("RANKED_SOLO_5x5")) {
						lblSummonerSoloTier.setIcon(new ImageIcon(resizeTierImg));
						lblSummonerSoloTier_Rank.setText("등급 : " + sInfo.getTier() + " " + sInfo.getTier_rank());
						lblSummonerLeagueSolo.setText("랭크 타입 : 솔로 랭크");
						lblSummonerSoloPoints.setText("점수 : " + sInfo.getLeaguePoints());
						lblSummonerSoloScore.setText("승리 : " + sInfo.getWins() + " 패배 : " + sInfo.getLosses());
							
						Double avg = Double.valueOf(sInfo.getWins()) + Double.valueOf(sInfo.getLosses());
						Double wins = Double.valueOf(sInfo.getWins()) / avg * 100;
						lblSummonerSoloRate.setText("승률 : " + String.format("%.0f", wins) + "%");
						
						if (miniSeries != null) {
							lblSummonerSoloProgress.setText("승격전 : " + sInfo.getProgress());
						}
						else {
							lblSummonerSoloProgress.setText("승격전 : -");
						}
					}
					if (sInfo.getQueueType().equals("RANKED_FLEX_SR")) {
						lblSummonerTeamTier.setIcon(new ImageIcon(resizeTierImg));
						lblSummonerTeamTier_Rank.setText("등급 : " + sInfo.getTier() + " " + sInfo.getTier_rank());
						lblSummonerLeagueTeam.setText("랭크 타입 : 자유 랭크");
						lblSummonerTeamPoints.setText("점수 : " + sInfo.getLeaguePoints());
						lblSummonerTeamScore.setText("승리 : " + sInfo.getWins() + " 패배 : " + sInfo.getLosses());
						
						Double avg = Double.valueOf(sInfo.getWins()) + Double.valueOf(sInfo.getLosses());
						Double wins = Double.valueOf(sInfo.getWins()) / avg * 100;
						lblSummonerTeamRate.setText("승률 : " + String.format("%.0f", wins) + "%");
						
						if (miniSeries != null) {
							lblSummonerTeamProgress.setText("승격전 : " + sInfo.getProgress());
						}
						else {
							lblSummonerTeamProgress.setText("승격전 : -");
						}
					}
				}
			}
		} catch (ClassCastException e) {
			System.out.println("존재하지 않는 소환사");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//소환사 TFT 리그 검색
	public void tftSummonerScore(SummonerInfo sInfo) {
		try {
			String apiURL = BaseURL.SEACRH_TFT + sInfo.getId() + "?api_key=" + BaseURL.API_KEY;
			
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
			
			if (response.toString().equals("[]")) {
				sInfo.setTier("UNRANKED");
			}
			
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray)parser.parse(response.toString());

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObj = (JSONObject)jsonArray.get(i);
				
				sInfo.setQueueType(jsonObj.get("queueType").toString());
				sInfo.setTier(jsonObj.get("tier").toString());
				sInfo.setTier_rank(jsonObj.get("rank").toString());
				sInfo.setWins(Integer.parseInt(jsonObj.get("wins").toString()));
				sInfo.setLosses(Integer.parseInt(jsonObj.get("losses").toString()));
				sInfo.setLeaguePoints(Integer.parseInt(jsonObj.get("leaguePoints").toString()));
				
				setTierIcon(sInfo.getTier());
				tierImage = new ImageIcon(tierIconPath);
				Image tierImage2 = tierImage.getImage();
				Image resizeTierImg = tierImage2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
				
				lblSummonerTFTTier.setIcon(new ImageIcon(resizeTierImg));
				lblSummonerTFTTier_Rank.setText("등급 : " + sInfo.getTier() + " " + sInfo.getTier_rank());
				lblSummonerLeagueTFT.setText("랭크 타입 : 전략전 팀 전투");
				lblSummonerTFTPoints.setText("점수 : " + sInfo.getLeaguePoints());
				lblSummonerTFTScore.setText("승리 : " + sInfo.getWins());
				
				Double avg = Double.valueOf(sInfo.getWins()) + Double.valueOf(sInfo.getLosses());
				Double wins = Double.valueOf(sInfo.getWins()) / avg * 100;
				lblSummonerTFTRate.setText("승률 : " + String.format("%.0f", wins) + "%");
			}
		} catch (ClassCastException e) {
			System.out.println("존재하지 않는 소환사");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setTierIcon(String tier) {
		switch (tier) {
			case "UNRANKED": {
				break;
			}
			case "IRON": {
				tierIconPath = "src/riot_image/Emblem_Iron.png";
				break;
			}
			case "BRONZE": {
				tierIconPath = "src/riot_image/Emblem_Bronze.png";
				break;
			}
			case "SILVER": {
				tierIconPath = "src/riot_image/Emblem_Silver.png";
				break;
			}
			case "GOLD": {
				tierIconPath = "src/riot_image/Emblem_Gold.png";
				break;
			}
			case "PLATINUM": {
				tierIconPath = "src/riot_image/Emblem_Platinum.png";
				break;
			}
			case "DIAMOND": {
				tierIconPath = "src/riot_image/Emblem_Diamond.png";
				break;
			}
			case "MASTER": {
				tierIconPath = "src/riot_image/Emblem_Master.png";
				break;
			}
			case "GRANDMASTER": {
				tierIconPath = "src/riot_image/Emblem_Grandmaster.png";
				break;
			}
			case "CHALLENGER": {
				tierIconPath = "src/riot_image/Emblem_Challenger.png";
				break;
			}
		}
	}
	
	public void setTierClear() {
		lblSummonerSoloScore.setText("승리 : 0 패배 : 0");
		lblSummonerSoloTier.setIcon(null);
		lblSummonerSoloTier.setText("Unranked");
		lblSummonerLeagueSolo.setText("");
		lblSummonerSoloTier_Rank.setText("");
		lblSummonerSoloPoints.setText("");
		lblSummonerSoloRate.setText("");
		lblSummonerSoloProgress.setText("");
		
		lblSummonerTeamScore.setText("승리 : 0 패배 : 0");
		lblSummonerTeamTier.setIcon(null);
		lblSummonerTeamTier.setText("Unranked");
		lblSummonerLeagueTeam.setText("");
		lblSummonerTeamTier_Rank.setText("");
		lblSummonerTeamPoints.setText("");
		lblSummonerTeamRate.setText("");
		lblSummonerTeamProgress.setText("");
		
		lblSummonerTFTTier.setIcon(null);
		lblSummonerTFTTier.setText("Unranked");
		lblSummonerTFTTier_Rank.setText("");
		lblSummonerLeagueTFT.setText("");
		lblSummonerTFTPoints.setText("");
		lblSummonerTFTScore.setText("");
		lblSummonerTFTRate.setText("");
	}
}