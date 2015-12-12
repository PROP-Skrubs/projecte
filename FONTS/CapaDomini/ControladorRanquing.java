package CapaDomini;

import CapaPersistencia.GestorRanking;

import java.util.ArrayList;

/**
 * Created by oriol on 12/12/15.
 */
public class ControladorRanquing {

    public static boolean afegirRanquing (String nomUsuari, int idHidato, int temps, String dificultat){
        Ranking r = new Ranking();
        r.setNomUsuari(nomUsuari);
        r.setIdHidato(idHidato);
        r.setTemps(temps);
        r.setDificultat(dificultat);
        return GestorRanking.insertRanquing(r);
    }

    public ArrayList<String> getTopUsuarisperHidato(int idHidato){
        return GestorRanking.getNomUsuarisPerHidato(idHidato);
    }

    public ArrayList<String> getTopUsuarisperDificultat(String dificultat){
        return GestorRanking.getNomUsuarisPerDificultat(dificultat);
    }

    public ArrayList<Integer> getTopIdHidatos(){
        return GestorRanking.getIdHidatosMesCopsResolts();
    }
}
