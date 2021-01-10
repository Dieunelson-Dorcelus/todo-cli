package command;

import cli.CLI;
import parser.ListParser;
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
    public void run(String[] args) {
        if (args.length>=1){
            switch (args[0]){
                case "--help" -> {
                    this.help();
                }
                default -> this.openList(args[0]);
            }
        }else{
            this.showForgetNameParameterError();
        }
    }

    private void openList(String name) {
        try {
            CLI.SLOT = (TaskList) CLI.DATASOURCE.getInstance( Path.of(CLI.ROOT_APP + "/lists/" + name + ".json"), new ListParser());
            CLI.LOCK = true;
            System.out.println("List : "+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
