package CapaVista;

/**
 * Created by daniel on 14/12/15.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VistaGenerica
{
    private JFrame frame;
    protected JPanel mainPanel;

    public VistaGenerica()
    {
        this("Finestra generica");
    }

    public VistaGenerica(String titolFinestra)
    {
        frame = new JFrame(titolFinestra);
        mainPanel = new JPanel();
        frame.setContentPane(mainPanel);

        //frame.setSize(tamanyX,tamanyY);
        //setBackgroundPicture


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
    }

    public void mostra(boolean b)
    {
        frame.setVisible(b);
    }

    protected void setDefaultCloseOperation(int op)
    {
        frame.setDefaultCloseOperation(op);
    }

    protected void pack()
    {
        frame.pack();
    }

    protected void dispose()
    {
        frame.dispose();
    }
}
