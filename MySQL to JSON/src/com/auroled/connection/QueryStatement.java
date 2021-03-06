package com.auroled.connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.auroled.entity.BattingBowlingTeams;

public class QueryStatement extends EstablishConnection {

	static List<Object> dataBaseList = new ArrayList<>();

	static EstablishConnection ec = new EstablishConnection();
	static Statement st;

	Convertion c = new Convertion();

	public static void getBattingBowlingTeam(String query) {
		List<BattingBowlingTeams> battingBowlingTeamList = new ArrayList<>();
		ec.getConnection();

		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(query);
			dataBaseList.add("========Batting Bowling Team========");
			while (set.next()) {

				battingBowlingTeamList
						.add((new BattingBowlingTeams(set.getString("batting_team"), set.getString("bowling_team"))));

				dataBaseList.add("Match Code = "+ set.getObject("match_code"));
				dataBaseList.add("Batting Team = "+ set.getObject("batting_team"));
				dataBaseList.add("Bowling Team = "+ set.getObject("bowling_team"));

			}

			Convertion.generateCSVForBattingBowlingTeam(battingBowlingTeamList);
		} catch (Exception e) {
			System.out.println("Error in getTeamNames Method");
		}
	}

	public static List<String> getTeamNames(String query) {

		ec.getConnection();

		List<String> teamList = new ArrayList<>();
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(query);
			String captain = "";
			String keeper = " ";

			while (set.next()) {
				if (set.getString("captain").equals("CAP")) {
					captain = " (" + " C " + ")";
				} else {
					captain = "";
				}
				if (set.getString("keeper").equals("WK")) {
					keeper = " (" + " WK " + ")";
				} else {
					keeper = "";
				}
				teamList.add(set.getString("dynamic_name") + captain + keeper);

			}

		} catch (Exception e) {
			System.out.println("Error in getTeamNames Method");
		}
		return teamList;

	}

	public static void getBatsmanInformation(String query) {
		ec.getConnection();
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(query);
			dataBaseList.add("========Batsman Information========");
			while (set.next()) {

				dataBaseList.add("Batsman Player Name = "+ set.getObject("player_name"));


			}

		} catch (Exception e) {
			System.out.println("Error in getBatsmanInformation Method : " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void getBowlingInformatiom(String query) {
		ec.getConnection();
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(query);
			dataBaseList.add("========Bowling Informatiom========");
			while (set.next()) {

				dataBaseList.add("Bowler Player Name = "+ set.getObject("player_name"));


			}

		} catch (Exception e) {
			System.out.println("Error in getBowlingInformatiom Method" + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void getExtrasInformatiom(String query) {
		ec.getConnection();
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(query);
			dataBaseList.add("========Extras Informatiom========");
			while (set.next()) {

				dataBaseList.add("Total Score = "+ set.getObject("total_score"));
				dataBaseList.add("Wickets = "+ set.getObject("wickets"));
				dataBaseList.add("Minutes = "+ set.getObject("Minutes"));
				dataBaseList.add("Bowling End = "+ set.getObject("bowling_end"));
				dataBaseList.add("Innings = "+ set.getObject("innings"));
				dataBaseList.add("Overs = "+set.getObject("overs"));
				dataBaseList.add("Penalties = "+ set.getObject("penalties"));
				dataBaseList.add("Byes = "+ set.getObject("byes"));
				dataBaseList.add("Leg Byes = "+ set.getObject("leg_byes"));


			}

		} catch (Exception e) {
			System.out.println("Error in getExtrasInformatiom Method " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void getExtraScoreInformatiom(String query) {
		ec.getConnection();
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(query);
			dataBaseList.add("========Extra Score Informatiom========");
			while (set.next()) {

				dataBaseList.add("Striker Name = "+ set.getObject("strikername"));
				dataBaseList.add("Ball = "+ set.getObject("ball"));


			}

		} catch (Exception e) {
			System.out.println("Error in getExtraScoreInformatiom Method " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void getFallOfWicketDetails(String query) {
		ec.getConnection();
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(query);
			dataBaseList.add("========FallOfWicket Details========");
			while (set.next()) {

				dataBaseList.add("Batsman Name = "+ set.getObject("batsmanname"));
				dataBaseList.add("Type of Wicket = "+ set.getObject("typeofwicket"));
				dataBaseList.add("Time = "+ set.getObject("time"));
				dataBaseList.add("Total SCore = "+ set.getObject("totalScore"));


			}

		} catch (Exception e) {
			System.out.println("Error in getFallOfWicketDetails Method");
		}

	}

	public static void getMatchInformation(String query) {
		ec.getConnection();
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(query);
			dataBaseList.add("========Match Information========");
			while (set.next()) {

				dataBaseList.add("Number Of Overs = "+ set.getObject("number_of_overs"));
				dataBaseList.add("Super Over = "+ set.getObject("superover"));
				dataBaseList.add("Target Run = "+ set.getObject("target_run"));
				dataBaseList.add("M start Date = "+ set.getObject("mstartdate"));


			}

		} catch (Exception e) {
			System.out.println("Error in getMatchInformation Method " + e.getMessage());
			e.printStackTrace();
		}

	}

 	public static void getMatchScoreDetails(String query) {

		ec.getConnection();
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(query);
			dataBaseList.add("========Match ScoreDetails========");
			while (set.next()) {

				dataBaseList.add("Striker Name = "+ set.getObject("strikername"));
				dataBaseList.add("Bowler Name = "+ set.getObject("bowlername"));
				dataBaseList.add("Run = "+ set.getObject("run"));


			}

		} catch (Exception e) {
			System.out.println("Error in getMatchScoreDetails Method " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	public static void getTextFile() {

	Convertion.generateTextFile(dataBaseList);

	}

	public static String getLastMatchCode(String query) {
		String res=null;
		ec.getConnection();
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(query);
			while (set.next()) {
			res = set.getString("matchcode");
			}
			
		} catch (Exception e) {
			System.out.println("Error in getLastMatchCode Method : "+ e.getMessage());
			e.printStackTrace();
		}
		return res ;
	}

}
