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
    
}
    
 
    

