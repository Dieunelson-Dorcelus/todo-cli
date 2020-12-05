package cli;

import command.Command;

import java.util.HashMap;

/**
 *  Interface de commande de l'application
 */
public class CLI {

    /**
     * App location
     */
    public static String ROOT_APP = System.getProperty("user.dir")+"/out/";

    /**
     * Active the debug mode
     */
    public static boolean DEBUG_MODE = false;

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
                cli.stop();
            }
        }else{
            CustomDebugger.print("Setup check failed !");
            Setup.install();
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
}
