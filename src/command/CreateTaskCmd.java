package command;

import cli.CLI;
import repository.Task;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CreateTaskCmd extends Command{
    
    /**
     * Run command
     *
     * @param args
     */
    @Override
    public void run(String[] args) {
        String title;
        String description = null;
        boolean end = false;
        Scanner sc= new Scanner(System.in);
        if (args.length==1){
            title = args[0];
        } else if (args.length==2){
            title = args[0];
            description = args[1];
        }else{
            System.out.print("Title : ");
            title = sc.nextLine();
            System.out.print("Description : ");
            description = sc.nextLine();
        }
        CLI.SLOT.create(new Task(title, description));
        
    }

    /**
     * Show help
     */
    @Override
    public void help() {

    }
}
