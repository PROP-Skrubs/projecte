package Testers;

import java.util.Scanner;

/**
 * Created by oriol on 7/11/15.
 */
public class LoginUsuari {
    public static void main(String[] args) {
        System.out.println("Siusplau, introdueix el teu nom de usuari i contrassenya:");
        while (true){
            boolean usr = false;
            boolean pswrd = false;
            System.out.println("Nom Usuari:");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            //
            System.out.println("Contrassenya:");
            capt = new Scanner(System.in);
            String s2 = capt.nextLine();
            //
            if(usr = false){
                System.out.println("Nom de usuari incorrecte");
            }
            if(pswrd = false){
                System.out.println("Constrassenya incorrecte");
            }
            if(usr == true && pswrd == true) break;

        }
        System.out.print("Loguin Realitzat correctament");
    }
}
