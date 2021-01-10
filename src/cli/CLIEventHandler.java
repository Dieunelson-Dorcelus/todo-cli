package cli;

import command.Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

public class CLIEventHandler implements ActionListener {

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //  Check if the event is trigger by a CLI
        if (!(e.getSource() instanceof CLI))return;
        // Check if the event exist
        if (CLIAction.values().length<=e.getID() || e.getID()<0)return;

        //  Get the CLI, the Action and the commandline
        CLI cli = (CLI) e.getSource();
        CLIAction action = CLIAction.values()[e.getID()];
        String commandLine = e.getActionCommand();

        switch (action){
            case Start -> this.onStart();
            case Stop -> this.onStop();
            case Update -> this.onUpdate();

            case Execute -> {
                CustomDebugger.print("CLI Execute");
                CustomDebugger.print("CommandLine : "+commandLine);

                String[] args_all = commandLine.split(" ");
                String[] args = Arrays.copyOfRange(args_all, 1, args_all.length);

                HashMap<String, Command> commands = cli.getCommands();
                if (commands.containsKey(args_all[0])){
                    commands.get(args_all[0]).run(args);
                }else{
                    //  Todo : throw error
                    CustomDebugger.print("This command no exist : "+args_all[0]);
                }
            }
        }
    }

    /**
     * When the CLI started
     */
    private void onStart(){
        CustomDebugger.print("CLI Start");
    }

    /**
     * When the CLI stoped
     */
    private void onStop(){
        CustomDebugger.print("CLI Stop");
    }

    /**
     * When the CLI update
     */
    private void onUpdate(){
        CustomDebugger.print("CLI Update");
    }
}
