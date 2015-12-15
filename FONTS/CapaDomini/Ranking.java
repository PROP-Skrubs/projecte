package CapaDomini;

import CapaPersistencia.GestorRanking;

import java.util.ArrayList;

/**
 * Created by oriol on 7/12/15.
 */
public class Ranking {

    private String nomUsuari;
    private Integer idHidato;
    private Integer temps;
    private String dificultat;

    public String getnomUsuari() {
        return nomUsuari;
    }

    public int getIdHidato() {
        return idHidato;
    }

    public int getTemps() {
        return temps;
    }

    public String getDificultat() {
        return dificultat;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public void setDificultat(String dificultat) {
        this.dificultat = dificultat;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public void setIdHidato(int idHidato) {
        this.idHidato = idHidato;
    }


}
