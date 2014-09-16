package com;

/**
 * Created by Daniel Newell on 9/14/2014.
 */
public class DialIn extends Event {

    public int userId;

    /**
     * This is the constructor.
     * @param userId
     * @param time
     */
    public DialIn(int userId, int time) {
        super.time = time;
        this.userId = userId;
    }

    /**
     * This is the definition of the process method for the DialIn object.
     * @param simulation
     */
    public void process (Simulation simulation) {
        CallBank callbank = (CallBank)simulation;
        callbank.callsDialedIn++;
        System.out.printf(Constants.DIAL_IN_MESSAGE, this.userId, super.time);
        if (callbank.operators > 0){
            callbank.callsAccepted++;
            callbank.operators--;
            callbank.howLong = callbank.r.nextInt(callbank.averageLength) + 1;
            System.out.printf(Constants.CONNECTION_MESSAGE, callbank.howLong);
            super.time += callbank.howLong;
            HangUp hangUp = new HangUp(this.userId, super.time);
            callbank.scheduleEvent(hangUp);
        } else {
            callbank.callsRejected++;
            System.out.print(Constants.BUSY_MESSAGE);
        }

        callbank.nextCall(callbank.callInterval);
    }


}
