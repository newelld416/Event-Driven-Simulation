package com;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public class CallBank extends Simulation {

    public int operators;
    public int averageLength;
    public int callInterval;

    /**
     * This is the constructor.
     * @param operators
     * @param averageLength
     * @param callInterval
     */
    public CallBank (int operators, int averageLength, int callInterval) {
        this.operators = operators;
        this.averageLength = averageLength;
        this.callInterval = callInterval;
        super.eventSet = new PriorityQueue<Event>();
        super.r = new Random();
        nextCall(this.callInterval);
    }


}
