package Testers;

import java.util.Scanner;

/**
 * Created by oriol on 7/11/15.
 */
public class Estadistiques {
    public static void main(String[] args) {
        System.out.println("Estadistiques");
        while(true){
            System.out.println("Introdueix una comana:");
            System.out.println("\t- 1: Estadistiques Usuari");
            System.out.println("\t- 2: Estadistiques Hidatos resolts per dificultat");
            System.out.println("\t- 3: Estadistiques Hidatos totals resolts");
            System.out.println("\t- x: Sortir generador Hidatos");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("1")){

            }
            else if (s.equals("2")){

            }
            else if (s.equals("x")){
                break;
            }
            else System.out.println("Comana no valida");
        }
    }
}

