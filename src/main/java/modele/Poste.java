package modele;

import java.util.*;





public class Poste {
    
    private String ref;
    private String des;
    private ArrayList<Machine> listeMachines;   

    public Poste(String ref, String des, ArrayList<Machine> listeMachines) {
        this.ref = ref;
        this.des = des;
        this.listeMachines = listeMachines;
    }
    
    

    
    
    public String getRef() {
        return ref;
    }

    public String getDes() {
        return des;
    }

    public ArrayList<Machine> getListeMachines() {
        return listeMachines;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setListeMachines(ArrayList<Machine> listeMachines) {
        this.listeMachines = listeMachines;
    }
    
    
    
}
