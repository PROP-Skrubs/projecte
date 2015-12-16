package CapaDomini.Algoritmes;

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

    /**
     * Retorna el nom del Usuari
     * @return el nom del Usuari
     */
    public String getnomUsuari() {
        return nomUsuari;
    }

    /**
     * Retorna el id del Hidato
     * @return el id del Hidato
     */
    public int getIdHidato() {
        return idHidato;
    }

    /**
     * Retorna el temps
     * @return el temps
     */
    public int getTemps() {
        return temps;
    }

    /**
     * Retorna la dificulta
     * @return la dificultat
     */
    public String getDificultat() {
        return dificultat;
    }

    /**
     * Modifica el nomUsuari
     * @param nomUsuari el nou nomUsuari
     */
    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    /**
     * Modicica la dificultat
     * @param dificultat la nova dificultat
     */
    public void setDificultat(String dificultat) {
        this.dificultat = dificultat;
    }

    /**
     * Modifica el temps
     * @param temps el nou temps
     */
    public void setTemps(int temps) {
        this.temps = temps;
    }

    /**
     * Modifica el id Del Hidato
     * @param idHidato el nou Id del Hidato
     */
    public void setIdHidato(int idHidato) {
        this.idHidato = idHidato;
    }


}
