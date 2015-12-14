package CapaVista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel on 14/12/15.
 */
public class VistaCrearTaulerManual extends VistaGenerica
{
    private GridBagLayout layout;
    private TaulerDisplayer taulerDisplayer;
    private JTextArea areaInstruccions;

    public VistaCrearTaulerManual()
    {
        super("Crear tauler manualment");

        afegirComponents();

        
    }


}
