package CapaVista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel on 14/12/15.
 */
public class VistaMenuPrincipal extends VistaGenerica
{
    private GridBagLayout layout;
    private JButton buttonJugarHidato;
    private JButton buttonCrearHidato;
    private JButton buttonVeureEstadistiques;
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
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);


        toAdd = buttonJugarHidato = new JButton("Jugar");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = buttonCrearHidato = new JButton("Crear nou Hidato");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(toAdd, c);

        toAdd = buttonVeureEstadistiques = new JButton("Estadístiques i rànquings");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(toAdd, c);
    }

    private void afegirActionListeners()
    {

    }

    private String donaNomUsuari()
    {
        return "ESTATIC";
    }
}
