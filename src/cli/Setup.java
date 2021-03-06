package cli;

import command.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

/**
 *  La classe setup va mettre en place l'arboressance de l'application
 */
public class Setup {

    public static String[] directories = {"lists", "logs"};

    /**
     * Verify if the app is ready
     * @return boolean
     */
    public static boolean check(){

        String root = CLI.ROOT_APP;

        for (String dir : Setup.directories) {
            if (!Files.exists(Path.of(CLI.ROOT_APP + "/" + dir))){
                return  false;
            }
        }

        return true;
    }

    /**
     * Return a dictionnary of all suported command
     * @return
     */
    public static HashMap<String, Command> supportedCommands(){

        HashMap<String, Command> commands = new HashMap<>();

        commands.put("hello", new HelloWorldCmd());
        commands.put("list", new CreateListCmd());
        commands.put("task", new CreateTaskCmd());
        commands.put("open", new OpenListCmd());
        commands.put("checklist", new ListTaskCmd());
        commands.put("tasklist", new ListTaskCmd());
        commands.put("done", new DoneTaskCmd());
        commands.put("ongoing", new OngoingTaskCmd());
        commands.put("exit", new ExitCmd());

        return commands;
    }

    /**
     * Install app
     */
    public static void install(){
        try {
            for (String dir : Setup.directories) {
                Files.createDirectories(Path.of(CLI.ROOT_APP + "/" + dir));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Uninstall app
     */
    public static void uninstall(){

    }
}
