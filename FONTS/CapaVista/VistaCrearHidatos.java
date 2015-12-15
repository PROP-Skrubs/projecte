package CapaVista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel on 14/12/15.
 */
public class VistaCrearHidatos extends DialogGeneric
{
    private GridBagLayout layout;
    private JRadioButton radioButtonAutomatic;
    private JRadioButton radioButtonManual;
    private JSpinner spinnerTamanyManual;
    private ButtonGroup radioButtonGroup;

    public VistaCrearHidatos()
    {
        super("Selecciona mode creació hidato");

        afegirComponents();

        pack();
    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;


        toAdd = radioButtonManual = new JRadioButton("Vull crear un Hidato a partir de valors predeterminats");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = radioButtonAutomatic = new JRadioButton("Vull crear un Hidato manualment (introdueix el tamany del tauler)");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = spinnerTamanyManual = new JSpinner();
        toAdd.setPreferredSize(new Dimension(50,0));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButtonAutomatic);
        radioButtonGroup.add(radioButtonManual);
    }

    private void afegirActionListener()
    {
        //enabled
    }

}
