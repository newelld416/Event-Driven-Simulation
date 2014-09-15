package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
import java.util.Random;
import java.util.PriorityQueue;

public class Simulation {
    protected int time;                           // represents the simulation clock
    protected int nextCallTime;
    protected PriorityQueue<Event> eventSet;
    protected Random r;

    /**
     * Constructor.
     */
    public Simulation() {

    }

    /**
     * Schedule an event, add it to the queue.
     * @param e
     */
    public void scheduleEvent (Event e) {
        eventSet.add(e);
    }

    /**
     * Run the simulation until either the priority queue is empty or the simulation time is up
     * processing one event that is removed from the priority queue each time.
     * @param stoppingTime
     */
    public void run (long stoppingTime) {

    }
}
