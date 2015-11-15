package CapaVista;

import CapaDomini.Casella;
import CapaDomini.Tauler;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel on 15/11/15.
 */
public class TaulerDisplayer extends JPanel
{
    /**todo:
     *  implementar espacios entre casillas
     *  implementar highlighting
     *  implementar click-edit
     *
     */
    private JLabel[][] numerosAlTauler;
    public TaulerDisplayer(int tamany)
    {
        setLayout(new GridLayout(tamany,tamany));
        numerosAlTauler = new JLabel[tamany][tamany];
        for (int i = 0; i < tamany; ++i)
        {
            for (int j = 0; j < tamany; ++j)
            {
                numerosAlTauler[i][j] = new JLabel();
                add(numerosAlTauler[i][j]);
            }
        }
    }

    public void setCasella(Casella c)
    {
        numerosAlTauler[c.x][c.y].setText(Integer.toString(c.elem));
    }

//    public static void main(String[] args)
//    {
//        JFrame f = new JFrame();
//        TaulerDisplayer t = new TaulerDisplayer(5);
//        f.setContentPane(t);
//        for (int i = 0; i < 5; ++i)
//            for (int j = 0; j < 5; ++j)
//                t.setCasella(new Casella(i,j,i+1));
//        f.pack();
//        f.setVisible(true);
//    }

}
