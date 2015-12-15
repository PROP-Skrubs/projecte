package Testers;

import CapaVista.*;


/**
 * Created by daniel on 14/12/15.
 */
public class GUIPROVES
{
    public static void main(String[] argv)
    {
        new VistaCrearHidatos().mostra(true);
        new VistaCrearHidatoAutomatic().mostra(true);
        new VistaCrearHidatoManual().mostra(true);
        new VistaLogin().mostra(true);
        new VistaMenuPrincipal().mostra(true);
        new VistaComencarPartida().mostra(true);
        new VistaCrearUsuari().mostra(true);
        new VistaJugarPartida().mostra(true);
        new NotificacioGenerica("EIEIEIEIEIEI QUE TIIO").mostra(true);
    }
}
