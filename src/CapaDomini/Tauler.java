package CapaDomini;

import java.util.*;

public class Tauler
{
    private Casella[][] tauler;
    private Integer idhidato;
    private Integer nforats;
    private Integer ncolocats;
    private Integer tamany;
    private static Casella[] offsets = {
            new Casella(1, -1), new Casella(1, 0), new Casella(1, -1),
            new Casella(0, -1), new Casella(0, 1),
            new Casella(-1, -1), new Casella(-1, 0), new Casella(-1, 1)
    };


    public Tauler()
    //Incloem un constructor sense arguments per requeriments del llenguatge, però no el fem servir
    {
        //Com que aquest constructor no s'hauria de fer servir mai, faig que tiri excepcions si es invocat i així ajudi a detectar errors de disseny
        throw new RuntimeException("ERROR: INVOCAT EL CONSTRUCTOR PER DEFECTE DE TAULER!");
    }

    public Tauler(int tamany)
    {
        tauler = new Casella[tamany][tamany];
        for (int i = 0; i < tamany; ++i)
        {
            for (int j = 0; j < tamany; ++j)
            {
                tauler[i][j] = new Casella(i, j, Casella.BUIT);
            }
        }
    }

    public Tauler(Tauler t)
    {
        int tamany = t.tamany();
        tauler = new Casella[tamany][tamany];
        for (int i = 0; i < tamany; ++i)
        {
            for (int j = 0; j < tamany; ++j)
            {
                tauler[i][j] = new Casella(t.tauler[i][j]);
            }
        }

    }

    public void clone(Tauler t) {
        for (int i = 0; i<t.tamany(); ++i) {
            for (int j=0; j<t.tamany(); ++j) {
                this.setCasella(i,j,t.getCasella(i,j).elem);
            }
        }
    }

    public Casella getCasella(int posX, int posY)
    {
        return tauler[posX][posY];
    }

    public void setCasella(int posX, int posY, int valor)
    {
        tauler[posX][posY] = new Casella(posX, posY, valor);
    }

    public int getLongitud()
    {
        return tauler.length;
    }
    public Integer tamany() {
        return tauler.length;
    }

    public boolean esvalid(int Posx, int Posy)
    {
        return (Posx >= 0 && Posx < tauler.length && Posy >= 0 && Posy < tauler.length);
    }

    public Casella buscarnumeromax()
    {
        Casella ret = new Casella(0, 0, 0);

        for (int i = 0; i < tauler.length; ++i)
        {
            for (int j = 0; j < tauler.length; ++j)
            {
                if (tauler[i][j].elem > ret.elem)
                {
                    ret.elem = tauler[i][j].elem;
                }

            }
        }
        return ret;
    }

    public Casella buscaNumero(int num)
    {
        for (Casella[] fila : tauler)
        {
            for (Casella candidat : fila)
            {
                if (candidat.elem == num)
                    return new Casella(candidat);
            }
        }
        return null;
    }


    public void getAdjacentslist(Casella inici, List<Casella> aAfegir) {
        /**
         * Aquesta funció afegeix a la lista "aAfegir" tots els adjacents que no tinguin o un valor o un forat, es a dir, només els que siguin buits
         */
        int DEBUG_AFEGIT = 0;
        for (int i = -1; i <= 1; ++i) {
            int consideraX = inici.x + i;
            if (consideraX >= 0 && consideraX < tauler.length) {
                for (int j = -1; j <= 1; ++j) {
                    int consideraY = inici.y + j;
                    if (consideraY >= 0 && consideraY < tauler.length) {
                        if (tauler[consideraX][consideraY].elem == Casella.BUIT) {
                            aAfegir.add(new Casella(consideraX, consideraY, 0));
                            ++DEBUG_AFEGIT;
                        }
                    }
                }
            }
        }
    }


    public void getAdjacents(Casella inici, Queue<Casella> aAfegir)
    {
        /**
         * Aquesta funció afegeix a la cua "aAfegir" tots els adjacents que no tinguin o un valor o un forat, es a dir, només els que siguin buits
         */
        int DEBUG_AFEGIT = 0;

        for (Casella offset : offsets)
        {
            Casella candidat = inici.suma(offset);
            if (candidat.esDinsLimits(tauler.length) && tauler[candidat.x][candidat.y].elem == Casella.BUIT)
            {
                aAfegir.add(new Casella(candidat));
                ++DEBUG_AFEGIT;
            }
        }
        //      System.err.println("S'han trobat " + DEBUG_AFEGIT + " adjacents\tCasella inicial: " + inici.x + "," + inici.y);
    }

    public int trobaPrimeraIncognita()
    {
        /**
         * Aixo no comprova que les caselles estiguin ficades en un ordre valid per les regles del hidato
         * Retorna 0 si no hi ha cap incognita al tauler
         */
        // no usarem presentsAlTauler[0]
        boolean[] presentsAlTauler = new boolean[tauler.length * tauler.length + 1];
        for (Casella[] fila : tauler)
        {
            for (Casella candidat : fila)
            {
                presentsAlTauler[candidat.elem] = true;
            }
        }
        int i = 1;
        while (i < presentsAlTauler.length)
        {
            if (!presentsAlTauler[i]) break;
            ++i;
        }

        if (i == presentsAlTauler.length) return 0;
        return i;
    }


    public boolean esPartit()
    {
        /**
         * Aquesta funcio serveix per a comprovar que un tauler no tingui multiples particions no connexes
         * Considera "travessables" nomes les caselles que estiguin a Casella.BUIT (0).
         * Per tant, te en compte tant els forats com els numeros ja posats.
         * Procediment:
         *  Marcar totes les caselles impassables com a "visitades"
         *  Agafar una casella "no visitada" quaslevol
         *  Començar a fer un BFS des d'aquesta casella, fins a exhaurir tots els adjacents.
         *  Si al final del BFS queda alguna casella no visitada, el tauler es partit.
         */

        boolean[][] visitats = new boolean[tauler.length][tauler.length];
        int primeraX = -1, primeraY = -1;
        int casellesVisitades = 0;
        for (int i = 0; i < tauler.length; ++i)
        {
            for (int j = 0; j < tauler.length; ++j)
            {
                visitats[i][j] = (tauler[i][j].elem != Casella.BUIT);
                if (!visitats[i][j])
                {
                    primeraX = i;
                    primeraY = j;
                }
                else
                {
                    ++casellesVisitades;
                }
            }
        }
        if (primeraX == -1 || primeraY == -1)
        {
            if (casellesVisitades == tauler.length * tauler.length)
                return false;
            else
                throw new RuntimeException("No hi ha punt d'inici, pero no hem visitat totes les caselles??");
        }

        //BFS a partir d'aqui
        Queue<Casella> aVisitar = new ArrayDeque<>();
        getAdjacents(new Casella(primeraX, primeraY, 0), aVisitar);
        visitats[primeraX][primeraY] = true;
        ++casellesVisitades;
        int iteracions = 0;
        while (!aVisitar.isEmpty())
        {
            ++iteracions;
            Casella actual = aVisitar.element();
            aVisitar.remove();
            //check if we've been here before. If so, just skip this round
            if (visitats[actual.x][actual.y]) continue;
            ++casellesVisitades;
            visitats[actual.x][actual.y] = true;
            getAdjacents(actual, aVisitar);
        }
        System.err.println("S'han fet " + iteracions + " iteracions");

        //Ara mirem si hem visitat tantes caselles com te el mapa...
        if (casellesVisitades > tauler.length * tauler.length)
            throw new RuntimeException("S'han visitat " + casellesVisitades + " en un tauler de " + tauler.length * tauler.length + " caselles");
        if (casellesVisitades < tauler.length * tauler.length)
        {
            System.err.println("S'han visitat " + casellesVisitades + " caselles...");
            return true;
        }
        return false;
    }

    public boolean he_acabat() {
        int cont = 0;
        for (int i = 0; i < this.tamany(); ++i) {
            for (int j = 0; j < this.tamany(); ++j) {
                if(this.getCasella(i,j).elem == 0) ++cont;
            }
        }

        if (cont == 0) return true;
        else return false;

    }
    public Integer getNforats() {
        return nforats;
    }

    public void setNforats(Integer nforats) {
        this.nforats = nforats;
    }

    public Integer getNcolocats() {
        return ncolocats;
    }

    public void setNcolocats(Integer ncolocats) {
        this.ncolocats = ncolocats;
    }

    public Integer getIdhidato() {
        return idhidato;
    }

    public void setIdhidato(Integer idhidato) {
        this.idhidato = idhidato;
    }
    public Tauler(Integer idhidato, Integer nforats, Integer ncolocats, Integer tamany, Casella[][] tauler){
        this.idhidato= idhidato;
        this.nforats = nforats;
        this.ncolocats = ncolocats;
        this.tamany = tamany;
        this.tauler = tauler;
    }

}