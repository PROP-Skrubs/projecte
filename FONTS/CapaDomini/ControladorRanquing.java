package CapaDomini;

import CapaPersistencia.GestorRanking;

import java.util.ArrayList;

/**
 * Created by oriol on 12/12/15.
 */
public class ControladorRanquing {

    public static int afegirRanquing (String nomUsuari, int idHidato, int temps, String dificultat){
        Ranking r = new Ranking();
        r.setNomUsuari(nomUsuari);
        r.setIdHidato(idHidato);
        r.setTemps(temps);
        r.setDificultat(dificultat);
        return GestorRanking.insertRanquing(r);
    }

    public static ArrayList<Ranking> getTopUsuarisperHidato(int idHidato){
        return GestorRanking.getUsuarisPerHidato(idHidato);
    }

    public static ArrayList<Ranking> getTopUsuarisperDificultat(String dificultat){
        return GestorRanking.getUsuarisPerDificultat(dificultat);
    }

    public static ArrayList<Ranking> getTopIdHidatos(){
        return GestorRanking.getHidatosMesCopsResolts();
    }
}
