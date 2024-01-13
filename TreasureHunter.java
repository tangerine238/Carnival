package Carnival;
import java.util.Scanner;

public class TreasureHunter implements Gamebooth {

    //returns the cost of playing
    public double getCost(){
        return 10.0;
    }

    

    public Prizes start(){
        //initialises the board so it is completly empty. It also intialises the random variables for the position of the "treasure"
        String[][] board = {{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "}};
        Prizes a;
        int x = (int)(Math.random()*5) + 1;
        int y = (int)(Math.random()*5) + 1;

        // Welcome text and explination of the game
        System.out.println("Playing treasure hunter...");
        System.out.println("Welcome to treasure hunter.\nYour goal is to guess which square the treasure is on.\nThe game will ask you the row you want to pick from, and the column you want to pick from.\nIf you find the prize after 2 guesses, you win a large prize.\nIf you find one after 4 guesses, you get a small prize.");
        System.out.println("Here's the board.");
        int repeat = 1;
        int row;
        int col;
        //game loop
        while(true){
            // uses the showGrid function made below to show the user the baord
            showGrid(board);
            /* These two wile loops ask the user to input a row and column they want to pick from.
             * The code checks whether the inputs are intergers and throws exceptions if they are not.
             */
            while (true){
                Scanner f = new Scanner(System.in);
                System.out.print("What row do you want to pick from?");
                String r = f.nextLine();
                try{
                    Integer.parseInt(r);
                    row = Integer.valueOf(r);
                    break;
                }
                catch(NumberFormatException ahkcvb){
                    System.out.println("That is not an integer");
                }
            }
            while (true){
                Scanner l = new Scanner(System.in);
                System.out.print("What col do you want to pick from?");
                String c = l.nextLine();
                try{
                    Integer.parseInt(c);
                    col = Integer.valueOf(c);
                    break;
                }
                catch(NumberFormatException ahkcvb){
                    System.out.println("That is not an integer");
                }
            }
            /* Nested if statements to determine if the row and column the user picked are valid by checking if they are less
            * than the length and width of the array and greater than 0. It also checks if the given guess is equal to the treasure's location.
            * It determines how many guessses it took the user to guess the correct square and gives prizes accordingly. 
            * It checks whether the square has already been chosen by the user.
            * Finally, if the space hasn't been chosen already and the space is not the correct square,
            * it tells the user how close they were to the correct row and correct column.
            */
            if(row < 6 && col < 6 && row > 0 && col > 0){
               if(row == x && col == y){
                System.out.println("You got it after " +repeat+ " guesses!");
                if(repeat < 4){
                    System.out.println("You win Africa!");
                    a = new Prizes("large","Africa");
                    break;
                }
                else if (repeat < 6){
                    System.out.println("You win Greenland!");
                    a = new Prizes("small","Greenland");
                    break;
                }
                else{
                    System.out.println("You didn't win anything.");
                    a = null;
                    break;
                }
                }
                else if(board[row-1][col-1] == "o"){
                    System.out.println("You've already tried that square.");
                }
                else{
                    System.out.println("Nope, try again.");
                    if(row == x + 1 || row == x - 1){
                        System.out.println("You were one row off");
                    }
                    if(col == y + 1 || col == y - 1){
                        System.out.println("You were one column off.");
                    }
                    board[row-1][col-1] = "o";
                } 
            }
            else{
                System.out.println("Invalid number! Pick again!.");
            }
            repeat ++;
        }
        return a;        
        }      
        
        // nested for loops will print each point in the array and in doing so, prints out the board for the player
        public void showGrid(String[][] n){
        for(int i = 0; i < n.length;i++){
            for (int j = 0; j < n[i].length; j++){
                System.out.print("|" + n[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }

    }

}
