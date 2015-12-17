package CapaVista;

import CapaDomini.Controladors.ControladorRanquing;
import CapaDomini.Modelo.Ranking;
import CapaPersistencia.GestorHidato;

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
    private JList listSeleccions;
    private AbstractListModel<String> modelDificultat;
    private AbstractListModel<String> modelHidatos;
    private ButtonGroup buttonGroup;


    public VistaSeleccioRanquings()
    {
        super("Estadístiques");

        carregaModels();

        afegirComponents();
        afegirActionListeners();

        listSeleccions.setSelectedIndex(0);

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

        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonDificultat);
        buttonGroup.add(radioButtonHidato);
        radioButtonDificultat.setSelected(true);
        listSeleccions.setModel(modelDificultat);
    }

    private void afegirActionListeners()
    {
        radioButtonDificultat.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                listSeleccions.setModel(modelDificultat);
                listSeleccions.setSelectedIndex(0);
            }
        });

        radioButtonHidato.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                listSeleccions.setModel(modelHidatos);
                listSeleccions.setSelectedIndex(0);
            }
        });
    }

    private void carregaModels()
    {
        DefaultListModel<String> m1 = new DefaultListModel<>();
        for (String s : new String[]{"Facil" , "Normal", "Dificil"})
        {
            m1.addElement(s);
        }
        modelDificultat = m1;

        DefaultListModel<String> m2 = new DefaultListModel<>();
        java.util.List<Integer> totesID = GestorHidato.donaTotesID();
        for (Integer i : totesID)
        {
            m2.addElement(i.toString());
        }
        modelHidatos = m2;

    }


    @Override
    public void executaOk()
    {
        java.util.List<Ranking> l;
        if (radioButtonDificultat.isSelected())
        {
            String dificultat = (String) listSeleccions.getSelectedValue();
            l = ControladorRanquing.getTopUsuarisperDificultat(dificultat);
        }
        else
        {
            String idHidato = (String) listSeleccions.getSelectedValue();
            l = ControladorRanquing.getTopUsuarisperHidato(Integer.valueOf(idHidato));
        }
        new VistaMostraRanquing(l).mostra(true);
    }
}
