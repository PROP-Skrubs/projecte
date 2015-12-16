package CapaVista;

import javax.swing.*;

/**
 * Created by daniel on 15/12/15.
 */
public class VistaComu
{
    protected JFrame frame;

    public void mostra(boolean b)
    {
        centra();
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

    protected void centra()
    {
        frame.setLocationRelativeTo(null);
    }

    protected void setTitol(String titol)
    {
        frame.setTitle(titol);
    }
}
