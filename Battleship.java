package Carnival;
import java.util.Scanner;

public class Battleship implements Gamebooth{

    public double getCost(){
        return 5.0;
    }

    public Prizes start(){

        //initilises 2D arrays for the board.
        String[][] boardPlayer = {{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "}};
        String[][] boardComp = {{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "}};
        //introduces game and shows player the grid
        System.out.println("Welcome to Battleship \nThe game is simple. You will recieve one boat which has a lenghth of 3 squares and a width of one.");
        System.out.println("You will place your boat on your grid. \nYou will then take turns with the computer, attempting to find the other's boat. \nIf you sink the computer's boat first, you win a Nintendo Switch. \nIf your boat gets sunk first but you hit the computer's boat, you win a pair of airbuds.");
        showGrid(boardPlayer);
        System.out.println("This is your grid");
        //initialises varaibles needed
        int row;
        int col;
        int row2;
        int col2;
        int orientation = (int)(Math.random()*2);
        int total;
        int total2;
        int compStartRow = (int)(Math.random()*5) + 1;
        int compStartCol = (int)(Math.random()*5) + 1;
        int compEndRow;
        int compEndCol;
        int compPick = 0;
        int compPick2 = 0;
        int pick;
        int pick2;
        Prizes a;
        int counter = 0;
        boolean upRow = false;
        boolean leftCol = false;
        boolean downRow = false;
        boolean rightCol = false;
        int direct = 20;

        /* This is the while loop function that determines the placment of the player's ship.
         * It first recieves a user input for the starting position of the head of the ship
         * It determines whether these input is an interger.
         * It also determines if either of the inputs are outside of the array
         * It then does the same for the tail of the ship
         * It then determines whether the ship has dimmensions 3x1 or 1x3 and asks the user to pick again if it doesn't
         */
        while(true){
            while(true){
                while (true){
                    Scanner f = new Scanner(System.in);
                    System.out.print("What row do you want your ship to start on?");
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
                    Scanner q = new Scanner(System.in);
                    System.out.print("What column do you want your ship to start on?");
                    String w = q.nextLine();
                    try{
                        Integer.parseInt(w);
                        col = Integer.valueOf(w);
                        break;
                    }
                    catch(NumberFormatException ahkcvb){
                        System.out.println("That is not an integer");
                    }
                }
                if (row > 5 || row < 1){
                    System.out.println("You picked an invalid row. Please pick numbers between 1 and 5 inclusive");
                }
                else if (col > 5 || col < 1){
                    System.out.println("You picked an invalid column. Please pick numbers between 1 and 5 inclusive");
                }
                else{
                    break;
                }
            }   
            while(true){
                while (true){
                    Scanner e = new Scanner(System.in);
                    System.out.print("What row do you want your ship to end on?");
                    String t = e.nextLine();
                    try{
                        Integer.parseInt(t);
                        row2 = Integer.valueOf(t);
                        break;
                    }
                    catch(NumberFormatException ahkcvb){
                        System.out.println("That is not an integer");
                    }
                    }
                while (true){
                    Scanner p = new Scanner(System.in);
                    System.out.print("What column do you want your ship to end on?");
                    String o = p.nextLine();
                    try{
                        Integer.parseInt(o);
                        col2 = Integer.valueOf(o);
                        break;
                    }
                    catch(NumberFormatException ahkcvb){
                        System.out.println("That is not an integer");
                    }
                }
                if (row2 > 5 || row2 < 1){
                    System.out.println("You picked an invalid row. Please pick numbers between 1 and 5 inclusive");
                }   
                else if (col2 > 5 || col2 < 1){
                    System.out.println("You picked an invalid column. Please pick numbers between 1 and 5 inclusive");
                }
                else{
                    break;
                }
            }  
            total = row - row2;
            total2 = col - col2;
            if (Math.abs(total) == 0){
                if(Math.abs(total2) != 2){
                    System.out.println("Your ship has incorrect dimmensions. Please choose again");
                }
                else{
                    break;
                }
            }
            else if (Math.abs(total2) == 0){
                if(Math.abs(total) != 2){
                    System.out.println("Your ship has incorrect dimmensions. Please choose again");
                }
                else{
                    break;
                }
            }
            else{
                System.out.println("Your ship has incorrect dimmensions. Please choose again.");
            }
        }
        /* This function places the user's ship in their chosen place
         * It also determines where the middle of the ship is, based on the position of the head and tail
         */
        boardPlayer[row-1][col-1] = "s";
        boardPlayer[row2-1][col2-1] = "s";
        if (Math.abs(total) == 2){
            if(row > row2){
                boardPlayer[row2][col-1] = "s";
            }
            else{
                boardPlayer[row][col-1] = "s";
            }
        }
        else{
            if(col > col2){
                boardPlayer[row-1][col2] = "s";
            }
            else{
                boardPlayer[row-1][col] = "s";
            }
        }
        int compMiddleRow;
        int compMiddleCol;
        /* This code determines where the computer's ship will be placed
         * Based on the random interger generated previously, it places the ship so that it is within the dimmensions of the baord
         * It also determines whether the ship will be horizontal or vertical
         */
        if(orientation == 0){
            if(compStartCol - 2 > 1){
                compEndCol = compStartCol - 2;
                compMiddleCol = compStartCol - 1;
            }
            else if(compStartCol + 2 < 5){
                compEndCol = compStartCol + 2;
                compMiddleCol = compStartCol + 1;
            }
            else{
                int rand = (int)(Math.random()*2);
                if (rand == 0){
                    compEndCol = compStartCol + 2;
                    compMiddleCol = compStartCol + 1;
                }
                else{
                    compEndCol = compStartCol - 2;
                    compMiddleCol = compStartCol - 1;
                }
            }
            compEndRow = compStartRow;
            compMiddleRow = compStartRow;
        }
        else{
            if(compStartRow - 2 > 1){
                compEndRow = compStartRow - 2;
                compMiddleRow = compStartRow - 1;
            }
            else if(compStartRow + 2 < 5){
                compEndRow = compStartRow + 2;
                compMiddleRow = compStartRow + 1;
            }
            else{
                int rand = (int)(Math.random()*2);
                if (rand == 0){
                    compEndRow = compStartRow + 2;
                    compMiddleRow = compStartRow + 1;
                }
                else{
                    compEndRow = compStartRow - 2;
                    compMiddleRow = compStartRow - 1;
                }
            }
            compEndCol = compStartCol;
            compMiddleCol = compStartCol;
        }
        System.out.println("Here is your board.");
        showGrid(boardPlayer);
        System.out.println("The computer will go first.");
        boolean hit = false;
        boolean orient = false;
        boolean playerHit = false;
        int spot = 0;
        int spot2 = 0;            
        int spot3 = 0;
        int spot4 = 0;
        /* While loop for the computer's choice
         * If it hasn't hit anything, the computer will choose a random square
         * Once it has, it will choose a square which is adjacent to the hit square
         * If it gets two hits, it will only look on either side of the two hits.
         */
        while(true){
            if (hit == false){
                while(true){
                    compPick = (int)(Math.random()*5);
                    compPick2 = (int)(Math.random()*5);
                    if(boardPlayer[compPick][compPick2].equals("s")){
                        System.out.println("The computer got a hit!");
                        boardPlayer[compPick][compPick2] = "x";
                        hit = true;
                        spot = compPick;
                        spot2 = compPick2;
                        break;
                    }
                    else if(boardPlayer[compPick][compPick2].equals("o")){
                        compPick = (int)(Math.random()*5);
                        compPick2 = (int)(Math.random()*5);
                    }
                    else{
                        System.out.println("The computer missed.");
                        boardPlayer[compPick][compPick2] = "o";
                        break;
                    }
                }   
            }
            else if(orient == false){
                while(true){
                    compPick = 100;
                    compPick2 = 100;
                    //compPick is changed so the check is breaking
                    if (spot == 0){
                        upRow = true; 
                    }
                    else if (spot == 4){
                        downRow = true;
                    }
                    if (spot2 == 0){
                        leftCol = true;
                    }
                    else if (spot2 == 4){
                        rightCol = true;
                    }
                    
                    while(true){
                        direct = (int)(Math.random()*4);
                        if(upRow){
                            if(leftCol){
                                direct = (int)(Math.random()*2);
                            }
                            else if(rightCol){
                                while(direct != 0 || direct != 3){
                                    direct = (int)(Math.random()*4);
                                }
                            }
                            else{
                                while (direct == 2){
                                    direct = (int)(Math.random()*4);
                                }
                            }
                            break;
                        }
                        else if(downRow){
                            if(leftCol){
                                while(direct != 2 || direct != 1){
                                    direct = (int)(Math.random()*4);
                                }
                            }
                            else if(rightCol){
                                while(direct != 0 || direct != 3){
                                    direct = (int)(Math.random()*4);
                                }
                            }
                            else{
                                while(direct == 0){
                                    direct = (int)(Math.random()*4);
                                }
                            }
                            break;
                        }
                        else if (rightCol){
                            while (direct == 1){
                                direct = (int)(Math.random()*4);
                            }
                            break;
                        }
                        else if (leftCol){
                            while(direct == 3){
                                direct = (int)(Math.random()*4);
                            }
                            break;
                        }
                        else{
                            break;
                        }
                    }
                    if(direct == 0){
                        compPick = spot + 1;
                        compPick2 = spot2;
                    }
                    else if(direct == 1){
                        compPick = spot;
                        compPick2 = spot2 + 1;
                    }
                    else if(direct == 2){
                        compPick = spot - 1;
                        compPick2 = spot2;
                    }
                    else if (direct == 3){
                        compPick = spot;
                        compPick2 = spot2 - 1;
                    }
                    if(boardPlayer[compPick][compPick2].equals("s")){
                        System.out.println("The computer got a hit!");
                        boardPlayer[compPick][compPick2] = "x";
                        orient = true;
                        spot3 = compPick;
                        spot4 = compPick2;
                        break;
                    }
                    else if(boardPlayer[compPick][compPick2].equals("o")){
  
                    }
                    else{
                        System.out.println("The computer missed.");
                        boardPlayer[compPick][compPick2] = "o";
                        break;
                    }
                }
            }
            else {
                boolean taken = false;
                while(true){
                    if (taken == false){
                        if (spot - spot3 > 0){
                            compPick = spot + 1;
                            compPick2 = spot2;
                        }
                        else if (spot3 - spot > 0){
                            compPick = spot3 + 1;
                            compPick2 = spot2;
                        }
                        else if (spot2 - spot4 > 0){
                            compPick = spot;
                            compPick2 = spot2 + 1;
                        }
                        else{
                            compPick = spot;
                            compPick2 = spot4 + 1;
                        }
                    }
                    else{
                        if (spot - spot3 > 0){
                            compPick = spot3 - 1;
                            compPick2 = spot2;
                        }
                        else if (spot3 - spot > 0){
                            compPick = spot - 1;
                            compPick2 = spot2;
                        }
                        else if (spot2 - spot4 > 0){
                            compPick = spot;
                            compPick2 = spot4 - 1;
                        }
                        else{
                            compPick = spot;
                            compPick2 = spot2 - 1;
                        }
                    }
                    if(boardPlayer[compPick][compPick2].equals("s")){
                        System.out.println("The computer got a hit!");
                        boardPlayer[compPick][compPick2] = "x";
                        System.out.println("The computer has sunk your battleship! It wins!");
                        if(playerHit == true){
                            System.out.println("You win a pair of airpods");
                            a = new Prizes("small","Airpods");
                            return a;
                        }
                        else{
                            System.out.println("You win nothing.");
                            a = null;
                            return null;
                        }
                    }
                    else if(boardPlayer[compPick][compPick2].equals("o")){
                        taken = true;
                    }
                    else{
                        System.out.println("The computer missed.");
                        boardPlayer[compPick][compPick2] = "o";
                        break;
                    }
        
                }
            }
            
            /* while loop for the player to pick
             * checks whether the player's choices are intergers
             * Also checks if the space chosen by the player has already been picked
             * Then checks if the position the player choses is part of the computer's ship
             */
            while(true){
                System.out.println("Here is your board.");
                showGrid(boardPlayer);
                System.out.println("Here is your attacking board.");
                showGrid(boardComp);
                while (true){
                    Scanner asdf = new Scanner(System.in);
                    System.out.print("What row do you want to guess?");
                    String ghjk = asdf.nextLine();
                    try{
                        Integer.parseInt(ghjk);
                        pick = Integer.valueOf(ghjk);
                        break;
                    }
                    catch(NumberFormatException ahkcvb){
                        System.out.println("That is not an integer");
                    }
                }
                while (true){
                    Scanner qwer = new Scanner(System.in);
                    System.out.print("What column do you want to guess?");
                    String wert = qwer.nextLine();
                    try{
                        Integer.parseInt(wert);
                        pick2 = Integer.valueOf(wert);
                        break;
                    }
                    catch(NumberFormatException ahkcvb){
                        System.out.println("That is not an integer");
                    }
                }
                if (pick > 5 || pick < 1 || pick2 < 1 || pick2 > 5){
                    System.out.println("That is not a valid square. Try again.");
                }
                else if (boardComp[pick-1][pick2-1].equals("x") || boardComp[pick-1][pick2-1].equals("o")){
                    System.out.println("You have already picked that square");
                }
                else{
                    break;
                }
            }
            if (pick-1 == compEndRow || pick-1 == compMiddleRow || pick-1 == compStartRow){
                if (pick2-1 == compEndCol || pick2-1 == compStartCol || pick2-1 == compMiddleCol){
                    System.out.println("HIT!");
                    counter++;
                    boardComp[pick-1][pick2-1] = "x";
                    playerHit = true;
                    if(counter == 3){
                        System.out.println("You sunk the computer's ship!");
                        System.out.println("You win a Nintendo switch!");
                        a = new Prizes("large","Nintendo Switch");
                        return a;
                    }
                }
                else{
                    System.out.println("Missed.");
                    boardComp[pick-1][pick2-1] = "o";   
                }
            }
            else{
                System.out.println("Missed.");
                boardComp[pick-1][pick2-1] = "o";
            }
        
        }
    }
            
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
