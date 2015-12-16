package CapaVista;

import CapaDomini.Modelo.Tauler;
import CapaDomini.Modelo.TaulerDisplayerCallbacks;
import CapaDomini.Modelo.ValidadorTauler;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel on 14/12/15.
 */
public class VistaCrearHidatoManual extends DialogGeneric
{
    private GridBagLayout layout;
    private TaulerDisplayer taulerDisplayer;
    private JTextArea areaInstruccions;
    private Tauler t;
    private TaulerDisplayerCallbacks cMethods;

    public VistaCrearHidatoManual()
    {

    }

    public VistaCrearHidatoManual(Tauler t, TaulerDisplayerCallbacks cMethods)
    {
        super("Crear tauler manualment");
        this.t = t;
        this.cMethods = cMethods;

        afegirComponents();

        pack();
    }

    private void afegirComponents()
    {
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints c;
        Component toAdd;

        toAdd = taulerDisplayer = new TaulerDisplayer(); //ControladorVista.donaCallbacksCreacioManual()
        taulerDisplayer.setTauler(t);
        taulerDisplayer.setCallbackMethods(cMethods);
        taulerDisplayer.requestFocusInWindow();

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = areaInstruccions= new JTextArea("Instruccions:\n - Up,Left,Down,Right per moure's per la finestra\n - 0-9 per introduir numero.\n - X per introduir forat\n - Backspace per borrar");
        areaInstruccions.setEditable(false);
        areaInstruccions.setEnabled(false);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd, c);
    }

    @Override
    public void executaOk()
    {
        int resultatValidacio = ControladorVista.demanaValidaIGuarda();
        String missatge = "";
        switch (resultatValidacio)
        {
            case ValidadorTauler.OK:
            {
                missatge = "Hidato creat i guardat correctament!";
                break;
            }
            case ValidadorTauler.JARESOLT:
            {
                missatge = "L'Hidato que has donat ja estava completament resolt!";
                break;
            }
            case ValidadorTauler.MULTIPLES:
            {
                missatge = "L'Hidato no és admissible ja que té múltiples solucions";
                break;
            }
            case ValidadorTauler.NOBENPOSADES:
            {
                missatge = "Aquest Hidato conté números consecutius que no son adjacents";
                break;
            }
            case ValidadorTauler.NOMINMAX:
            {
                missatge = "Aquest Hidato no té el mínim i el màxim posats";
                break;
            }
            case ValidadorTauler.NOTESOL:
            {
                missatge = "Aquest Hidato no té solució";
                break;
            }
        }
        new NotificacioGenerica(missatge).mostra(true);
        if (resultatValidacio == ValidadorTauler.OK)
        {
            dispose();
        }
        else
        {
            taulerDisplayer.requestFocusInWindow();
        }
    }

    @Override
    public void executaKo()
    {
        super.executaKo();
    }
}
