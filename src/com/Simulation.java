package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
import java.util.Random;
import java.util.PriorityQueue;

public class Simulation {
    protected int time;                           // represents the simulation clock

    protected PriorityQueue<Event> eventSet;
    protected Random r;

    public Simulation() {
        // to complete
    }

    public void scheduleEvent (Event e) {
        // add e to the priority queue
    }

    public void run (long stoppingTime) {
        // run the simulation until either the priority queue is empty or
// the simulation time is up
// processing one event that is removed from the priority queue
// each time
    }
}
