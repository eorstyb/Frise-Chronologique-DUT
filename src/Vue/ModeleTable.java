package Vue;

import Modele.Agenda;
import Modele.Date;
import Modele.Evenement;
import Modele.Frise;
import javax.swing.table.DefaultTableModel;

public class ModeleTable extends DefaultTableModel {
    //champs
    private Date EvenementDate;
    private int COLUMN;
    private final int ROW = 4;

    //constructeur
    public ModeleTable(Frise frise, PanelAffichage panelAffichage){

        Date debut = frise.getDateDeDebut();
        Date fin = frise.getDateDeFin();
        int i = 0;

        while (debut.compareTo(fin) != 0){
           fin = fin.dateDeLaVeille();
           i++;
        }




        setColumnCount(COLUMN);
        setRowCount(ROW);
        //EvenementDate = panelAffichage.getPanelDiapo().getPanelEvenement().getEvenementDate();


    }
    
}
