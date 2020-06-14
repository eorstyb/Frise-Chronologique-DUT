package Modele;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Set;

/**
 * <b> La classe Agenda sert � construire l'objet Agenda</b>
 */
public class Agenda {
    /**
     * Une liste dans laquelle on ajoute les evenements de l'agenda et sert pour compter
     * le nombre d'evenements.
     *
     * @see Agenda#compteNbEvt(Date)
     */
    private ArrayList<Evenement> listeEvts;
    /**
     * un TreeSet dans lequel on ajoute des evenements tri�s.
     */
    private TreeSet<Evenement> arbreEvts;
    /**
     * Une Hashmap dans lequel on ajoute des evenements.
     *
     * @see Agenda#getHashMapEvts()
     */
    private HashMap<Integer, TreeSet<Evenement>> hashMapEvts;


    /**
     * <b>Constructeur de la classe Agenda</b>
     */
    public Agenda() {

        listeEvts = new ArrayList<>();
        arbreEvts = new TreeSet<>();
        hashMapEvts = new HashMap<>();
    }

    /**
     * Cette fonction ajoute un evenement dans l'agenda
     *
     * @param parEvt l'�venement ajout�
     */
    public void ajout(Evenement parEvt) {

        // Ajout dans la ArrayList
        listeEvts.add(parEvt);
        // Ajout dans le TreeSet
        arbreEvts.add(parEvt);

        // Ajout dans la HashMap :
        // clef : le numero de semaine
        // valeur : les �v�nements qui ont lieu cette semaine
        // nous servira en IHM pour afficher l'agenda semaine par semaine

        Date date = parEvt.getDate();
        GregorianCalendar calendar = new GregorianCalendar(date.getAnnee(),
                date.getMois() - 1, date.getJour());
        int numeroDeSemaine = calendar.get(Calendar.WEEK_OF_YEAR);


        if (hashMapEvts.containsKey(numeroDeSemaine)) {
            hashMapEvts.get(numeroDeSemaine).add(parEvt);
        } else {
            TreeSet<Evenement> liste = new TreeSet<Evenement>();
            liste.add(parEvt);
            getHashMapEvts().put(numeroDeSemaine, liste);
        }
    }


    /**
     * parcours de la hashmap avec un iterateur sur l'ensemble des clefs
     *
     * @return une chaine de caract�re
     */


    @Override
    public String toString() {
        String chaine = "\n" + listeEvts + "\n" + arbreEvts + "\n\n";

        Set<Integer> clefs = getHashMapEvts().keySet();
        Iterator<Integer> iterateur = clefs.iterator();
        while (iterateur.hasNext()) {
            Integer clef = iterateur.next();
            TreeSet<Evenement> liste = getHashMapEvts().get(clef);
            chaine += clef + " : " + liste + "\n";
        }
        return chaine;


    }


    /**
     * compte le nombre d'évenements de l'agenda
     * qui ont lieu à la date parDate
     *
     * @param parDate la date choisie
     * @return nb d'evenement
     */
    public int compteNbEvt(Date parDate) {
        int nbEvt = 0;
        Iterator<Evenement> iterateur = arbreEvts.iterator();
        while (iterateur.hasNext()) {
            Evenement evt = iterateur.next();
            if (evt.getDate().compareTo(parDate) == 0)
                nbEvt++;
        }  // while
        return nbEvt;
    } // compteNbEvt

    /**
     * compte le nombre d'�v�nements de l'agenda
     *   dont le titre contient la cha�ne de caracat�res parString
     * @param parString une chaine de caract�re
     * @return nb d'evenement
     */
    /*public int compteNbEvt (String parString) {
        int nbEvt = 0;
        for (Evenement evt : listeEvts) {
            if (evt.getNom().contains (parString)) {
                nbEvt++;
            }
        }
        return nbEvt;
    } // compteNbEvt
  */
  /* // � tester
  public void triFusion (){
	 // listeEvts =
			  triFusion (listeEvts, 0,listeEvts.size());

  }*/

 /* public ArrayList <Evenement>  triFusion (ArrayList <Evenement>  list, int indiceDebut, int longueur) {
	if (longueur == 1){

		 ArrayList <Evenement> arrayList =new ArrayList <Evenement> ();
		 arrayList.add(list.get(indiceDebut));
		 return arrayList;

	}
	else
			return fusion (triFusion(list,indiceDebut ,longueur/2),
			        triFusion (list, indiceDebut + longueur/2, longueur-longueur/2)
					);


  }

  public ArrayList <Evenement> fusion (ArrayList <Evenement> liste1, ArrayList <Evenement> liste2){
  	if (liste1.isEmpty()) {
               return liste2;
	}
    if (liste2.isEmpty()) {
               return liste1;
	}
	ArrayList <Evenement> arrayList =new ArrayList <Evenement> ();
	Evenement premierDeListe1 = liste1.get(0);
	Evenement premierDeListe2 = liste2.get(0);
    if (premierDeListe1.compareTo(premierDeListe2) <= 0) {
			liste1.remove(0);
            arrayList = fusion(liste1,liste2);
			arrayList.add(0,premierDeListe1);

	}
	else {  liste2.remove(0);
            arrayList = fusion(liste1,liste2);
			arrayList.add(0,premierDeListe2);

			}
	return arrayList;
    }*/

    /**
     * permet l'acc�s � la hashMap d'evenements
     *
     * @return la Hashmap qui contient les evenements
     */
    public HashMap<Integer, TreeSet<Evenement>> getHashMapEvts() {
        return hashMapEvts;
    }

    /**
     * permet de modifier la hasmapevt
     *
     * @param hashMapEvts la Hashmap courante
     */
    public void setHashMapEvts(HashMap<Integer, TreeSet<Evenement>> hashMapEvts) {
        this.hashMapEvts = hashMapEvts;
    }

    /**
     * permet l'acc�s au Treeset d'evenements
     *
     * @return arbreEvts
     */
    public TreeSet<Evenement> getEvenements() {
        return arbreEvts;
    }

    /**
     * permet d'obtenir un TreeSet d'evenements selon le num�ro de semaine
     * @param numSemaine le num�ro de semaine s�lectionn�e
     * @return hashMap d'evenenemnt
     */
}
/**
 * @author Antoine Chaud
 */
