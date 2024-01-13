package Carnival;

public class Prizes {
    
    String size;
    String name;

    //constructor creating a prizes object
    public Prizes(String n, String m){
        size = n;
        name = m;
    }

    public Prizes(){
        
    }

    //returns the size of the prize
    public String getSize(){
        return size;
    }

    //returns the name of the prize
    public String getName(){
        return name;
    }

}
