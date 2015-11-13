package CapaDomini;

import java.util.Comparator;

/**
 * Created by cross on 20/10/15.
 */

public class Casella implements Comparator, Comparable{
    public int elem;
    public int x;
    public int y;
    public int numadjlliures;
    public static int FORAT = -1;
    public static int BUIT = 0;
    public static boolean original;

    public Casella() {}
    public Casella(int x, int y, int elem, int numadjlliures)
    {
        this.x = x;
        this.y = y;
        this.elem = elem;
        this.numadjlliures = numadjlliures;
    }

    public Casella(int xx, int yy)
    {
        x=xx;
        y=yy;
    }
    public Casella(Casella c)
    {
        this.x = c.x;
        this.y = c.y;
        this.elem = c.elem;
    }
    public  void clone(Casella cas)
    {
        this.elem = cas.elem;
        this.x = cas.x;
        this.y = cas.y;
        this.numadjlliures = cas.numadjlliures;

    }
    public Casella suma(Casella o)
    {
        return new Casella(x+o.x,y+o.y);
    }

    public boolean esDinsLimits(int tam)
    {
        return 0<=x && x<tam && 0<=y && y<tam;
    }

    @Override
    public int compare(Object o, Object t1) {
        Casella u1 = (Casella) o;
        Casella u2 = (Casella) t1;
        return new Integer(u1.numadjlliures).compareTo(new Integer(u2.numadjlliures));
    }

    @Override
    public int compareTo(Object o) {
        Casella c = (Casella) o;
        return new Integer(numadjlliures).compareTo(new Integer(c.numadjlliures));
    }
}
