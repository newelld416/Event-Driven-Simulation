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

    public void process(Simulation s) {
        CallBank bank = (CallBank)s;

        // to complete this now
    }


}
