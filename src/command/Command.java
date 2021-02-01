package command;


import cli.CLI;

/**
 * Command abstract class
 */
public abstract class Command {
    /**
     * Run command
     * @param args
     */
    public abstract void run(String[] args) throws DefaultCommandException;

    public void execute(String[] args){
        try {
            run(args);
        }catch (DefaultCommandException exception){
            CLI.print(exception.getMessage());
            CLI.LOCK = false;
        }
    }

    /**
     * Show help
     */
    public abstract void help();

}
