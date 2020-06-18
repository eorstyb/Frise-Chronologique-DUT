package Vue;

import Controleur.Controleur;
import Modele.Agenda;
import Modele.Evenement;
import Modele.Frise;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class PanelDiapo extends JPanel {

    //champs
    private JButton next;
    private JButton previous;
    private PanelEvenement panelEvenement;
    private PanelAffichage panelAffichage;
    private Agenda agenda;
    private JLabel titre;
    private Iterator iterator;

    public PanelDiapo(Frise frise, PanelAffichage panelAffichage){
        this.setLayout(new BorderLayout());
        this.panelAffichage = panelAffichage;
        this.agenda = frise.getAgenda();

        String intitulé = frise.getIntituleFrise();
        next = new JButton(">");
        previous = new JButton("<");
        iterator = agenda.getListEvenements().iterator();
        if(iterator.hasNext())
            panelEvenement = new PanelEvenement((Evenement) iterator.next());

        this.add(titre = new JLabel(intitulé));
        this.add(panelEvenement, BorderLayout.CENTER);
        this.add(next,BorderLayout.LINE_END);
        this.add(previous,BorderLayout.LINE_START);
    }

    public void enregistreEcouteur(Controleur controleur) {
        next.addActionListener(controleur);
        previous.addActionListener(controleur);
    }

    public PanelEvenement getPanelEvenement() {
        return panelEvenement;
    }
}