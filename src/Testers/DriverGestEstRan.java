package Testers;

import java.util.Scanner;

/**
 * Created by oriol on 12/11/15.
 */
public class DriverGestEstRan
{
    public static void main()
    {
        while (true)
        {
            System.out.print("Introdueix Stub a probar:");
            Scanner capt = new Scanner(System.in);
            String s = capt.nextLine();
            if (s.equals("x"))
            {
                break;
            }
            else if (s.equals("Estadistiques"))
            {
                while (true)
                {
                    System.out.println("Introdueixi el numero de la consulta que vulgui realitzar:");
                    System.out.println("\t- 1: Lectura Estadistiques Usuari");
                    System.out.println("\t- 2: Lectura Estadistiques Hidatos resolts per dificultat");
                    System.out.println("\t- 3: Lectura Estadistiques Hidatos totals resolts");
                    System.out.println("\t- x: Sortir estadistiques");
                    s = capt.nextLine();
                    if (s.equals("1"))
                    {
                        System.out.println("\t-Lectura Estadistiques Usuari Maria");
                        System.out.println("\t Hidato -> 1    ::  Nº intents -> 3    ::  Nº cops resolt -> 1     :: Ratio -> 33.33%   ::  Temps mig -> 15 minuts");
                        System.out.println("\t Hidato -> 2    ::  Nº intents -> 10    ::  Nº cops resolt -> 3     :: Ratio -> 30%   ::  Temps mig -> 20 minuts");
                        System.out.println("\t Hidato -> 3    ::  Nº intents -> 4    ::  Nº cops resolt -> 4     :: Ratio -> 100%   ::  Temps mig -> 15 minuts");
                    }
                    else if (s.equals("2"))
                    {
                        System.out.println("Seleccioni les estadistiques que vol veure");
                        System.out.println("\t- 1: Lectura Estadistiques Hidato Easy");
                        System.out.println("\t- 2: Lectura Estadistiques Hidatos Medium");
                        System.out.println("\t- 3: Lectura Estadistiques Hidatos Difícil");
                        System.out.println("\t- 4: Lectura Estadistiques Hidatos Ultraviolence");
                        System.out.println("\t- x: Sortir estadistiques");
                        s = capt.nextLine();
                        if (s.equals("1"))
                        {
                            System.out.println("Ha seleccionat les estadistiques d'Hidatos Easy");
                            System.out.println("\t Hidato -> 1    ::  Nº intents -> 3    ::  Nº cops resolt -> 1     :: Ratio -> 3:1   ::  Temps mig -> 15 minuts");
                            System.out.println("\t Hidato -> 4    ::  Nº intents -> 8    ::  Nº cops resolt -> 7     :: Ratio -> 8:7   ::  Temps mig -> 25 minuts");
                            System.out.println("\t Hidato -> 5    ::  Nº intents -> 5    ::  Nº cops resolt -> 2     :: Ratio -> 5:2  ::  Temps mig -> 23 minuts");

                        }
                        else if (s.equals("2"))
                        {
                            System.out.println("Ha seleccionat les estadistiques d'Hidatos Medium");
                            System.out.println("\t Hidato -> 2    ::  Nº intents -> 10    ::  Nº cops resolt -> 3     :: Ratio -> 10:3   ::  Temps mig -> 20 minuts");
                            System.out.println("\t Hidato -> 3    ::  Nº intents -> 4    ::  Nº cops resolt -> 4     :: Ratio -> 4:4   ::  Temps mig -> 15 minuts");

                        }
                        else if (s.equals("3"))
                        {
                            System.out.println("Ha seleccionat les estadistiques d'Hidatos Dificil");
                            System.out.println("\t Hidato -> 6    ::  Nº intents -> 6    ::  Nº cops resolt -> 0     :: Ratio -> 6:0   ::  Temps mig -> 0 minuts");
                            System.out.println("\t Hidato -> 7    ::  Nº intents -> 7    ::  Nº cops resolt -> 3     :: Ratio -> 7:3   ::  Temps mig -> 6 minuts");
                            System.out.println("\t Hidato -> 11    ::  Nº intents -> 3    ::  Nº cops resolt -> 1     :: Ratio -> 3:1   ::  Temps mig -> 12 minuts");
                            System.out.println("\t Hidato -> 12    ::  Nº intents -> 12    ::  Nº cops resolt -> 0     :: Ratio -> 12:0   ::  Temps mig -> 0 minuts");
                            System.out.println("\t Hidato -> 14    ::  Nº intents -> 3    ::  Nº cops resolt -> 1     :: Ratio -> 3:1   ::  Temps mig -> 8 minuts");
                        }
                        else if (s.equals("4"))
                        {
                            System.out.println("Ha seleccionat les estadistiques d'Hidatos Ultraviolence");
                            System.out.println("\t Hidato -> 8    ::  Nº intents -> 4    ::  Nº cops resolt -> 0     :: Ratio -> 4:0   ::  Temps mig -> 0 minuts");
                            System.out.println("\t Hidato -> 9    ::  Nº intents -> 1    ::  Nº cops resolt -> 1     :: Ratio -> 1:1   ::  Temps mig -> 10 minuts");
                            System.out.println("\t Hidato -> 10    ::  Nº intents -> 13    ::  Nº cops resolt -> 6     :: Ratio -> 13:6   ::  Temps mig -> 15 minuts");
                            System.out.println("\t Hidato -> 13    ::  Nº intents -> 9    ::  Nº cops resolt -> 2     :: Ratio -> 9:2   ::  Temps mig -> 15 minuts");
                        }
                        else if (s.equals("x"))
                        {
                            break;
                        }
                    }
                    else if (s.equals("3"))
                    {
                        System.out.println("Ha seleccionat Lectura Estadistiques Hidatos totals resolts");
                        System.out.println("\t Hidato -> 1    ::  Nº intents -> 3    ::  Nº cops resolt -> 1     :: Ratio -> 3:1   ::  Temps mig -> 15 minuts");
                        System.out.println("\t Hidato -> 2    ::  Nº intents -> 10    ::  Nº cops resolt -> 3     :: Ratio -> 10:3   ::  Temps mig -> 20 minuts");
                        System.out.println("\t Hidato -> 3    ::  Nº intents -> 4    ::  Nº cops resolt -> 4     :: Ratio -> 4:4   ::  Temps mig -> 15 minuts");
                        System.out.println("\t Hidato -> 4    ::  Nº intents -> 0    ::  Nº cops resolt -> 0     :: Ratio -> 8:7   ::  Temps mig -> 25 minuts");
                        System.out.println("\t Hidato -> 5    ::  Nº intents -> 0    ::  Nº cops resolt -> 0     :: Ratio -> 5:2  ::  Temps mig -> 23 minuts");
                        System.out.println("\t Hidato -> 6    ::  Nº intents -> 0    ::  Nº cops resolt -> 0     :: Ratio -> 6:0   ::  Temps mig -> 0 minuts");
                        System.out.println("\t Hidato -> 7    ::  Nº intents -> 0    ::  Nº cops resolt -> 0     :: Ratio -> 7:3   ::  Temps mig -> 6 minuts");
                        System.out.println("\t Hidato -> 8    ::  Nº intents -> 0    ::  Nº cops resolt -> 0     :: Ratio -> 4:0   ::  Temps mig -> 0 minuts");
                        System.out.println("\t Hidato -> 9    ::  Nº intents -> 1    ::  Nº cops resolt -> 1     :: Ratio -> 1:1   ::  Temps mig -> 10 minuts");
                        System.out.println("\t Hidato -> 10    ::  Nº intents -> 0    ::  Nº cops resolt -> 0     :: Ratio -> 13:6   ::  Temps mig -> 15 minuts");
                        System.out.println("\t Hidato -> 11    ::  Nº intents -> 0    ::  Nº cops resolt -> 0     :: Ratio -> 3:1   ::  Temps mig -> 12 minuts");
                        System.out.println("\t Hidato -> 12    ::  Nº intents -> 0    ::  Nº cops resolt -> 0     :: Ratio -> 12:0   ::  Temps mig -> 0 minuts");
                        System.out.println("\t Hidato -> 13    ::  Nº intents -> 0    ::  Nº cops resolt -> 0     :: Ratio -> 9:2   ::  Temps mig -> 15 minuts");
                        System.out.println("\t Hidato -> 14    ::  Nº intents -> 0    ::  Nº cops resolt -> 0     :: Ratio -> 3:1   ::  Temps mig -> 8 minuts");

                    }
                    else if (s.equals("x"))
                    {
                        break;
                    }
                    else System.out.println("Comana no valida");
                }
            }

            else if (s.equals("Ranquing"))
            {
                while (true)
                {
                    System.out.println("Introdueixi el número de la consulta que vulgui realitzar:");
                    System.out.println("\t- 1: Lectura Ranquing de Usuaris per Hidato");
                    System.out.println("\t- 2: Lectura Ranquing de Hidatos");
                    System.out.println("\t- 3: Lectura  Ranquing de Persones per Dificultat");
                    System.out.println("\t- x: Lectura Sortir Ranquing");
                    s = capt.nextLine();
                    if (s.equals("1"))
                    {
                        System.out.println("Ha seleccionat Lectura Ranquing de Usuaris per Hidato");
                        System.out.println("\t Hidato -> 1 ");
                        System.out.println("\t\t Maria  ::  Temps mig -> 15 minuts  ::  Nº cops jugat-> 3");
                        System.out.println("\t\t Edu  ::  Temps mig -> 16 minuts  ::  Nº cops jugat-> 4");
                        System.out.println("\t\t Oriol  ::  Temps mig -> 16 minuts  ::  Nº cops jugat-> 4");
                        System.out.println("\t Hidato -> 2 ");
                        System.out.println("\t\t Lucas  ::  Temps mig -> 15 minuts  ::  Nº cops jugat-> 3");
                        System.out.println("\t\t Maria  ::  Temps mig -> 20 minuts  ::  Nº cops jugat-> 10");
                        System.out.println("\t\t Eva  ::  Temps mig -> 25 minuts  ::  Nº cops jugat-> 3");
                        System.out.println("\t Hidato -> 3 ");
                        System.out.println("\t\t Maria  ::  Temps mig -> 15 minuts  ::  Nº cops jugat-> 4");
                        System.out.println("\t Hidato -> 4 ");
                        System.out.println("\t Cap usuari ha jugat aquest hidato ");
                        System.out.println("\t Hidato -> 5 ");
                        System.out.println("\t Cap usuari ha jugat aquest hidato ");
                        System.out.println("\t Hidato -> 6 ");
                        System.out.println("\t Cap usuari ha jugat aquest hidato ");
                        System.out.println("\t Hidato -> 7 ");
                        System.out.println("\t Cap usuari ha jugat aquest hidato ");
                        System.out.println("\t Hidato -> 8 ");
                        System.out.println("\t Cap usuari ha jugat aquest hidato ");
                        System.out.println("\t Hidato -> 9 ");
                        System.out.println("\t\t Dani  ::  Temps mig -> 5 minuts  ::  Nº cops jugat-> 3");
                        System.out.println("\t\t Oriol  ::  Temps mig -> 7 minuts  ::  Nº cops jugat-> 4");
                        System.out.println("\t\t Edu  ::  Temps mig -> 8 minuts  ::  Nº cops jugat-> 7");
                        System.out.println("\t\t Maria  ::  Temps mig -> 12 minuts  ::  Nº cops jugat-> 8");
                        System.out.println("\t\t Lucas  ::  Temps mig -> 15 minuts  ::  Nº cops jugat-> 4");
                        System.out.println("\t\t Eva  ::  Temps mig -> 15 minuts  ::  Nº cops jugat-> 4");
                        System.out.println("\t Hidato -> 10 ");
                        System.out.println("\t Cap usuari ha jugat aquest hidato ");
                        System.out.println("\t Hidato -> 11 ");
                        System.out.println("\t Cap usuari ha jugat aquest hidato ");
                        System.out.println("\t Hidato -> 12 ");
                        System.out.println("\t Cap usuari ha jugat aquest hidato ");
                        System.out.println("\t Hidato -> 13 ");
                        System.out.println("\t Cap usuari ha jugat aquest hidato ");
                        System.out.println("\t Hidato -> 14 ");
                        System.out.println("\t Cap usuari ha jugat aquest hidato ");
                    }
                    else if (s.equals("2"))
                    {
                        System.out.println("Ha seleccionat Lectura Ranquing de Hidatos");
                        System.out.println("\t Hidato -> 3    ::  Nº intents -> 4    ::  Nº cops resolt -> 4     :: Ratio -> 4:4   ::  Temps mig -> 15 minuts");
                        System.out.println("\t Hidato -> 9    ::  Nº intents -> 1    ::  Nº cops resolt -> 1     :: Ratio -> 1:1   ::  Temps mig -> 10 minuts");
                        System.out.println("\t Hidato -> 2    ::  Nº intents -> 10   ::  Nº cops resolt -> 3     :: Ratio -> 10:3  ::  Temps mig -> 20 minuts");
                        System.out.println("\t Hidato -> 1    ::  Nº intents -> 3    ::  Nº cops resolt -> 1     :: Ratio -> 3:1   ::  Temps mig -> 15 minuts");
                    }
                    else if (s.equals("3"))
                    {
                        System.out.println("Ha seleccionat Lectura Ranquing de Persones per Dificultat");
                        System.out.println("Easy");
                        System.out.println("\t  Maria  ::   Nº Hidatos Comencats-> 2   ::  Nº Hidatos Resolts-> 2   Ratio -> 2:2");
                        System.out.println("\t  Edu    ::   Nº Hidatos Comencats-> 1   ::  Nº Hidatos Resolts-> 2   Ratio -> 2:2");
                        System.out.println("\t  Oriol  ::   Nº Hidatos Comencats-> 1   ::  Nº Hidatos Resolts-> 2   Ratio -> 2:2");
                        System.out.println("\t  Lucas  ::   Nº Hidatos Comencats-> 1   ::  Nº Hidatos Resolts-> 2   Ratio -> 2:2");
                        System.out.println("\t  Eva    ::   Nº Hidatos Comencats-> 1   ::  Nº Hidatos Resolts-> 2   Ratio -> 2:2");
                        System.out.println("Medium");
                        System.out.println("Dificil");
                        System.out.println("Ultraviolence");
                        System.out.println("\t\t Dani   ::   Nº Hidatos Comencats-> 1   ::  Nº Hidatos Resolts-> 2   Ratio -> 2:2");
                        System.out.println("\t\t Oriol  ::   Nº Hidatos Comencats-> 1   ::  Nº Hidatos Resolts-> 2   Ratio -> 2:2");
                        System.out.println("\t\t Edu    ::   Nº Hidatos Comencats-> 1   ::  Nº Hidatos Resolts-> 2   Ratio -> 2:2");
                        System.out.println("\t\t Maria  ::   Nº Hidatos Comencats-> 1   ::  Nº Hidatos Resolts-> 2   Ratio -> 2:2");
                        System.out.println("\t\t Lucas  ::   Nº Hidatos Comencats-> 1   ::  Nº Hidatos Resolts-> 2   Ratio -> 2:2");
                        System.out.println("\t\t Eva    ::   Nº Hidatos Comencats-> 1   ::  Nº Hidatos Resolts-> 2   Ratio -> 2:2");
                    }
                    else if (s.equals("x"))
                    {
                        break;
                    }
                    else s.equals("Comana no valida");
                }
            }
            else s.equals("Comana no valida");
        }
    }
}
