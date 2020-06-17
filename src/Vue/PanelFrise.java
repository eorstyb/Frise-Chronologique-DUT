package Vue;

import Controleur.Controleur;
import Modele.Frise;

import javax.swing.*;
import java.awt.*;

public class PanelFrise extends JPanel {
    //champs
    private JTable tableFrise;
    private ModeleTable modele;

    //constructeur
    public PanelFrise(Frise frise,PanelAffichage panelAffichage) {

        modele = new ModeleTable(frise,panelAffichage);
        tableFrise = new JTable (modele);
        JScrollPane scrollPane= new JScrollPane(tableFrise ,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(500,310));
        tableFrise.getTableHeader().setResizingAllowed(false);
        tableFrise.getTableHeader().setReorderingAllowed(false);

    }

    //méthodes

    public void enregistreEcouteur(Controleur controleur) {

    }
}
