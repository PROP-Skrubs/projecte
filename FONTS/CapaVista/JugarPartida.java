package CapaVista;

import CapaDomini.Controladors.ControladorPartida;
import CapaDomini.Algoritmes.Tauler;
import CapaDomini.Algoritmes.TaulerDisplayerCallbacks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by daniel on 16/11/15.
 */
public class JugarPartida
{
    private TaulerDisplayer taulerDisplayer1;
    private JPanel panel1;
    private JButton guardarPartidaButton;
    private JButton sortirButton;
    private JTextField contador;
    private Tauler t;
    private TaulerDisplayerCallbacks callbacks;
    int n = 0;
    int horas = 0;
    int min = 0;
    int seg = 0;

    public JugarPartida(Tauler taulerProgres, TaulerDisplayerCallbacks cMethods)
    {
        $$$setupUI$$$();

        final JFrame frame = new JFrame("JugarPartida");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        taulerDisplayer1.setTauler(taulerProgres);
        taulerDisplayer1.setCallbackMethods(cMethods);
        frame.pack();
        taulerDisplayer1.requestFocusInWindow();
        frame.setVisible(true);

        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                frame.toFront();
                frame.repaint();
            }
        });

        //    Timer
        int delay = 1000; //milliseconds
        n = 0;
        contador.setText("00:00:00");
        ActionListener taskPerformer = new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                n += 1;
                String count = conversion(n);
                contador.setText(count);
                if (n > 59) n = 0;
            }
        };
        new Timer(delay, taskPerformer).start();

        contador.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                ControladorPartida.guardarPartida();
                System.out.println("Partida guardada correctament!");
            }
        });

        guardarPartidaButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                ControladorPartida.guardarPartida();
                System.out.println("Partida guardada correctament!");
            }
        });

        sortirButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                ControladorPartida.descartaPartida();
                frame.dispose();
            }
        });
    }

    public void createUIComponents()
    {
        taulerDisplayer1 = new TaulerDisplayer();
    }

    public String conversion(int seg)
    {
        String segundos;
        String minutos;
        String hora;
        if (seg == 60)
        {
            ++min;
            seg = 0;
            if (min == 60)
            {
                ++horas;
                min = 0;
            }
        }
        if (seg < 10)
        {
            segundos = "0" + seg;
        }
        else
        {
            segundos = String.valueOf(seg);
        }
        if (min < 10)
        {
            minutos = "0" + min;
        }
        else
        {
            minutos = String.valueOf(min);
        }
        if (horas < 10)
        {
            hora = "0" + horas;
        }
        else
        {
            hora = String.valueOf(horas);
        }
        String r = hora + ":" + minutos + ":" + segundos;
        return r;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        createUIComponents();
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(taulerDisplayer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        sortirButton = new JButton();
        sortirButton.setText("Sortir");
        panel1.add(sortirButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        contador = new JTextField();
        contador.setText("");
        panel1.add(contador, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        guardarPartidaButton = new JButton();
        guardarPartidaButton.setText("Guardar Partida");
        panel1.add(guardarPartidaButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return panel1;
    }
}
