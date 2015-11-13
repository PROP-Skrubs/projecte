package Testers;

import java.util.Scanner;

/**
 * Created by oriol on 12/11/15.
 */
public class DriverGestioPerfil {
    public static void main() {
        while (true) {
            System.out.print("Introdueix Stub a probar:");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("x")) {
                break;
            }
            else if (s.equals("login usuari")){

            }
            else if (s.equals("crear usuari")){

            }
            else if (s.equals("creador hidatos")){

            }
            else s.equals("Comana no valida");
        }
    }
}
