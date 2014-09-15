package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
import java.util.Random;
import java.util.PriorityQueue;

public class Simulation {
    protected int time;
    protected int nextCallTime = 0;
    protected PriorityQueue<Event> eventSet;
    protected Random r;
    protected int howLong;

    /**
     * Constructor.
     */
    public Simulation() {
        eventSet = new PriorityQueue<Event>();
        r = new Random();

        //Need to make next call

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
        Event event = null;

        while (!eventSet.isEmpty()){
            event = eventSet.remove();
            event.process(this);
        }
    }

    //Need public method for next call

}
