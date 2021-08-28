package com.company;

/**
 * <h1>Bet</h1>
 * <p>This is the class for the Bet object that stores info on what a game is and what the user can do.</p>
 *
 * <p>Created: 8/28/2021</p>
 *
 * @author Kellen Nankervis
 */

public class Bet {
    private int id;
    private String name;
    private String dateStart;
    private String dateEnd;
    private String teamOne;
    private String teamTwo;
    private double oddOne;
    private double oddTwo;
    private String winningTeam;
    private int winningNum;
    private double minBet;
    private double maxBet;

    /**
     * Name: Bet
     * This Method is used to create a bet
     * @param id (Int; the id of the bet.)
     * @param name (String; the name of the bet.)
     * @param dateStart (String; the start date of the bet.)
     * @param dateEnd (String; the end date of the bet.)
     * @param teamOne (String; the first team of the bet.)
     * @param teamTwo (String; the second team of the bet.)
     * @param oddOne (double; the first teams odds.)
     * @param oddTwo (double; the second teams odds.)
     * @param winningTeam (String; the winning team.)
     * @param winningNum (int; the winning teams number.)
     * @param minBet (double; the minimum a user can bet.)
     * @param maxBet (double; the maximum a user can bet.)
     */

    Bet(int id, String name, String dateStart, String dateEnd, String teamOne, String teamTwo,
        double oddOne, double oddTwo, String winningTeam, int winningNum
    , double minBet, double maxBet){
        this.id = id;
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.oddOne = oddOne;
        this.oddTwo = oddTwo;
        this.winningTeam = winningTeam;
        this.winningNum = winningNum;
        this.minBet = minBet;
        this.maxBet = maxBet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getID(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDateStart(String dateStart){
        this.dateStart = dateStart;
    }

    public String getDateStart(){
        return dateStart;
    }

    public void setDateEnd(String dateEnd){
        this.dateEnd = dateEnd;
    }

    public String getDateEnd(){
        return dateEnd;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamOne(){
        return teamOne;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getTeamTwo(){
        return teamTwo;
    }

    public void setOddOne(double oddOne) {
        this.oddOne = oddOne;
    }

    public double getOddOne() {
        return oddOne;
    }

    public void setOddTwo(double oddTwo) {
        this.oddTwo = oddTwo;
    }

    public double getOddTwo() {
        return oddTwo;
    }

    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public void setWinningNum(int winningNum) {
        this.winningNum = winningNum;
    }

    public int getWinningNum() {
        return winningNum;
    }

    public void setMinBet(double minBet) {
        this.minBet = minBet;
    }

    public double getMinBet() {
        return minBet;
    }

    public void setMaxBet(double maxBet) {
        this.maxBet = maxBet;
    }

    public double getMaxBet() {
        return maxBet;
    }

    /**
     * Name: toStringOne
     * This Method is used to print the bet object for ongoing and completed bets on the user end.
     */

    public String toStringOne(){
        return "Bet ID: " + getID() + "\nBet name: " + getName() + "\nStart Date: " + getDateStart() + "\nEnd Date:" +
                " " + getDateEnd() + "\nTeam 1: " + getTeamOne() + "\nTeam 1's odds: " + getOddOne() +
                "\nTeam 2: " + getTeamTwo() + "\nTeam 2's odds: " + getOddTwo() + "\nWinning Team: "
                + getWinningTeam() + "\nWinning Team's Number: " + getWinningNum();
    }

    /**
     * Name: toStringTwo
     * This Method is used to print the bet object for upcoming bets on the user end.
     */

    public String toStringTwo(){
        return "Bet ID: " + getID() + "\nBet name: " + getName() + "\nStart Date: " + getDateStart() + "\nEnd Date:" +
                " " + getDateEnd() + "\nTeam 1: " + getTeamOne() + "\nTeam 1's odds: " + getOddOne() +
                "\nTeam 2: " + getTeamTwo() + "\nTeam 2's odds: " + getOddTwo() + "\nMinimum Bet amount: "
                + getMinBet() + "\nMaximum Bet amount: " + getMaxBet();
    }

    /**
     * Name: toStringTwo
     * This Method is used to print the bet object for all bets on the admin end.
     */

    public String toStringThree(){
        return "Bet ID: " + getID() + "\nBet name: " + getName() + "\nStart Date: " + getDateStart() + "\nEnd Date:" +
                " " + getDateEnd() + "\nTeam 1: " + getTeamOne() + "\nTeam 1's odds: " + getOddOne() +
                "\nTeam 2: " + getTeamTwo() + "\nTeam 2's odds: " + getOddTwo() + "\nWinning Team: "
                + getWinningTeam() + "\nWinning Team's Number: " + getWinningNum() + "\nMinimum Bet amount: "
                + getMinBet() + "\nMaximum Bet amount: " + getMaxBet();
    }
}
