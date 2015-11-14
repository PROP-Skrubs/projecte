package CapaDomini;

import java.util.Comparator;

/**
 * Created by cross on 20/10/15.
 */

public class Casella implements Comparable{
    public int elem;
    public int x;
    public int y;
    public int numadjlliures;
    public static int FORAT = -1;
    public static int BUIT = 0;
    public static boolean original;

    public Casella()
    {
    }

    public Casella(int x, int y, int elem)
    {
        this.x = x;
        this.y = y;
        this.elem = elem;
    }
    public Casella(int x, int y, int elem, int numadjlliures)
    {
        this.x = x;
        this.y = y;
        this.elem = elem;
        this.numadjlliures = numadjlliures;
    }

    public Casella(int xx, int yy)
    {
        x = xx;
        y = yy;
    }

    public Casella(Casella c)
    {
        this.x = c.x;
        this.y = c.y;
        this.elem = c.elem;
    }
    public void clone(Casella cas)
    { //todo mirar si es pot usar el constructor
        this.elem = cas.elem;
        this.x = cas.x;
        this.y = cas.y;
        this.numadjlliures = cas.numadjlliures;
    }

    public Casella suma(Casella o)
    {
        return new Casella(x + o.x, y + o.y);
    }

    public int distancia(Casella o)
    {
        /**
         * Torna la minima distancia possible entre dues caselles, independentment del tauler en la que estiguin colocades. La distancia minima real entre dues caselles colocades en un tauler pot ser significativament mes alta (o pot ser que no hi hagi cami per on arribar-hi.
         * Una alternativa baratissima a trobar el tauler.camiMesCurt(Casella a, Casella b) que es necessariament un BFS.
         */
        int distX = x - o.x;
        int distY = y - o.y;
        distX = distX >= 0 ? distX : -distX;
        distY = distY >= 0 ? distY : -distY;
        return distX >= distY ? distX : distY;
    }

    public boolean esDinsLimits(int tam)
    {
        return 0 <= x && x < tam && 0 <= y && y < tam;
    }

    public boolean esAdjacent(Casella o)
    {
        return distancia(o) <= 1;
    }

    @Override
    public int compareTo(Object o) {
        Casella c = (Casella) o;
        return new Integer(numadjlliures).compareTo(new Integer(c.numadjlliures));
    }
}
