package com.auroled.entity;

public class BattingBowlingTeams {
    
    
    private String match_code;
    private String batting_team;
    private String bowling_team;
    
    
    	public BattingBowlingTeams(String batting_team, String bowling_team) {
		super();
		this.batting_team = batting_team;
		this.bowling_team = bowling_team;
        }
    
    public String getMatch_code() {
		return match_code;
	}
	public void setMatch_code(String match_code) {
		this.match_code = match_code;
	}
	public String getBatting_team() {
		return batting_team;
	}
	public void setBatting_team(String batting_team) {
		this.batting_team = batting_team;
	}
	public String getBowling_team() {
		return bowling_team;
	}
	public void setBowling_team(String bowling_team) {
		this.bowling_team = bowling_team;
	}
    
    
    
    
}
