/**
 * Created by daniel on 12/10/15.
 */
public class CapaDomini
{
    private static Usuari usuariActual;

    public static boolean fesLogin(String nomUsuari, String contrasenya)
    {
        Usuari  u = CapaPersistencia.donaUsuari(nomUsuari);
        if (u == null) return false;
//        if (!u.validaContrasenya(contrasenya)) return false;

        //si passa totes les comprovacions
        usuariActual = u;
        return true;
    }

    public static Usuari getUsuariActual()
    {
        return usuariActual;
    }
}
