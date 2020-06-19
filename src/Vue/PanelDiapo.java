package Vue;

import Controleur.Controleur;
import Modele.Agenda;
import Modele.Evenement;
import Modele.Frise;
import javax.swing.*;
import java.util.Iterator;

public class PanelDiapo extends JPanel {

    //champs
    private JButton next;
    private JButton previous;
    private PanelEvenement panelEvenement;
    private PanelAffichage panelAffichage;
    private Frise frise;
    private Agenda agenda;
    private Iterator iterator;

    public PanelDiapo(Frise parFrise, PanelAffichage panelAffichage){
        this.panelAffichage = panelAffichage;
        frise = parFrise;
        this.agenda = frise.getAgenda();
        next = new JButton(">");
        previous = new JButton("<");
        iterator = agenda.getListEvenements().iterator();
        if(iterator.hasNext())
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