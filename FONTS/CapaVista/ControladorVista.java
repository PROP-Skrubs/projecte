package CapaVista;

import CapaDomini.Modelo.*;
import CapaDomini.Controladors.ControladorHidato;
import CapaDomini.Controladors.ControladorLogin;
import CapaDomini.Controladors.ControladorUsuari;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by daniel on 15/12/15.
 */
public class ControladorVista
{

    public static void main(String[] argv)
    {
        //        new VistaCrearHidatos().mostra(true);
        //        new VistaCrearHidatoAutomatic().mostra(true);
        //        new VistaCrearHidatoManual().mostra(true);
        new VistaLogin().mostra(true);
        //        new VistaMenuPrincipal().mostra(true);
        //        new VistaComencarPartida().mostra(true);
        //        new VistaCrearUsuari("asdf","asdf").mostra(true);
        //        new VistaJugarPartida().mostra(true);
        //        new NotificacioGenerica("EIEIEIEIEIEI QUE TIIO").mostra(true);
    }

    static boolean demanaFerLogin(String nomUsuari, String contrasenya)
    {
        return ControladorLogin.fesLogin(nomUsuari, contrasenya);
    }

    public static void mostraMenuPrincipal()
    {
        new VistaMenuPrincipal().mostra(true);
    }

    static boolean demanaCrearUsuari(String nomUsuari, String contrasenya, String nomReal)
    {
        return ControladorUsuari.crearUsuari(nomUsuari, contrasenya, nomReal);
    }

    static void demanaCrearHidatoAutomaticament()
    {
        ControladorHidato.creaHidatoAutomaticament();
    }

    static void demanaCrearHidatoManualment(int tamany)
    {
        ControladorHidato.creaHidatoManualment(tamany);
    }

    public static void mostraCreacioHidatoAutomatica()
    {
        VistaCrearHidatoAutomatic ct = new VistaCrearHidatoAutomatic();
        ct.mostra(true);
    }

    static int demanaValidacioParametres(int tamany, int numForats, int numColocats, int dificultat)
    {
        return Algoritmes.validarparamscreacioTaulerpredeterminat(tamany, numForats, numColocats, dificultat);
    }

    static int demanaCreacioAutomatica(int tamany, int numForats, int numColocats, String dificultat)
    {
        return ControladorHidato.fesCreacioAutomatica(tamany,numForats,numColocats,dificultat);
    }

    public static void mostraHidato(int idHidato)
    {
        new VistaMostrarHidato(idHidato).mostra(true);
    }

    static Tauler demanaTaulerDeHidato(int idHidato)
    {
        return ControladorHidato.donaTauler(idHidato);
    }

    static TaulerDisplayerCallbacks donaCallbacksPerDefecte()
    {
        return new TaulerDisplayerCallbacks()
        {
            @Override
            public boolean casellaModificada(Casella c)
            {
                return false;
            }
        };
    }
    static int demanaValidaIGuarda()
    {
        return ControladorHidato.validaIGuarda();
    }

    static void mostraSeleccioEstadistiques()
    {
        new VistaSeleccioEstadistiques().mostra(true);
    }

    static void mostraSeleccioRanquings()
    {
        new VistaSeleccioRanquings().mostra(true);
    }

    public static void notifica(String missatge)
    {
        new NotificacioGenerica(missatge).mostra(true);
    }

    static void demanaCrearHidatoFitxer(String pathFitxer)
    {
        try
        {
            Scanner in;
            in = new Scanner(new File(pathFitxer));
            int resultat = ControladorHidato.llegeixTaulerCreacio(in);
            String missatge = "";
            switch (resultat)
            {
                case ValidadorTauler.OK:
                {
                    missatge = "Hidato creat i guardat correctament!";
                    break;
                }
                case ValidadorTauler.JARESOLT:
                {
                    missatge = "L'Hidato que has donat ja estava completament resolt!";
                    break;
                }
                case ValidadorTauler.MULTIPLES:
                {
                    missatge = "L'Hidato no és admissible ja que té múltiples solucions";
                    break;
                }
                case ValidadorTauler.NOBENPOSADES:
                {
                    missatge = "Aquest Hidato conté números consecutius que no son adjacents";
                    break;
                }
                case ValidadorTauler.NOMINMAX:
                {
                    missatge = "Aquest Hidato no té el mínim i el màxim posats";
                    break;
                }
                case ValidadorTauler.NOTESOL:
                {
                    missatge = "Aquest Hidato no té solució";
                    break;
                }
            }
            new NotificacioGenerica(missatge).mostra(true);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    static void mostraEstadistiquesHidato(int idHidato)
    {
        new VistaMostraEstadisticaHidato(idHidato).mostra(true);
    }
}
