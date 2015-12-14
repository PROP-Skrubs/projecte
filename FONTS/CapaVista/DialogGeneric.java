package CapaVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by daniel on 14/12/15.
 */
public class DialogGeneric
{
    private JFrame frame;
    protected JPanel mainPanel;
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
        frame.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c;
        Component toAdd;

        toAdd = mainPanel = new JPanel();
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx=0;
        c.gridy=0;
        frame.getContentPane().add(toAdd,c);

        toAdd = buttonOk = new JButton("Acceptar");
        c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=1;
        frame.getContentPane().add(toAdd,c);

        toAdd = buttonKo = new JButton("Cancelar");
        c = new GridBagConstraints();
        c.gridx=1;
        c.gridy=1;
        frame.getContentPane().add(toAdd,c);
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

    public void mostra(boolean b)
    {
        frame.setVisible(b);
    }

    protected void setDefaultCloseOperation(int op)
    {
        frame.setDefaultCloseOperation(op);
    }

    protected void pack()
    {
        frame.pack();
    }

    protected void dispose()
    {
        frame.dispose();
    }
}
