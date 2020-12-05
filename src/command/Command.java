package command;


/**
 * Command abstract class
 */
public abstract class Command {

    /**
     * Run command
     * @param args
     */
    public abstract void run(String[] args);

    /**
     * Show help
     */
    public abstract void help();

}
