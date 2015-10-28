/**
 * Created by daniel on 22/10/15.
 */
public class TesterParticio
{
    public static void main(String[] args)
    {
        Tauler prova = new Tauler(9);
        CapaVista.demanaTaulerAUsuari(prova);
        if (!prova.esPartit()) System.out.println("No és partit!! Tot bé.");
        else System.out.println("Malament, és partit.");
    }
}
