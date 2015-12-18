package CapaVista;

import CapaDomini.Controladors.ControladorLogin;
import CapaDomini.Controladors.ControladorPartida;
import CapaDomini.Modelo.Hidato;
import CapaDomini.Modelo.Partida;
import CapaPersistencia.GestorHidato;
import CapaPersistencia.GestorPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    java.util.List<Integer> idHidatos;
    java.util.List<Integer> idPartides;

    public VistaComencarPartida()
    {
        super("Jugar");

        afegirComponents();
        afegirActionListeners();

        carregaModel();
        listSeleccions.setModel(modelLlistaHidatos);

        pack();
    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

        toAdd = radioButtonNovaPartida = new JRadioButton("Vull seleccionar un Hidato començar una nova partida");
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = radioButtonCarregarPartida = new JRadioButton("Vull carregar una partida en curs");
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        listSeleccions = new JList();
        toAdd = new JScrollPane(listSeleccions);
        toAdd.setPreferredSize(new Dimension(300,100));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight= GridBagConstraints.REMAINDER;
        mainPanel.add(toAdd, c);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButtonCarregarPartida);
        radioButtonGroup.add(radioButtonNovaPartida);
        radioButtonNovaPartida.setSelected(true);
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


    public void carregaModel()
    {
        idHidatos = GestorHidato.donaTotesID();
        idPartides = GestorPartida.donaIdsegonsUsuari(ControladorLogin.getUsuariActual().getUniqID());
        java.util.List<Hidato> hidatos = new ArrayList<>();
        java.util.List<Partida> partides= new ArrayList<>();
        for (Integer id : idHidatos)
        {
            hidatos.add(GestorHidato.donaHidato(id));
        }
        for (Integer id : idPartides)
        {
            partides.add(GestorPartida.donaPartida(id));
        }
        DefaultListModel<String> modelHidatos = new DefaultListModel<>();
        DefaultListModel<String> modelPartides = new DefaultListModel<>();
        for (Hidato h : hidatos)
        {
            String descripcio = "Hidato: " + Integer.toString(h.getUniqID()) + "    Dificultat: " + h.getDificultat() +  "    Tamany: " + h.getTamany();
            modelHidatos.addElement(descripcio);
        }
        for (Partida p : partides)
        {
            String descripcio = "ID: " + Integer.toString(p.getUniqID()) + "    Hidato: " + p.getIDHidato();
            modelPartides.addElement(descripcio);
        }
        modelLlistaPartides = modelPartides;
        modelLlistaHidatos = modelHidatos;

    }

    @Override
    public void executaOk()
    {
        if (listSeleccions.getSelectedValue() == null)
        {
            new NotificacioGenerica("Si us plau, selecciona alguna partida o Hidato.");
            return;
        }
        int indexSeleccionat = listSeleccions.getSelectedIndex();


        if (radioButtonCarregarPartida.isSelected())
        {
            Integer idSeleccionada = idPartides.get(indexSeleccionat);
            ControladorPartida.carregarPartida(idSeleccionada); //todo verificar que un usuari nomes pugui carregar la seva partida
        }
        else if (radioButtonNovaPartida.isSelected())
        {
            Integer idSeleccionada = idHidatos.get(indexSeleccionat);
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
