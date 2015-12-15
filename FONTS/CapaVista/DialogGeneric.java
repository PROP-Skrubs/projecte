package CapaVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by daniel on 14/12/15.
 */
public class DialogGeneric extends VistaComu
{
    private JPanel topPanel;
    private GridBagLayout layoutTop;
    protected JPanel mainPanel;
    private JPanel panelBotons;
    private FlowLayout layoutBotons;
    private JButton buttonKo;
    private JButton buttonOk;

    public DialogGeneric()
    {
        this("Dialog generic");
    }

    public DialogGeneric(String titolDialog)
    {
        frame = new JFrame(titolDialog);

        afegirComponents();
        afegirActionListeners();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
    }

    private void afegirComponents()
    {
        topPanel = new JPanel();
        panelBotons = new JPanel();
        layoutTop = new GridBagLayout();
        layoutBotons = new FlowLayout(FlowLayout.RIGHT);
        topPanel.setLayout(layoutTop);
        panelBotons.setLayout(layoutBotons);

        GridBagConstraints c;
        Component toAdd;

        toAdd = mainPanel = new JPanel();
        c = new GridBagConstraints();
        c.fill= GridBagConstraints.BOTH;
        c.gridx=0;
        c.gridy=0;
        topPanel.add(toAdd, c);

        toAdd = panelBotons;
        c = new GridBagConstraints();
        c.gridx=0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        topPanel.add(toAdd, c);


        toAdd = buttonOk = new JButton("Acceptar");
        panelBotons.add(toAdd, c);

        toAdd = buttonKo = new JButton("Cancelar");
        panelBotons.add(toAdd,c);


        frame.setContentPane(topPanel);
    }

    private void afegirActionListeners()
    {
        buttonOk.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                executaOk();
            }
        });

        buttonKo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                executaKo();
            }
        });
    }

    public void executaOk()
    {
        throw new RuntimeException("Accio OK per defecte no reimplementada!");
    }

    public void executaKo()
    {
        //simulem que l'usuari ha clicat la creueta de tancar finestra
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
