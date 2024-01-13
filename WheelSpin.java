package Carnival;

public class WheelSpin implements Gamebooth {

    public double getCost(){
        return 1.0;
    }

    public Prizes start(){
        
        //generates two random numbers
        int num1 = (int)(Math.random()*25);
        int num2 = (int)(Math.random()*25);
        int total = num1 + num2;
        Prizes a;

        System.out.println("Playing Spin the Wheel...");
        System.out.println("Welcome to Spin the Wheel!");
        System.out.println("This wheel has 25 numbers on it!");
        System.out.println("You'll spin the wheel twice.");
        System.out.println("If you get a number higher than 20, you win a small prize of a pair of apple bottom jeans!");
        System.out.println("If you get two numbers that add up to 25, you win a large prize of boots with the fur!");
        System.out.println("Let's Spin That Wheel!");
        //checks if the total of the two numbers is 25 and gives a large prize
        if (total == 25){
            System.out.println("YOU GOT TWO NUMBERS ADDING TO 25!");
            System.out.println("You win a pair of boots with the fur!");
            a = new Prizes("large","Boots with the fur");
        }
        // checks if either number is greater than 20 and gives a small prize
        else if (num1 > 20 || num2 > 20){
            System.out.println("You spun a number greater than 20!");
            System.out.println("You win a pair of apple bottom jeans!");
            a = new Prizes("small","Apple bottom jeans");
        }
        else{
            System.out.println("You didn't win anything.");
            a = null;
        }

        return a;

    }
    
}
