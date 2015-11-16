package CapaDomini;

import CapaPersistencia.GestorHidato;
import CapaPersistencia.GestorPartida;
import CapaPersistencia.GestorUsuari;
import CapaVista.JugarPartida;

/**
 * Created by cross on 15/11/15.
 */
public class ControladorPartida
{
    private static Partida partida;
    private static ControladorPartidaCallbackImplementor callbackImplementor;

    static
    {
        callbackImplementor = ControladorPartidaCallbackImplementor.getInstance();
    }

    public static class ControladorPartidaCallbackImplementor implements TaulerDisplayerCallbacks
    {
        private static ControladorPartidaCallbackImplementor instance;
        private ControladorPartidaCallbackImplementor()
        {
            //do nothing?
        }
        public static ControladorPartidaCallbackImplementor getInstance()
        {
            if (instance == null) instance = new ControladorPartidaCallbackImplementor();
            return instance;
        }

        public boolean casellaModificada(Casella c)
        {
            boolean aRetornar = false;
            if (c.getElem() > 0)
            {
                int resultatAfegir = afegirvaloraCaselladePartida(c.getX(),c.getY(),c.getElem());
                aRetornar = resultatAfegir == 0; //todo: canviar aixo per un enum o algo plox
            }
            else if (c.getElem() == Casella.BUIT)
            {
                int resultatEliminar = eliminarvalorCaselladePartida(c.getX(),c.getY());
                aRetornar = resultatEliminar == 0;
            }
            else
            {
                throw new RuntimeException("No se com vols que modifiqui una casella");
            }
            return aRetornar;
        }
    }

    public static int afegirvaloraCaselladePartida(int x, int y, int elem)
    {
        int ret = partida.afegir(x, y, elem);
        return ret;
    }

    public static int eliminarvalorCaselladePartida(int x, int y)
    {
        int ret = partida.remove(x, y);
        return ret;
    }

    public static void jugaPartida()
    {
        JugarPartida j = new JugarPartida(partida.getTaulerOriginal(),callbackImplementor);
    }

    public static void novaPartida(Usuari u, Hidato h)
    {
        partida = new Partida();
        partida.setUsuari(u);
        partida.setHidato(h);
        partida.setTaulerProgres(new Tauler(h.getTamany()));
        partida.setnCelesResoltes(0);
        partida.setNumAjudesUtilitzades(0);
        partida.setEsAcabada(false);
    }

    public static void novaPartida(int idUsuari, int idHidato)
    {
        Usuari u = GestorUsuari.donaUsuari(idUsuari);
        Hidato h = GestorHidato.donaHidato(idHidato);
        novaPartida(u,h);
    }

    public static boolean carregarPartida(int idPartida)
    {
        partida = GestorPartida.donaPartida(idPartida);
        return partida != null;
    }

    public static boolean guardarPartida()
    {
        if (!GestorPartida.existeixPartida(partida.getUniqID()))
            return GestorPartida.modificaPartida(partida);
        else
            return GestorPartida.creaPartida(partida) != -1;
    }



    //demanarhelp1
    //demanarhelp2

}
