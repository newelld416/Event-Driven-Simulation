package com;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public class CallBank extends Simulation {

    public int operators;
    public int averageLength;
    public int maxCallInterval;

    /**
     * This is the constructor.
     * @param operators
     * @param averageLength
     * @param maxCallInterval
     */
    public CallBank (int operators, int averageLength, int maxCallInterval) {
        this.operators = operators;
        this.averageLength = averageLength;
        this.maxCallInterval = maxCallInterval;
        super.eventSet = new PriorityQueue<Event>();
        super.r = new Random();
        nextCall(super.r.nextInt(this.maxCallInterval)+1);
    }


}
