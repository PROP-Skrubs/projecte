package CapaDomini;
import java.util.*;

/**
 * Created by daniel on 12/10/15.
 */
public class CapaDomini
{
    public static void ordenaAdjacents(List<Casella> Adjacents){

        ListIterator<Casella> it= Adjacents.listIterator();
        boolean acabat = false;
        while(it.hasNext() && !acabat) {
            int x = it.next().x;
            it.previous();
            int y = it.next().y;
            it.previous();
            int elem = it.next().elem;
            it.previous();
            int numadjacents = it.next().numadjlliures;
            if(x == 0 && y == 0){
                int p = it.nextIndex() - 1;
                Casella aux = new Casella(x,y,elem,numadjacents);
                Adjacents.add(0,aux);
                acabat = true;
            }
            else if (x == 0 || y == 0){
                int p = it.nextIndex() - 1;
                Casella aux = new Casella(x,y,elem,numadjacents);
                Adjacents.add(0,aux);
                acabat = true;
            }

        }


    }
    public static void eliminarnumeros( Tauler t, List<Integer> num_pre){
        for (int i = 0; i < t.getTamany(); ++i) {
            for (int j = 0; j < t.getTamany(); ++j) {
                if(!num_pre.contains(t.getCasella(i, j).elem) && (t.getCasella(i, j).elem != -1)) {
                    t.setCasella(i,j,0,0);
                }
            }
        }

    }


    public static void escriulist(List<Integer> list){

        for(int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
    }


    public static int backtrackingmayorde8(int k, int final1, Casella actual, Tauler t,  Tauler fin) {

        Random rnd = new Random();
        if (k == final1-1){
            fin.clone(t);
//            escriu(fin);
            return 0;
        }
        else {
            List<Casella> Adjacents = new ArrayList<Casella>();
            t.getAdjacentslist(actual, Adjacents);
            while (!Adjacents.isEmpty() && !fin.he_acabat()) {

                //int p = numadjmespetit(Adjacents);
                //Collections.sort(Adjacents, new Casella());
                ordenaAdjacents(Adjacents);

                //Collections.sort(Adjacents);
                int kaux = k +1;
                Casella aux = Adjacents.get(0);
                Adjacents.remove(0);

                aux.elem = actual.elem +1;

                Tauler taux = new Tauler(t.getTamany());
                taux.clone(t);
//                escriu(taux);
                //              escriu(t);
                taux.setCasella(aux.x, aux.y, aux.elem,t.getCasella(aux.x,aux.y).numadjlliures);
                //            escriu(taux);

                if(taux.he_acabat()) backtrackingmayorde8(kaux,final1,aux,taux,fin);
                else  if(!taux.esPartit()) {
                    int auxret = backtrackingmayorde8(kaux,final1,aux,taux,fin);
                    if(auxret == 0) return 0;
                }

            }
            return -1;
        }
    }


    public static int backtrackingmayor(int k, int final1, Casella actual, Tauler t,  Tauler fin) {

        Random rnd = new Random();
        if (k == final1-1){
            fin.clone(t);
//            escriu(fin);
            return 0;
        }
        else {
            List<Casella> Adjacents = new ArrayList<Casella>();
            t.getAdjacentslist(actual, Adjacents);
            while (!Adjacents.isEmpty() && !fin.he_acabat()) {

                //int p = numadjmespetit(Adjacents);
                //Collections.sort(Adjacents, new Casella());
                ordenaAdjacents(Adjacents);

                //Collections.sort(Adjacents);
                int kaux = k +1;
                Casella aux = Adjacents.get(0);
                Adjacents.remove(0);

                aux.elem = actual.elem +1;

                Tauler taux = new Tauler(t.getTamany());
                taux.clone(t);
//                escriu(taux);
                //              escriu(t);
                taux.setCasella(aux.x, aux.y, aux.elem,t.getCasella(aux.x,aux.y).numadjlliures);
                //            escriu(taux);

                if(taux.he_acabat()) backtrackingmayor(kaux, final1, aux, taux, fin);
                else  if(!taux.esPartit()) {
                    int auxret = backtrackingmenor(kaux, final1, aux, taux, fin);
                    if(auxret == 0) return 0;
                }

            }
            return -1;
        }
    }


    public static int backtrackingmenor(int k, int final1, Casella actual, Tauler t,  Tauler fin) {

        Random rnd = new Random();
        if (k == final1-1){
            fin.clone(t);
//            escriu(fin);
            return 0;
        }
        else {
            List<Casella> Adjacents = new ArrayList<Casella>();
            t.getAdjacentslist(actual, Adjacents);
            while (!Adjacents.isEmpty() && !fin.he_acabat()) {

                //int p = numadjmespetit(Adjacents);
                //Collections.sort(Adjacents, new Casella());
                Collections.sort(Adjacents);
                int kaux = k +1;
                Casella aux = Adjacents.get(0);
                Adjacents.remove(0);

                aux.elem = actual.elem +1;

                Tauler taux = new Tauler(t.getTamany());
                taux.clone(t);
//                escriu(taux);
                //              escriu(t);
                taux.setCasella(aux.x, aux.y, aux.elem,t.getCasella(aux.x,aux.y).numadjlliures);
                //            escriu(taux);

                if(taux.he_acabat()) backtrackingmenor(kaux, final1, aux, taux, fin);
                else  if(!taux.esPartit()) {
                    int auxret = backtrackingmayor(kaux, final1, aux, taux, fin);
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

    public static Tauler creacioTaulerPredeterminat(int n, int m, int x, String dificultat, TaulerComplert retcomplert)
    {
        /*
        Donat una "n" que serà el getTamany d'un costat del Tauler, donat una "m" que serà el nombre de "Forats" que hi
        haurà al Tauler, donat una "x" que serà el nombre de números predetermints que tingui el Tauler y una "dificultat"
        que serà el complicat que serà aquest. Retornarà un Tauler amb "m" Forats repartits aleatoriament, amb "x"-2
        números escollits aleatoriament, el 1 i el n*n-m ficats al Tauler.
         */
        Casella inicial = new Casella();


        Tauler t = new Tauler(n);
        Random rnd = new Random();
        int auxX;
        int auxY;

        //ficar_numadjlliures(t);

        for (int i = 0; i <  m; ++i)   { //poner de forma RANDOM els forats
            auxX = rnd.nextInt(n);
            auxY = rnd.nextInt(n);
            if (t.getCasella(auxX,auxY).elem == -1 ) { --i; }
            else { t.setCasella(auxX, auxY, Casella.FORAT, -1);}
        }
        t.print();
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
                t.setCasella(auxX, auxY, num_pre.get(0), t.getCasella(auxX,auxY).numadjlliures); //Ponemos el numero 1 en alguna parte del tablero
                preparat = true;
                inicial.x = auxX;
                inicial.y = auxY;
                inicial.elem = num_pre.get(0);
            }

        }
        t.print();

        System.out.print(inicial.x + " " + inicial.y + " " + inicial.elem + "\n");

        Tauler ret = new Tauler(t.getTamany());
//        Tauler retcomplert = new Tauler(t.getTamany());
        int acabarbacktrackin = -1;

        while(acabarbacktrackin != 0){
            if(acabarbacktrackin == ValidadorTauler.NOMINMAX) throw new RuntimeException("No esta o el 1 o el numero maxim");
            if (acabarbacktrackin == ValidadorTauler.NOBENPOSADES) throw new RuntimeException("Els numeros no tenen l'adjacent continuu");
            if (acabarbacktrackin == ValidadorTauler.JARESOLT) throw new RuntimeException("L'Hidato propossat ja està resolt");
            if (acabarbacktrackin == ValidadorTauler.NOTESOL)    throw new RuntimeException("L'Hidato propossat no té solució");

            if (n <= 7) backtrackingmenor(0, n * n - m, inicial, t, ret);
            else backtrackingmayorde8(0, n*n-m, inicial,t,ret);
            acabarbacktrackin = ValidadorTauler.validarTauler(ret,retcomplert);
        }

        System.out.print("Surto Backtracking:\n");
        ret.print();

        eliminarnumeros(ret, num_pre);

        ret.print();

        return ret;
        
    }
}
