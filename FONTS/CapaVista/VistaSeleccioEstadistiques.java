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
        listSeleccions.setModel(modelLlistaHidatos);
        listSeleccions.setSelectedIndex(0);

        pack();
    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

//        toAdd = radioButtonUsuari = new JRadioButton("Veure estadístiques de Usuaris");
//        c = new GridBagConstraints();
//        c.gridx = 0;
//        c.gridy = 0;
//        mainPanel.add(toAdd, c);

        toAdd = radioButtonHidato = new JRadioButton("Veure estadistiques de Hidatos");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = listSeleccions = new JList();
        listSeleccions.setPreferredSize(new Dimension(150,150));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        radioButtonGroup = new ButtonGroup();
//        radioButtonGroup.add(radioButtonUsuari);
        radioButtonGroup.add(radioButtonHidato);
        radioButtonHidato.setSelected(true);
    }

    private void afegirActionListeners()
    {
//        radioButtonUsuari.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent)
//            {
//                listSeleccions.setModel(modelLlistaUsuaris);
//                listSeleccions.setSelectedIndex(0);
//            }
//        });
        radioButtonHidato.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                listSeleccions.setModel(modelLlistaHidatos);
                listSeleccions.setSelectedIndex(0);
            }
        });
    }

    public void carregaModel(int quinModel)
    {
        java.util.List<Integer> totesID;
//        java.util.List<String> totesNOM;

//            totesNOM = GestorUsuari.donaTotsNom();
            totesID = GestorHidato.donaTotesID();

        DefaultListModel<String> listM = new DefaultListModel<>();

//        if (quinModel == 1)
//        {
//            for (String s : totesNOM)
//            {
//                listM.addElement(s);
//                modelLlistaUsuaris = listM;
//            }
//        }
//        else
//        {
            for (Integer i : totesID)
            {
                listM.addElement(i.toString());
            }
        modelLlistaHidatos = listM;
        //        }
    }


    @Override
    public void executaOk()
    {
//        if (radioButtonUsuari.isSelected())
//        {
//            ControladorVista.mostrarEstadistiquesUsuari((String) listSeleccions.getSelectedValue());
//        }
//        else
//        {
            ControladorVista.mostraEstadistiquesHidato(Integer.valueOf((String) listSeleccions.getSelectedValue()));
//        }
    }
}
