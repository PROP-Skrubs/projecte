package CapaDomini;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Tauler
{
    private Casella[][] tauler;

    private static Casella[] offsets = {
            new Casella(1, -1), new Casella(1, 0), new Casella(1, 1),
            new Casella(0, -1),                     new Casella(0, 1),
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
        int tamany = t.getTamany();
        tauler = new Casella[tamany][tamany];
        for (int i = 0; i < tamany; ++i)
        {
            for (int j = 0; j < tamany; ++j)
            {
                tauler[i][j] = new Casella(t.tauler[i][j]);
            }
        }
    }

    public void move(Tauler altre)
    {
        //agafa lo que hi ha a l'altre tauler i t'ho posa a tu
        tauler = altre.tauler;
        altre.tauler = null;
    }

    public Casella getCasella(int posX, int posY)
    {
        return new Casella(tauler[posX][posY]);
    }

    public Casella getCasella(Casella candidat) { return new Casella(tauler[candidat.x][candidat.y]);}

    public void setCasella(int posX, int posY, int valor)
    {
        tauler[posX][posY] = new Casella(posX, posY, valor);
    }

    public void setCasella(Casella c)
    {
        tauler[c.x][c.y]=c;
    }

    public int getTamany()
    {
        return tauler.length;
    }

    public boolean esValid(int Posx, int Posy)
    {
        //todo: el nom no es gens indicatiu
        return (Posx >= 0 && Posx < tauler.length && Posy >= 0 && Posy < tauler.length);
    }

    public boolean teMaximIMinim()
    {
        return buscaCasella(1)!= null && buscaCasella(maximElementPossible()) != null;
    }

    public List<Interval> donaIntervals(boolean[] presents)
    {
        List<Interval> aRetornar = new ArrayList<>();
        boolean enInterval = false;
        int iniciInterval = -400;
        for (int i = 1; i < presents.length; ++i)
        {
            if (enInterval && presents[i]) continue;
            if (!enInterval && !presents[i]) continue;
            if (!enInterval && presents[i])
            {
                iniciInterval=i;
                enInterval = true;
            }
            if (enInterval && !presents[i])
            {
                aRetornar.add(new Interval(iniciInterval,i-1));
                enInterval=false;
            }
        }
        if (enInterval) //afegeix el ultim interval que arriba fins al final!!
            aRetornar.add(new Interval(iniciInterval,presents.length-1));
        return aRetornar;
    }

    public boolean casellesBenPosades()
    {
        /**
         * Aixo comprova que tots els numeros que estiguin posats al tauler hi siguin de manera adjacent.
         * La idea es agafar els intervals de caselles que es troben posades al tauler i mirar si recorrent el tauler des de l'inici de cada interval es pot arribar al final del mateix. Si això és així, significa que les caselles de l'interval estaven posades adjacentment.
         */
        boolean[] presents = presentsAlTauler();
        List<Interval> intervals = donaIntervals(presents);
        for (Interval interval : intervals)
        {
            Casella maxima = recorreTauler(interval.inici);
            if (!(maxima != null && maxima.elem == interval.fi))
            {
                return false;
            }
        }
        return true;
    }


    public Casella buscaCasella(int num)
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

    public void getAdjacents(Casella inici, Queue<Casella> aAfegir)
    {
        /**
         * Aquesta funció afegeix a la cua "aAfegir" tots els adjacents que no tinguin o un valor o un forat, es a dir, només els que siguin buits
         */
        int DEBUG_AFEGIT = 0;

        for (Casella offset : offsets)
        {
            Casella candidat = inici.suma(offset);
            if (candidat.esDinsLimits(tauler.length) && getCasella(candidat).elem == Casella.BUIT)
            {
                aAfegir.add(getCasella(candidat)); //Aixi la casella que retornarem tindra el camp elem inicialitzat tambe...
                ++DEBUG_AFEGIT;
            }
        }
//              System.err.println("S'han trobat " + DEBUG_AFEGIT + " adjacents\tCasella inicial: " + inici.x + "," + inici.y);
    }

    public int maximElementPossible() //todo computar aixo un cop
    {
        /**
         * Retorna el numero mes elevat que pot tenir aquest tauler
         */
        int potencialMax = getTamany() * getTamany();
        for (int i = 0; i < getTamany(); ++i)
            for (int j = 0; j < getTamany(); ++j)
                if (getCasella(i,j).elem == Casella.FORAT)
                    --potencialMax;
        return potencialMax;
    }

    public Casella recorreTauler(int inicial)
    {
        /**
         * Aquesta funcio intenta travessar tot el hidato, començant per la casella que te el numero i acabant fins on es pugui arribar seguint les adjacencies.
         * Torna l'ultima on hi ha pogut arribar.
         */
        Casella cActual = buscaCasella(inicial);
        boolean heAvancat = true;
        while (heAvancat)
        {
            heAvancat = false;
            //Get adjacents i mira si algun te el seguent numero
            for (Casella offset : offsets)
            {
                Casella candidat = cActual.suma(offset);
                if (candidat.esDinsLimits(tauler.length))
                {
                    candidat = getCasella(candidat);
                    if (candidat.elem == cActual.elem+1)
                    {
                        heAvancat = true;
                        cActual = candidat;
                    }
                }
            }
        }
        return getCasella(cActual);
    }

    public boolean[] presentsAlTauler()
    {
        // no usarem presentsAlTauler[0]
        boolean[] aRetornar = new boolean[tauler.length * tauler.length + 1];
        for (Casella[] fila : tauler)
        {
            for (Casella candidat : fila)
            {
                aRetornar[candidat.elem] = true;
            }
        }
        return aRetornar;
    }

    public int trobaPrimeraIncognitaAPartirDe(int minim)
    {
        /**
         * Aixo NO comprova que les caselles estiguin ficades en un ordre valid per les regles del hidato
         * Retorna 0 si no hi ha cap incognita al tauler a partir del minim (inclusiu)
         */
        /* todo: funcionalitat duplicada, canviar per
         *   donaIntervals(presentsAlTauler)[0].final+1
         */
        boolean[] presentsAlTauler = presentsAlTauler();
        int i = minim;
        while (i < presentsAlTauler.length)
        {
            if (!presentsAlTauler[i]) break;
            ++i;
        }

        if (i == presentsAlTauler.length) return 0;
        return i;
    }

    public int camiMesCurt(int a, int b)
    {
        //todo: valorar si aixo fa falta (es car de calcular) i en tot cas implementar-ho
        throw new RuntimeException("Aquesta funcio se suposa que no la has de cridar, no esta implementada!");
        /**
         * Busca la distancia minima entre el punt A i el punt B.
         * Si un dels numeros no existeix, o no hi ha cami retorna -1.
         */
//
//        Casella cA = buscaCasella(a);
//        Casella cB = buscaCasella(b);
//        if (cA != null && cB != null)
//        {
//            //fes un bfs
//        }
//        else
//        {
//            //return algo que no hi ha cami
//        }
//        return -1;
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

    public void print()
    {
        for (int i = 0; i < getTamany(); ++i)
        {
            for (int j = 0; j < getTamany(); ++j)
            {
                System.out.print(getCasella(i,j).elem);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}