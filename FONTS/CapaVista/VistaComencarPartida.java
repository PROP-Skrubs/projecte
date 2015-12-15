package CapaVista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel on 15/12/15.
 */
public class VistaComencarPartida extends DialogGeneric
{
    private GridBagLayout layout;
    private JRadioButton radioButtonNovaPartida;
    private JRadioButton radioButtonCarregarPartida;
    private JList listSeleccions;


    public VistaComencarPartida()
    {
        super("Jugar");

        afegirComponents();
        afegirActionListeners();

        pack();
    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

        toAdd = radioButtonNovaPartida = new JRadioButton("Vull començar una nova partida");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = radioButtonCarregarPartida = new JRadioButton("Vull carregar una partida en curs");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = listSeleccions = new JList();
        listSeleccions.setPreferredSize(new Dimension(150,150));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weighty=2;
        mainPanel.add(toAdd, c);
    }

    private void afegirActionListeners()
    {

    }

}
