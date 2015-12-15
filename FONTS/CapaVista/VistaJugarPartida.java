package CapaVista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel on 15/12/15.
 */
public class VistaJugarPartida extends VistaGenerica
{
    private GridBagLayout layout;
    private TaulerDisplayer taulerDisplayer;
    private JButton buttonGuardarPartida;
    private JButton buttonSortir;
    private JLabel labelContador;

    public VistaJugarPartida()
    {
        super("Jugar");

        afegirComponents();
        afegirActionListeners();

    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

        toAdd = taulerDisplayer = new TaulerDisplayer();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = GridBagConstraints.REMAINDER;
        mainPanel.add(toAdd, c);

        toAdd = labelContador = new JLabel();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(toAdd, c);


        toAdd = buttonGuardarPartida = new JButton("Guardar Partida");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = buttonSortir = new JButton("Sortir");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(toAdd, c);

        pack();
    }

    private void afegirActionListeners()
    {

    }
}
