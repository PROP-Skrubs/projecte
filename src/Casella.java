/**
 * Created by cross on 20/10/15.
 */
public class Casella {
    public int elem;
    public int x;
    public int y;
    public static int FORAT = -1;
    public static int BUIT = 0;

    public Casella() {}
    public Casella(int x, int y, int elem)
    {
        this.x = x;
        this.y = y;
        this.elem = elem;
    }

    /*public Casella clone()
    {
        Casella ret = new Casella(this.x, this.y, this.elem);

        return ret;

    }*/
}
