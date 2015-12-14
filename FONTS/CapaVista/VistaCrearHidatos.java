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

    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

        toAdd = radioButtonAutomatic = new JRadioButton();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = radioButtonManual = new JRadioButton();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = spinnerTamanyManual = new JSpinner();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(automaticamentRadioButton);
        radioButtonGroup.add(manualmentRadioButton);

    }

    private void afegirActionListener()
    {
        //enabled
    }

}
