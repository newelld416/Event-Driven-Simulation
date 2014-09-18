package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public class DialIn extends Event {

    /**
     * This is the constructor.
     * @param userId
     * @param time
     */
    public DialIn(int userId, int time) {
        super.time = time;
        super.userId = userId;
    }

    /**
     * This is the definition of the process method for the DialIn object.
     * @param simulation
     */
    public void process (Simulation simulation) {
        CallBank callbank = (CallBank)simulation;
        callbank.callsDialedIn++;
        Utilities.OutputMessage(String.format(Constants.DIAL_IN_MESSAGE, this.userId, super.time), Constants.OUTPUT_FILENAME);

        if (callbank.operators > 0){
            // If an operator is available than the call is accepted
            callbank.callsAccepted++; callbank.operators--;
            callbank.howLong = callbank.r.nextInt(callbank.averageLength) + 1;  // Get the duration of the call
            callbank.totalTimeConnected += callbank.howLong;    // Add that to the total time connected
            Utilities.OutputMessage(String.format(Constants.CONNECTION_MESSAGE, callbank.howLong), Constants.OUTPUT_FILENAME);
            super.time += callbank.howLong;

            // This finds the longest time a user is connected
            callbank.longestTimeConnected = callbank.howLong > callbank.longestTimeConnected ?
                    callbank.howLong :
                    callbank.longestTimeConnected;

            //Add new HangUp event to eventSet
            HangUp hangUp = new HangUp(this.userId, super.time);
            callbank.scheduleEvent(hangUp);
        } else {
            // If an operator is not available than reject the call
            callbank.callsRejected++;
            Utilities.OutputMessage(Constants.BUSY_MESSAGE, Constants.OUTPUT_FILENAME);
        }

        // Add the next call to the eventSet with a random time interval
        callbank.nextCall(callbank.r.nextInt(callbank.maxCallInterval)+1);
    }
}
