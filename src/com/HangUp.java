package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public class HangUp extends Event {

    /**
     * This is the constructor.
     * @param userId
     * @param time
     */
    public HangUp (int userId, int time) {
        super.time = time;
        super.userId = userId;
    }

    /**
     * This is the definition of the process method for the HangUp object.
     * @param simulation
     */
    public void process(Simulation simulation) {
        CallBank callBank = (CallBank)simulation;
        callBank.operators++;
        Utilities.OutputMessage(String.format(Constants.HANG_UP_MESSAGE, this.userId, super.time), Constants.OUTPUT_FILENAME);
    }


}
