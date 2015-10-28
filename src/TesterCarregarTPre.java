/**
 * Created by cross on 22/10/15.
 */
public class TesterCarregarTPre {
    public static int main(String[] args)
    {
        Tauler t = CapaVista.demanaTauleraUsuariPredeterminat();
        if (!t.esPartit()) System.out.println("Es valid!!");
        return 0;
    }
}
