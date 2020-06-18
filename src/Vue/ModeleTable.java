package Vue;

import Modele.Agenda;
import Modele.Date;
import Modele.Evenement;
import Modele.Frise;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;

public class ModeleTable extends DefaultTableModel {
    private String[] ColumnNames;
    private Frise frise;
    private Agenda agenda;
    private int COLUMN = 16;
    private final int ROW = 11;
    private PanelAffichage panelAffichage;
    private Date[] datesColonnes;

    //constructeur
    public ModeleTable(Frise parFrise, PanelAffichage panelAffichage) {
        this.panelAffichage = panelAffichage;
        frise = parFrise;
        agenda = frise.getAgenda();

        Date debut = frise.getDateDeDebut();
        Date fin = frise.getDateDeFin();
        int i = 0;

        while (debut.compareTo(fin) != 0) {
            fin = fin.dateDeLaVeille();
            i++;
        }
        int periode = i;
        System.out.println(periode);
        periode = periode / COLUMN;

        this.setColumnCount(COLUMN + 1);
        this.setRowCount(ROW);

        ColumnNames = new String[COLUMN + 1];
        datesColonnes = new Date[COLUMN + 1];
        int j = 1;
        ColumnNames[0] = debut.toString();
        datesColonnes[0] = debut;
        for (int cpt = 0; cpt > -1; cpt++) {
            if (cpt == periode) {
                ColumnNames[j] = debut.toString();
                datesColonnes[j] = debut;
                j += 1;
                if (j == COLUMN)
                    break;
                else
                    cpt = 0;
            }
            debut = debut.dateDuLendemain();
        }

        datesColonnes[COLUMN] = frise.getDateDeFin();
        ColumnNames[COLUMN] = frise.getDateDeFin().toString();
        for (Date s : datesColonnes)
            System.out.println(s.toString());
        System.out.println("Fin");
        this.setColumnIdentifiers(ColumnNames);
        setFrise(frise);
    }

    public void setFrise(Frise parFrise) {
        this.frise = parFrise;
        this.agenda = frise.getAgenda();
        Evenement[] tabEvenements = new Evenement[100];
        ArrayList<Evenement> arrayEvt = agenda.getListEvenements();
        arrayEvt.sort(Evenement::compareTo);
        Iterator iterator = arrayEvt.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            tabEvenements[i] = (Evenement) iterator.next();
            i++;
        }
        int j = 0;
        while (tabEvenements[j] != null) {
            i = 1;
            while (i < COLUMN) {
                System.out.println(tabEvenements[j].getDate().toString());
                System.out.println(datesColonnes[i].toString());
                if (tabEvenements[j].getDate().compareTo(datesColonnes[i - 1]) >= 0 && tabEvenements[j].getDate().compareTo(datesColonnes[i]) <= 0) {
                    this.setValueAt(tabEvenements[j], tabEvenements[j].getPoids(), i);
                }
                i += 1;
            }
            j += 1;
        }
    }
}