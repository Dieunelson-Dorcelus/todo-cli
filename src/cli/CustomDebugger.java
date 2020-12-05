package cli;

import java.util.Date;

/**
 * Custom class for debug
 */
public class CustomDebugger {

    /**
     * Log the message in the console
     * @param message
     */
    public static void print(String message){
        if (CLI.DEBUG_MODE){
            System.out.println("[DEBUG]( "+(new Date())+" )=> "+message);
        }
    }

    /**
     * Log the message in a file
     * @param message
     */
    public static void log(String message){
        // TODO : save the message in a log file
        System.out.println("[DEBUG]( "+(new Date())+" )=> "+message);
    }
}
