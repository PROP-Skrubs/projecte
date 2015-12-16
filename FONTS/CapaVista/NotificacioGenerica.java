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
    private JTextArea label;
    private JButton button;

    public NotificacioGenerica()
    {
        this("");
    }

    public NotificacioGenerica(String missatge)
    {
        frame = new JFrame("Notificació");
        frame.getContentPane().setLayout(new GridBagLayout());
        label = new JTextArea(missatge);
        label.setEnabled(false);
        label.setEditable(false);
        button = new JButton("D'acord!");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(label,c);
        c.gridy = 1;
        frame.getContentPane().add(button,c);
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
