package CapaVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by daniel on 15/12/15.
 */
public class NotificacioGenerica extends VistaComu
{
    private JLabel label;
    private JButton button;

    public NotificacioGenerica()
    {
        this("");
    }

    public NotificacioGenerica(String missatge)
    {
        frame = new JFrame("Notificació");
        frame.getContentPane().setLayout(new GridLayout(2,1));
        label = new JLabel(missatge);
        button = new JButton("D'acord!");
        frame.getContentPane().add(label);
        frame.getContentPane().add(button);
        button.requestFocusInWindow();

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                frame.dispose();
            }
        });

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        mostra(true);
    }
}
