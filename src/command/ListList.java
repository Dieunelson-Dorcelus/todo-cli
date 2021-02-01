package command;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;

import cli.CLI;

public class ListList extends Command{
    /**
     * Run command
     *
     * @param args
     */
    @Override
    public void run(String[] args) {
        String[] lists = getLists();
        for (int i = -1; i < lists.length; i++) {
            if (i==-1){
                CLI.print("| Lists :");
            }else if(i==lists.length-1){
                CLI.print("'- " +  lists[i]);
            }else{
                CLI.print("|- " +  lists[i]);
            }
        }
    }

    public String[] getLists(){
        File f = new File(String.valueOf(Path.of(CLI.ROOT_APP + "/lists/")));

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".json");
            }
        };

        String[] lists = f.list();
        String[] result = new String[lists.length];

        for (int i = 0; i < lists.length; i++) {
            result[i] = lists[i].substring(0, lists[i].length()-5);
        }

        return result;
    }

    /**
     * Show help
     */
    @Override
    public void help() {

    }
}
