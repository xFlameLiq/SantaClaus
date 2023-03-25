
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer {

    private boolean renoNoDisponible = false;
    private boolean duendeNoDisponible = false;
    private boolean santaNoDisponible = true;
    private int renosDisponibles = 0;
    private int duendeProblema = 0;
    private int duendeTrabajar = 0;

    public Buffer() {

    }

    public synchronized int santaDespierta() {
        while (this.santaNoDisponible) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            System.out.println("SANTA HA DESPERTADO");
            System.out.println("HOHOHO");
            if (this.renosDisponibles == 9) {
                this.renoNoDisponible = true;
                this.duendeNoDisponible = false;
                notifyAll();
                while (this.renosDisponibles != 0) {
                    this.renosDisponibles = 0;
                    System.out.println("SANTA HA SALIDO A REPARTIR LOS REGALOS");

                }
            }
            if (this.renosDisponibles == 0) {
                System.out.println("SANTA LLEVÓ TODOS LOS REGALOS.\n");
                this.renoNoDisponible = false;
                this.santaNoDisponible = true;
                notifyAll();
                return 1;
            }
            if (this.duendeProblema == 3) {
                this.duendeNoDisponible = true;
                this.renoNoDisponible = false;
                notifyAll();

                while (this.duendeProblema != 0) {
                    System.out.println("SANTA ESTÁ AYUDANDO A LOS DUENDES..." + "(Duende: " + this.duendeProblema + ")");
                    this.duendeProblema = this.duendeProblema - 1;
                }
            }
            if (this.duendeProblema == 0) {
                System.out.println("SANTA TERMINÓ DE AYUDAR A LOS DUENDES.\n");
                this.duendeTrabajar = 0;
                this.duendeNoDisponible = false;
                this.santaNoDisponible = true;

                notifyAll();

                return 0;
            }
        }
        return 2;
    }

    public synchronized int duendesProblema(int duendeAyuda) {
        while (this.duendeNoDisponible) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        try {
            sleep(500);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        this.duendeProblema = this.duendeProblema + duendeAyuda;
        return this.duendeProblema;
    }

    public synchronized int renoVacaciones(int renoNuevo) {
        while (this.renoNoDisponible) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        try {
            sleep(500);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        this.renosDisponibles = this.renosDisponibles + renoNuevo;
        return renosDisponibles;
    }

    public synchronized void renosListos() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        if (this.renosDisponibles == 9) {

            this.renoNoDisponible = true;
            this.santaNoDisponible = false;
            this.duendeNoDisponible = true;
            System.out.println("¡¡¡HAN LLEGADO TODOS LOS RENOS!!!");
            notifyAll();
        }
    }

    public synchronized void duendesConfirmarProblema() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        if (this.duendeProblema == 3) {

            this.duendeNoDisponible = true;
            this.santaNoDisponible = false;
            this.renoNoDisponible = true;
            System.out.println("¡¡¡LOS DUENDES SE ENCUENTRAN EN PROBLEMAS!!!");
            notifyAll();
        }
    }

    public void descansarRenos() {

    }

    public int getRenosDisponibles() {
        return renosDisponibles;
    }

    public int getDuendeProblema() {
        return duendeProblema;
    }

    public int getDuendeTrabajar() {
        return duendeTrabajar;
    }

    public void setDuendeTrabajar(int duendeTrabajar) {
        this.duendeTrabajar = duendeTrabajar;
    }

}
