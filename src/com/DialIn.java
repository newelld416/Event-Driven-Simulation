package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public class DialIn extends Event {

    public int userId;

    public DialIn(int userId, int time) {
        super.time = time;
        this.userId = userId;
    }

    public void process (Simulation s) {
        CallBank bank = (CallBank)s;

        // to complete
    }
}
