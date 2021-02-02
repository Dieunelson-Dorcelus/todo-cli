package command;

import cli.CLI;
import parser.ListParser;
import repository.DataSource;
import repository.TaskList;

import java.io.IOException;
import java.nio.file.Path;

public class OpenListCmd extends Command{
    /**
     * Run command
     *
     * @param args
     */
    @Override
    public void run(String[] args) throws DefaultCommandException {
        if (args.length>=1){
            switch (args[0]){
                case "--help" -> {
                    this.help();
                }
                default -> this.openList(args[0]);
            }
        }else{
            throw new DefaultCommandException("Name parameter is missing !");
        }
    }

    private void openList(String name) throws DefaultCommandException {
        try {
            CLI.SLOT = (TaskList) DataSource.getInstance().getObject( Path.of(CLI.ROOT_APP + "/lists/" + name + ".json"), new ListParser());
            CLI.LOCK = true;
            CLI.print("List : "+name);
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
