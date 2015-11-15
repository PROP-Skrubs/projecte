package Testers;


import CapaDomini.*;
import CapaVista.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by oriol on 7/11/15.
 */
public class DriverCreadorHidatos {
    public void main() {
        System.out.println("Generador de Hidatos:");
        while(true){
            System.out.println("Introdueix una comana:");
            System.out.println("\t- 1: Generar Hidato aleatori");
            System.out.println("\t- 2: Generar Hidato manualment");
            System.out.println("\t- x: Sortir generador Hidatos");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("1")){
                capt = new Scanner(System.in);
                System.out.println("Introdueix tamany hidato:");
                int n = capt.nextInt();
                while (n < 3 | n > 10) {
                    System.out.println("Tamany no valid, introdueix una altra");
                    n = capt.nextInt();
                }
                System.out.println("Introdueix numero forats:");
                int m = capt.nextInt();
                while ((m < 0 || m >(0.3*n*n))) {
                    System.out.println("Forats no valida, introdueix una altra");
                    m = capt.nextInt();
                }
                System.out.println("Introdueix numero valors predeterminats:");
                int x = capt.nextInt();
                while (x < 3 || x >(n*n-1)) {
                    System.out.println("Numero de valors no valid, introdueix una altra");
                    x = capt.nextInt();
                }
                System.out.println("Dificultat:");
                while (true) {
                    s = capt.nextLine();
                    if (s.equals("facil") || s.equals("normal") || s.equals("dificil") || s.equals("UltraViolence")) {
                        CapaDomini cd = new CapaDomini();
                        Tauler t = new Tauler();
                        TaulerComplert tc = new TaulerComplert();
                        t = cd.creacioTaulerPredeterminat(n, m, x, s, tc);
                        t.pintar_tauler();
                        tc.pintar_tauler();
                        break;
                    }
                    else System.out.println("Dificultat no valida [facil/normal/dificil/UltraViolence]");
                }

            }
            else if (s.equals("2")){
                capt = new Scanner(System.in);
                while (true) {
                    System.out.println("Vols utilitzar un arxiu per introduir el Hidato? [y/n]");
                    s = capt.nextLine();
                    if(s.equals("y")){;
                        Scanner scanner;
                        System.out.println("Selecciona arxiu:[1/2/3]");
                        s = capt.nextLine();
                        while (true) {
                            if (s.equals("1")) {
                                try {
                                    scanner = new Scanner(new File("hidato1.txt"));
                                } catch (FileNotFoundException e) {
                                    throw new RuntimeException("Arxiu no trobat", e);

                                }
                                break;
                            }
                            else if (s.equals("2")) {
                                try {
                                    scanner = new Scanner(new File("hidato2.txt"));
                                } catch (FileNotFoundException e) {
                                    throw new RuntimeException("Arxiu no trobat", e);

                                }
                                break;
                            }
                            else if (s.equals("3")) {
                                try {
                                    scanner = new Scanner(new File("hidato3.txt"));
                                } catch (FileNotFoundException e) {
                                    throw new RuntimeException("Arxiu no trobat", e);

                                }
                                break;
                            }
                            else System.out.println("Comana no valida");
                        }

                        Tauler t = new Tauler(scanner);
                        TaulerComplert  tc = new TaulerComplert();
                        int i = ValidadorTauler.validarTauler(t, tc);
                        t.pintar_tauler();

                    }
                    else {
                        System.out.println("Introdueix tamany hidato:");
                        int n = capt.nextInt();
                        while (n < 3 | n > 10) {
                            System.out.println("Tamany no valid, introdueix una altra");
                            n = capt.nextInt();
                        }
                        System.out.println("");
                    }
                }
            }
            else if (s.equals("x")){
                break;
            }
            else System.out.println("Comana no valida");
        }
    }


}
