package Vue;

import javax.swing.*;
import java.awt.*;

public class PanelAide extends JPanel {

    private JLabel texte = new JLabel();
    private JLabel texte2 = new JLabel();
    private JLabel texte3 = new JLabel();
    private JLabel texte4 = new JLabel();
    private JLabel texte5 = new JLabel();
    private JLabel texte6 = new JLabel();
    private JLabel texte7 = new JLabel();


    public PanelAide() {
        this.setLayout(new GridLayout(10,10));
        this.setSize(new Dimension(1000,1000));
        this.setLocation(700,400);
        this.setVisible(true);
        this.setEnabled(true);
        texte.setText("Bienvenue dans notre application de création de frises !");
        texte2.setText("Grâce à cette application vous pourrez créer des frises et naviguer dans celles-ci !");
        texte3.setText("En appuyant sur Accueil vous pourrez changer de frises");
        texte4.setText("En appuyant sur Création vous pourrez soit créer une nouvelle frise soit ajouter un événement à la frise sélectionnée");
        texte5.setText("En appuyant sur Affichage vous pourrez naviguer entre les événéments grâce à la frise");
        texte6.setText("Enfin en appuyant sur Fermer vous pourrez fermer l'application");
        texte7.setText("Quittez ce menu en choisissant un onglet :)");
        this.add(texte);
        this.add(texte2);
        this.add(texte3);
        this.add(texte4);
        this.add(texte5);
        this.add(texte6);
        this.add(texte7);
    }
}
