package CapaDomini;

import java.util.*;

/**
 * Created by Eduard on 15/12/15.
 */
public class Algoritmes {
    /**
     *  Donada una Llista de caselles donada per parametre d’entrada et modifica
     * aquesta llista perque et fiquin en primera posició els adjacents que estan
     * en les esquines o els que estan a un extrem del Tauler
     * @param Adjacents
     */

    public static final int OK = 0;
    public static final int ERRORTAMANY = 1;
    public static final int ERRORFORATS = 2;
    public static final int ERRORNUMPREDETERMINATS = 3;
    public static final int DIFICULTATINCORRECTA = 4;

    public static final int FACIL = 0;
    public static final int NORMAL = 1;
    public static final int DIFICIL = 2;



    private static void ordenaAdjacents(List<Casella> Adjacents)
    {
        ListIterator<Casella> it = Adjacents.listIterator();
        boolean acabat = false;
        while (it.hasNext() && !acabat)
        {
            int x = it.next().x;
            it.previous();
            int y = it.next().y;
            it.previous();
            int elem = it.next().elem;
            it.previous();
            int numadjacents = it.next().numadjlliures;
            if (x == 0 && y == 0)
            {
                int p = it.nextIndex() - 1;
                Casella aux = new Casella(x, y, elem, numadjacents);
                Adjacents.add(0, aux);
                acabat = true;
            }
            else if (x == 0 || y == 0)
            {
                int p = it.nextIndex() - 1;
                Casella aux = new Casella(x, y, elem, numadjacents);
                Adjacents.add(0, aux);
                acabat = true;
            }

        }


    }

    /**
     * Donat un tauler i una llista de enters et modifica el tauler ficant
     * un BUIT a l’element de cada casella que el seu valor no estigui
     * a la llista de enters
     * @param t
     * @param num_pre
     */
    private static void eliminarnumeros( Tauler t, List<Integer> num_pre){

        for (int i = 0; i < t.getTamany(); ++i) {
            for (int j = 0; j < t.getTamany(); ++j) {
                if(!num_pre.contains(t.getCasella(i, j).elem) && (t.getCasella(i, j).elem != -1)) {
                    t.setCasella(i,j,0,0);

                }
            }
        }

    }
    /**
     * Donat dos enters una Casella y dos taulers, t’emplena un tauler
     * completament amb un cami vàlid
     *
     * @param k contador del Backtracking
     * @param final1 final del contador del Backtracking
     * @param actual Casella on estas
     * @param t Tauler per on es genera
     * @param fin Cuando completas t lo pasas a fin para devolsver el tablero completo
     *
     * @return entero -1 si es para completar el tablero, 0 si es para volver por la recusividad
     */
    private static int backtrackingmayorde8(int k, int final1, Casella actual, Tauler t,  Tauler fin, int cont) {
        ++cont;
        if (cont >= 300) {
            return 3;
        }
        else {

            Random rnd = new Random();
            if (k == final1 - 1) {
                fin.clone(t);
                System.out.print("Contador de backtracking = " + cont + "\n");

                //            escriu(fin);
                return 0;
            } else {
                List<Casella> Adjacents = new ArrayList<Casella>();
                t.getAdjacentslist(actual, Adjacents);
                while (!Adjacents.isEmpty() && !fin.he_acabat()) {

                    //int p = numadjmespetit(Adjacents);
                    //Collections.sort(Adjacents, new Casella());
                    ordenaAdjacents(Adjacents);

                    //Collections.sort(Adjacents);
                    int kaux = k + 1;
                    Casella aux = Adjacents.get(0);
                    Adjacents.remove(0);

                    aux.elem = actual.elem + 1;

                    Tauler taux = new Tauler(t.getTamany());
                    taux.clone(t);
                    //                escriu(taux);
                    //              escriu(t);
                    taux.setCasella(aux.x, aux.y, aux.elem, t.getCasella(aux.x, aux.y).numadjlliures);
                    //            escriu(taux);
                    //taux.print();
                    //System.out.print("\n");
                    if (taux.he_acabat()) backtrackingmayorde8(kaux, final1, aux, taux, fin, ++cont);
                    else if (!taux.esPartit()) {
                        int auxret = backtrackingmayorde8(kaux, final1, aux, taux, fin, ++cont);
                        if (auxret == 0) return 0;
                        if (auxret == 3) return 3;
                    }

                }
                return -1;
            }
        }
    }

    /**
     * Donat dos enters una Casella y dos taulers, t’emplena un tauler
     * completament amb un cami vàlid
     *
     * @param k contador del Backtracking
     * @param final1 final del contador del Backtracking
     * @param actual Casella on estas
     * @param t Tauler per on es genera
     * @param fin Cuando completas t lo pasas a fin para devolsver el tablero completo
     *
     * @return entero -1 si es para completar el tablero, 0 si es para volver por la recusividad
     */
    private static int backtrackingmenor(int k, int final1, Casella actual, Tauler t,  Tauler fin, int cont) {

        ++cont;
        if (cont >= 300) {
            return 3;
        }
        else{


            Random rnd = new Random();
            if (k == final1 - 1) {
                fin.clone(t);
                System.out.print("Contador de backtracking = " + cont + "\n");
                //            escriu(fin);
                return 0;
            } else {
                List<Casella> Adjacents = new ArrayList<Casella>();
                t.getAdjacentslist(actual, Adjacents);
                while (!Adjacents.isEmpty() && !fin.he_acabat()) {

                    //int p = numadjmespetit(Adjacents);
                    //Collections.sort(Adjacents, new Casella());
                    Collections.sort(Adjacents);
                    int kaux = k + 1;
                    Casella aux = Adjacents.get(0);
                    Adjacents.remove(0);

                    aux.elem = actual.elem + 1;

                    Tauler taux = new Tauler(t.getTamany());
                    taux.clone(t);
                    //                escriu(taux);
                    //              escriu(t);
                    taux.setCasella(aux.x, aux.y, aux.elem, t.getCasella(aux.x, aux.y).numadjlliures);
                    //            escriu(taux);
                    //taux.print();
                    //System.out.print("\n");
                    if (taux.he_acabat()) backtrackingmenor(kaux, final1, aux, taux, fin, cont);
                    else if (!taux.esPartit()) {
                        int auxret = backtrackingmenor(kaux, final1, aux, taux, fin, cont);
                        if (auxret == 0) return 0;
                        if (auxret == 3) return 3;
                    }

                }
                return -1;
            }
        }
    }

    /**
     * Valida la entrada dels paràmetres dels generadors d'Hidatos aleatoris
     * @param n El tamany d'un costat del Hidato
     * @param m El nombre de Forats que hi haurà al Hidato
     * @param x El nombre de números predeterminats que hi haurà al Hidato
     * @return Retorna 0 (OK) si es tot OK, 1 (ERRORTAMANY) si el Tamany falla, 2 (ERRORFORATS) si el nombre de Forats falla i 3 (ERRORNUMPREDETERMINATS) si el nombre de numeros
     * prederminats no es el correcte.
     */
    public static int  validarparamscreacioTaulerpredeterminat(int n, int m, int x, int dificultat)
    {
        double minimPredeterminats,maximPredeterminats;
        switch (dificultat)
        {
            case DIFICIL:
            {
                minimPredeterminats = 0.75;
                maximPredeterminats = 0.82;
                break;
            }
            case NORMAL:
            {
                minimPredeterminats = 0.83;
                maximPredeterminats = 0.90;
                break;
            }
            case FACIL:
            {
                minimPredeterminats = 0.91;
                maximPredeterminats = 0.96;
                break;
            }
            default:
            {
                return DIFICULTATINCORRECTA;
            }
        }
        if (n < 3 || n > 10)
        {
            return ERRORTAMANY;
        }
        if (m < 0 || m > (0.3 * n * n))
        {
            return ERRORFORATS;
        }
        if (x < minimPredeterminats*(n*n-m) || x > maximPredeterminats*(n*n-m))
        {
            return ERRORNUMPREDETERMINATS;
        }
        return OK;
    }


    /**
     *
     * @param n
     * @param m
     * @param x
     * @param dificultat
     * @param retcomplert
     * @return Donat una "n" que serà el getTamany d'un costat del Tauler, donat una "m" que serà el nombre de "Forats" que hi
     *haurà al Tauler, donat una "x" que serà el nombre de números predetermints que tingui el Tauler y una "dificultat"
     *que serà el complicat que serà aquest. Retornarà un Tauler amb "m" Forats repartits aleatoriament, amb "x"-2
     *números escollits aleatoriament, el 1 i el n*n-m ficats al Tauler.
     */
    public static Tauler creacioTaulerPredeterminat(int n, int m, int x, String dificultat, TaulerComplert retcomplert)
    {
        int vuelta = 3;
        int intentsdedonarHidatobo = 0;
        int acabarbacktrackin = -1;
        Tauler ret = new Tauler(n);
        while (acabarbacktrackin != 0 && vuelta == 3 )
        {
            ++intentsdedonarHidatobo;
            Casella inicial = new Casella();

            Tauler t = new Tauler(n);
            Random rnd = new Random();
            int auxX;
            int auxY;

            //ficar_numadjlliures(t);
            boolean b = true;
            while(b) {
                for (int i = 0; i < m; ++i) { //poner de forma RANDOM els forats
                    auxX = rnd.nextInt(n);
                    auxY = rnd.nextInt(n);
                    if (t.getCasella(auxX, auxY).elem == -1) {
                        --i;
                    } else {
                        t.setCasella(auxX, auxY, Casella.FORAT, -1);
                    }
                }
                b = t.esPartit();
            }


            List<Integer> num_pre = new ArrayList<Integer>();
            List<Integer> num_pre_aux = new ArrayList<Integer>();

            for (int i = 2; i < n * n - m - 1; ++i) num_pre_aux.add(i);

            num_pre.add(1);
            for (int i = 0; i < x - 2; ++i)
            {
                int auxrnd = rnd.nextInt(num_pre_aux.size());
                num_pre.add(num_pre_aux.get(auxrnd));
                num_pre_aux.remove(auxrnd);
            }
            num_pre.add(n * n - m);


            boolean preparat = false;
            while (!preparat)
            { //ponemos el primero numero de forma random sin que caiga en un Forat
                auxX = rnd.nextInt(n);
                auxY = rnd.nextInt(n);
                if (t.getCasella(auxX, auxY).elem == 0)
                {
                    t.setCasella(auxX, auxY, num_pre.get(0), t.getCasella(auxX, auxY).numadjlliures); //Ponemos el numero 1 en alguna parte del tablero
                    preparat = true;
                    inicial.x = auxX;
                    inicial.y = auxY;
                    inicial.elem = num_pre.get(0);
                }

            }


            if (acabarbacktrackin == ValidadorTauler.NOMINMAX)
                throw new RuntimeException("No esta o el 1 o el numero maxim");
            if (acabarbacktrackin == ValidadorTauler.NOBENPOSADES)
                throw new RuntimeException("Els numeros no tenen l'adjacent continuu");
            if (acabarbacktrackin == ValidadorTauler.JARESOLT)
                throw new RuntimeException("L'Hidato propossat ja està resolt");
            if (acabarbacktrackin == ValidadorTauler.NOTESOL)
                throw new RuntimeException("L'Hidato propossat no té solució");
            if (acabarbacktrackin == ValidadorTauler.MULTIPLES && intentsdedonarHidatobo == 20)
                throw new RuntimeException("Els parametres donats no son suficients per donar un Hidato únic");
            int cont;
            cont = 0;


            if (n >= 7) vuelta = backtrackingmayorde8(0, n * n - m, inicial, t, ret, cont);
            else vuelta = backtrackingmenor(0, n * n - m, inicial, t, ret, cont);


            if (vuelta != 3) {
                eliminarnumeros(ret, num_pre);

                acabarbacktrackin = ValidadorTauler.validarTauler(ret, retcomplert);
            }

            System.out.print("acabarbacktrackin = " + acabarbacktrackin + "\n");


            System.out.print("Surto Backtracking:\n");

            ret.print();

        }
        return ret;
    }
}
