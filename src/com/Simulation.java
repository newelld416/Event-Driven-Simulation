package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
import java.util.Random;
import java.util.PriorityQueue;

public class Simulation {
    protected int nextCallTime = 0;
    protected PriorityQueue<Event> eventSet;
    protected Random r;
    protected int howLong;
    private int userNum = 0;

    /**
     * Constructor.
     */
    public Simulation() {}

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

            if(event.time > stoppingTime ) {
                break;
            }

            event.process(this);
        }
    }

    /**
     * Place a new DIAL_IN event into the event queue.
     * Then advance the time when next DIAL_IN event will occur.
     * In practice, we would use a random number to set the time.
     */
    public void nextCall(int delta)
    {
        DialIn dialIn = new DialIn(userNum++, nextCallTime);
        scheduleEvent(dialIn);
        nextCallTime += delta;
    }

}
