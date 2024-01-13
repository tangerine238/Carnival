package Carnival;

interface Gamebooth { 
    
    /* This is the gamebooth interface. It acts as the mother class for all of the games used in this code. 
     * Within this interface, are two methods, start and getCost. These methods are used in all of the games. 
     * Essentially, the gamebooth interface lets you hold these common methods to be used later.
     */

    public Prizes start(); 
    public double getCost();

}