package CapaVista;

import CapaDomini.Controladors.ControladorLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by daniel on 14/12/15.
 */
public class VistaMenuPrincipal extends VistaGenerica
{
    private GridBagLayout layout;
    private JButton buttonJugarHidato;
    private JButton buttonCrearHidato;
    private JButton buttonVeureEstadistiques;
    private JButton buttonVeureRanquings;
    private JLabel labelTextBenvinguda;


    public VistaMenuPrincipal()
    {
        super("Menú principal");

        afegirComponents();
        afegirActionListeners();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

        toAdd = labelTextBenvinguda = new JLabel("Benvingut, " + donaNomUsuari());
        c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight=GridBagConstraints.REMAINDER;
        mainPanel.add(toAdd, c);

        toAdd = new JPanel();
        toAdd.setPreferredSize(new Dimension(20,0));
        c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.gridx=1;
        c.gridheight=GridBagConstraints.REMAINDER;
        mainPanel.add(toAdd,c);

        toAdd = buttonJugarHidato = new JButton("Jugar");
        c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = buttonCrearHidato = new JButton("Crear nou Hidato");
        c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 2;
        mainPanel.add(toAdd, c);

        toAdd = buttonVeureEstadistiques = new JButton("Estadístiques");
        c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 3;
        mainPanel.add(toAdd, c);

        toAdd = buttonVeureRanquings = new JButton("Rànquings");
        c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 4;
        mainPanel.add(toAdd, c);


    }


    private void afegirActionListeners()
    {
        buttonCrearHidato.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new VistaCrearHidatos().mostra(true);
            }
        });

        buttonJugarHidato.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new VistaComencarPartida().mostra(true);
            }
        });

        buttonVeureEstadistiques.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                ControladorVista.mostraSeleccioEstadistiques();
            }
        });

        buttonVeureRanquings.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                ControladorVista.mostraSeleccioRanquings();
            }
        });
    }

    private String donaNomUsuari()
    {
        return ControladorLogin.getUsuariActual().getNomReal();
    }
}
