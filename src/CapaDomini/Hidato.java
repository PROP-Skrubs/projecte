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
        uniqID = -1;
        tauler = null;
        taulerComplert = null;
        dificultat = null;
    }

    public Hidato(Tauler tauler, TaulerComplert taulerComplert, String dificultat)
    {
        this.uniqID = -1;
        this.tauler.move(tauler);
        this.taulerComplert.move(taulerComplert);
        this.dificultat = dificultat;
    }

    public Hidato(Hidato h)
    {
        uniqID = h.getUniqID();
        tauler = h.getTauler();
        taulerComplert = h.getTaulerComplert();
        dificultat = h.getDificultat();
    }

    public Tauler getTauler()
    {
        return new Tauler(tauler);
    }

    public TaulerComplert getTaulerComplert()
    {
        return new TaulerComplert(taulerComplert);
    }

    public int getIDTauler()
    {
        return tauler.getUniqID();
    }

    public void setIDTauler(int id)
    {
        tauler.setUniqID(id);
    }

    public int getIDTaulerComplert()
    {
        return taulerComplert.getUniqID();
    }

    public void setIDTaulerComplert(int id)
    {
        taulerComplert.setUniqID(id);
    }

    public void setTauler(Tauler nou)
    {
        tauler = nou;
    }

    public void setTaulerComplert(TaulerComplert nou)
    {
        taulerComplert = nou;
    }

    public int getUniqID()
    {
        return uniqID;
    }

    public void setUniqID(int uniqID)
    {
        this.uniqID = uniqID;
    }

    public String getDificultat()
    {
        return dificultat;
    }

    public void setDificultat(String dificultat)
    {
        this.dificultat = dificultat;
    }

}
