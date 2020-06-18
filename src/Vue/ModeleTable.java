package Vue;

import Modele.Agenda;
import Modele.Date;
import Modele.Evenement;
import Modele.Frise;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;

public class ModeleTable extends DefaultTableModel {
    //champs
    //private Date EvenementDate;
    private String[] ColumnNames;
    private Frise frise;
    private Agenda agenda;
    private int COLUMN = 14;
    private final int ROW = 11;
    private PanelAffichage panelAffichage;
    private Date[] datesColonnes;

    //constructeu
    public ModeleTable(Frise parFrise, PanelAffichage panelAffichage){
        this.panelAffichage = panelAffichage;
        frise = parFrise;
        agenda = frise.getAgenda();

        Date debut = frise.getDateDeDebut();
        Date fin = frise.getDateDeFin();
        int i = 0;
        System.out.println(debut.toString());
        System.out.println(fin.toString());

        while (debut.compareTo(fin) != 0) {
            fin = fin.dateDeLaVeille();
            i++;
        }
        System.out.println("Fin while");
        int periode = i;
        periode = periode / COLUMN - 1;

        this.setColumnCount(COLUMN);
        this.setRowCount(ROW);

        ColumnNames = new String[COLUMN];
        datesColonnes = new Date[COLUMN];
        int j = 1;
        ColumnNames[0] = debut.toString();
        datesColonnes[0] = debut;
        for (int cpt = 0; cpt > -1; cpt++) {
            if (cpt == periode) {
                ColumnNames[j] = debut.toString();
                datesColonnes[j] = debut;
                j += 1;
                if (j == COLUMN - 1)
                    break;
                else
                    cpt = 0;
            }
            debut = debut.dateDuLendemain();
        }

        datesColonnes[COLUMN - 1] = frise.getDateDeFin();
        ColumnNames[COLUMN - 1] = frise.getDateDeFin().toString();
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
        System.out.println(datesColonnes.length);
        if (tabEvenements[0] != null) {
            for (Evenement evt : tabEvenements) {
                i = 1;
                while (i < COLUMN) {
                    if (evt.getDate().compareTo(datesColonnes[i - 1]) >= 0 && evt.getDate().compareTo(datesColonnes[i]) <= 0) {
                        this.setValueAt(evt, i, evt.getPoids());
                    }
                    i += 1;
                }
            }
        }
    }
}