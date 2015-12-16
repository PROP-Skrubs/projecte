package CapaVista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel on 16/12/15.
 */
public class VistaSeleccioEstadistiques extends DialogGeneric
{
    private GridBagLayout layout;
    private JRadioButton radioButtonUsuari;
    private JRadioButton radioButtonHidato;
    private JList listSeleccions;


    public VistaSeleccioEstadistiques()
    {
        super("Estadístiques");

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

        toAdd = radioButtonUsuari = new JRadioButton("Veure estadístiques de Hidatos");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = radioButtonHidato = new JRadioButton("Veure estadistiques de usuaris");
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

    @Override
    public void executaOk()
    {
//        ControladorVista.mostraEstadistiques(usuari/hidato, id);
    }
}
