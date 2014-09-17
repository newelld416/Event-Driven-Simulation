package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public abstract class Event implements Comparable<Event> {
    int time;
    int userId;

    /**
     * Compare to method, used to compare events.
     * @param event
     * @return
     */
    public int compareTo(Event event) {
        return this.time - event.time;
    }

    /**
     * This process method is implemented int DialIn and HangUp classes.
     * @param simulation
     */
    public abstract void process(Simulation simulation);
}
