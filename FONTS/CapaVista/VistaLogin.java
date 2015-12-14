package CapaVista;

/**
 * Created by daniel on 14/12/15.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VistaLogin extends VistaGenerica
{
    private GridBagLayout layout;
    private JButton botoEntrar;
    private JButton botoCrearCompte;
    private JLabel labelNomUsuari;
    private JLabel labelContrasenya;
    private JTextField campUsuari;
    private JPasswordField campContrasenya;

    public VistaLogin()
    {
        super("Benvingut");

        afegirComponents();
//        afegirActionListeners();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

        toAdd = botoEntrar = new JButton("Entra");
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 2;
        mainPanel.add(toAdd, c);

        toAdd = botoCrearCompte = new JButton("Crear nou compte d'usuari");
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 3;
        mainPanel.add(toAdd, c);

        toAdd = labelNomUsuari = new JLabel("Nom d'Usuari");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = labelContrasenya = new JLabel("Contrasenya");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd, c);

        toAdd = campUsuari = new JTextField();
        toAdd.setPreferredSize(new Dimension(200, 30));
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = campContrasenya = new JPasswordField();
        toAdd.setPreferredSize(new Dimension(200, 30));
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(toAdd, c);
    }

//    private void afegirActionListeners()
//    {
//        botoEntrar.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent actionEvent)
//             {
//                 String nomUsuari = campUsuari.getText();
//                 String contrasenya = new String(campContrasenya.getPassword());
//
//                 if (ControladorLogin.fesLogin(nomUsuari, contrasenya))
//                 {
//                     new MenuPrincipal();
//                     //TODO: que el menu es mostri al centre de la pantalla
//                     dispose();
//                 }
//                 else
//                 {
//                     //Alerta a l'usuari que el login ha sigut incorrecte
//                     //TODO: aixo es pot fer amb un "pop-up" grafic, oi? :)
//                     System.out.println("Login incorrecte");
//                 }
//             }
//        });
//
//        botoCrearCompte.addActionListener(new ActionListener()
//        {
//              @Override
//              public void actionPerformed(ActionEvent actionEvent)
//              {
//                  String nomUsuari = campUsuari.getText();
//                  String contrasenya = new String(campContrasenya.getPassword());
//                  String nomReal = "pepito";
//                  boolean usuariCreatCorrectament = ControladorUsuari.crearUsuari(nomUsuari, contrasenya, nomReal);
//
//                  //TODO: aixo es pot fer amb un "pop-up" grafic, oi? :)
//                  if (usuariCreatCorrectament)
//                      System.out.println("Usuari creat correctament");
//                  else
//                      System.out.println("Ja existia un usuari amb aquest nom!!");
//              }
//        });
//
//    }
}
