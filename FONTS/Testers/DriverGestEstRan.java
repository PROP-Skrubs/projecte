package Testers;

import CapaPersistencia.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Aquesta classe es un stuck de lo que es Estadistiques i Ranking
 * @author Eduard J. Seoane
 */
public class DriverGestEstRan {
    public static void main() {
        while (true) {
            System.out.print("Introdueix Stub a probar:");
            System.out.print("\t- 1:Estadistiques");
            System.out.print("\t- 2:Ranquing");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("x")) {
                break;
            }
            else if (s.equals("1")) {
                while (true) {
                    System.out.println("Estadstiques");
                    System.out.println("Introdueixi el numero de la consulta que vulgui realitzar:");
                    System.out.println("\t- 1: Lectura Estadistiques Usuari");
                    System.out.println("\t- 2: Lectura Estadistiques Hidatos resolts per dificultat");
                    System.out.println("\t- 3: Lectura Estadistiques Hidatos totals resolts");
                    System.out.println("\t- x: Sortir estadistiques");
                    s = capt.nextLine();
                    if (s.equals("1")) {
                        System.out.println("\t-Lectura Estadistiques Usuari Maria");
                        System.out.println("\t Hidato -> 1    ::  N. intents -> 3    ::  N. cops resolt -> 1     :: Ratio -> 1:3   ::  Temps mig -> 15 minuts");
                        System.out.println("\t Hidato -> 2    ::  N. intents -> 10   ::  N. cops resolt -> 3     :: Ratio -> 3:10  ::  Temps mig -> 20 minuts");
                        System.out.println("\t Hidato -> 3    ::  N. intents -> 4    ::  N. cops resolt -> 4     :: Ratio -> 4:4   ::  Temps mig -> 15 minuts");
                    }
                    else if (s.equals("2")) {
                        System.out.println("Seleccioni les estadistiques que vol veure");
                        System.out.println("\t- 1: Lectura Estadistiques Hidato Easy");
                        System.out.println("\t- 2: Lectura Estadistiques Hidatos Medium");
                        System.out.println("\t- 3: Lectura Estadistiques Hidatos Dificult");
                        System.out.println("\t- 4: Lectura Estadistiques Hidatos Ultraviolence");
                        System.out.println("\t- x: Sortir estadistiques");
                        s = capt.nextLine();
                        if(s.equals("1")){
                            System.out.println("Ha seleccionat les estadistiques d'Hidatos Easy");
                            System.out.println("\t Hidato -> 1    ::  N. intents -> 11   ::   N. cops resolt -> 1     :: Ratio -> 1:11  ::  Temps mig -> 15 minuts");
                            System.out.println("\t Hidato -> 4    ::  N. intents -> 8    ::   N. cops resolt -> 7     :: Ratio -> 7:8   ::  Temps mig -> 25 minuts");
                            System.out.println("\t Hidato -> 5    ::  N. intents -> 5    ::   N. cops resolt -> 2     :: Ratio -> 2:5   ::  Temps mig -> 23 minuts");

                        }
                        else if(s.equals("2")){
                            System.out.println("Ha seleccionat les estadistiques d'Hidatos Medium");
                            System.out.println("\t Hidato -> 2    ::   N. intents -> 16   ::   N. cops resolt -> 3     :: Ratio -> 3:16  ::  Temps mig -> 20 minuts");
                            System.out.println("\t Hidato -> 3    ::   N. intents -> 4    ::   N. cops resolt -> 4     :: Ratio -> 4:4   ::  Temps mig -> 15 minuts");

                        }
                        else if(s.equals("3")){
                            System.out.println("Ha seleccionat les estadistiques d'Hidatos Dificil");
                            System.out.println("\t Hidato -> 6     ::   N. intents -> 0    ::   N. cops resolt -> 0     :: Ratio -> 0:0   ::  Temps mig -> 0 minuts");
                            System.out.println("\t Hidato -> 7     ::   N. intents -> 7    ::   N. cops resolt -> 3     :: Ratio -> 3:7   ::  Temps mig -> 6 minuts");
                            System.out.println("\t Hidato -> 11    ::   N. intents -> 3    ::   N. cops resolt -> 1     :: Ratio -> 1:3   ::  Temps mig -> 12 minuts");
                            System.out.println("\t Hidato -> 12    ::   N. intents -> 0    ::   N. cops resolt -> 0     :: Ratio -> 0:0   ::  Temps mig -> 0 minuts");
                            System.out.println("\t Hidato -> 14    ::   N. intents -> 3    ::   N. cops resolt -> 1     :: Ratio -> 1:3   ::  Temps mig -> 8 minuts");
                        }
                        else if(s.equals("4")){
                            System.out.println("Ha seleccionat les estadistiques d'Hidatos Ultraviolence");
                            System.out.println("\t Hidato -> 8     ::   N. intents -> 0    ::   N. cops resolt -> 0     :: Ratio -> 0:0   ::  Temps mig -> 0 minuts");
                            System.out.println("\t Hidato -> 9     ::   N. intents -> 26   ::   N. cops resolt -> 26    :: Ratio -> 26:26 ::  Temps mig -> 10 minuts");
                            System.out.println("\t Hidato -> 10    ::   N. intents -> 13   ::   N. cops resolt -> 6     :: Ratio -> 6:13  ::  Temps mig -> 15 minuts");
                            System.out.println("\t Hidato -> 13    ::   N. intents -> 9    ::   N. cops resolt -> 2     :: Ratio -> 2:9   ::  Temps mig -> 15 minuts");
                        }
                        else if(s.equals("x")){
                            break;
                        }
                    }
                    else if (s.equals("3")) {
                        System.out.println("Ha seleccionat Lectura Estadistiques Hidatos totals resolts");
                        System.out.println("\t Hidato -> 1    ::   N. intents -> 11   ::   N. cops resolt -> 1     ::   Ratio -> 1:11     ::  Temps mig -> 15 minuts");
                        System.out.println("\t Hidato -> 2    ::   N. intents -> 16   ::   N. cops resolt -> 3     ::   Ratio -> 3:16     ::  Temps mig -> 20 minuts");
                        System.out.println("\t Hidato -> 3    ::   N. intents -> 4    ::   N. cops resolt -> 4     ::   Ratio -> 4:4      ::  Temps mig -> 15 minuts");
                        System.out.println("\t Hidato -> 4    ::   N. intents -> 8    ::   N. cops resolt -> 7     ::   Ratio -> 7:8      ::  Temps mig -> 25 minuts");
                        System.out.println("\t Hidato -> 5    ::   N. intents -> 5    ::   N. cops resolt -> 2     ::   Ratio -> 2:5      ::  Temps mig -> 23 minuts");
                        System.out.println("\t Hidato -> 6    ::   N. intents -> 0    ::   N. cops resolt -> 0     ::   Ratio -> 0:0      ::  Temps mig -> 0 minuts");
                        System.out.println("\t Hidato -> 7    ::   N. intents -> 7    ::   N. cops resolt -> 3     ::   Ratio -> 3:7      ::  Temps mig -> 6 minuts");
                        System.out.println("\t Hidato -> 8    ::   N. intents -> 0    ::   N. cops resolt -> 0     ::   Ratio -> 0:0      ::  Temps mig -> 0 minuts");
                        System.out.println("\t Hidato -> 9    ::   N. intents -> 26   ::   N. cops resolt -> 26    ::   Ratio -> 26:26    ::  Temps mig -> 10 minuts");
                        System.out.println("\t Hidato -> 10   ::   N. intents -> 13   ::   N. cops resolt -> 6     ::   Ratio -> 6:13     ::  Temps mig -> 15 minuts");
                        System.out.println("\t Hidato -> 11   ::   N. intents -> 3    ::   N. cops resolt -> 1     ::   Ratio -> 1:3      ::  Temps mig -> 12 minuts");
                        System.out.println("\t Hidato -> 12   ::   N. intents -> 0    ::   N. cops resolt -> 0     ::   Ratio -> 0:0      ::  Temps mig -> 0 minuts");
                        System.out.println("\t Hidato -> 13   ::   N. intents -> 9    ::   N. cops resolt -> 2     ::    Ratio -> 2:9     ::  Temps mig -> 15 minuts");
                        System.out.println("\t Hidato -> 14   ::   N. intents -> 3    ::   N. cops resolt -> 1     ::   Ratio -> 1:3      ::  Temps mig -> 8 minuts");
                    }
                    else if (s.equals("x")) {
                        break;
                    }
                    else System.out.println("Comana no valida");
                }
            }

            else if (s.equals("2")){
                while (true) {
                    System.out.println("Ranquing Top 10");
                    System.out.println("Introdueixi el numero de la consulta que vulgui realitzar:");
                    System.out.println("\t- 1: Lectura Ranquing de Usuaris per Hidato");
                    System.out.println("\t- 2: Lectura Ranquing de Hidatos");
                    System.out.println("\t- 3: Lectura  Ranquing de Persones per Dificultat");
                    System.out.println("\t- x: Lectura Sortir Ranquing");
                    if (s.equals("1")) {
                        System.out.println("Ha seleccionat Lectura Ranquing de Usuaris per Hidato");
                        System.out.println("\t Introdueix id Hidato:");
                        int id = capt.nextInt();
                        GestorRanking gr = new GestorRanking();
                        ArrayList<Integer> array = gr.getIdUsuarisPerHidato(id);
                        System.out.println("\t Ranquing de Usuaris amb Hidato = " + id);
                        for (int i = 0; i < array.size(); ++i){
                            System.out.println("\t\t" + i +  "-> " +  array.get(i) );
                        }
                    }
                    else if (s.equals("2")) {
                        System.out.println("Ha seleccionat Lectura Ranquing de Hidatos");
                        GestorRanking gr = new GestorRanking();
                        ArrayList<Integer> array = gr.getIdHidatosMesCopsResolts();
                        System.out.println("\t HidatoS mes cops resolt ");
                        for (int i = 0; i < array.size(); ++i){
                            System.out.println("\t\t" + i +  "-> " +  array.get(i) );
                        }
                    }
                    else if (s.equals("3")) {
                        System.out.println("Ha seleccionat Lectura Ranquing de Persones per Dificultat");
                        System.out.println("\t Introdueix dificultat:");
                        s = capt.nextLine();
                        GestorRanking gr = new GestorRanking();
                        ArrayList<Integer> array = gr.getIdUsuarisPerDificultat(s);
                        System.out.println("\t Ranquing de Usuaris amb dificultat = " + s);
                        for (int i = 0; i < array.size(); ++i){
                            System.out.println("\t\t" + i +  "-> " +  array.get(i) );
                        }
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
