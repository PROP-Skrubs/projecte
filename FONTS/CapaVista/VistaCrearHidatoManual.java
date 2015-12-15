package CapaVista;

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

    public VistaCrearHidatoManual()
    {
        super("Crear tauler manualment");

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
        super.executaOk();
    }

    @Override
    public void executaKo()
    {
        super.executaKo();
    }
}
