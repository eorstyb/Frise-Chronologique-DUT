package Vue;

import javax.swing.*;
import java.util.Calendar;

public class PanelFormulaire extends JPanel {
    //champs
    JLabel nomEvenement = new JLabel("Nom de l'événement");
    JTextField entreeNomEvenement = new JTextField(20);
    JLabel dateEvenement = new JLabel("Date de l'événement");
    JTextField entreeJour;

    public PanelFormulaire() {

    }
}


/*    À l’aide d’un formulaire l’utilisateur saisit les données générales qui décrivent la chronologie (intitulé, dates,
        période, adresse du fichier de sauvegarde), puis les données particulières qui décrivent chaque événement :
        titre, date, adresse du fichier image, texte descriptif, poids (le poids de l’événement représente son importance
        dans la chronologie, il correspond dans la table à l’indice de la ligne à laquelle l’événement est affiché, plus
        un poids est élevé, plus l’indice de la ligne est bas, proche de l’en-tête).
*/