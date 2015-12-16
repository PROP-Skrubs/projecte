package CapaVista;

import CapaDomini.Controladors.ControladorEstadisticas;
import CapaDomini.Modelo.EstadisticasHidato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by daniel on 16/12/15.
 */
public class VistaMostraEstadisticaHidato extends VistaGenerica
{
    private GridBagLayout layout;
    private JLabel labelCopsResolts;
    private JLabel labelCopsIntentat;
    private JLabel labelTempsMig;
    private JLabel labelNumAjudes;
    private JButton buttonOk;
    protected EstadisticasHidato h;

    VistaMostraEstadisticaHidato()
    {
        super();

        afegirComponents();
        afegirActionListeners();

        pack();

    }

    VistaMostraEstadisticaHidato(int idHidato)
    {
        super();

        afegirComponents();
        afegirActionListeners();

        setTitol("Estadistiques de l'Hidato " + h.getIdHidato());
        pack();
    }

    private void construeix()
    {

    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

        toAdd = labelCopsIntentat = new JLabel("Cops intentat: " + h.getIntents());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = labelCopsResolts = new JLabel("Cops resolts: " + h.getCops_res());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = labelTempsMig = new JLabel("Temps mig: " + h.getTemps_mig());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(toAdd, c);

        toAdd = labelNumAjudes = new JLabel("Ajudes utilitzades: " + h.getAjudes());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(toAdd, c);

        toAdd = buttonOk = new JButton("D'acord!");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 4;
        mainPanel.add(toAdd, c);

    }

    private void afegirActionListeners()
    {
        buttonOk.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                dispose();
            }
        });
    }
}
