package command;

import cli.CLI;
import parser.ListParser;
import repository.DataSource;

import java.io.IOException;
import java.nio.file.Path;

public class ExitCmd extends Command{
    /**
     * Run command
     *
     * @param args
     */
    @Override
    public void run(String[] args) throws DefaultCommandException {
        try {
            if (CLI.SLOT!=null){
                DataSource.getInstance().save(CLI.SLOT, Path.of(CLI.ROOT_APP + "/lists/" + CLI.SLOT.getName() + ".json"), new ListParser());
            }
            CLI.LOCK = false;
            CLI.print("Bye !");
        } catch (IOException e) {
            throw new DefaultCommandException(e.getMessage());
        }
    }

    /**
     * Show help
     */
    @Override
    public void help() {

    }
}
