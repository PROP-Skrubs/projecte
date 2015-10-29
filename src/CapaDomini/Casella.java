package CapaDomini;

/**
 * Created by cross on 20/10/15.
 */

public class Casella {
    public int elem;
    public int x;
    public int y;
    public static int FORAT = -1;
    public static int BUIT = 0;
    public static boolean original;

    public Casella() {}
    public Casella(int x, int y, int elem)
    {
        this.x = x;
        this.y = y;
        this.elem = elem;
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
    public Casella suma(Casella o)
    {
        return new Casella(x+o.x,y+o.y);
    }

    public boolean esDinsLimits(int tam)
    {
        return 0<=x && x<tam && 0<=y && y<tam;
    }
}
