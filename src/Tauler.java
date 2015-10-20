public class Tauler
{
    private class Casella
    {
        public int valor;
        public int x;
        public int y;
    }
    private Casella[][] tauler;
    private static int FORAT = -1;
    private static int BUIT = 0;

    public Tauler()
    //Incloem un constructor sense arguments perque requeriments del llenguatge, però no el fem servir
    {
        //Com que aquest constructor no s'hauria de fer servir mai, faig que tiri excepcions si es invocat i així ajudi a detectar errors de disseny
        throw new RuntimeException("ERROR: INVOCAT EL CONSTRUCTOR PER DEFECTE DE TAULER!");
    }

    public Tauler(int tamany)
    {
        tauler = new int[tamany][tamany];
    }

    public int getCasella(int posX, int posY)
    {
        return tauler[posX][posY];
    }

    public void setCasella(int posX, int posY, int valor)
    {
        tauler[posX][posY] = valor;
    }

    public int tamanyX()
    {
        return tauler.length;
    }

    public int tamanyY()
    {
        return tauler[0].length;
    }
}

