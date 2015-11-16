package CapaDomini;

import CapaPersistencia.GestorUsuari;

/**
 * Created by daniel on 29/10/15.
 */

public class ControladorLogin
{
    private static Usuari usuariActual;

    public static boolean fesLogin(String nomUsuari, String contrasenya)
    {
        /**Veridica si la contrasenya es la que correspon al Usuari amb el seu nom
         */
        Usuari u = GestorUsuari.donaUsuari(nomUsuari);
        if (u == null) return false;
        if (!u.validaContrasenya(contrasenya)) return false;

        //si passa totes les comprovacions
        usuariActual = u;
        return true;
    }

    public static Usuari getUsuariActual()
    {
        /**Retorna el UsuariActual
         */
        return usuariActual;
    }
}