package CapaVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by daniel on 16/12/15.
 */
public class VistaSeleccioRanquings extends DialogGeneric
{
    private GridBagLayout layout;
    private JRadioButton radioButtonHidato;
    private JRadioButton radioButtonDificultat;
    private JRadioButton radioButtonCopsResolts;
    private JList listSeleccions;
    private ButtonGroup radioButtonGroup;
    private AbstractListModel<String> modelLlistaHidatos;
    private AbstractListModel<String> modelLlistaDificultat;
    private AbstractListModel<String> modelLlistaCopsResolsts;


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

        toAdd = radioButtonCopsResolts = new JRadioButton("Veure ranquings de millors hidatos per cops resolts");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(toAdd, c);

        toAdd = listSeleccions = new JList();
        listSeleccions.setPreferredSize(new Dimension(150,150));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weighty=2;
        mainPanel.add(toAdd, c);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButtonHidato);
        radioButtonGroup.add(radioButtonDificultat);
        radioButtonGroup.add(radioButtonCopsResolts);

    }

    private void afegirActionListeners()
    {
        radioButtonDificultat.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                listSeleccions.setModel(modelLlistaDificultat);
                listSeleccions.setSelectedIndex(0);
            }
        });
        radioButtonHidato.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                listSeleccions.setModel(modelLlistaHidatos);
                listSeleccions.setSelectedIndex(0);
            }
        });
        radioButtonCopsResolts.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                listSeleccions.setModel(modelLlistaCopsResolsts);
                listSeleccions.setSelectedIndex(0);
            }
        });
    }

    @Override
    public void executaOk()
    {
//        ControladorVista.mostraRanquings(usuari/hidato, id);
    }
}
