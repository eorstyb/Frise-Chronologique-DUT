package Vue;

import Controleur.Controleur;
import Modele.Agenda;
import Modele.Evenement;
import javax.swing.*;
import java.util.Iterator;

public class PanelDiapo extends JPanel {

    //champs
    private JButton next;
    private JButton previous;
    private PanelEvenement panelEvenement;
    private PanelAffichage panelAffichage;
    private Agenda agenda;
    private Iterator iterator;

    public PanelDiapo(Agenda agenda, PanelAffichage panelAffichage){
        this.panelAffichage = panelAffichage;
        this.agenda = agenda;
        next = new JButton(">");
        previous = new JButton("<");
        iterator = agenda.getListEvenements().iterator();
        panelEvenement = new PanelEvenement((Evenement) iterator.next());
    }

    public void enregistreEcouteur(Controleur controleur) {
        next.addActionListener(controleur);
        previous.addActionListener(controleur);
    }

    public PanelEvenement getPanelEvenement() {
        return panelEvenement;
    }
}