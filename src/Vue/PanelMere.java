package Vue;

import Controleur.Controleur;
import Modele.Frise;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import static Vue.Constantes.*;

public class PanelMere extends JPanel implements ActionListener {
    //champs
    private PanelAccueil panelAccueil = new PanelAccueil();
    private PanelCreation panelCrea = new PanelCreation();
    private PanelAffichage panelAff = new PanelAffichage();
    private PanelAide panelAide = new PanelAide();
    private FenetreMere fenetreMere;
    private Controleur controleur;
    private JPopupMenu popupMenu = new JPopupMenu();
    private JLabel choix = new JLabel("Que voulez-vous faire ?");
    private JButton choix1 = new JButton("Charger une frise déjà existante");
    private JButton choix2 = new JButton("Créer une nouvelle frise");
    private Frise[] tabFrises = new Frise[20];
    private JButton[] tabBoutons = new JButton[20];
    private File fileFrise = new File("frise.ser");

    public PanelMere(FenetreMere parFenetreMere) throws IOException {
        this.setLayout(new CardLayout());
        this.setForeground(SOBRE);
        fenetreMere = parFenetreMere;


        initFrises();
        if(tabFrises[0] != null) {
            popupMenu.setSize(new Dimension(1000,1000));
            popupMenu.setLocation(700,400);
            choix1.addActionListener(this);
            choix2.addActionListener(this);
            popupMenu.add(choix);
            popupMenu.add(choix1);
            popupMenu.add(choix2);
            this.add(popupMenu);
        }
        else {
            controleur = new Controleur(panelCrea, panelAff, this);
            this.add("Accueil", panelAccueil);
            this.add("Création", panelCrea);
            this.add("Affichage", panelAff);
            validate();
            repaint();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(fenetreMere.getItemCreation())) {
            ((CardLayout) getLayout()).show(this, "Création");
            this.remove(panelAide);
            panelAide.setVisible(false);
            panelAide.setEnabled(false);
            validate();
            repaint();
        }

        if(e.getSource().equals(fenetreMere.getItemAffichage())) {
            ((CardLayout) getLayout()).show(this, "Affichage");
            this.remove(panelAide);
            panelAide.setVisible(false);
            panelAide.setEnabled(false);
            validate();
            repaint();
        }

        if(e.getSource().equals(fenetreMere.getItemAccueil())) {
            ((CardLayout) getLayout()).show(this, "Accueil");
            this.remove(panelAide);
            panelAide.setVisible(false);
            panelAide.setEnabled(false);
            validate();
            repaint();
        }

        if(e.getSource().equals(fenetreMere.getItemAide())) {
            panelAide.setSize(new Dimension(1000,1000));
            panelAide.setLocation(700,400);
            panelAide.setVisible(true);
            panelAide.setEnabled(true);
            JLabel texte = new JLabel("Bienvenue dans notre application de création de frises !");
            JLabel texte2 = new JLabel("Grâce à cette application vous pourrez créer des frises et naviguer dans celles-ci !");
            JLabel texte3 = new JLabel("En appuyant sur Accueil vous pourrez changer de frises");
            JLabel texte4 = new JLabel("En appuyant sur Création vous pourrez soit créer une nouvelle frise soit ajouter un événement à la frise sélectionnée");
            JLabel texte5 = new JLabel("En appuyant sur Affichage vous pourrez naviguer entre les événéments grâce à la frise");
            JLabel texte6 = new JLabel("Enfin en appuyant sur Fermer vous pourrez fermer l'application");
            JLabel texte7 = new JLabel("Quittez ce menu en choisissant un onglet :)");
            this.add(texte);
            this.add(texte2);
            this.add(texte3);
            this.add(texte4);
            this.add(texte5);
            this.add(texte6);
            this.add(texte7);
            this.add(panelAide);
            validate();
            repaint();
        }

        if(e.getSource().equals(fenetreMere.getItemFermer())) {
            int quitter = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter l'application ?", "Fermer", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (quitter == JOptionPane.OK_OPTION)
                fenetreMere.dispose();
        }

        if(e.getSource().equals(choix1)) {
            popupMenu.removeAll();
            JLabel label = new JLabel("Quelle frise voulez vous charger ?");
            popupMenu.add(label);
            popupMenu.validate();
            popupMenu.repaint();
            int i = 0;
            while(tabFrises[i] != null) {
                tabBoutons[i] = new JButton("Frise " + i + 1 + " : " + tabFrises[i].getIntituleFrise());
                tabBoutons[i].setSize(100,100);
                tabBoutons[i].addActionListener(this);
                popupMenu.add(tabBoutons[i]);
                i += 1;
            }
            popupMenu.validate();
            popupMenu.repaint();
            this.validate();
            this.repaint();
        }

        if(e.getSource().equals(choix2)) {
            controleur = new Controleur(panelCrea, panelAff, this);
            removeAll();
            popupMenu.setVisible(false);
            popupMenu.setEnabled(false);
            this.add("Accueil", panelAccueil);
            this.add("Création", panelCrea);
            this.add("Affichage", panelAff);
            repaint();
            validate();
        }

        for(int i = 0; i < tabBoutons.length; i++) {
            if(e.getSource().equals(tabBoutons[i])) {
                panelAff = new PanelAffichage(tabFrises[i]);
                panelCrea = new PanelCreation(tabFrises[i], controleur);
                panelAccueil = new PanelAccueil(tabFrises, controleur);
                controleur = new Controleur(tabFrises, tabFrises[i], panelCrea, panelAff, this);
                this.add("Accueil", panelAccueil);
                this.add("Création",panelCrea);
                this.add("Affichage",panelAff);
                this.remove(popupMenu);
                popupMenu.setVisible(false);
                popupMenu.setEnabled(false);
                validate();
                repaint();
            }
        }
    }

    public void initFrises() throws IOException {
        if (fileFrise.length() == 0) {
            try {
                fileFrise.createNewFile();
            } catch (IOException e) {
                System.err.println("Fichier inexistant et non créé");
            }
        }
        else {
            ObjectInputStream ob = null;
            try {
                FileInputStream fi = new FileInputStream(fileFrise);
                ob = new ObjectInputStream(fi);
                tabFrises = (Frise[]) ob.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            ob.close();
        }
    }

    public void setFrise(Frise parFrise) {
        panelAff = new PanelAffichage(parFrise);
        this.add("Affichage", panelAff);
        validate();
        repaint();
    }

    public PanelAffichage getPanelAff() {
        return panelAff;
    }
}