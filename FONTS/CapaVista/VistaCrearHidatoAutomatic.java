package CapaVista;

import CapaDomini.Modelo.Algoritmes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel on 14/12/15.
 */
public class VistaCrearHidatoAutomatic extends DialogGeneric
{
    private GridBagLayout layout;
    private JSpinner spinnerTamanyHidato;
    private JSpinner spinnerForats;
    private JSpinner spinnerNumerosPrecolocats;
    private JLabel labelTamanyHidato;
    private JLabel labelForats;
    private JLabel labelNumerosPrecolocats;
    private JComboBox comboBoxDificultat;
    private JLabel labelDificultat;



    public VistaCrearHidatoAutomatic()
    {
        super("Crear tauler manualment");

        afegirComponents();
        afegirActionListeners();

        pack();
    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

        toAdd = spinnerTamanyHidato = new JSpinner(new SpinnerNumberModel(5, 3, 10, 1));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = labelTamanyHidato = new JLabel("Tamany de l'Hidato");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd,c);

        toAdd = spinnerForats = new JSpinner(new SpinnerNumberModel(2, 0, 30, 1));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(toAdd,c);

        toAdd = labelForats = new JLabel("\"Forats\" o caselles no usables");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd,c);

        toAdd = spinnerNumerosPrecolocats = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(toAdd,c);

        toAdd = labelNumerosPrecolocats = new JLabel("Numeros pre-colocats");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(toAdd,c);

        toAdd = comboBoxDificultat = new JComboBox();
        DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Fàcil");
        defaultComboBoxModel1.addElement("Normal");
        defaultComboBoxModel1.addElement("Difícil");
        comboBoxDificultat.setModel(defaultComboBoxModel1);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        mainPanel.add(toAdd,c);

        toAdd = labelDificultat = new JLabel("Dificultat");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(toAdd,c);
    }

    private void afegirActionListeners()
    {

    }

    @Override
    public void executaOk()
    {
        int tamany = (int) spinnerTamanyHidato.getValue();
        int numForats = (int) spinnerForats.getValue();
        int numColocats = (int) spinnerNumerosPrecolocats.getValue();
        int dificultat= comboBoxDificultat.getSelectedIndex();

        String missatgeError = "No inicialitzat";
        switch (ControladorVista.demanaValidacioParametres(tamany,numForats,numColocats,dificultat))
        {
            case Algoritmes.OK:
            {
                int nouHidato = ControladorVista.demanaCreacioAutomatica(tamany, numForats, numColocats, (String) comboBoxDificultat.getSelectedItem());
                ControladorVista.mostraHidato(nouHidato);
                dispose();
                return;
            }
            case Algoritmes.ERRORTAMANY:
            {
                missatgeError = "El tamany ha d'estar entre 3 i 10";
                break;
            }
            case Algoritmes.DIFICULTATINCORRECTA:
            {
                missatgeError = "Dificultat incorrecta";
                break;
            }
            case Algoritmes.ERRORFORATS:
            {
                missatgeError = "Els forats han d'estar en el rang 0% - 30%";
                break;
            }
            case Algoritmes.ERRORNUMPREDETERMINATS:
            {
                missatgeError = "Els numero de caselles precolocades ha d'estar en el rang\n75% - 82% per a Dificil\n83% - 90% per a Normal\n91% - 96% per a Facil";
                break;
            }
        }
        new NotificacioGenerica(missatgeError).mostra(true);
    }
}
