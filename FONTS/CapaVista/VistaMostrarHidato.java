package CapaVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by daniel on 14/12/15.
 */
public class VistaMostrarHidato extends VistaGenerica
{
    private GridBagLayout layout;
    private TaulerDisplayer taulerDisplayer;
    private JButton boto;
    private int idHidato;

    public VistaMostrarHidato()
    {
        System.err.println("Aixo no s'hauria de cridar");
    }

    public VistaMostrarHidato(int idHidato)
    {
        super("Crear tauler manualment");

        this.idHidato = idHidato;

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

        toAdd = taulerDisplayer = new TaulerDisplayer(); //ControladorVista.donaCallbacksCreacioManual()
        taulerDisplayer.setTauler(ControladorVista.demanaTaulerDeHidato(idHidato));
        taulerDisplayer.setCallbackMethods(ControladorVista.donaCallbacksPerDefecte());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(toAdd, c);

        toAdd = boto = new JButton("D'acord!");
        toAdd.requestFocusInWindow();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(toAdd, c);
    }

    private void afegirActionListeners()
    {
        boto.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                dispose();
            }
        });
    }

}
