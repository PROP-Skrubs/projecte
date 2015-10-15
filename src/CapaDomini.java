/**
 * Created by daniel on 12/10/15.
 */
public class CapaDomini
{
    private static Usuari usuariActual;

    public static boolean fesLogin(String nomUsuari, String contrasenya)
    {
        Usuari u = CapaPersistencia.donaUsuari(nomUsuari);
        if (u == null) return false;
        if (!u.validaContrasenya(contrasenya)) return false;

        //si passa totes les comprovacions
        usuariActual = u;
        return true;
    }

    public static void crearUsuari(String nomUsuari, String contrasenya, String nomReal)
    {
        Usuari u = new Usuari();
        u.setNomUsuari(nomUsuari);
        u.setContrasenya(contrasenya);
        u.setNomReal(nomReal);
        CapaPersistencia.crearUsuari(u);
        //TODO: controlar les excepcions i el resultat de la operacio
    }

    private static void eliminarUsuari(String nomUsuari)
    {
        CapaPersistencia.eliminarUsuari(nomUsuari);
        //TODO: controlar les excepcions i el resultat de la operacio
    }

    public static Usuari getUsuariActual()
    {
        return usuariActual;
    }
}
