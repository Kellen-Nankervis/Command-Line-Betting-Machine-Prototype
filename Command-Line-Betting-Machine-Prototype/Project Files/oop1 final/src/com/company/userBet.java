package com.company;

/**
 * <h1>UserBet</h1>
 * <p>This is the class for the userBet object that stores information on the users bets</p>
 *
 * <p>Created: 8/28/2021</p>
 *
 * @author Kellen Nankervis
 */

public class userBet {
    private int id;
    private double amountBet;
    private int teamBet;
    private int complete;

    /**
     * Name: userBet
     * This Method is used to create the userBet object.
     * @param id (int; the id of the bet.)
     * @param amountBet (double; the amount bet.)
     * @param teamBet (int; the team that is bet on.)
     * @param complete (int; a check for if the bet is complete.)
     */

    userBet(int id, double amountBet, int teamBet, int complete){
        this.id = id;
        this.amountBet = amountBet;
        this.teamBet = teamBet;
        this.complete = complete;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAmountBet(double amountBet) {
        this.amountBet = amountBet;
    }

    public double getAmountBet() {
        return amountBet;
    }

    public void setTeamBet(int teamBet) {
        this.teamBet = teamBet;
    }

    public int getTeamBet() {
        return teamBet;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public int getComplete() {
        return complete;
    }
}
