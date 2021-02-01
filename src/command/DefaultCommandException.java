package command;

public class DefaultCommandException extends Exception{
    private boolean cliLock;
    public DefaultCommandException(String message) {
        super(message);
        this.cliLock = false;
    }
    public DefaultCommandException(String message, boolean lock) {
        super(message);
        this.cliLock = lock;
    }

    public boolean getCliLock() {
        return this.cliLock;
    }
}
