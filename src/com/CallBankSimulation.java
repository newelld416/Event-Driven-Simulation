package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public class CallBankSimulation {

    /**
     * This is the Main method that kicks off the program execution.
     * @param args
     */
    public static void main(String[] args){

        // Create a new call bank
        CallBank s = new CallBank(3, 5, 1);

        // Run the simulation
        s.run(20);
    }

}
