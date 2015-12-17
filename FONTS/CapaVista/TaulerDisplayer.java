package CapaVista;

import CapaDomini.Modelo.Casella;
import CapaDomini.Modelo.Tauler;
import CapaDomini.Modelo.TaulerDisplayerCallbacks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Es la classe que et permet veure e interactuar amb l'Hidato
 * @author Dani Armengod
 */
public class TaulerDisplayer extends JPanel
{
    /**
     * todo:
     * implementar espacios entre casillas
     * resuleto GridLayout.set{H,V}gap(int);
     * implementar highlighting
     * resuelto JLabel.setForeground(Color.XXX | null)
     * implementar click-edit
     */
    private CasellaLabel[][] numerosAlTauler;
    protected Casella focus;
    private Casella oldFocus;
    private int valorAnticCasella;
    private boolean modificantCasella;
    private int numeroInputBuffer = 0;
    private TaulerDisplayerCallbacks callbackMethods;

    /**
     * Modifica el TaulerDisplayerCallbacks amb el valor passat per parametre
     * @param c
     */
    public void setCallbackMethods(TaulerDisplayerCallbacks c)
    {
        this.callbackMethods = c;
    }

    /**
     * Crea un tauler igual al Tauler passat per paràmetre
     * @param t
     */
    public void setTauler(Tauler t)
    {
        int tamany = t.getTamany();
        GridLayout g = new GridLayout(tamany, tamany);
        setLayout(g);
        numerosAlTauler = new CasellaLabel[tamany][tamany];
        for (int i = 0; i < tamany; ++i)
        {
            for (int j = 0; j < tamany; ++j)
            {
                numerosAlTauler[i][j] = new CasellaLabel(t.getCasella(i,j));
                numerosAlTauler[i][j].setFont(numerosAlTauler[i][j].getFont().deriveFont(32.0f));
                add(numerosAlTauler[i][j]);
            }
        }
        focus = new Casella(tamany / 2, tamany / 2);
        oldFocus = focus;
        setHighlightOnFocus();
        g.setHgap(5);
        g.setVgap(5);
    }

    /**
     * Permet interactuar amb el tauler i modificar els valors amb les fletxes del teclat i l'enter
     */
    public TaulerDisplayer()
    {
        modificantCasella = false;
        setFocusable(true);
        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent keyEvent)
            {
                char caracterIntroduit = keyEvent.getKeyChar();
                if ('0' <= caracterIntroduit && caracterIntroduit <= '9')
                {
                    if (!modificantCasella)
                    {
                        modificantCasella = true;
                        valorAnticCasella = focus.getElem();
                    }
                    numeroInputBuffer *= 10;
                    numeroInputBuffer += caracterIntroduit - '0';
                    focus.setElem(numeroInputBuffer);
                    setCasella(focus);
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent)
            {
                Casella casellaASumar = null;
                Casella aModificar = null;
                if (modificantCasella) { focus.setElem(valorAnticCasella); setCasella(focus); modificantCasella = false; }
                switch (keyEvent.getKeyCode())
                {
                    case KeyEvent.VK_LEFT:
                        casellaASumar = new Casella(0, -1);
                        break;
                    case KeyEvent.VK_RIGHT:
                        casellaASumar = new Casella(0, 1);
                        break;
                    case KeyEvent.VK_UP:
                        casellaASumar = new Casella(-1, 0);
                        break;
                    case KeyEvent.VK_DOWN:
                        casellaASumar = new Casella(1,0);
                        break;
                    case KeyEvent.VK_SHIFT:
                    case KeyEvent.VK_ENTER:
                        aModificar = new Casella(focus);
                        aModificar.setElem(numeroInputBuffer);
                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        aModificar = new Casella(focus);
                        aModificar.setElem(Casella.BUIT);
                        break;
                    case KeyEvent.VK_X:
                        aModificar = new Casella(focus);
                        aModificar.setElem(Casella.FORAT);
                        break;
                }
                if (casellaASumar != null)
                {
                    numeroInputBuffer = 0;
                    focus = focus.sumaAmbCheck(casellaASumar, 0, getTamany() - 1);
                    focus.setElem(numerosAlTauler[focus.x][focus.y].getCasellaElem());
                    setHighlightOnFocus();
                }
                if (aModificar != null)
                {
                    numeroInputBuffer = 0;
                    if (callbackMethods.casellaModificada(aModificar))
                    {
                        focus = aModificar;
                        setCasella(focus);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent)
            {

            }
        });
    }

    /**
     * Modifica el color mostrat a la vista
     */
    public void setHighlightOnFocus()
    {
        numerosAlTauler[oldFocus.x][oldFocus.y].setHighlight(false);
        numerosAlTauler[focus.x][focus.y].setHighlight(true);
        oldFocus = focus;
    }

    public void setHighlightOn(Casella c, boolean on)
    {
        numerosAlTauler[c.x][c.y].setHighlight(on);
    }

    /**
     *
     * @return Retorna el tamany del Tauler
     */
    public int getTamany()
    {
        return numerosAlTauler.length;
    }

    /**
     * Modifica el TaulerDisplaer ficant una Casella amb el valor de l'element de la casella pasada per paràmetre
     * @param c
     */
    public void setCasella(Casella c)
    {
        numerosAlTauler[c.x][c.y].setCasellaElem(c.elem);
    }

//    public static void main(String[] args)
//    {
//        JFrame f = new JFrame();
//        TaulerDisplayer t = new TaulerDisplayer(10);
//        f.setContentPane(t);
//        for (int i = 0; i < 10; ++i)
//            for (int j = 0; j < 10; ++j)
//                t.setCasella(new Casella(i, j, i + 1));
//        f.pack();
//        f.setVisible(true);
//    }

}
