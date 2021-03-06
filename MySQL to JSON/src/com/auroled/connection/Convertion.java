package com.auroled.connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.auroled.entity.BattingBowlingTeams;

public class Convertion {

	/*
	 * public static JSONObject getMapToJson(TreeMap < Integer, String >
	 * sortedPlayerMapList) { JSONObject jsonData = null; try { jsonData = new
	 * JSONObject(sortedPlayerMapList); } catch (Exception e) {
	 * System.out.println("Error while getiing json data"); }
	 * 
	 * return jsonData;
	 * 
	 * }
	 */

	public static void generateCSVFile(List<List<String>> totalTeamList) {
		PrintWriter pw = null;
		String filePath = "cricket_team.csv";
		StringBuilder sb = new StringBuilder();
		try {
			pw = new PrintWriter(new File(filePath));
			sb.append("RCB" + "," + "DC" + "\r\n" + "\r\n");
			int totalTeamPlayers = totalTeamList.get(0).size();

			for (int i = 0; i < totalTeamPlayers; i++) {

				sb.append(totalTeamList.get(0).get(i) + "," + totalTeamList.get(1).get(i));
				sb.append("\r\n");

			}

			System.out.println("CSV file generatd successfully with the name" + filePath);

		} catch (FileNotFoundException e) {
			System.out.println("Error while generating" + filePath + " file");
			System.out.println("Please close recently opened " + filePath + " .If it is opened");
			e.printStackTrace();
		} finally {
			pw.write(sb.toString());
			pw.close();
		}

	}

	public static void generateCSVForBattingBowlingTeam(List<BattingBowlingTeams> battingBowlingTeamList) {
		PrintWriter pw = null;
		String filePath = "Batting_Bowling_team.csv";
		StringBuilder sb = new StringBuilder();
		try {
			pw = new PrintWriter(new File(filePath));

			sb.append("Batting_team\t" + "," + "Bowling_team\t" + "\r\n" + "\r\n");

			for (BattingBowlingTeams list : battingBowlingTeamList) {
				sb.append(list.getBatting_team() + "," + list.getBowling_team());
				sb.append("\r\n");
			}

			System.out.println("CSV file generatd successfully with the name" + filePath);

		} catch (FileNotFoundException e) {
			System.out.println("Error while generating" + filePath + " file");
			System.out.println("Please close recently opened " + filePath + " .If it is opened");
			e.printStackTrace();
		} finally {
			pw.write(sb.toString());
			pw.close();
		}

	}

	public static void generateTextFile(List<Object> dataBaseList) {

		FileWriter fw = null;
		
		try {
			fw = new FileWriter("testout.txt");

			for (Object list : dataBaseList) {
				
				System.out.println(list);
				fw.write(list + "\r\n");

			}

		} catch (IOException e1) {

			e1.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
