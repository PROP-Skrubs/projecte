package CapaVista;

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

    static void mostraMenuPrincipal()
    {
        new VistaMenuPrincipal();
    }
}
