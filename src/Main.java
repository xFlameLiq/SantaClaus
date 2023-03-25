
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        int duendesThread = 3, renosThread = 9, santaThread = 1;
        Buffer intermedio = new Buffer();
        Duendes[] duende = new Duendes[duendesThread];
        Renos[] reno = new Renos[renosThread];
        Santa[] santa = new Santa[santaThread];
        for (int i = 0; i < duende.length; i++) {
            duende[i] = new Duendes(intermedio);
        }
        for (int i = 0; i < reno.length; i++) {
            reno[i] = new Renos(intermedio);
        }
        for (int i = 0; i < santa.length; i++) {
            santa[i] = new Santa(intermedio, duende, reno);
        }

        for (int i = 0; i < santa.length; i++) {
            santa[i].start();
        }
        for (int i = 0; i < duende.length; i++) {
            duende[i].start();
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex);
           }
        }
        for (int i = 0; i < reno.length; i++) {
            reno[i].start();
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }

    }
}
