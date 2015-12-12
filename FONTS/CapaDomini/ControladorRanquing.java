package CapaDomini;

import CapaPersistencia.GestorRanking;

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
}
