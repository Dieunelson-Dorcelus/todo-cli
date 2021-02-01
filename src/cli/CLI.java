package cli;

import command.Command;
import repository.DataSource;
import repository.TaskList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 *  Interface de commande de l'application
 */
public class CLI {

    /**
     * App location
     */
    public static String ROOT_APP = System.getProperty("user.dir")+"/.todo";

    /**
     * Datasource
     */
    public static DataSource DATASOURCE = new DataSource();

    /**
     * Active the debug mode
     */
    public static boolean DEBUG_MODE = false;

    /**
     * Locker
     */
    public static boolean LOCK = false;

    /**
     * Locker
     */
    public static TaskList SLOT;

    /**
     * Event manager
     */
    private CLIEventHandler eventManager;

    /**
     * List of supported command
     */
    private HashMap<String, Command> commands;

    public CLI(HashMap<String, Command> commands){
        this.eventManager = new CLIEventHandler();
        this.commands = commands;
    }

    /**
     * Lauch method
     * @param args
     */
    public static void main(String[] args) {

        if (Setup.check()){
            CustomDebugger.print("Setup check passed !");
            CLI cli = new CLI(Setup.supportedCommands());

            //  If we not have the minimum args
            if (args.length<1){
                cli.help();
                return;
            }else{
                cli.start();
                String commandLine = "";
                for (String s : args){
                    commandLine+=s+" ";
                    if (s.contains("--debug")){
                        CLI.DEBUG_MODE = true;
                    }
                }
                cli.execute(commandLine);
                if (cli.LOCK){
                    Scanner sc= new Scanner(System.in);
                    while (cli.LOCK){
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        CLI.print(dtf.format(now)+" ["+CLI.SLOT.getName()+"] # ", false);
                        try {
                            commandLine = sc.nextLine();
                            cli.execute(commandLine);
                        }catch (Exception e){
                            CLI.print(e.getMessage());
                        }
                    }
                }

                cli.stop();
            }
        }else{
            CustomDebugger.print("Setup check failed !");
            CLI.print("Installing...");
            Setup.install();
            if (Setup.check()){
                CLI.print("Installation : OK");
            }else{
                CLI.print("Installation : FAILED");
            }
        }
    }

    /**
     * Start the CLI
     */
    public void start(){
        this.triggerEvent(CLIAction.Start, "start");
    }

    /**
     * Stop the CLI
     */
    public void stop(){
        this.triggerEvent(CLIAction.Stop, "stop");
    }

    /**
     * Execute a command line
     * @param commandline
     */
    public void execute(String commandline){
        this.triggerEvent(CLIAction.Execute, commandline);
    }

    /**
     * Trigger an event
     * @param action
     * @param commandLine
     */
    public void triggerEvent(CLIAction action, String commandLine){
        CLIEvent event = new CLIEvent(this, action.ordinal(), commandLine);
        this.eventManager.actionPerformed(event);
    }

    /**
     * Show all command supported by the CLI
     */
    public void help(){
        for (String name : this.commands.keySet()){
            CustomDebugger.print(name);
        }
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public static void print(String message){
        System.out.println(message);
    }
    public static void print(String message, boolean ln){
        if (ln){
            System.out.println(message);
        }else{
            System.out.print(message);
        }
    }

}
