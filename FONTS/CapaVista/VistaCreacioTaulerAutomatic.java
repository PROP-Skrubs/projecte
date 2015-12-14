package CapaVista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel on 14/12/15.
 */
public class VistaCreacioTaulerAutomatic extends DialogGeneric
{
    private GridBagLayout layout;
    private JSpinner spinnerTamanyHidato;
    private JSpinner spinnerForats;
    private JSpinner spinnerNumerosPrecolocats;
    private JLabel labelTamanyHidato;
    private JLabel labelForats;
    private JLabel labelNumerosPrecolocats;
    private JComboBox comboBoxDificultat;
    private JLabel labelDificultat;



    public VistaCreacioTaulerAutomatic()
    {
        super("Crear tauler manualment");

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

        toAdd = spinnerTamanyHidato = new JSpinner();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = labelTamanyHidato = new JLabel("Tamany de l'Hidato");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd,c);

        toAdd = spinnerForats = new JSpinner();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(toAdd,c);

        toAdd = labelForats = new JLabel("\"Forats\" o caselles no usables");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd,c);

        toAdd = spinnerNumerosPrecolocats = new JSpinner();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(toAdd,c);

        toAdd = labelNumerosPrecolocats = new JLabel("Numeros pre-colocats");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(toAdd,c);

        toAdd = comboBoxDificultat = new JComboBox();
        DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Fàcil");
        defaultComboBoxModel1.addElement("Normal");
        defaultComboBoxModel1.addElement("Difícil");
        comboBoxDificultat.setModel(defaultComboBoxModel1);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        mainPanel.add(toAdd,c);

        toAdd = labelDificultat = new JLabel("Dificultat");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(toAdd,c);
    }

    private void afegirActionListeners()
    {

    }

}
