package CapaDomini;

import java.util.*;

/**
 * Created by daniel on 12/10/15.
 */
public class CapaDomini
{
    public static void eliminarnumeros( Tauler t, List<Integer> num_pre){
        for (int i = 0; i < t.tamany(); ++i) {
            for (int j = 0; j < t.tamany(); ++j) {
                if(!num_pre.contains(t.getCasella(i, j).elem) && (t.getCasella(i, j).elem != -1)) {
                    t.setCasella(i,j,0);
                }
            }
        }

    }


    public static void escriu(Tauler t) {
        for(int i = 0; i < t.tamany(); ++i) {
            for (int j = 0; j < t.tamany(); ++j){
                System.out.print("|");
                System.out.print(t.getCasella(i, j).elem);
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }

    public static void escriulist(List<Integer> list){

        for(int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
    }

    public static int backtracking(int k, int final1, Casella actual, Tauler t,  Tauler fin) {

        Random rnd = new Random();
        if (k == final1-1){
            fin.clone(t);
            return 0;
        }
        else {
            List<Casella> Adjacents = new ArrayList<Casella>();
            t.getAdjacentslist(actual, Adjacents);
            while (!Adjacents.isEmpty() && !fin.he_acabat()) {
                int kaux = k +1;
                int p = rnd.nextInt(Adjacents.size());
                Casella aux = Adjacents.get(p);
                Adjacents.remove(p);

                aux.elem = actual.elem+1;

                Tauler taux = new Tauler(t.tamany());
                taux.clone(t);
                taux.setCasella(aux.x, aux.y, aux.elem);

                if(taux.he_acabat()) backtracking(kaux,final1,aux,taux,fin);
                else  if(!taux.esPartit()) {
                    int auxret = backtracking(kaux,final1,aux,taux,fin);
                    if(auxret == 0) return 0;
                }

            }
            return -1;
        }
    }



    public static boolean validarparamscreacioTaulerpredeterminat(int n,int m, int x, String dificultat)
    {
        if (n < 3 || n > 10)
        {
            throw new RuntimeException("Nombre de costat no valid, inserti un altre");
        }
        if (m < 0 || m >(0.3*n*n))
        {
            throw new RuntimeException("Nombre de forats no vàlid, inserti un altre");
        }
        if (x < 3 || x >(n*n-1))
        {
            throw new RuntimeException("Nombre predeterminats no vàlid, inserti un altre");
        }
        if  ((dificultat.compareTo("facil") != 0) || (dificultat.compareTo("normal") != 0) || (dificultat.compareTo("dificil") != 0) || (dificultat.compareTo("UltraViolence") != 0) )
        {
            throw new RuntimeException("Dificultat no vàlida, inserti un altre");
        }
        return true;
    }

    public static Tauler creacioTaulerPredeterminat(int n, int m, int x, String dificultat)
    {
        /*
        Donat una "n" que serà el tamany d'un costat del Tauler, donat una "m" que serà el nombre de "Forats" que hi
        haurà al Tauler, donat una "x" que serà el nombre de números predetermints que tingui el Tauler y una "dificultat"
        que serà el complicat que serà aquest. Retornarà un Tauler amb "m" Forats repartits aleatoriament, amb "x"-2
        números escollits aleatoriament, el 1 i el n*n-m ficats al Tauler.
         */
        Casella inicial = new Casella();


        Tauler t = new Tauler(n);
        Random rnd = new Random();
        int auxX;
        int auxY;

        for (int i = 0; i <  m; ++i)   { //poner de forma RANDOM els forats
            auxX = rnd.nextInt(n);
            auxY = rnd.nextInt(n);
            if (t.getCasella(auxX,auxY).elem == -1 ) { --i; }
            else { t.setCasella(auxX, auxY, Casella.FORAT);}
        }
        escriu(t);
        boolean b = t.esPartit();
        if(b) {throw new RuntimeException("Els forats parteixen l'Hidato Sisplau Repetir Hitaro predeterminat");}


        List<Integer> num_pre = new ArrayList<Integer>();
        List<Integer> num_pre_aux = new ArrayList<Integer>();

        for (int i = 2; i < n*n-m-1; ++i) num_pre_aux.add(i);

        num_pre.add(1);
        for (int i = 0; i < x - 2; ++i) {
            int auxrnd = rnd.nextInt(num_pre_aux.size());
            num_pre.add(num_pre_aux.get(auxrnd));
            num_pre_aux.remove(auxrnd);
        }
        num_pre.add(n*n-m);


        escriulist(num_pre);
        boolean preparat = false;
        while (!preparat){ //ponemos el primero numero de forma random sin que caiga en un Forat
            auxX = rnd.nextInt(n);
            auxY = rnd.nextInt(n);
            if (t.getCasella(auxX,auxY).elem == 0){
                t.setCasella(auxX, auxY, num_pre.get(0)); //Ponemos el numero 1 en alguna parte del tablero
                preparat = true;
                inicial.x = auxX;
                inicial.y = auxY;
                inicial.elem = num_pre.get(0);
            }

        }
        escriu(t);

        System.out.print(inicial.x + " " + inicial.y + " " + inicial.elem + "\n");

        Tauler ret = new Tauler(t.tamany());

        backtracking(0, n * n - m, inicial, t, ret);

        System.out.print("Surto Backtracking:\n");
        escriu(ret);

        eliminarnumeros(ret, num_pre);

        escriu(ret);

        return ret;
    }
}
