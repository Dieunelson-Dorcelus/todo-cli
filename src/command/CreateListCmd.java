package command;

import cli.CLI;
import parser.ListParser;
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
    public void run(String[] args) {
        if (args.length>=1){
            switch (args[0]){
                case "--help" -> {
                    this.help();
                }
                default -> {
                    try {
                        this.createList(args[0]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            this.showForgetNameParameterError();
        }
    }

    private void createList(String name) throws IOException {
        TaskList list = new TaskList(name);
        CLI.DATASOURCE.save(list, Path.of(CLI.ROOT_APP + "/lists/" + name + ".json"), new ListParser());
    }

    private void showForgetNameParameterError() {
        System.err.println("Name parameter is missing !");
    }

    /**
     * Show help
     */
    @Override
    public void help() {

    }
}
