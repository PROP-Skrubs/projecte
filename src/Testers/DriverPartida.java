package Testers;

import CapaDomini.Hidato;
import CapaDomini.Partida;

import java.util.Scanner;

/**
 * Created by oriol on 5/11/15.
 */
public class DriverPartida {

    public void manual(){
        System.out.println("Menu de ajuda:");
        System.out.println("-creator: Creador de Hidatos");
        System.out.println("-hidato play: Comensar partida");
        System.out.println("\t-add:  Afegir numero");
        System.out.println("\t-rm:   Eliminar numero");
        System.out.println("\t-help1: Seguent numero");
        System.out.println("\t-help2: Possibles candidats");
        System.out.println("\t-stop: Sortir de la partida");
        System.out.println("-log: Loguin Usuari");
        System.out.println("-p: Imprimeix Hidato");
        System.out.println("-psol: Imprimeix solucio");
        System.out.println("-ran: Ranquings");
        System.out.println("-x: Sortir del Tester");
    }
    public static void main(String[] args) {
        System.out.print("Benvinguts al Tester\n");
        while(true) {
            System.out.print("Introdueix una comanda:");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("x")){
                break;
            }
            else if (s.equals("man")) {
                DriverPartida d = new DriverPartida();
                Partida p = new Partida();
                p.setIduser(1);
                p.setIduser(1);
                d.manual();
            }

            else if (s.equals("p")){
                Hidato h = new Hidato();
                System.out.print("Hidato actual:\n");
                h.getTauler().pintar_tauler();
            }

            else if (s.equals("hidato play")){

            }

            else if (s.equals("creator")){
                DriverCreadorHidatos ch = new DriverCreadorHidatos();
                ch.main();
            }

            else if (s.equals("log")){

            }

            else {
                System.out.print("Comanda no valida\n");
            }
        }
    }

}
