
import java.util.logging.Level;
import java.util.logging.Logger;

public class Santa extends Thread {

    private Buffer santa;
    private Duendes[] duende;
    private Renos[] reno;
    private int renosDisponibles = 0;
    private int duendesProblemas = 0;
    int confirmarTrabajoDuendes = 0;
    int confirmarVacacionesRenos = 0;

    public Santa(Buffer santa, Duendes[] duende, Renos[] reno) {
        this.santa = santa;
        this.duende = duende;
        this.reno = reno;
    }

    public void run() {
        while (true) {
            int confirmar = santa.santaDespierta();
 
            if (confirmar == 0) {
                for (int i = 0; i < duende.length; i++) {
                    duende[i].setBuclearTrabajo(1);
                }
                System.out.println("LOS DUENDES VUELVEN A TRABAJAR");
            }
            if (confirmar == 1) {
                for (int i = 0; i < reno.length; i++) {
                    reno[i].setBuclearLlegada(1);
                }
                System.out.println("LOS RENOS VUELVEN A TRABAJAR");
            }
        }
    }
}
