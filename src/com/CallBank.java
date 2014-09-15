package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public class CallBank extends Simulation {

    public int operators;
    public int averageLength;
    public int callInterval;

    /**
     * Constructor.
     * @param operators
     * @param averageLength
     * @param callInterval
     */
    public CallBank (int operators, int averageLength, int callInterval) {
        this.operators = operators;
        this.averageLength = averageLength;
        this.callInterval = callInterval;
    }


}
