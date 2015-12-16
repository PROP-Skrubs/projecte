package CapaVista;

import CapaPersistencia.GestorHidato;
import CapaPersistencia.GestorUsuari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by daniel on 16/12/15.
 */
public class VistaSeleccioEstadistiques extends DialogGeneric
{
    private GridBagLayout layout;
    private JRadioButton radioButtonUsuari;
    private JRadioButton radioButtonHidato;
    private JList listSeleccions;
    private ButtonGroup radioButtonGroup;
    private AbstractListModel<String> modelLlistaHidatos;
    private AbstractListModel<String> modelLlistaUsuaris;

    public VistaSeleccioEstadistiques()
    {
        super("Estadístiques");

        afegirComponents();
        afegirActionListeners();

        carregaModel(1);
        carregaModel(2);
        listSeleccions.setModel(modelLlistaUsuaris);

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

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButtonHidato);
        radioButtonGroup.add(radioButtonUsuari);
    }

    private void afegirActionListeners()
    {
        radioButtonUsuari.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                listSeleccions.setModel(modelLlistaUsuaris);
            }
        });
        radioButtonUsuari.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                listSeleccions.setModel(modelLlistaHidatos);
            }
        });
    }

    public void carregaModel(int quinModel)
    {
        java.util.List<Integer> totesID;
        java.util.List<String> totesNOM;

            totesNOM = GestorUsuari.donaTotesID();
            totesID = GestorHidato.donaTotesID();

        DefaultListModel<String> listM = new DefaultListModel<>();

        if (quinModel == 1)
        {
            for (String s : totesNOM)
            {
                listM.addElement(s);
                modelLlistaUsuaris = listM;
            }
        }
        else
        {
            for (Integer i : totesID)
            {
                listM.addElement(i.toString());
                modelLlistaHidatos = listM;
            }
        }
    }


    @Override
    public void executaOk()
    {
//        ControladorVista.mostraEstadistiques(usuari/hidato, id);
    }
}
