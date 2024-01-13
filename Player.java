package Carnival;
import java.util.*;

public class Player {
    
    double money;
    ArrayList<Prizes> winnings = new ArrayList<Prizes>();
    
    //gives player a certain number for their money
    public Player(double m){
        money = m;
    }
    
    //returns the money remaining
    public double getMoney(){
        return money;
    }

    //returns the user's prizes
    public String getPrizes(){
        int choice;
        while (true){
            Scanner g = new Scanner(System.in);
            System.out.println("Choose an option: \n1) View all prizes\n2) View number of small and large prizes for each game");
            String c = g.nextLine();
            try{
                Integer.parseInt(c);
                choice = Integer.valueOf(c);
                break;
            }
            catch(NumberFormatException ahkcvb){
                System.out.println("That is not an integer");
            }
        }
        while(true){
            if (choice == 1){
                ArrayList<String> names = new ArrayList<String>();
                for (Prizes f : winnings){
                    names.add(f.getName());
                }
                return "Your prizes include: " +names;
            }
            else if (choice == 2){
                int keychain =0;
                int fish = 0;
                int poster = 0;
                int tiger = 0;
                int boots = 0;
                int jeans = 0;
                int Africa = 0;
                int Greenland = 0;
                int nintendo = 0;
                int pods = 0;
                for (Prizes s : winnings){
                    String n = s.getName();
                    if (n.equals("Plush Fish")){
                        fish++;
                    }
                    else if (n.equals("Keychain")){
                        keychain++;
                    }
                    else if(n.equals("Poster")){
                        poster++;
                    }
                    else if(n.equals("Plush Tiger")){
                        tiger++;
                    }
                    else if(n.equals("Boots with the fur")){
                        boots++;
                    }
                    else if (n.equals("Apple bottom jeans")){
                        jeans++;
                    }
                    else if(n.equals("Africa")){
                        Africa++;
                    }
                    else if(n.equals("Greenland")){
                        Greenland++;
                    }
                    else if(n.equals("Nintendo Switch")){
                        nintendo++;
                    }
                    else{
                        pods++;
                    }
                }
                return "Red or Black: " +keychain+ " small prizes and " +fish+ " large prizes.\nPenny Toss: " +poster+ " small prizes and " +tiger+ " large prizes. \nWheel Spin: " +jeans+ " small prizes and " +boots+ " large prizes.\nTreasure Hunter: " +Greenland+ " small prizes and " +Africa+ " large prizes.\nBattleship: " +pods+ " small prizes and " +nintendo+ " large prizes.";
            }
            else{
                System.out.println("Please choose a valid interger.");
            }
        }    
    }

    public String toString(){
        return getPrizes();
    }

    //checks whether the user has enough money to run the game.
    //It calls the getCost function from the gamebooth inerface and checks whether the amount of money is valid
    //It will then create an object to run the start function and run the game
    public void play(Gamebooth g){
        if (money >= g.getCost()){
            Prizes run = g.start();
            money -= g.getCost();
            if(run != null){ 
                winnings.add(run);
            }
        }
        else{
            System.out.println("You don't have enough money. Pick a different option.");
        }
        
    }

    
}
