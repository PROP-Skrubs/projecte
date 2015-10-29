package CapaDomini;

import CapaPersistencia.CapaPersistencia;

/**
 * Created by daniel on 29/10/15.
 */

public class ControladorLogin
{
    private static Usuari usuariActual;

    public static boolean fesLogin(String nomUsuari, String contrasenya)
    {
        Usuari u = CapaPersistencia.ControladorUsuari.donaUsuari(nomUsuari);
        if (u == null) return false;
        if (!u.validaContrasenya(contrasenya)) return false;

        //si passa totes les comprovacions
        usuariActual = u;
        return true;
    }

    public static Usuari getUsuariActual()
    {
        return usuariActual;
    }
}