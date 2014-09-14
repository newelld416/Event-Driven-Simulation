package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public abstract class Event implements Comparable<Event> {
    int time;

    public int compareTo( Event rhs ) {
        return 1;
    }

    public abstract void process(Simulation s);
}
