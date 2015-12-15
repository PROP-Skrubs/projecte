package CapaVista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel on 15/12/15.
 */
public class VistaCrearUsuari extends DialogGeneric
{
    private GridBagLayout layout;
    private JTextField campUsuari;
    private JPasswordField campContrasenya;
    private JTextField campNomReal;
    private JLabel labelUsuari;
    private JLabel labelContrasenya;
    private JLabel labelNomReal;

    public VistaCrearUsuari()
    {
        super("Nou usuari");

        afegirComponents();

        pack();
    }

    public VistaCrearUsuari(String nomUsuari, String contrasenya)
    {
        this();
        campUsuari.setText(nomUsuari);
        campContrasenya.setText(contrasenya);
    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

        toAdd = campUsuari = new JTextField();
        toAdd.setPreferredSize(new Dimension(200, 30));
        c = new GridBagConstraints();
        c.insets = new Insets(2,2,2,2);
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = campContrasenya = new JPasswordField();
        toAdd.setPreferredSize(new Dimension(200, 30));
        c = new GridBagConstraints();
        c.insets = new Insets(2,2,2,2);
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = campNomReal = new JTextField();
        toAdd.setPreferredSize(new Dimension(200, 30));
        c = new GridBagConstraints();
        c.insets = new Insets(2,2,2,2);
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(toAdd, c);

        toAdd = labelUsuari = new JLabel("Nom d'Usuari");
        c = new GridBagConstraints();
        c.insets = new Insets(2,2,2,2);
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = labelContrasenya = new JLabel("Contrasenya");
        c = new GridBagConstraints();
        c.insets = new Insets(2,2,2,2);
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = labelNomReal = new JLabel("Nom real");
        c = new GridBagConstraints();
        c.insets = new Insets(2,2,2,2);
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(toAdd, c);


        pack();
    }

    @Override
    public void executaOk()
    {
        String nomUsuari = campUsuari.getText();
        String contrasenya = new String(campContrasenya.getPassword());
        String nomReal = campNomReal.getText();
        if (ControladorVista.demanaCrearUsuari(nomUsuari, contrasenya, nomReal))
        {
            new NotificacioGenerica("Usuari creat correctament");
            dispose();
        }
        else
        {
            new NotificacioGenerica("No s'ha pogut crear l'usuari");
        }
    }
}
