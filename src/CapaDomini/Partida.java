package CapaDomini;

import java.util.Scanner;

/**
 * Created by Maria on 10/11/2015.
 */
public class Partida
{
    int uniqID;
    Hidato hidato;
    Usuari usuari;
    int nCelesResoltes;
    int numAjudesUtilitzades;
    Tauler taulerProgres;
    boolean esAcabada;

    public int afegir(int x, int y, int elem) { //todo arreglar aixo
        /**
         * Afegeix un valor n del Tauler del Hidato i imprimeix el tauler amb la nova modificacio.
         */
        while (x < 1 | x > taulerProgres.getTamany()) {
            System.out.println("X no valida, introdueix una altra");
            return 1;
        }

        while (y < 1 | y > taulerProgres.getTamany()) {
            System.out.println("Y no valida, introdueix una altra");
            return 2;
        }

        while (taulerProgres.buscaCasella(elem) != null) {
            System.out.println("Valor ja assignat");
            return 3;
        }
        while(true){
            if (taulerProgres.getTamany() * 2 < elem)
                System.out.println("Valor massa gran");
            else if (elem < 1)
                System.out.println("Valor massa petit");
            else break;
            return 3;
        }
        if (taulerProgres.getCasella(x-1,y-1).isOriginal()){
            System.out.print("Aquesta casella no es pot modificar");
            return 0;
        }
        else {
            taulerProgres.setCasella(x - 1, y - 1, elem);
            taulerProgres.pintar_tauler();
            return 0;
        }

    }

    public int remove(int x, int y) {
        /**
         * Treu un valor n del Tauler del Hidato i imprimeix el tauler amb la nova modificacio.
         */
        while (x < 1 | x > taulerProgres.getTamany()) {
            System.out.println("X no valida, introdueix una altra");
            return 1;
        }

        while (y < 1 | y > taulerProgres.getTamany()) {
            System.out.println("Y no valida, introdueix una altra");
            return 2;
        }
        if (taulerProgres.getCasella(x-1,y-1).isOriginal()){
            System.out.print("Aquesta casella no es pot eliminar");
            return 0;
        }
        else {
            taulerProgres.setCasella(x - 1, y - 1, 0);
            taulerProgres.pintar_tauler();
            return 0;
        }
    }

    public int getUniqID()
    {
        /**
         * Retorna UniqID
         */
        return uniqID;
    }

    public void setUniqID(int uniqID)
    {
        /**
         * Modifica UniqID per el passat per paràmetre
         */
        this.uniqID = uniqID;
    }

    public int getnCelesResoltes()
    {
        /**
         * Retorna nCelesResoltes
         */
        return nCelesResoltes;
    }

    public void setnCelesResoltes(int nCelesResoltes)
    {
        /**
         * Modifica nCelesResoltes per el passat per paràmetre
         */
        this.nCelesResoltes = nCelesResoltes;
    }

    public int getNumAjudesUtilitzades()
    {
        /**
         * Retorna NumAjudesUtilitzades
         */
        return numAjudesUtilitzades;
    }

    public void setNumAjudesUtilitzades(int numAjudesUtilitzades)
    {
        /**
         * Modifica NumAjudesUtilitzades per el passat per paràmetre
         */
        this.numAjudesUtilitzades = numAjudesUtilitzades;
    }

    public Boolean getEsAcabada()
    {
        /**
         * Retorna EsAcabada
         */
        return esAcabada;
    }

    public void setEsAcabada(Boolean esAcabada)
    {
        /**
         * Modifica esAcabada per el passat per paràmetre
         */
        this.esAcabada = esAcabada;
    }

    public Partida()
    {
        /**
         * Constructora Buida
         */
    }
}
