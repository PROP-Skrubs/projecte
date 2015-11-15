package Testers;


import CapaDomini.CapaDomini;
import CapaDomini.Tauler;
import CapaDomini.TaulerComplert;
import CapaDomini.ValidadorTauler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by oriol on 7/11/15.
 */
public class DriverCreadorHidatos {
    public static void main(String[] args) {
        System.out.println("Generador de Hidatos:");
        while (true) {
            System.out.println("Introdueix una comana:");
            System.out.println("\t- 1: Generar Hidato aleatori");
            System.out.println("\t- 2: Generar Hidato manualment");
            System.out.println("\t- x: Sortir generador Hidatos");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("1")) {
                capt = new Scanner(System.in);
                System.out.println("Introdueix tamany hidato:");
                int n = capt.nextInt();
                while (n < 3 | n > 10) {
                    System.out.println("Tamany no valid, introdueix una altra");
                    n = capt.nextInt();
                }
                System.out.println("Introdueix numero forats:");
                int m = capt.nextInt();
                while ((m < 0 || m > (0.3 * n * n))) {
                    System.out.println("Forats no valida, introdueix una altra");
                    m = capt.nextInt();
                }
                System.out.println("Introdueix numero valors predeterminats:");
                int x = capt.nextInt();
                while (x < 3 || x > (n * n - 1)) {
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
                        System.out.print("\n");
                        tc.pintar_tauler();
                        break;
                    } else System.out.println("Dificultat no valida [facil/normal/dificil/UltraViolence]");
                }

            } else if (s.equals("2")) {
                capt = new Scanner(System.in);
                System.out.println("S'utilitzara arxius predeterminats per aquesta fase de testeig");
                Scanner scanner;
                while (true) {
                    System.out.println("Selecciona arxiu:[1/2/3]");
                    s = capt.nextLine();
                    if (s.equals("1")) {
                        try {
                            scanner = new Scanner(new File("./src/Testers/hidato1"));
                        } catch (FileNotFoundException e) {
                            System.out.println(System.getProperty("user.dir"));
                            throw new RuntimeException("Arxiu no trobat", e);

                        }
                        break;
                    } else if (s.equals("2")) {
                        try {
                            scanner = new Scanner(new File("./src/Testers/hidato2"));
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException("Arxiu no trobat", e);

                        }
                        break;
                    } else if (s.equals("3")) {
                        try {
                            scanner = new Scanner(new File("./src/Testers/hidato3"));
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException("Arxiu no trobat", e);

                        }
                        break;
                    } else System.out.println("Comana no valida");
                }
                Tauler t = new Tauler(scanner);
                TaulerComplert tc = new TaulerComplert();
                System.out.println("li passo el seguent tauler");
                t.print();
                System.out.println("//////////////////////////////////////////////////////////");
                int i = ValidadorTauler.validarTauler(t, tc);
                t.pintar_tauler();
                System.out.println(i);
                tc.pintar_tauler();


            }
            else if (s.equals("x")) break;
            else System.out.println("Comana no valida");
        }
    }
}
