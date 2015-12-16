package CapaVista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel on 16/12/15.
 */
public class VistaSeleccioRanquings extends DialogGeneric
{
    private GridBagLayout layout;
    private JRadioButton radioButtonHidato;
    private JRadioButton radioButtonDificultat;
    private JList listSeleccions;


    public VistaSeleccioRanquings()
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

        toAdd = radioButtonHidato = new JRadioButton("Veure ranquings de millors usuaris per hidato");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = radioButtonDificultat = new JRadioButton("Veure ranquings de millors usuaris per dificultat");
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
//        ControladorVista.mostraRanquings(usuari/hidato, id);
    }
}
