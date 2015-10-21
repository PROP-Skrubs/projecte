import java.util.Scanner;

/**
 * Created by daniel on 12/10/15.
 */


public class CapaVista
{
    public static void main(String[] args)
    {
        mostraMenuLogin();
    }

    public static void mostraMenuLogin()
    {
        new MenuLogin();
    }

    public static void mostraMenuPrincipal()
    {
        new MenuPrincipal();
    }

    public static void demanaTaulerAUsuari(Tauler aModificar)
    {
        Scanner in = new Scanner(System.in);
        int costat = aModificar.getLongitud();
        for (int i = 0; i < costat; ++i)
        {
            for (int j = 0; j < costat; ++j)
            {
                aModificar.setCasella(i,j,in.nextInt());
            }
        }
    }
}