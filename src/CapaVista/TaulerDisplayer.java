package CapaVista;

import CapaDomini.Casella;
import CapaDomini.Tauler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by daniel on 15/11/15.
 */
public class TaulerDisplayer extends JPanel
{
    /**
     * todo:
     * implementar espacios entre casillas
     * implementar highlighting
     * implementar click-edit
     */
    private JLabel[][] numerosAlTauler;

    public TaulerDisplayer(int tamany)
    {
        GridLayout g = new GridLayout(tamany, tamany);
        setLayout(g);
        numerosAlTauler = new JLabel[tamany][tamany];
        for (int i = 0; i < tamany; ++i)
        {
            for (int j = 0; j < tamany; ++j)
            {
                numerosAlTauler[i][j] = new JLabel();
                numerosAlTauler[i][j].setFont(numerosAlTauler[i][j].getFont().deriveFont(32.0f));
                add(numerosAlTauler[i][j]);
            }
        }
        g.setHgap(5);
        g.setVgap(5);

        setFocusable(true);
        requestFocus();

        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent keyEvent)
            {
                numerosAlTauler[2][5].setText(Character.toString(keyEvent.getKeyChar()));
            }

            @Override
            public void keyPressed(KeyEvent keyEvent)
            {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent)
            {

            }
        });
    }

    public void setCasella(Casella c)
    {
        numerosAlTauler[c.x][c.y].setText(Integer.toString(c.elem));
    }


    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        TaulerDisplayer t = new TaulerDisplayer(10);
        f.setContentPane(t);
        for (int i = 0; i < 10; ++i)
            for (int j = 0; j < 10; ++j)
                t.setCasella(new Casella(i, j, i + 1));
        f.pack();
        f.setVisible(true);
    }

}
