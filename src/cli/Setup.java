package cli;

import command.Command;
import command.HelloWorldCmd;

import java.util.HashMap;

/**
 *  La classe setup va mettre en place l'arboressance de l'application
 */
public class Setup {

    /**
     * Verify if the app is ready
     * @return boolean
     */
    public static boolean check(){

        String root = CLI.ROOT_APP;

        return true;
    }

    /**
     * Return a dictionnary of all suported command
     * @return
     */
    public static HashMap<String, Command> supportedCommands(){

        HashMap<String, Command> commands = new HashMap<>();

        commands.put("hello", new HelloWorldCmd());

        return commands;
    }

    /**
     * Install app
     */
    public static void install(){

    }

    /**
     * Uninstall app
     */
    public static void uninstall(){

    }
}
