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


        toAdd = radioButtonHidato = new JRadioButton("Veure estadistiques de Hidatos");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        listSeleccions = new JList();
        toAdd = new JScrollPane(listSeleccions);
        toAdd.setPreferredSize(new Dimension(300,100));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        radioButtonGroup = new ButtonGroup();

        radioButtonGroup.add(radioButtonHidato);
        radioButtonHidato.setSelected(true);
    }

    private void afegirActionListeners()
    {


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
        totesID = GestorHidato.donaTotesID();
        DefaultListModel<String> listM = new DefaultListModel<>();
        for (Integer i : totesID)
        {
            listM.addElement(i.toString());
        }
        modelLlistaHidatos = listM;

    }


    @Override
    public void executaOk()
    {
        if (listSeleccions.getSelectedValue() == null)
        {
            new NotificacioGenerica("Si us plau, selecciona algun Hidato per veure'n les estadístiques.");
            return;
        }
        ControladorVista.mostraEstadistiquesHidato(Integer.valueOf((String) listSeleccions.getSelectedValue()));
    }
}
