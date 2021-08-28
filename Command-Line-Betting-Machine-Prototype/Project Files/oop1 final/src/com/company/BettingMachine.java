package com.company;

import java.util.Scanner;

/**
 * <h1>Betting Machine</h1>
 * <p>This is the class that runs the whole system from first preloading the games and accounts to letting
 * the admin and user profiles interact.</p>
 *
 * <p>Created: 8/28/2021</p>
 *
 * @author Kellen Nankervis
 */
public class BettingMachine {

    /**
     * Name: main
     * This Method is used to start the program.
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //preload bets
        Bet[] completedBets = new Bet[3];
        completedBets = preloadBetsCB();
        Bet[] ongoingBets = new Bet[0];
        Bet[] upcomingBets = new Bet[2];
        upcomingBets = preloadBetsUB();

        //Create Account's info
        Account userAccount = new Account(5000.00);
        userBet[] userBets = new userBet[0];

        //Ask which user is signing in
        login(input,completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

/**
 * Name: preloadBetsCB
 * This Method is used to preload the completed bets.
 */

    public static Bet[] preloadBetsCB(){
        Bet[] completedBets = new Bet[3];
        completedBets[0] = new Bet(1,"Warriors Win The Finals With a 3-1 Lead", "6-11-2016","6-20-2016",
                "Golden State Warriors", "Cleveland Cavaliers",1.03,10.50,
                "Cleveland Cavaliers",2,5.0,1000.0);
        completedBets[1] = new Bet(2,"Raptors VS Warriors 2019 NBA Finals","5-30-2019","6-19-2019"
        ,"Toronto Raptors", "Golden State Warriors",2.30,1.66,
                "Toronto Raptors",1,5.0,20000.0);
        completedBets[2] = new Bet(3,"Suns VS Bucks 2021 NBA Finals","7-6-2021","7-23-2021","" +
                "Phoenix Suns","Milwaukee Bucks",2.02,1.91,
                "Milwaukee Bucks",2,5.0,25000.0);
        return completedBets;
    }

    /**
     * Name: preloadBetsUB
     * This Method is used to preload the upcoming bets.
     */

    public static Bet[] preloadBetsUB(){
        Bet[] upcomingBets = new Bet[2];
        upcomingBets[1] = new Bet(5,"Nets vs Lakers", "12-24-2021", "12-25-2021","Brooklyn" +
                " Nets","Los Angeles Lakers",1.95,1.95,
                "n/a",0,10.0,2500);
        upcomingBets[0] = new Bet(4,"Nets vs Bucks","10-18-2021","10-19-2021","Brooklyn" +
                " Nets", "Milwaukee Bucks", 1.9,2.05,
                "n/a",0,15.0,6000);
        return upcomingBets;
    }

    /**
     * Name: login
     * This Method is used to log in as a user or admin.
     * @param input (Scanner; used to let the user make inputs)
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void login(Scanner input, Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        System.out.println("Login:\nUser: 1\nAdmin: 2");
        try{
            int userInput = input.nextInt();
            if(userInput != 1 && userInput != 2){
                System.out.println("Sorry, the input you entered does not " +
                        "correspond to any of the current options. Please try again.");
                loginRetry(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 1){
                userMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 2){
                adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
        }catch(Exception a){
            System.out.println("The type of value you entered does not match what was expected." +
                    " Please try again.");

            loginRetry(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: loginRetry
     * This Method is used to retry the log in as a user or admin.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void loginRetry(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        login(input,completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

    /**
     * Name: userMenu
     * This Method is used to move the user to certain subsets of the program.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void userMenu(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        System.out.println("Which bets would you like to view?" +
                "\nCompleted Bets: 1\nOngoing Bets: 2\nUpcoming Bets: 3\nAccount options: 4" +
                "\nLogout: 5");
        try{
            int userInput = input.nextInt();
            if(userInput != 1 && userInput != 2 && userInput != 3 && userInput != 4 && userInput != 5){
                System.out.println("Sorry, the input you entered does not " +
                        "correspond to any of the current options. Please try again.");
                userMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 1){
                userPrintCB(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 2){
                userPrintOB(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 3){
                userPrintUB(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 4){
                userAccountMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 5){
                loginRetry(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
        }catch(Exception b){
            System.out.println("The type of value you entered does not match what was expected." +
                    " Please try again.");
            userMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: userPrintCB
     * This Method is used to print the completed bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void userPrintCB(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        if(completedBets.length >= 1){
            System.out.println("\nHere is the list of completed bets:");
            for(int i = 0; i < completedBets.length; i++){
                System.out.println(completedBets[i].toStringOne());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no completed bets to view\n");
        }
        postCBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

    /**
     * Name: postCBMenu
     * This Method is used to give the user options of what to do.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void postCBMenu(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to do now?\nLogout: 1\nGo back to the Main Menu: 2" +
                "\nReprint Completed Bets: 3");
        try{
            int userInput = input.nextInt();
            if(userInput != 1 && userInput != 2 && userInput != 3){
                System.out.println("Sorry, the input you entered does not " +
                        "correspond to any of the current options. Please try again.");
                postCBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 1){
                loginRetry(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 2){
                userMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 3){
                userPrintCB(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
        }catch(Exception b){
            System.out.println("The type of value you entered does not match what was expected." +
                    " Please try again.");
            postCBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: userPrintOB
     * This Method is used to print the ongoing bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void userPrintOB(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        if(ongoingBets.length >= 1){
            System.out.println("\nHere is the list of ongoing bets:");
            for(int i = 0; i < ongoingBets.length; i++){
                System.out.println(ongoingBets[i].toStringOne());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no ongoing bets to view\n");
        }
        postOBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

    /**
     * Name: postOBMenu
     * This Method is used to give the user options of what to do.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void postOBMenu(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to do now?\nLogout: 1\nGo back to the Main Menu: 2" +
                "\nReprint Ongoing Bets: 3");
        try{
            int userInput = input.nextInt();
            if(userInput != 1 && userInput != 2 && userInput != 3){
                System.out.println("Sorry, the input you entered does not " +
                        "correspond to any of the current options. Please try again.");
                postOBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 1){
                loginRetry(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 2){
                userMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 3){
                userPrintOB(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
        }catch(Exception b){
            System.out.println("The type of value you entered does not match what was expected." +
                    " Please try again.");
            postOBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: userPrintUB
     * This Method is used to print the upcoming bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void userPrintUB(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        if(upcomingBets.length >= 1){
            System.out.println("\nHere is the list of upcoming bets:");
            for(int i = 0; i < upcomingBets.length; i++){
                System.out.println(upcomingBets[i].toStringTwo());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no upcoming bets to view\n");
        }
        postUBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

    /**
     * Name: postUBMenu
     * This Method is used to give the user options of what to do.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void postUBMenu(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to do now?\nLogout: 1\nGo back to the Main Menu: 2" +
                "\nReprint Upcoming Bets: 3\nPlace a Bet: 4\nSimulate a game: 5");
        try{
            int userInput = input.nextInt();
            if(userInput != 1 && userInput != 2 && userInput != 3 && userInput != 4 && userInput != 5){
                System.out.println("Sorry, the input you entered does not " +
                        "correspond to any of the current options. Please try again.");
                postUBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 1){
                loginRetry(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 2){
                userMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 3){
                userPrintUB(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 4){
                userBetMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 5){
                userSimMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
        }catch(Exception b){
            System.out.println("The type of value you entered does not match what was expected." +
                    " Please try again.");
            postUBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: userBetMenu
     * This Method is used to allow the user to place bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void userBetMenu(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        if(upcomingBets.length >= 1){
            System.out.println("\nHere is the list of upcoming bets:");
            for(int i = 0; i < upcomingBets.length; i++){
                System.out.println(upcomingBets[i].toStringTwo());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no upcoming bets to view\n");
        }
        System.out.println("Please enter the id of the bet you would like to play on or enter 0 to exit.");
        try{
            int userInput = input.nextInt();
            if(userInput == 0){
                System.out.println("You have exited back to the previous menu.");
                postUBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput != 0){
                try{
                    for(int i2 = 0; i2 < userBets.length; i2++){
                        if(userBets[i2].getId() == userInput){
                            System.out.println("You have already bet on this game. You will be " +
                                    "redirected to the beginning of this menu.");
                            userBetMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                        }
                    }
                    for(int i = 0; i < upcomingBets.length; i++){
                        int betID = 0;
                        if(userInput == upcomingBets[i].getID()){
                            betID = i;
                            System.out.println("What amount would you like to bet?\nMinimum amount to bet: "
                                    + upcomingBets[betID].getMinBet() + "\nMaximum amount to bet: " +
                                    upcomingBets[betID].getMaxBet());
                            try{
                                double userInputDouble = input.nextDouble();
                                if(userInputDouble > userAccount.getBalance()){
                                    System.out.println("You are trying to bet more than you currently have in your account." +
                                            " You will be redirected to the beginning of this menu.");
                                    userBetMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                }
                                if((userInputDouble >= upcomingBets[betID].getMinBet()
                                        && userInputDouble <= upcomingBets[betID].getMaxBet())){
                                    double betAmount = userInputDouble;
                                    System.out.println("What team would you like to bet on?\n" + upcomingBets[betID].getTeamOne()
                                            + ": 1\n" + upcomingBets[betID].getTeamTwo() + ": 2\n");
                                    try{
                                        int userTeamInput = input1.nextInt();
                                        if(userTeamInput != 1 && userTeamInput != 2){
                                            System.out.println("The number you have entered is invalid, you will be" +
                                                    " redirected to the beginning of this menu.");
                                            userBetMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                        }else{
                                            int a = userBets.length;
                                            userBet[] tempUserBets = new userBet[a+1];
                                            tempUserBets[a] = new userBet(userInput,betAmount,userTeamInput,0);
                                            for(int i1 = 0; i1 < userBets.length;i1++){
                                                tempUserBets[i] = new userBet(userBets[i1].getId(),userBets[i1].getAmountBet(),
                                                        userBets[i1].getTeamBet(),userBets[i1].getComplete());
                                            }
                                            userBets = tempUserBets;
                                            userAccount.withdraw(betAmount);
                                            if(userTeamInput == 1){
                                                System.out.println("\nCongratulations you have placed a bet on " + upcomingBets[betID].getName() + " " +
                                                        "if you win you will receive " + (upcomingBets[betID].getOddOne() * betAmount) + ". " +
                                                        "Good Luck!");
                                                userMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                            }
                                            if(userTeamInput == 2){
                                                System.out.println("\nCongratulations you have placed a bet on " + upcomingBets[betID].getName() + " " +
                                                        "if you win you will receive " + (upcomingBets[betID].getOddTwo() * betAmount) + ". " +
                                                        "Good Luck!\nYou have been redirected to the main menu.");
                                                userMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                            }
                                        }
                                    }catch(Exception a){
                                        System.out.println("The type of value you entered does not match what was expected. You " +
                                                "will be redirected to the beginning of this menu.");
                                        userBetMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                    }
                                }else{
                                    System.out.println("Sorry, the input you entered is outside " +
                                            "of the betting amount range. You will be redirected " +
                                            "to the beginning of this menu.");
                                    userBetMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                }
                            }catch(Exception a){
                                System.out.println("The type of value you entered does not match what was expected. You " +
                                        "will be redirected to the beginning of this menu.");
                                userBetMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                            }
                        }
                    }
                    System.out.println("The value you entered does not correspond with any active ID. " +
                            "You will be redirected to the beginning of this menu.");
                    userBetMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                }catch(Exception a){
                    System.out.println("The type of value you entered does not match what was expected. You " +
                            "will be redirected to the beginning of this menu.");
                    userBetMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                }
            }
        }catch(Exception a){
            System.out.println("The type of value you entered does not match what was expected. You " +
                    "will be redirected to the beginning of this menu.");
            userBetMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: userSimMenu
     * This Method is used to allow the user to sim bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void userSimMenu(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        if(upcomingBets.length >= 1){
            System.out.println("\nHere is the list of upcoming bets:");
            for(int i = 0; i < upcomingBets.length; i++){
                System.out.println(upcomingBets[i].toStringTwo());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no upcoming bets to view\n");
        }
        System.out.println("Please enter the id of the bet you would like to simulate or enter 0 to exit.");
        try {
            int userInput = input.nextInt();
            if(userInput == 0){
                System.out.println("You have exited back to the previous menu.");
                userPrintUB(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput != 0) {
                try {
                    for (int i = 0; i < upcomingBets.length; i++) {
                        int betID = 0;
                        if (userInput == upcomingBets[i].getID()) {
                            betID = i;
                            System.out.println("Would you like to simulate with implied odds or your own?" +
                                    "\nImplied odds: 1\nMy own odds: 2");
                            try{
                                userInput = input1.nextInt();
                                if(userInput == 1){
                                    double odd1 = (1/(upcomingBets[betID].getOddOne()));
                                    double odd2 = (1/(upcomingBets[betID].getOddTwo()));
                                    double sum = (odd1 + odd2);
                                    odd1 = (odd1/sum);
                                    userSim(completedBets,ongoingBets,upcomingBets,userAccount,userBets,odd1,betID);
                                }
                                if(userInput == 2){
                                    System.out.println("What do you want the probability to be for " +
                                            upcomingBets[betID].getTeamOne() + "?");
                                    try{
                                        double odd1 = input2.nextDouble();
                                        System.out.println("What do you want the probability to be for " +
                                                upcomingBets[betID].getTeamTwo() + "?");
                                        try{
                                            double odd2 = input3.nextDouble();
                                            double sum = odd1 + odd2;
                                            if(odd1 < 0 || odd2 < 0 || sum <= 0){
                                                System.out.println("You have entered the odds incorrectly. " +
                                                        "You will be redirected to the previous menu.");
                                                userPrintUB(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                            }
                                            else{
                                                odd1 = (odd1/sum);
                                                userSim(completedBets,ongoingBets,upcomingBets,userAccount,userBets,odd1,betID);
                                            }
                                        }catch(Exception a){
                                            System.out.println("The type of value you entered does not match what was expected. " +
                                                    "You will be redirected to the previous menu.");
                                            userPrintUB(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                        }
                                    }catch(Exception a) {
                                        System.out.println("The type of value you entered does not match what was expected. " +
                                                "You will be redirected to the previous menu.");
                                        userPrintUB(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
                                    }
                                }
                                if(userInput != 1 && userInput != 2){
                                    System.out.println("Sorry, the input you entered does not correspond to any of the current " +
                                            "options. " +
                                            "You will be redirected to the previous menu.");
                                    userPrintUB(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                }
                            }catch(Exception a) {
                                System.out.println("The type of value you entered does not match what was expected. " +
                                        "You will be redirected to the previous menu.");
                                userPrintUB(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
                            }
                        }
                    }
                    System.out.println("The type of value you entered does not match what was expected. " +
                            "You will be redirected to the previous menu.");
                    userPrintUB(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
                }catch(Exception a) {
                    System.out.println("The type of value you entered does not match what was expected. " +
                            "You will be redirected to the previous menu.");
                    userPrintUB(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
                }
            }
        }catch(Exception a) {
            System.out.println("The type of value you entered does not match what was expected. " +
                    "You will be redirected to the previous menu.");
            userPrintUB(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
        }
    }

    /**
     * Name: userSim
     * This Method is used to sim the bet the user wants.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     * @param betID (int; The place of the bet the user is accessing in the array.)
     * @param odd1 (double; The odds the first team wins)
     */

    public static void userSim(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets,double odd1,int betID){
        Scanner input = new Scanner(System.in);
        if(Math.random()>odd1){
            System.out.println(upcomingBets[betID].getTeamTwo() + " Won!");
        }else{
            System.out.println(upcomingBets[betID].getTeamOne() + " Won!");
        }
        System.out.println("Would you like to\n" +
                "Simulate again: 1\n" +
                "Exit: 2");
        try{
            int userInput = input.nextInt();
            if(userInput != 1 && userInput != 2){
                System.out.println("Sorry, the input you entered does not " +
                        "correspond to any of the current options. You will be exited to the main menu.");
                userMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 1){
                userSim(completedBets,ongoingBets,upcomingBets,userAccount,userBets,odd1,betID);
            }
            if(userInput == 2){
                userPrintUB(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
        }catch(Exception a) {
            System.out.println("The type of value you entered does not match what was expected. You " +
                    "will be redirected to the main menu.");
            userMenu(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
        }
    }

    /**
     * Name: userAccountMenu
     * This Method is used to give the user options on what to do next.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void userAccountMenu(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Account Menu, here you can:\n" +
                "Check Balance: 1\nWithdraw Funds: 2\nDeposit Funds: 3\nExit to Main Menu: 4");
        try{
            int userInput = input.nextInt();
            if(userInput != 1 && userInput != 2 && userInput != 3 && userInput != 4){
                System.out.println("Sorry, the input you entered does not " +
                        "correspond to any of the current options. Please try again.");
                userAccountMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 1){
                double sum = 0;
                for(int i = 0; i < userBets.length; i++){
                    sum = sum + userBets[i].getAmountBet();
                }
                System.out.println("Your current balance is " + userAccount.getBalance() + " and you have "
                + sum + " in bets currently");
                userAccountMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(userInput == 2){
                userWithdraw(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
            if(userInput == 3){
                userDeposit(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
            if(userInput == 4){
                userMenu(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
        }catch(Exception a) {
            System.out.println("The type of value you entered does not match what was expected. Please try again.");
            userAccountMenu(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
        }
    }

    /**
     * Name: userWithdraw
     * This Method is used to let the user withdraw funds.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void userWithdraw(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        System.out.println("How much would you like to withdraw? Enter 0 to exit:");
        try{
            double userInput = input.nextDouble();
            if(userInput == 0){
                userMenu(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
            if(userInput <= userAccount.getBalance() || userInput >= 0){
                userAccount.withdraw(userInput);
                System.out.println("Congratulations you have withdrawn " + userInput + ". You will now be taken to" +
                        " the account menu.");
                userAccountMenu(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }else{
                System.out.println("You can't withdraw more than you have in your account" +
                        " or deposit money here. Please try again.");
                userWithdraw(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
        }catch(Exception a) {
            System.out.println("The type of value you entered does not match what was expected. Please try again.");
            userMenu(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
        }
    }

    /**
     * Name: userDeposit
     * This Method is used to let the user deposit funds.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void userDeposit(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        System.out.println("How much would you like to deposit? Enter 0 to exit:");
        try {
            double userInput = input.nextDouble();
            if (userInput == 0) {
                userMenu(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
            if (userInput >= 0) {
                userAccount.deposit(userInput);
                System.out.println("Congratulations you have now deposited " + userInput + " into your account." +
                        " You will now be taken to the account menu.");
                userAccountMenu(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            } else {
                System.out.println("You can not deposit money here. Please try again");
                userDeposit(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
        } catch(Exception a) {
            System.out.println("The type of value you entered does not match what was expected. Please try again.");
            userMenu(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
        }
    }

    /**
     * Name: adminMenu
     * This Method is used to let the admin move around their systems.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminMenu(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        System.out.println("Which bets would you like to view?" +
                "\nCompleted Bets: 1\nOngoing Bets: 2\nUpcoming Bets: 3\nAdd Bet: 4\nLogout: 5");
        try {
            int userInput = input.nextInt();
            if (userInput != 1 && userInput != 2 && userInput != 3 && userInput != 4 && userInput != 5) {
                System.out.println("Sorry, the input you entered does not " +
                        "correspond to any of the current options. Please try again.");
                adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if (userInput == 1) {
                adminPrintCB(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
            if (userInput == 2) {
                adminPrintOB(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
            if (userInput == 3) {
                adminPrintUB(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
            if (userInput == 4) {
                adminAddBet(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
            if(userInput == 5){
                logAdminUserBetTest(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
        }catch (Exception a){
            adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: adminPrintCB
     * This Method is used Print the completed bets for the admin.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminPrintCB(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        if(completedBets.length >= 1){
            System.out.println("\nHere is the list of completed bets:");
            for(int i = 0; i < completedBets.length; i++){
                System.out.println(completedBets[i].toStringThree());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no completed bets to view\n");
        }
        adminCBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

    /**
     * Name: adminCBMenu
     * This Method is used to let the admin move around their systems.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminCBMenu(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        System.out.println("Here you can:\nEdit a bet: 1\nDelete a bet: 2\nGo back to the admin Menu: 3\n" +
                "Logout: 4");
        try{
            int adminInput = input.nextInt();
            if(adminInput != 1 && adminInput != 2 && adminInput != 3 && adminInput != 4){
                System.out.println("The input you entered does not correspond with any of the available " +
                        "options please try again");
                adminCBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput == 1){
                adminCBEdit(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput == 2){
                adminCBDelete(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput == 3){
                adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput == 4){
                logAdminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
        }catch (Exception a){
            adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: adminCBEdit
     * This Method is used to let the admin edit completed bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminCBEdit(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets,
                                   Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        if(completedBets.length >= 1){
            System.out.println("\nHere is the list of completed bets:");
            for(int i = 0; i < completedBets.length; i++){
                System.out.println(completedBets[i].toStringThree());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no completed bets to view\n");
        }
        System.out.println("Enter the ID of the game you would like to edit or 0 to exit:");
        try {
            int adminInput = input.nextInt();
            if(adminInput == 0){
                System.out.println("You have exited back to the admin menu.");
                adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput != 0) {
                try {
                    for (int i = 0; i < completedBets.length; i++) {
                        int betID = 0;
                        if (adminInput == completedBets[i].getID()) {
                            betID = i;
                            System.out.println("What would you like to edit:\n" +
                                    "Name: 1\nDate Start: 2\nDate End: 3\nTeam One: 4\nTeam Two: 5\nOdd One: 6\n" +
                                    "Odd Two: 7\nWinning Team: 8\nWinning Num: 9\nMin Bet: 10\nMax Bet: 11" +
                                    "\nExit: 12");
                            try{
                                int adminInput1 = input1.nextInt();
                                if(adminInput1<1 || adminInput1>13){
                                    System.out.println("The number you entered does not correspond with any of the options." +
                                            " Please try again.");
                                    adminCBEdit(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                }
                                if(adminInput1 == 1){
                                    System.out.println("Enter the new Name:");
                                    String adminInput2 = input2.nextLine();
                                    completedBets[betID].setName(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 2){
                                    System.out.println("Enter the new Date Start:");
                                    String adminInput2 = input2.nextLine();
                                    completedBets[betID].setDateStart(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 3){
                                    System.out.println("Enter the new Date End:");
                                    String adminInput2 = input2.nextLine();
                                    completedBets[betID].setDateEnd(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 4){
                                    System.out.println("Enter the new Team One:");
                                    String adminInput2 = input2.nextLine();
                                    completedBets[betID].setTeamOne(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 5){
                                    System.out.println("Enter the new Team Two:");
                                    String adminInput2 = input2.nextLine();
                                    completedBets[betID].setTeamTwo(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 6){
                                    System.out.println("Enter the new Odd One:");
                                    double adminInput2 = input2.nextDouble();
                                    completedBets[betID].setOddOne(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 7){
                                    System.out.println("Enter the new Odd Two:");
                                    double adminInput2 = input2.nextDouble();
                                    completedBets[betID].setOddTwo(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 8){
                                    System.out.println("Enter the new Winning Team:");
                                    String adminInput2 = input2.nextLine();
                                    completedBets[betID].setWinningTeam(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 9){
                                    System.out.println("Enter the new Winning Num:");
                                    int adminInput2 = input2.nextInt();
                                    completedBets[betID].setWinningNum(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 10){
                                    System.out.println("Enter the new Min Bet:");
                                    double adminInput2 = input2.nextDouble();
                                    completedBets[betID].setMinBet(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 11){
                                    System.out.println("Enter the new Max Bet:");
                                    double adminInput2 = input2.nextDouble();
                                    completedBets[betID].setMaxBet(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 12){
                                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                }
                            }catch(Exception a){
                                adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                            }
                        }
                    }
                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                }catch(Exception a) {
                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                }
            }adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }catch(Exception a) {
            adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: adminCBDelete
     * This Method is used to let the admin Delete completed bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminCBDelete(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets,
                                   Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        if(completedBets.length >= 1){
            System.out.println("\nHere is the list of completed bets:");
            for(int i = 0; i < completedBets.length; i++){
                System.out.println(completedBets[i].toStringThree());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no completed bets to view\n");
        }
        System.out.println("Enter the ID of the game you would like to Delete or 0 to exit:");
        try {
            int adminInput = input.nextInt();
            if (adminInput == 0) {
                System.out.println("You have exited back to the previous menu.");
                adminPrintCB(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
            if (adminInput != 0) {
                try {
                    for (int i = 0; i < completedBets.length; i++) {
                        int betID = 0;
                        if (adminInput == completedBets[i].getID()) {
                            betID = i;
                            int a = completedBets.length - 1;
                            Bet[] tempCompletedBets = new Bet[a];
                            int b = 0;
                            for(int i1 = 0; i1 < completedBets.length; i1++){
                                if(betID != i1){
                                    tempCompletedBets[b] = completedBets[i1];
                                    b++;
                                }
                            }
                            completedBets = tempCompletedBets;
                            System.out.println("Success!");
                        }
                    }
                }catch(Exception a){
                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                }
            }
        }catch(Exception a){
            adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
        adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

    /**
     * Name: adminUserBetTest
     * This Method is used to check if the bets the user have placed have concluded.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminUserBetTest(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets,
                                     Account userAccount, userBet[] userBets){
        for(int i = 0; i < userBets.length; i++){
            for(int i1 = 0; i1 < completedBets.length; i1++){
                if(userBets[i].getId() == completedBets[i1].getID()){
                    if(completedBets[i1].getWinningNum() != 0){
                        if(completedBets[i1].getWinningNum() == userBets[i].getTeamBet()){
                            if(userBets[i].getTeamBet() == 1){
                                double a = userBets[i].getAmountBet() * completedBets[i1].getOddOne();
                                userAccount.deposit(a);
                                userBets[i].setComplete(1);
                            }
                            if(userBets[i].getTeamBet() == 2){
                                double a = userBets[i].getAmountBet() * completedBets[i1].getOddTwo();
                                userAccount.deposit(a);
                                userBets[i].setComplete(1);
                            }
                        }
                        if(completedBets[i1].getWinningNum() != userBets[i].getTeamBet()){
                            userBets[i].setComplete(1);
                        }
                    }
                }
            }
            for(int i1 = 0; i1 < ongoingBets.length; i1++){
                if(userBets[i].getId() == ongoingBets[i1].getID()){
                    if(ongoingBets[i1].getWinningNum() != 0){
                        if(ongoingBets[i1].getWinningNum() == userBets[i].getTeamBet()){
                            if(userBets[i].getTeamBet() == 1){
                                double a = userBets[i].getAmountBet() * ongoingBets[i1].getOddOne();
                                userAccount.deposit(a);
                                userBets[i].setComplete(1);
                            }
                            if(userBets[i].getTeamBet() == 2){
                                double a = userBets[i].getAmountBet() * ongoingBets[i1].getOddTwo();
                                userAccount.deposit(a);
                                userBets[i].setComplete(1);
                            }
                        }
                        if(ongoingBets[i1].getWinningNum() != userBets[i].getTeamBet()){
                            userBets[i].setComplete(1);
                        }
                    }
                }
            }
            for(int i1 = 0; i1 < upcomingBets.length; i1++){
                if(userBets[i].getId() == upcomingBets[i1].getID()){
                    if(upcomingBets[i1].getWinningNum() != 0){
                        if(upcomingBets[i1].getWinningNum() == userBets[i].getTeamBet()){
                            if(userBets[i].getTeamBet() == 1){
                                double a = userBets[i].getAmountBet() * upcomingBets[i1].getOddOne();
                                userAccount.deposit(a);
                                userBets[i].setComplete(1);
                            }
                            if(userBets[i].getTeamBet() == 2){
                                double a = userBets[i].getAmountBet() * upcomingBets[i1].getOddTwo();
                                userAccount.deposit(a);
                                userBets[i].setComplete(1);
                            }
                        }
                        if(upcomingBets[i1].getWinningNum() != userBets[i].getTeamBet()){
                            userBets[i].setComplete(1);
                        }
                    }
                }
            }
        }
        deleteOldUserBets(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
    }

    /**
     * Name: deleteOldUserBets
     * This Method is used to delete old user bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void deleteOldUserBets(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets,
                                        Account userAccount, userBet[] userBets){
        for(int i = 0; i < userBets.length; i++){
            int betID = 0;
            if(userBets[i].getComplete() == 1){
                betID = i;
                int a = userBets.length - 1;
                userBet[] tempUserBets = new userBet[a];
                int b = 0;
                for(int i1 = 0; i1 < userBets.length; i1++){
                    if(betID != i1){
                        tempUserBets[b] = userBets[i1];
                        b++;
                    }
                }
                userBets = tempUserBets;
            }
        }
        adminMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

    /**
     * Name: logAdminUserBetTest
     * This Method is used to check if games the user have bet on have completed and logout.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void logAdminUserBetTest(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets,
                                        Account userAccount, userBet[] userBets){
        for(int i = 0; i < userBets.length; i++){
            for(int i1 = 0; i1 < completedBets.length; i1++){
                if(userBets[i].getId() == completedBets[i1].getID()){
                    if(completedBets[i1].getWinningNum() != 0){
                        if(completedBets[i1].getWinningNum() == userBets[i].getTeamBet()){
                            if(userBets[i].getTeamBet() == 1){
                                double a = userBets[i].getAmountBet() * completedBets[i1].getOddOne();
                                userAccount.deposit(a);
                                userBets[i].setComplete(1);
                            }
                            if(userBets[i].getTeamBet() == 2){
                                double a = userBets[i].getAmountBet() * completedBets[i1].getOddTwo();
                                userAccount.deposit(a);
                                userBets[i].setComplete(1);
                            }
                        }
                    }
                }
            }
            for(int i1 = 0; i1 < ongoingBets.length; i1++){
                if(userBets[i].getId() == ongoingBets[i1].getID()){
                    if(ongoingBets[i1].getWinningNum() != 0){
                        if(ongoingBets[i1].getWinningNum() == userBets[i].getTeamBet()){
                            if(userBets[i].getTeamBet() == 1){
                                double a = userBets[i].getAmountBet() * ongoingBets[i1].getOddOne();
                                userAccount.deposit(a);
                                userBets[i].setComplete(1);
                            }
                            if(userBets[i].getTeamBet() == 2){
                                double a = userBets[i].getAmountBet() * ongoingBets[i1].getOddTwo();
                                userAccount.deposit(a);
                                userBets[i].setComplete(1);
                            }
                        }
                    }
                }
            }
            for(int i1 = 0; i1 < upcomingBets.length; i1++){
                if(userBets[i].getId() == upcomingBets[i1].getID()){
                    if(upcomingBets[i1].getWinningNum() != 0){
                        if(upcomingBets[i1].getWinningNum() == userBets[i].getTeamBet()){
                            if(userBets[i].getTeamBet() == 1){
                                double a = userBets[i].getAmountBet() * upcomingBets[i1].getOddOne();
                                userAccount.deposit(a);
                                userBets[i].setComplete(1);
                            }
                            if(userBets[i].getTeamBet() == 2){
                                double a = userBets[i].getAmountBet() * upcomingBets[i1].getOddTwo();
                                userAccount.deposit(a);
                                userBets[i].setComplete(1);
                            }
                        }
                    }
                }
            }
        }
        logDeleteOldUserBets(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
    }

    /**
     * Name: logDeleteOldUserBets
     * This Method is used to delete old user bets and logout.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void logDeleteOldUserBets(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets,
                                         Account userAccount, userBet[] userBets){
        for(int i = 0; i < userBets.length; i++){
            int betID = 0;
            if(userBets[i].getComplete() == 1){
                betID = i;
                int a = userBets.length - 1;
                userBet[] tempUserBets = new userBet[a];
                int b = 0;
                for(int i1 = 0; i1 < userBets.length; i1++){
                    if(betID != i1){
                        tempUserBets[b] = userBets[i1];
                        b++;
                    }
                }
                userBets = tempUserBets;
            }
        }
        loginRetry(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

    /**
     * Name: adminPrintOB
     * This Method is used to print ongoing bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminPrintOB(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        if(ongoingBets.length >= 1){
            System.out.println("\nHere is the list of ongoing bets:");
            for(int i = 0; i < ongoingBets.length; i++){
                System.out.println(ongoingBets[i].toStringThree());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no ongoing bets to view\n");
        }
        adminOBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

    /**
     * Name: adminOBMenu
     * This Method is used to let the admin move around their systems.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminOBMenu(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        System.out.println("Here you can:\nEdit a bet: 1\nMove a bet: 2\nGo back to the admin Menu: 3\n" +
                "Logout: 4");
        try{
            int adminInput = input.nextInt();
            if(adminInput != 1 && adminInput != 2 && adminInput != 3 && adminInput != 4){
                System.out.println("The input you entered does not correspond with any of the available " +
                        "options please try again");
                adminOBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput == 1){
                adminOBEdit(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput == 2){
                adminOBMove(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput == 3){
                adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput == 4){
                logAdminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
        }catch (Exception a){
            adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: adminOBEdit
     * This Method is used to let the admin edit ongoing bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminOBEdit(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets,
                                   Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        if(ongoingBets.length >= 1){
            System.out.println("\nHere is the list of ongoing bets:");
            for(int i = 0; i < ongoingBets.length; i++){
                System.out.println(ongoingBets[i].toStringThree());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no ongoing bets to view\n");
        }
        System.out.println("Enter the ID of the game you would like to edit or 0 to exit:");
        try {
            int adminInput = input.nextInt();
            if(adminInput == 0){
                System.out.println("You have exited back to the admin menu.");
                adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput != 0) {
                try {
                    for (int i = 0; i < ongoingBets.length; i++) {
                        int betID = 0;
                        if (adminInput == ongoingBets[i].getID()) {
                            betID = i;
                            System.out.println("What would you like to edit:\n" +
                                    "Name: 1\nDate Start: 2\nDate End: 3\nTeam One: 4\nTeam Two: 5\nOdd One: 6\n" +
                                    "Odd Two: 7\nWinning Team: 8\nWinning Num: 9\nMin Bet: 10\nMax Bet: 11" +
                                    "\nExit: 12");
                            try{
                                int adminInput1 = input1.nextInt();
                                if(adminInput1<1 || adminInput1>13){
                                    System.out.println("The number you entered does not correspond with any of the options." +
                                            " Please try again.");
                                    adminOBEdit(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                }
                                if(adminInput1 == 1){
                                    System.out.println("Enter the new Name:");
                                    String adminInput2 = input2.nextLine();
                                    ongoingBets[betID].setName(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 2){
                                    System.out.println("Enter the new Date Start:");
                                    String adminInput2 = input2.nextLine();
                                    ongoingBets[betID].setDateStart(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 3){
                                    System.out.println("Enter the new Date End:");
                                    String adminInput2 = input2.nextLine();
                                    ongoingBets[betID].setDateEnd(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 4){
                                    System.out.println("Enter the new Team One:");
                                    String adminInput2 = input2.nextLine();
                                    ongoingBets[betID].setTeamOne(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 5){
                                    System.out.println("Enter the new Team Two:");
                                    String adminInput2 = input2.nextLine();
                                    ongoingBets[betID].setTeamTwo(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 6){
                                    System.out.println("Enter the new Odd One:");
                                    double adminInput2 = input2.nextDouble();
                                    ongoingBets[betID].setOddOne(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 7){
                                    System.out.println("Enter the new Odd Two:");
                                    double adminInput2 = input2.nextDouble();
                                    ongoingBets[betID].setOddTwo(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 8){
                                    System.out.println("Enter the new Winning Team:");
                                    String adminInput2 = input2.nextLine();
                                    ongoingBets[betID].setWinningTeam(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 9){
                                    System.out.println("Enter the new Winning Num:");
                                    int adminInput2 = input2.nextInt();
                                    ongoingBets[betID].setWinningNum(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 10){
                                    System.out.println("Enter the new Min Bet:");
                                    double adminInput2 = input2.nextDouble();
                                    ongoingBets[betID].setMinBet(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 11){
                                    System.out.println("Enter the new Max Bet:");
                                    double adminInput2 = input2.nextDouble();
                                    ongoingBets[betID].setMaxBet(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 12){
                                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                }
                            }catch(Exception a){
                                adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                            }
                        }
                    }
                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                }catch(Exception a) {
                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                }
            }adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }catch(Exception a) {
            adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: adminOBMove
     * This Method is used to move ongoing bets to completed bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminOBMove(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets,
                                     Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        if(ongoingBets.length >= 1){
            System.out.println("\nHere is the list of ongoing bets:");
            for(int i = 0; i < ongoingBets.length; i++){
                System.out.println(ongoingBets[i].toStringThree());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no ongoing bets to view\n");
        }
        System.out.println("Enter the ID of the game you would like to Move or 0 to exit:");
        try {
            int adminInput = input.nextInt();
            if (adminInput == 0) {
                System.out.println("You have exited back to the previous menu.");
                adminPrintOB(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
            if (adminInput != 0) {
                try {
                    for (int i = 0; i < ongoingBets.length; i++) {
                        int betID = 0;
                        if (adminInput == ongoingBets[i].getID()) {
                            betID = i;
                            int a = ongoingBets.length - 1;
                            Bet[] tempOngoingBets = new Bet[a];
                            int b = 0;
                            for(int i1 = 0; i1 < ongoingBets.length; i1++){
                                if(betID != i1){
                                    tempOngoingBets[b] = ongoingBets[i1];
                                    b++;
                                }
                            }
                            int c = completedBets.length + 1;
                            int d = completedBets.length;
                            Bet[] tempCompletedBets = new Bet[c];
                            tempCompletedBets[d] = ongoingBets[betID];
                            for(int i1 = 0; i1 < completedBets.length; i1++){
                                tempCompletedBets[i1] = completedBets[i1];
                            }
                            completedBets = tempCompletedBets;
                            ongoingBets = tempOngoingBets;
                            System.out.println("Success!");
                        }
                    }
                }catch(Exception a){
                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                }
            }
        }catch(Exception a){
            adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
        adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

    /**
     * Name: adminPrintUB
     * This Method is used to print upcoming bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminPrintUB(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        if(upcomingBets.length >= 1){
            System.out.println("\nHere is the list of upcoming bets:");
            for(int i = 0; i < upcomingBets.length; i++){
                System.out.println(upcomingBets[i].toStringThree());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no upcoming bets to view\n");
        }
        adminUBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

    /**
     * Name: adminUBMenu
     * This Method is used to let the admin move around their systems.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminUBMenu(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets, Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        System.out.println("Here you can:\nEdit a bet: 1\nMove a bet: 2\nGo back to the admin Menu: 3\n" +
                "Logout: 4");
        try{
            int adminInput = input.nextInt();
            if(adminInput != 1 && adminInput != 2 && adminInput != 3 && adminInput != 4){
                System.out.println("The input you entered does not correspond with any of the available " +
                        "options please try again");
                adminUBMenu(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput == 1){
                adminUBEdit(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput == 2){
                adminUBMove(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput == 3){
                adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput == 4){
                logAdminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
        }catch (Exception a){
            adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: adminUBEdit
     * This Method is used to edit upcoming bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminUBEdit(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets,
                                   Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        if(upcomingBets.length >= 1){
            System.out.println("\nHere is the list of upcoming bets:");
            for(int i = 0; i < upcomingBets.length; i++){
                System.out.println(upcomingBets[i].toStringThree());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no upcoming bets to view\n");
        }
        System.out.println("Enter the ID of the game you would like to edit or 0 to exit:");
        try {
            int adminInput = input.nextInt();
            if(adminInput == 0){
                System.out.println("You have exited back to the admin menu.");
                adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
            if(adminInput != 0) {
                try {
                    for (int i = 0; i < upcomingBets.length; i++) {
                        System.out.println(upcomingBets.length);
                        int betID = 0;
                        System.out.println(upcomingBets[i].getID());
                        if (adminInput == upcomingBets[i].getID()) {
                            System.out.println(adminInput);
                            betID = i;
                            System.out.println("What would you like to edit:\n" +
                                    "Name: 1\nDate Start: 2\nDate End: 3\nTeam One: 4\nTeam Two: 5\nOdd One: 6\n" +
                                    "Odd Two: 7\nWinning Team: 8\nWinning Num: 9\nMin Bet: 10\nMax Bet: 11" +
                                    "\nExit: 12");
                            try{
                                int adminInput1 = input1.nextInt();
                                if(adminInput1<1 || adminInput1>13){
                                    System.out.println("The number you entered does not correspond with any of the options." +
                                            " Please try again.");
                                    adminUBEdit(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                }
                                if(adminInput1 == 1){
                                    System.out.println("Enter the new Name:");
                                    String adminInput2 = input2.nextLine();
                                    upcomingBets[betID].setName(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 2){
                                    System.out.println("Enter the new Date Start:");
                                    String adminInput2 = input2.nextLine();
                                    upcomingBets[betID].setDateStart(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 3){
                                    System.out.println("Enter the new Date End:");
                                    String adminInput2 = input2.nextLine();
                                    upcomingBets[betID].setDateEnd(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 4){
                                    System.out.println("Enter the new Team One:");
                                    String adminInput2 = input2.nextLine();
                                    upcomingBets[betID].setTeamOne(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 5){
                                    System.out.println("Enter the new Team Two:");
                                    String adminInput2 = input2.nextLine();
                                    upcomingBets[betID].setTeamTwo(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 6){
                                    System.out.println("Enter the new Odd One:");
                                    double adminInput2 = input2.nextDouble();
                                    upcomingBets[betID].setOddOne(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 7){
                                    System.out.println("Enter the new Odd Two:");
                                    double adminInput2 = input2.nextDouble();
                                    upcomingBets[betID].setOddTwo(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 8){
                                    System.out.println("Enter the new Winning Team:");
                                    String adminInput2 = input2.nextLine();
                                    upcomingBets[betID].setWinningTeam(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 9){
                                    System.out.println("Enter the new Winning Num:");
                                    int adminInput2 = input2.nextInt();
                                    upcomingBets[betID].setWinningNum(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 10){
                                    System.out.println("Enter the new Min Bet:");
                                    double adminInput2 = input2.nextDouble();
                                    upcomingBets[betID].setMinBet(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 11){
                                    System.out.println("Enter the new Max Bet:");
                                    double adminInput2 = input2.nextDouble();
                                    upcomingBets[betID].setMaxBet(adminInput2);
                                    System.out.println("Success!");
                                }
                                if(adminInput1 == 12){
                                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                                }
                            }catch(Exception a){
                                adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                            }
                        }
                    }
                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                }catch(Exception a) {
                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                }
            }adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }catch(Exception a) {
            adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }

    /**
     * Name: adminUBMove
     * This Method is used to move upcoming bets to ongoing bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminUBMove(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets,
                                   Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        if(upcomingBets.length >= 1){
            System.out.println("\nHere is the list of upcoming bets:");
            for(int i = 0; i < upcomingBets.length; i++){
                System.out.println(upcomingBets[i].toStringThree());
                System.out.println("\n");
            }
        }else{
            System.out.println("\nThere are currently no upcoming bets to view\n");
        }
        System.out.println("Enter the ID of the game you would like to Move or 0 to exit:");
        try {
            int adminInput = input.nextInt();
            if (adminInput == 0) {
                System.out.println("You have exited back to the previous menu.");
                adminPrintOB(completedBets, ongoingBets, upcomingBets, userAccount, userBets);
            }
            if (adminInput != 0) {
                try {
                    for (int i = 0; i < upcomingBets.length; i++) {
                        int betID = 0;
                        if (adminInput == upcomingBets[i].getID()) {
                            betID = i;
                            int a = upcomingBets.length - 1;
                            Bet[] tempUpcomingBets = new Bet[a];
                            int b = 0;
                            for(int i1 = 0; i1 < upcomingBets.length; i1++){
                                if(betID != i1){
                                    tempUpcomingBets[b] = upcomingBets[i1];
                                    b++;
                                }
                            }
                            int c = ongoingBets.length + 1;
                            int d = ongoingBets.length;
                            Bet[] tempOngoingBets = new Bet[c];
                            tempOngoingBets[d] = upcomingBets[betID];
                            for(int i1 = 0; i1 < ongoingBets.length; i1++){
                                tempOngoingBets[i1] = ongoingBets[i1];
                            }
                            ongoingBets = tempOngoingBets;
                            upcomingBets = tempUpcomingBets;
                            System.out.println("Success!");
                        }
                    }
                }catch(Exception a){
                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                }
            }
        }catch(Exception a){
            adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
        adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
    }

    /**
     * Name: adminAddBet
     * This Method is used to add upcoming bets.
     * @param completedBets (Bet[]; array of completed bets)
     * @param ongoingBets (Bet[]; array of ongoing bets)
     * @param upcomingBets (Bet[]; array of upcoming bets)
     * @param userAccount (Account; the object of the users account.)
     * @param userBets (userBet[]; The array that contains the users bets.)
     */

    public static void adminAddBet(Bet[] completedBets, Bet[] ongoingBets, Bet[] upcomingBets,
                                   Account userAccount, userBet[] userBets){
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        Scanner input4 = new Scanner(System.in);
        Scanner input5 = new Scanner(System.in);
        Scanner input6 = new Scanner(System.in);
        Scanner input7 = new Scanner(System.in);
        Scanner input8 = new Scanner(System.in);
        Scanner input9 = new Scanner(System.in);
        Scanner input10 = new Scanner(System.in);
        System.out.println("You are going to start creating an object that will be added to the " +
                "upcoming objects array. If you are sure you want to continue enter 1. Any other number" +
                " will exit you to the main menu.");
        try{
            int adminInput = input.nextInt();
            if(adminInput == 1){
                System.out.println("ID:");
                int ID = input1.nextInt();
                if (ID == 0){
                    System.out.println("This ID is invalid, you will have to restart the adding" +
                            " process.");
                    adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                }
                for(int i = 0; i < upcomingBets.length; i++){
                    if (ID == upcomingBets[i].getID()){
                        System.out.println("This ID already exists, you will have to restart the adding" +
                                " process.");
                        adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                    }
                }
                for(int i1 = 0; i1 < ongoingBets.length; i1++){
                    if (ID == ongoingBets[i1].getID()){
                        System.out.println("This ID already exists, you will have to restart the adding" +
                                " process.");
                        adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                    }
                }
                for(int i2 = 0; i2 < completedBets.length; i2++){
                    if (ID == completedBets[i2].getID()){
                        System.out.println("This ID already exists, you will have to restart the adding" +
                                " process.");
                        adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
                    }
                }
                System.out.println("Name");
                String name = input2.nextLine();
                System.out.println("Start Date");
                String startDate = input3.nextLine();
                System.out.println("End Date");
                String endDate = input4.nextLine();
                System.out.println("Team One");
                String Team1 = input5.nextLine();
                System.out.println("Team Two");
                String Team2 = input6.nextLine();
                System.out.println("Team One's odds");
                double odd1 = input7.nextDouble();
                System.out.println("Team Two's odds");
                double odd2 = input8.nextDouble();
                System.out.println("Minimum Bet amount");
                double minBet = input9.nextDouble();
                System.out.println("Maximum Bet amount");
                double maxBet = input10.nextDouble();
                int c = upcomingBets.length + 1;
                int d = upcomingBets.length;
                Bet[] tempUpcomingBets = new Bet[c];
                tempUpcomingBets[d] = new Bet(ID,name,startDate,endDate,Team1,Team2,odd1,odd2,"N/A",0,
                        minBet,maxBet);
                for(int i1 = 0; i1 < upcomingBets.length; i1++){
                    tempUpcomingBets[i1] = upcomingBets[i1];
                }
                upcomingBets = tempUpcomingBets;
                System.out.println("Success!");
                adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
            }
        }catch(Exception a){
            adminUserBetTest(completedBets,ongoingBets,upcomingBets,userAccount,userBets);
        }
    }
}
