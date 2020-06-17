package Vue;

import Controleur.Controleur;
import Modele.Frise;
import Modele.LectureEcriture;
import com.sun.org.apache.xml.internal.utils.SystemIDResolver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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
            panelCrea = new PanelCreation();
            controleur = new Controleur(panelCrea, panelAff);
            this.add("Accueil", panelAccueil);
            this.add("Création", panelCrea);
            this.add("Affichage", panelAff);
            this.add("Aide", panelAide);
            validate();
            repaint();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(fenetreMere.getItemCreation()))
            ((CardLayout) getLayout()).show(this,"Création");

        if(e.getSource().equals(fenetreMere.getItemAffichage()))
            ((CardLayout) getLayout()).show(this,"Affichage");

        if(e.getSource().equals(fenetreMere.getItemAccueil()))
            ((CardLayout) getLayout()).show(this, "Accueil");

        if(e.getSource().equals(fenetreMere.getItemAide()))
            ((CardLayout) getLayout()).show(this, "Aide");

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
            removeAll();
            popupMenu.setVisible(false);
            popupMenu.setEnabled(false);
            this.add("Accueil", panelAccueil);
            this.add("Création", panelCrea);
            this.add("Affichage", panelAff);
            this.add("Aide", panelAide);
            repaint();
            validate();
        }

        for(int i = 0; i < tabBoutons.length; i++) {
            if(e.getSource().equals(tabBoutons[i])) {
                panelAff = new PanelAffichage(tabFrises[i]);
                panelCrea = new PanelCreation(tabFrises[i], controleur);
                panelAccueil = new PanelAccueil(tabFrises, controleur);
                controleur = new Controleur(tabFrises, tabFrises[i], panelCrea, panelAff);
                this.add("Accueil", panelAccueil);
                this.add("Création",panelCrea);
                this.add("Affichage",panelAff);
                this.add("Aide", panelAide);
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
}