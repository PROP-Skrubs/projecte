package Testers;

import java.util.Scanner;

/**
 * Created by oriol on 12/11/15.
 */
public class DriverGestEstRan {
    public static void main() {
        while (true) {
            System.out.print("Introdueix Stub a probar:");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("x")) {
                break;
            }
            else if (s.equals("estadistiques")) {
                while (true) {
                    System.out.println("Introdueix una comana:");
                    System.out.println("\t- 1: Lectura Estadistiques Usuari");
                    System.out.println("\t- 2: Lectura Estadistiques Hidatos resolts per dificultat");
                    System.out.println("\t- 3: Lectura Estadistiques Hidatos totals resolts");
                    System.out.println("\t- x: Sortir estadistiques");
                    s = capt.nextLine();
                    if (s.equals("1")) {

                    }
                    else if (s.equals("2")) {

                    }
                    else if (s.equals("x")) {
                        break;
                    }
                    else System.out.println("Comana no valida");
                }
            }

            else if (s.equals("ranquing")){
                while (true) {
                    System.out.println("Introdueix una comana:");
                    System.out.println("\t- 1: Lectura Ranquing de Usuaris");
                    System.out.println("\t- 2: Lectura Ranquing de Hidatos");
                    System.out.println("\t- x: Sortir Ranquing");
                    s = capt.nextLine();
                    if (s.equals("1")) {

                    }
                    else if (s.equals("2")) {

                    }
                    else if (s.equals("x")) {
                        break;
                    }
                    else s.equals("Comana no valida");
                }
            }
            else s.equals("Comana no valida");
        }
    }
}
