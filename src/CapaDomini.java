import java.util.ArrayList;

/**
 * Created by daniel on 12/10/15.
 */
public class CapaDomini
{
    private static Usuari usuariActual;
    private static Tauler taulerEsbos;

    public static boolean fesLogin(String nomUsuari, String contrasenya)
    {
        Usuari u = CapaPersistencia.donaUsuari(nomUsuari);
        if (u == null) return false;
        if (!u.validaContrasenya(contrasenya)) return false;

        //si passa totes les comprovacions
        usuariActual = u;
        return true;
    }

    public static boolean crearUsuari(String nomUsuari, String contrasenya, String nomReal)
    {
        Usuari u = new Usuari();
        u.setNomUsuari(nomUsuari);
        u.setContrasenya(contrasenya);
        u.setNomReal(nomReal);
        return CapaPersistencia.crearUsuari(u);
        /*TODO:
            Controlar les excepcions i el resultat de la operacio.
              ^en principi ja es controla tot lo necessari (basicament si es crea o no l'user) i es deixa morir els errors de base de dades.
         */
    }

    private static boolean eliminarUsuari(String nomUsuari)
    {
        //Retorna true si s'ha borrat l'usuari. False si no s'ha borrat cap usuari. Tira excepcio si s'han borrat multiples.
        return CapaPersistencia.eliminarUsuari(nomUsuari);
        /*TODO:
            Si la capa de persistencia tira una excepcio normal en lloc d'una runtime (o controlem la runtime aqui), llavors podem morir "more gracefully" si mai borrem mes d'un usuari... PERO COM TAMPOC PASSARA MAI (GOD BLESS UNIQUE CONSTRAINTS), FUCK IT.
         */
    }

    public static boolean validarHidato(Hidato h)
    {
        /**
         * Aquesta funcio accepta un Hidato on el seu tauler complert és buit i el d'usuari conte un Hidato que s'ha de validar.
         * Retorna true si el tauler d'usuari tenia un Hidato vàlid (solucio i és unica) i deixa el tauler mestre amb totes les dades.
         * Retorna false si el Hidato no tenia solucio, o aquesta no era unica.
         */
        taulerEsbos = h.getTauler();
        int primeraIncognita = taulerEsbos.trobaPrimerIncognita();
        return bt(taulerEsbos,primeraIncognita,false);
    }
    public static boolean bt(Tauler t, int numeroActual, boolean solucioTrobada)
    {
        if (reject(t)) return false;
        if (accept(t))
        {
            if (solucioTrobada) throw new RuntimeException("Tauler amb multiples solucions.");
            else solucioTrobada = true;
        }
        ArrayList<Casella> permutacions = donaPermutacions( );
        int index = 0;
        while (next(t,permutacions,index))
        {
            solucioTrobada = bt(t);
        }
        return solucioTrobada;
    }

    public static Usuari getUsuariActual()
    {
        return usuariActual;
    }
}
