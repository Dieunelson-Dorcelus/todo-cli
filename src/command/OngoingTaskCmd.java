package command;

import cli.CLI;
import repository.Task;

public class OngoingTaskCmd extends Command{
    /**
     * Run command
     *
     * @param args
     */
    @Override
    public void run(String[] args) throws DefaultCommandException {
        String taskTitle = String.join(" ", args);
        if (CLI.SLOT.getTasks().keySet().contains(taskTitle)){
            Task task = CLI.SLOT.getTasks().get(taskTitle);
            task.setDone(false);
            CLI.print(taskTitle+" is ongoing !");
        }else{
            throw new DefaultCommandException("Task not found !", true);
        }
    }

    /**
     * Show help
     */
    @Override
    public void help() {

    }
}
