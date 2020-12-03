package cli;

/**
 *  Interface de commande de l'application
 */
public class CLI {

    /**
     * Lieu d'installation de l'application
     */
    public static String ROOT_APP = System.getProperty("user.dir")+"/out/";

    /**
     * Methode de lancement
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Hello World");
        if (Setup.check()){
            System.out.println("We are ready !");
        }
    }
}
