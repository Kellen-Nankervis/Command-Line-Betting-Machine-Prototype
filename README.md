# Project Title

## Synopsis
This is a brief prototype for a betting program that would allow users to place bets and view what is going on.

## Motivation
I built this as my final project for CSCI 1111. I had a motivation for this project specifically because sports betting is an intrest of mine.

## How to Run
To run the program you will need BettingMachine.java, Bet.java, userbet.java, and Account.java. To start you will run BettingMachine.java
[Here is what you'll see when you begin the program](running.png)

## Code Example
I am proud of this method that lets the user simulates bets that they might want to play on either with implied odds or with their own odds.
```
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
```

## Tests
Since this project has no value returning methods I have no JUnit tests.

## Contributors
Kellen Nankervis
