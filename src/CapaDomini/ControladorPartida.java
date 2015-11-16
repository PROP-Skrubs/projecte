package CapaDomini;

import CapaPersistencia.GestorPartida;

/**
 * Created by cross on 15/11/15.
 */
public class ControladorPartida {
    private static Partida partida;


    public static int afegirvaloraCaselladePartida(int x, int y, int elem){
        int ret = partida.afegir(x, y, elem);
        return ret;
    }
    public static int eliminarvalorCaselladePartida(int x, int y){
        int ret = partida.remove(x, y);
        return ret;
    }
    //carregarpartida
    //guardarpartida
    //afegirvaloraCasella
    //eliminarvaloraCasella
    //demanarhelp1
    //demanarhelp2

}
