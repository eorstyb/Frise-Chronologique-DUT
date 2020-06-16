package Vue;

import Modele.Agenda;
import Modele.Evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class PanelDiapo extends JPanel implements ActionListener {

    //champs
    private JButton next;
    private JButton previous;
    private PanelEvenement panelEvenement;
    private Agenda agenda;
    private Iterator iterator;

    public PanelDiapo(Agenda agenda){
        this.agenda = agenda;
        next = new JButton(">");
        previous = new JButton("<");
        iterator = agenda.getListEvenements().iterator();
        panelEvenement = new PanelEvenement((Evenement) iterator.next());
        next.addActionListener(this);
        previous.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == next) {
            if(iterator.hasNext())
                panelEvenement = new PanelEvenement((Evenement) iterator.next());
            else {
                iterator = agenda.getListEvenements().iterator();
                panelEvenement = new PanelEvenement((Evenement) iterator.next());
            }
        }
    }
}
