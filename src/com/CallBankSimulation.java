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
        CallBank s = new CallBank(3, 5, 1);
        s.run(20);
    }

}
