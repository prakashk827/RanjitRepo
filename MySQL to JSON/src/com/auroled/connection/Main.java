package com.auroled.connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {

		
		  List<List<String>> totalTeamList = new ArrayList<>();
		  
		  List<String> ATeamList = new ArrayList<>(); String query1 =
		  "select * from away_team_information"; ATeamList =
		  QueryStatement.getTeamNames(query1); totalTeamList.add(ATeamList);
		  
		  List<String> BTeamList = new ArrayList<>(); String query2 =
		  "select * from home_team_information"; BTeamList =
		  QueryStatement.getTeamNames(query2); totalTeamList.add(BTeamList);
		  Convertion.generateCSVFile(totalTeamList);
		  
		  String query3 = "select * from batting_bowling_teams";
		  QueryStatement.getBattingBowlingTeam(query3);
		 

		// sql to text
		  
		String query = "SELECT matchcode FROM  matchscore_details ORDER  BY id DESC LIMIT 1";
		String matchCode = QueryStatement.getLastMatchCode(query);
		System.out.println("Match Code from Main :" + matchCode);

		String query4 = "SELECT * FROM batsman_information WHERE match_code = 'matchCode'";
		QueryStatement.getBatsmanInformation(query4);

		String query5 = "select * from bowler_information where match_code='matchCode'";
		QueryStatement.getBowlingInformatiom(query5);

		String query6 = "SELECT * FROM extras_information WHERE match_code='matchCode'";
		QueryStatement.getExtrasInformatiom(query6);

		String query7 = "select * from extrascore_details where matchcode='matchCode'";
		QueryStatement.getExtraScoreInformatiom(query7);

		String query8 = "select * from fallofwicket_details where matchcode='matchCode'";
		QueryStatement.getFallOfWicketDetails(query8);

		String query9 = "select * from match_information where match_code='matchCode'";
		QueryStatement.getMatchInformation(query9);

		String query10 = "select * from matchscore_details where matchcode='matchCode'";
		QueryStatement.getMatchScoreDetails(query10);

		QueryStatement.getTextFile();

	}
}
