package CapaDomini;

import java.util.Queue;

/**
 * Created by daniel on 29/10/15.
 */
public class ControladorHidato
{
    private static Tauler taulerEsbos;

    public static boolean validarHidato(Hidato h)
    {
        /**
         * Aquesta funcio accepta un Hidato on el seu tauler complert és buit i el d'usuari conte un Hidato que s'ha de validar.
         * Retorna true si el tauler d'usuari tenia un Hidato vàlid (solucio i és unica) i deixa el tauler mestre amb totes les dades.
         * Retorna false si el Hidato no tenia solucio, o aquesta no era unica.
         */
        taulerEsbos = h.getTauler();
        int primeraIncognita = taulerEsbos.trobaPrimeraIncognita();
        return bt(taulerEsbos,primeraIncognita,false);
    }

    public static Queue<Casella> donaPermutacions(Tauler t, Casella c){};

    public static boolean bt(Tauler t, int numeroActual, boolean solucioTrobada, TaulerComplert taulerDesti)
    {
        if (reject(t)) return false;
        if (accept(t))
        {
            if (solucioTrobada) throw new RuntimeException("Tauler amb multiples solucions.");
            else
            {
                solucioTrobada = true;
            }
        }
        Queue<Casella> permutacions = donaPermutacions( );
        int index = 0;
        while (next(t,permutacions,index))
        {
            solucioTrobada = bt(t);
            ++index;
        }
        return solucioTrobada;
    }
}
