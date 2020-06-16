package Modele;

import java.io.Serializable;

public class Frise implements Serializable {
    private Agenda agenda;
    private Date dateDeDebut;
    private Date dateDeFin;
    private String intituleFrise;
    private String cheminFichier;

    public Frise(Agenda parAgenda, Date parDateDeDebut, Date parDateDeFin, String parIntituleFrise, String parCheminFichier) {
        agenda = parAgenda;
        dateDeDebut = parDateDeDebut;
        dateDeFin = parDateDeFin;
        intituleFrise = parIntituleFrise;
        cheminFichier = parCheminFichier;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public Date getDateDeDebut() {
        return dateDeDebut;
    }

    public Date getDateDeFin() {
        return dateDeFin;
    }

    public String getCheminFichier() {
        return cheminFichier;
    }

    public String getIntituleFrise() {
        return intituleFrise;
    }
}
