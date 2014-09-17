package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by Daniel on 9/17/2014.
 */
public class Utilities {

    /**
     * This method decides whether you should be outputting to the console or the a file, and outputs the given message.
     * @param message
     */
    public static void OutputMessage(String message, String fileName){
        if(Constants.PRINT_TO_FILE){
            //If configured to print to a file proceed with this section
            try {
                File file = new File(fileName);
                BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
                output.write(message);
                output.close();
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        } else {
            //If configured to print to console proceed with this section
            System.out.print(message);
        }

    }
}
