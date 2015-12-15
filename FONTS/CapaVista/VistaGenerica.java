package CapaVista;

/**
 * Created by daniel on 14/12/15.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VistaGenerica extends VistaComu
{
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
}
