package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public class DialIn extends Event {

    public int userId;
    private int nextCallTime = 0;

    public DialIn(int userId, int time) {
        super.time = time;
        this.userId = userId;
    }

    public void process (Simulation simulation) {
        CallBank bank = (CallBank)simulation;

        System.out.println("Dial In Message");
        if (bank.operators > 0){
            bank.operators--;
            simulation.howLong = simulation.r.nextInt(((CallBank) simulation).averageLength) + 1;
            System.out.println("Connect Message");
            super.time += simulation.howLong;
            simulation.eventSet.add(this);
        } else {
            System.out.println("Busy Message");
        }

        //TODO: Need to perform next call
    }


}
