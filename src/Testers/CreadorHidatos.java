package Testers;

import CapaDomini.CapaDomini;

import java.util.Scanner;

/**
 * Created by oriol on 7/11/15.
 */
public class CreadorHidatos {
    public void main() {
        System.out.println("Generador de Hidatos:");
        CapaDomini cd = new CapaDomini();
        while(true){
            System.out.println("Introdueix una comana:");
            System.out.println("\t- 1:Generar Hidato aleatori");
            System.out.println("\t- 2:Generar Hidato manualment");
            System.out.println("\t- x:Sortir generador Hidatos");
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
                        cd.creacioTaulerPredeterminat(n, m, x, s).pintar_tauler(1);

                        break;
                    }
                    else System.out.println("Dificultat no valida [facil/normal/dificil/UltraViolence]");
                }

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
