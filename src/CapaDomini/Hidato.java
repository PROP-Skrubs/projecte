package CapaDomini;

import java.util.Scanner;

/**
 * Created by daniel on 12/10/15.
 */


public class Hidato
{
    private int uniqID;
    private Tauler tauler;
    private TaulerComplert taulerComplert;
    public String dificultat;

    public Hidato()
    {
        /** Retorna un Hidato buit
        */
        uniqID = -1;
        tauler = null;
        taulerComplert = null;
        dificultat = null;
    }

    public String getDificultat()
    {
        /**Retorna la dificultat
         *
         */
        return dificultat;
    }

    public Hidato(Tauler tauler, TaulerComplert taulerComplert, String dificultat)
    {
        /**Retorna un Hidato amb els valors iguals als paràmetres
         */
        this.uniqID = -1;
        this.tauler.move(tauler);
        this.taulerComplert.move(taulerComplert);
        this.dificultat = dificultat;
    }


    public Tauler getTauler()
    {
        /**
         * Retorna Tauler
         */
        return tauler;
    }
    public TaulerComplert getTaulerComplert()
    {
        /**
         * Retorna TaulerComplert
         */
        return taulerComplert;
    }

    public int getIDTauler()
    {
        /**
         * Retorna idTauler
         */
        return tauler.getUniqID();
    }
    public void setIDTauler(int id) {
        /**
         * Modifica el id per el passat per paràmetre
         */
        tauler.setUniqID(id);
    }
    public int getIDTaulerComplert()
    {
        /**
         * Retorna el idTaulerComplert
         */
        return taulerComplert.getUniqID();
    }
    public void setIDTaulerComplert(int id)
    {
        /**
         * Modifica el idTaulerComplert per el passat per paràmetre
         */
        taulerComplert.setUniqID(id);
    }

    public void setTauler(Tauler nou)
    {
        /**
         * Modifica el Tauler per el passat per paràmetre
         */
        tauler = nou;
    }
    public void setTaulerComplert(TaulerComplert nou)
    {
        /**
         * Modifica el TaulerComplert per el passat per paràmetre
         */
        taulerComplert = nou;
    }
    public int getUniqID() {
        /**
         * Retorna el UniqID
         */
        return uniqID;
    }

    public void setUniqID(int uniqID) {
        /**
         * Modifica el UniqID per el passat per paràmetre
         */
        this.uniqID = uniqID;
    }

    public String isDificultat() {
        /**
         * Retorna dificultat
         */
        return dificultat;
    }

    public void setDificultat(String dificultat) {
        /**
         * Modifica dificualtat per el passat per paràmetre
         */
        this.dificultat = dificultat;
    }


    public void imprimir(){
        /**
         * Printa per pantalla el Tauler
         */
        getTauler().pintar_tauler();
    }
}
