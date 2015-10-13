public class TaulerComplert extends Tauler
{
    public int comparaDiferencies(Tauler altre)
    {
        //TODO: Que torni també la llista de diferencies que troba... pero java es una puta i no deixa parametres per referencia, aixi que esta una mica fucked
        //S'ha de fer sanity-check que comprovi que els dos taulers tenen dimensions iguals
        if (this.tamanyX() != altre.tamanyX() || this.tamanyY() != altre.tamanyY())
        {
            System.out.println("ERROR TAMANYS DE TAULER NO SON IGUALS");
            // throw excepcio
        }
        int diferenciesTrobades = 0;
        for (int x = 0; x < this.tamanyX(); ++x)
        {
            for (int y = 0; y < this.tamanyY(); ++y)
            {
                if (this.getCasella(x, y) != altre.getCasella(x, y))
                {
                    ++diferenciesTrobades;
                }
            }
        }
        return diferenciesTrobades;
    }
}
