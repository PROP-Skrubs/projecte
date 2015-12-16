package CapaVista;

import CapaDomini.Algoritmes.Casella;

import javax.swing.*;
import java.awt.*;

/**
 * Aquesta classe conté CasellaLabel i totes les seves funcionalitats
 */
public class CasellaLabel extends JLabel
{
    private Casella continguts;
    private static final Color ACTIVE_COLOR = Color.YELLOW;
    private static final Color PASSIVE_COLOR = Color.BLUE;

    /**Crea una CasellaLabel buida
     */
    public CasellaLabel()
    {
        super();
        continguts = new Casella();
        setOpaque(true);
        setMinimumSize(new Dimension(40,40));
        setHorizontalAlignment(SwingConstants.CENTER);
        setHighlight(false);
    }
    /**
     * Crea una CasellaLabel igual a la passada per paràmetres
     * @param c
     */
    public CasellaLabel(Casella c)
    {
        super();
        continguts = new Casella(c);
        setCasellaElem(c.elem);
        setOpaque(true);
        setMinimumSize(new Dimension(40,40));
        setHorizontalAlignment(SwingConstants.CENTER);
        setHighlight(false);
    }

    /**
     *
     * @return Retorna el valor X de la Casella
     */
    public int getCasellaX()
    {
        return continguts.getX();
    }

    /**
     *
     * @return Retorna el valor Y de la Casella
     */
    public int getCasellaY()
    {
        return continguts.getY();
    }

    /**
     *
     * @return Retorna el valor de l'element de la Casella
     */
    public int getCasellaElem()
    {
        return continguts.getElem();
    }

    /**
     * Modifica l'element de la Casella amb el valor passat per parametre
     * @param elem
     */
    public void setCasellaElem(int elem)
    {
        continguts.setElem(elem);
        String text;
        if (elem == Casella.BUIT)
            text = " ";
        else if (elem == Casella.FORAT)
            text = "X";
        else
            text = Integer.toString(elem);
        setText(text);
    }

    /**
     * Modifica el color de la Casella
     * @param b
     */
    public void setHighlight(boolean b)
    {
        Color toSet = b ? ACTIVE_COLOR : PASSIVE_COLOR;
        setBackground(toSet);
    }
}
