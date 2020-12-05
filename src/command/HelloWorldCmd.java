package command;

public class HelloWorldCmd extends Command{

    /**
     * Run command
     * @param args
     */
    @Override
    public void run(String[] args) {
        if (args.length>=1){
            switch (args[0]){
                case "--help" -> {
                    this.help();
                }
                default -> this.sayHello();
            }
        }else{
            this.sayHello();
        }
    }

    public void sayHello(){
        System.out.println("Hello world !");
    }

    /**
     * Show help
     */
    @Override
    public void help() {
        System.out.println("Show hello world");
    }
}
