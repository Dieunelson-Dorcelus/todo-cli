package command;

import cli.CLI;
import repository.Task;

public class ListTaskCmd extends Command{
    /**
     * Run command
     *
     * @param args
     */
    @Override
    public void run(String[] args) throws DefaultCommandException {
        try {
            for (String taskTitle: CLI.SLOT.getTasks().keySet()) {
                Task task = CLI.SLOT.getTasks().get(taskTitle);
                if (task.isDone()){
                    CLI.print("[X] "+ taskTitle);
                }else{
                    CLI.print("[ ] "+ taskTitle);
                }
            }
        }catch (Exception e){
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
