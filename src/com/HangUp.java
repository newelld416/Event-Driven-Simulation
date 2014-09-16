package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public class HangUp extends Event {

    public int userId;

    /**
     * This is the constructor.
     * @param userId
     * @param time
     */
    public HangUp (int userId, int time) {
        super.time = time;
        this.userId = userId;
    }

    /**
     * This is the definition of the process method for the HangUp object.
     * @param simulation
     */
    public void process(Simulation simulation) {
        CallBank callBank = (CallBank)simulation;
        callBank.operators++;
        System.out.printf(Constants.HANG_UP_MESSAGE, this.userId, super.time);
    }


}
