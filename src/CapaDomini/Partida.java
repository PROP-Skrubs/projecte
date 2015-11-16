package CapaDomini;


/**
 * Created by Maria on 10/11/2015.
 */
public class Partida
{
    private int uniqID;
    private Hidato hidato;
    private Usuari usuari;
    private Tauler taulerProgres;
    private int nCelesResoltes;
    private int numAjudesUtilitzades;
    private boolean esAcabada;

    public int afegir(int x, int y, int elem)
    { //todo arreglar aixo
        /**
         * Afegeix un valor n del Tauler del Hidato i imprimeix el tauler amb la nova modificacio.
         */
        if (x < 1 | x > taulerProgres.getTamany())
        {
            System.out.println("X no valida, introdueix una altra");
            return 1;
        }

        if (y < 1 | y > taulerProgres.getTamany())
        {
            System.out.println("Y no valida, introdueix una altra");
            return 2;
        }

        if (taulerProgres.buscaCasella(elem) != null)
        {
            System.out.println("Valor ja assignat");
            return 3;
        }
        if (taulerProgres.getTamany() * 2 < elem)
        {
            System.out.println("Valor massa gran");
            return 3;
        }
        if (elem < 1)
        {
            System.out.println("Valor massa petit");
            return 3;
        }
        if (taulerProgres.getCasella(x - 1, y - 1).isOriginal())
        {
            System.out.print("Aquesta casella no es pot modificar");
            return 0;
        }
        else
        {
            taulerProgres.setCasella(x - 1, y - 1, elem);
            taulerProgres.pintar_tauler();
            return 0;
        }

    }

    public Usuari getUsuari()
    {
        return new Usuari(usuari);
    }

    public void setUsuari(Usuari u)
    {
        usuari = u;
    }

    public Hidato getHidato()
    {
        return new Hidato(hidato);
    }

    public void setHidato(Hidato h)
    {
        hidato = h;
    }

    public int remove(int x, int y)
    {
        /**
         * Treu un valor n del Tauler del Hidato i imprimeix el tauler amb la nova modificacio.
         */
        if (x < 1 | x > taulerProgres.getTamany())
        {
            System.out.println("X no valida, introdueix una altra");
            return 1;
        }

        if (y < 1 | y > taulerProgres.getTamany())
        {
            System.out.println("Y no valida, introdueix una altra");
            return 2;
        }
        if (taulerProgres.getCasella(x - 1, y - 1).isOriginal())
        {
            System.out.print("Aquesta casella no es pot eliminar");
            return 0;
        }
        else
        {
            taulerProgres.setCasella(x - 1, y - 1, 0);
            taulerProgres.pintar_tauler();
            return 0;
        }
    }

    public int getUniqID()
    {
        return uniqID;
    }

    public void setUniqID(int uniqID)
    {
        this.uniqID = uniqID;
    }

    public int getnCelesResoltes()
    {
        return nCelesResoltes;
    }

    public void setnCelesResoltes(int nCelesResoltes)
    {
        this.nCelesResoltes = nCelesResoltes;
    }

    public int getNumAjudesUtilitzades()
    {
        return numAjudesUtilitzades;
    }

    public void setNumAjudesUtilitzades(int numAjudesUtilitzades)
    {
        this.numAjudesUtilitzades = numAjudesUtilitzades;
    }

    public Boolean esAcabada()
    {
        return esAcabada;
    }

    public void setEsAcabada(Boolean esAcabada)
    {
        this.esAcabada = esAcabada;
    }

    public Partida()
    {
    }
}
