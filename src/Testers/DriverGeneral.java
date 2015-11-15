package Testers;

import java.util.Scanner;

/**
 * Created by oriol on 12/11/15.
 */
public class DriverGeneral {
    public static void main(String[] args) {
        System.out.println("Benvinguts al Tester\n");
        while (true) {
            System.out.println("Introdueix una comanda:");
            System.out.println("\t-1 : Gestio Perfil");
            System.out.println("\t-2 : Gestio Partida");
            System.out.println("\t-3 : Gestio Estadistiques i Ranquing");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("x")) {
                break;
            }
            else if (s.equals("1")){
                DriverGestioPerfil.main();
            }
            else if (s.equals("2")){
                DriverGestioPartida.main();
            }
            else if (s.equals("3")){
                DriverGestEstRan.main();
            }

            else s.equals("Comana no valida");
        }
    }
}
