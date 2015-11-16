package CapaDomini;

import CapaPersistencia.GestorPartida;

/**
 * Created by cross on 15/11/15.
 */
public class ControladorPartida {
    private static Partida partida;


    public static int afegirvaloraCaselladePartida(int x, int y, int elem){
        /**Afegeix al Tauler de la partida el ELEM a la posicio X,Y passat tot per paràmetres
         *
         */
        int ret = partida.afegir(x, y, elem);
        return ret;
    }
    public static int eliminarvalorCaselladePartida(int x, int y){
        /**Elimina el valor de la Casella de partida de la posicio X,Y passat per paràmetres
         *
         */
        int ret = partida.remove(x, y);
        return ret;
    }

}
