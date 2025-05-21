package modele;


import java.util.*;




public class Machine  {
    
    
    
    private String ref;
    private String des;
    private String type;
    private float cout;
    private ArrayList<Evenement> listeEvenement;
    
    private float x;
    private float y;

    public Machine(String ref, String des, String type, float cout, float x, float y) {
        this.ref = ref;
        this.des = des;
        this.type = type;
        this.cout = cout;
        this.x = x;
        this.y = y;
        this.listeEvenement = new ArrayList<Evenement>();
    }
    
    
    
    //ajouter méthode getters/seter sur arraylist evenement
    
    

    
    
    
    
    public String getRef() {
        return ref;
    }

    public String getDes() {
        return des;
    }

    public String getType() {
        return type;
    }

    public float getCout() {
        return cout;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void addEvenement(Evenement e) {
        listeEvenement.add(e);
    }
    
    
    
    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    
    //Calcul de la fiabilité
     public double getFiabilite() {
        return 1.0 - ((double) listeEvenement.size() / 840.0);
    }

     
     //Obtenir les evenements de la machine
    public List<Evenement> getEvenements() {
        return listeEvenement;
    }
    
}
