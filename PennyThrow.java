package Carnival;
import java.util.*;

public class PennyThrow implements Gamebooth{

    // initialises the board that penny's will land on. Also initialises the array list that will store the spaces that were landed on.
    String[][] board = {{"Poster","Poster","Plush Tiger","Nothing"},{"Nothing","Plush Tiger","Nothing","Poster"},{"Poster","Nothing","Poster","Nothing"},{"Nothing","Nothing","Nothing","Plush Tiger"}};
    ArrayList<String> score = new ArrayList<String>();
    Prizes a;
    
    public double getCost(){
        return 3.0;
    }


    public Prizes start(){
        System.out.println("Playing Penny Toss...");
        //initialises the users random throws
        int x = (int)(Math.random()*4);
        int y = (int)(Math.random()*4);
        int c = (int)(Math.random()*4);
        int b = (int)(Math.random()*4);
        int r = (int)(Math.random()*4);
        int t = (int)(Math.random()*4);
        score.add(board[x][y]);
        score.add(board[c][b]);
        score.add(board[r][t]);
        //prints the three squares landed on
        System.out.println("You landed on " +score);
        /* This for loop determines whether the three squares the user landed on
         * are the same. If they aren't it breaks the loop and returns null.
         */
        for (String s : score) {
            if (!s.equals(score.get(0))) {  
                System.out.println("You didn't win anything.");
                a = null;
                return a;
            }
        }
        /* if and else if statements determine what prize the player gets by checking
         * their first square. THis works because we have already checked whether the array
         * holds values which are all equal. Instead of checking the first index, I could
         * check any of the indexes
         */
        if (score.get(0).equals("Poster")){
            System.out.println("You win a Poster!");
            a = new Prizes("small","Poster");
        }
        else if(score.get(0).equals("Plush Tiger")){
            System.out.println("You win a Plush Tiger!");
            a = new Prizes("large","Plush Tiger");
        }
        else if (score.get(0).equals("Nothing")){
            System.out.println("You don't win anything");
            a = null;
        }
        return a;
        
    }

}
