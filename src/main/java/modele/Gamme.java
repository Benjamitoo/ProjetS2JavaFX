package modele;

import java.util.*;





public class Gamme {
    private String ref;
    private LinkedList<Operation> protocole;
    private ArrayList<Equipement> materiel;
    
    public Gamme(String ref){
        this.ref = ref;
        this.protocole = new LinkedList<Operation>();
        this.materiel = new ArrayList<Equipement>();
        
    }

    public Gamme(String ref, LinkedList<Operation> protocole, ArrayList<Equipement> materiel) {
        this.ref = ref;
        this.protocole = protocole;
        this.materiel = materiel;
    }
    
    public String affiche(){
        String s = "";
        Iterator i = this.protocole.iterator();
        while(i.hasNext()){
            s = s + i.next() + " -> "; 
        }
        return s;
    }
    
    
    
    public String getRef() {
        return ref;
    }

    public LinkedList<Operation> getProtocole() {
        return protocole;
    }

    public ArrayList<Equipement> getMateriel() {
        return materiel;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setProtocole(LinkedList<Operation> protocole) {
        this.protocole = protocole;
    }

    public void setMateriel(ArrayList<Equipement> materiel) {
        this.materiel = materiel;
    }

    
    
    
    
}
