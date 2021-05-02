package com.java.ex.riot;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.java.ex.riotinfo.BaseURL;
import com.java.ex.riotinfo.MatchInfo;
import com.java.ex.riotinfo.SummonerInfo;

public class SearchSummonerMatch extends JFrame {
	Container ct;
	JPanel searchMatchPanel;
	
	String[] header = {"Champion", "GameID", "Lane", "PlatformId", "Queue", "Role", "Season", "GameStartTime"};
	JTable matchTable;
	DefaultTableModel matchDTM;
	DefaultTableCellRenderer matchDTCR;
	TableColumnModel matchTCM;
	JScrollPane matchScroll;
	
	String matchConverQueue;
	String championName;
	
	MatchInfo mInfo = new MatchInfo();
	
	public SearchSummonerMatch(SummonerInfo sInfo) {
		ct = getContentPane();
		searchMatchPanel = new JPanel();
		searchMatchPanel.setLayout(null);
		
		//테이블 목록 수정 불가
		matchDTM = new DefaultTableModel(header, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		//테이블 설정
		matchTable = new JTable(matchDTM);
		matchTable.setRowHeight(30);
		matchTable.getTableHeader().setReorderingAllowed(false);
		matchTable.getColumnModel().getColumn(5).setPreferredWidth(90);
		matchTable.getColumnModel().getColumn(7).setPreferredWidth(125);
		matchTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = matchTable.getSelectedRow();
					Object gameId = matchTable.getValueAt(row, 1);
					
					new SearchSummonerMatchDetailInfo(gameId);
				}
			}
		});
		
		matchScroll = new JScrollPane(matchTable);
		matchScroll.setBounds(10, 10, 765, 445);
		
		//테이블 컬럼 중앙 정렬
		matchDTCR = new DefaultTableCellRenderer();
		matchDTCR.setHorizontalAlignment(SwingConstants.CENTER);
		matchTCM = matchTable.getColumnModel();
		
		//header 크기만큼 컬럼들을 중앙 정렬
		for (int i = 0; i < header.length; i++) {
			matchTCM.getColumn(i).setCellRenderer(matchDTCR);
		}
		
		searchMatch(sInfo, mInfo);
		
		searchMatchPanel.add(matchScroll);
		
		ct.add(searchMatchPanel);
		
		setVisible(true);
		setSize(800, 500);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public void searchMatch(SummonerInfo sInfo, MatchInfo mInfo) {
		try {
			String apiURL = BaseURL.MATCH_LISTS + sInfo.getAccountId() + "?api_key=" + BaseURL.API_KEY;
			
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
			
			JSONArray jsonArray = (JSONArray)jsonObj.get("matches");

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonMatches = (JSONObject)jsonArray.get(i);
				
				mInfo.setGameId(Long.parseLong(jsonMatches.get("gameId").toString()));
				mInfo.setChampion(Integer.parseInt(jsonMatches.get("champion").toString()));
				mInfo.setQueue(Integer.parseInt(jsonMatches.get("queue").toString()));
				mInfo.setSeason(Integer.parseInt(jsonMatches.get("season").toString()));
				mInfo.setTimeStamp(Long.parseLong(jsonMatches.get("timestamp").toString()));
				mInfo.setPlatformId(jsonMatches.get("platformId").toString());
				mInfo.setRole(jsonMatches.get("role").toString());
				mInfo.setLane(jsonMatches.get("lane").toString());
				
				matchQueue(mInfo.getQueue());
				loadChampionInfo(mInfo.getChampion());
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Object[] data = {championName + "(" + mInfo.getChampion() + ")", mInfo.getGameId(), mInfo.getLane(), mInfo.getPlatformId(), matchConverQueue, mInfo.getRole(), mInfo.getSeason(), sdf.format(mInfo.getTimeStamp())};
				matchDTM.addRow(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadChampionInfo(int champion) {
		//라이엇에서 제공하는 champion.json는 데이터가 많아서 내가 가공.. 신챔나오면 추가해주장
		try {
			//parser와 FileReader로 champion2.json을 읽어 옴
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
	
	//Queue 지정 메소드
	public void matchQueue(int queue) {
		switch (queue) {
			case 420: {
				matchConverQueue = "솔로 랭크";
				break;
			}
			case 430: {
				matchConverQueue = "일반 게임";
				break;
			}
			case 440 : {
				matchConverQueue = "자유 랭크";
				break;
			}
		}
	}
}