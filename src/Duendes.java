
import java.util.Random;

public class Duendes extends Thread {

    private Buffer duende;
    private int confirmarProblema = 0;
    private int conteoDuendes = 0;
    private int buclearTrabajo = 0;

    public Duendes(Buffer duende) {
        this.duende = duende;
    }

    public void run() {
        Random aleatorio = new Random();
        while (true) {
            int ocupado = aleatorio.nextInt(2) + 1;
            int tiempo = aleatorio.nextInt(4) + 1;
            try {
                sleep(1500 * tiempo);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

            if (ocupado == 1) {
                if (confirmarProblema != 1) {
                    confirmarProblema = 1;
                    conteoDuendes = duende.duendesProblema(ocupado);
                    System.out.println("El duende " + this.getName() + " ha tenido problemas, necesita ayuda");
                    System.out.println("Duendes con problemas: " + conteoDuendes + "\n");
                   // buclearTrabajo = duende.trabajarDuendes();
                    if (conteoDuendes == 3) {
                        duende.duendesConfirmarProblema();
                    }
                    buclearTrabajo = 0;
                } else {
                    if (buclearTrabajo == 1) {
                        confirmarProblema = 0;
                    }
                }
            } else {
                if (confirmarProblema == 0) {
                    System.out.println("El duende: " + this.getName() + " realizó su juguete sin problemas\n");
                }
            }

        }
    }

    public int getBuclearTrabajo() {
        return buclearTrabajo;
    }

    public void setBuclearTrabajo(int buclearTrabajo) {
        this.buclearTrabajo = buclearTrabajo;
    }
    
    

    public Buffer getDuende() {
        return duende;
    }

    public void setDuende(Buffer duende) {
        this.duende = duende;
    }

    public int getConteoDuendes() {
        return conteoDuendes;
    }

    public void setConteoDuendes(int conteoDuendes) {
        this.conteoDuendes = conteoDuendes;
    }

    public int getConfirmarProblema() {
        return confirmarProblema;
    }

    public void setConfirmarProblema(int confirmarProblema) {
        this.confirmarProblema = confirmarProblema;
    }

}
