
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Renos extends Thread {

    private Buffer reno;
    private int confirmarRegreso = 0;
    private int buclearLlegada = 0;
    private int conteoRenos = 0;

    public Renos(Buffer reno) {
        this.reno = reno;
    }

    public void run() {
        Random aleatorio = new Random();
        while (true) {
            int regreso = aleatorio.nextInt(2) + 1;
            int tiempo = aleatorio.nextInt(4) + 1;
            try {
                sleep(1000 * tiempo);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            if (regreso == 1) {
                if (confirmarRegreso != 1) {
                    confirmarRegreso = 1;
                    conteoRenos = reno.renoVacaciones(regreso);
                    System.out.println("El reno " + this.getName() + " ha llegado de vacaciones, se enganchó al trineo");
                    System.out.println("Renos disponibles: " + conteoRenos + "\n");
                   //buclearLlegada = 1;
                    if (conteoRenos == 9) {
                        reno.renosListos();
                    }
                    buclearLlegada = 0;
                } else {
                    if (buclearLlegada == 1) {
                        confirmarRegreso = 0;           
                    }
                }
            } else {
                if (confirmarRegreso == 0) {
                    System.out.println("El reno: " + this.getName() + " no está listo para trabajar \n");
                }
            }

        }
    }
    
    public void setBuclearLlegada(int buclearLlegada){
        this.buclearLlegada = buclearLlegada;
    }

    public void setConfirmarRegreso(int confirmarRegreso) {
        this.confirmarRegreso = confirmarRegreso;
    }

}
