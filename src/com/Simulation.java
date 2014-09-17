package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
import java.io.PrintWriter;
import java.util.Random;
import java.util.PriorityQueue;

public class Simulation {
    //These parameters are used throughout the simulation
    protected int nextCallTime = 0;
    protected PriorityQueue<Event> eventSet;
    protected Random r;
    protected int howLong;
    private int userNum = 0;

    //These parameters are used for the statistics
    public int callsDialedIn = 0;
    public int callsAccepted = 0;
    public int callsRejected = 0;
    public double totalTimeConnected = 0;
    public int longestTimeConnected = 0;

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

        clearOutputFile();

        Event event = null;

        while (!eventSet.isEmpty()){
            event = eventSet.remove();

            if(event.time > stoppingTime ) {
                break;
            }

            event.process(this);
        }

        printStatistics();
    }

    /**
     * Place a new DIAL_IN event into the event queue.
     * Then advance the time when next DIAL_IN event will occur.
     * In practice, we would use a random number to set the time.
     */
    public void nextCall(int delta){
        DialIn dialIn = new DialIn(userNum++, nextCallTime);
        scheduleEvent(dialIn);
        nextCallTime += delta;
    }

    /**
     * This method prints the statistics.
     */
    public void printStatistics(){
        Utilities.OutputMessage(Constants.STATISTICS_MESSAGE, Constants.OUTPUT_FILENAME);
        Utilities.OutputMessage(String.format(Constants.CALLS_DIALED_IN_MESSAGE, this.callsDialedIn), Constants.OUTPUT_FILENAME);
        Utilities.OutputMessage(String.format(Constants.CALLS_ACCEPTED_MESSAGE, this.callsAccepted), Constants.OUTPUT_FILENAME);
        Utilities.OutputMessage(String.format(Constants.CALLS_REJECTED_MESSAGE, this.callsRejected), Constants.OUTPUT_FILENAME);
        Utilities.OutputMessage(String.format(Constants.AVERAGE_CONNECTED_TIME_MESSAGE, this.totalTimeConnected/ (double) this.callsAccepted), Constants.OUTPUT_FILENAME);
        Utilities.OutputMessage(String.format(Constants.LONGEST_TIME_CONNECTED_MESSAGE, this.longestTimeConnected), Constants.OUTPUT_FILENAME);
    }

    /**
     * This method clears the output file.
     */
    private void clearOutputFile() {
        try {
            PrintWriter writer = new PrintWriter(Constants.OUTPUT_FILENAME);
            writer.print("");
            writer.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
        }
    }
}
