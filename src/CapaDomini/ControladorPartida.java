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

    public boolean carregarPartida(int idPartida)
    {
        partida = GestorPartida.donaPartida(idPartida);
    }

    public boolean guardarPartida()
    {
        if (!GestorPartida.existeixPartida(partida.getUniqID()))
            return GestorPartida.modificaPartida(partida);
        else
            return GestorPartida.creaPartida(partida) != -1;
    }
    //afegirvaloraCasella
    //eliminarvaloraCasella
    //demanarhelp1
    //demanarhelp2

}
