package CapaVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by daniel on 14/12/15.
 */
public class VistaCrearHidatos extends DialogGeneric
{
    private GridBagLayout layout;
    private JRadioButton radioButtonAutomatic;
    private JRadioButton radioButtonManual;
    private JRadioButton radioButtonFitxer;
    private JSpinner spinnerTamanyManual;
    private ButtonGroup radioButtonGroup;
    JFileChooser chooser;

    public VistaCrearHidatos()
    {
        super("Selecciona mode creació hidato");

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


        toAdd = radioButtonAutomatic = new JRadioButton("Vull crear un Hidato a partir de valors predeterminats");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = radioButtonManual = new JRadioButton("Vull crear un Hidato manualment (introdueix el tamany del tauler)");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = spinnerTamanyManual = new JSpinner(new SpinnerNumberModel(5, 3, 10, 1));
        toAdd.setPreferredSize(new Dimension(50,0));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = radioButtonFitxer = new JRadioButton("Vull escollir un fitxer");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(toAdd, c);

        chooser = new JFileChooser(".");

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButtonAutomatic);
        radioButtonGroup.add(radioButtonManual);
        radioButtonGroup.add(radioButtonFitxer);
        radioButtonAutomatic.setSelected(true);
    }

    private void afegirActionListeners()
    {
        radioButtonAutomatic.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                chooser.setEnabled(false);
            }
        });
        radioButtonManual.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                chooser.setEnabled(false);
            }
        });
        radioButtonFitxer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                chooser.setEnabled(true);
                chooser.showOpenDialog(mainPanel);
            }
        });
    }



    @Override
    public void executaOk()
    {
        if (radioButtonAutomatic.isSelected())
        {
            ControladorVista.demanaCrearHidatoAutomaticament();
        }
        if (radioButtonManual.isSelected())
        {
            ControladorVista.demanaCrearHidatoManualment((int) spinnerTamanyManual.getValue());
        }
        if (radioButtonFitxer.isSelected())
        {
            ControladorVista.demanaCrearHidatoFitxer(chooser.getSelectedFile().getAbsolutePath());
        }
        dispose();
    }
}
