package CapaVista;

import CapaDomini.Modelo.Ranking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 16/12/15.
 */
public class VistaMostraRanquing extends VistaGenerica
{
    GridLayout layout;
    List<JLabel> jLabels;
    List<Ranking> rankings;

    public VistaMostraRanquing(List<Ranking> l)
    {
        super("Ranquings");

        rankings = l;

        afegirComponents();

        pack();
    }

    private void afegirComponents()
    {
        layout = new GridLayout(11,1);
        mainPanel.setLayout(layout);
        jLabels = new ArrayList<>(10);
        int i = 0;
        for (Ranking r : rankings)
        {
            if (i>=10) break;
            jLabels.add(new JLabel(r.getnomUsuari() + " : " + Integer.toString(r.getTemps()) + " segons"));
            mainPanel.add(jLabels.get(i));
            ++i;
        }
        while (i<10)
        {
            jLabels.add(new JLabel("----------------------"));
            mainPanel.add(jLabels.get(i));
            ++i;
        }
        JButton b = new JButton("Tancar");
        mainPanel.add(b);
        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                dispose();
            }
        });

    }
}
