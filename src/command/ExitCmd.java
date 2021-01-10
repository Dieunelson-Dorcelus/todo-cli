package command;

import cli.CLI;
import parser.ListParser;

import java.io.IOException;
import java.nio.file.Path;

public class ExitCmd extends Command{
    /**
     * Run command
     *
     * @param args
     */
    @Override
    public void run(String[] args) {
        try {
            if (CLI.SLOT!=null){
                CLI.DATASOURCE.save(CLI.SLOT, Path.of(CLI.ROOT_APP + "/lists/" + CLI.SLOT.getName() + ".json"), new ListParser());
            }
            CLI.LOCK = false;
            System.out.println("Bye !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show help
     */
    @Override
    public void help() {

    }
}
