package Carnival;

public class Marbles implements Gamebooth{
    
    // initialization of all the necessary variables
    String colour;
    String colourTwo;
    String colourThree;
    // does the three random draws
    int draw = (int)(Math.random()*2);
    int drawTwo = (int)(Math.random()*2);
    int drawThree = (int)(Math.random()*2);
    Prizes a;

    public Prizes start(){
        //plays the red and black game
        System.out.println("Playing Red and Black ...");
        //turns each draw into red or black
        if (draw == 0){
            colour = "red";
        }
        else{
            colour = "black";
        }
        if (drawTwo == 0){
            colourTwo = "red";
        }
        else{
            colourTwo = "black";
        }
        if (drawThree == 0){
            colourThree = "red";
        }
        else{
            colourThree = "black";
        }
        //states the colours picked
        System.out.println("Your first draw was "+colour);
        System.out.println("Your second draw was "+colourTwo);
        System.out.println("Your third draw was "+colourThree);
        // if statement first checks if the first two draws are the same, then if the second and third are the same
        if (draw == drawTwo){         
            if (drawThree == drawTwo){
                System.out.println("You win a Plush Fish!");
                a = new Prizes("large","Plush Fish");
            }
            else{
                System.out.println("You win a Keychain!");
                a = new Prizes("small","Keychain");
            }
        }
        else{
            System.out.println("You win a Keychain!");
            a = new Prizes("small","Keychain");
        }
        
        return a;
    }
    //returns the cost of playing
    public double getCost(){
        return 1.5;
    }
}
    

