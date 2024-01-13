package Carnival;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        int loop = 0; //initialises while loop conditions. I really could have done while true instead but I chose to do it this way.
        int loop2 = 0;
        double n;
        System.out.println("Welcome to the Carnival!");
        // Asks user how much money they have and retrieves the value as a double
        while (true){
            System.out.print("How much money do you have with you today?");
            Scanner a = new Scanner(System.in);
            if(!a.hasNextDouble()){
                System.out.println("That was an invalid input. Please use a double value. Eg. 3.5.");
            
            }
            else{
                n = a.nextDouble();  
                break;
            }
        }

        // creates a new instance of the player class. This will represent the user and store their money and prizes.
        Player customer = new Player(n); 
        /* This is the main game portion. It runs a continous while loop for the player to indicate whether they want to play a game, 
         * see their wallet or quit.
         * This loop will also account for incorrect variables like L or F without breaking. Within this loop, if the user choses option a, 
         * the system starts a new loop for the game portion of the code. This is also a while loop and it also corrects for invalid options.
         * Within this while loop are if statements which determine the game the player will play. 
         * These if statements create a new instance of the game and run the game.
        */
        while (loop == 0){
            System.out.println("Choose one of these options:\n A) Play A Game\n B) See Prizes\n C) Quit");
            Scanner b = new Scanner(System.in);
            String choice = b.nextLine();
            if (choice.equals("A") || choice.equals("a")){
                while (loop2 == 0){
                    System.out.println("You have "+customer.getMoney()+" dollars.\nWhich game would you like to play?\n 1) Red or Black ($1.50) \n 2) Penny Toss ($3.00)\n 3) Spin That Wheel ($1.00) \n 4) Treasure hunter ($10.00)\n 5) Battleship ($5.00)\n 6) Stop Playing");
                    Scanner c = new Scanner(System.in);
                    String game = c.nextLine();
                    if (game.equals("1")){
                        Gamebooth g1 = new Marbles();
                        customer.play(g1);
                    }      
                    else if (game.equals("2")){
                        Gamebooth g2 = new PennyThrow();
                        customer.play(g2);
                    }
                    else if (game.equals("3")){
                        Gamebooth g3 = new WheelSpin();
                        customer.play(g3);
                    }
                    else if (game.equals("4")){
                        Gamebooth g4 = new TreasureHunter();
                        customer.play(g4);
                    }
                    else if (game.equals("5")){
                        Gamebooth g5 = new Battleship();
                        customer.play(g5);
                    }
                    else if (game.equals("6")){
                        break;
                    }
                    else{
                        System.out.println("That is not a valid option. Try again.");
                    }
                }    
                
            }
            else if(choice.equals("B") || choice.equals("b")){
                System.out.println(customer.toString());
            }
            else if(choice.equals("C") || choice.equals("c")){
                System.out.println("Bye");
                break;
            }

            else{
                System.out.println("That's not a valid option.");
            }
        }     
    }
}
