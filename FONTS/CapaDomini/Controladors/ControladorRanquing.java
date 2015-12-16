package CapaDomini.Controladors;

import CapaDomini.Modelo.Ranking;
import CapaPersistencia.GestorRanking;

import java.util.ArrayList;

/**
 * Created by oriol on 12/12/15.
 */
public class ControladorRanquing {

    /**
     * Afegeix una tupla a la BD de Ranquing
     * @param nomUsuari el nomUsuari de la tupla
     * @param idHidato el idHidato de la tupla
     * @param temps el temps de la tupla
     * @param dificultat la dificultat de la tupla
     * @return si ha inserit la tupla a la BD o no
     */
    public static int afegirRanquing (String nomUsuari, int idHidato, int temps, String dificultat){
        Ranking r = new Ranking();
        r.setNomUsuari(nomUsuari);
        r.setIdHidato(idHidato);
        r.setTemps(temps);
        r.setDificultat(dificultat);
        return GestorRanking.insertRanquing(r);
    }

    /**
     * Retorna el Ranquing d'Usuaris per Hidatos
     * @param idHidato la id del Hidato que volem saber els seus Usuaris que millors han resolt
     * @return el llistat de Ranking
     */
    public static ArrayList<Ranking> getTopUsuarisperHidato(int idHidato){
        return GestorRanking.getUsuarisPerHidato(idHidato);
    }

    /**
     * Retorna el Ranquing de Usuaris segons la dificultat
     * @param dificultat la dificultat que volem per saber els Usuaris que mes Hidatos amb resolt amb aquesta dificultat
     * @return el llistat de Raking
     */
    public static ArrayList<Ranking> getTopUsuarisperDificultat(String dificultat){
        return GestorRanking.getUsuarisPerDificultat(dificultat);
    }

    /**
     * Retorna el Ranquing de Hidatos mes cops resolts
     * @return el llistat de Raking
     */
    public static ArrayList<Ranking> getTopIdHidatos(){
        return GestorRanking.getHidatosMesCopsResolts();
    }
}
