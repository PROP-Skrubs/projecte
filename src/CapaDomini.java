import java.util.ArrayList;
import java.util.Random;

/**
 * Created by daniel on 12/10/15.
 */
public class CapaDomini
{
    private static Usuari usuariActual;
    private static Tauler taulerEsbos;
    private boolean[][] mapabool;
    private int[] X = {0,1,1,0,-1,1,-1,-1};
    private int[] Y = {1,0,1,-1,0,-1,1,-1};

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


    public static boolean validarparamscreacioTaulerpredeterminat(int n,int m, int x, String dificultat)
    {
        if (n < 3 || n > 10)
        {
            throw new RuntimeException("Nombre de costat no valid, inserti un altre");
        }
        if (m < 0 || m >(0,3*n*n))
        {
            throw new RuntimeException("Nombre de forats no vàlid, inserti un altre");
        }
        if (x < 3 || x >(n*n-1))
        {
            throw new RuntimeException("Nombre predeterminats no vàlid, inserti un altre");
        }
        if  ((dificultat.compareTo("facil") != 0) || (dificultat.compareTo("normal") != 0) || (dificultat.compareTo("dificil") != 0) || (dificultat.compareTo("UltraViolence") != 0) )
        {
            throw new RuntimeException("Dificultat no vàlida, inserti un altre");
        }
    }

    public Tauler creacioTaulerPredeterminat(int n, int m, int x, String dificultat)
    {
        mapabool = new boolean[n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                mapabool[i][j] = false;
            }
        }

        Tauler t = new Tauler(n);
        Random rnd = new Random();
        int auxX;
        int auxY;

        for(int i = 0, i < n; ++i) { //poner de forma RANDOM els forats
            auxX = rnd.nextInt(n);
            auxY = rnd.nextInt(n);
            if(mapabool[auxX][auxY]) --i;
            else t.setCasella(auxX, auxY, -1);
            mapabool[auxX][auxY] = true;
        }

        //mirarforatsvalids(t);

        private int[] num_pre = new int[m];
        num_pre[0] = 1;


        auxX = rnd.nextInt(n);
        auxY = rnd.nextInt(n);






    }


}
