package com.leecottrell.testsports.testsports;

public class Sport {
    String sportName;
    String stadium;
    String teamName;

    public Sport() {
        sportName="No Sport";
        stadium = "Nowhere";
        teamName ="Nobody";
    }

    public Sport(String sportName, String stadium, String teamName) {
        this.sportName = sportName;
        this.stadium = stadium;
        this.teamName = teamName;
    }

    public String getSportName() {
        return this.sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getStadium() {
        return this.stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Sport sportName(String sportName) {
        setSportName(sportName);
        return this;
    }

    public Sport stadium(String stadium) {
        setStadium(stadium);
        return this;
    }

    public Sport teamName(String teamName) {
        setTeamName(teamName);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " sportName='" + getSportName() + "'" +
            ", stadium='" + getStadium() + "'" +
            ", teamName='" + getTeamName() + "'" +
            "}";
    }
    
}
