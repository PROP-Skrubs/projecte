package CapaDomini;

import java.util.Queue;
import java.util.Random;

/**
 * Created by daniel on 12/10/15.
 */
public class CapaDomini
{

    private static int[] X = {0,1,1,0,-1,1,-1,-1};
    private static int[] Y = {1,0,1,-1,0,-1,1,-1};
    private static Queue q;

    public static void bubbleSort(int[] array) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public static boolean norepeticion(int[]numpre ) {
        //Pre : v esta ordenat;
        for(int i = 1; i < numpre.length ;++i){
            if(numpre[i] == numpre[i-1]) return false;
        }
        return true;
    }


    public static boolean backtracking(int k, int margen, Casella actual, Tauler t, boolean[][] mapabool)
    {
        Random rnd = new Random();
        if (k == margen) return true;
        else {
            boolean ya = false;
            while(!ya) {
                int p = rnd.nextInt(8);
                int auxX = actual.x + X[p];
                int auxY = actual.y + Y[p];

                if (t.esValid(auxX, auxY) && !mapabool[auxX][auxY]) {
                    Casella newaux = new Casella();

                    newaux.elem = actual.elem + 1;
                    newaux.x = auxX;
                    newaux.y = auxY;

                    if (t.pucacabar(newaux,mapabool)) {
                        t.setCasella(auxX, auxY, newaux.elem);
                        mapabool[auxX][auxY] = true;
                        backtracking(k+1, margen, newaux, t, mapabool);
                        ya = true;
                    }
                }
            }
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
        boolean[][] mapabool = new boolean[n][n];
        Casella inicial = new Casella();

        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                mapabool[i][j] = false;
            }
        }

        Tauler t = new Tauler(n);
        Random rnd = new Random();
        int auxX;
        int auxY;

        for (int i = 0; i <  n; ++i)   { //poner de forma RANDOM els forats
            auxX = rnd.nextInt(n);
            auxY = rnd.nextInt(n);
            if (mapabool[auxX][auxY]) { --i; }
            else { t.setCasella(auxX, auxY, Casella.FORAT);}
            mapabool[auxX][auxY] = true;
        }

        //mirarforatsvalids(t);
        boolean b = t.esPartit();
        if(b) {throw new RuntimeException("Els forats parteixen l'Hidato Sisplau Repetir Hitaro predeterminat");}

        int[] num_pre = new int[x];
        boolean preparat = false;
        while (!preparat){ //cogemos que numeros seran los que metamos en el CapaDomini.Tauler
            num_pre[0] = 1;
            num_pre[x] = n*n - m;

            for(int i = 1; i < x-1; ++i){
                num_pre[i] = rnd.nextInt(x-1);
            }
            bubbleSort(num_pre);

            if(norepeticion(num_pre)) { preparat = true;}


        }
        preparat = false;
        while (!preparat){ //ponemos el primero numero de forma random sin que caiga en un Forat
            auxX = rnd.nextInt(n);
            auxY = rnd.nextInt(n);
            if (!mapabool[auxX][auxY]){
                t.setCasella(auxX, auxY, num_pre[0]); //Ponemos el numero 1 en alguna parte del tablero
                preparat = true;
            }

        }
        for(int i = 1; i < num_pre.length; ++i){
            int margen = num_pre[i] - num_pre[i-1];
            int k = 0;
            inicial = t.buscarnumeromax();

            backtracking(k,margen,inicial,t,mapabool);

        }



        return t;
    }
}
