/**
 * Created by daniel on 22/10/15.
 */
public class TesterParticio
{
    public static int main(String[] args)
    {
        Tauler prova = new Tauler(4);
        CapaVista.demanaTaulerAUsuari(prova);
        if (!prova.esPartit()) System.out.println("Es valid!!");
        return 0;
    }
}
