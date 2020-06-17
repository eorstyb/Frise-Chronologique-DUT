package Vue;

import Modele.Agenda;
import Modele.Date;
import Modele.Evenement;
import Modele.Frise;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.Iterator;
import java.util.TreeSet;

public class ModeleTable extends DefaultTableModel {
    //champs
    //private Date EvenementDate;
    private String[] ColumnNames;
    private Frise frise;
    private int COLUMN = 14;
    private final int ROW = 11;
    private PanelAffichage panelAffichage;

    //constructeur
    public ModeleTable(Frise parFrise, PanelAffichage panelAffichage){
        this.panelAffichage = panelAffichage;
        frise = parFrise;

        Date date1 = new Date(16,06,2020);
        Date date2 = new Date(16,11,2020);
        Date debut = date1;
        Date fin = date2;

        int i = 0;

        while (debut.compareTo(fin) != 0){
           fin = fin.dateDeLaVeille();
           i++;
        }

        int periode = i;
        periode = periode/COLUMN;

        this.setColumnCount(COLUMN);
        this.setRowCount(ROW);

        ColumnNames = new String[COLUMN + 1];
        int j = 1;
        ColumnNames[0] = debut.toString();
        for(int cpt = 0; cpt > -1; cpt++){
            if(cpt == periode) {
                ColumnNames[j] = debut.toString();
                j += 1;
                if(j == COLUMN -  1)
                    break;
                else
                    cpt = 0;
            }
            debut = debut.dateDuLendemain();
        }

        for(String s : ColumnNames)
            System.out.println(s);
        System.out.println("Fin");
        this.setColumnIdentifiers(ColumnNames);

        //EvenementDate = panelAffichage.getPanelDiapo().getPanelEvenement().getEvenementDate();
    }
}