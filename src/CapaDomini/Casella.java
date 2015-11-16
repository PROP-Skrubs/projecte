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


    public Casella() {
        /** Dona una Casella buida
        */
    }

    public Casella(int x, int y, int elem) {
        /** Dona una Casella amb els valors que pases per paràmetre excepte numadjlliures
        */
        this.x = x;
        this.y = y;
        this.elem = elem;
    }

    public Casella(int x, int y, int elem, int numadjlliures) {
        /**Dona una Casella amb els valors que pases per paràmetre
        */
        this.x = x;
        this.y = y;
        this.elem = elem;
        this.numadjlliures = numadjlliures;
    }

    public Casella(int xx, int yy) {
        /**Et modifica la X y la Y de la Casella ficantli xx y yy
        */

        x = xx;
        y = yy;
    }

    public Casella(Casella c) {
        /**A la Casella li modifica els valors de la Casella per els que
         * te la Casella que pases per paràmetre excepte el numadjlliures
         */
        this.x = c.x;
        this.y = c.y;
        this.elem = c.elem;
    }

    public Casella suma(Casella o)
    {
        /**Als valors X y Y de la Casella se li suma els valors X y Y de
         * la Casella que pases per paràmetre
         */
        Casella aRetornar = new Casella(this);
        aRetornar.setX(x + o.x);
        aRetornar.setY(y + o.y);
        return aRetornar;
    }

    public Casella sumaAmbCheck(Casella o, int minim, int maxim)
    {
        /**Als valors X i Y de la Casella se li suma els valors X y Y de
         * la Casella que pases per paràmetre dintre de un minim i un màxim
         */
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

    public boolean esDinsLimits(int tam) {
        /**Donat el tamany d’un tauler que li pases per paràmetre et diu si la Casella està dins dels límits del Tauler
        */
        return 0 <= x && x < tam && 0 <= y && y < tam;
    }

    public boolean esAdjacent(Casella o) {

        /**Donat una Casella que li pases per paràmetre et diu si es Adjacent a la Casella.
         */
        return distancia(o) <= 1;
    }

    public int getElem(){
        /**Et retorna el valor de la Casella
        */
        return elem;
    }

    public void setElem(int elem) {
        /**Et modifica el valor de la Casella per el enter que li pases per paràmetre
        */
        this.elem = elem;
    }

    public int getX() {
        /**Et retorna el valor de la X
        */
        return x;
    }

    public void setX(int x) {
        /**Et modifica el valor de la X per el enter que li pases per paràmetre
         */
        this.x = x;
    }

    public int getY() {
        /**Et retorna el valor de la Y
         */
        return y;
    }

    public void setY(int y) {
        /**Et modifica el valor de la X per el enter que li pases per paràmetre
         */
        this.y = y;
    }

    @Override
        public int compareTo(Object o) {
        /**Funcio que serveix per ordenar per l'implentacio Comparable
          */


        Casella c = (Casella) o;
        return new Integer(numadjlliures).compareTo(new Integer(c.numadjlliures));
    }
}
