package command;

import cli.CLI;
import parser.ListParser;
import repository.DataSource;
import repository.TaskList;

import java.io.IOException;
import java.nio.file.Path;

public class CreateListCmd extends Command{
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
                default -> {
                    try {
                        this.createList(args[0]);
                    } catch (IOException e) {
                        throw new DefaultCommandException(e.getMessage());
                    }
                }
            }
        }else{
            (new ListList()).run(args);
        }
    }

    private void createList(String name) throws IOException {
        TaskList list = new TaskList(name);
        DataSource.getInstance().save(list, Path.of(CLI.ROOT_APP + "/lists/" + name + ".json"), new ListParser());
        System.out.println(list);
    }

    /**
     * Show help
     */
    @Override
    public void help() {

    }
}
