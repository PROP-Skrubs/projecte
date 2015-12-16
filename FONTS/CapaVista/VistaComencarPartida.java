package CapaVista;

import CapaDomini.Controladors.ControladorLogin;
import CapaDomini.Controladors.ControladorPartida;
import CapaPersistencia.GestorHidato;
import CapaPersistencia.GestorPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by daniel on 15/12/15.
 */
public class VistaComencarPartida extends DialogGeneric
{
    private GridBagLayout layout;
    private JRadioButton radioButtonNovaPartida;
    private JRadioButton radioButtonCarregarPartida;
    private JList listSeleccions;
    private ButtonGroup radioButtonGroup;
    private AbstractListModel<String> modelLlistaPartides;
    private AbstractListModel<String> modelLlistaHidatos;


    public VistaComencarPartida()
    {
        super("Jugar");

        afegirComponents();
        afegirActionListeners();

        carregaModel(1);
        carregaModel(2);
        listSeleccions.setModel(modelLlistaPartides);

        pack();
    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

        toAdd = radioButtonNovaPartida = new JRadioButton("Vull començar una nova partida");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = radioButtonCarregarPartida = new JRadioButton("Vull carregar una partida en curs");
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
        c.weighty= GridBagConstraints.REMAINDER;
        mainPanel.add(toAdd, c);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButtonCarregarPartida);
        radioButtonGroup.add(radioButtonNovaPartida);
        radioButtonCarregarPartida.setSelected(true);
    }

    private void afegirActionListeners()
    {
        radioButtonCarregarPartida.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                listSeleccions.setModel(modelLlistaPartides);
                listSeleccions.setSelectedIndex(0);
            }
        });

        radioButtonNovaPartida.addActionListener(new ActionListener()
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
        if (quinModel == 1) //Partida
        {
            totesID = GestorPartida.donaTotesID();
        }
        else
        {
            totesID = GestorHidato.donaTotesID();
        }

        DefaultListModel<String> listM = new DefaultListModel<>();
        for (Integer i : totesID)
        {
            listM.addElement(i.toString());
        }
        if (quinModel == 1)
        {
            modelLlistaPartides = listM;
        }
        else
        {
            modelLlistaHidatos = listM;
        }
    }

    @Override
    public void executaOk()
    {
        if (listSeleccions.getSelectedValue() == null) return;
        Integer idSeleccionada = Integer.valueOf((String) listSeleccions.getSelectedValue());
        if (radioButtonCarregarPartida.isSelected())
        {
            ControladorPartida.carregarPartida(idSeleccionada); //todo verificar que un usuari nomes pugui carregar la seva partida
        }
        else if (radioButtonNovaPartida.isSelected())
        {
            ControladorPartida.novaPartida(ControladorLogin.getUsuariActual().getUniqID(), idSeleccionada);
        }
        else
        {
            throw new RuntimeException("Que vols que faci?");
        }
        ControladorPartida.jugaPartida();
        dispose();

    }
}
