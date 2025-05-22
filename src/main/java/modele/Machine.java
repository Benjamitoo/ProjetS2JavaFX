package modele;


import java.util.*;




public class Machine extends Equipement {
    
    
    
    private String des;
    private String type;
    private float cout;
    private ArrayList<Evenement> listeEvenement;
    
    private float x;
    private float y;

    public Machine(String id, String ref, String des, String type, float cout, float x, float y) {
        super(id, ref);
        this.des = des;
        this.type = type;
        this.cout = cout;
        this.x = x;
        this.y = y;
        this.listeEvenement = new ArrayList<Evenement>();
    }
}