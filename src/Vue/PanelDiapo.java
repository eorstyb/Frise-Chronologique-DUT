/*package Vue;

import Controleur.Controleur;
import Modele.Agenda;
import Modele.Evenement;
import Modele.Frise;

import javax.swing.*;
import java.awt.*;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======
>>>>>>> 0a10ebc940f353230259a3713634f0144c0c20cc
import java.util.Iterator;
import java.util.ListIterator;

import static Vue.Constantes.INTITULE;

public class PanelDiapo extends JPanel implements ActionListener{

    //champs
    private JButton next;
    private JButton previous;
    private PanelEvenement panelEvenement;
    private PanelAffichage panelAffichage;
    private Agenda agenda;
    private JLabel titre;
<<<<<<< HEAD
    private ListIterator iterator;

    public PanelDiapo(Frise frise, PanelAffichage panelAffichage){
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);
        this.panelAffichage = panelAffichage;
        this.agenda = frise.getAgenda();

        String intituleFrise = frise.getIntituleFrise();
        titre = new JLabel(intituleFrise);
        titre.setFont(INTITULE);
=======
    private Iterator iterator;

    public PanelDiapo(Frise frise, PanelAffichage panelAffichage){
        this.setLayout(new BorderLayout());
        this.panelAffichage = panelAffichage;
        this.agenda = frise.getAgenda();

        String intitulé = frise.getIntituleFrise();
>>>>>>> 0a10ebc940f353230259a3713634f0144c0c20cc
        next = new JButton(">");
        previous = new JButton("<");
        next.addActionListener( this);
        previous.addActionListener(this);
        iterator = agenda.getListEvenements().listIterator();

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(titre,constraints);

        if(iterator.hasNext()) {
            panelEvenement = new PanelEvenement((Evenement) iterator.next());
<<<<<<< HEAD
            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.anchor = GridBagConstraints.LINE_START;
            this.add(panelEvenement, constraints);
        }

        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(previous,constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        this.add(next,constraints);
=======

        this.add(titre = new JLabel(intitulé));
        this.add(panelEvenement, BorderLayout.CENTER);
        this.add(next,BorderLayout.LINE_END);
        this.add(previous,BorderLayout.LINE_START);
>>>>>>> 0a10ebc940f353230259a3713634f0144c0c20cc
    }

    public void enregistreEcouteur(Controleur controleur) {
        next.addActionListener(controleur);
        previous.addActionListener(controleur);
    }

    public PanelEvenement getPanelEvenement() {
        return panelEvenement;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.next) {
            if(iterator.hasNext()) {
                panelEvenement = new PanelEvenement((Evenement) iterator.next());
            }
            else {
                iterator = agenda.getListEvenements().listIterator();
                if(iterator.hasNext())
                    panelEvenement = new PanelEvenement((Evenement) iterator.next());
            }
        }
        if(e.getSource() == this.previous) {
            if(iterator.hasPrevious()) {
                panelEvenement = new PanelEvenement((Evenement) iterator.previous());
            }
        }
    }
}
*/
package Vue;

import Controleur.Controleur;
import Modele.Agenda;
import Modele.Evenement;
import Modele.Frise;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import static Vue.Constantes.INTITULE;

public class PanelDiapo extends JPanel implements ActionListener {

    //champs
    private JButton next;
    private JButton previous;
    private PanelEvenement panelEvenement;
    private PanelAffichage panelAffichage;
    private Agenda agenda;
    private Evenement[] tabEvt = new Evenement[100];
    int i = 0;
    private JLabel titre;

    public PanelDiapo(Frise frise, PanelAffichage panelAffichage) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        this.panelAffichage = panelAffichage;
        this.agenda = frise.getAgenda();

        String intituleFrise = frise.getIntituleFrise();
        titre = new JLabel(intituleFrise);
        titre.setFont(INTITULE);

        next = new JButton(">");
        previous = new JButton("<");
        next.addActionListener(this);
        previous.addActionListener(this);
        Iterator iterator = agenda.getListEvenements().iterator();
        int j = 0;
        while (iterator.hasNext()) {
            tabEvt[j] = (Evenement) iterator.next();
            j++;
        }

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(titre, constraints);

        if (tabEvt[0] != null) {
            panelEvenement = new PanelEvenement(tabEvt[0]);
            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.anchor = GridBagConstraints.LINE_START;
            this.add(panelEvenement, constraints);
        }

        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(previous, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        this.add(next, constraints);
    }

    public void enregistreEcouteur(Controleur controleur) {
        next.addActionListener(controleur);
        previous.addActionListener(controleur);
    }

    public PanelEvenement getPanelEvenement() {
        return panelEvenement;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GridBagConstraints constraints = new GridBagConstraints();
        if (e.getSource() == this.next) {
            if (i + 1 < tabEvt.length && tabEvt[i + 1] != null) {
                this.remove(panelEvenement);
                panelEvenement = new PanelEvenement(tabEvt[i + 1]);
                constraints.gridx = 1;
                constraints.gridy = 1;
                constraints.anchor = GridBagConstraints.LINE_START;
                this.add(panelEvenement, constraints);
                validate();
                repaint();
                this.i += 1;
            } else {
                this.i = 0;
                if (tabEvt[i] != null) {
                    this.remove(panelEvenement);
                    panelEvenement = new PanelEvenement(tabEvt[i]);
                    constraints.gridx = 1;
                    constraints.gridy = 1;
                    constraints.anchor = GridBagConstraints.LINE_START;
                    this.add(panelEvenement, constraints);
                    validate();
                    repaint();
                }
            }
            if (e.getSource() == this.previous) {
                if (i > 0 && tabEvt[i - 1] != null) {
                    this.remove(panelEvenement);
                    panelEvenement = new PanelEvenement(tabEvt[i - 1]);
                    constraints.gridx = 1;
                    constraints.gridy = 1;
                    constraints.anchor = GridBagConstraints.LINE_START;
                    this.add(panelEvenement, constraints);
                    validate();
                    repaint();
                    i--;
                }
            }
        }
    }
}