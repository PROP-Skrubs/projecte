package Testers;

import java.util.Scanner;

/**
 * Created by oriol on 7/11/15.
 */
public class Ranquings {
    public static void main(String[] args) {
        System.out.println("Ranquings");
        while(true){
            System.out.println("Introdueix una comana:");
            System.out.println("\t- 1: Ranquing de Usuaris");
            System.out.println("\t- 2: Ranquing de Hidatos");
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
