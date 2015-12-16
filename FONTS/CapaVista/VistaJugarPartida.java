package CapaVista;

import CapaDomini.Controladors.ControladorPartida;
import CapaDomini.Algoritmes.Tauler;
import CapaDomini.Algoritmes.TaulerDisplayerCallbacks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by daniel on 15/12/15.
 */
public class VistaJugarPartida extends VistaGenerica
{
    private GridBagLayout layout;
    private TaulerDisplayer taulerDisplayer;
    private JButton buttonGuardarPartida;
    private JButton buttonSortir;
    private JButton buttonValidar;
    private JLabel labelContador;
    int horas = 0;
    int min = 0;
    int seg = 0;


    public VistaJugarPartida()
    {

    }

    public VistaJugarPartida(Tauler taulerProgres, TaulerDisplayerCallbacks cMethods, int segonsTranscorreguts)
    {
        super("Jugar");

        conversionInicial(segonsTranscorreguts);

        afegirComponents();
        afegirActionListeners();

        taulerDisplayer.setTauler(taulerProgres);
        taulerDisplayer.setCallbackMethods(cMethods);
        taulerDisplayer.requestFocusInWindow();

        pack();
    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

        toAdd = taulerDisplayer = new TaulerDisplayer();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = GridBagConstraints.REMAINDER;
        mainPanel.add(toAdd, c);

        toAdd = labelContador = new JLabel();
        int delay = 1000; //milliseconds
        labelContador.setText("00:00:00");
        ActionListener taskPerformer = new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                seg += 1;
                String count = conversion(seg);
                labelContador.setText(count);
                if (seg > 59) seg = 0;
            }
        };
        new Timer(delay, taskPerformer).start();

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = buttonValidar = new JButton("Validar Hidato");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = buttonGuardarPartida = new JButton("Guardar Partida");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(toAdd, c);

        toAdd = buttonSortir = new JButton("Sortir");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        mainPanel.add(toAdd, c);

        pack();
    }

    private void afegirActionListeners()
    {
        buttonGuardarPartida.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                ControladorPartida.guardarPartida(horas*3600+min*60+seg);
                new NotificacioGenerica("Partida guardada correctament!").mostra(true);
            }
        });

        buttonSortir.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                ControladorPartida.actualitzaEstadistiquesIRanquings();
                dispose();
            }
        });

        buttonValidar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (ControladorPartida.esAcabada())
                {
                    ControladorPartida.actualitzaEstadistiquesIRanquings();
                    new NotificacioGenerica("Enhorabona per guanyar!").mostra(true);
                    dispose();
                }
                else
                {
                    new NotificacioGenerica("L'Hidato encara no és correcte!").mostra(true);
                }
            }
        });

    }


    private String conversion(int seg)
    {
        String segundos;
        String minutos;
        String hora;
        if (seg == 60)
        {
            ++min;
            seg = 0;
            if (min == 60)
            {
                ++horas;
                min = 0;
            }
        }
        if (seg < 10)
        {
            segundos = "0" + seg;
        }
        else
        {
            segundos = String.valueOf(seg);
        }
        if (min < 10)
        {
            minutos = "0" + min;
        }
        else
        {
            minutos = String.valueOf(min);
        }
        if (horas < 10)
        {
            hora = "0" + horas;
        }
        else
        {
            hora = String.valueOf(horas);
        }
        String r = hora + ":" + minutos + ":" + segundos;
        return r;
    }

    private void conversionInicial(int segundos)
    {
        horas = segundos/3600;
        segundos = segundos%3600;
        min = segundos/60;
        segundos = segundos%60;
        seg = segundos;
    }
}
