package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public class HangUp extends Event {

    public int userId;

    public HangUp (int userId, int time) {
        super.time = time;
        this.userId = userId;
    }

    public void process(Simulation simulation) {
        CallBank bank = (CallBank)simulation;
        ((CallBank) simulation).operators++;
        System.out.println("Hang Up Message");
    }


}
