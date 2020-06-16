package Vue;

import Controleur.Controleur;
import Modele.Frise;
import com.sun.corba.se.impl.orbutil.closure.Constant;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class PanelFormulaire extends JPanel {
    //champs
    private JLabel titre = new JLabel("Ajout d'un événement");
    private JLabel nomEvenement = new JLabel("Nom de l'événement");
    private JTextField entreeNomEvenement = new JTextField(20);
    private JLabel description = new JLabel("Description de l'événement");
    private JTextArea entreeDescription = new JTextArea(5,30);
    private JLabel dateEvenement = new JLabel("Date de l'événement");
    private JComboBox<Integer> entreeJour = new JComboBox<Integer>();
    private JComboBox<String> entreeMois = new JComboBox<String>();
    private JComboBox<Integer> entreeAnnee = new JComboBox<Integer>();
    private JLabel poidsEvenement = new JLabel("Poids de l'événement (1 = très important, 10 = superficiel)");
    private JComboBox<Integer> entreePoids = new JComboBox<Integer>();
    private JLabel cheminImage = new JLabel("Chemin vers l'image de l'événement");
    private JTextField entreeCheminImage = new JTextField(20);
    private JButton valider = new JButton("Valider");
    private String[] MOIS = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
    private Frise frise;


    public PanelFormulaire(Frise parFrise) {
        frise = parFrise;
        setLayout(new GridBagLayout());
        GridBagConstraints contraintes = new GridBagConstraints();
        contraintes.insets = new Insets(30, 30, 30, 30);
        contraintes.anchor = 20;

        contraintes.gridx = 0;
        contraintes.gridy = 0;
        titre.setSize(new Dimension(300,300));
        this.add(titre, contraintes);

        contraintes.gridy += 4;
        this.add(nomEvenement, contraintes);

        contraintes.gridx += 2;
        this.add(entreeNomEvenement, contraintes);

        contraintes.gridx = 0;
        contraintes.gridy += 2;
        this.add(description, contraintes);

        contraintes.gridy -= 1;
        contraintes.gridx += 1;
        this.add(entreeDescription, contraintes);

        contraintes.gridx = 0;
        contraintes.gridy += 4;
        this.add(dateEvenement, contraintes);

        contraintes.gridx += 1;
        for(int i = 1; i < 32; i++)
            entreeJour.addItem(i);
        this.add(entreeJour, contraintes);

        contraintes.gridx += 1;
        for(int i = 0; i < 12; i++)
            entreeMois.addItem(MOIS[i]);
        this.add(entreeMois, contraintes);

        contraintes.gridx += 1;
        for(int i = frise.getDateDeDebut().getAnnee(); i < frise.getDateDeFin().getAnnee() + 1; i++)
            entreeAnnee.addItem(i);
        this.add(entreeAnnee, contraintes);

        contraintes.gridx = 0;
        contraintes.gridy += 4;
        this.add(poidsEvenement, contraintes);

        contraintes.gridx += 2;
        for(int i = 1; i < 11; i++)
            entreePoids.addItem(i);
        this.add(entreePoids, contraintes);

        contraintes.gridx = 0;
        contraintes.gridy += 4;
        this.add(cheminImage);

        contraintes.gridx += 1;
        this.add(entreeCheminImage, contraintes);

        contraintes.gridx = 10;
        contraintes.gridy += 4;
        this.add(valider, contraintes);
    }

    public void enregistreEcouteur(Controleur controleur) {
        this.valider.addActionListener(controleur);
    }

    public JButton getValider() {
        return valider;
    }

    public JTextField getEntreeNomEvenement() {
        return entreeNomEvenement;
    }

    public JTextArea getEntreeDescription() {
        return entreeDescription;
    }

    public JComboBox<Integer> getEntreeJour() {
        return entreeJour;
    }

    public JComboBox<String> getEntreeMois() {
        return entreeMois;
    }

    public JComboBox<Integer> getEntreeAnnee() {
        return entreeAnnee;
    }

    public JComboBox<Integer> getEntreePoids() {
        return entreePoids;
    }

    public JTextField getEntreeCheminImage() {
        return entreeCheminImage;
    }

}


/*    À l’aide d’un formulaire l’utilisateur saisit les données générales qui décrivent la chronologie (intitulé, dates,
        période, adresse du fichier de sauvegarde), puis les données particulières qui décrivent chaque événement :
        titre, date, adresse du fichier image, texte descriptif, poids (le poids de l’événement représente son importance
        dans la chronologie, il correspond dans la table à l’indice de la ligne à laquelle l’événement est affiché, plus
        un poids est élevé, plus l’indice de la ligne est bas, proche de l’en-tête).
*/