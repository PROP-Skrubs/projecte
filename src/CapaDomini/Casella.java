package CapaDomini;

import java.util.Comparator;

/**
 * Created by cross on 20/10/15.
 */

public class Casella implements Comparable
{
    public int elem;
    public int x;
    public int y;
    public int numadjlliures;
    public static int FORAT = -1;
    public static int BUIT = 0;

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

    public Casella suma(Casella o)
    {
        Casella aRetornar = new Casella(this);
        aRetornar.setX(x + o.x);
        aRetornar.setY(y + o.y);
        return aRetornar;
    }

    public Casella sumaAmbCheck(Casella o, int minim, int maxim)
    {
        Casella aRetornar = suma(o);
        aRetornar.x = aRetornar.x>minim?aRetornar.x:minim;
        aRetornar.x = aRetornar.x<maxim?aRetornar.x:maxim;
        aRetornar.y = aRetornar.y>minim?aRetornar.y:minim;
        aRetornar.y = aRetornar.y<maxim?aRetornar.y:maxim;
        return aRetornar;
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

    public int getElem()
    {
        return elem;
    }

    public void setElem(int elem)
    {
        this.elem = elem;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    @Override
    public int compareTo(Object o)
    {
        Casella c = (Casella) o;
        return new Integer(numadjlliures).compareTo(new Integer(c.numadjlliures));
    }
}
