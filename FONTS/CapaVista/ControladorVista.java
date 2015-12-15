package CapaVista;

import CapaDomini.ControladorHidato;
import CapaDomini.ControladorLogin;
import CapaDomini.ControladorUsuari;

/**
 * Created by daniel on 15/12/15.
 */
public class ControladorVista
{
    static boolean demanaFerLogin(String nomUsuari, String contrasenya)
    {
        return ControladorLogin.fesLogin(nomUsuari,contrasenya);
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
}
