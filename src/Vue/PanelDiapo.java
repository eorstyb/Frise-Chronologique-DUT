package Vue;

import Modele.Agenda;

import javax.swing.*;
import java.util.Iterator;

public class PanelDiapo extends JPanel {

    //champs
    private JButton next;
    private JButton previous;
    private PanelEvenement panelEvenement;

    PanelDiapo(Agenda agenda){
        next = new JButton(">");
        previous = new JButton("<");
        Iterator iterator = agenda.getEvenements().iterator();
        panelEvenement = new PanelEvenement();

    }
}
