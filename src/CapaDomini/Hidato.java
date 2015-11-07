package CapaDomini;

/**
 * Created by daniel on 12/10/15.
 */
public class Hidato
{
    private Tauler tauler;
    private TaulerComplert taulerComplert;
    public boolean dificultat;

    public Tauler getTauler()
    {
        return new Tauler(tauler);
    }
    public TaulerComplert getTaulerComplert(){ return taulerComplert; }

    public void pintar_hidato(int m){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_BARRA = "\u2014";

        for (int i = 0; i < 6; ++i){
            System.out.print("|");
            for (int j = 0; j < 6; ++j) {
                if(m == 1){
                    if (tauler.getCasella(i,j).elem - 10 < 0) System.out.print(" ");
                    if (tauler.getCasella(i,j).elem - 10 < 0) System.out.print("*");
                    if(tauler.getCasella(i,j).elem != 0)System.out.print(ANSI_RED + tauler.getCasella(i,j).elem + ANSI_RESET); //mirar si es un numero core
                    else System.out.print(tauler.getCasella(i,j).elem);
                }
                else{
                    if (taulerComplert.getCasella(i,j).elem - 10 < 0) System.out.print(" ");
                    if(taulerComplert.getCasella(i,j).elem != 0)System.out.print(ANSI_RED+ taulerComplert.getCasella(i,j).elem + ANSI_RESET); //mirar si es un numero core
                    else{
                        if(taulerComplert.getCasella(i,j).elem != 0) System.out.print(taulerComplert.getCasella(i,j).elem);
                        else System.out.print(" ");
                    }
                }
                System.out.print("|");
            }
            System.out.print("\n");

        }

    }

}
