package Testers;

import java.util.Scanner;

/**
 * Created by oriol on 12/11/15.
 */
public class DriverGestioPerfil {
    public static void main() {
        while (true) {
            System.out.println("Introdueix una comana:");
            System.out.println("\t- 1: Login Usuari");
            System.out.println("\t- 2: Crear Usuari");
            System.out.println("\t- 3: Entrar a al creador de Hidatos");
            System.out.println("\t- x: Sortir de Gestio de Perfil");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("x")) {
                break;
            }
            else if (s.equals("1")){
                System.out.println("Siusplau, introdueix el teu nom de usuari i contrassenya:");
                while (true){
                    boolean usr = false;
                    boolean pswrd = false;
                    System.out.println("Nom Usuari:");
                    capt = new Scanner(System.in);
                    s = capt.nextLine();
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
            else if (s.equals("2")){
                while(true){
                    System.out.println("Siusplau, introdueix nom usuari a crear:");
                    capt = new Scanner(System.in);
                    s = capt.nextLine();
                    if(/*comprobacio usr esta repetit*/){
                        System.out.println("Nom de usuari ja repetit, introdueix un altre nom.");
                    }
                    else break;
                }
                System.out.println("Siusplau, introdueix nom Real:");
                capt = new Scanner(System.in);
                String s2 = capt.nextLine();
                System.out.println("Siusplau, introdueix Contrassenya:");
                capt = new Scanner(System.in);
                String s3 = capt.nextLine();
            }
            else if (s.equals("3")){
                DriverCreadorHidatos dch = new DriverCreadorHidatos;
                dch.main();
            }
            else s.equals("Comana no valida");
        }
    }
}
