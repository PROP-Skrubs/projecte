package Testers;

import CapaDomini.Hidato;

import java.util.Scanner;

/**
 * Created by oriol on 5/11/15.
 */
public class DriverPartida {
    public static void main(String[] args) {
        Hidato h = new Hidato();
        boolean comensat = false;
        System.out.print("Benvinguts al Tester\n");
        while(true) {
            System.out.print("Introdueix una comanda:");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("x")){
                break;
            }
            if (s.equals("man")) {
                System.out.println("-Menu de ajuda:");
                System.out.println("-p: Imprimeix Hidato");
                System.out.println("-psol: Imprimeix solucio");
                System.out.println("-x: Sortir del Tester");
                System.out.println("-hidato play: Comensar partida");
                System.out.println("\t-add:  Afegir numero");
                System.out.println("\t-rm:   Eliminar numero");
                System.out.println("\t-help: Seguent numero");
                System.out.println("\t-stop: Sortir de la partida");
            }

            if (s.equals("p")){
                Imprimir_Hidato ih = new Imprimir_Hidato();
                System.out.print("Hidato actual:\n");
                ih.imprimir(h);
            }

            if (s.equals("hidato play")){
                if(t.comensat == true){
                    while(true) {
                        System.out.println("vols continuar amb la partida anterior? [y/n]");
                        s = capt.nextLine();
                        if (s.equals("n")) {
                            t.matrix_clear();
                            t.vector_clear();
                            t.pintar_hidato(2);
                            break;
                        } else if (s.equals("y")) {
                            Imprimir_Hidato ih = new Imprimir_Hidato();
                            ih.imprimir(h);
                            break;
                        } else System.out.println("Comana no valida");
                    }
                }
                else {
                    System.out.println("ha comensat una nova partida:");

                }
                while (true){
                    s = capt.nextLine();
                    if (s.equals("add")){
                        Afegir_Valor av = new Afegir_Valor();
                        av.afegir(h);
                    }

                    if (s.equals("rm")){
                        Remove_valor rv = new Remove_valor();
                        rv.remove(h);
                    }

                    if (s.equals("help")){
                        Ajudes a = new Ajudes();
                    }
                    if (s.equals("stop")) {
                        System.out.println("Partida pausada");
                        comensat = true;
                        break;
                    }
                }
            }



            else {
                System.out.print("Comanda no valida\n");
            }

        }
    }

}
